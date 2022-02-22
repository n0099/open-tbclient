package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes4.dex */
public class g {
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f60090b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f60091c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f60092d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f60093e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f60094f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f60095g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f60096h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.f60090b = str;
        this.f60091c = strArr;
        this.f60092d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f60093e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f60090b, this.f60091c));
            synchronized (this) {
                if (this.f60093e == null) {
                    this.f60093e = compileStatement;
                }
            }
            if (this.f60093e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f60093e;
    }

    public SQLiteStatement b() {
        if (this.f60095g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f60090b, this.f60092d));
            synchronized (this) {
                if (this.f60095g == null) {
                    this.f60095g = compileStatement;
                }
            }
            if (this.f60095g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f60095g;
    }

    public SQLiteStatement c() {
        if (this.f60094f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f60090b, this.f60091c, this.f60092d));
            synchronized (this) {
                if (this.f60094f == null) {
                    this.f60094f = compileStatement;
                }
            }
            if (this.f60094f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f60094f;
    }

    public SQLiteStatement d() {
        if (this.f60096h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f60090b, this.f60091c, this.f60092d));
            synchronized (this) {
                if (this.f60096h == null) {
                    this.f60096h = compileStatement;
                }
            }
            if (this.f60096h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f60096h;
    }
}
