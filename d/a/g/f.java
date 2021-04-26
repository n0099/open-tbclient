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
    public static volatile f f40721a;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i2, ArrayList<String> arrayList, ArrayList<String> arrayList2, long j, String str);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f40722e;

        /* renamed from: f  reason: collision with root package name */
        public a f40723f;

        public b(String str, a aVar) {
            this.f40722e = str;
            this.f40723f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<String> arrayList;
            ArrayList<String> arrayList2;
            Map e2 = f.this.e(this.f40722e);
            if (e2 != null) {
                arrayList2 = (ArrayList) e2.get(HttpDnsCacheForHost.JSON_KEY_IPV6);
                arrayList = (ArrayList) e2.get("ipv4");
            } else {
                arrayList = null;
                arrayList2 = null;
            }
            this.f40723f.a(((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? -1 : 0, arrayList, arrayList2, 60L, this.f40722e);
        }
    }

    public static f b() {
        if (f40721a == null) {
            synchronized (f.class) {
                if (f40721a == null) {
                    f40721a = new f();
                }
            }
        }
        return f40721a;
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
