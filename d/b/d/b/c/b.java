package d.b.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.b.d.b.c.a.a;
import d.b.d.b.l;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f65878c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.d.b.c.c.b f65879a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f65880b;

    public static b a() {
        if (f65878c == null) {
            synchronized (b.class) {
                if (f65878c == null) {
                    f65878c = new b();
                }
            }
        }
        return f65878c;
    }

    public void b(Context context) {
        try {
            this.f65880b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f65879a = new d.b.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f65879a != null) {
            this.f65879a.f(this.f65880b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f65879a != null) {
            return this.f65879a.g(this.f65880b, str);
        }
        return false;
    }
}
