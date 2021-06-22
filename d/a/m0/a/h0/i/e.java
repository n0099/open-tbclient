package d.a.m0.a.h0.i;

import android.os.Looper;
import androidx.annotation.StringRes;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f45951a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f45953f;

        public a(int i2, int i3) {
            this.f45952e = i2;
            this.f45953f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c(this.f45952e, this.f45953f);
        }
    }

    public static boolean b() {
        return f45951a < 2;
    }

    public static void c(@StringRes int i2, int i3) {
        SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (i3 != 1) {
            d.a.m0.a.z1.b.f.e.f(activity, i2).F();
        } else {
            d.a.m0.a.z1.b.f.e.f(activity, i2).H();
        }
    }

    public static void d(@StringRes int i2, int i3) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            c(i2, i3);
        } else {
            q0.X(new a(i2, i3));
        }
    }

    public static void e() {
        f45951a = 0;
    }

    public static void f(@StringRes int i2) {
        if (d.a.m0.a.r1.l.b.d() != 2 || d.a.m0.a.w2.e.D == null) {
            g(i2, 0);
        }
    }

    public static synchronized void g(@StringRes int i2, int i3) {
        synchronized (e.class) {
            int i4 = f45951a;
            if (i4 == 0) {
                f45951a = 1;
                System.currentTimeMillis();
                d(i2, i3);
            } else if (i4 == 1) {
                f45951a = 2;
                d(i2, i3);
                i.i("toast提示个数已达2个");
            }
        }
    }
}
