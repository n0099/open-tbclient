package d.b.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.b.d.b.c.a.a;
import d.b.d.b.l;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f69713c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.d.b.c.c.b f69714a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f69715b;

    public static b a() {
        if (f69713c == null) {
            synchronized (b.class) {
                if (f69713c == null) {
                    f69713c = new b();
                }
            }
        }
        return f69713c;
    }

    public void b(Context context) {
        try {
            this.f69715b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f69714a = new d.b.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f69714a != null) {
            this.f69714a.f(this.f69715b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f69714a != null) {
            return this.f69714a.g(this.f69715b, str);
        }
        return false;
    }
}
