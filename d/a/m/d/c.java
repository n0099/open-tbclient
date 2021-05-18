package d.a.m.d;

import android.content.Context;
import com.baidu.crabsdk.b.s;
import com.baidu.crabsdk.sender.i;
import com.baidu.crabsdk.sender.k;
import java.util.Map;
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Throwable f63860e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f63861f;

    public c(Throwable th, Context context) {
        this.f63860e = th;
        this.f63861f = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, Object> d2 = com.baidu.crabsdk.sender.g.d(this.f63860e, this.f63861f);
            com.baidu.crabsdk.sender.g.h(d2);
            d2.put("exceptionThread", s.b(Thread.currentThread()));
            i.e(this.f63861f, i.h(d2));
            k.l(this.f63861f);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
