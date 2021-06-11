package d.b.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.b.d.b.c.a.a;
import d.b.d.b.l;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f69609c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.d.b.c.c.b f69610a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f69611b;

    public static b a() {
        if (f69609c == null) {
            synchronized (b.class) {
                if (f69609c == null) {
                    f69609c = new b();
                }
            }
        }
        return f69609c;
    }

    public void b(Context context) {
        try {
            this.f69611b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f69610a = new d.b.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f69610a != null) {
            this.f69610a.f(this.f69611b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f69610a != null) {
            return this.f69610a.g(this.f69611b, str);
        }
        return false;
    }
}
