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
    public static final List<Proxy> f34591a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f34592b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34593c;

    /* renamed from: d  reason: collision with root package name */
    public final int f34594d;

    public i(ProxySelector proxySelector, String str, int i) {
        this.f34592b = (ProxySelector) j.a(proxySelector);
        this.f34593c = (String) j.a(str);
        this.f34594d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f34592b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f34593c.equals(uri.getHost()) && this.f34594d == uri.getPort() ? f34591a : this.f34592b.select(uri);
    }
}
