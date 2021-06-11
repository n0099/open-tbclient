package d.a.f0.a.k;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.f0.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0592a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f43527e;

        public RunnableC0592a(Runnable runnable) {
            this.f43527e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43527e.run();
        }
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new RunnableC0592a(runnable));
            }
        } catch (Exception e2) {
            b.i().d(e2);
        }
    }
}
