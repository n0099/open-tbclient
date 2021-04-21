package com.kwad.sdk.core.g;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.g.e;
import com.kwad.sdk.core.g.h;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i {

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a(int i, String str);

        @MainThread
        void a(@NonNull List<AdTemplate> list);
    }

    public static void a(@NonNull final h.a aVar, @NonNull final e.a aVar2) {
        new com.kwad.sdk.core.network.i<h, AdResultData>() { // from class: com.kwad.sdk.core.g.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.core.g.a.f fVar : h.a.this.f34169a) {
                    arrayList.add(fVar.f34035a);
                }
                AdResultData adResultData = new AdResultData(arrayList);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public h b() {
                return new h(h.a.this);
            }
        }.a(new com.kwad.sdk.core.network.j<h, AdResultData>() { // from class: com.kwad.sdk.core.g.i.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull h hVar, int i, String str) {
                e.a.this.a(i, str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull h hVar, @NonNull AdResultData adResultData) {
                e.a.this.a(adResultData);
            }
        });
    }
}
