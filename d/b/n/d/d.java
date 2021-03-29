package d.b.n.d;

import android.content.Context;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f64145e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Throwable f64146f;

    public d(Context context, Throwable th) {
        this.f64145e = context;
        this.f64146f = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.g(this.f64145e, i.h(com.baidu.crabsdk.sender.g.c(this.f64145e, this.f64146f, false)));
            k.l(this.f64145e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
