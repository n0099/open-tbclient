package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes8.dex */
public class g {
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f58440b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f58441c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f58442d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f58443e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f58444f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f58445g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f58446h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.f58440b = str;
        this.f58441c = strArr;
        this.f58442d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f58443e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f58440b, this.f58441c));
            synchronized (this) {
                if (this.f58443e == null) {
                    this.f58443e = compileStatement;
                }
            }
            if (this.f58443e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f58443e;
    }

    public SQLiteStatement b() {
        if (this.f58445g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f58440b, this.f58442d));
            synchronized (this) {
                if (this.f58445g == null) {
                    this.f58445g = compileStatement;
                }
            }
            if (this.f58445g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f58445g;
    }

    public SQLiteStatement c() {
        if (this.f58444f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f58440b, this.f58441c, this.f58442d));
            synchronized (this) {
                if (this.f58444f == null) {
                    this.f58444f = compileStatement;
                }
            }
            if (this.f58444f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f58444f;
    }

    public SQLiteStatement d() {
        if (this.f58446h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f58440b, this.f58441c, this.f58442d));
            synchronized (this) {
                if (this.f58446h == null) {
                    this.f58446h = compileStatement;
                }
            }
            if (this.f58446h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f58446h;
    }
}
