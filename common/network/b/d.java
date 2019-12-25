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
    private c mRL;
    private Dns mRM;
    private static d mRK = null;
    private static boolean lGC = false;
    private static Set<String> mRN = new HashSet();

    static {
        mRN.add("quanmin.baidu.com");
    }

    public static void a(Context context, c cVar, Dns dns) {
        mRK = new d(cVar, dns);
        b.init(context);
    }

    public static d dDv() {
        return mRK;
    }

    private d(c cVar, Dns dns) {
        this.mRL = cVar;
        this.mRM = dns;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        List<InetAddress> QX;
        if (InetAddressValidator.getInstance().isValid(str)) {
            return Collections.singletonList(InetAddress.getByName(str));
        }
        try {
            if (!isInWhiteList(str)) {
                QX = QX(str);
            } else {
                try {
                    QX = QZ(str);
                } catch (UnknownHostException e) {
                    QX = QX(str);
                }
            }
            return QX;
        } catch (UnknownHostException e2) {
            return QY(str);
        }
    }

    private List<InetAddress> QX(String str) throws UnknownHostException {
        return this.mRM.lookup(str);
    }

    private List<InetAddress> QY(String str) throws UnknownHostException {
        String[] QW = b.dDu().QW(str);
        if (QW.length <= 0) {
            throw new UnknownHostException("disaster recovery failed");
        }
        ArrayList arrayList = new ArrayList(QW.length);
        for (String str2 : QW) {
            arrayList.add(InetAddress.getByName(str2));
        }
        return arrayList;
    }

    private List<InetAddress> QZ(String str) throws UnknownHostException {
        List<InetAddress> lookup = this.mRL.lookup(str);
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
        b.dDu().h(str, (String[]) arrayList2.toArray(new String[0]));
        return arrayList;
    }

    public static boolean isInWhiteList(String str) {
        if (lGC) {
            return mRN.contains(str);
        }
        return false;
    }
}
