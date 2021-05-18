package d.a.i0.a.r1.m;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.i0.a.v2.q0;
/* loaded from: classes3.dex */
public class e implements d.a.i0.a.v2.e1.b<HybridUbcFlow> {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f44366f = true;

    /* renamed from: g  reason: collision with root package name */
    public static int f44367g = -1;

    /* renamed from: e  reason: collision with root package name */
    public final String f44368e;

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
        this.f44368e = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.v2.e1.b
    /* renamed from: a */
    public synchronized void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f44366f) {
            if (f44367g == -1) {
                d.a.i0.a.c1.a.Z().getSwitch("swan_next_env_delay", 600);
                f44367g = 600;
            }
            q0.Y(new a(this), f44367g);
        }
        if ("fmp_callback".equals(this.f44368e)) {
            f44366f = false;
        } else if ("callback_on_submit".equals(this.f44368e)) {
            f44366f = true;
        }
    }
}
