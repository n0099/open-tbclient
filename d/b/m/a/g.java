package d.b.m.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public Handler f64728a;

    public g(String str) {
        this.f64728a = null;
        HandlerThread handlerThread = new HandlerThread("BlockCanaryThread_" + str);
        handlerThread.start();
        this.f64728a = new Handler(handlerThread.getLooper());
    }

    public final Handler a() {
        return this.f64728a;
    }
}
