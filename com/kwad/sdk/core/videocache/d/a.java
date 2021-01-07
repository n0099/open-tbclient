package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.IMConstants;
import com.kwad.sdk.core.videocache.j;
import com.kwad.sdk.core.videocache.n;
import com.kwai.video.player.misc.IMediaFormat;
/* loaded from: classes5.dex */
class a extends SQLiteOpenHelper implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f9784a = {IMConstants.MSG_ROW_ID, "url", "length", IMediaFormat.KEY_MIME};

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        j.a(context);
    }

    private ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.f9806a);
        contentValues.put("length", Long.valueOf(nVar.f9807b));
        contentValues.put(IMediaFormat.KEY_MIME, nVar.c);
        return contentValues;
    }

    private n a(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow(IMediaFormat.KEY_MIME)));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    @Override // com.kwad.sdk.core.videocache.d.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public n a(String str) {
        n a2;
        Cursor cursor = null;
        j.a(str);
        try {
            Cursor query = getReadableDatabase().query("SourceInfo", f9784a, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        a2 = a(query);
                        if (query != null) {
                            query.close();
                        }
                        return a2;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            a2 = null;
            if (query != null) {
            }
            return a2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.kwad.sdk.core.videocache.d.b
    public void a(String str, n nVar) {
        j.a(str, nVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(nVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        j.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
