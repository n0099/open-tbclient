package com.kwad.sdk.core.g;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f34149a = new Handler(Looper.getMainLooper());

    /* loaded from: classes6.dex */
    public interface a {
        @MainThread
        void a(int i, String str);

        @MainThread
        void a(long j, AdTemplate adTemplate);
    }

    public static void a(final long j, final com.kwad.sdk.core.g.a.f fVar, final com.kwad.sdk.core.g.a.l lVar, final a aVar) {
        new com.kwad.sdk.core.network.i<com.kwad.sdk.core.g.a, AdResultData>() { // from class: com.kwad.sdk.core.g.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AdResultData b(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(com.kwad.sdk.core.g.a.f.this.f34035a);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: c */
            public com.kwad.sdk.core.g.a b() {
                return new com.kwad.sdk.core.g.a(com.kwad.sdk.core.g.a.f.this, lVar);
            }
        }.a(new com.kwad.sdk.core.network.j<com.kwad.sdk.core.g.a, AdResultData>() { // from class: com.kwad.sdk.core.g.f.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.a aVar2, final int i, final String str) {
                f.f34149a.post(new Runnable() { // from class: com.kwad.sdk.core.g.f.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.kwad.sdk.core.d.a.c("PatchAdRequestManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        a.this.a(i, str);
                    }
                });
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.core.g.a aVar2, @NonNull final AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty()) {
                    f.f34149a.post(new Runnable() { // from class: com.kwad.sdk.core.g.f.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            a.this.a(j, adResultData.adTemplateList.get(0));
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.f34255c;
                a(aVar2, fVar2.k, fVar2.l);
            }
        });
    }
}
