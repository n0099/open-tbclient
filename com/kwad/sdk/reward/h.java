package com.kwad.sdk.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public class h {
    public volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.network.i<i, BaseResultData> f55842b;

    /* loaded from: classes8.dex */
    public static class a {
        public static h a = new h();
    }

    public h() {
        this.a = false;
    }

    public static h a() {
        return a.a;
    }

    private void b(final AdTemplate adTemplate) {
        if (this.a) {
            return;
        }
        this.a = true;
        com.kwad.sdk.core.network.i<i, BaseResultData> iVar = new com.kwad.sdk.core.network.i<i, BaseResultData>() { // from class: com.kwad.sdk.reward.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public i b() {
                return new i(adTemplate);
            }

            @Override // com.kwad.sdk.core.network.i
            @NonNull
            public BaseResultData b(String str) {
                return new BaseResultData() { // from class: com.kwad.sdk.reward.RewardCallbackVerifyHelper$1$1
                };
            }
        };
        this.f55842b = iVar;
        iVar.a(new com.kwad.sdk.core.network.j<i, BaseResultData>() { // from class: com.kwad.sdk.reward.h.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull i iVar2, int i2, String str) {
                super.a((AnonymousClass2) iVar2, i2, str);
                h.this.a = false;
                com.kwad.sdk.core.d.a.c("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull i iVar2, @NonNull BaseResultData baseResultData) {
                super.a((AnonymousClass2) iVar2, (i) baseResultData);
                h.this.a = false;
                com.kwad.sdk.core.d.a.c("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }
        });
    }

    public void a(AdTemplate adTemplate) {
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.ar(j2))) {
            m.a(adTemplate, j2);
        } else {
            b(adTemplate);
        }
    }

    public void b() {
        com.kwad.sdk.core.network.i<i, BaseResultData> iVar = this.f55842b;
        if (iVar != null) {
            iVar.e();
        }
    }
}
