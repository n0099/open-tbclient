package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.ap;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public final class i extends ProxySelector {
    public static final List<Proxy> aBh = Arrays.asList(Proxy.NO_PROXY);
    public final ProxySelector aBi;
    public final String aBj;
    public final int aBk;

    public i(ProxySelector proxySelector, String str, int i) {
        this.aBi = (ProxySelector) ap.checkNotNull(proxySelector);
        this.aBj = ap.fZ(str);
        this.aBk = i;
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.aBi.connectFailed(uri, socketAddress, iOException);
    }

    public static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        boolean z;
        if (this.aBj.equals(uri.getHost()) && this.aBk == uri.getPort()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return aBh;
        }
        return this.aBi.select(uri);
    }
}
