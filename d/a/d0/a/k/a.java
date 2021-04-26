package d.a.d0.a.k;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d.a.d0.a.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0543a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Runnable f40615e;

        public RunnableC0543a(Runnable runnable) {
            this.f40615e = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f40615e.run();
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
                new Handler(Looper.getMainLooper()).post(new RunnableC0543a(runnable));
            }
        } catch (Exception e2) {
            b.i().d(e2);
        }
    }
}
