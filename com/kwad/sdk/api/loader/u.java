package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.n;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class u {
    public static final AtomicBoolean SJ = new AtomicBoolean();

    public static void a(Context context, IKsAdSDK iKsAdSDK) {
        if (Math.abs(System.currentTimeMillis() - t.r(context, "lastUpdateTime")) >= t.r(context, "interval") * 1000 && !SJ.get()) {
            SJ.set(true);
            try {
                Object dM = iKsAdSDK.dM("TRANSFORM_API_HOST", "https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
                String obj = dM != null ? dM.toString() : "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
                Context context2 = Loader.get().getContext();
                new n.e(new n.g(new n.d(new n.h(new n.b(obj, iKsAdSDK), context2), context2), context2), context2).a(new n.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.kwad.sdk.api.loader.n.c
                    public final /* synthetic */ void c(Boolean bool) {
                        u.SJ.set(false);
                        new StringBuilder("checkAndUpdate onNewResult: ").append(bool);
                    }

                    @Override // com.kwad.sdk.api.loader.n.c
                    public final void g(Throwable th) {
                        u.SJ.set(false);
                        m.a("DynamicMonitor", "onFailure", th);
                    }
                });
            } catch (Throwable th) {
                SJ.set(false);
                m.a("DynamicMonitor", "onFailure", th);
            }
        }
    }
}
