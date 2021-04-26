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
    public static final List<Proxy> f30317a = Collections.singletonList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f30318b = ProxySelector.getDefault();

    /* renamed from: c  reason: collision with root package name */
    public final String f30319c;

    /* renamed from: d  reason: collision with root package name */
    public final int f30320d;

    public j(String str, int i2) {
        this.f30319c = str;
        this.f30320d = i2;
    }

    public static void a(String str, int i2) {
        ProxySelector.setDefault(new j(str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f30318b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.f30319c.equalsIgnoreCase(uri.getHost()) && this.f30320d == uri.getPort()) ? f30317a : this.f30318b.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
