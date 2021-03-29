package d.b.g0.a.j1.n;

import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.b.g0.a.i2.k0;
/* loaded from: classes2.dex */
public class e implements d.b.g0.a.i2.u0.b<HybridUbcFlow> {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f44938f = true;

    /* renamed from: g  reason: collision with root package name */
    public static int f44939g = -1;

    /* renamed from: e  reason: collision with root package name */
    public final String f44940e;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a(e eVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            k0.R();
        }
    }

    public e(String str) {
        this.f44940e = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.i2.u0.b
    /* renamed from: a */
    public synchronized void onCallback(HybridUbcFlow hybridUbcFlow) {
        if (f44938f) {
            if (f44939g == -1) {
                d.b.g0.a.w0.a.N().getSwitch("swan_next_env_delay", 600);
                f44939g = 600;
            }
            k0.U(new a(this), f44939g);
        }
        if ("fmp_callback".equals(this.f44940e)) {
            f44938f = false;
        } else if ("callback_on_submit".equals(this.f44940e)) {
            f44938f = true;
        }
    }
}
