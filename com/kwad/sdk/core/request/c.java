package com.kwad.sdk.core.request;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f39741b;

    /* renamed from: c  reason: collision with root package name */
    public static Context f39742c;

    /* renamed from: d  reason: collision with root package name */
    public static a f39743d;

    /* loaded from: classes7.dex */
    public interface a {
        void a();

        void a(@NonNull SdkConfigData sdkConfigData);
    }

    /* loaded from: classes7.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.config.b.b(c.f39742c);
            if (c.f39743d != null) {
                c.f39743d.a();
            }
            if (!c.a) {
                com.kwad.sdk.core.report.d.b(c.f39742c);
                boolean unused = c.a = true;
            }
            c.a();
        }
    }

    public static void a() {
        com.kwad.sdk.core.d.a.a("ConfigRequestManager", "load()");
        new i<com.kwad.sdk.core.request.b, SdkConfigData>() { // from class: com.kwad.sdk.core.request.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.request.b b() {
                return new com.kwad.sdk.core.request.b();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public SdkConfigData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                SdkConfigData sdkConfigData = new SdkConfigData();
                sdkConfigData.parseJson(jSONObject);
                try {
                    boolean h2 = com.kwad.sdk.core.config.b.h();
                    String g2 = com.kwad.sdk.core.config.b.g();
                    if (h2 && !TextUtils.isEmpty(g2)) {
                        KSVodPlayerCoreInitConfig.updatePlayerConfig(g2);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.a(th);
                }
                return sdkConfigData;
            }
        }.a(new j<com.kwad.sdk.core.request.b, SdkConfigData>() { // from class: com.kwad.sdk.core.request.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.b bVar) {
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onStartRequest request url = " + bVar.a());
                super.a((AnonymousClass2) bVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.b bVar, int i, String str) {
                super.a((AnonymousClass2) bVar, i, str);
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.b bVar, @NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.a.a(c.f39742c);
                com.kwad.sdk.core.config.b.a(sdkConfigData);
                com.kwad.sdk.core.config.b.a(c.f39742c, sdkConfigData);
                if (c.f39743d != null) {
                    c.f39743d.a(sdkConfigData);
                }
            }
        });
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (c.class) {
            if (f39741b) {
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "config request manager has init-ed");
                return;
            }
            f39741b = true;
            f39742c = context;
            f39743d = aVar;
            com.kwad.sdk.utils.i.a(new b());
        }
    }
}
