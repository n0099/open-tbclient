package d.b.m.a;

import android.os.Handler;
import com.baidu.crabsdk.a.n;
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f65002e;

    public j(n nVar) {
        this.f65002e = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.f65002e.b();
        if (this.f65002e.f4696a.get()) {
            Handler a2 = com.baidu.crabsdk.a.j.a();
            runnable = this.f65002e.f4698c;
            a2.postDelayed(runnable, this.f65002e.f4697b);
        }
    }
}
