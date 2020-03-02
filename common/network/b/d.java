package common.network.b;

import android.content.Context;
import common.network.InetAddressValidator;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Dns;
/* loaded from: classes.dex */
public class d implements Dns {
    private c nuC;
    private Dns nuD;
    private static d nuB = null;
    private static boolean lKO = false;
    private static Set<String> nuE = new HashSet();

    static {
        nuE.add("quanmin.baidu.com");
    }

    public static void a(Context context, c cVar, Dns dns) {
        nuB = new d(cVar, dns);
        b.init(context);
    }

    public static d dIM() {
        return nuB;
    }

    private d(c cVar, Dns dns) {
        this.nuC = cVar;
        this.nuD = dns;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        List<InetAddress> RV;
        if (InetAddressValidator.getInstance().isValid(str)) {
            return Collections.singletonList(InetAddress.getByName(str));
        }
        try {
            if (!isInWhiteList(str)) {
                RV = RV(str);
            } else {
                try {
                    RV = RX(str);
                } catch (UnknownHostException e) {
                    RV = RV(str);
                }
            }
            return RV;
        } catch (UnknownHostException e2) {
            return RW(str);
        }
    }

    private List<InetAddress> RV(String str) throws UnknownHostException {
        return this.nuD.lookup(str);
    }

    private List<InetAddress> RW(String str) throws UnknownHostException {
        String[] RU = b.dIL().RU(str);
        if (RU.length <= 0) {
            throw new UnknownHostException("disaster recovery failed");
        }
        ArrayList arrayList = new ArrayList(RU.length);
        for (String str2 : RU) {
            arrayList.add(InetAddress.getByName(str2));
        }
        return arrayList;
    }

    private List<InetAddress> RX(String str) throws UnknownHostException {
        List<InetAddress> lookup = this.nuC.lookup(str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (InetAddress inetAddress : lookup) {
            if (!inetAddress.isAnyLocalAddress() && !inetAddress.isLinkLocalAddress() && !inetAddress.isLoopbackAddress() && !inetAddress.isSiteLocalAddress()) {
                arrayList.add(inetAddress);
                arrayList2.add(inetAddress.getHostAddress());
            }
        }
        if (arrayList.size() <= 0) {
            throw new UnknownHostException(String.format("%s has no valid ip", str));
        }
        b.dIL().h(str, (String[]) arrayList2.toArray(new String[0]));
        return arrayList;
    }

    public static boolean isInWhiteList(String str) {
        if (lKO) {
            return nuE.contains(str);
        }
        return false;
    }
}
