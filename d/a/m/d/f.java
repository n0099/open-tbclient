package d.a.m.d;

import android.content.Context;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f63330e;

    public f(Context context) {
        this.f63330e = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.l(this.f63330e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
