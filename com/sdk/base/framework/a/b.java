package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes6.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ URL f38412a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f38413b;

    public b(a aVar, URL url) {
        this.f38413b = aVar;
        this.f38412a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f38413b.f38405c = (HttpURLConnection) network.openConnection(this.f38412a);
        } catch (IOException unused) {
        }
    }
}
