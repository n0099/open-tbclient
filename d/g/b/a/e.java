package d.g.b.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static a f67003a = new a("loop");

    /* renamed from: b  reason: collision with root package name */
    public static a f67004b = new a("writer");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Handler f67005a;

        public a(String str) {
            this.f67005a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.f67005a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f67005a;
        }
    }

    public static Handler a() {
        return f67003a.a();
    }

    public static Handler b() {
        return f67004b.a();
    }
}
