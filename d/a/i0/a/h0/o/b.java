package d.a.i0.a.h0.o;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f42257b = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public c f42258a = c.f42259a;

    public final void a(@NonNull d.a.i0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
        bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
        if (pMSAppInfo == null) {
            pMSAppInfo = d.a.i0.n.g.a.h().s(prefetchEvent.appId);
        }
        if (pMSAppInfo == null) {
            return;
        }
        bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
        if (this.f42258a.a(prefetchEvent, pMSAppInfo, bundle)) {
            d.a.i0.a.v1.c.a e2 = d.a.i0.a.v1.c.a.e();
            d.a.i0.a.v1.c.c cVar2 = new d.a.i0.a.v1.c.c(120, bundle);
            cVar2.b(cVar.f45155f);
            cVar2.p(false);
            e2.h(cVar2);
        }
    }

    public void b(@NonNull PrefetchEvent prefetchEvent, @NonNull d.a.i0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo) {
        a(cVar, prefetchEvent, pMSAppInfo);
        cVar.X(prefetchEvent);
        if (f42257b) {
            Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
            Log.d("PrefetchMessenger", "onPrefetchReady client id: " + cVar.f45155f.index);
        }
    }
}
