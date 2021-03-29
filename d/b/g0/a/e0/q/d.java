package d.b.g0.a.e0.q;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.g0.a.e0.q.a;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44249c = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.a.e0.q.a f44250a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.e0.q.b f44251b;

    /* loaded from: classes2.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PrefetchEvent f44252a;

        public a(PrefetchEvent prefetchEvent) {
            this.f44252a = prefetchEvent;
        }

        @Override // d.b.g0.a.e0.q.a.e
        public void a(d.b.g0.a.n1.c.f.c cVar, PMSAppInfo pMSAppInfo) {
            d.this.f44251b.c(this.f44252a, cVar, pMSAppInfo);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f44254a = new d(null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d c() {
        return b.f44254a;
    }

    public void b(PrefetchEvent prefetchEvent) {
        if (f44249c) {
            Log.d("SwanAppPrefetchManager", "fire preloadEvent abSwitch: " + d.b.g0.a.e0.q.e.a.c());
        }
        if (d(prefetchEvent)) {
            return;
        }
        if (f44249c) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
        }
        if (TextUtils.equals("show", prefetchEvent.state)) {
            this.f44250a.i(prefetchEvent, new a(prefetchEvent));
        } else {
            this.f44251b.a(prefetchEvent);
        }
    }

    public final boolean d(PrefetchEvent prefetchEvent) {
        return (d.b.g0.a.e0.q.e.a.c() && prefetchEvent != null && prefetchEvent.c()) ? false : true;
    }

    public d() {
        this.f44250a = new d.b.g0.a.e0.q.a();
        this.f44251b = new d.b.g0.a.e0.q.b();
    }
}
