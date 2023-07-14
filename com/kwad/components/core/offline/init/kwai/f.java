package com.kwad.components.core.offline.init.kwai;

import android.content.Context;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.utils.ae;
/* loaded from: classes10.dex */
public final class f implements INet {
    @Override // com.kwad.components.offline.api.core.api.INet
    public final int getActiveNetworkType(Context context) {
        return ae.getActiveNetworkType(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final String getCurrHost(@INet.HostType String str, String str2) {
        return com.kwad.sdk.core.network.idc.a.tH().F(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final void handleSwitchHost(String str, @INet.HostType String str2, int i, Throwable th) {
        com.kwad.sdk.core.network.idc.a.tH().a(str, str2, new DomainException(i, th));
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isMobileConnected(Context context) {
        return ae.isMobileConnected(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isNetworkConnected(Context context) {
        return ae.isNetworkConnected(context);
    }

    @Override // com.kwad.components.offline.api.core.api.INet
    public final boolean isWifiConnected(Context context) {
        return ae.isWifiConnected(context);
    }
}
