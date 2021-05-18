package d.a.i0.h.h0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.i0.a.a2.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k;
import d.a.i0.a.n1.m;
import d.a.i0.h.f0.h;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47216a = k.f43025a;

    /* loaded from: classes3.dex */
    public static class a extends d.a.i0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.h.h0.a f47217c;

        public a(d.a.i0.h.h0.a aVar) {
            this.f47217c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v1.a.b.c.b, d.a.i0.a.v1.a.b.c.c, d.a.i0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.i0.a.v1.a.b.a.b bVar) {
            int i2;
            if (SwanAppNetworkUtils.i(null)) {
                i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            } else {
                i2 = -2;
            }
            if (b.f47216a) {
                Log.d("StuckScreenReporter", "get NetworkQuality: " + i2);
            }
            d.a.i0.h.h0.a aVar = this.f47217c;
            aVar.m = i2;
            d.a.i0.a.j2.k.u("976", aVar);
        }
    }

    public static void b(d.a.i0.h.h0.a aVar) {
        if (aVar == null) {
            return;
        }
        d.a.i0.a.v1.c.e.a.E().L(null, m.class, new a(aVar));
    }

    public static void c(d.a.e0.a.d.b bVar) {
        V8ExceptionInfo a2;
        if (bVar == null || (a2 = bVar.a()) == null) {
            return;
        }
        String str = a2.exceptionMsg;
        String str2 = a2.exceptionTrace;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        if (f47216a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(d.a.i0.h.q.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= d.a.i0.h.q.c.b.a()) {
            return;
        }
        d.a.i0.h.h0.a aVar = new d.a.i0.h.h0.a();
        aVar.f43012b = "stuck";
        aVar.f43015e = "jserror";
        aVar.f43016f = e.V();
        if (e.i() != null && e.i().N() != null) {
            b.a N = e.i().N();
            aVar.f43013c = N.T();
            aVar.f43011a = d.a.i0.a.j2.k.m(N.G());
        }
        aVar.l = str + ";" + str2;
        aVar.k = h.d() ? 20 : 10;
        aVar.n = d.a.i0.h.q.c.b.b();
        aVar.o = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
