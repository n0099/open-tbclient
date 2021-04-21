package d.b.h0.g.e0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.y0.e.b;
import d.b.h0.a.z1.h;
import d.b.h0.g.w.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48827a = k.f45772a;

    /* loaded from: classes3.dex */
    public static class a extends d.b.h0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.g.e0.a f48828c;

        public a(d.b.h0.g.e0.a aVar) {
            this.f48828c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.n1.a.b.c.b, d.b.h0.a.n1.a.b.c.c, d.b.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.b.h0.a.n1.a.b.a.b bVar) {
            int i;
            if (SwanAppNetworkUtils.h(null)) {
                i = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            } else {
                i = -2;
            }
            if (b.f48827a) {
                Log.d("StuckScreenReporter", "get NetworkQuality: " + i);
            }
            d.b.h0.g.e0.a aVar = this.f48828c;
            aVar.l = i;
            h.u("976", aVar);
        }
    }

    public static void b(d.b.h0.g.e0.a aVar) {
        if (aVar == null) {
            return;
        }
        d.b.h0.a.n1.c.e.a.C().J(null, d.class, new a(aVar));
    }

    public static void c(d.b.e0.a.d.b bVar) {
        V8ExceptionInfo a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (f48827a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(d.b.h0.g.o.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= d.b.h0.g.o.c.b.a()) {
            return;
        }
        d.b.h0.g.e0.a aVar = new d.b.h0.g.e0.a();
        aVar.f47973b = "stuck";
        aVar.f47975d = "jserror";
        aVar.f47976e = e.T();
        if (e.y() != null && e.y().L() != null) {
            b.a L = e.y().L();
            aVar.f47974c = L.S();
            aVar.f47972a = h.n(L.F());
        }
        aVar.k = str + ";" + str2;
        aVar.j = d.b.h0.g.c0.d.d() ? 20 : 10;
        aVar.m = d.b.h0.g.o.c.b.b();
        aVar.n = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
