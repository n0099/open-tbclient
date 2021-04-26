package d.g.b.a;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final Context f65452e;

    /* renamed from: f  reason: collision with root package name */
    public final m f65453f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f65454g;

    public c(Context context, m mVar) {
        this.f65452e = context;
        this.f65453f = mVar;
    }

    public final void a() {
        this.f65454g = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f65454g) {
            if (f.d().h(this.f65452e)) {
                this.f65453f.a(com.google.ar.core.p.COMPLETED);
                return;
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
