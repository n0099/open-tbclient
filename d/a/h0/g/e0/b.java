package d.a.h0.g.e0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8ExceptionInfo;
import com.baidu.searchbox.v8engine.util.TimeUtils;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.y0.e.b;
import d.a.h0.a.z1.h;
import d.a.h0.g.w.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46298a = k.f43101a;

    /* loaded from: classes3.dex */
    public static class a extends d.a.h0.a.n1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.g.e0.a f46299c;

        public a(d.a.h0.g.e0.a aVar) {
            this.f46299c = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.n1.a.b.c.b, d.a.h0.a.n1.a.b.c.c, d.a.h0.a.n1.a.b.c.a
        public void onEvent(@NonNull d.a.h0.a.n1.a.b.a.b bVar) {
            int i2;
            if (SwanAppNetworkUtils.h(null)) {
                i2 = bVar.a() != null ? bVar.a().getInt("net_quality") : -1;
            } else {
                i2 = -2;
            }
            if (b.f46298a) {
                Log.d("StuckScreenReporter", "get NetworkQuality: " + i2);
            }
            d.a.h0.g.e0.a aVar = this.f46299c;
            aVar.l = i2;
            h.u("976", aVar);
        }
    }

    public static void b(d.a.h0.g.e0.a aVar) {
        if (aVar == null) {
            return;
        }
        d.a.h0.a.n1.c.e.a.C().J(null, d.class, new a(aVar));
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
        if (f46298a) {
            Log.d("StuckScreenReporter", String.format("LastTouchTime %s; exceptionTime %s", TimeUtils.logTimeOfDay(d.a.h0.g.o.c.b.a()), TimeUtils.logTimeOfDay(a2.exceptionTime)));
        }
        if (a2.exceptionTime >= d.a.h0.g.o.c.b.a()) {
            return;
        }
        d.a.h0.g.e0.a aVar = new d.a.h0.g.e0.a();
        aVar.f45412b = "stuck";
        aVar.f45414d = "jserror";
        aVar.f45415e = e.T();
        if (e.h() != null && e.h().L() != null) {
            b.a L = e.h().L();
            aVar.f45413c = L.S();
            aVar.f45411a = h.n(L.F());
        }
        aVar.k = str + ";" + str2;
        aVar.j = d.a.h0.g.c0.d.d() ? 20 : 10;
        aVar.m = d.a.h0.g.o.c.b.b();
        aVar.n = System.currentTimeMillis() - a2.exceptionTime;
        b(aVar);
    }
}
