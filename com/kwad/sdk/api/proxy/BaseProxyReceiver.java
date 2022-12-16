package com.kwad.sdk.api.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes8.dex */
public abstract class BaseProxyReceiver extends BroadcastReceiver {
    public IReceiverProxy mDelegate;

    @NonNull
    public abstract IReceiverProxy getDelegate(Context context);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.mDelegate == null) {
            this.mDelegate = getDelegate(Wrapper.wrapContextIfNeed(context));
        }
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        this.mDelegate.onReceive(context, intent);
    }
}
