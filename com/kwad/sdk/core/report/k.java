package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class k extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    public static int f9423a = 1;

    /* renamed from: b  reason: collision with root package name */
    private String f9424b;

    public k(@Nullable Context context, int i) {
        super(context, "ksadrep.db", (SQLiteDatabase.CursorFactory) null, i);
        this.f9424b = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.f9424b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
