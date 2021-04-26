package d.f.b.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static a f65416a = new a("loop");

    /* renamed from: b  reason: collision with root package name */
    public static a f65417b = new a("writer");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Handler f65418a;

        public a(String str) {
            this.f65418a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.f65418a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f65418a;
        }
    }

    public static Handler a() {
        return f65416a.a();
    }

    public static Handler b() {
        return f65417b.a();
    }
}
