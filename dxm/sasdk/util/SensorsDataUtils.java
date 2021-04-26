package dxm.sasdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.core.content.ContextCompat;
import com.baidu.apollon.statistics.g;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import e.a.k;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class SensorsDataUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f67504a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f67505b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f67506c;

    static {
        new HashMap<String, String>() { // from class: dxm.sasdk.util.SensorsDataUtils.1
            {
                put("46000", "中国移动");
                put("46002", "中国移动");
                put("46007", "中国移动");
                put("46008", "中国移动");
                put("46001", "中国联通");
                put("46006", "中国联通");
                put("46009", "中国联通");
                put("46003", "中国电信");
                put("46005", "中国电信");
                put("46011", "中国电信");
            }
        };
        f67506c = new ArrayList<String>() { // from class: dxm.sasdk.util.SensorsDataUtils.2
            {
                add("9774d56d682e549c");
                add("0123456789abcdef");
            }
        };
    }

    public static boolean a(Context context, String str) {
        try {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                k.b("SA.SensorsDataUtils", "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"" + str + "\" />");
                return false;
            }
            return true;
        } catch (Exception e2) {
            k.b("SA.SensorsDataUtils", e2.toString());
            return false;
        }
    }

    public static void b(Context context) {
        try {
            SharedPreferences.Editor edit = d(context).edit();
            edit.putString("sensorsdata.user.agent", null);
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static String c(Context context) {
        if (!TextUtils.isEmpty(f67504a)) {
            return f67504a;
        }
        try {
            f67504a = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return f67504a;
    }

    public static SharedPreferences d(Context context) {
        return context.getSharedPreferences("dxm.sasdk.sa", 0);
    }

    public static String e(Context context) {
        try {
            SharedPreferences d2 = d(context);
            String string = d2.getString("sensorsdata.user.agent", null);
            if (TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 17) {
                    try {
                        if (Class.forName("android.webkit.WebSettings").getMethod("getDefaultUserAgent", new Class[0]) != null) {
                            string = WebSettings.getDefaultUserAgent(context);
                        }
                    } catch (Exception unused) {
                        k.b("SA.SensorsDataUtils", "WebSettings NoSuchMethod: getDefaultUserAgent");
                    }
                } else {
                    try {
                        Class<?> cls = Class.forName("android.webkit.WebSettingsClassic");
                        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class, Class.forName("android.webkit.WebViewClassic"));
                        declaredConstructor.setAccessible(true);
                        string = (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(context, null), new Object[0]);
                    } catch (Exception unused2) {
                    }
                }
            }
            if (TextUtils.isEmpty(string)) {
                string = System.getProperty("http.agent");
            }
            if (!TextUtils.isEmpty(string)) {
                SharedPreferences.Editor edit = d2.edit();
                edit.putString("sensorsdata.user.agent", string);
                edit.apply();
            }
            return string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean f(Context context) {
        if (a(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean g(String str) {
        return (TextUtils.isEmpty(str) || f67506c.contains(str.toLowerCase())) ? false : true;
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof Date) {
                synchronized (f67505b) {
                    jSONObject2.put(next, f67505b.format((Date) obj));
                }
            } else {
                jSONObject2.put(next, obj);
            }
        }
    }

    public static String i(Context context) {
        NetworkInfo networkInfo;
        if (a(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnectedOrConnecting()) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return g.f3962b;
                    case 13:
                        return "4G";
                    default:
                        return "NULL";
                }
            }
            return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
        }
        return "NULL";
    }
}
