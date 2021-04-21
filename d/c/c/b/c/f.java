package d.c.c.b.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.adnet.core.Request;
import d.c.c.b.a;
import d.c.c.b.d.o;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* loaded from: classes5.dex */
public class f implements c {
    public static f p;

    /* renamed from: c  reason: collision with root package name */
    public Context f66604c;

    /* renamed from: d  reason: collision with root package name */
    public e f66605d;

    /* renamed from: a  reason: collision with root package name */
    public long f66602a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66603b = false;

    /* renamed from: e  reason: collision with root package name */
    public int f66606e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f66607f = 19700101000L;

    /* renamed from: g  reason: collision with root package name */
    public int f66608g = 0;

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, Integer> f66609h = new HashMap<>();
    public HashMap<String, Integer> i = new HashMap<>();
    public int j = 0;
    public HashMap<String, Integer> k = new HashMap<>();
    public HashMap<String, Integer> l = new HashMap<>();
    public boolean m = true;
    public Map<String, Integer> n = new HashMap();
    public Handler o = new a(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            f.this.h(message.arg1 != 0);
        }
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (p == null) {
                p = new f();
            }
            fVar = p;
        }
        return fVar;
    }

    @Override // d.c.c.b.c.c
    public synchronized void b(Request request, o oVar) {
        if (request == null || oVar == null) {
            return;
        }
        if (this.m) {
            if (d.c.c.b.e.e.a(this.f66604c)) {
                URL url = null;
                try {
                    url = new URL(request.getUrl());
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String ipAddrStr = request.getIpAddrStr();
                int i = (int) oVar.f66686h;
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(ipAddrStr)) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.d.c("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i);
                    d n = n();
                    if (n != null && n.f66591b) {
                        g(oVar, host);
                    }
                    if (n == null) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.d.c("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i + " " + this.f66608g + "#" + this.f66609h.size() + "#" + this.i.size() + " " + this.j + "#" + this.k.size() + "#" + this.l.size());
                    if (i > 0) {
                        if (j(i)) {
                            if (this.f66608g > 0 || this.j > 0) {
                                t();
                            }
                            o(host);
                        } else if (!m(i)) {
                            this.j++;
                            this.k.put(path, 0);
                            this.l.put(ipAddrStr, 0);
                            if (this.j >= n.f66597h && this.k.size() >= n.i && this.l.size() >= n.j) {
                                com.bytedance.sdk.adnet.d.d.c("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + ipAddrStr + "#" + i);
                                i(false, 0L);
                                t();
                            }
                            l(host);
                        }
                    }
                }
            }
        }
    }

    @Override // d.c.c.b.c.c
    public synchronized void c(Request request, Exception exc) {
        if (request == null || exc == null) {
            return;
        }
        if (this.m) {
            if (d.c.c.b.e.e.a(this.f66604c)) {
                URL url = null;
                try {
                    url = new URL(request.getUrl());
                } catch (Exception unused) {
                }
                if (url == null) {
                    return;
                }
                String protocol = url.getProtocol();
                String host = url.getHost();
                String path = url.getPath();
                String ipAddrStr = request.getIpAddrStr();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    d n = n();
                    if (n == null) {
                        return;
                    }
                    com.bytedance.sdk.adnet.d.d.c("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + ipAddrStr + "# " + this.f66608g + "#" + this.f66609h.size() + "#" + this.i.size() + " " + this.j + "#" + this.k.size() + "#" + this.l.size());
                    this.f66608g = this.f66608g + 1;
                    this.f66609h.put(path, 0);
                    this.i.put(ipAddrStr, 0);
                    if (this.f66608g >= n.f66594e && this.f66609h.size() >= n.f66595f && this.i.size() >= n.f66596g) {
                        com.bytedance.sdk.adnet.d.d.c("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + ipAddrStr);
                        i(false, 0L);
                        t();
                    }
                    l(host);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d(String str) {
        String str2;
        URL url;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String str3 = null;
            try {
                url = new URL(str);
                str2 = url.getProtocol();
            } catch (Throwable th) {
                th = th;
                str2 = null;
            }
            try {
                str3 = url.getHost();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (!TextUtils.isEmpty(str2)) {
                    if (!q(str3)) {
                    }
                }
                return str;
            }
            if (!TextUtils.isEmpty(str2) && (("http".equals(str2) || "https".equals(str2)) && !TextUtils.isEmpty(str3))) {
                if (!q(str3)) {
                    com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str3);
                    return str;
                }
                Map<String, String> p2 = p();
                if (p2 != null && p2.containsKey(str3)) {
                    String str4 = p2.get(str3);
                    if (TextUtils.isEmpty(str4)) {
                        return str;
                    }
                    com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleHostMapping, match, origin: " + str);
                    String str5 = str2 + "://" + str3;
                    String str6 = str2 + "://" + str4;
                    if (str.startsWith(str5)) {
                        str = str.replaceFirst(str5, str6);
                    }
                    com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleHostMapping, target: " + str);
                    return str;
                }
                com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleHostMapping, nomatch: " + str3);
            }
        }
        return str;
    }

    public synchronized void e(Context context, boolean z) {
        if (!this.f66603b) {
            this.f66604c = context;
            this.m = z;
            this.f66605d = new e(context, z);
            if (z) {
                s();
            }
            com.bytedance.sdk.adnet.d.d.c("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.f66606e + " probeVersion: " + this.f66607f);
            this.f66603b = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(o oVar, String str) {
        int i;
        long j;
        d n;
        if (oVar != null && this.m) {
            String e2 = oVar.e("tnc-cmd", null);
            if (TextUtils.isEmpty(e2)) {
                com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleTncProbe, no probeProto, " + str);
                return;
            }
            String[] split = e2.split("@");
            if (split != null && split.length == 2) {
                try {
                    i = Integer.parseInt(split[0]);
                    try {
                        j = Long.parseLong(split[1]);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleTncProbe, probeProto except, " + str);
                        j = 0L;
                        com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleTncProbe, local: " + this.f66606e + "@" + this.f66607f + " svr: " + i + "@" + j + " " + str);
                        if (j > this.f66607f) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 0;
                }
                com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleTncProbe, local: " + this.f66606e + "@" + this.f66607f + " svr: " + i + "@" + j + " " + str);
                if (j > this.f66607f) {
                    return;
                }
                this.f66606e = i;
                this.f66607f = j;
                this.f66604c.getSharedPreferences("ttnet_tnc_config", 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
                if (this.f66606e != 10000 || (n = n()) == null) {
                    return;
                }
                Random random = new Random(System.currentTimeMillis());
                int i2 = n.l;
                long nextInt = i2 > 0 ? random.nextInt(i2) * 1000 : 0L;
                com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleTncProbe, updateConfig delay: " + nextInt + " " + str);
                i(true, nextInt);
                return;
            }
            com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleTncProbe, probeProto err, " + str);
        }
    }

    public final void h(boolean z) {
        d n = n();
        if (n == null) {
            return;
        }
        com.bytedance.sdk.adnet.d.d.c("TNCManager", "doUpdateRemote, " + z);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.f66602a + (n.k * 1000) > elapsedRealtime) {
            com.bytedance.sdk.adnet.d.d.c("TNCManager", "doUpdateRemote, time limit");
            return;
        }
        this.f66602a = elapsedRealtime;
        a.b.a(this.f66604c).m(d.c.c.b.e.e.a(this.f66604c));
    }

    public final void i(boolean z, long j) {
        if (this.o.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.o.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.o.sendMessageDelayed(obtainMessage, j);
        } else {
            this.o.sendMessage(obtainMessage);
        }
    }

    public final boolean j(int i) {
        return i >= 200 && i < 400;
    }

    public void k() {
        this.n.clear();
    }

    public final void l(String str) {
        Map<String, String> p2;
        if (TextUtils.isEmpty(str) || (p2 = p()) == null || !p2.containsValue(str)) {
            return;
        }
        if (this.n.get(str) == null) {
            this.n.put(str, 1);
        } else {
            this.n.put(str, Integer.valueOf(this.n.get(str).intValue() + 1));
        }
    }

    public final boolean m(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        d n = n();
        if (n == null || TextUtils.isEmpty(n.m)) {
            return false;
        }
        String str = n.m;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        return str.contains(sb.toString());
    }

    public d n() {
        e eVar = this.f66605d;
        if (eVar != null) {
            return eVar.e();
        }
        return null;
    }

    public final void o(String str) {
        if (!TextUtils.isEmpty(str) && this.n.containsKey(str)) {
            this.n.put(str, 0);
        }
    }

    public Map<String, String> p() {
        d n = n();
        if (n != null) {
            return n.f66593d;
        }
        return null;
    }

    public final boolean q(String str) {
        Map<String, String> p2 = p();
        if (p2 == null) {
            return false;
        }
        String str2 = p2.get(str);
        if (TextUtils.isEmpty(str2) || this.n.get(str2) == null || this.n.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.adnet.d.d.c("TNCManager", "handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    public e r() {
        return this.f66605d;
    }

    public final void s() {
        SharedPreferences sharedPreferences = this.f66604c.getSharedPreferences("ttnet_tnc_config", 0);
        this.f66606e = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.f66607f = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    public final void t() {
        com.bytedance.sdk.adnet.d.d.c("TNCManager", "resetTNCControlState");
        this.f66608g = 0;
        this.f66609h.clear();
        this.i.clear();
        this.j = 0;
        this.k.clear();
        this.l.clear();
    }
}
