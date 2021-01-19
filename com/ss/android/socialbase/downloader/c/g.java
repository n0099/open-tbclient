package com.ss.android.socialbase.downloader.c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.m.h;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f13103a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13104b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement pUx;
    private SQLiteStatement pUy;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f13103a = sQLiteDatabase;
        this.f13104b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement eDC() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.f13103a.compileStatement(h.d("INSERT INTO ", this.f13104b, this.c));
            synchronized (this) {
                if (this.e == null) {
                    this.e = compileStatement;
                }
            }
            if (this.e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.e;
    }

    public SQLiteStatement eDD() {
        if (this.pUy == null) {
            SQLiteStatement compileStatement = this.f13103a.compileStatement(h.a(this.f13104b, this.d));
            synchronized (this) {
                if (this.pUy == null) {
                    this.pUy = compileStatement;
                }
            }
            if (this.pUy != compileStatement) {
                compileStatement.close();
            }
        }
        return this.pUy;
    }

    public SQLiteStatement eDE() {
        if (this.pUx == null) {
            SQLiteStatement compileStatement = this.f13103a.compileStatement(h.a(this.f13104b, this.c, this.d));
            synchronized (this) {
                if (this.pUx == null) {
                    this.pUx = compileStatement;
                }
            }
            if (this.pUx != compileStatement) {
                compileStatement.close();
            }
        }
        return this.pUx;
    }
}
