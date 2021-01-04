package com.ss.android.socialbase.downloader.c;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.m.h;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f13402a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13403b;
    private final String[] c;
    private final String[] d;
    private SQLiteStatement e;
    private SQLiteStatement pXo;
    private SQLiteStatement pXp;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f13402a = sQLiteDatabase;
        this.f13403b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement eGO() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.f13402a.compileStatement(h.d("INSERT INTO ", this.f13403b, this.c));
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

    public SQLiteStatement eGP() {
        if (this.pXp == null) {
            SQLiteStatement compileStatement = this.f13402a.compileStatement(h.a(this.f13403b, this.d));
            synchronized (this) {
                if (this.pXp == null) {
                    this.pXp = compileStatement;
                }
            }
            if (this.pXp != compileStatement) {
                compileStatement.close();
            }
        }
        return this.pXp;
    }

    public SQLiteStatement eGQ() {
        if (this.pXo == null) {
            SQLiteStatement compileStatement = this.f13402a.compileStatement(h.a(this.f13403b, this.c, this.d));
            synchronized (this) {
                if (this.pXo == null) {
                    this.pXo = compileStatement;
                }
            }
            if (this.pXo != compileStatement) {
                compileStatement.close();
            }
        }
        return this.pXo;
    }
}
