package com.kwad.sdk.contentalliance;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.b.i;
import com.kwad.sdk.core.config.c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.ah;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d implements com.kwad.sdk.plugin.b {
    private void a(@NonNull List<com.kwad.sdk.core.response.model.b> list) {
        if (com.kwad.sdk.core.config.c.m()) {
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.core.response.model.b bVar : list) {
                if (bVar != null && bVar.f34364c) {
                    arrayList.add(new KsScene.Builder(bVar.f34362a).build());
                }
            }
            com.kwad.sdk.contentalliance.home.b.a(arrayList);
        }
    }

    private void b(final Context context) {
        com.kwad.sdk.core.d.a.b("ContentPluginImpl", "初次获取Gid: initGId");
        d.q.a.a.b.c().g(context, true, new d.q.a.a.d() { // from class: com.kwad.sdk.contentalliance.d.1
            @Override // d.q.a.a.d
            public void a(int i, String str) {
                com.kwad.sdk.core.d.a.d("ContentPluginImpl", "初次获取Gid: initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            @Override // d.q.a.a.d
            public void a(String str, String str2) {
                com.kwad.sdk.core.b.e.a(context, str2);
                d.this.a(context, str);
            }
        });
    }

    private void c() {
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || ah.m(context).endsWith(":filedownloader")) {
            return;
        }
        com.kwad.sdk.emotion.a.d.a().a(com.kwad.sdk.emotion.model.a.a().a(ad.a(KsAdSDKImpl.get().getContext())).a(), new com.kwad.sdk.emotion.model.b() { // from class: com.kwad.sdk.contentalliance.d.2
        });
    }

    @Override // com.kwad.sdk.plugin.b
    public i a() {
        return new com.kwad.sdk.core.b.a();
    }

    @Override // com.kwad.sdk.plugin.b
    public void a(Context context) {
        com.kwad.sdk.contentalliance.detail.photo.newui.d.c.a().a(context);
    }

    @Override // com.kwad.sdk.plugin.e
    public void a(Context context, SdkConfig sdkConfig) {
        try {
            b(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.d("ContentPluginImpl", "ContentPluginImpl initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.plugin.b
    public void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.equals(str, ae.e(context))) {
            return;
        }
        ae.d(context, str);
        try {
            d.q.a.a.b.c().k(context, str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.d("ContentPluginImpl", "ContentPluginImpl KWEGIDDFP setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.plugin.b
    public void a(@NonNull SdkConfigData sdkConfigData) {
        List<com.kwad.sdk.core.response.model.b> b2 = c.a.aa.b();
        if (b2 != null) {
            a(b2);
        }
        if (com.kwad.sdk.core.config.c.L()) {
            c();
        }
    }

    @Override // com.kwad.sdk.plugin.e
    public Class b() {
        return com.kwad.sdk.plugin.b.class;
    }
}
