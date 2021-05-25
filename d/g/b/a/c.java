package d.g.b.a;

import android.content.Context;
/* loaded from: classes6.dex */
public final class c extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public final Context f66181e;

    /* renamed from: f  reason: collision with root package name */
    public final m f66182f;

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f66183g;

    public c(Context context, m mVar) {
        this.f66181e = context;
        this.f66182f = mVar;
    }

    public final void a() {
        this.f66183g = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!this.f66183g) {
            if (f.d().h(this.f66181e)) {
                this.f66182f.a(com.google.ar.core.p.COMPLETED);
                return;
            }
            try {
                Thread.sleep(200L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
