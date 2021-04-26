package com.kwad.sdk.core.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.f;
import com.kwai.video.ksvodplayerkit.KSVodPlayerCoreInitConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33095a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f33096b = false;

    /* renamed from: c  reason: collision with root package name */
    public static Context f33097c;

    /* renamed from: d  reason: collision with root package name */
    public static a f33098d;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(@NonNull SdkConfigData sdkConfigData);
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.config.c.a(c.f33097c);
            if (c.f33098d != null) {
                c.f33098d.a();
            }
            if (!c.f33095a) {
                e.b(c.f33097c);
                boolean unused = c.f33095a = true;
            }
            c.a();
        }
    }

    public static void a() {
        com.kwad.sdk.core.d.a.a("ConfigRequestManager", "load()");
        new i<com.kwad.sdk.core.g.b, SdkConfigData>() { // from class: com.kwad.sdk.core.g.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.g.b b() {
                return new com.kwad.sdk.core.g.b();
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
                    boolean g2 = com.kwad.sdk.core.config.c.g();
                    String f2 = com.kwad.sdk.core.config.c.f();
                    if (g2 && !TextUtils.isEmpty(f2)) {
                        KSVodPlayerCoreInitConfig.updatePlayerConfig(f2);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.a(th);
                }
                return sdkConfigData;
            }
        }.a(new j<com.kwad.sdk.core.g.b, SdkConfigData>() { // from class: com.kwad.sdk.core.g.c.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.b bVar) {
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onStartRequest request url = " + bVar.a());
                super.a((AnonymousClass2) bVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.b bVar, int i2, String str) {
                super.a((AnonymousClass2) bVar, i2, str);
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.b bVar, @NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.b.a(c.f33097c);
                com.kwad.sdk.core.config.c.a(c.f33097c, sdkConfigData);
                if (c.f33098d != null) {
                    c.f33098d.a(sdkConfigData);
                }
            }
        });
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (c.class) {
            if (f33096b) {
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "config request manager has init-ed");
                return;
            }
            f33096b = true;
            f33097c = context;
            f33098d = aVar;
            f.a(new b());
        }
    }
}
