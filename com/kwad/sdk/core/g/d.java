package com.kwad.sdk.core.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.SdkConfigData;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f33965a = false;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f33966b = false;

    /* renamed from: c  reason: collision with root package name */
    public static Context f33967c;

    /* renamed from: d  reason: collision with root package name */
    public static a f33968d;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(@NonNull SdkConfigData sdkConfigData);
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.kwad.sdk.core.config.c.a(d.f33967c);
            if (d.f33968d != null) {
                d.f33968d.a();
            }
            if (!d.f33965a) {
                com.kwad.sdk.core.report.e.a(d.f33967c);
                boolean unused = d.f33965a = true;
            }
            d.a();
        }
    }

    public static void a() {
        com.kwad.sdk.core.d.a.a("ConfigRequestManager", "load()");
        new com.kwad.sdk.core.network.i<c, SdkConfigData>() { // from class: com.kwad.sdk.core.g.d.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public SdkConfigData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                SdkConfigData sdkConfigData = new SdkConfigData();
                sdkConfigData.parseJson(jSONObject);
                try {
                    boolean p = com.kwad.sdk.core.config.c.p();
                    String o = com.kwad.sdk.core.config.c.o();
                    if (p && !TextUtils.isEmpty(o)) {
                        com.kwai.video.ksvodplayerkit.j.a(o);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.a.a(th);
                }
                return sdkConfigData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public c b() {
                return new c();
            }
        }.a(new com.kwad.sdk.core.network.j<c, SdkConfigData>() { // from class: com.kwad.sdk.core.g.d.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull c cVar) {
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onStartRequest request url = " + cVar.a());
                super.a((AnonymousClass2) cVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull c cVar, int i, String str) {
                super.a((AnonymousClass2) cVar, i, str);
                com.kwad.sdk.core.d.a.a("ConfigRequestManager", "onError");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull c cVar, @NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.b.a(d.f33967c);
                com.kwad.sdk.core.config.c.a(d.f33967c, sdkConfigData);
                if (d.f33968d != null) {
                    d.f33968d.a(sdkConfigData);
                }
            }
        });
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (d.class) {
            if (!f33966b) {
                f33967c = context;
                f33966b = true;
            }
            f33968d = aVar;
            com.kwad.sdk.utils.f.a(new b());
        }
    }
}
