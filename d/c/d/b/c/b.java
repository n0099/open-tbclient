package d.c.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.c.d.b.c.a.a;
import d.c.d.b.l;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f65805c;

    /* renamed from: a  reason: collision with root package name */
    public d.c.d.b.c.c.b f65806a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f65807b;

    public static b a() {
        if (f65805c == null) {
            synchronized (b.class) {
                if (f65805c == null) {
                    f65805c = new b();
                }
            }
        }
        return f65805c;
    }

    public void b(Context context) {
        try {
            this.f65807b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f65806a = new d.c.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f65806a != null) {
            this.f65806a.f(this.f65807b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f65806a != null) {
            return this.f65806a.g(this.f65807b, str);
        }
        return false;
    }
}
