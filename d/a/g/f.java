package d.a.g;

import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f43554a;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f43555e;

        /* renamed from: f  reason: collision with root package name */
        public a f43556f;

        public b(String str, a aVar) {
            this.f43555e = str;
            this.f43556f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2;
            Map e2 = f.this.e(this.f43555e);
            if (e2 != null) {
                arrayList2 = (ArrayList) e2.get(HttpDnsCacheForHost.JSON_KEY_IPV6);
                arrayList = (ArrayList) e2.get("ipv4");
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            this.f43556f.a(((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? -1 : 0, arrayList, arrayList2, 60L, this.f43555e);
        }
    }

    public static f b() {
        if (f43554a == null) {
            synchronized (f.class) {
                if (f43554a == null) {
                    f43554a = new f();
                }
            }
        }
        return f43554a;
    }

    public BDHttpDnsResult a(String str) {
        ArrayList arrayList;
        Map<String, ArrayList> e2 = e(str);
        ArrayList arrayList2 = null;
        if (e2 != null) {
            arrayList2 = e2.get("ipv4");
            arrayList = e2.get(HttpDnsCacheForHost.JSON_KEY_IPV6);
        } else {
            arrayList = null;
        }
        return ((arrayList2 == null || arrayList2.isEmpty()) && (arrayList == null || arrayList.isEmpty())) ? new BDHttpDnsResult(BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveErrorDnsResolve) : new BDHttpDnsResult(BDHttpDnsResult.ResolveType.RESOLVE_FROM_DNS, BDHttpDnsResult.ResolveStatus.BDHttpDnsResolveOK, arrayList2, arrayList);
    }

    public void d(String str, a aVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        l.a().b().execute(new b(str, aVar));
    }

    public final Map<String, ArrayList> e(String str) {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null || allByName.length == 0) {
                k.a("Dns resolve failed, host(%s), get empty resolve result", str);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            for (InetAddress inetAddress : allByName) {
                if (inetAddress instanceof Inet4Address) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (e.e(hostAddress)) {
                        arrayList.add(hostAddress);
                    }
                } else if (inetAddress instanceof Inet6Address) {
                    String hostAddress2 = inetAddress.getHostAddress();
                    if (e.g(hostAddress2)) {
                        arrayList2.add(hostAddress2);
                    }
                }
            }
            hashMap.put("ipv4", arrayList);
            hashMap.put(HttpDnsCacheForHost.JSON_KEY_IPV6, arrayList2);
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                k.a("Dns resolve failed, host(%s), get no valid resolve result", str);
                return null;
            }
            k.a("Dns resolve successful, host(%s), ipv4List(%s), ipv6List(%s)", str, arrayList.toString(), arrayList2.toString());
            return hashMap;
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
            k.a("Dns resolve failed, host(%s), caught UnknownHostException", str);
            return null;
        }
    }
}
