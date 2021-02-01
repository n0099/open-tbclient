package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.KsAdSDKImpl;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class NetworkMonitor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f9029a = false;

    /* renamed from: b  reason: collision with root package name */
    private List<WeakReference<a>> f9030b;
    private boolean c;
    private final BroadcastReceiver d;

    /* loaded from: classes3.dex */
    private enum Holder {
        INSTANCE;
        
        private NetworkMonitor mInstance = new NetworkMonitor();

        Holder() {
        }

        NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* loaded from: classes3.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(NetworkState networkState);
    }

    private NetworkMonitor() {
        this.f9030b = Collections.synchronizedList(new LinkedList());
        this.c = false;
        this.d = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if ((ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.a(NetworkState.NETWORK_NONE);
                        } else if (1 == activeNetworkInfo.getType()) {
                            NetworkMonitor.this.a(NetworkState.NETWORK_WIFI);
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkMonitor.this.a(NetworkState.NETWORK_MOBILE);
                        } else {
                            NetworkMonitor.this.a(NetworkState.NETWORK_NONE);
                        }
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
        Iterator<WeakReference<a>> it = this.f9030b.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                a aVar = next.get();
                if (aVar == null) {
                    it.remove();
                } else {
                    aVar.a(networkState);
                }
            }
        }
    }

    private synchronized void d() {
        Context context;
        if (!f9029a && (context = KsAdSDKImpl.get().getContext()) != null) {
            context.getApplicationContext().registerReceiver(this.d, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            f9029a = true;
        }
    }

    public void a(@NonNull a aVar) {
        d();
        this.f9030b.add(new WeakReference<>(aVar));
    }

    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        Iterator<WeakReference<a>> it = this.f9030b.iterator();
        while (it.hasNext()) {
            WeakReference<a> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                a aVar2 = next.get();
                if (aVar2 == null) {
                    it.remove();
                } else if (aVar == aVar2) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public boolean b() {
        return !this.c;
    }

    public void c() {
        this.c = true;
    }
}
