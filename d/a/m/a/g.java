package d.a.m.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public Handler f63840a;

    public g(String str) {
        this.f63840a = null;
        HandlerThread handlerThread = new HandlerThread("BlockCanaryThread_" + str);
        handlerThread.start();
        this.f63840a = new Handler(handlerThread.getLooper());
    }

    public final Handler a() {
        return this.f63840a;
    }
}
