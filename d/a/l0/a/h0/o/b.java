package d.a.l0.a.h0.o;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.l0.a.k;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46107b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public c f46108a = c.f46109a;

    public final void a(@NonNull d.a.l0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
        bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
        if (pMSAppInfo == null) {
            pMSAppInfo = d.a.l0.n.g.a.h().s(prefetchEvent.appId);
        }
        if (pMSAppInfo == null) {
            return;
        }
        bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
        if (this.f46108a.a(prefetchEvent, pMSAppInfo, bundle)) {
            d.a.l0.a.v1.c.a e2 = d.a.l0.a.v1.c.a.e();
            d.a.l0.a.v1.c.c cVar2 = new d.a.l0.a.v1.c.c(120, bundle);
            cVar2.b(cVar.f49005f);
            cVar2.p(false);
            e2.h(cVar2);
        }
    }

    public void b(@NonNull PrefetchEvent prefetchEvent, @NonNull d.a.l0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo) {
        a(cVar, prefetchEvent, pMSAppInfo);
        cVar.X(prefetchEvent);
        if (f46107b) {
            Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
            Log.d("PrefetchMessenger", "onPrefetchReady client id: " + cVar.f49005f.index);
        }
    }
}
