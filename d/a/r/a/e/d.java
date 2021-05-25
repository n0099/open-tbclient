package d.a.r.a.e;

import android.content.Context;
import android.net.NetworkInfo;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f64368c;

    /* renamed from: a  reason: collision with root package name */
    public String f64369a;

    /* renamed from: b  reason: collision with root package name */
    public int f64370b;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f64368c = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f64368c.put("3GNET", 21);
        f64368c.put("3GWAP", 22);
        f64368c.put("CMNET", 31);
        f64368c.put("UNINET", 32);
        f64368c.put("CTNET", 33);
        f64368c.put("CMWAP", 41);
        f64368c.put("UNIWAP", 42);
        f64368c.put("CTWAP", 43);
    }

    public d(Context context) {
        String upperCase;
        NetworkInfo a2 = e.a(context);
        if (a2 != null) {
            if (!"wifi".equals(a2.getTypeName().toLowerCase())) {
                String extraInfo = a2.getExtraInfo();
                upperCase = extraInfo != null ? extraInfo.toUpperCase() : upperCase;
                this.f64370b = a2.getSubtype();
            }
            "wifi".toUpperCase();
            this.f64369a = upperCase;
            this.f64370b = a2.getSubtype();
        }
    }
}
