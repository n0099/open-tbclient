package com.kwad.sdk.core.download.c;

import android.content.Context;
import com.kwad.sdk.export.proxy.AdInstallProxy;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class b implements AdInstallProxy {
    @Override // com.kwad.sdk.export.proxy.AdInstallProxy, com.ksad.download.a
    public void installApp(Context context, String str) {
        ag.d(context, str);
    }
}
