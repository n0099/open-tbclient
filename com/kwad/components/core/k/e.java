package com.kwad.components.core.k;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.v;
import com.kwad.sdk.utils.w;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class e {
    public static volatile boolean HJ;
    public static volatile boolean HK;
    public static volatile boolean HL;
    public static final List<a> HM = new CopyOnWriteArrayList();
    public static Context ab;

    /* loaded from: classes8.dex */
    public interface a {
        void a(@NonNull SdkConfigData sdkConfigData);

        void no();
    }

    /* loaded from: classes8.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.core.config.d.aV(e.ab);
                e.access$102(true);
                for (a aVar : e.HM) {
                    if (aVar != null) {
                        aVar.no();
                    }
                }
                e.ok();
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
            }
        }
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (e.class) {
            if (HJ) {
                com.kwad.sdk.core.e.b.d("ConfigRequestManager", "config request manager has init-ed");
                return;
            }
            HJ = true;
            ab = context;
            w.f(context, w.cn(context) + 1);
            HM.add(aVar);
            com.kwad.sdk.utils.g.runOnDefaultExecutor(new b());
        }
    }

    public static void a(a aVar) {
        HM.add(aVar);
        if (HK) {
            aVar.no();
        }
        if (HL) {
            aVar.a(com.kwad.sdk.core.config.d.rZ());
        }
    }

    public static /* synthetic */ boolean access$102(boolean z) {
        HK = true;
        return true;
    }

    public static /* synthetic */ boolean av(boolean z) {
        HL = true;
        return true;
    }

    public static void ok() {
        com.kwad.sdk.core.e.b.d("ConfigRequestManager", "load()");
        new m<d, SdkConfigData>() { // from class: com.kwad.components.core.k.e.1
            @NonNull
            public static SdkConfigData au(String str) {
                w.N(e.ab, str);
                JSONObject jSONObject = new JSONObject(str);
                SdkConfigData sdkConfigData = new SdkConfigData();
                sdkConfigData.parseJson(jSONObject);
                try {
                    com.kwad.sdk.core.config.d.lt();
                    com.kwad.sdk.core.config.d.rH();
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.b.printStackTrace(th);
                }
                return sdkConfigData;
            }

            @NonNull
            public static d on() {
                return new d();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.g createRequest() {
                return on();
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return au(str);
            }
        }.request(new n<d, SdkConfigData>() { // from class: com.kwad.components.core.k.e.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull d dVar) {
                com.kwad.sdk.core.e.b.d("ConfigRequestManager", "onStartRequest request url = " + dVar.getUrl());
                super.onStartRequest(dVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull d dVar, int i, String str) {
                super.onError(dVar, i, str);
                com.kwad.sdk.core.e.b.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
            }

            public static void b(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.b.aT(e.ab);
                com.kwad.sdk.core.config.d.c(sdkConfigData);
                e.av(true);
                for (a aVar : e.HM) {
                    if (aVar != null) {
                        aVar.a(sdkConfigData);
                    }
                }
                if (sdkConfigData != null) {
                    com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
                }
                v.zu();
                v.zp();
                w.f(e.ab, 0);
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                b((SdkConfigData) baseResultData);
            }
        });
    }
}
