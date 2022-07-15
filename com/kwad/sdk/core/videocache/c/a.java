package com.kwad.sdk.core.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.kwad.sdk.core.videocache.m;
import com.kwad.sdk.utils.aj;
/* loaded from: classes5.dex */
public final class a extends SQLiteOpenHelper implements b {
    public static final String[] a = {"_id", "url", CloudStabilityUBCUtils.KEY_LENGTH, "mime"};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        aj.a(context);
    }

    public static ContentValues a(m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", mVar.a);
        contentValues.put(CloudStabilityUBCUtils.KEY_LENGTH, Long.valueOf(mVar.b));
        contentValues.put("mime", mVar.c);
        return contentValues;
    }

    public static m a(Cursor cursor) {
        return new m(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(CloudStabilityUBCUtils.KEY_LENGTH)), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final m a(String str) {
        Throwable th;
        Cursor cursor;
        aj.a(str);
        m mVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", a, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        mVar = a(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.a(cursor);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.a(cursor);
            return mVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final void a(String str, m mVar) {
        aj.a(str, mVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(mVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        aj.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
