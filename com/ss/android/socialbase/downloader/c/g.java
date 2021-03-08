package com.ss.android.socialbase.downloader.c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.m.h;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f7795a;
    private final String b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement qfQ;
    private SQLiteStatement qfR;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f7795a = sQLiteDatabase;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement eGf() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.f7795a.compileStatement(h.d("INSERT INTO ", this.b, this.c));
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

    public SQLiteStatement eGg() {
        if (this.qfR == null) {
            SQLiteStatement compileStatement = this.f7795a.compileStatement(h.a(this.b, this.d));
            synchronized (this) {
                if (this.qfR == null) {
                    this.qfR = compileStatement;
                }
            }
            if (this.qfR != compileStatement) {
                compileStatement.close();
            }
        }
        return this.qfR;
    }

    public SQLiteStatement eGh() {
        if (this.qfQ == null) {
            SQLiteStatement compileStatement = this.f7795a.compileStatement(h.a(this.b, this.c, this.d));
            synchronized (this) {
                if (this.qfQ == null) {
                    this.qfQ = compileStatement;
                }
            }
            if (this.qfQ != compileStatement) {
                compileStatement.close();
            }
        }
        return this.qfQ;
    }
}
