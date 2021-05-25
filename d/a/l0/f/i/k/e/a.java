package d.a.l0.f.i.k.e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes3.dex */
public final class a implements d.a.l0.f.i.k.f.b {

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f46743d = {"_id", "createAt", "uri", "packagename", "path", "size", "progress", "status"};

    /* renamed from: e  reason: collision with root package name */
    public static final int f46744e = DownloadState.DOWNLOADED.value();

    /* renamed from: f  reason: collision with root package name */
    public static final int f46745f = DownloadState.DOWNLOAD_PAUSED.value();

    /* renamed from: a  reason: collision with root package name */
    public b f46746a;

    /* renamed from: b  reason: collision with root package name */
    public final SQLiteDatabase f46747b;

    /* renamed from: c  reason: collision with root package name */
    public final SQLiteDatabase f46748c;

    public a(Context context, d.a.l0.f.i.k.c.a aVar) {
        this.f46746a = null;
        b bVar = new b(context);
        this.f46746a = bVar;
        this.f46747b = bVar.getWritableDatabase();
        this.f46748c = this.f46746a.getReadableDatabase();
    }

    @Override // d.a.l0.f.i.k.f.b
    public void a(DownloadInfo downloadInfo) {
        this.f46747b.execSQL("REPLACE INTO ad_download(_id,createAt,uri,packagename,path,size,progress,status)VALUES(?,?,?,?,?,?,?,?);", new Object[]{downloadInfo.getId(), Long.valueOf(downloadInfo.getCreateAt()), downloadInfo.getUri(), downloadInfo.getPackageName(), downloadInfo.getPath(), Long.valueOf(downloadInfo.getSize()), Long.valueOf(downloadInfo.getProgress()), Integer.valueOf(downloadInfo.getStatus())});
    }

    @Override // d.a.l0.f.i.k.f.b
    public void b() {
        this.f46747b.execSQL("UPDATE ad_download SET status=? WHERE status!=?;", new Object[]{Integer.valueOf(f46745f), Integer.valueOf(f46744e)});
    }

    @Override // d.a.l0.f.i.k.f.b
    public DownloadInfo c(String str) {
        Cursor query = this.f46748c.query("ad_download", f46743d, "_id=?", new String[]{str}, null, null, "createAt desc");
        if (query.moveToNext()) {
            DownloadInfo downloadInfo = new DownloadInfo();
            e(query, downloadInfo);
            query.close();
            return downloadInfo;
        }
        query.close();
        return null;
    }

    @Override // d.a.l0.f.i.k.f.b
    public synchronized void close() {
        if (this.f46746a == null) {
            return;
        }
        try {
            this.f46746a.close();
            this.f46746a = null;
        } catch (Exception unused) {
        }
    }

    @Override // d.a.l0.f.i.k.f.b
    public void d(DownloadInfo downloadInfo) {
        this.f46747b.delete("ad_download", "_id=?", new String[]{String.valueOf(downloadInfo.getId())});
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
