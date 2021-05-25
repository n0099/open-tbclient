package d.f.b.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static a f66145a = new a("loop");

    /* renamed from: b  reason: collision with root package name */
    public static a f66146b = new a("writer");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Handler f66147a;

        public a(String str) {
            this.f66147a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.f66147a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f66147a;
        }
    }

    public static Handler a() {
        return f66145a.a();
    }

    public static Handler b() {
        return f66146b.a();
    }
}
