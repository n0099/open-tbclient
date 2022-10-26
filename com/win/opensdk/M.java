package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.win.opensdk.core.Info;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class M {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, context, f)) == null) ? (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static int a(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) ? (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLI.intValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                return a(context) + File.separator + "win" + File.separator + e(str);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65544, null, str, str2, i)) == null) {
            if (i > 0) {
                try {
                    return str.replaceAll(str2, String.valueOf(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLLI.objValue;
    }

    public static String a(String str, String str2, boolean z, HashMap hashMap) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{str, str2, Boolean.valueOf(z), hashMap})) == null) {
            try {
                String replaceAll = str.replaceAll("__TIMESTAMP__", String.valueOf(System.currentTimeMillis()));
                if (hashMap != null && hashMap.size() > 0) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        replaceAll = replaceAll.replaceAll((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                return z ? b(replaceAll, str2) : replaceAll;
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static HashMap a(HashMap hashMap, int i, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{hashMap, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            hashMap.put("view_dx", Integer.valueOf(i));
            hashMap.put("view_dy", Integer.valueOf(i2));
            hashMap.put("view_ux", Integer.valueOf(i3));
            hashMap.put("view_uy", Integer.valueOf(i4));
            hashMap.put("view_width", Integer.valueOf(i5));
            hashMap.put("view_height", Integer.valueOf(i6));
            return hashMap;
        }
        return (HashMap) invokeCommon.objValue;
    }

    public static void a(Context context, Info info) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, info) == null) {
            info.setLoad(a1.a(context, info.getLoad(), f(context), info.getMaterial(), new Y0(context, info)));
        }
    }

    public static void a(WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, webView) == null) {
            try {
                webView.setHorizontalScrollbarOverlay(false);
                webView.setHorizontalScrollBarEnabled(false);
                webView.setVerticalScrollbarOverlay(false);
                webView.setVerticalScrollBarEnabled(false);
                webView.setBackgroundColor(0);
                webView.setScrollBarStyle(0);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDomStorageEnabled(true);
                settings.setBuiltInZoomControls(false);
                settings.setAppCacheEnabled(true);
                settings.setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());
                settings.setDatabaseEnabled(true);
                settings.setSupportZoom(false);
                settings.setDisplayZoomControls(false);
                settings.setCacheMode(-1);
                settings.setUseWideViewPort(false);
                settings.setLightTouchEnabled(false);
                settings.setLoadsImagesAutomatically(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setAllowFileAccess(true);
                if (Build.VERSION.SDK_INT >= 11) {
                    settings.setAllowContentAccess(false);
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    settings.setAllowFileAccessFromFileURLs(false);
                    settings.setAllowUniversalAccessFromFileURLs(false);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    settings.setMixedContentMode(0);
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    settings.setMediaPlaybackRequiresUserGesture(false);
                }
                CookieManager cookieManager = CookieManager.getInstance();
                if (cookieManager != null) {
                    cookieManager.setAcceptCookie(true);
                    if (Build.VERSION.SDK_INT >= 21) {
                        cookieManager.setAcceptThirdPartyCookies(webView, true);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(Info info) {
        String vv_show_urls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, info) == null) {
            try {
                a(info, 100, "");
                if (info != null && !TextUtils.isEmpty(info.getImp_urls())) {
                    vv_show_urls = info.getImp_urls();
                } else if (info == null || TextUtils.isEmpty(info.getVv_show_urls())) {
                    return;
                } else {
                    vv_show_urls = info.getVv_show_urls();
                }
                g(vv_show_urls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Info info, String str) {
        String vv_click_urls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, info, str) == null) {
            try {
                a(info, 200, str);
                if (info != null && !TextUtils.isEmpty(info.getClick_urls())) {
                    vv_click_urls = info.getClick_urls();
                } else if (info == null || TextUtils.isEmpty(info.getVv_click_urls())) {
                    return;
                } else {
                    vv_click_urls = info.getVv_click_urls();
                }
                g(vv_click_urls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, file) == null) {
            try {
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        file.delete();
                        return;
                    }
                    for (File file2 : file.listFiles()) {
                        a(file2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) {
            try {
                Runtime.getRuntime().exec("chmod " + str + " " + str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(byte[] bArr, String str, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, null, bArr, str, kVar) == null) {
            new Thread(new d0(bArr, str, kVar)).start();
        }
    }

    public static boolean a(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, strArr, str)) == null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static long b(File file) {
        InterceptResult invokeL;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, file)) == null) {
            if (!file.exists()) {
                throw new IllegalArgumentException(file + " does not exist");
            } else if (!file.isDirectory()) {
                throw new IllegalArgumentException(file + " is not a directory");
            } else {
                long j = 0;
                for (File file2 : file.listFiles()) {
                    j = (file2.isDirectory() ? b(file2) : file2.length()) + j;
                }
                return j;
            }
        }
        return invokeL.longValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) ? context.getPackageName() : (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                int intValue = ((Integer) jSONObject.get("view_width")).intValue();
                int intValue2 = ((Integer) jSONObject.get("view_height")).intValue();
                int intValue3 = ((Integer) jSONObject.get("view_dx")).intValue();
                int intValue4 = ((Integer) jSONObject.get("view_dy")).intValue();
                return a(a(a(a(a(a(str, "__WIDTH__", intValue), "__HEIGHT__", intValue2), "__DOWN_X__", intValue3), "__DOWN_Y__", intValue4), "__UP_X__", ((Integer) jSONObject.get("view_ux")).intValue()), "__UP_Y__", ((Integer) jSONObject.get("view_uy")).intValue());
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, context, str)) == null) {
            try {
                return new File(a(context) + File.separator + "win" + File.separator + e(str)).exists();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, context)) == null) {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            return displayMetrics.heightPixels;
        }
        return invokeL.intValue;
    }

    public static String c(String str) {
        byte b;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes("UTF-8"));
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < digest.length; i++) {
                    if (Integer.toHexString(digest[i] & 255).length() == 1) {
                        stringBuffer.append("0");
                        b = digest[i];
                    } else {
                        b = digest[i];
                    }
                    stringBuffer.append(Integer.toHexString(b & 255));
                }
                return stringBuffer.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            try {
                if (str.length() > 250) {
                    str = str.substring(0, 250);
                }
                if (str.contains("/") && (split = str.split("/")) != null && split.length > 0) {
                    return split[split.length - 1];
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
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

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, context)) == null) {
            File externalCacheDir = context.getExternalCacheDir();
            String absolutePath = externalCacheDir == null ? context.getCacheDir().getAbsolutePath() : externalCacheDir.getAbsolutePath();
            return absolutePath + File.separator + "adche";
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) ? str == null || str.length() == 0 : invokeL.booleanValue;
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        b2.a(new g1(optString));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static byte[] h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return new byte[0];
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes("UTF-8"));
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static int a(U0 u0, y1 y1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, u0, y1Var)) == null) {
            byte[] bArr = u0.b;
            int i = u0.a;
            if (i == 200) {
                y1Var.a(new String(bArr, "UTF-8"));
                return y1Var.a;
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static Intent a(Info info, Context context, String str) {
        InterceptResult invokeLLL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, info, context, str)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                try {
                    if (Build.VERSION.SDK_INT == 23) {
                        a("777", a(context) + "/win/");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                a("777", str);
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.setAction("android.intent.action.INSTALL_PACKAGE");
                    intent.setFlags(268435457);
                    fromFile = FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileProvider", new File(str));
                } else {
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    fromFile = Uri.fromFile(new File(str));
                }
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                return intent;
            } catch (Exception e2) {
                String str2 = "错误:" + e2.getMessage();
                e2.printStackTrace();
                if (info != null) {
                    d1 a = e1.a(context);
                    try {
                        a.b = e1.a("wiin", new f1(info));
                        a.a("msg", e1.a(str));
                    } catch (JSONException unused) {
                    }
                    a.a();
                }
                return intent;
            }
        }
        return (Intent) invokeLLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        boolean z;
        File cacheDir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                cacheDir = context.getExternalCacheDir();
            } else {
                cacheDir = context.getCacheDir();
            }
            return cacheDir.getPath();
        }
        return (String) invokeL.objValue;
    }

    public static String a(Context context, String str, String str2) {
        Signature[] signatureArr;
        String str3;
        MessageDigest messageDigest;
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, context, str, str2)) == null) {
            try {
                try {
                    signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    byte[] byteArray = signatureArr[0].toByteArray();
                    try {
                        messageDigest = MessageDigest.getInstance(str2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        str3 = sb.toString().toUpperCase();
                        return str3.toUpperCase();
                    }
                    str3 = "error!";
                    return str3.toUpperCase();
                }
                return "ERROR";
            } catch (Exception e3) {
                e3.printStackTrace();
                return "ERROR";
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("aTFob21lOGw=", 0);
            StringBuilder sb2 = new StringBuilder();
            for (byte b : decode) {
                sb2.append((char) b);
            }
            sb.append(sb2.toString());
            sb.append("mloo0ks9");
            String sb3 = sb.toString();
            if (f(sb3) || f(str)) {
                str2 = "";
            } else {
                byte[] bytes = sb3.getBytes(IMAudioTransRequest.CHARSET);
                byte[] bArr = new byte[16];
                for (int i = 0; i < bytes.length && i < 16; i++) {
                    bArr[i] = bytes[i];
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(1, secretKeySpec);
                str2 = Base64.encodeToString(cipher.doFinal(str.getBytes(IMAudioTransRequest.CHARSET)), 2);
            }
            if (!TextUtils.isEmpty(str2)) {
                return "KL_" + str2;
            }
            return str2;
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("Y2wyaQ==", 2);
            StringBuilder sb2 = new StringBuilder();
            for (byte b : decode) {
                sb2.append((char) b);
            }
            sb.append(sb2.toString());
            sb.append("4c6k");
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            byte[] decode2 = Base64.decode("YjJsbw==", 0);
            StringBuilder sb5 = new StringBuilder();
            for (byte b2 : decode2) {
                sb5.append((char) b2);
            }
            sb4.append(sb5.toString());
            sb4.append("o7my");
            K1 k1 = new K1(sb3, sb4.toString());
            Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
            cipher.init(2, k1.b, k1.a);
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
            }
            return new String(cipher.doFinal(bArr), IMAudioTransRequest.CHARSET);
        }
        return (String) invokeL.objValue;
    }

    public static HashMap a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("Accept-Encoding", Collections.singletonList("application/gzip"));
            hashMap.put("Content-Encoding", Collections.singletonList("application/gzip"));
            hashMap.put("User-Agent", Collections.singletonList(e2.a));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void a(Info info, int i, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(65551, null, info, i, str) == null) && info != null) {
            g(a((String) info.getEvents().get(i, ""), str, info.isHo_c_sw(), null));
        }
    }

    public static void a(String str, Map map, S0 s0) {
        String message;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, str, map, s0) == null) {
            try {
                s0.a();
                U0 a = new T0(str, "GET", a(map)).a();
                y1 y1Var = new y1();
                int a2 = a(a, y1Var);
                if (a2 == 200) {
                    s0.a(y1Var);
                } else {
                    s0.a(a2, y1Var.b);
                }
            } catch (JSONException e) {
                message = e.getMessage();
                i = 101;
                s0.a(i, message);
            } catch (Exception e2) {
                message = e2.getMessage();
                i = 100;
                s0.a(i, message);
            }
        }
    }

    public static void b(Info info, Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65562, null, info, context, str) == null) && !TextUtils.isEmpty(str)) {
            try {
                Intent a = a(info, context, str);
                if (a.getFlags() > 0) {
                    d1 a2 = e1.a(context);
                    try {
                        a2.b = e1.a("wist", new f1(info));
                        a2.a("msg", e1.a(str));
                    } catch (JSONException unused) {
                    }
                    a2.a();
                    context.startActivity(a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, Info info) {
        InterceptResult invokeLL;
        File file;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65563, null, context, info)) == null) {
            try {
                String a = a(context, info.getOpen());
                file = new File(a);
                if (file.exists()) {
                    try {
                        packageInfo = context.getPackageManager().getPackageArchiveInfo(a, 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        return invokeLL.booleanValue;
        packageInfo = null;
        if (packageInfo != null) {
            if (packageInfo.versionCode == info.getDl_vsc()) {
                return true;
            }
            if (info.getDl_vsc() == 0 && info.getDl_pkg().equals(packageInfo.packageName)) {
                return true;
            }
            e1.a(context).a(new f1(info), packageInfo.packageName, packageInfo.versionCode, 1).a();
            file.delete();
            return false;
        }
        return false;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis() - Z1.a(context);
            if (currentTimeMillis < 0) {
                Z1.t(context);
            }
            boolean z = false;
            if (currentTimeMillis > context.getSharedPreferences("_prefs", 0).getLong("bdtsi", 24L) * 3600000) {
                z = true;
            }
            if (!z) {
                return;
            }
            b2.a(new b1(context));
        }
    }

    public static byte[] d(String str) {
        InterceptResult invokeL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, str)) == null) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URLDecoder.decode(str, "UTF-8")).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (-1 == read) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                        return byteArray;
                    } catch (Exception unused2) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception unused5) {
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
