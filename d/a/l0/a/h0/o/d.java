package d.a.l0.a.h0.o;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.h0.o.a;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42434c = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.a.h0.o.a f42435a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.h0.o.b f42436b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42437e;

        public a(PrefetchEvent prefetchEvent) {
            this.f42437e = prefetchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c(this.f42437e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42439a;

        public b(PrefetchEvent prefetchEvent) {
            this.f42439a = prefetchEvent;
        }

        @Override // d.a.l0.a.h0.o.a.e
        public void a(d.a.l0.a.v1.c.f.c cVar, PMSAppInfo pMSAppInfo) {
            d.this.f42436b.b(this.f42439a, cVar, pMSAppInfo);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final d f42441a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d e() {
        return c.f42441a;
    }

    public final void c(PrefetchEvent prefetchEvent) {
        this.f42435a.g(prefetchEvent, new b(prefetchEvent));
    }

    public void d(PrefetchEvent prefetchEvent) {
        if (f42434c) {
            Log.d("SwanAppPrefetchManager", "fire preloadEvent abSwitch: " + d.a.l0.a.h0.o.e.a.f());
        }
        if (f(prefetchEvent)) {
            return;
        }
        if (f42434c) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
        }
        ExecutorUtilsExt.postOnSerial(new a(prefetchEvent), "prefetch-event-thread");
    }

    public final boolean f(PrefetchEvent prefetchEvent) {
        return (d.a.l0.a.h0.o.e.a.f() && prefetchEvent != null && prefetchEvent.f() && TextUtils.equals(prefetchEvent.state, "show")) ? false : true;
    }

    public d() {
        this.f42435a = new d.a.l0.a.h0.o.a();
        this.f42436b = new d.a.l0.a.h0.o.b();
    }
}
