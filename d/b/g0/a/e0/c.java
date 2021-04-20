package d.b.g0.a.e0;

import android.os.Looper;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.e0.f;
import d.b.g0.a.i2.k0;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f44257a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f44258b;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44259e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44260f;

        public a(int i, int i2) {
            this.f44259e = i;
            this.f44260f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.c(this.f44259e, this.f44260f);
        }
    }

    public static boolean b() {
        return f44258b < 2;
    }

    public static void c(@StringRes int i, int i2) {
        SwanAppActivity activity = d.b.g0.a.z0.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (i2 != 1) {
            d.b.g0.a.q1.b.f.d.e(activity, i).C();
        } else {
            d.b.g0.a.q1.b.f.d.e(activity, i).E();
        }
    }

    public static void d(@StringRes int i, int i2) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            c(i, i2);
        } else {
            k0.T(new a(i, i2));
        }
    }

    public static void e() {
        f44258b = 0;
        f44257a = 0L;
    }

    public static void f(@StringRes int i) {
        g(i, 0);
    }

    public static synchronized void g(@StringRes int i, int i2) {
        synchronized (c.class) {
            if (f.b.f44270d) {
                int i3 = f44258b;
                if (i3 != 0) {
                    if (i3 == 1 && (f44257a + 5000) - System.currentTimeMillis() < 0) {
                        f44258b = 2;
                        d(i, i2);
                        f.d("toast提示个数已达2个");
                    }
                } else {
                    f44258b = 1;
                    f44257a = System.currentTimeMillis();
                    d(i, i2);
                }
            }
        }
    }
}
