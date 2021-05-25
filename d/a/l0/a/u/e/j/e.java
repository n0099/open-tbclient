package d.a.l0.a.u.e.j;

import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
import d.a.l0.a.j2.k;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes2.dex */
public class e implements Observer {
    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj instanceof NetRequestResult) {
            NetRequestResult netRequestResult = (NetRequestResult) obj;
            String url = netRequestResult.getUrl();
            String valueOf = String.valueOf(netRequestResult.getId());
            if (netRequestResult.getStatusCode() == 4 && url != null) {
                d.a.l0.a.h0.q.b.g().k(valueOf, url);
            }
            NetInfo netInfo = netRequestResult.getNetInfo();
            if (netRequestResult.getFromType() == 1 && url != null && netInfo != null) {
                d.a.l0.a.h0.q.b.g().t(valueOf, url, netInfo);
            }
            int statusCode = netRequestResult.getStatusCode();
            if (statusCode < 0 || statusCode >= 400) {
                String statusMsg = netRequestResult.getStatusMsg();
                NetInfo.Response response = netInfo.getResponse();
                NetInfo.Base base = netInfo.getBase();
                StringBuilder sb = new StringBuilder();
                sb.append(statusMsg);
                sb.append("; code=");
                sb.append(response != null ? Integer.valueOf(response.mCode) : "");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append("; status=");
                sb3.append(base != null ? Integer.valueOf(base.mStatus) : "");
                k.J(statusCode, netRequestResult.getUrl(), 0, sb3.toString(), 0L, 0L);
            }
        }
    }
}
