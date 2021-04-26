package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.utils.AppStatusHelper;
/* loaded from: classes6.dex */
public class b {

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i2, String str);

        void a(AppStatusRules appStatusRules);
    }

    public static void a(final Context context, final a aVar) {
        if (context == null) {
            return;
        }
        new com.kwad.sdk.core.network.i<com.kwad.sdk.collector.b.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AppStatusRules b(String str) {
                return AppStatusRules.createFromJson(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.collector.b.a b() {
                return new com.kwad.sdk.collector.b.a(AppStatusHelper.b(context));
            }
        }.a(new j<com.kwad.sdk.collector.b.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.b.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.a aVar2) {
                super.a((AnonymousClass2) aVar2);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.a aVar2, int i2, String str) {
                super.a((AnonymousClass2) aVar2, i2, str);
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.b.a aVar2, @NonNull AppStatusRules appStatusRules) {
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(appStatusRules);
                }
            }
        });
    }
}
