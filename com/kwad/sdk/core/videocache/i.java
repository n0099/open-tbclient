package com.kwad.sdk.core.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class i extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Proxy> f34206a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f34207b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34208c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34209d;

    public i(ProxySelector proxySelector, String str, int i) {
        this.f34207b = (ProxySelector) j.a(proxySelector);
        this.f34208c = (String) j.a(str);
        this.f34209d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f34207b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f34208c.equals(uri.getHost()) && this.f34209d == uri.getPort() ? f34206a : this.f34207b.select(uri);
    }
}
