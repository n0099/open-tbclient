package d.a.m0.a.r1.m;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.m0.a.v2.q0;
/* loaded from: classes3.dex */
public class e implements d.a.m0.a.v2.e1.b<HybridUbcFlow> {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f48324f = true;

    /* renamed from: g  reason: collision with root package name */
    public static int f48325g = -1;

    /* renamed from: e  reason: collision with root package name */
    public final String f48326e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(e eVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            q0.V();
        }
    }

    public e(String str) {
        this.f48326e = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.v2.e1.b
    /* renamed from: a */
    public synchronized void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f48324f) {
            if (f48325g == -1) {
                d.a.m0.a.c1.a.Z().getSwitch("swan_next_env_delay", 600);
                f48325g = 600;
            }
            q0.Y(new a(this), f48325g);
        }
        if ("fmp_callback".equals(this.f48326e)) {
            f48324f = false;
        } else if ("callback_on_submit".equals(this.f48326e)) {
            f48324f = true;
        }
    }
}
