package d.o.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.o.a.e.b.l.f;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f66937a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66938b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f66939c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f66940d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f66941e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f66942f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f66943g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f66944h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f66937a = sQLiteDatabase;
        this.f66938b = str;
        this.f66939c = strArr;
        this.f66940d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f66941e == null) {
            SQLiteStatement compileStatement = this.f66937a.compileStatement(f.a("INSERT INTO ", this.f66938b, this.f66939c));
            synchronized (this) {
                if (this.f66941e == null) {
                    this.f66941e = compileStatement;
                }
            }
            if (this.f66941e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66941e;
    }

    public SQLiteStatement b() {
        if (this.f66943g == null) {
            SQLiteStatement compileStatement = this.f66937a.compileStatement(f.b(this.f66938b, this.f66940d));
            synchronized (this) {
                if (this.f66943g == null) {
                    this.f66943g = compileStatement;
                }
            }
            if (this.f66943g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66943g;
    }

    public SQLiteStatement c() {
        if (this.f66942f == null) {
            SQLiteStatement compileStatement = this.f66937a.compileStatement(f.c(this.f66938b, this.f66939c, this.f66940d));
            synchronized (this) {
                if (this.f66942f == null) {
                    this.f66942f = compileStatement;
                }
            }
            if (this.f66942f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66942f;
    }

    public SQLiteStatement d() {
        if (this.f66944h == null) {
            SQLiteStatement compileStatement = this.f66937a.compileStatement(f.i(this.f66938b, this.f66939c, this.f66940d));
            synchronized (this) {
                if (this.f66944h == null) {
                    this.f66944h = compileStatement;
                }
            }
            if (this.f66944h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f66944h;
    }
}
