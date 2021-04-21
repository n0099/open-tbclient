package d.e.a.a.b;

import android.os.HandlerThread;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f66913a;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f66914a = new g();
    }

    public static g a() {
        return b.f66914a;
    }

    public HandlerThread b() {
        return this.f66913a;
    }

    public g() {
        HandlerThread handlerThread = new HandlerThread("SensorCacheThread");
        this.f66913a = handlerThread;
        handlerThread.start();
        this.f66913a.setPriority(10);
    }
}
