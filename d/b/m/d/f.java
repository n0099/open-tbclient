package d.b.m.d;

import android.content.Context;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f64755e;

    public f(Context context) {
        this.f64755e = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.l(this.f64755e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
