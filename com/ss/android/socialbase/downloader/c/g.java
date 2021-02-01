package com.ss.android.socialbase.downloader.c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.m.h;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f13105a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13106b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement qeB;
    private SQLiteStatement qeC;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f13105a = sQLiteDatabase;
        this.f13106b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement eFT() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.f13105a.compileStatement(h.d("INSERT INTO ", this.f13106b, this.c));
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

    public SQLiteStatement eFU() {
        if (this.qeC == null) {
            SQLiteStatement compileStatement = this.f13105a.compileStatement(h.a(this.f13106b, this.d));
            synchronized (this) {
                if (this.qeC == null) {
                    this.qeC = compileStatement;
                }
            }
            if (this.qeC != compileStatement) {
                compileStatement.close();
            }
        }
        return this.qeC;
    }

    public SQLiteStatement eFV() {
        if (this.qeB == null) {
            SQLiteStatement compileStatement = this.f13105a.compileStatement(h.a(this.f13106b, this.c, this.d));
            synchronized (this) {
                if (this.qeB == null) {
                    this.qeB = compileStatement;
                }
            }
            if (this.qeB != compileStatement) {
                compileStatement.close();
            }
        }
        return this.qeB;
    }
}
