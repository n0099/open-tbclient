package com.kwad.sdk.contentalliance.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.g.a.j;
import com.kwad.sdk.core.g.e;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.g.i;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f33220a = new AtomicBoolean(false);

    @Nullable
    public static com.kwai.video.ksvodplayerkit.d.b a(AdTemplate adTemplate, int i2) {
        if (adTemplate != null) {
            String l = com.kwad.sdk.core.response.b.c.l(adTemplate);
            if (ag.a(l)) {
                return null;
            }
            return new com.kwai.video.ksvodplayerkit.d.f(l, String.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)), i2);
        }
        return null;
    }

    public static void a(List<KsScene> list) {
        if (list == null || list.isEmpty() || f33220a.get()) {
            return;
        }
        f33220a.set(true);
        h.a aVar = new h.a();
        for (KsScene ksScene : list) {
            aVar.f34412a.add(new com.kwad.sdk.core.g.a.f(ksScene));
        }
        aVar.f34413b = new com.kwad.sdk.core.g.a.c();
        aVar.f34415d = new j(1);
        i.a(aVar, new e.a() { // from class: com.kwad.sdk.contentalliance.home.b.1
            @Override // com.kwad.sdk.core.g.e.a
            public void a(int i2, String str) {
                com.kwad.sdk.core.d.a.a("ContentPreloadManager", "PhotoRequestManager onError msg=" + str);
            }

            @Override // com.kwad.sdk.core.g.e.a
            public void a(@NonNull AdResultData adResultData) {
                com.kwad.sdk.core.d.a.a("ContentPreloadManager", "PhotoRequestManager onSuccess");
                if (adResultData.result != 1) {
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.f34499c;
                    a(fVar.k, fVar.l);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                for (AdTemplate adTemplate : adResultData.adTemplateList) {
                    if (adTemplate != null) {
                        arrayList.add(adTemplate);
                        if (!hashMap.containsKey(Long.valueOf(adTemplate.posId))) {
                            com.kwad.sdk.core.d.a.a("ContentPreloadManager", "posId = " + adTemplate.posId + " getAuthorName = " + com.kwad.sdk.core.response.b.c.v(adTemplate));
                            hashMap.put(Long.valueOf(adTemplate.posId), adTemplate);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f34499c;
                    a(fVar2.k, fVar2.l);
                    return;
                }
                com.kwad.sdk.core.d.a.a("ContentPreloadManager", "save");
                a.a().b();
                a.a().a(arrayList);
                com.kwad.sdk.core.report.e.a(arrayList);
                b.b(hashMap);
            }
        });
    }

    public static boolean a() {
        return com.kwad.sdk.core.video.a.e.b() && com.kwad.sdk.core.config.c.p() && com.kwad.sdk.core.config.c.ag() && b() && com.kwad.sdk.core.video.a.d.p();
    }

    public static void b(@NonNull Map<Long, AdTemplate> map) {
        if (a()) {
            c(map);
        }
    }

    public static boolean b() {
        if (com.kwad.sdk.core.config.c.ah() != 1) {
            return com.kwad.sdk.core.config.c.ah() == 2 && com.ksad.download.d.b.b(KsAdSDKImpl.get().getContext());
        }
        return true;
    }

    public static void c(@NonNull Map<Long, AdTemplate> map) {
        int i2 = 0;
        for (Long l : map.keySet()) {
            AdTemplate adTemplate = map.get(l);
            int i3 = i2 + 1;
            com.kwai.video.ksvodplayerkit.d.b a2 = a(adTemplate, 1000 - i2);
            if (a2 != null) {
                com.kwai.video.ksvodplayerkit.d.c.a().a(a2);
                com.kwad.sdk.core.d.a.a("ContentPreloadManager", "addPreloadTask " + com.kwad.sdk.core.response.b.c.v(adTemplate) + " key=" + l);
            }
            m.a(KsAdSDKImpl.get().getContext(), com.kwad.sdk.core.response.b.c.m(adTemplate).a());
            i2 = i3;
        }
    }
}
