package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes3.dex */
public class g {
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f59878b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f59879c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f59880d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f59881e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f59882f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f59883g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f59884h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.f59878b = str;
        this.f59879c = strArr;
        this.f59880d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f59881e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f59878b, this.f59879c));
            synchronized (this) {
                if (this.f59881e == null) {
                    this.f59881e = compileStatement;
                }
            }
            if (this.f59881e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59881e;
    }

    public SQLiteStatement b() {
        if (this.f59883g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f59878b, this.f59880d));
            synchronized (this) {
                if (this.f59883g == null) {
                    this.f59883g = compileStatement;
                }
            }
            if (this.f59883g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59883g;
    }

    public SQLiteStatement c() {
        if (this.f59882f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f59878b, this.f59879c, this.f59880d));
            synchronized (this) {
                if (this.f59882f == null) {
                    this.f59882f = compileStatement;
                }
            }
            if (this.f59882f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59882f;
    }

    public SQLiteStatement d() {
        if (this.f59884h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f59878b, this.f59879c, this.f59880d));
            synchronized (this) {
                if (this.f59884h == null) {
                    this.f59884h = compileStatement;
                }
            }
            if (this.f59884h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59884h;
    }
}
