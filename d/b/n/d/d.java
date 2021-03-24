package d.b.n.d;

import android.content.Context;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes2.dex */
public final class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f64144e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Throwable f64145f;

    public d(Context context, Throwable th) {
        this.f64144e = context;
        this.f64145f = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.g(this.f64144e, i.h(com.baidu.crabsdk.sender.g.c(this.f64144e, this.f64145f, false)));
            k.l(this.f64144e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
