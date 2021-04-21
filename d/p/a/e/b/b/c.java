package d.p.a.e.b.b;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import d.p.a.e.b.l.f;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final SQLiteDatabase f68077a;

    /* renamed from: b  reason: collision with root package name */
    public final String f68078b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f68079c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f68080d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteStatement f68081e;

    /* renamed from: f  reason: collision with root package name */
    public SQLiteStatement f68082f;

    /* renamed from: g  reason: collision with root package name */
    public SQLiteStatement f68083g;

    /* renamed from: h  reason: collision with root package name */
    public SQLiteStatement f68084h;

    public c(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.f68077a = sQLiteDatabase;
        this.f68078b = str;
        this.f68079c = strArr;
        this.f68080d = strArr2;
    }

    public SQLiteStatement a() {
        if (this.f68081e == null) {
            SQLiteStatement compileStatement = this.f68077a.compileStatement(f.a("INSERT INTO ", this.f68078b, this.f68079c));
            synchronized (this) {
                if (this.f68081e == null) {
                    this.f68081e = compileStatement;
                }
            }
            if (this.f68081e != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f68081e;
    }

    public SQLiteStatement b() {
        if (this.f68083g == null) {
            SQLiteStatement compileStatement = this.f68077a.compileStatement(f.b(this.f68078b, this.f68080d));
            synchronized (this) {
                if (this.f68083g == null) {
                    this.f68083g = compileStatement;
                }
            }
            if (this.f68083g != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f68083g;
    }

    public SQLiteStatement c() {
        if (this.f68082f == null) {
            SQLiteStatement compileStatement = this.f68077a.compileStatement(f.c(this.f68078b, this.f68079c, this.f68080d));
            synchronized (this) {
                if (this.f68082f == null) {
                    this.f68082f = compileStatement;
                }
            }
            if (this.f68082f != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f68082f;
    }

    public SQLiteStatement d() {
        if (this.f68084h == null) {
            SQLiteStatement compileStatement = this.f68077a.compileStatement(f.i(this.f68078b, this.f68079c, this.f68080d));
            synchronized (this) {
                if (this.f68084h == null) {
                    this.f68084h = compileStatement;
                }
            }
            if (this.f68084h != compileStatement) {
                compileStatement.close();
            }
        }
        return this.f68084h;
    }
}
