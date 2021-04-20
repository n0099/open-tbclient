package d.b.l.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.connect.ConnectManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.identity.NetworkParam;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import java.util.HashMap;
/* loaded from: classes.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f64717b = AppConfig.isDebug();

    /* renamed from: c  reason: collision with root package name */
    public static String f64718c = "networkparam";

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, Integer> f64719d;

    /* renamed from: a  reason: collision with root package name */
    public Context f64720a = AppRuntime.getAppContext();

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f64719d = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f64719d.put("3GNET", 21);
        f64719d.put("3GWAP", 22);
        f64719d.put("CMNET", 31);
        f64719d.put("UNINET", 32);
        f64719d.put("CTNET", 33);
        f64719d.put("CMWAP", 41);
        f64719d.put("UNIWAP", 42);
        f64719d.put("CTWAP", 43);
    }

    public String a(String str, boolean z) {
        if (z) {
            String b2 = b();
            if (TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.f64720a.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, NetworkParam.NET_TYPE_ID_DISCONNECT));
            }
            if (TextUtils.isEmpty(b2)) {
                return str;
            }
            if (!TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f64720a.getApplicationContext()).edit();
                edit.putString(NetworkParam.LAST_NETWORK_TYPE, b2);
                edit.apply();
            }
            return UrlUtil.addParam(str, "network", b2);
        }
        return UrlUtil.addParam(str, "network", b());
    }

    public String b() {
        String str;
        long uptimeMillis = f64717b ? SystemClock.uptimeMillis() : 0L;
        ConnectManager connectManager = new ConnectManager(this.f64720a);
        String netType = connectManager.getNetType();
        int subType = connectManager.getSubType();
        if (!TextUtils.isEmpty(netType)) {
            netType = netType.toUpperCase();
            Integer num = f64719d.get(netType);
            if (num == null) {
                num = 5;
            }
            str = num + "_" + subType;
        } else {
            str = ((Object) 5) + "_" + subType;
        }
        if (f64717b) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            Log.i(f64718c, "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName());
        }
        return str;
    }
}
