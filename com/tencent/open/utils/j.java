package com.tencent.open.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alibaba.fastjson.asm.Label;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.BuildConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f42013a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f42014b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f42015c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f42016d = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f42017e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static String f42018f = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f42019g = "0123456789ABCDEF";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f42020a;

        /* renamed from: b  reason: collision with root package name */
        public long f42021b;

        /* renamed from: c  reason: collision with root package name */
        public long f42022c;

        public a(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42020a = str;
            this.f42021b = i2;
            if (str != null) {
                this.f42022c = str.length();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2036590800, "Lcom/tencent/open/utils/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2036590800, "Lcom/tencent/open/utils/j;");
        }
    }

    public static char a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) {
            int i3 = i2 & 15;
            return (char) (i3 < 10 ? i3 + 48 : (i3 - 10) + 97);
        }
        return invokeI.charValue;
    }

    public static Bundle a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            Bundle bundle = new Bundle();
            if (str != null) {
                try {
                    for (String str2 : str.split("&")) {
                        String[] split = str2.split("=");
                        if (split.length == 2) {
                            bundle.putString(URLDecoder.decode(split[0]), URLDecoder.decode(split[1]));
                        }
                    }
                    return bundle;
                } catch (Exception unused) {
                    return null;
                }
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static Bundle b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            try {
                URL url = new URL(str.replace("auth://", "http://"));
                Bundle a2 = a(url.getQuery());
                a2.putAll(a(url.getRef()));
                return a2;
            } catch (MalformedURLException unused) {
                return new Bundle();
            }
        }
        return (Bundle) invokeL.objValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            try {
                URL url = new URL(str.replace("auth://", "http://"));
                JSONObject a2 = a((JSONObject) null, url.getQuery());
                a(a2, url.getRef());
                return a2;
            } catch (MalformedURLException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject d(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str.equals("false")) {
                str = "{value : false}";
            }
            if (str.equals("true")) {
                str = "{value : true}";
            }
            if (str.contains("allback(")) {
                str = str.replaceFirst("[\\s\\S]*allback\\(([\\s\\S]*)\\);[^\\)]*\\z", "$1").trim();
            }
            if (str.contains("online[0]=")) {
                str = "{online:" + str.charAt(str.length() - 2) + "}";
            }
            return new JSONObject(str);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) ? str == null || str.length() == 0 : invokeL.booleanValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mtt", 64);
                String str = packageInfo.versionName;
                if (h.a(str, "4.3") >= 0 && !str.startsWith("4.4") && (signatureArr = packageInfo.signatures) != null) {
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                        messageDigest.update(signatureArr[0].toByteArray());
                        String a2 = a(messageDigest.digest());
                        messageDigest.reset();
                        if (a2.equals("d8391a394d4a179e6fe7bdb8a301258b")) {
                            return true;
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        com.tencent.open.a.f.e("openSDK_LOG.Util", "isQQBrowerAvailable has exception: " + e2.getMessage());
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static final boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
            if (str == null) {
                return false;
            }
            return str.startsWith("http://") || str.startsWith("https://");
        }
        return invokeL.booleanValue;
    }

    public static boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) ? str != null && new File(str).exists() : invokeL.booleanValue;
    }

    public static byte[] i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, context, str)) == null) {
            if (context == null) {
                return "";
            }
            String d2 = d(context, str);
            f42015c = d2;
            return d2;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65566, null, context, str)) == null) {
            boolean z = !d(context) || h.a(context, Constants.PACKAGE_QQ_PAD) == null;
            if (z && h.a(context, Constants.PACKAGE_TIM) != null) {
                z = false;
            }
            if (z) {
                return h.c(context, str) < 0;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? h.c(context, "5.9.5") >= 0 || h.a(context, Constants.PACKAGE_TIM) != null : invokeL.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return (Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory() : null) != null;
        }
        return invokeV.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Location lastKnownLocation;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65554, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        if (context == null) {
            return "";
        }
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setCostAllowed(false);
            criteria.setAccuracy(2);
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider == null || (lastKnownLocation = locationManager.getLastKnownLocation(bestProvider)) == null) {
                return "";
            }
            String str = lastKnownLocation.getLatitude() + "*" + lastKnownLocation.getLongitude();
            f42018f = str;
            return str;
        } catch (Exception e2) {
            com.tencent.open.a.f.b("openSDK_LOG.Util", "getLocation>>>", e2);
        }
        return "";
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            if (str != null) {
                for (String str2 : str.split("&")) {
                    String[] split = str2.split("=");
                    if (split.length == 2) {
                        try {
                            split[0] = URLDecoder.decode(split[0]);
                            split[1] = URLDecoder.decode(split[1]);
                        } catch (Exception unused) {
                        }
                        try {
                            jSONObject.put(split[0], split[1]);
                        } catch (JSONException e2) {
                            com.tencent.open.a.f.e("openSDK_LOG.Util", "decodeUrlToJson has exception: " + e2.getMessage());
                        }
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.isConnectedOrConnecting()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, context, str)) == null) {
            if (context == null) {
                return "";
            }
            b(context, str);
            return f42013a;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean d(Context context) {
        double d2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                d2 = Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
            } catch (Throwable unused) {
                d2 = 0.0d;
            }
            return d2 > 6.5d;
        }
        return invokeL.booleanValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(i(str));
                byte[] digest = messageDigest.digest();
                if (digest != null) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : digest) {
                        sb.append(a(b2 >>> 4));
                        sb.append(a(b2));
                    }
                    return sb.toString();
                }
                return str;
            } catch (NoSuchAlgorithmException e2) {
                com.tencent.open.a.f.e("openSDK_LOG.Util", "encrypt has exception: " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, context, str) == null) || context == null) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            String str2 = packageInfo.versionName;
            f42014b = str2;
            f42013a = str2.substring(0, str2.lastIndexOf(46));
            f42016d = f42014b.substring(f42014b.lastIndexOf(46) + 1, f42014b.length());
            f42017e = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            com.tencent.open.a.f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e2.getMessage());
        } catch (Exception e3) {
            com.tencent.open.a.f.e("openSDK_LOG.Util", "getPackageInfo has exception: " + e3.getMessage());
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
                return "";
            } catch (SocketException e2) {
                com.tencent.open.a.f.a("openSDK_LOG.Util", "getUserIp SocketException ", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, context, str)) == null) {
            if (context == null) {
                return "";
            }
            b(context, str);
            return f42014b;
        }
        return (String) invokeLL.objValue;
    }

    public static boolean f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, context, str)) == null) {
            boolean z = !d(context) || h.a(context, Constants.PACKAGE_QQ_PAD) == null;
            if (z && h.a(context, Constants.PACKAGE_TIM) != null) {
                z = false;
            }
            if (z) {
                return h.c(context, str) < 0;
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            try {
                z = f(context);
            } catch (Exception unused) {
                z = false;
            }
            try {
                if (z) {
                    a(context, "com.tencent.mtt", "com.tencent.mtt.MainActivity", str);
                } else {
                    a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                }
                return true;
            } catch (Exception unused2) {
                if (z) {
                    try {
                        try {
                            try {
                                a(context, "com.android.browser", "com.android.browser.BrowserActivity", str);
                                return true;
                            } catch (Exception unused3) {
                                a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                                return true;
                            }
                        } catch (Exception unused4) {
                            a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                            return true;
                        }
                    } catch (Exception unused5) {
                        return false;
                    }
                }
                try {
                    try {
                        a(context, "com.google.android.browser", "com.android.browser.BrowserActivity", str);
                        return true;
                    } catch (Exception unused6) {
                        return false;
                    }
                } catch (Exception unused7) {
                    a(context, "com.android.chrome", "com.google.android.apps.chrome.Main", str);
                    return true;
                }
            }
        }
        return invokeLL.booleanValue;
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65547, null, context, str, str2, str3) == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(str, str2));
            intent.setAction("android.intent.action.VIEW");
            intent.addFlags(1073741824);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            intent.setData(Uri.parse(str3));
            context.startActivity(intent);
        }
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b2 : bArr) {
                String num = Integer.toString(b2 & 255, 16);
                if (num.length() == 1) {
                    num = "0" + num;
                }
                sb.append(num);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static final String a(Context context) {
        InterceptResult invokeL;
        CharSequence applicationLabel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (context == null || (applicationLabel = context.getPackageManager().getApplicationLabel(context.getApplicationInfo())) == null) {
                return null;
            }
            return applicationLabel.toString();
        }
        return (String) invokeL.objValue;
    }

    public static final String a(String str, int i2, String str2, String str3) {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65544, null, str, i2, str2, str3)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "UTF-8";
            }
            try {
                if (str.getBytes(str2).length <= i2) {
                    return str;
                }
                int i3 = 0;
                int i4 = 0;
                while (i3 < str.length()) {
                    int i5 = i3 + 1;
                    i4 += str.substring(i3, i5).getBytes(str2).length;
                    if (i4 > i2) {
                        String substring = str.substring(0, i3);
                        if (TextUtils.isEmpty(str3)) {
                            return substring;
                        }
                        return substring + str3;
                    }
                    i3 = i5;
                }
                return str;
            } catch (Exception e2) {
                com.tencent.open.a.f.e("openSDK_LOG.Util", "Util.subString has exception: " + e2.getMessage());
                return str;
            }
        }
        return (String) invokeLILL.objValue;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, str4, str5, str6})) == null) ? a(str, str3, str4, str2, str5, str6, "", "", "", "", "", "") : (Bundle) invokeCommon.objValue;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("openid", str);
            bundle.putString("report_type", str2);
            bundle.putString("act_type", str3);
            bundle.putString("via", str4);
            bundle.putString("app_id", str5);
            bundle.putString("result", str6);
            bundle.putString("type", str7);
            bundle.putString(DpStatConstants.KEY_LOGIN_STATUS, str8);
            bundle.putString("need_user_auth", str9);
            bundle.putString("to_uin", str10);
            bundle.putString("call_source", str11);
            bundle.putString("to_type", str12);
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{str, str2, str3, str4, str5, str6, str7, str8, str9})) == null) {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.PARAM_PLATFORM, "1");
            bundle.putString("result", str);
            bundle.putString("code", str2);
            bundle.putString("tmcost", str3);
            bundle.putString("rate", str4);
            bundle.putString("cmd", str5);
            bundle.putString("uin", str6);
            bundle.putString("appid", str7);
            bundle.putString("share_type", str8);
            bundle.putString("detail", str9);
            bundle.putString("os_ver", Build.VERSION.RELEASE);
            bundle.putString("network", com.tencent.open.b.a.a(e.a()));
            bundle.putString("apn", com.tencent.open.b.a.b(e.a()));
            bundle.putString("model_name", Build.MODEL);
            bundle.putString("sdk_ver", Constants.SDK_VERSION);
            bundle.putString("packagename", e.b());
            bundle.putString(IAdRequestParam.APV, d(e.a(), e.b()));
            return bundle;
        }
        return (Bundle) invokeCommon.objValue;
    }

    public static boolean a(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65549, null, context, z)) == null) {
            if (!d(context) || h.a(context, Constants.PACKAGE_QQ_PAD) == null) {
                return !z ? h.c(context, BuildConfig.VERSION_NAME) >= 0 || h.a(context, Constants.PACKAGE_TIM) != null : h.c(context, BuildConfig.VERSION_NAME) >= 0 || h.a(context, Constants.PACKAGE_TIM) != null;
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }
}
