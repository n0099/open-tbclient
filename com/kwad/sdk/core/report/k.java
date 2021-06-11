package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
/* loaded from: classes7.dex */
public class k extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f34681a = 1;

    /* renamed from: b  reason: collision with root package name */
    public String f34682b;

    public k(@Nullable Context context, int i2) {
        super(context, "ksadrep.db", (SQLiteDatabase.CursorFactory) null, i2);
        this.f34682b = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.f34682b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
