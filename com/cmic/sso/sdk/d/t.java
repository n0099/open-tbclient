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
    public static t f30664a;

    /* renamed from: b  reason: collision with root package name */
    public ConnectivityManager f30665b;

    /* renamed from: c  reason: collision with root package name */
    public Network f30666c;

    /* renamed from: d  reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f30667d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30668e;

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f30669f = false;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Network network);
    }

    public t(Context context) {
        this.f30665b = (ConnectivityManager) context.getSystemService("connectivity");
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
                this.f30669f = false;
                this.f30665b.stopUsingNetworkFeature(0, "enableHIPRI");
            } else {
                if (this.f30665b != null && this.f30667d != null) {
                    this.f30665b.unregisterNetworkCallback(this.f30667d);
                    this.f30667d = null;
                    this.f30666c = null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.f30666c != null;
        }
        return this.f30669f;
    }

    public static t a(Context context) {
        if (f30664a == null) {
            synchronized (t.class) {
                if (f30664a == null) {
                    f30664a = new t(context);
                }
            }
        }
        return f30664a;
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
        Network network = this.f30666c;
        if (network != null && !this.f30668e && (networkInfo = this.f30665b.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            Log.e("HttpUtils", "reuse network: ");
            aVar.a(this.f30666c);
            return;
        }
        ConnectivityManager.NetworkCallback networkCallback = this.f30667d;
        if (networkCallback != null) {
            try {
                this.f30665b.unregisterNetworkCallback(networkCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f30667d = null;
            }
            Log.e("HttpUtils", "clear: ");
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.cmic.sso.sdk.d.t.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network2) {
                t.this.f30666c = network2;
                aVar.a(network2);
                t.this.f30668e = false;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network2) {
                t.this.f30668e = true;
            }
        };
        this.f30667d = networkCallback2;
        this.f30665b.requestNetwork(build, networkCallback2);
    }

    public boolean a(String str) {
        this.f30665b.startUsingNetworkFeature(0, "enableHIPRI");
        for (int i2 = 0; i2 < 30; i2++) {
            try {
                if (this.f30665b.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                    break;
                }
                Thread.sleep(1000L);
            } catch (InterruptedException e2) {
                com.cmic.sso.sdk.c.a.f30624a.add(e2);
                c.a("WifiNetworkUtils", "check hipri failed");
            }
        }
        this.f30669f = this.f30665b.requestRouteToHost(5, b(c(str)));
        c.a("WifiNetworkUtils", "切换数据网络结果 >>> " + this.f30669f);
        return this.f30669f;
    }
}
