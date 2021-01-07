package com.ss.android.socialbase.downloader.c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.m.h;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f13403a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13404b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement pYW;
    private SQLiteStatement pYX;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f13403a = sQLiteDatabase;
        this.f13404b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement eHs() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.f13403a.compileStatement(h.d("INSERT INTO ", this.f13404b, this.c));
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

    public SQLiteStatement eHt() {
        if (this.pYX == null) {
            SQLiteStatement compileStatement = this.f13403a.compileStatement(h.a(this.f13404b, this.d));
            synchronized (this) {
                if (this.pYX == null) {
                    this.pYX = compileStatement;
                }
            }
            if (this.pYX != compileStatement) {
                compileStatement.close();
            }
        }
        return this.pYX;
    }

    public SQLiteStatement eHu() {
        if (this.pYW == null) {
            SQLiteStatement compileStatement = this.f13403a.compileStatement(h.a(this.f13404b, this.c, this.d));
            synchronized (this) {
                if (this.pYW == null) {
                    this.pYW = compileStatement;
                }
            }
            if (this.pYW != compileStatement) {
                compileStatement.close();
            }
        }
        return this.pYW;
    }
}
