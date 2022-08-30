package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.am;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public final class i extends ProxySelector {
    public static final List<Proxy> aeJ = Arrays.asList(Proxy.NO_PROXY);
    public final ProxySelector aeK;
    public final String aeL;
    public final int aeM;

    public i(ProxySelector proxySelector, String str, int i) {
        this.aeK = (ProxySelector) am.checkNotNull(proxySelector);
        this.aeL = am.dQ(str);
        this.aeM = i;
    }

    public static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aeK.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return this.aeL.equals(uri.getHost()) && this.aeM == uri.getPort() ? aeJ : this.aeK.select(uri);
    }
}
