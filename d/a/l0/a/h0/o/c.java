package d.a.l0.a.h0.o;

import android.os.Bundle;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes2.dex */
public interface c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f42433a = new a();

    /* loaded from: classes2.dex */
    public static class a implements c {
        @Override // d.a.l0.a.h0.o.c
        public boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle) {
            return pMSAppInfo != null && pMSAppInfo.appCategory == 0;
        }
    }

    boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle);
}
