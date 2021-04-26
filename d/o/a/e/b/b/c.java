package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f66433a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66434b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f66435c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f66436d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f66437e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f66438f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f66439g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f66440h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f66433a = sQLiteDatabase;
        this.f66434b = str;
        this.f66435c = strArr;
        this.f66436d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f66437e == null) {
            SQLiteStatement compileStatement = this.f66433a.compileStatement(f.a("INSERT INTO ", this.f66434b, this.f66435c));
            synchronized (this) {
                if (this.f66437e == null) {
                    this.f66437e = compileStatement;
                }
            }
            if (this.f66437e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66437e;
    }

    public SQLiteStatement b() {
        if (this.f66439g == null) {
            SQLiteStatement compileStatement = this.f66433a.compileStatement(f.b(this.f66434b, this.f66436d));
            synchronized (this) {
                if (this.f66439g == null) {
                    this.f66439g = compileStatement;
                }
            }
            if (this.f66439g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66439g;
    }

    public SQLiteStatement c() {
        if (this.f66438f == null) {
            SQLiteStatement compileStatement = this.f66433a.compileStatement(f.c(this.f66434b, this.f66435c, this.f66436d));
            synchronized (this) {
                if (this.f66438f == null) {
                    this.f66438f = compileStatement;
                }
            }
            if (this.f66438f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66438f;
    }

    public SQLiteStatement d() {
        if (this.f66440h == null) {
            SQLiteStatement compileStatement = this.f66433a.compileStatement(f.i(this.f66434b, this.f66435c, this.f66436d));
            synchronized (this) {
                if (this.f66440h == null) {
                    this.f66440h = compileStatement;
                }
            }
            if (this.f66440h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66440h;
    }
}
