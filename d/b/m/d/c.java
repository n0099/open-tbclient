package d.b.m.d;

import android.content.Context;
import com.baidu.crabsdk.b.s;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
import java.util.Map;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f64747e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f64748f;

    public c(Throwable th, Context context) {
        this.f64747e = th;
        this.f64748f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> d2 = com.baidu.crabsdk.sender.g.d(this.f64747e, this.f64748f);
            com.baidu.crabsdk.sender.g.h(d2);
            d2.put("exceptionThread", s.b(Thread.currentThread()));
            i.e(this.f64748f, i.h(d2));
            k.l(this.f64748f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
