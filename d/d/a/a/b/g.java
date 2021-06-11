package d.d.a.a.b;

import android.os.HandlerThread;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f69783a;

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f69784a = new g();
    }

    public static g a() {
        return b.f69784a;
    }

    public HandlerThread b() {
        return this.f69783a;
    }

    public g() {
        HandlerThread handlerThread = new HandlerThread("SensorCacheThread");
        this.f69783a = handlerThread;
        handlerThread.start();
        this.f69783a.setPriority(10);
    }
}
