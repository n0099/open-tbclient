package com.sdk.base.framework.a;

import android.net.ConnectivityManager;
import android.net.Network;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes7.dex */
public final class b extends ConnectivityManager.NetworkCallback {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ URL f39230a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f39231b;

    public b(a aVar, URL url) {
        this.f39231b = aVar;
        this.f39230a = url;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            this.f39231b.f39223c = (HttpURLConnection) network.openConnection(this.f39230a);
        } catch (IOException unused) {
        }
    }
}
