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
    public static final List<Proxy> f32755a = Arrays.asList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f32756b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32757c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32758d;

    public i(ProxySelector proxySelector, String str, int i2) {
        this.f32756b = (ProxySelector) j.a(proxySelector);
        this.f32757c = (String) j.a(str);
        this.f32758d = i2;
    }

    public static void a(String str, int i2) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f32756b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return this.f32757c.equals(uri.getHost()) && this.f32758d == uri.getPort() ? f32755a : this.f32756b.select(uri);
    }
}
