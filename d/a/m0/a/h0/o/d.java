package d.a.m0.a.h0.o;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.h0.o.a;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46218c = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.a.h0.o.a f46219a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.h0.o.b f46220b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f46221e;

        public a(PrefetchEvent prefetchEvent) {
            this.f46221e = prefetchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c(this.f46221e);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f46223a;

        public b(PrefetchEvent prefetchEvent) {
            this.f46223a = prefetchEvent;
        }

        @Override // d.a.m0.a.h0.o.a.e
        public void a(d.a.m0.a.v1.c.f.c cVar, PMSAppInfo pMSAppInfo) {
            d.this.f46220b.b(this.f46223a, cVar, pMSAppInfo);
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final d f46225a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d e() {
        return c.f46225a;
    }

    public final void c(PrefetchEvent prefetchEvent) {
        this.f46219a.g(prefetchEvent, new b(prefetchEvent));
    }

    public void d(PrefetchEvent prefetchEvent) {
        if (f46218c) {
            Log.d("SwanAppPrefetchManager", "fire preloadEvent abSwitch: " + d.a.m0.a.h0.o.e.a.f());
        }
        if (f(prefetchEvent)) {
            return;
        }
        if (f46218c) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
        }
        ExecutorUtilsExt.postOnSerial(new a(prefetchEvent), "prefetch-event-thread");
    }

    public final boolean f(PrefetchEvent prefetchEvent) {
        return (d.a.m0.a.h0.o.e.a.f() && prefetchEvent != null && prefetchEvent.f() && TextUtils.equals(prefetchEvent.state, "show")) ? false : true;
    }

    public d() {
        this.f46219a = new d.a.m0.a.h0.o.a();
        this.f46220b = new d.a.m0.a.h0.o.b();
    }
}
