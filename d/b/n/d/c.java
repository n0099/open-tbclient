package d.b.n.d;

import android.content.Context;
import com.baidu.crabsdk.b.s;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
import java.util.Map;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f64143e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f64144f;

    public c(Throwable th, Context context) {
        this.f64143e = th;
        this.f64144f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> d2 = com.baidu.crabsdk.sender.g.d(this.f64143e, this.f64144f);
            com.baidu.crabsdk.sender.g.h(d2);
            d2.put("exceptionThread", s.b(Thread.currentThread()));
            i.e(this.f64144f, i.h(d2));
            k.l(this.f64144f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
