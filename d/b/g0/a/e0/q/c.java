package d.b.g0.a.e0.q;

import android.os.Bundle;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes3.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f44247a = new a();

    /* loaded from: classes3.dex */
    public static class a implements c {
        @Override // d.b.g0.a.e0.q.c
        public boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle) {
            if (d.b.g0.a.e0.q.e.a.c()) {
                bundle.putString("swan_app_prefetch_event_name", b(prefetchEvent, pMSAppInfo) ? "prefetch" : "preload");
                return true;
            }
            return false;
        }

        public final boolean b(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
            return false;
        }
    }

    boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle);
}
