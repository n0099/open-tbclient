package d.a.h0.a.s0.k.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.h0.a.s0.k.f.c.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final d.a.h0.a.s0.k.f.c.a f43992a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.a.h0.a.s0.k.f.c.a f43993b;

    /* loaded from: classes2.dex */
    public static class a implements d.a.h0.a.i2.u0.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            b.b().b(TextUtils.equals(hybridUbcFlow.j().optString("type"), "3") || hybridUbcFlow.m("na_first_meaningful_paint"));
        }
    }

    static {
        d.a.h0.a.s0.k.f.c.b bVar = new d.a.h0.a.s0.k.f.c.b();
        f43992a = bVar;
        f43993b = bVar;
    }

    public static void a() {
        b().a();
    }

    @NonNull
    public static d.a.h0.a.s0.k.f.c.a b() {
        return f43993b;
    }

    public static void c() {
        b().a();
    }

    public static void d(String str) {
        f(new c(str));
    }

    public static void e() {
        f(f43992a);
    }

    public static void f(@NonNull d.a.h0.a.s0.k.f.c.a aVar) {
        f43993b = aVar;
    }
}
