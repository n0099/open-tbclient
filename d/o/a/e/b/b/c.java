package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f70948a;

    /* renamed from: b  reason: collision with root package name */
    public final String f70949b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f70950c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f70951d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f70952e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f70953f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f70954g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f70955h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f70948a = sQLiteDatabase;
        this.f70949b = str;
        this.f70950c = strArr;
        this.f70951d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f70952e == null) {
            SQLiteStatement compileStatement = this.f70948a.compileStatement(f.a("INSERT INTO ", this.f70949b, this.f70950c));
            synchronized (this) {
                if (this.f70952e == null) {
                    this.f70952e = compileStatement;
                }
            }
            if (this.f70952e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f70952e;
    }

    public SQLiteStatement b() {
        if (this.f70954g == null) {
            SQLiteStatement compileStatement = this.f70948a.compileStatement(f.b(this.f70949b, this.f70951d));
            synchronized (this) {
                if (this.f70954g == null) {
                    this.f70954g = compileStatement;
                }
            }
            if (this.f70954g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f70954g;
    }

    public SQLiteStatement c() {
        if (this.f70953f == null) {
            SQLiteStatement compileStatement = this.f70948a.compileStatement(f.c(this.f70949b, this.f70950c, this.f70951d));
            synchronized (this) {
                if (this.f70953f == null) {
                    this.f70953f = compileStatement;
                }
            }
            if (this.f70953f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f70953f;
    }

    public SQLiteStatement d() {
        if (this.f70955h == null) {
            SQLiteStatement compileStatement = this.f70948a.compileStatement(f.i(this.f70949b, this.f70950c, this.f70951d));
            synchronized (this) {
                if (this.f70955h == null) {
                    this.f70955h = compileStatement;
                }
            }
            if (this.f70955h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f70955h;
    }
}
