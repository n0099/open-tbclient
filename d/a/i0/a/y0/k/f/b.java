package d.a.i0.a.y0.k.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.i0.a.y0.k.f.c.c;
import d.a.i0.a.y0.k.f.c.d;
import d.a.i0.a.y0.k.f.c.e;
import d.a.i0.a.y0.k.f.c.f;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final e f45718a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f45719b;

    /* loaded from: classes3.dex */
    public static class a implements d.a.i0.a.v2.e1.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            b.b().b(TextUtils.equals(hybridUbcFlow.k().optString("type"), "3") || hybridUbcFlow.n("na_first_meaningful_paint"), hybridUbcFlow);
        }
    }

    static {
        f fVar = new f();
        f45718a = fVar;
        f45719b = fVar;
    }

    public static void a() {
        b().c();
    }

    @NonNull
    public static e b() {
        return f45719b;
    }

    public static void c(int i2) {
        if (i2 != 3) {
            b().c();
        }
    }

    public static void d(String str) {
        e b2 = b();
        if (b2 != null && (b2 instanceof d.a.i0.a.y0.k.f.c.b)) {
            ((d.a.i0.a.y0.k.f.c.b) b2).f(str);
        } else {
            g(new d.a.i0.a.y0.k.f.c.b(str));
        }
    }

    public static void e(String str) {
        if (TextUtils.equals(str, "3")) {
            g(new d(str));
        } else {
            g(new c(str));
        }
    }

    public static void f() {
        g(f45718a);
    }

    public static void g(@NonNull e eVar) {
        f45719b = eVar;
    }
}
