package d.a.h0.a.e0.q;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.h0.a.e0.q.a;
import d.a.h0.a.k;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f42275c = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.a.e0.q.a f42276a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.e0.q.b f42277b;

    /* loaded from: classes2.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f42278a;

        public a(PrefetchEvent prefetchEvent) {
            this.f42278a = prefetchEvent;
        }

        @Override // d.a.h0.a.e0.q.a.e
        public void a(d.a.h0.a.n1.c.f.c cVar, PMSAppInfo pMSAppInfo) {
            d.this.f42277b.c(this.f42278a, cVar, pMSAppInfo);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f42280a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d c() {
        return b.f42280a;
    }

    public void b(PrefetchEvent prefetchEvent) {
        if (f42275c) {
            Log.d("SwanAppPrefetchManager", "fire preloadEvent abSwitch: " + d.a.h0.a.e0.q.e.a.c());
        }
        if (d(prefetchEvent)) {
            return;
        }
        if (f42275c) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
        }
        if (TextUtils.equals("show", prefetchEvent.state)) {
            this.f42276a.i(prefetchEvent, new a(prefetchEvent));
        } else {
            this.f42277b.a(prefetchEvent);
        }
    }

    public final boolean d(PrefetchEvent prefetchEvent) {
        return (d.a.h0.a.e0.q.e.a.c() && prefetchEvent != null && prefetchEvent.c()) ? false : true;
    }

    public d() {
        this.f42276a = new d.a.h0.a.e0.q.a();
        this.f42277b = new d.a.h0.a.e0.q.b();
    }
}
