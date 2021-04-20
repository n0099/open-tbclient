package d.d.a.a.b;

import android.os.HandlerThread;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f66766a;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f66767a = new g();
    }

    public static g a() {
        return b.f66767a;
    }

    public HandlerThread b() {
        return this.f66766a;
    }

    public g() {
        HandlerThread handlerThread = new HandlerThread("SensorCacheThread");
        this.f66766a = handlerThread;
        handlerThread.start();
        this.f66766a.setPriority(10);
    }
}
