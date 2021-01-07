package com.kwad.sdk.core.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes5.dex */
class i extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Proxy> f9801a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    private final ProxySelector f9802b;
    private final String c;
    private final int d;

    i(ProxySelector proxySelector, String str, int i) {
        this.f9802b = (ProxySelector) j.a(proxySelector);
        this.c = (String) j.a(str);
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f9802b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.c.equals(uri.getHost()) && this.d == uri.getPort() ? f9801a : this.f9802b.select(uri);
    }
}
