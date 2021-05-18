package d.a.i0.a.h0.i;

import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.v2.q0;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f41991a;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f41992e;

        public a(SwanAppActivity swanAppActivity) {
            this.f41992e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f41992e.finish();
        }
    }

    public static String a() {
        return f41991a;
    }

    public static void b(String str) {
        f41991a = str;
    }

    public static void c() {
        SwanAppActivity activity = d.a.i0.a.g1.f.V().getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        q0.X(new a(activity));
    }
}
