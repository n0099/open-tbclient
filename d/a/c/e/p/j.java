package d.a.c.e.p;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.NetworkState;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class j {
    public static Pattern m = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
    public static boolean n = true;
    public static j o;
    public long j;

    /* renamed from: a  reason: collision with root package name */
    public NetworkInfo f39203a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39204b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39205c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39206d = true;

    /* renamed from: e  reason: collision with root package name */
    public int f39207e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f39208f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f39209g = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f39210h = null;

    /* renamed from: i  reason: collision with root package name */
    public int f39211i = -1;
    public boolean k = true;
    public Runnable l = new a(this);

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a(j jVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                int I = j.I();
                long l = j.l();
                j.e();
                if (j.C()) {
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = I;
                    networkState.mCurNetState = j.I();
                    networkState.mlastChangedTime = l;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    j.M(currentTimeMillis);
                    MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangedMessage(networkState));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AsyncService.INSTANCE.sendRunnable(j.k().l);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        try {
            b bVar = new b(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            BdBaseApplication.getInst().getApp().registerReceiver(bVar, intentFilter);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        o = null;
    }

    public static boolean A() {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean C() {
        return k().B();
    }

    public static boolean D() {
        return n;
    }

    public static boolean E() {
        NetworkInfo h2 = k().h();
        return (h2 == null || h2.getExtraInfo() == null || !h2.getExtraInfo().contains("wap")) ? false : true;
    }

    public static boolean F(String str) {
        return m.matcher(str).find();
    }

    public static boolean H() {
        return k().G();
    }

    public static int I() {
        if (H()) {
            return 1;
        }
        if (t()) {
            return 2;
        }
        if (u()) {
            return 3;
        }
        return (v() || z()) ? 4 : 0;
    }

    public static String J() {
        int I = I();
        return I != 1 ? I != 2 ? I != 3 ? I != 4 ? "unreachable" : "4g" : "3g" : "2g" : "wifi";
    }

    public static String K() {
        String J = J();
        return J != null ? J.toUpperCase() : J;
    }

    public static int L() {
        String substring;
        int i2;
        String networkOperator = ((TelephonyManager) BdBaseApplication.getInst().getContext().getSystemService("phone")).getNetworkOperator();
        if (networkOperator == null || networkOperator.length() < 4 || k.isEmptyStringAfterTrim(networkOperator) || (substring = networkOperator.substring(0, 3)) == null || !substring.equals("460")) {
            return 0;
        }
        try {
            i2 = Integer.parseInt(networkOperator.substring(3));
        } catch (NumberFormatException unused) {
            i2 = 0;
        }
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3 && i2 != 5) {
                        if (i2 != 6) {
                            if (i2 != 7) {
                                if (i2 != 11) {
                                    return 0;
                                }
                            }
                        }
                    }
                    return 3;
                }
            }
            return 2;
        }
        return 1;
    }

    public static void M(long j) {
        k().N(j);
    }

    public static String c() {
        return k().p();
    }

    public static int d() {
        return k().q();
    }

    public static void e() {
        k().j();
    }

    public static int f() {
        return k().o();
    }

    public static synchronized j k() {
        j jVar;
        synchronized (j.class) {
            if (o == null) {
                o = new j();
            }
            jVar = o;
        }
        return jVar;
    }

    public static long l() {
        return k().g();
    }

    public static String m() {
        return !z() ? "N" : H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : v() ? "4G" : u() ? com.baidu.apollon.statistics.g.f3963b : t() ? "2G" : "N";
    }

    public static int n(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 3;
            default:
                return 4;
        }
    }

    public static void r() {
        s(true);
    }

    public static void s(boolean z) {
        k().O(z);
        k().j();
    }

    public static boolean t() {
        return 1 == k().i();
    }

    public static boolean u() {
        return 2 == k().i();
    }

    public static boolean v() {
        return 3 == k().i();
    }

    public static boolean x() {
        return k().w();
    }

    public static boolean z() {
        return k().y();
    }

    public boolean B() {
        return this.k;
    }

    public boolean G() {
        if (this.f39203a == null) {
            j();
        }
        return this.f39204b;
    }

    public final void N(long j) {
        this.j = j;
    }

    public void O(boolean z) {
        this.k = z;
    }

    public final long g() {
        return this.j;
    }

    public final NetworkInfo h() {
        try {
            return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int i() {
        if (this.f39203a == null) {
            j();
        }
        return this.f39208f;
    }

    public final void j() {
        NetworkInfo h2 = h();
        this.f39203a = h2;
        if (h2 != null) {
            if (h2.getType() == 1) {
                this.f39204b = true;
                this.f39205c = false;
            } else if (h2.getType() == 0) {
                this.f39204b = false;
                this.f39205c = true;
            } else {
                this.f39204b = false;
                this.f39205c = false;
            }
            this.f39206d = true;
            int subtype = h2.getSubtype();
            this.f39207e = subtype;
            if (this.f39205c) {
                this.f39208f = n(subtype);
            } else {
                this.f39208f = 0;
            }
        } else {
            this.f39204b = false;
            this.f39205c = false;
            this.f39206d = false;
            this.f39207e = 0;
            this.f39207e = 0;
        }
        this.f39209g = L();
        this.f39210h = Proxy.getDefaultHost();
        this.f39211i = Proxy.getDefaultPort();
    }

    public int o() {
        if (this.f39209g == -1) {
            try {
                this.f39209g = L();
            } catch (Exception unused) {
                this.f39209g = 0;
            }
        }
        return this.f39209g;
    }

    public String p() {
        if (this.f39210h == null) {
            this.f39210h = Proxy.getDefaultHost();
        }
        return this.f39210h;
    }

    public int q() {
        if (-1 == this.f39211i) {
            this.f39211i = Proxy.getDefaultPort();
        }
        return this.f39211i;
    }

    public boolean w() {
        if (this.f39203a == null) {
            j();
        }
        return this.f39205c;
    }

    public boolean y() {
        if (this.f39203a == null) {
            j();
        }
        return this.f39206d;
    }
}
