package d.a.l.c;

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
public class f {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f63141b = AppConfig.isDebug();

    /* renamed from: c  reason: collision with root package name */
    public static String f63142c = "networkparam";

    /* renamed from: d  reason: collision with root package name */
    public static HashMap<String, Integer> f63143d;

    /* renamed from: a  reason: collision with root package name */
    public Context f63144a = AppRuntime.getAppContext();

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        f63143d = hashMap;
        hashMap.put(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 1);
        f63143d.put("3GNET", 21);
        f63143d.put("3GWAP", 22);
        f63143d.put("CMNET", 31);
        f63143d.put("UNINET", 32);
        f63143d.put("CTNET", 33);
        f63143d.put("CMWAP", 41);
        f63143d.put("UNIWAP", 42);
        f63143d.put("CTWAP", 43);
    }

    public String a(String str, boolean z) {
        if (z) {
            String b2 = b();
            if (TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                return UrlUtil.addParam(str, "network", PreferenceManager.getDefaultSharedPreferences(this.f63144a.getApplicationContext()).getString(NetworkParam.LAST_NETWORK_TYPE, NetworkParam.NET_TYPE_ID_DISCONNECT));
            }
            if (TextUtils.isEmpty(b2)) {
                return str;
            }
            if (!TextUtils.equals(b2, NetworkParam.NET_TYPE_ID_DISCONNECT)) {
                SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f63144a.getApplicationContext()).edit();
                edit.putString(NetworkParam.LAST_NETWORK_TYPE, b2);
                edit.apply();
            }
            return UrlUtil.addParam(str, "network", b2);
        }
        return UrlUtil.addParam(str, "network", b());
    }

    public String b() {
        String str;
        long uptimeMillis = f63141b ? SystemClock.uptimeMillis() : 0L;
        ConnectManager connectManager = new ConnectManager(this.f63144a);
        String netType = connectManager.getNetType();
        int subType = connectManager.getSubType();
        if (!TextUtils.isEmpty(netType)) {
            netType = netType.toUpperCase();
            Integer num = f63143d.get(netType);
            if (num == null) {
                num = 5;
            }
            str = num + "_" + subType;
        } else {
            str = ((Object) 5) + "_" + subType;
        }
        if (f63141b) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            Log.i(f63142c, "getCurrentNetTypeId cost " + (uptimeMillis2 - uptimeMillis) + "ms, current net type: " + netType + ", type id: " + str + ", subtype id: " + subType + ", subtype name: " + connectManager.getSubTypeName());
        }
        return str;
    }
}
