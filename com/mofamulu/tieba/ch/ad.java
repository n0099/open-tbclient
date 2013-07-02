package com.mofamulu.tieba.ch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class ad extends SQLiteOpenHelper {
    public ad(Context context) {
        super(context, "ice.tbhp", (SQLiteDatabase.CursorFactory) null, 5);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS chs(userName VARCHAR(64) PRIMARY KEY, nickName VARCHAR(64), color int(11), brand VARCHAR(32), sign VARCHAR(64), nickType int(11), lastUpdateTime bigint)");
            a(sQLiteDatabase);
            b(sQLiteDatabase);
            c(sQLiteDatabase);
        } catch (Throwable th) {
            Log.e("tbhp_DBHelper", "failed to onCreate.", th);
        }
    }

    protected void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS signs(userName VARCHAR(64) PRIMARY KEY, password VARCHAR(128), authCode varchar(255), cookies text, loginError VARCHAR(255), signStatus int(11), lastSign int(11), ignoredTiebas text, tiebas text)");
    }

    protected void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter TABLE signs add column fromType int(11) default 0");
    }

    protected void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("alter TABLE chs add column banner varchar(512)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 3) {
            a(sQLiteDatabase);
        }
        if (i < 4) {
            b(sQLiteDatabase);
        }
        if (i < 5) {
            c(sQLiteDatabase);
        }
    }
}
