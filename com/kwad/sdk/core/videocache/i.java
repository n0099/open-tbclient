package com.kwad.sdk.core.videocache;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes3.dex */
public class i extends ProxySelector {
    public static final List<Proxy> a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f58502b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58503c;

    /* renamed from: d  reason: collision with root package name */
    public final int f58504d;

    public i(ProxySelector proxySelector, String str, int i2) {
        this.f58502b = (ProxySelector) j.a(proxySelector);
        this.f58503c = (String) j.a(str);
        this.f58504d = i2;
    }

    public static void a(String str, int i2) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f58502b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f58503c.equals(uri.getHost()) && this.f58504d == uri.getPort() ? a : this.f58502b.select(uri);
    }
}
