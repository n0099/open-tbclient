package d.a.h0.e.a.l.h;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
/* loaded from: classes3.dex */
public final class a implements d.a.h0.e.a.l.i.a {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f45786e = {"_id", "createAt", "uri", "packagename", "path", "size", "progress", "status"};

    /* renamed from: f  reason: collision with root package name */
    public static final int f45787f = SwanAdDownloadState.DOWNLOADED.value();

    /* renamed from: g  reason: collision with root package name */
    public static final int f45788g = SwanAdDownloadState.DOWNLOAD_PAUSED.value();

    /* renamed from: a  reason: collision with root package name */
    public final Context f45789a;

    /* renamed from: b  reason: collision with root package name */
    public final b f45790b;

    /* renamed from: c  reason: collision with root package name */
    public final SQLiteDatabase f45791c;

    /* renamed from: d  reason: collision with root package name */
    public final SQLiteDatabase f45792d;

    public a(Context context, d.a.h0.e.a.l.f.a aVar) {
        this.f45789a = context;
        b bVar = new b(context, aVar);
        this.f45790b = bVar;
        this.f45791c = bVar.getWritableDatabase();
        this.f45792d = this.f45790b.getReadableDatabase();
    }

    @Override // d.a.h0.e.a.l.i.a
    public void a(DownloadInfo downloadInfo) {
        this.f45791c.execSQL("REPLACE INTO ad_download(_id,createAt,uri,packagename,path,size,progress,status)VALUES(?,?,?,?,?,?,?,?);", new Object[]{downloadInfo.getId(), Long.valueOf(downloadInfo.getCreateAt()), downloadInfo.getUri(), downloadInfo.getPackageName(), downloadInfo.getPath(), Long.valueOf(downloadInfo.getSize()), Long.valueOf(downloadInfo.getProgress()), Integer.valueOf(downloadInfo.getStatus())});
    }

    @Override // d.a.h0.e.a.l.i.a
    public void b() {
        this.f45791c.execSQL("UPDATE ad_download SET status=? WHERE status!=?;", new Object[]{Integer.valueOf(f45788g), Integer.valueOf(f45787f)});
    }

    @Override // d.a.h0.e.a.l.i.a
    public DownloadInfo c(String str) {
        Cursor query = this.f45792d.query("ad_download", f45786e, "_id=?", new String[]{str}, null, null, "createAt desc");
        if (query.moveToNext()) {
            DownloadInfo downloadInfo = new DownloadInfo();
            e(query, downloadInfo);
            query.close();
            return downloadInfo;
        }
        query.close();
        return null;
    }

    @Override // d.a.h0.e.a.l.i.a
    public void d(DownloadInfo downloadInfo) {
        this.f45791c.delete("ad_download", "_id=?", new String[]{String.valueOf(downloadInfo.getId())});
    }

    public final void e(Cursor cursor, DownloadInfo downloadInfo) {
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
