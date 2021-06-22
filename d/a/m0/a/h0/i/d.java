package d.a.m0.a.h0.i;

import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f45949a;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f45950e;

        public a(SwanAppActivity swanAppActivity) {
            this.f45950e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45950e.finish();
        }
    }

    public static String a() {
        return f45949a;
    }

    public static void b(String str) {
        f45949a = str;
    }

    public static void c() {
        SwanAppActivity activity = d.a.m0.a.g1.f.V().getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        q0.X(new a(activity));
    }
}
