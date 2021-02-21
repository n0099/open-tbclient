package com.kwad.sdk.core.download.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.download.DOWNLOADSTAUS;
import com.kwad.sdk.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.core.page.AdWebViewVideoActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: com.kwad.sdk.core.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1094a {
        void a();
    }

    public static void a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC1094a interfaceC1094a, @Nullable b bVar) {
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        com.kwad.sdk.home.download.a.a().a(true);
        if (d.a(context, adTemplate, 1) == 1) {
            interfaceC1094a.a();
        } else if (!com.kwad.sdk.core.response.b.a.y(j)) {
            AdWebViewActivityProxy.launch(context, adTemplate);
            interfaceC1094a.a();
        } else if (bVar != null) {
            bVar.a(context);
            if (j.status == DOWNLOADSTAUS.DOWNLOADING || j.status == DOWNLOADSTAUS.PROGRESS) {
                return;
            }
            interfaceC1094a.a();
        }
    }

    public static void b(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull InterfaceC1094a interfaceC1094a, @Nullable b bVar) {
        AdInfo j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        if (ao.a()) {
            return;
        }
        if (d.a(context, adTemplate, 1) == 1) {
            interfaceC1094a.a();
        } else if (!com.kwad.sdk.core.response.b.a.y(j)) {
            if (com.kwad.sdk.core.response.b.a.P(j)) {
                AdWebViewVideoActivityProxy.launch(context, adTemplate);
            } else {
                AdWebViewActivityProxy.launch(context, adTemplate);
            }
            interfaceC1094a.a();
        } else if (bVar != null) {
            if (!com.kwad.sdk.core.response.b.a.P(j) || TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.B(j))) {
                bVar.a(context);
            } else if (!bVar.c()) {
                AdWebViewVideoActivityProxy.launch(context, adTemplate);
            }
            if (j.status == DOWNLOADSTAUS.DOWNLOADING || j.status == DOWNLOADSTAUS.PROGRESS) {
                return;
            }
            interfaceC1094a.a();
        }
    }
}
