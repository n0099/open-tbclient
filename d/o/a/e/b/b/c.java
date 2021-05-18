package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f67119a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67120b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f67121c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f67122d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f67123e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f67124f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f67125g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f67126h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f67119a = sQLiteDatabase;
        this.f67120b = str;
        this.f67121c = strArr;
        this.f67122d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f67123e == null) {
            SQLiteStatement compileStatement = this.f67119a.compileStatement(f.a("INSERT INTO ", this.f67120b, this.f67121c));
            synchronized (this) {
                if (this.f67123e == null) {
                    this.f67123e = compileStatement;
                }
            }
            if (this.f67123e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67123e;
    }

    public SQLiteStatement b() {
        if (this.f67125g == null) {
            SQLiteStatement compileStatement = this.f67119a.compileStatement(f.b(this.f67120b, this.f67122d));
            synchronized (this) {
                if (this.f67125g == null) {
                    this.f67125g = compileStatement;
                }
            }
            if (this.f67125g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67125g;
    }

    public SQLiteStatement c() {
        if (this.f67124f == null) {
            SQLiteStatement compileStatement = this.f67119a.compileStatement(f.c(this.f67120b, this.f67121c, this.f67122d));
            synchronized (this) {
                if (this.f67124f == null) {
                    this.f67124f = compileStatement;
                }
            }
            if (this.f67124f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67124f;
    }

    public SQLiteStatement d() {
        if (this.f67126h == null) {
            SQLiteStatement compileStatement = this.f67119a.compileStatement(f.i(this.f67120b, this.f67121c, this.f67122d));
            synchronized (this) {
                if (this.f67126h == null) {
                    this.f67126h = compileStatement;
                }
            }
            if (this.f67126h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67126h;
    }
}
