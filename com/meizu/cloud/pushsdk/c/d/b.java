package com.meizu.cloud.pushsdk.c.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes2.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String f68456a = b.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public static b f68457b;

    public b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static b a(Context context, String str) {
        if (f68457b == null) {
            f68457b = new b(context.getApplicationContext(), str);
        }
        return f68457b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'events' (id INTEGER PRIMARY KEY, eventData BLOB, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        String str = f68456a;
        com.meizu.cloud.pushsdk.c.f.c.b(str, "Upgrading database from version " + i2 + " to " + i3 + ". Destroying old data now..", new Object[0]);
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'events'");
        onCreate(sQLiteDatabase);
    }
}
