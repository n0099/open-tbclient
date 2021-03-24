package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f66932a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66933b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f66934c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f66935d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f66936e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f66937f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f66938g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f66939h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f66932a = sQLiteDatabase;
        this.f66933b = str;
        this.f66934c = strArr;
        this.f66935d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f66936e == null) {
            SQLiteStatement compileStatement = this.f66932a.compileStatement(f.a("INSERT INTO ", this.f66933b, this.f66934c));
            synchronized (this) {
                if (this.f66936e == null) {
                    this.f66936e = compileStatement;
                }
            }
            if (this.f66936e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66936e;
    }

    public SQLiteStatement b() {
        if (this.f66938g == null) {
            SQLiteStatement compileStatement = this.f66932a.compileStatement(f.b(this.f66933b, this.f66935d));
            synchronized (this) {
                if (this.f66938g == null) {
                    this.f66938g = compileStatement;
                }
            }
            if (this.f66938g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66938g;
    }

    public SQLiteStatement c() {
        if (this.f66937f == null) {
            SQLiteStatement compileStatement = this.f66932a.compileStatement(f.c(this.f66933b, this.f66934c, this.f66935d));
            synchronized (this) {
                if (this.f66937f == null) {
                    this.f66937f = compileStatement;
                }
            }
            if (this.f66937f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66937f;
    }

    public SQLiteStatement d() {
        if (this.f66939h == null) {
            SQLiteStatement compileStatement = this.f66932a.compileStatement(f.i(this.f66933b, this.f66934c, this.f66935d));
            synchronized (this) {
                if (this.f66939h == null) {
                    this.f66939h = compileStatement;
                }
            }
            if (this.f66939h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66939h;
    }
}
