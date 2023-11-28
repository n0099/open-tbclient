package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class NetworkMonitor {
    public static volatile boolean aom;
    public final List<a> aon;
    public boolean aoo;
    public final BroadcastReceiver aop;

    /* loaded from: classes10.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* loaded from: classes10.dex */
    public interface a {
        void a(NetworkState networkState);
    }

    /* loaded from: classes10.dex */
    public enum Holder {
        INSTANCE;
        
        public final NetworkMonitor mInstance = new NetworkMonitor((byte) 0);

        public final NetworkMonitor getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }

    public NetworkMonitor() {
        this.aon = new CopyOnWriteArrayList();
        this.aoo = false;
        this.aop = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                boolean z;
                ConnectivityManager connectivityManager;
                try {
                    if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        if (1 != activeNetworkInfo.getType()) {
                            if (activeNetworkInfo.getType() == 0) {
                                NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                                return;
                            } else {
                                NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                                return;
                            }
                        }
                        NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                        return;
                    }
                    NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    private synchronized void aO(Context context) {
        if (!aom && context != null) {
            context.getApplicationContext().registerReceiver(this.aop, new IntentFilter(com.baidu.searchbox.ui.animview.praise.NetworkMonitor.NET_CHANGE_ACTION));
            aom = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        for (a aVar : this.aon) {
            aVar.a(networkState);
        }
    }

    public final void a(a aVar) {
        this.aon.remove(aVar);
    }

    public final void a(Context context, @NonNull a aVar) {
        aO(context);
        if (!this.aon.contains(aVar)) {
            this.aon.add(aVar);
        }
    }
}
