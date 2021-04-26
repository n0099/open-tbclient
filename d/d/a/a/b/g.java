package d.d.a.a.b;

import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f65323a;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f65324a = new g();
    }

    public static g a() {
        return b.f65324a;
    }

    public HandlerThread b() {
        return this.f65323a;
    }

    public g() {
        HandlerThread handlerThread = new HandlerThread("SensorCacheThread");
        this.f65323a = handlerThread;
        handlerThread.start();
        this.f65323a.setPriority(10);
    }
}
