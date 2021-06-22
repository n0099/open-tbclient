package d.a.m0.a.h0.o;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46215b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public c f46216a = c.f46217a;

    public final void a(@NonNull d.a.m0.a.v1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
        bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
        if (pMSAppInfo == null) {
            pMSAppInfo = d.a.m0.n.g.a.h().s(prefetchEvent.appId);
        }
        if (pMSAppInfo == null) {
            return;
        }
        bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
        if (this.f46216a.a(prefetchEvent, pMSAppInfo, bundle)) {
            d.a.m0.a.v1.c.a e2 = d.a.m0.a.v1.c.a.e();
            d.a.m0.a.v1.c.c cVar2 = new d.a.m0.a.v1.c.c(120, bundle);
            cVar2.b(cVar.f49113f);
            cVar2.p(false);
            e2.h(cVar2);
        }
    }

    public void b(@NonNull PrefetchEvent prefetchEvent, @NonNull d.a.m0.a.v1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo) {
        a(cVar, prefetchEvent, pMSAppInfo);
        cVar.X(prefetchEvent);
        if (f46215b) {
            Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
            Log.d("PrefetchMessenger", "onPrefetchReady client id: " + cVar.f49113f.index);
        }
    }
}
