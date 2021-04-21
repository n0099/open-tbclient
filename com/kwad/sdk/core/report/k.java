package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public class k extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f34430a = 1;

    /* renamed from: b  reason: collision with root package name */
    public String f34431b;

    public k(@Nullable Context context, int i) {
        super(context, "ksadrep.db", (SQLiteDatabase.CursorFactory) null, i);
        this.f34431b = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.f34431b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
