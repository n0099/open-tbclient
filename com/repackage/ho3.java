package com.repackage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class ho3 implements ko3 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] d;
    public static final int e;
    public static final int f;
    public transient /* synthetic */ FieldHolder $fh;
    public io3 a;
    public final SQLiteDatabase b;
    public final SQLiteDatabase c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755641563, "Lcom/repackage/ho3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755641563, "Lcom/repackage/ho3;");
                return;
            }
        }
        d = new String[]{"_id", "createAt", "uri", "packagename", "path", "size", "progress", "status"};
        e = DownloadState.DOWNLOADED.value();
        f = DownloadState.DOWNLOAD_PAUSED.value();
    }

    public ho3(Context context, co3 co3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, co3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        io3 io3Var = new io3(context);
        this.a = io3Var;
        this.b = io3Var.getWritableDatabase();
        this.c = this.a.getReadableDatabase();
    }

    @Override // com.repackage.ko3
    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
            this.b.execSQL("REPLACE INTO ad_download(_id,createAt,uri,packagename,path,size,progress,status)VALUES(?,?,?,?,?,?,?,?);", new Object[]{downloadInfo.getId(), Long.valueOf(downloadInfo.getCreateAt()), downloadInfo.getUri(), downloadInfo.getPackageName(), downloadInfo.getPath(), Long.valueOf(downloadInfo.getSize()), Long.valueOf(downloadInfo.getProgress()), Integer.valueOf(downloadInfo.getStatus())});
        }
    }

    @Override // com.repackage.ko3
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.execSQL("UPDATE ad_download SET status=? WHERE status!=?;", new Object[]{Integer.valueOf(f), Integer.valueOf(e)});
        }
    }

    @Override // com.repackage.ko3
    public DownloadInfo c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Cursor query = this.c.query("ad_download", d, "_id=?", new String[]{str}, null, null, "createAt desc");
            if (query.moveToNext()) {
                DownloadInfo downloadInfo = new DownloadInfo();
                d(query, downloadInfo);
                query.close();
                return downloadInfo;
            }
            query.close();
            return null;
        }
        return (DownloadInfo) invokeL.objValue;
    }

    @Override // com.repackage.ko3
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    return;
                }
                try {
                    this.a.close();
                    this.a = null;
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void d(Cursor cursor, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, cursor, downloadInfo) == null) {
            int columnIndex = cursor.getColumnIndex("_id");
            int columnIndex2 = cursor.getColumnIndex("createAt");
            int columnIndex3 = cursor.getColumnIndex("uri");
            int columnIndex4 = cursor.getColumnIndex("packagename");
            int columnIndex5 = cursor.getColumnIndex("path");
            int columnIndex6 = cursor.getColumnIndex("size");
            int columnIndex7 = cursor.getColumnIndex("progress");
            int columnIndex8 = cursor.getColumnIndex("status");
            downloadInfo.setId(cursor.getString(columnIndex));
            downloadInfo.setCreateAt(cursor.getLong(columnIndex2));
            downloadInfo.setUri(cursor.getString(columnIndex3));
            downloadInfo.setPackageName(cursor.getString(columnIndex4));
            downloadInfo.setPath(cursor.getString(columnIndex5));
            downloadInfo.setSize(cursor.getLong(columnIndex6));
            downloadInfo.setProgress(cursor.getLong(columnIndex7));
            downloadInfo.setStatus(cursor.getInt(columnIndex8));
        }
    }

    @Override // com.repackage.ko3
    public void delete(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
            this.b.delete("ad_download", "_id=?", new String[]{String.valueOf(downloadInfo.getId())});
        }
    }
}
