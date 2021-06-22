package d.g.b.a;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final Context f70016e;

    /* renamed from: f  reason: collision with root package name */
    public final m f70017f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f70018g;

    public c(Context context, m mVar) {
        this.f70016e = context;
        this.f70017f = mVar;
    }

    public final void a() {
        this.f70018g = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f70018g) {
            if (f.d().h(this.f70016e)) {
                this.f70017f.a(com.google.ar.core.p.COMPLETED);
                return;
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
