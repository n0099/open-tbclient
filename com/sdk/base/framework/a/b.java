package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ URL f35622a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f35623b;

    public b(a aVar, URL url) {
        this.f35623b = aVar;
        this.f35622a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f35623b.f35615c = (HttpURLConnection) network.openConnection(this.f35622a);
        } catch (IOException unused) {
        }
    }
}
