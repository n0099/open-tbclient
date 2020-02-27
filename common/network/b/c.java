package common.network.b;

import com.baidu.bdhttpdns.BDHttpDns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;
/* loaded from: classes.dex */
public class c implements Dns {
    private BDHttpDns nuy;

    public c(BDHttpDns bDHttpDns) {
        this.nuy = bDHttpDns;
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        ArrayList<String> mg = this.nuy.f(str, false).mg();
        if (mg == null) {
            throw new UnknownHostException(str);
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : mg) {
            arrayList.add(InetAddress.getByName(str2));
        }
        return arrayList;
    }
}
