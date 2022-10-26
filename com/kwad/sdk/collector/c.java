package com.kwad.sdk.collector;

import android.content.Context;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.utils.az;
/* loaded from: classes7.dex */
public final class c {

    /* loaded from: classes7.dex */
    public interface a {
        void b(AppStatusRules appStatusRules);

        void g(int i, String str);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void bg(String str) {
                com.kwad.sdk.core.e.b.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void onLoaded() {
                c.b(context, aVar);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new m() { // from class: com.kwad.sdk.collector.c.2
            public static AppStatusRules bh(String str) {
                return AppStatusRules.createFromJson(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* renamed from: rq */
            public com.kwad.sdk.collector.kwai.a createRequest() {
                return new com.kwad.sdk.collector.kwai.a(az.dx(context));
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bh(str);
            }
        }.request(new n() { // from class: com.kwad.sdk.collector.c.3
            private void a(AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.b(appStatusRules);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(com.kwad.sdk.collector.kwai.a aVar2) {
                super.onStartRequest(aVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(com.kwad.sdk.collector.kwai.a aVar2, int i, String str) {
                super.onError(aVar2, i, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.g(i, str);
                }
            }

            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.g gVar, BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }
        });
    }
}
