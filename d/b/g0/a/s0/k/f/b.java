package d.b.g0.a.s0.k.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.b.g0.a.s0.k.f.c.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final d.b.g0.a.s0.k.f.c.a f45900a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.b.g0.a.s0.k.f.c.a f45901b;

    /* loaded from: classes2.dex */
    public static class a implements d.b.g0.a.i2.u0.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            b.b().b(TextUtils.equals(hybridUbcFlow.j().optString("type"), "3") || hybridUbcFlow.m("na_first_meaningful_paint"));
        }
    }

    static {
        d.b.g0.a.s0.k.f.c.b bVar = new d.b.g0.a.s0.k.f.c.b();
        f45900a = bVar;
        f45901b = bVar;
    }

    public static void a() {
        b().a();
    }

    @NonNull
    public static d.b.g0.a.s0.k.f.c.a b() {
        return f45901b;
    }

    public static void c() {
        b().a();
    }

    public static void d(String str) {
        f(new c(str));
    }

    public static void e() {
        f(f45900a);
    }

    public static void f(@NonNull d.b.g0.a.s0.k.f.c.a aVar) {
        f45901b = aVar;
    }
}
