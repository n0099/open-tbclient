package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class NetworkMonitor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f32049a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<a>> f32050b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f32051c;

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastReceiver f32052d;

    /* loaded from: classes6.dex */
    public enum Holder {
        INSTANCE;
        
        public NetworkMonitor mInstance = new NetworkMonitor();

        Holder() {
        }

        public NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* loaded from: classes6.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* loaded from: classes6.dex */
    public interface a {
        void a(NetworkState networkState);
    }

    public NetworkMonitor() {
        this.f32050b = Collections.synchronizedList(new LinkedList());
        this.f32051c = false;
        this.f32052d = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                NetworkMonitor networkMonitor;
                NetworkState networkState;
                try {
                    if ((ContextCompat.checkSelfPermission(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION) == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_NONE;
                        } else if (1 == activeNetworkInfo.getType()) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_WIFI;
                        } else if (activeNetworkInfo.getType() == 0) {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_MOBILE;
                        } else {
                            networkMonitor = NetworkMonitor.this;
                            networkState = NetworkState.NETWORK_NONE;
                        }
                        networkMonitor.a(networkState);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkState networkState) {
        a aVar;
        Iterator<WeakReference<a>> it = this.f32050b.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next == null || (aVar = next.get()) == null) {
                it.remove();
            } else {
                aVar.a(networkState);
            }
        }
    }
}
