package com.kwad.sdk.api.proxy.app;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.proxy.BaseProxyActivity;
import com.kwad.sdk.api.proxy.IActivityProxy;
/* loaded from: classes8.dex */
public class KsFullScreenLandScapeVideoActivity extends BaseProxyActivity {
    @Override // com.kwad.sdk.api.proxy.BaseProxyActivity
    @NonNull
    public IActivityProxy getDelegate(Context context) {
        return (IActivityProxy) Loader.get().newComponentProxy(context, KsFullScreenLandScapeVideoActivity.class, this);
    }
}
