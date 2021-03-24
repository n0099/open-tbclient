package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.kwad.sdk.KsAdSDKImpl;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class NetworkMonitor {

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f33406a = false;

    /* renamed from: b  reason: collision with root package name */
    public List<WeakReference<a>> f33407b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f33408c;

    /* renamed from: d  reason: collision with root package name */
    public final BroadcastReceiver f33409d;

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
        this.f33407b = Collections.synchronizedList(new LinkedList());
        this.f33408c = false;
        this.f33409d = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
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

    public static NetworkMonitor a() {
        return Holder.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NetworkState networkState) {
        a aVar;
        Iterator<WeakReference<a>> it = this.f33407b.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next == null || (aVar = next.get()) == null) {
                it.remove();
            } else {
                aVar.a(networkState);
            }
        }
    }

    private synchronized void d() {
        if (f33406a) {
            return;
        }
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return;
        }
        context.getApplicationContext().registerReceiver(this.f33409d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        f33406a = true;
    }

    public void a(@NonNull a aVar) {
        d();
        this.f33407b.add(new WeakReference<>(aVar));
    }

    public void b(a aVar) {
        a aVar2;
        if (aVar == null) {
            return;
        }
        Iterator<WeakReference<a>> it = this.f33407b.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next == null || (aVar2 = next.get()) == null) {
                it.remove();
            } else if (aVar == aVar2) {
                it.remove();
                return;
            }
        }
    }

    public boolean b() {
        return !this.f33408c;
    }

    public void c() {
        this.f33408c = true;
    }
}
