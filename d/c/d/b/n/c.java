package d.c.d.b.n;

import android.content.Context;
import d.c.d.b.h.i;
import d.c.d.b.l;
import d.c.d.b.m;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f66748e;

    public c(Context context) {
        this.f66748e = context;
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void b(Context context, int i) {
        try {
            if (!m.a().e().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        i.b().postDelayed(new c(context), i);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new d.c.d.b.h.e(this.f66748e).c(l.j.c(this.f66748e));
        } finally {
            try {
            } finally {
            }
        }
    }
}
