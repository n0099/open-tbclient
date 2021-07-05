package d.a.q0.f.i.k.e;

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
/* loaded from: classes8.dex */
public final class a implements d.a.q0.f.i.k.f.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f52671d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f52672e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f52673f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f52674a;

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteDatabase f52675b;

    /* renamed from: c  reason: collision with root package name */
    public final SQLiteDatabase f52676c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1933429634, "Ld/a/q0/f/i/k/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1933429634, "Ld/a/q0/f/i/k/e/a;");
                return;
            }
        }
        f52671d = new String[]{"_id", "createAt", "uri", "packagename", "path", "size", "progress", "status"};
        f52672e = DownloadState.DOWNLOADED.value();
        f52673f = DownloadState.DOWNLOAD_PAUSED.value();
    }

    public a(Context context, d.a.q0.f.i.k.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52674a = null;
        b bVar = new b(context);
        this.f52674a = bVar;
        this.f52675b = bVar.getWritableDatabase();
        this.f52676c = this.f52674a.getReadableDatabase();
    }

    @Override // d.a.q0.f.i.k.f.b
    public void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
            this.f52675b.execSQL("REPLACE INTO ad_download(_id,createAt,uri,packagename,path,size,progress,status)VALUES(?,?,?,?,?,?,?,?);", new Object[]{downloadInfo.getId(), Long.valueOf(downloadInfo.getCreateAt()), downloadInfo.getUri(), downloadInfo.getPackageName(), downloadInfo.getPath(), Long.valueOf(downloadInfo.getSize()), Long.valueOf(downloadInfo.getProgress()), Integer.valueOf(downloadInfo.getStatus())});
        }
    }

    @Override // d.a.q0.f.i.k.f.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f52675b.execSQL("UPDATE ad_download SET status=? WHERE status!=?;", new Object[]{Integer.valueOf(f52673f), Integer.valueOf(f52672e)});
        }
    }

    @Override // d.a.q0.f.i.k.f.b
    public DownloadInfo c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Cursor query = this.f52676c.query("ad_download", f52671d, "_id=?", new String[]{str}, null, null, "createAt desc");
            if (query.moveToNext()) {
                DownloadInfo downloadInfo = new DownloadInfo();
                e(query, downloadInfo);
                query.close();
                return downloadInfo;
            }
            query.close();
            return null;
        }
        return (DownloadInfo) invokeL.objValue;
    }

    @Override // d.a.q0.f.i.k.f.b
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.f52674a == null) {
                    return;
                }
                try {
                    this.f52674a.close();
                    this.f52674a = null;
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // d.a.q0.f.i.k.f.b
    public void d(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) {
            this.f52675b.delete("ad_download", "_id=?", new String[]{String.valueOf(downloadInfo.getId())});
        }
    }

    public final void e(Cursor cursor, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, cursor, downloadInfo) == null) {
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
}
