package d.b.n.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public Handler f64123a;

    public g(String str) {
        this.f64123a = null;
        HandlerThread handlerThread = new HandlerThread("BlockCanaryThread_" + str);
        handlerThread.start();
        this.f64123a = new Handler(handlerThread.getLooper());
    }

    public final Handler a() {
        return this.f64123a;
    }
}
