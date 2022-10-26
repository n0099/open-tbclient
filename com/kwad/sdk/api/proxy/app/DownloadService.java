package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyService;
import com.kwad.sdk.api.proxy.IServiceProxy;
/* loaded from: classes7.dex */
public class DownloadService extends BaseProxyService {
    @Override // com.kwad.sdk.api.proxy.BaseProxyService
    public IServiceProxy getDelegate(Context context) {
        return (IServiceProxy) Loader.get().newComponentProxy(context, DownloadService.class, this);
    }
}
