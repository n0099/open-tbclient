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
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import f.a.k;
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
/* loaded from: classes10.dex */
public final class SensorsDataUtils {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f78320a;

    /* renamed from: b  reason: collision with root package name */
    public static final SimpleDateFormat f78321b;

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f78322c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1376658533, "Ldxm/sasdk/util/SensorsDataUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1376658533, "Ldxm/sasdk/util/SensorsDataUtils;");
                return;
            }
        }
        f78321b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        new HashMap<String, String>() { // from class: dxm.sasdk.util.SensorsDataUtils.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
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
        f78322c = new ArrayList<String>() { // from class: dxm.sasdk.util.SensorsDataUtils.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                add("9774d56d682e549c");
                add("0123456789abcdef");
            }
        };
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            try {
                SharedPreferences.Editor edit = d(context).edit();
                edit.putString("sensorsdata.user.agent", null);
                edit.apply();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (!TextUtils.isEmpty(f78320a)) {
                return f78320a;
            }
            try {
                f78320a = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return f78320a;
        }
        return (String) invokeL.objValue;
    }

    public static SharedPreferences d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context.getSharedPreferences("dxm.sasdk.sa", 0) : (SharedPreferences) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? (TextUtils.isEmpty(str) || f78322c.contains(str.toLowerCase())) ? false : true : invokeL.booleanValue;
    }

    public static void h(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, jSONObject, jSONObject2) == null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof Date) {
                    synchronized (f78321b) {
                        jSONObject2.put(next, f78321b.format((Date) obj));
                    }
                } else {
                    jSONObject2.put(next, obj);
                }
            }
        }
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        NetworkInfo networkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (a(context, DefaultConnectivityMonitorFactory.NETWORK_PERMISSION)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnectedOrConnecting()) {
                    if (Build.VERSION.SDK_INT < 30 || a(context, "android.permission.READ_PHONE_STATE")) {
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
                                return "3G";
                            case 13:
                                return "4G";
                            default:
                                return "NULL";
                        }
                    }
                    return "NULL";
                }
                return CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING;
            }
            return "NULL";
        }
        return (String) invokeL.objValue;
    }
}
