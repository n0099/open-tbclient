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
    public static final List<Proxy> f29720a = Collections.singletonList(Proxy.NO_PROXY);

    /* renamed from: b  reason: collision with root package name */
    public final ProxySelector f29721b = ProxySelector.getDefault();

    /* renamed from: c  reason: collision with root package name */
    public final String f29722c;

    /* renamed from: d  reason: collision with root package name */
    public final int f29723d;

    public j(String str, int i) {
        this.f29722c = str;
        this.f29723d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new j(str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f29721b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.f29722c.equalsIgnoreCase(uri.getHost()) && this.f29723d == uri.getPort()) ? f29720a : this.f29721b.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
