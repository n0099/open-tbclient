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
/* loaded from: classes6.dex */
public class t {
    private static t pmR = null;

    /* renamed from: b  reason: collision with root package name */
    private ConnectivityManager f7737b;
    private ConnectivityManager.NetworkCallback d;
    private boolean e;
    private volatile boolean f = false;
    private Network pmS;

    /* loaded from: classes6.dex */
    public interface a {
        void d(Network network);
    }

    private t(Context context) {
        this.f7737b = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return this.pmS != null;
        }
        return this.f;
    }

    public static t id(Context context) {
        if (pmR == null) {
            synchronized (t.class) {
                if (pmR == null) {
                    pmR = new t(context);
                }
            }
        }
        return pmR;
    }

    @TargetApi(21)
    public void a(final a aVar) {
        NetworkInfo networkInfo;
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.pmS != null && !this.e && (networkInfo = this.f7737b.getNetworkInfo(this.pmS)) != null && networkInfo.isAvailable()) {
                Log.e("HttpUtils", "reuse network: ");
                aVar.d(this.pmS);
                return;
            }
            if (this.d != null) {
                try {
                    this.f7737b.unregisterNetworkCallback(this.d);
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
                    t.this.pmS = network;
                    aVar.d(network);
                    t.this.e = false;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    t.this.e = true;
                }
            };
            this.f7737b.requestNetwork(build, this.d);
        }
    }

    public void b() {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                this.f = false;
                this.f7737b.stopUsingNetworkFeature(0, "enableHIPRI");
            } else if (this.f7737b != null && this.d != null) {
                this.f7737b.unregisterNetworkCallback(this.d);
                this.d = null;
                this.pmS = null;
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
        this.f7737b.startUsingNetworkFeature(0, "enableHIPRI");
        for (int i = 0; i < 30; i++) {
            try {
                if (this.f7737b.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) == 0) {
                    break;
                }
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                com.cmic.sso.sdk.d.a.pmH.add(e);
                c.a("WifiNetworkUtils", "check hipri failed");
            }
        }
        this.f = this.f7737b.requestRouteToHost(5, b(c(str)));
        c.a("WifiNetworkUtils", "切换数据网络结果 >>> " + this.f);
        return this.f;
    }
}
