package d.c.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.c.d.b.c.a.a;
import d.c.d.b.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f66651c;

    /* renamed from: a  reason: collision with root package name */
    public d.c.d.b.c.c.b f66652a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f66653b;

    public static b a() {
        if (f66651c == null) {
            synchronized (b.class) {
                if (f66651c == null) {
                    f66651c = new b();
                }
            }
        }
        return f66651c;
    }

    public void b(Context context) {
        try {
            this.f66653b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f66652a = new d.c.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f66652a != null) {
            this.f66652a.f(this.f66653b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f66652a != null) {
            return this.f66652a.g(this.f66653b, str);
        }
        return false;
    }
}
