package d.a.r.a.e;

import android.content.Context;
import android.net.NetworkInfo;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f68086c;

    /* renamed from: a  reason: collision with root package name */
    public String f68087a;

    /* renamed from: b  reason: collision with root package name */
    public int f68088b;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f68086c = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f68086c.put("3GNET", 21);
        f68086c.put("3GWAP", 22);
        f68086c.put("CMNET", 31);
        f68086c.put("UNINET", 32);
        f68086c.put("CTNET", 33);
        f68086c.put("CMWAP", 41);
        f68086c.put("UNIWAP", 42);
        f68086c.put("CTWAP", 43);
    }

    public d(Context context) {
        String upperCase;
        NetworkInfo a2 = e.a(context);
        if (a2 != null) {
            if (!"wifi".equals(a2.getTypeName().toLowerCase())) {
                String extraInfo = a2.getExtraInfo();
                upperCase = extraInfo != null ? extraInfo.toUpperCase() : upperCase;
                this.f68088b = a2.getSubtype();
            }
            "wifi".toUpperCase();
            this.f68087a = upperCase;
            this.f68088b = a2.getSubtype();
        }
    }
}
