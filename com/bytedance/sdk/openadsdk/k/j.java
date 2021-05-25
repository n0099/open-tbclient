package com.bytedance.sdk.openadsdk.k;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class j extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    public static final List<Proxy> f29491a = Collections.singletonList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f29492b = ProxySelector.getDefault();

    /* renamed from: c  reason: collision with root package name */
    public final String f29493c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29494d;

    public j(String str, int i2) {
        this.f29493c = str;
        this.f29494d = i2;
    }

    public static void a(String str, int i2) {
        ProxySelector.setDefault(new j(str, i2));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f29492b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.f29493c.equalsIgnoreCase(uri.getHost()) && this.f29494d == uri.getPort()) ? f29491a : this.f29492b.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
