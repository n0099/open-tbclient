package d.a.b.a.a.b;

import android.content.Context;
import android.util.Pair;
import d.a.b.a.a.a.a.c;
import d.a.b.a.a.a.a.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f42033b;

    /* renamed from: a  reason: collision with root package name */
    public Context f42034a;

    public a(Context context) {
        this.f42034a = context.getApplicationContext();
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f42033b == null) {
                synchronized (a.class) {
                    if (f42033b == null) {
                        f42033b = new a(context.getApplicationContext());
                    }
                }
            }
            aVar = f42033b;
        }
        return aVar;
    }

    public final i a(String str) {
        return new c(this.f42034a).c(str);
    }

    public Pair c(String str) {
        i a2 = a(str);
        long j = -1;
        if (a2.d()) {
            try {
                j = d.a.b.a.a.e.a.a(a2.f42031a);
                return new Pair(0, Long.valueOf(j));
            } catch (IllegalArgumentException unused) {
                return new Pair(-108, Long.valueOf(j));
            }
        }
        return new Pair(Integer.valueOf(a2.f42032b), -1L);
    }
}
