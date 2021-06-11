package i.a.a.c.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.yy.gslbsdk.DnsResultInfo;
import com.yy.gslbsdk.GslbEvent;
import com.yy.gslbsdk.HttpDnsService;
import com.yy.gslbsdk.thread.ThreadPoolMgr;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes8.dex */
public class a implements Dns {

    /* renamed from: a  reason: collision with root package name */
    public HttpDnsService f72038a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f72039b;

    /* renamed from: i.a.a.c.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1991a implements GslbEvent.GslbEventListener {
        public C1991a(a aVar) {
        }

        @Override // com.yy.gslbsdk.GslbEvent.GslbEventListener
        public void onMessage(String str) {
            RLog.debug(HttpDnsService.TAG, "OkHttpDns onMessage msg:" + str);
        }
    }

    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f72040a = new a(null);
    }

    public /* synthetic */ a(C1991a c1991a) {
        this();
    }

    public static a b() {
        return b.f72040a;
    }

    public List<String> a(String str) throws UnknownHostException {
        if (this.f72038a == null) {
            RLog.error("YYPayHttpDns", "getIPListByHost error mHttpDnsService null", new Object[0]);
            return null;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DnsResultInfo ipsByHost = this.f72038a.getIpsByHost(str);
        if (ipsByHost != null) {
            ArrayList arrayList = new ArrayList();
            String[] strArr = ipsByHost.mIpsV6;
            if (strArr != null) {
                arrayList.addAll(c(strArr));
                if (ipsByHost.mIpsV6.length == 0) {
                    RLog.error("YYPayHttpDns", "getIPListByHost IpsV6 empty hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
                }
            } else {
                RLog.error("YYPayHttpDns", "getIPListByHost IpsV6 null hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
            }
            String[] strArr2 = ipsByHost.mIpsV4;
            if (strArr2 != null) {
                arrayList.addAll(c(strArr2));
                if (ipsByHost.mIpsV4.length == 0) {
                    RLog.error("YYPayHttpDns", "getIPListByHost IpsV4 empty hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
                }
            } else {
                RLog.error("YYPayHttpDns", "getIPListByHost IpsV4 null hostname:" + str + " code:" + ipsByHost.mErrorCode, new Object[0]);
            }
            RLog.info("YYPayHttpDns", "hostname:" + str + " mDataSource:" + ipsByHost.mDataSource + " code:" + ipsByHost.mErrorCode + " res.IPList:" + arrayList + " use duration:" + (SystemClock.uptimeMillis() - uptimeMillis));
            return arrayList;
        }
        RLog.info("YYPayHttpDns", "getIPListByDns host:" + str + "  use duration:" + (SystemClock.uptimeMillis() - uptimeMillis));
        return null;
    }

    public List<String> c(String[] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public List<InetAddress> d(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    arrayList.add(InetAddress.getByName(str));
                } catch (UnknownHostException e2) {
                    RLog.error("YYPayHttpDns", "getByName(" + str + ") error", e2);
                }
            }
        }
        return arrayList;
    }

    public synchronized void e(Context context, String str, String str2) {
        if (!this.f72039b) {
            RLog.warn("YYPayHttpDns", "tryInitHttpDns but not enable appId:" + str + " hdid:" + str2);
        } else if (this.f72038a != null) {
            RLog.warn("YYPayHttpDns", "tryInitHttpDns but mHttpDnsService exit appId:" + str + " hdid:" + str2);
        } else if (context == null) {
            RLog.error("YYPayHttpDns", "tryInitHttpDns error context params null", new Object[0]);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            HttpDnsService service = HttpDnsService.getService(context, str, (ThreadPoolMgr.ITaskExecutor) null, str2, "CN");
            this.f72038a = service;
            service.setLogEnabled(Env.instance().isTestEnv());
            this.f72038a.setGslbEventMessager(new C1991a(this));
            this.f72038a.setHttpsEnable(true);
            this.f72038a.setNetworkStatus(3);
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(Env.instance().REVENUE_HTTP_URL);
            if (!Env.instance().isTestEnv()) {
                arrayList.addAll(Arrays.asList(Env.instance().BACKUP_DOMAIN_POOL));
            }
            RLog.info("YYPayHttpDns", "PreResolveHost hosts:" + arrayList.toString());
            this.f72038a.setPreResolveHosts(arrayList);
            RLog.info("YYPayHttpDns", "dns init success cost time = " + (System.currentTimeMillis() - currentTimeMillis) + " appId:" + str + " hdid:" + str2);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(5:5|6|7|(3:16|17|18)|(2:12|13)(1:15))|25|(1:9)|16|17|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        com.yy.mobile.framework.revenuesdk.baseapi.log.RLog.error("YYPayHttpDns", "System lookup dns error", r5);
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // okhttp3.Dns
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<InetAddress> lookup(String str) {
        List<InetAddress> list;
        if (this.f72039b && this.f72038a != null) {
            RLog.info("YYPayHttpDns", "httpdns lookup ");
            try {
                list = d(a(str));
            } catch (Exception e2) {
                RLog.error("YYPayHttpDns", "lookup exception:" + e2.getLocalizedMessage(), new Object[0]);
            }
            if (list != null || list.isEmpty()) {
                RLog.info("YYPayHttpDns", "system lookup");
                list = Dns.SYSTEM.lookup(str);
            }
            return list != null ? Collections.emptyList() : list;
        }
        list = null;
        if (list != null) {
        }
        RLog.info("YYPayHttpDns", "system lookup");
        list = Dns.SYSTEM.lookup(str);
        if (list != null) {
        }
    }

    public a() {
        this.f72038a = null;
        this.f72039b = true;
        RLog.warn("YYPayHttpDns", "new OkHttpDns:" + toString());
    }
}
