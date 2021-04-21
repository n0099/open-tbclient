package d.h.b.a;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final Context f67037e;

    /* renamed from: f  reason: collision with root package name */
    public final m f67038f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f67039g;

    public c(Context context, m mVar) {
        this.f67037e = context;
        this.f67038f = mVar;
    }

    public final void a() {
        this.f67039g = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f67039g) {
            if (f.d().h(this.f67037e)) {
                this.f67038f.a(com.google.ar.core.p.COMPLETED);
                return;
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
