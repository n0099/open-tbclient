package d.b.m.d;

import android.content.Context;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f64749e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Throwable f64750f;

    public d(Context context, Throwable th) {
        this.f64749e = context;
        this.f64750f = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i.g(this.f64749e, i.h(com.baidu.crabsdk.sender.g.c(this.f64749e, this.f64750f, false)));
            k.l(this.f64749e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
