package d.b.m.a;

import android.os.Handler;
import com.baidu.crabsdk.a.n;
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ n f64738e;

    public j(n nVar) {
        this.f64738e = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable;
        this.f64738e.b();
        if (this.f64738e.f4696a.get()) {
            Handler a2 = com.baidu.crabsdk.a.j.a();
            runnable = this.f64738e.f4698c;
            a2.postDelayed(runnable, this.f64738e.f4697b);
        }
    }
}
