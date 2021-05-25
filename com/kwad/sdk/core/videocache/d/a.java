package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.kwad.sdk.core.videocache.j;
import com.kwad.sdk.core.videocache.n;
/* loaded from: classes6.dex */
public class a extends SQLiteOpenHelper implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f32722a = {"_id", "url", CloudStabilityUBCUtils.KEY_LENGTH, "mime"};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        j.a(context);
    }

    private ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.f32768a);
        contentValues.put(CloudStabilityUBCUtils.KEY_LENGTH, Long.valueOf(nVar.f32769b));
        contentValues.put("mime", nVar.f32770c);
        return contentValues;
    }

    private n a(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(CloudStabilityUBCUtils.KEY_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kwad.sdk.core.videocache.d.b
    public n a(String str) {
        Throwable th;
        Cursor cursor;
        j.a(str);
        n nVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", f32722a, "url=?", new String[]{str}, null, null, null);
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
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
