package d.d.a.a.b;

import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f69887a;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f69888a = new g();
    }

    public static g a() {
        return b.f69888a;
    }

    public HandlerThread b() {
        return this.f69887a;
    }

    public g() {
        HandlerThread handlerThread = new HandlerThread("SensorCacheThread");
        this.f69887a = handlerThread;
        handlerThread.start();
        this.f69887a.setPriority(10);
    }
}
