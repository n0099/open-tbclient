package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f67162a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67163b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f67164c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f67165d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f67166e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f67167f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f67168g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f67169h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f67162a = sQLiteDatabase;
        this.f67163b = str;
        this.f67164c = strArr;
        this.f67165d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f67166e == null) {
            SQLiteStatement compileStatement = this.f67162a.compileStatement(f.a("INSERT INTO ", this.f67163b, this.f67164c));
            synchronized (this) {
                if (this.f67166e == null) {
                    this.f67166e = compileStatement;
                }
            }
            if (this.f67166e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67166e;
    }

    public SQLiteStatement b() {
        if (this.f67168g == null) {
            SQLiteStatement compileStatement = this.f67162a.compileStatement(f.b(this.f67163b, this.f67165d));
            synchronized (this) {
                if (this.f67168g == null) {
                    this.f67168g = compileStatement;
                }
            }
            if (this.f67168g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67168g;
    }

    public SQLiteStatement c() {
        if (this.f67167f == null) {
            SQLiteStatement compileStatement = this.f67162a.compileStatement(f.c(this.f67163b, this.f67164c, this.f67165d));
            synchronized (this) {
                if (this.f67167f == null) {
                    this.f67167f = compileStatement;
                }
            }
            if (this.f67167f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67167f;
    }

    public SQLiteStatement d() {
        if (this.f67169h == null) {
            SQLiteStatement compileStatement = this.f67162a.compileStatement(f.i(this.f67163b, this.f67164c, this.f67165d));
            synchronized (this) {
                if (this.f67169h == null) {
                    this.f67169h = compileStatement;
                }
            }
            if (this.f67169h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67169h;
    }
}
