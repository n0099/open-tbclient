package d.b.m.d;

import android.content.Context;
import com.baidu.crabsdk.sender.k;
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f65019e;

    public f(Context context) {
        this.f65019e = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            k.l(this.f65019e);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
