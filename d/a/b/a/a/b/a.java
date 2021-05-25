package d.a.b.a.a.b;

import android.content.Context;
import android.util.Pair;
import d.a.b.a.a.a.a.c;
import d.a.b.a.a.a.a.i;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f38277b;

    /* renamed from: a  reason: collision with root package name */
    public Context f38278a;

    public a(Context context) {
        this.f38278a = context.getApplicationContext();
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f38277b == null) {
                synchronized (a.class) {
                    if (f38277b == null) {
                        f38277b = new a(context.getApplicationContext());
                    }
                }
            }
            aVar = f38277b;
        }
        return aVar;
    }

    public final i a(String str) {
        return new c(this.f38278a).c(str);
    }

    public Pair c(String str) {
        i a2 = a(str);
        long j = -1;
        if (a2.d()) {
            try {
                j = d.a.b.a.a.e.a.a(a2.f38275a);
                return new Pair(0, Long.valueOf(j));
            } catch (IllegalArgumentException unused) {
                return new Pair(-108, Long.valueOf(j));
            }
        }
        return new Pair(Integer.valueOf(a2.f38276b), -1L);
    }
}
