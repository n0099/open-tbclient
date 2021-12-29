package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes3.dex */
public class g {
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f62224b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f62225c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f62226d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f62227e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f62228f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f62229g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f62230h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.f62224b = str;
        this.f62225c = strArr;
        this.f62226d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f62227e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f62224b, this.f62225c));
            synchronized (this) {
                if (this.f62227e == null) {
                    this.f62227e = compileStatement;
                }
            }
            if (this.f62227e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f62227e;
    }

    public SQLiteStatement b() {
        if (this.f62229g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f62224b, this.f62226d));
            synchronized (this) {
                if (this.f62229g == null) {
                    this.f62229g = compileStatement;
                }
            }
            if (this.f62229g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f62229g;
    }

    public SQLiteStatement c() {
        if (this.f62228f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f62224b, this.f62225c, this.f62226d));
            synchronized (this) {
                if (this.f62228f == null) {
                    this.f62228f = compileStatement;
                }
            }
            if (this.f62228f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f62228f;
    }

    public SQLiteStatement d() {
        if (this.f62230h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f62224b, this.f62225c, this.f62226d));
            synchronized (this) {
                if (this.f62230h == null) {
                    this.f62230h = compileStatement;
                }
            }
            if (this.f62230h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f62230h;
    }
}
