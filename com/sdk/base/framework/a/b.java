package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes6.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ URL f38796a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f38797b;

    public b(a aVar, URL url) {
        this.f38797b = aVar;
        this.f38796a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f38797b.f38789c = (HttpURLConnection) network.openConnection(this.f38796a);
        } catch (IOException unused) {
        }
    }
}
