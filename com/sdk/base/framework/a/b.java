package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b extends ConnectivityManager.NetworkCallback {
    private /* synthetic */ URL a;
    private /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, URL url) {
        this.b = aVar;
        this.a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.b.c = (HttpURLConnection) network.openConnection(this.a);
        } catch (IOException e) {
        }
    }
}
