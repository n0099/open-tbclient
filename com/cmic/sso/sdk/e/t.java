package com.cmic.sso.sdk.e;

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
/* loaded from: classes7.dex */
public class t {
    private static t prw = null;

    /* renamed from: b  reason: collision with root package name */
    private ConnectivityManager f8037b;
    private ConnectivityManager.NetworkCallback d;
    private boolean e;
    private volatile boolean f = false;
    private Network prx;

    /* loaded from: classes7.dex */
    public interface a {
        void d(Network network);
    }

    private t(Context context) {
        this.f8037b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.prx != null;
        }
        return this.f;
    }

    /* renamed from: if  reason: not valid java name */
    public static t m59if(Context context) {
        if (prw == null) {
            synchronized (t.class) {
                if (prw == null) {
                    prw = new t(context);
                }
            }
        }
        return prw;
    }

    @TargetApi(21)
    public void a(final a aVar) {
        NetworkInfo networkInfo;
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.prx != null && !this.e && (networkInfo = this.f8037b.getNetworkInfo(this.prx)) != null && networkInfo.isAvailable()) {
                Log.e("HttpUtils", "reuse network: ");
                aVar.d(this.prx);
                return;
            }
            if (this.d != null) {
                try {
                    this.f8037b.unregisterNetworkCallback(this.d);
                } catch (Exception e) {
                    e.printStackTrace();
                    this.d = null;
                }
                Log.e("HttpUtils", "clear: ");
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            this.d = new ConnectivityManager.NetworkCallback() { // from class: com.cmic.sso.sdk.e.t.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    t.this.prx = network;
                    aVar.d(network);
                    t.this.e = false;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    t.this.e = true;
                }
            };
            this.f8037b.requestNetwork(build, this.d);
        }
    }

    public void b() {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                this.f = false;
                this.f8037b.stopUsingNetworkFeature(0, "enableHIPRI");
            } else if (this.f8037b != null && this.d != null) {
                this.f8037b.unregisterNetworkCallback(this.d);
                this.d = null;
                this.prx = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int b(String str) {
        try {
            InetAddress byName = InetAddress.getByName(str);
            if (byName != null) {
                c.b("WifiNetworkUtils", "lookupHost inetAddress " + byName.toString());
            }
            byte[] address = byName.getAddress();
            return (address[0] & 255) | ((address[3] & 255) << 24) | ((address[2] & 255) << 16) | ((address[1] & 255) << 8);
        } catch (UnknownHostException e) {
            return -1;
        }
    }

    private static String c(String str) {
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
        if (indexOf4 >= 0) {
            return str.substring(0, indexOf4);
        }
        return str;
    }

    public boolean a(String str) {
        this.f8037b.startUsingNetworkFeature(0, "enableHIPRI");
        for (int i = 0; i < 30; i++) {
            try {
                if (this.f8037b.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                    break;
                }
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                com.cmic.sso.sdk.d.a.prm.add(e);
                c.a("WifiNetworkUtils", "check hipri failed");
            }
        }
        this.f = this.f8037b.requestRouteToHost(5, b(c(str)));
        c.a("WifiNetworkUtils", "切换数据网络结果 >>> " + this.f);
        return this.f;
    }
}
