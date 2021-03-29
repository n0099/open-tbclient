package d.c.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.c.d.b.c.a.a;
import d.c.d.b.l;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f65806c;

    /* renamed from: a  reason: collision with root package name */
    public d.c.d.b.c.c.b f65807a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f65808b;

    public static b a() {
        if (f65806c == null) {
            synchronized (b.class) {
                if (f65806c == null) {
                    f65806c = new b();
                }
            }
        }
        return f65806c;
    }

    public void b(Context context) {
        try {
            this.f65808b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f65807a = new d.c.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f65807a != null) {
            this.f65807a.f(this.f65808b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f65807a != null) {
            return this.f65807a.g(this.f65808b, str);
        }
        return false;
    }
}
