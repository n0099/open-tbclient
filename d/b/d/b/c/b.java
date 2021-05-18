package d.b.d.b.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import d.b.d.b.c.a.a;
import d.b.d.b.l;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f65835c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.d.b.c.c.b f65836a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f65837b;

    public static b a() {
        if (f65835c == null) {
            synchronized (b.class) {
                if (f65835c == null) {
                    f65835c = new b();
                }
            }
        }
        return f65835c;
    }

    public void b(Context context) {
        try {
            this.f65837b = new d(context).getWritableDatabase();
        } catch (Throwable th) {
            l.k.c(th);
        }
        this.f65836a = new d.b.d.b.c.c.b();
    }

    public synchronized void c(a aVar) {
        if (this.f65836a != null) {
            this.f65836a.f(this.f65837b, aVar);
        }
    }

    public synchronized boolean d(String str) {
        if (this.f65836a != null) {
            return this.f65836a.g(this.f65837b, str);
        }
        return false;
    }
}
