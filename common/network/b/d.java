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
    private c ntS;
    private Dns ntT;
    private static d ntR = null;
    private static boolean lKa = false;
    private static Set<String> ntU = new HashSet();

    static {
        ntU.add("quanmin.baidu.com");
    }

    public static void a(Context context, c cVar, Dns dns) {
        ntR = new d(cVar, dns);
        b.init(context);
    }

    public static d dHB() {
        return ntR;
    }

    private d(c cVar, Dns dns) {
        this.ntS = cVar;
        this.ntT = dns;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        List<InetAddress> RK;
        if (InetAddressValidator.getInstance().isValid(str)) {
            return Collections.singletonList(InetAddress.getByName(str));
        }
        try {
            if (!isInWhiteList(str)) {
                RK = RK(str);
            } else {
                try {
                    RK = RM(str);
                } catch (UnknownHostException e) {
                    RK = RK(str);
                }
            }
            return RK;
        } catch (UnknownHostException e2) {
            return RL(str);
        }
    }

    private List<InetAddress> RK(String str) throws UnknownHostException {
        return this.ntT.lookup(str);
    }

    private List<InetAddress> RL(String str) throws UnknownHostException {
        String[] RJ = b.dHA().RJ(str);
        if (RJ.length <= 0) {
            throw new UnknownHostException("disaster recovery failed");
        }
        ArrayList arrayList = new ArrayList(RJ.length);
        for (String str2 : RJ) {
            arrayList.add(InetAddress.getByName(str2));
        }
        return arrayList;
    }

    private List<InetAddress> RM(String str) throws UnknownHostException {
        List<InetAddress> lookup = this.ntS.lookup(str);
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
        b.dHA().h(str, (String[]) arrayList2.toArray(new String[0]));
        return arrayList;
    }

    public static boolean isInWhiteList(String str) {
        if (lKa) {
            return ntU.contains(str);
        }
        return false;
    }
}
