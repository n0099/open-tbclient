package d.a.i0.a.h0.o;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.h0.o.a;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42260c = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.a.h0.o.a f42261a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.h0.o.b f42262b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42263e;

        public a(PrefetchEvent prefetchEvent) {
            this.f42263e = prefetchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c(this.f42263e);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42265a;

        public b(PrefetchEvent prefetchEvent) {
            this.f42265a = prefetchEvent;
        }

        @Override // d.a.i0.a.h0.o.a.e
        public void a(d.a.i0.a.v1.c.f.c cVar, PMSAppInfo pMSAppInfo) {
            d.this.f42262b.b(this.f42265a, cVar, pMSAppInfo);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final d f42267a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d e() {
        return c.f42267a;
    }

    public final void c(PrefetchEvent prefetchEvent) {
        this.f42261a.g(prefetchEvent, new b(prefetchEvent));
    }

    public void d(PrefetchEvent prefetchEvent) {
        if (f42260c) {
            Log.d("SwanAppPrefetchManager", "fire preloadEvent abSwitch: " + d.a.i0.a.h0.o.e.a.f());
        }
        if (f(prefetchEvent)) {
            return;
        }
        if (f42260c) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
        }
        ExecutorUtilsExt.postOnSerial(new a(prefetchEvent), "prefetch-event-thread");
    }

    public final boolean f(PrefetchEvent prefetchEvent) {
        return (d.a.i0.a.h0.o.e.a.f() && prefetchEvent != null && prefetchEvent.f() && TextUtils.equals(prefetchEvent.state, "show")) ? false : true;
    }

    public d() {
        this.f42261a = new d.a.i0.a.h0.o.a();
        this.f42262b = new d.a.i0.a.h0.o.b();
    }
}
