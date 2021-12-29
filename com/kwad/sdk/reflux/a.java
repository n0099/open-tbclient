package com.kwad.sdk.reflux;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.request.d;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.request.model.j;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.ax;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static int a = 12;

    /* renamed from: com.kwad.sdk.reflux.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2114a {
        void a(int i2, String str);

        void a(@Nullable List<AdTemplate> list);

        void a_(int i2);
    }

    public static void a(final f fVar, final List<String> list, final boolean z, final boolean z2, @Nullable final j jVar, @NonNull final d.a aVar, final boolean z3) {
        new i<com.kwad.sdk.core.request.a, AdResultData>() { // from class: com.kwad.sdk.reflux.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.core.request.a b() {
                com.kwad.sdk.core.request.a aVar2 = new com.kwad.sdk.core.request.a(f.this, list, z, null, jVar);
                aVar2.a(z2 ? 1 : 0);
                return aVar2;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(f.this.a);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }
        }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.request.a, AdResultData>() { // from class: com.kwad.sdk.reflux.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.a aVar2, int i2, String str) {
                aVar.a(i2, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.request.a aVar2, @NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || z3) {
                    aVar.a(adResultData);
                    return;
                }
                d.a aVar3 = aVar;
                com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f58091e;
                aVar3.a(fVar2.n, fVar2.o);
            }
        });
    }

    public static void a(@NonNull SceneImpl sceneImpl, final InterfaceC2114a interfaceC2114a) {
        boolean a2 = ap.a().a(sceneImpl, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        sceneImpl.setAdStyle(11);
        sceneImpl.setAdNum(a);
        a(new f(sceneImpl), null, false, a2, null, new d.a() { // from class: com.kwad.sdk.reflux.a.1
            @Override // com.kwad.sdk.core.request.d.a
            public void a(final int i2, final String str) {
                ax.a(new Runnable() { // from class: com.kwad.sdk.reflux.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.e("RefluxAdLoadManager", "loadRefluxAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        InterfaceC2114a.this.a(i2, str);
                    }
                });
            }

            @Override // com.kwad.sdk.core.request.d.a
            public void a(@NonNull final AdResultData adResultData) {
                ax.a(new Runnable() { // from class: com.kwad.sdk.reflux.a.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            InterfaceC2114a.this.a_(adResultData.adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.a.b(th);
                        }
                    }
                });
                ax.a(new Runnable() { // from class: com.kwad.sdk.reflux.a.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC2114a.this.a(adResultData.adTemplateList);
                        a.b(adResultData, elapsedRealtime);
                    }
                });
            }
        }, false);
    }

    public static void b(AdResultData adResultData, long j2) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.adTemplateList.size() <= 0 || (adTemplate = adResultData.adTemplateList.get(0)) == null) {
            return;
        }
        com.kwad.sdk.core.report.d.a(adTemplate, elapsedRealtime - j2);
    }
}
