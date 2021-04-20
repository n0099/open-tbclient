package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f67930a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67931b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f67932c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f67933d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f67934e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f67935f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f67936g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f67937h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f67930a = sQLiteDatabase;
        this.f67931b = str;
        this.f67932c = strArr;
        this.f67933d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f67934e == null) {
            SQLiteStatement compileStatement = this.f67930a.compileStatement(f.a("INSERT INTO ", this.f67931b, this.f67932c));
            synchronized (this) {
                if (this.f67934e == null) {
                    this.f67934e = compileStatement;
                }
            }
            if (this.f67934e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67934e;
    }

    public SQLiteStatement b() {
        if (this.f67936g == null) {
            SQLiteStatement compileStatement = this.f67930a.compileStatement(f.b(this.f67931b, this.f67933d));
            synchronized (this) {
                if (this.f67936g == null) {
                    this.f67936g = compileStatement;
                }
            }
            if (this.f67936g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67936g;
    }

    public SQLiteStatement c() {
        if (this.f67935f == null) {
            SQLiteStatement compileStatement = this.f67930a.compileStatement(f.c(this.f67931b, this.f67932c, this.f67933d));
            synchronized (this) {
                if (this.f67935f == null) {
                    this.f67935f = compileStatement;
                }
            }
            if (this.f67935f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67935f;
    }

    public SQLiteStatement d() {
        if (this.f67937h == null) {
            SQLiteStatement compileStatement = this.f67930a.compileStatement(f.i(this.f67931b, this.f67932c, this.f67933d));
            synchronized (this) {
                if (this.f67937h == null) {
                    this.f67937h = compileStatement;
                }
            }
            if (this.f67937h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f67937h;
    }
}
