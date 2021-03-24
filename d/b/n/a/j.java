package d.b.n.a;

import android.os.Handler;
import com.baidu.crabsdk.a.n;
/* loaded from: classes2.dex */
public final class j implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f64133e;

    public j(n nVar) {
        this.f64133e = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.f64133e.b();
        if (this.f64133e.f4660a.get()) {
            Handler a2 = com.baidu.crabsdk.a.j.a();
            runnable = this.f64133e.f4662c;
            a2.postDelayed(runnable, this.f64133e.f4661b);
        }
    }
}
