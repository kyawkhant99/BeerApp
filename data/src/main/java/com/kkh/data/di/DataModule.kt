package com.kkh.data.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.kkh.data.api.BeerApi
import com.kkh.data.datasource.local.BeerLocalDataSource
import com.kkh.data.datasource.local.BeerLocalDataSourceImpl
import com.kkh.data.datasource.local.db.BeerDatabase
import com.kkh.data.datasource.local.db.dao.BeerDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@OptIn(ExperimentalPagingApi::class)
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context: Context): BeerDatabase {
        return Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            "beers.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideBeerDao( db: BeerDatabase): BeerDao {
        return db.dao
    }


    @Provides
    @Singleton
    fun provideOkhttp(@ApplicationContext context: Context): OkHttpClient{
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideBeerApi(client: OkHttpClient): BeerApi {
        return Retrofit.Builder()
            .baseUrl(BeerApi.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindLocalDataSource(localDataSource: BeerLocalDataSourceImpl):BeerLocalDataSource
}