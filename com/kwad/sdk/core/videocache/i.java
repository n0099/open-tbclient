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

    /* renamed from: a  reason: collision with root package name */
    public static final List<Proxy> f34847a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f34848b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34849c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34850d;

    public i(ProxySelector proxySelector, String str, int i2) {
        this.f34848b = (ProxySelector) j.a(proxySelector);
        this.f34849c = (String) j.a(str);
        this.f34850d = i2;
    }

    public static void a(String str, int i2) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f34848b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f34849c.equals(uri.getHost()) && this.f34850d == uri.getPort() ? f34847a : this.f34848b.select(uri);
    }
}
