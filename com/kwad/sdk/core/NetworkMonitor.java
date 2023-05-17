package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public final class NetworkMonitor {
    public static volatile boolean Ti;
    public final List<WeakReference<a>> Tj;
    public boolean Tk;
    public final BroadcastReceiver Tl;

    /* loaded from: classes9.dex */
    public enum Holder {
        INSTANCE;
        
        public NetworkMonitor mInstance = new NetworkMonitor((byte) 0);

        Holder() {
        }

        public final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* loaded from: classes9.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* loaded from: classes9.dex */
    public interface a {
        void a(NetworkState networkState);
    }

    public NetworkMonitor() {
        this.Tj = Collections.synchronizedList(new LinkedList());
        this.Tk = false;
        this.Tl = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                NetworkMonitor networkMonitor;
                NetworkState networkState;
                try {
                    if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_WIFI;
                        } else if (activeNetworkInfo.getType() == 0) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_MOBILE;
                        } else {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_NONE;
                        }
                        networkMonitor.b(networkState);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    private synchronized void aR(Context context) {
        if (Ti) {
            return;
        }
        if (context == null) {
            return;
        }
        context.getApplicationContext().registerReceiver(this.Tl, new IntentFilter(com.baidu.searchbox.ui.animview.praise.NetworkMonitor.NET_CHANGE_ACTION));
        Ti = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        a aVar;
        synchronized (this.Tj) {
            Iterator<WeakReference<a>> it = this.Tj.iterator();
            while (it.hasNext()) {
                WeakReference<a> next = it.next();
                if (next != null && (aVar = next.get()) != null) {
                    aVar.a(networkState);
                }
                it.remove();
            }
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(Context context, @NonNull a aVar) {
        aR(context);
        this.Tj.add(new WeakReference<>(aVar));
    }

    public final void a(a aVar) {
        a aVar2;
        synchronized (this.Tj) {
            Iterator<WeakReference<a>> it = this.Tj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<a> next = it.next();
                if (next != null && (aVar2 = next.get()) != null) {
                    if (aVar == aVar2) {
                        it.remove();
                        break;
                    }
                }
                it.remove();
            }
        }
    }
}
