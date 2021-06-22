package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f71052a;

    /* renamed from: b  reason: collision with root package name */
    public final String f71053b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f71054c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f71055d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f71056e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f71057f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f71058g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f71059h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f71052a = sQLiteDatabase;
        this.f71053b = str;
        this.f71054c = strArr;
        this.f71055d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f71056e == null) {
            SQLiteStatement compileStatement = this.f71052a.compileStatement(f.a("INSERT INTO ", this.f71053b, this.f71054c));
            synchronized (this) {
                if (this.f71056e == null) {
                    this.f71056e = compileStatement;
                }
            }
            if (this.f71056e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f71056e;
    }

    public SQLiteStatement b() {
        if (this.f71058g == null) {
            SQLiteStatement compileStatement = this.f71052a.compileStatement(f.b(this.f71053b, this.f71055d));
            synchronized (this) {
                if (this.f71058g == null) {
                    this.f71058g = compileStatement;
                }
            }
            if (this.f71058g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f71058g;
    }

    public SQLiteStatement c() {
        if (this.f71057f == null) {
            SQLiteStatement compileStatement = this.f71052a.compileStatement(f.c(this.f71053b, this.f71054c, this.f71055d));
            synchronized (this) {
                if (this.f71057f == null) {
                    this.f71057f = compileStatement;
                }
            }
            if (this.f71057f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f71057f;
    }

    public SQLiteStatement d() {
        if (this.f71059h == null) {
            SQLiteStatement compileStatement = this.f71052a.compileStatement(f.i(this.f71053b, this.f71054c, this.f71055d));
            synchronized (this) {
                if (this.f71059h == null) {
                    this.f71059h = compileStatement;
                }
            }
            if (this.f71059h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f71059h;
    }
}
