package d.b.d.b.n;

import android.content.Context;
import d.b.d.b.h.i;
import d.b.d.b.l;
import d.b.d.b.m;
/* loaded from: classes5.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public Context f65250e;

    public c(Context context) {
        this.f65250e = context;
    }

    public static void a(Context context) {
        b(context, 0);
    }

    public static void b(Context context, int i2) {
        try {
            if (!m.a().e().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        i.b().postDelayed(new c(context), i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new d.b.d.b.h.e(this.f65250e).c(l.j.c(this.f65250e));
        } finally {
            try {
            } finally {
            }
        }
    }
}
