package com.cmic.sso.sdk.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;
/* loaded from: classes6.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public static t f30709a;

    /* renamed from: b  reason: collision with root package name */
    public ConnectivityManager f30710b;

    /* renamed from: c  reason: collision with root package name */
    public Network f30711c;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f30712d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30713e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f30714f = false;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Network network);
    }

    public t(Context context) {
        this.f30710b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static String c(String str) {
        int indexOf = str.indexOf("://");
        if (indexOf > 0) {
            str = str.substring(indexOf + 3);
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 >= 0) {
            str = str.substring(0, indexOf2);
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 >= 0) {
            str = str.substring(0, indexOf3);
        }
        int indexOf4 = str.indexOf(63);
        return indexOf4 >= 0 ? str.substring(0, indexOf4) : str;
    }

    public void b() {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                this.f30714f = false;
                this.f30710b.stopUsingNetworkFeature(0, "enableHIPRI");
            } else {
                if (this.f30710b != null && this.f30712d != null) {
                    this.f30710b.unregisterNetworkCallback(this.f30712d);
                    this.f30712d = null;
                    this.f30711c = null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f30711c != null;
        }
        return this.f30714f;
    }

    public static t a(Context context) {
        if (f30709a == null) {
            synchronized (t.class) {
                if (f30709a == null) {
                    f30709a = new t(context);
                }
            }
        }
        return f30709a;
    }

    public static int b(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("lookupHost inetAddress ");
                sb.append(byName.toString());
                c.b("WifiNetworkUtils", sb.toString());
            }
            byte[] address = byName.getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (UnknownHostException unused) {
            return -1;
        }
    }

    @TargetApi(21)
    public void a(final a aVar) {
        NetworkInfo networkInfo;
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        Network network = this.f30711c;
        if (network != null && !this.f30713e && (networkInfo = this.f30710b.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            Log.e("HttpUtils", "reuse network: ");
            aVar.a(this.f30711c);
            return;
        }
        ConnectivityManager.NetworkCallback networkCallback = this.f30712d;
        if (networkCallback != null) {
            try {
                this.f30710b.unregisterNetworkCallback(networkCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f30712d = null;
            }
            Log.e("HttpUtils", "clear: ");
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.cmic.sso.sdk.d.t.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network2) {
                t.this.f30711c = network2;
                aVar.a(network2);
                t.this.f30713e = false;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network2) {
                t.this.f30713e = true;
            }
        };
        this.f30712d = networkCallback2;
        this.f30710b.requestNetwork(build, networkCallback2);
    }

    public boolean a(String str) {
        this.f30710b.startUsingNetworkFeature(0, "enableHIPRI");
        for (int i = 0; i < 30; i++) {
            try {
                if (this.f30710b.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                    break;
                }
                Thread.sleep(1000L);
            } catch (InterruptedException e2) {
                com.cmic.sso.sdk.c.a.f30670a.add(e2);
                c.a("WifiNetworkUtils", "check hipri failed");
            }
        }
        this.f30714f = this.f30710b.requestRouteToHost(5, b(c(str)));
        c.a("WifiNetworkUtils", "切换数据网络结果 >>> " + this.f30714f);
        return this.f30714f;
    }
}
