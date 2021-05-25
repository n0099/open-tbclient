package d.d.a.a.b;

import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f66052a;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f66053a = new g();
    }

    public static g a() {
        return b.f66053a;
    }

    public HandlerThread b() {
        return this.f66052a;
    }

    public g() {
        HandlerThread handlerThread = new HandlerThread("SensorCacheThread");
        this.f66052a = handlerThread;
        handlerThread.start();
        this.f66052a.setPriority(10);
    }
}
