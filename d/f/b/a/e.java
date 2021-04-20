package d.f.b.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static a f66856a = new a("loop");

    /* renamed from: b  reason: collision with root package name */
    public static a f66857b = new a("writer");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Handler f66858a;

        public a(String str) {
            this.f66858a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.f66858a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f66858a;
        }
    }

    public static Handler a() {
        return f66856a.a();
    }

    public static Handler b() {
        return f66857b.a();
    }
}
