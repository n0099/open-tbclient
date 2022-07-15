package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.collector.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.utils.av;
/* loaded from: classes5.dex */
public final class c {

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str);

        void a(AppStatusRules appStatusRules);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        d.a(context, new d.a() { // from class: com.kwad.sdk.collector.c.1
            @Override // com.kwad.sdk.collector.d.a
            public final void a() {
                c.b(context, aVar);
            }

            @Override // com.kwad.sdk.collector.d.a
            public final void a(String str) {
                com.kwad.sdk.core.d.b.e("AppStatusFetchConfigManager", "onLoadError: " + str);
            }
        });
    }

    public static void b(final Context context, final a aVar) {
        new l<com.kwad.sdk.collector.kwai.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.2
            @NonNull
            public static AppStatusRules a(String str) {
                return AppStatusRules.createFromJson(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.collector.kwai.a createRequest() {
                return new com.kwad.sdk.collector.kwai.a(av.o(context));
            }

            /* JADX DEBUG: Return type fixed from 'com.kwad.sdk.core.network.BaseResultData' to match base method */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ AppStatusRules parseData(String str) {
                return a(str);
            }
        }.request(new m<com.kwad.sdk.collector.kwai.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.c.3
            private void a(@NonNull AppStatusRules appStatusRules) {
                a aVar2 = a.this;
                if (aVar2 != null) {
                    aVar2.a(appStatusRules);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.sdk.collector.kwai.a aVar2) {
                super.onStartRequest(aVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.sdk.collector.kwai.a aVar2, int i, String str) {
                super.onError(aVar2, i, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(i, str);
                }
            }

            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                a((AppStatusRules) baseResultData);
            }
        });
    }
}
