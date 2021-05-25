package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0364a {
        void a();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC0364a interfaceC0364a, @Nullable b bVar, boolean z) {
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        com.kwad.sdk.home.download.a.a().a(true);
        if (d.a(context, adTemplate, 1) == 1) {
            interfaceC0364a.a();
            return 0;
        } else if (!com.kwad.sdk.core.response.b.a.v(g2)) {
            AdWebViewActivityProxy.launch(context, adTemplate);
            interfaceC0364a.a();
            return 0;
        } else if (bVar != null) {
            int a2 = bVar.a(context, z);
            int i2 = g2.status;
            if (i2 != 2 && i2 != 3) {
                interfaceC0364a.a();
            }
            return a2;
        } else {
            return 0;
        }
    }

    public static void b(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC0364a interfaceC0364a, @Nullable b bVar, boolean z) {
        AdInfo g2 = com.kwad.sdk.core.response.b.c.g(adTemplate);
        if (an.a()) {
            return;
        }
        if (d.a(context, adTemplate, 1) == 1) {
            interfaceC0364a.a();
        } else if (!com.kwad.sdk.core.response.b.a.v(g2)) {
            if (com.kwad.sdk.core.response.b.a.L(g2)) {
                AdWebViewVideoActivityProxy.launch(context, adTemplate);
            } else {
                AdWebViewActivityProxy.launch(context, adTemplate);
            }
            interfaceC0364a.a();
        } else if (bVar != null) {
            if (!com.kwad.sdk.core.response.b.a.L(g2) || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.y(g2))) {
                bVar.a(context, z);
            } else if (!bVar.c()) {
                AdWebViewVideoActivityProxy.launch(context, adTemplate);
            }
            int i2 = g2.status;
            if (i2 == 2 || i2 == 3) {
                return;
            }
            interfaceC0364a.a();
        }
    }
}
