package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.loader.m;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class u {
    public static final AtomicBoolean amH = new AtomicBoolean();

    public static /* synthetic */ String access$000() {
        return zq();
    }

    public static String zq() {
        String bR = com.kwad.sdk.api.c.bR("https://open.e.kuaishou.com/rest/e/v3/open/sdk2");
        if (TextUtils.isEmpty(bR)) {
            return "https://open.e.kuaishou.com/rest/e/v3/open/sdk2";
        }
        return bR;
    }

    public static void a(final Context context, final IKsAdSDK iKsAdSDK) {
        if (!com.kwad.sdk.api.c.zd() && !amH.get() && context != null && iKsAdSDK != null) {
            amH.set(true);
            com.kwad.sdk.api.a.a.submit(new Runnable() { // from class: com.kwad.sdk.api.loader.u.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (Math.abs(System.currentTimeMillis() - t.x(context, "lastUpdateTime")) < t.x(context, "interval") * 1000) {
                            return;
                        }
                        m.zo().a(new v() { // from class: com.kwad.sdk.api.loader.u.1.1
                            @Override // com.kwad.sdk.api.loader.v
                            public final Context getContext() {
                                return context;
                            }

                            @Override // com.kwad.sdk.api.loader.v
                            public final String zr() {
                                return u.access$000();
                            }

                            @Override // com.kwad.sdk.api.loader.v
                            public final IKsAdSDK zs() {
                                return iKsAdSDK;
                            }
                        }, new m.c<Boolean>() { // from class: com.kwad.sdk.api.loader.u.1.2
                            public static void c(Boolean bool) {
                                new StringBuilder("onNewResult: ").append(bool);
                            }

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.kwad.sdk.api.loader.m.c
                            public final /* synthetic */ void g(Boolean bool) {
                                c(bool);
                            }
                        });
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public static void aE(Context context) {
        g.m(context, "");
    }
}
