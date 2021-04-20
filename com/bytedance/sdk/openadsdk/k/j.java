package com.bytedance.sdk.openadsdk.k;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class j extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Proxy> f29406a = Collections.singletonList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f29407b = ProxySelector.getDefault();

    /* renamed from: c  reason: collision with root package name */
    public final String f29408c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29409d;

    public j(String str, int i) {
        this.f29408c = str;
        this.f29409d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new j(str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f29407b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.f29408c.equalsIgnoreCase(uri.getHost()) && this.f29409d == uri.getPort()) ? f29406a : this.f29407b.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
