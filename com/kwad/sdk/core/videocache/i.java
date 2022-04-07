package com.kwad.sdk.core.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
public class i extends ProxySelector {
    public static final List<Proxy> a = Arrays.asList(Proxy.NO_PROXY);
    public final ProxySelector b;
    public final String c;
    public final int d;

    public i(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) j.a(proxySelector);
        this.c = (String) j.a(str);
        this.d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.c.equals(uri.getHost()) && this.d == uri.getPort() ? a : this.b.select(uri);
    }
}
