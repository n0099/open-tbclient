package d.a.h0.a.j1.n;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.h0.a.i2.k0;
/* loaded from: classes3.dex */
public class e implements d.a.h0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f42984f = true;

    /* renamed from: g  reason: collision with root package name */
    public static int f42985g = -1;

    /* renamed from: e  reason: collision with root package name */
    public final String f42986e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(e eVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.R();
        }
    }

    public e(String str) {
        this.f42986e = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.i2.u0.b
    /* renamed from: a */
    public synchronized void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f42984f) {
            if (f42985g == -1) {
                d.a.h0.a.w0.a.N().getSwitch("swan_next_env_delay", 600);
                f42985g = 600;
            }
            k0.U(new a(this), f42985g);
        }
        if ("fmp_callback".equals(this.f42986e)) {
            f42984f = false;
        } else if ("callback_on_submit".equals(this.f42986e)) {
            f42984f = true;
        }
    }
}
