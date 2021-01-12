package com.kwad.sdk.plugin;

import android.content.Context;
import com.kwad.sdk.api.SdkConfig;
/* loaded from: classes4.dex */
public class f {
    public static void a(Context context, SdkConfig sdkConfig) {
        e eVar = (e) c.class.newInstance();
        g.a(eVar.b(), eVar);
        eVar.a(context, sdkConfig);
        e eVar2 = (e) com.kwad.sdk.contentalliance.d.class.newInstance();
        g.a(eVar2.b(), eVar2);
        eVar2.a(context, sdkConfig);
    }
}
