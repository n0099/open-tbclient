package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes8.dex */
public class g {
    public final SQLiteDatabase a;
    public final String b;
    public final String[] c;
    public final String[] d;
    public SQLiteStatement e;
    public SQLiteStatement f;
    public SQLiteStatement g;
    public SQLiteStatement h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.b = str;
        this.c = strArr;
        this.d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.b, this.c));
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

    public SQLiteStatement b() {
        if (this.g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.b, this.d));
            synchronized (this) {
                if (this.g == null) {
                    this.g = compileStatement;
                }
            }
            if (this.g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.g;
    }

    public SQLiteStatement c() {
        if (this.f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.b, this.c, this.d));
            synchronized (this) {
                if (this.f == null) {
                    this.f = compileStatement;
                }
            }
            if (this.f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f;
    }

    public SQLiteStatement d() {
        if (this.h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.b, this.c, this.d));
            synchronized (this) {
                if (this.h == null) {
                    this.h = compileStatement;
                }
            }
            if (this.h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.h;
    }
}
