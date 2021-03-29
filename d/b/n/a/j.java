package d.b.n.a;

import android.os.Handler;
import com.baidu.crabsdk.a.n;
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f64134e;

    public j(n nVar) {
        this.f64134e = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.f64134e.b();
        if (this.f64134e.f4661a.get()) {
            Handler a2 = com.baidu.crabsdk.a.j.a();
            runnable = this.f64134e.f4663c;
            a2.postDelayed(runnable, this.f64134e.f4662b);
        }
    }
}
