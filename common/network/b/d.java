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
    private c ntX;
    private Dns ntY;
    private static d ntW = null;
    private static boolean lKf = false;
    private static Set<String> ntZ = new HashSet();

    static {
        ntZ.add("quanmin.baidu.com");
    }

    public static void a(Context context, c cVar, Dns dns) {
        ntW = new d(cVar, dns);
        b.init(context);
    }

    public static d dHD() {
        return ntW;
    }

    private d(c cVar, Dns dns) {
        this.ntX = cVar;
        this.ntY = dns;
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
        return this.ntY.lookup(str);
    }

    private List<InetAddress> RL(String str) throws UnknownHostException {
        String[] RJ = b.dHC().RJ(str);
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
        List<InetAddress> lookup = this.ntX.lookup(str);
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
        b.dHC().h(str, (String[]) arrayList2.toArray(new String[0]));
        return arrayList;
    }

    public static boolean isInWhiteList(String str) {
        if (lKf) {
            return ntZ.contains(str);
        }
        return false;
    }
}
