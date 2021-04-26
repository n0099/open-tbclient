package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes6.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ URL f36377a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f36378b;

    public b(a aVar, URL url) {
        this.f36378b = aVar;
        this.f36377a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f36378b.f36370c = (HttpURLConnection) network.openConnection(this.f36377a);
        } catch (IOException unused) {
        }
    }
}
