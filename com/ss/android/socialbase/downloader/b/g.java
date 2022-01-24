package com.ss.android.socialbase.downloader.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.i.i;
/* loaded from: classes4.dex */
public class g {
    public final SQLiteDatabase a;

    /* renamed from: b  reason: collision with root package name */
    public final String f59923b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f59924c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f59925d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f59926e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f59927f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f59928g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f59929h;

    public g(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.a = sQLiteDatabase;
        this.f59923b = str;
        this.f59924c = strArr;
        this.f59925d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f59926e == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a("INSERT INTO ", this.f59923b, this.f59924c));
            synchronized (this) {
                if (this.f59926e == null) {
                    this.f59926e = compileStatement;
                }
            }
            if (this.f59926e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59926e;
    }

    public SQLiteStatement b() {
        if (this.f59928g == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f59923b, this.f59925d));
            synchronized (this) {
                if (this.f59928g == null) {
                    this.f59928g = compileStatement;
                }
            }
            if (this.f59928g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59928g;
    }

    public SQLiteStatement c() {
        if (this.f59927f == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.a(this.f59923b, this.f59924c, this.f59925d));
            synchronized (this) {
                if (this.f59927f == null) {
                    this.f59927f = compileStatement;
                }
            }
            if (this.f59927f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59927f;
    }

    public SQLiteStatement d() {
        if (this.f59929h == null) {
            SQLiteStatement compileStatement = this.a.compileStatement(i.b(this.f59923b, this.f59924c, this.f59925d));
            synchronized (this) {
                if (this.f59929h == null) {
                    this.f59929h = compileStatement;
                }
            }
            if (this.f59929h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f59929h;
    }
}
