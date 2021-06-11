package d.f.b.a;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static a f69876a = new a("loop");

    /* renamed from: b  reason: collision with root package name */
    public static a f69877b = new a("writer");

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Handler f69878a;

        public a(String str) {
            this.f69878a = null;
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.f69878a = new Handler(handlerThread.getLooper());
        }

        public Handler a() {
            return this.f69878a;
        }
    }

    public static Handler a() {
        return f69876a.a();
    }

    public static Handler b() {
        return f69877b.a();
    }
}
