package d.a.h0.a.e0;

import android.os.Looper;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.e0.f;
import d.a.h0.a.i2.k0;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static long f41882a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile int f41883b;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f41885f;

        public a(int i2, int i3) {
            this.f41884e = i2;
            this.f41885f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.c(this.f41884e, this.f41885f);
        }
    }

    public static boolean b() {
        return f41883b < 2;
    }

    public static void c(@StringRes int i2, int i3) {
        SwanAppActivity activity = d.a.h0.a.z0.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (i3 != 1) {
            d.a.h0.a.q1.b.f.d.e(activity, i2).C();
        } else {
            d.a.h0.a.q1.b.f.d.e(activity, i2).E();
        }
    }

    public static void d(@StringRes int i2, int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            c(i2, i3);
        } else {
            k0.T(new a(i2, i3));
        }
    }

    public static void e() {
        f41883b = 0;
        f41882a = 0L;
    }

    public static void f(@StringRes int i2) {
        g(i2, 0);
    }

    public static synchronized void g(@StringRes int i2, int i3) {
        synchronized (c.class) {
            if (f.b.f41895d) {
                int i4 = f41883b;
                if (i4 != 0) {
                    if (i4 == 1 && (f41882a + 5000) - System.currentTimeMillis() < 0) {
                        f41883b = 2;
                        d(i2, i3);
                        f.d("toast提示个数已达2个");
                    }
                } else {
                    f41883b = 1;
                    f41882a = System.currentTimeMillis();
                    d(i2, i3);
                }
            }
        }
    }
}
