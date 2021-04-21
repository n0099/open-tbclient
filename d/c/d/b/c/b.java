package d.c.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.c.d.b.c.a.a;
import d.c.d.b.l;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f66746c;

    /* renamed from: a  reason: collision with root package name */
    public d.c.d.b.c.c.b f66747a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f66748b;

    public static b a() {
        if (f66746c == null) {
            synchronized (b.class) {
                if (f66746c == null) {
                    f66746c = new b();
                }
            }
        }
        return f66746c;
    }

    public void b(Context context) {
        try {
            this.f66748b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f66747a = new d.c.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f66747a != null) {
            this.f66747a.f(this.f66748b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f66747a != null) {
            return this.f66747a.g(this.f66748b, str);
        }
        return false;
    }
}
