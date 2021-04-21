package d.b.h0.a.e0.q;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import d.b.h0.a.k;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44967b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public c f44968a = c.f44969a;

    public void a(@NonNull PrefetchEvent prefetchEvent) {
        d.b.h0.a.n1.c.f.c c2 = a.c(prefetchEvent);
        if (c2 == null) {
            return;
        }
        if ((c2.x() && TextUtils.equals(c2.f46113g, prefetchEvent.appId)) || c2.C()) {
            b(c2, prefetchEvent, null);
        }
    }

    public final void b(@NonNull d.b.h0.a.n1.c.f.c cVar, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
        bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
        if (pMSAppInfo == null) {
            pMSAppInfo = d.b.h0.l.i.a.h().r(prefetchEvent.appId);
        }
        if (pMSAppInfo == null) {
            return;
        }
        bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
        if (this.f44968a.a(prefetchEvent, pMSAppInfo, bundle)) {
            d.b.h0.a.n1.c.a e2 = d.b.h0.a.n1.c.a.e();
            d.b.h0.a.n1.c.c cVar2 = new d.b.h0.a.n1.c.c(120, bundle);
            cVar2.b(cVar.f46112f);
            cVar2.p(true);
            e2.h(cVar2);
        }
    }

    public void c(@NonNull PrefetchEvent prefetchEvent, @NonNull d.b.h0.a.n1.c.f.c cVar, @Nullable PMSAppInfo pMSAppInfo) {
        b(cVar, prefetchEvent, pMSAppInfo);
        cVar.S(prefetchEvent);
        if (f44967b) {
            Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
            Log.d("PrefetchMessenger", "onPrefetchReady client id: " + cVar.f46112f.index);
        }
    }
}
