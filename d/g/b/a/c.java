package d.g.b.a;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final Context f69912e;

    /* renamed from: f  reason: collision with root package name */
    public final m f69913f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f69914g;

    public c(Context context, m mVar) {
        this.f69912e = context;
        this.f69913f = mVar;
    }

    public final void a() {
        this.f69914g = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f69914g) {
            if (f.d().h(this.f69912e)) {
                this.f69913f.a(com.google.ar.core.p.COMPLETED);
                return;
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
