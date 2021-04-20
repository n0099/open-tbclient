package d.b.g0.g.e0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.y0.e.b;
import d.b.g0.a.z1.h;
import d.b.g0.g.w.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48498a = k.f45443a;

    /* loaded from: classes3.dex */
    public static class a extends d.b.g0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.g.e0.a f48499c;

        public a(d.b.g0.g.e0.a aVar) {
            this.f48499c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.n1.a.b.c.b, d.b.g0.a.n1.a.b.c.c, d.b.g0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.g0.a.n1.a.b.a.b bVar) {
            int i;
            if (SwanAppNetworkUtils.h(null)) {
                i = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            } else {
                i = -2;
            }
            if (b.f48498a) {
                Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
            }
            d.b.g0.g.e0.a aVar = this.f48499c;
            aVar.l = i;
            h.u("976", aVar);
        }
    }

    public static void b(d.b.g0.g.e0.a aVar) {
        if (aVar == null) {
            return;
        }
        d.b.g0.a.n1.c.e.a.C().J(null, d.class, new a(aVar));
    }

    public static void c(d.b.d0.a.d.b bVar) {
        V8ExceptionInfo a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (f48498a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(d.b.g0.g.o.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= d.b.g0.g.o.c.b.a()) {
            return;
        }
        d.b.g0.g.e0.a aVar = new d.b.g0.g.e0.a();
        aVar.f47644b = "stuck";
        aVar.f47646d = "jserror";
        aVar.f47647e = e.T();
        if (e.y() != null && e.y().L() != null) {
            b.a L = e.y().L();
            aVar.f47645c = L.S();
            aVar.f47643a = h.n(L.F());
        }
        aVar.k = str + ";" + str2;
        aVar.j = d.b.g0.g.c0.d.d() ? 20 : 10;
        aVar.m = d.b.g0.g.o.c.b.b();
        aVar.n = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
