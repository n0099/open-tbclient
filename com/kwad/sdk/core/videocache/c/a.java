package com.kwad.sdk.core.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.j;
import com.kwad.sdk.core.videocache.n;
/* loaded from: classes3.dex */
public class a extends SQLiteOpenHelper implements b {
    public static final String[] a = {"_id", "url", "length", "mime"};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        j.a(context);
    }

    private ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.a);
        contentValues.put("length", Long.valueOf(nVar.f56352b));
        contentValues.put("mime", nVar.f56353c);
        return contentValues;
    }

    private n a(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public n a(String str) {
        Throwable th;
        Cursor cursor;
        j.a(str);
        n nVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", a, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        nVar = a(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return nVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.kwad.sdk.core.videocache.c.b
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
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
