package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ URL f13068a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f13069b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, URL url) {
        this.f13069b = aVar;
        this.f13068a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f13069b.c = (HttpURLConnection) network.openConnection(this.f13068a);
        } catch (IOException e) {
        }
    }
}
