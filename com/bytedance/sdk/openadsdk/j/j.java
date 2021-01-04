package com.bytedance.sdk.openadsdk.j;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
class j extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    private static final List<Proxy> f7604a = Collections.singletonList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    private final ProxySelector f7605b = ProxySelector.getDefault();
    private final String c;
    private final int d;

    private j(String str, int i) {
        this.c = str;
        this.d = i;
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri == null) {
            throw new IllegalArgumentException("URI can't be null");
        }
        return (this.c.equalsIgnoreCase(uri.getHost()) && this.d == uri.getPort()) ? f7604a : this.f7605b.select(uri);
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f7605b.connectFailed(uri, socketAddress, iOException);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, int i) {
        ProxySelector.setDefault(new j(str, i));
    }
}
