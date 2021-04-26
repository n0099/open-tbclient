package d.b.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.b.d.b.c.a.a;
import d.b.d.b.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f65149c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.d.b.c.c.b f65150a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f65151b;

    public static b a() {
        if (f65149c == null) {
            synchronized (b.class) {
                if (f65149c == null) {
                    f65149c = new b();
                }
            }
        }
        return f65149c;
    }

    public void b(Context context) {
        try {
            this.f65151b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f65150a = new d.b.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f65150a != null) {
            this.f65150a.f(this.f65151b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f65150a != null) {
            return this.f65150a.g(this.f65151b, str);
        }
        return false;
    }
}
