package d.a.l0.h.k0;

import android.annotation.SuppressLint;
import java.util.concurrent.LinkedBlockingDeque;
@SuppressLint({"MobilebdThread"})
/* loaded from: classes3.dex */
public final class k extends Thread {

    /* renamed from: e  reason: collision with root package name */
    public LinkedBlockingDeque<b> f47437e = new LinkedBlockingDeque<>(1024);

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f47438f;

    public final LinkedBlockingDeque<b> a() {
        return this.f47437e;
    }

    public final boolean b() {
        return this.f47438f;
    }

    public final void c(boolean z) {
        this.f47438f = z;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (this.f47438f) {
            try {
                this.f47437e.take().a();
            } catch (InterruptedException unused) {
                return;
            } catch (Throwable unused2) {
            }
        }
    }
}
