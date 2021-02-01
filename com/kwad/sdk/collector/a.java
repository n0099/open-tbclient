package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.i;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.utils.AppStatusHelper;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.collector.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1072a {
        void a(int i, String str);

        void a(AppStatusRules appStatusRules);
    }

    public static void a(final Context context, final InterfaceC1072a interfaceC1072a) {
        if (context == null) {
            return;
        }
        new i<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.a.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.i
            @NonNull
            /* renamed from: a */
            public AppStatusRules b(String str) {
                return AppStatusRules.createFromJson(str);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public com.kwad.sdk.collector.a.a b() {
                return new com.kwad.sdk.collector.a.a(AppStatusHelper.b(context));
            }
        }.a(new j<com.kwad.sdk.collector.a.a, AppStatusRules>() { // from class: com.kwad.sdk.collector.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.a.a aVar) {
                super.a((AnonymousClass2) aVar);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.a.a aVar, int i, String str) {
                super.a((AnonymousClass2) aVar, i, str);
                if (InterfaceC1072a.this != null) {
                    InterfaceC1072a.this.a(i, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.network.j, com.kwad.sdk.core.network.h
            public void a(@NonNull com.kwad.sdk.collector.a.a aVar, @NonNull AppStatusRules appStatusRules) {
                if (InterfaceC1072a.this != null) {
                    InterfaceC1072a.this.a(appStatusRules);
                }
            }
        });
    }
}
