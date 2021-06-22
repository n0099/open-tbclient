package d.f.b.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static a f69980a = new a("loop");

    /* renamed from: b  reason: collision with root package name */
    public static a f69981b = new a("writer");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Handler f69982a;

        public a(String str) {
            this.f69982a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.f69982a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f69982a;
        }
    }

    public static Handler a() {
        return f69980a.a();
    }

    public static Handler b() {
        return f69981b.a();
    }
}
