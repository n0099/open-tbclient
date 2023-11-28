package com.kwad.components.core.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class g {
    public static volatile boolean Ri;
    public static volatile boolean Rj;
    public static final List<a> Rk = new CopyOnWriteArrayList();

    /* loaded from: classes10.dex */
    public interface a {
        void a(@NonNull SdkConfigData sdkConfigData);

        void qi();
    }

    public static boolean isLoaded() {
        return com.kwad.sdk.core.config.d.isLoaded();
    }

    public static void qg() {
        com.kwad.sdk.core.e.c.d("ConfigRequestManager", "load()");
        new l<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.3
            @NonNull
            public static f qj() {
                return new f();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.f createRequest() {
                return qj();
            }

            @NonNull
            public static SdkConfigData ap(String str) {
                y.aj(ServiceProvider.Jn(), str);
                JSONObject jSONObject = new JSONObject(str);
                SdkConfigData sdkConfigData = new SdkConfigData();
                sdkConfigData.parseJson(jSONObject);
                try {
                    com.kwad.sdk.core.config.d.yf();
                    com.kwad.sdk.core.config.d.Aw();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
                return sdkConfigData;
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.response.model.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return ap(str);
            }
        }.request(new o<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull f fVar) {
                com.kwad.sdk.core.e.c.d("ConfigRequestManager", "onStartRequest request url = " + fVar.getUrl());
                super.onStartRequest(fVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull f fVar, int i, String str) {
                super.onError(fVar, i, str);
                com.kwad.sdk.core.e.c.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
            }

            public static void b(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.b.aP(ServiceProvider.Jn());
                com.kwad.sdk.core.config.d.c(sdkConfigData);
                g.access$102(true);
                for (a aVar : g.Rk) {
                    if (aVar != null) {
                        aVar.a(sdkConfigData);
                    }
                }
                if (sdkConfigData != null) {
                    com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
                }
                x.JY();
                x.JS();
                y.k(ServiceProvider.Jn(), 0);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                b((SdkConfigData) baseResultData);
            }
        });
    }

    public static synchronized void a(a aVar) {
        synchronized (g.class) {
            if (Ri) {
                com.kwad.sdk.core.e.c.d("ConfigRequestManager", "config request manager has init-ed");
                return;
            }
            Ri = true;
            Rk.add(aVar);
            Rk.add(new a() { // from class: com.kwad.components.core.request.g.1
                @Override // com.kwad.components.core.request.g.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                }

                @Override // com.kwad.components.core.request.g.a
                public final void qi() {
                    try {
                        Map<String, String> parseJSON2MapString = u.parseJSON2MapString(com.kwad.sdk.core.config.c.aqI.getValue());
                        for (String str : parseJSON2MapString.keySet()) {
                            GlobalThreadPools.r(str, Integer.parseInt(parseJSON2MapString.get(str)));
                        }
                        GlobalThreadPools.Er();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.e.c.printStackTrace(th);
                    }
                }
            });
            com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.core.request.g.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    Context Jn = ServiceProvider.Jn();
                    y.k(Jn, y.cb(Jn) + 1);
                    com.kwad.sdk.core.config.d.aR(Jn);
                    for (a aVar2 : g.Rk) {
                        if (aVar2 != null) {
                            aVar2.qi();
                        }
                    }
                    g.qg();
                }
            });
        }
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        Rj = true;
        return true;
    }

    public static void b(a aVar) {
        Rk.add(aVar);
        if (isLoaded()) {
            aVar.qi();
        }
        if (Rj) {
            aVar.a(com.kwad.sdk.core.config.d.AR());
        }
    }
}
