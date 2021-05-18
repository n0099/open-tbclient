package d.f.b.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static a f66102a = new a("loop");

    /* renamed from: b  reason: collision with root package name */
    public static a f66103b = new a("writer");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Handler f66104a;

        public a(String str) {
            this.f66104a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.f66104a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f66104a;
        }
    }

    public static Handler a() {
        return f66102a.a();
    }

    public static Handler b() {
        return f66103b.a();
    }
}
