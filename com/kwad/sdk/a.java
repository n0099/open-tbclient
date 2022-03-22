package com.kwad.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.core.a.i;
import com.kwad.sdk.utils.as;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import com.yxcorp.kuaishou.addfp.ResponseDfpCallback;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.plugin.a {
    private void a(final Context context) {
        com.kwad.sdk.core.d.a.c("AdPluginImpl", "初次获取Gid: initGId");
        KWEGIDDFP.instance().getEGidByCallback(context, false, new ResponseDfpCallback() { // from class: com.kwad.sdk.a.1
            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public void onFailed(int i, String str) {
                com.kwad.sdk.core.d.a.e("AdPluginImpl", "初次获取Gid: initGId onFailed errorCode:" + i + "errorMessage :" + str);
            }

            @Override // com.yxcorp.kuaishou.addfp.ResponseDfpCallback
            public void onSuccess(String str, String str2) {
                com.kwad.sdk.core.a.e.a(context, str2);
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
        if (context == null || TextUtils.isEmpty(str) || TextUtils.equals(str, as.a(context))) {
            return;
        }
        as.d(context, str);
        try {
            KWEGIDDFP.instance().setEgid(context, str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.e("AdPluginImpl", "AdPluginImpl KWEGIDDFP setEGid error : " + th);
        }
    }

    @Override // com.kwad.sdk.plugin.a
    public i b() {
        return new com.kwad.sdk.core.a.a();
    }
}
