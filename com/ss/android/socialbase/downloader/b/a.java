package com.ss.android.socialbase.downloader.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61601b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super(com.ss.android.socialbase.downloader.downloader.c.N(), "downloader.db", (SQLiteDatabase.CursorFactory) null, 15);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Context) objArr[0], (String) objArr[1], (SQLiteDatabase.CursorFactory) objArr[2], ((Integer) objArr[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61601b = false;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Context N = com.ss.android.socialbase.downloader.downloader.c.N();
            if (!this.f61601b && N != null) {
                try {
                    File file = new File("/data/data/" + N.getPackageName() + "/database/main/");
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    super.getReadableDatabase().execSQL("PRAGMA temp_store_directory = tempDir");
                    this.f61601b = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return super.getReadableDatabase();
            }
            return super.getReadableDatabase();
        }
        return (SQLiteDatabase) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
            super.onConfigure(sQLiteDatabase);
            if (com.ss.android.socialbase.downloader.g.a.c().b("disable_sqlite_wal") <= 0 || Build.VERSION.SDK_INT != 28) {
                return;
            }
            sQLiteDatabase.disableWriteAheadLogging();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloader( _id INTEGER PRIMARY KEY, url TEXT, savePath TEXT, tempPath TEXT, name TEXT, chunkCount INTEGER, status INTEGER, curBytes INTEGER, totalBytes INTEGER, eTag TEXT, onlyWifi INTEGER, force INTEGER, retryCount INTEGER, extra TEXT, mimeType TEXT, title TEXT, notificationEnable INTEGER, notificationVisibility INTEGER, isFirstDownload INTEGER, isFirstSuccess INTEGER, needHttpsToHttpRetry INTEGER, downloadTime INTEGER, packageName TEXT, md5 TEXT, retryDelay INTEGER, curRetryTime INTEGER, retryDelayStatus INTEGER, defaultHttpServiceBackUp INTEGER, chunkRunnableReuse INTEGER, retryDelayTimeArray TEXT, chunkDowngradeRetry INTEGER, backUpUrlsStr TEXT, backUpUrlRetryCount INTEGER, realDownloadTime INTEGER, retryScheduleMinutes INTEGER, independentProcess INTEGER, auxiliaryJsonobjectString TEXT, iconUrl TEXT, appVersionCode INTEGER, taskId TEXT)");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloadChunk( _id INTEGER, chunkIndex INTEGER, startOffset INTEGER, curOffset INTEGER, endOffset INTEGER, chunkContentLen INTEGER, hostChunkIndex INTEGER )");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) && com.ss.android.socialbase.downloader.c.a.a()) {
            com.ss.android.socialbase.downloader.c.a.a("onDowngrade");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, sQLiteDatabase, i2, i3) == null) {
            switch (i2) {
                case 1:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD mimeType TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD title TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD notificationEnable INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD notificationVisibility INTEGER");
                case 2:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD isFirstDownload INTEGER");
                case 3:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD isFirstSuccess INTEGER");
                case 4:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD needHttpsToHttpRetry INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD downloadTime INTEGER");
                case 5:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD packageName TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD md5 TEXT");
                case 6:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelay INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD curRetryTime INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelayStatus INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD defaultHttpServiceBackUp INTEGER");
                case 7:
                    sQLiteDatabase.execSQL("ALTER TABLE downloadChunk ADD chunkContentLen INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloadChunk ADD hostChunkIndex INTEGER");
                case 8:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD chunkRunnableReuse INTEGER");
                case 9:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryDelayTimeArray TEXT");
                case 10:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD chunkDowngradeRetry INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD backUpUrlsStr TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD backUpUrlRetryCount INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD realDownloadTime INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD retryScheduleMinutes INTEGER");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD independentProcess INTEGER");
                case 11:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD auxiliaryJsonobjectString TEXT");
                case 12:
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD iconUrl TEXT");
                    sQLiteDatabase.execSQL("ALTER TABLE downloader ADD appVersionCode INTEGER");
                case 13:
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS segments( _id INTEGER PRIMARY KEY,info TEXT )");
                    break;
                case 14:
                    break;
                default:
                    return;
            }
            sQLiteDatabase.execSQL("ALTER TABLE downloader ADD taskId TEXT");
        }
    }
}
