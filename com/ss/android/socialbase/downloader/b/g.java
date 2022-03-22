package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes7.dex */
public class g {
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43171b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f43172c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f43173d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f43174e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f43175f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f43176g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f43177h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.f43171b = str;
        this.f43172c = strArr;
        this.f43173d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f43174e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f43171b, this.f43172c));
            synchronized (this) {
                if (this.f43174e == null) {
                    this.f43174e = compileStatement;
                }
            }
            if (this.f43174e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f43174e;
    }

    public SQLiteStatement b() {
        if (this.f43176g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f43171b, this.f43173d));
            synchronized (this) {
                if (this.f43176g == null) {
                    this.f43176g = compileStatement;
                }
            }
            if (this.f43176g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f43176g;
    }

    public SQLiteStatement c() {
        if (this.f43175f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f43171b, this.f43172c, this.f43173d));
            synchronized (this) {
                if (this.f43175f == null) {
                    this.f43175f = compileStatement;
                }
            }
            if (this.f43175f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f43175f;
    }

    public SQLiteStatement d() {
        if (this.f43177h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f43171b, this.f43172c, this.f43173d));
            synchronized (this) {
                if (this.f43177h == null) {
                    this.f43177h = compileStatement;
                }
            }
            if (this.f43177h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f43177h;
    }
}
