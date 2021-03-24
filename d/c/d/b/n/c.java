package d.c.d.b.n;

import android.content.Context;
import d.c.d.b.h.i;
import d.c.d.b.l;
import d.c.d.b.m;
/* loaded from: classes6.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f65902e;

    public c(Context context) {
        this.f65902e = context;
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
            new d.c.d.b.h.e(this.f65902e).c(l.j.c(this.f65902e));
        } finally {
            try {
            } finally {
            }
        }
    }
}
