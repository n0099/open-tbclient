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
    public static final List<Proxy> f32826a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f32827b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32828c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32829d;

    public i(ProxySelector proxySelector, String str, int i2) {
        this.f32827b = (ProxySelector) j.a(proxySelector);
        this.f32828c = (String) j.a(str);
        this.f32829d = i2;
    }

    public static void a(String str, int i2) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f32827b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f32828c.equals(uri.getHost()) && this.f32829d == uri.getPort() ? f32826a : this.f32827b.select(uri);
    }
}
