package d.a.m.a;

import android.os.Handler;
import com.baidu.crabsdk.a.n;
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f63851e;

    public j(n nVar) {
        this.f63851e = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.f63851e.b();
        if (this.f63851e.f4661a.get()) {
            Handler a2 = com.baidu.crabsdk.a.j.a();
            runnable = this.f63851e.f4663c;
            a2.postDelayed(runnable, this.f63851e.f4662b);
        }
    }
}
