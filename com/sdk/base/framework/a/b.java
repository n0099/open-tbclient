package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ URL f39328a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f39329b;

    public b(a aVar, URL url) {
        this.f39329b = aVar;
        this.f39328a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f39329b.f39321c = (HttpURLConnection) network.openConnection(this.f39328a);
        } catch (IOException unused) {
        }
    }
}
