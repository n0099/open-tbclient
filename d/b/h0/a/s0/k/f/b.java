package d.b.h0.a.s0.k.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.b.h0.a.s0.k.f.c.c;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final d.b.h0.a.s0.k.f.c.a f46621a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d.b.h0.a.s0.k.f.c.a f46622b;

    /* loaded from: classes2.dex */
    public static class a implements d.b.h0.a.i2.u0.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            b.b().b(TextUtils.equals(hybridUbcFlow.j().optString("type"), "3") || hybridUbcFlow.m("na_first_meaningful_paint"));
        }
    }

    static {
        d.b.h0.a.s0.k.f.c.b bVar = new d.b.h0.a.s0.k.f.c.b();
        f46621a = bVar;
        f46622b = bVar;
    }

    public static void a() {
        b().a();
    }

    @NonNull
    public static d.b.h0.a.s0.k.f.c.a b() {
        return f46622b;
    }

    public static void c() {
        b().a();
    }

    public static void d(String str) {
        f(new c(str));
    }

    public static void e() {
        f(f46621a);
    }

    public static void f(@NonNull d.b.h0.a.s0.k.f.c.a aVar) {
        f46622b = aVar;
    }
}
