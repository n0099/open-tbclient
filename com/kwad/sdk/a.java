package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.b.i;
import com.kwad.sdk.utils.af;
/* loaded from: classes6.dex */
public class a implements com.kwad.sdk.plugin.a {
    private void a(final Context context) {
        com.kwad.sdk.core.d.a.c("AdPluginImpl", "初次获取Gid: initGId");
        d.q.a.a.b.b().f(context, false, new d.q.a.a.d() { // from class: com.kwad.sdk.a.1
            @Override // d.q.a.a.d
            public void a(int i2, String str) {
                com.kwad.sdk.core.d.a.e("AdPluginImpl", "初次获取Gid: initGId onFailed errorCode:" + i2 + "errorMessage :" + str);
            }

            @Override // d.q.a.a.d
            public void a(String str, String str2) {
                com.kwad.sdk.core.b.e.a(context, str2);
                a.this.a(context, str);
            }
        });
    }

    @Override // com.kwad.sdk.plugin.d
    public Class a() {
        return com.kwad.sdk.plugin.a.class;
    }

    @Override // com.kwad.sdk.plugin.d
    public void a(Context context, SdkConfig sdkConfig) {
        try {
            a(context);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.e("AdPluginImpl", "AdPluginImpl initGId error : " + th);
        }
    }

    @Override // com.kwad.sdk.plugin.a
    public void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.equals(str, af.a(context))) {
            return;
        }
        af.d(context, str);
        try {
            d.q.a.a.b.b().j(context, str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.e("AdPluginImpl", "AdPluginImpl KWEGIDDFP setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.plugin.a
    public i b() {
        return new com.kwad.sdk.core.b.a();
    }
}
