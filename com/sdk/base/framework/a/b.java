package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ URL f12771a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f12772b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, URL url) {
        this.f12772b = aVar;
        this.f12771a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f12772b.c = (HttpURLConnection) network.openConnection(this.f12771a);
        } catch (IOException e) {
        }
    }
}
