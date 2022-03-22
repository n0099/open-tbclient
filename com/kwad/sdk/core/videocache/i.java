package com.kwad.sdk.core.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class i extends ProxySelector {
    public static final List<Proxy> a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f39951b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39952c;

    /* renamed from: d  reason: collision with root package name */
    public final int f39953d;

    public i(ProxySelector proxySelector, String str, int i) {
        this.f39951b = (ProxySelector) j.a(proxySelector);
        this.f39952c = (String) j.a(str);
        this.f39953d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f39951b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f39952c.equals(uri.getHost()) && this.f39953d == uri.getPort() ? a : this.f39951b.select(uri);
    }
}
