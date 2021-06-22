package d.a.r.a.e;

import android.content.Context;
import android.net.NetworkInfo;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap<String, Integer> f68190c;

    /* renamed from: a  reason: collision with root package name */
    public String f68191a;

    /* renamed from: b  reason: collision with root package name */
    public int f68192b;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f68190c = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f68190c.put("3GNET", 21);
        f68190c.put("3GWAP", 22);
        f68190c.put("CMNET", 31);
        f68190c.put("UNINET", 32);
        f68190c.put("CTNET", 33);
        f68190c.put("CMWAP", 41);
        f68190c.put("UNIWAP", 42);
        f68190c.put("CTWAP", 43);
    }

    public d(Context context) {
        String upperCase;
        NetworkInfo a2 = e.a(context);
        if (a2 != null) {
            if (!"wifi".equals(a2.getTypeName().toLowerCase())) {
                String extraInfo = a2.getExtraInfo();
                upperCase = extraInfo != null ? extraInfo.toUpperCase() : upperCase;
                this.f68192b = a2.getSubtype();
            }
            "wifi".toUpperCase();
            this.f68191a = upperCase;
            this.f68192b = a2.getSubtype();
        }
    }
}
