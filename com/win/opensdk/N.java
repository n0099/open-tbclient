package com.win.opensdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.alibaba.fastjson.asm.Label;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
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
/* loaded from: classes6.dex */
public class N {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(65536, null, context, f2)) == null) ? (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f) : invokeLF.intValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return a(context) + File.separator + "win" + File.separator + e(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, int i2, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{str, Integer.valueOf(i2), str2, Boolean.valueOf(z)})) == null) {
            if (i2 == 200 || i2 == 100) {
                try {
                    String replaceAll = str.replaceAll("__TIMESTAMP__", String.valueOf(System.currentTimeMillis()));
                    return z ? b(replaceAll, str2) : replaceAll;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return str;
                }
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public static String a(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65543, null, str, str2, i2)) == null) {
            if (i2 > 0) {
                try {
                    return str.replaceAll(str2, String.valueOf(i2));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        return (String) invokeLLI.objValue;
    }

    public static HashMap a(HashMap hashMap, int i2, int i3, int i4, int i5, int i6, int i7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{hashMap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)})) == null) {
            hashMap.put("view_dx", Integer.valueOf(i2));
            hashMap.put("view_dy", Integer.valueOf(i3));
            hashMap.put("view_ux", Integer.valueOf(i4));
            hashMap.put("view_uy", Integer.valueOf(i5));
            hashMap.put("view_width", Integer.valueOf(i6));
            hashMap.put("view_height", Integer.valueOf(i7));
            return hashMap;
        }
        return (HashMap) invokeCommon.objValue;
    }

    public static HashMap a(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, map)) == null) {
            HashMap hashMap = new HashMap();
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("Accept-Encoding", Collections.singletonList("application/gzip"));
            hashMap.put("Content-Encoding", Collections.singletonList("application/gzip"));
            hashMap.put("User-Agent", Collections.singletonList(Z1.f39723a));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static void a(Info info) {
        String vv_show_urls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, info) == null) {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(Info info, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65547, null, info, i2, str) == null) || info == null) {
            return;
        }
        g(a((String) info.getEvents().get(i2, ""), i2, str, info.isHo_c_sw()));
    }

    public static void a(Info info, String str) {
        String vv_click_urls;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, info, str) == null) {
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
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            try {
                Runtime.getRuntime().exec("chmod " + str + " " + str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(byte[] bArr, String str, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, bArr, str, kVar) == null) {
            new Thread(new e0(bArr, str, kVar)).start();
        }
    }

    public static boolean a(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, strArr, str)) == null) {
            for (String str2 : strArr) {
                if (TextUtils.equals(str2, str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) ? context.getPackageName() : (String) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("Y2wyaQ==", 2);
            StringBuilder sb2 = new StringBuilder();
            for (byte b2 : decode) {
                sb2.append((char) b2);
            }
            sb.append(sb2.toString());
            sb.append("4c6k");
            String sb3 = sb.toString();
            StringBuilder sb4 = new StringBuilder();
            byte[] decode2 = Base64.decode("YjJsbw==", 0);
            StringBuilder sb5 = new StringBuilder();
            for (byte b3 : decode2) {
                sb5.append((char) b3);
            }
            sb4.append(sb5.toString());
            sb4.append("o7my");
            F1 f1 = new F1(sb3, sb4.toString());
            Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
            cipher.init(2, f1.f39577b, f1.f39576a);
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
            }
            return new String(cipher.doFinal(bArr), "utf-8");
        }
        return (String) invokeL.objValue;
    }

    public static String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, str2)) == null) {
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
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static boolean b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) {
            try {
                return new File(a(context) + File.separator + "win" + File.separator + e(str)).exists();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) {
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
        byte b2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes("UTF-8"));
                byte[] digest = messageDigest.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < digest.length; i2++) {
                    if (Integer.toHexString(digest[i2] & 255).length() == 1) {
                        stringBuffer.append("0");
                        b2 = digest[i2];
                    } else {
                        b2 = digest[i2];
                    }
                    stringBuffer.append(Integer.toHexString(b2 & 255));
                }
                return stringBuffer.toString();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static byte[] d(String str) {
        InterceptResult invokeL;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, str)) == null) {
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

    public static String e(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, str)) == null) {
            try {
                if (str.length() > 250) {
                    str = str.substring(0, 250);
                }
                if (str.contains("/") && (split = str.split("/")) != null && split.length > 0) {
                    return split[split.length - 1];
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, context)) == null) {
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

    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) ? str == null || str.length() == 0 : invokeL.booleanValue;
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65566, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        W1.a(new b1(optString));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static byte[] h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65567, null, str)) == null) {
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

    public static String a(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("aTFob21lOGw=", 0);
            StringBuilder sb2 = new StringBuilder();
            for (byte b2 : decode) {
                sb2.append((char) b2);
            }
            sb.append(sb2.toString());
            sb.append("mloo0ks9");
            String sb3 = sb.toString();
            if (f(sb3) || f(str)) {
                str2 = "";
            } else {
                byte[] bytes = sb3.getBytes("utf-8");
                byte[] bArr = new byte[16];
                for (int i2 = 0; i2 < bytes.length && i2 < 16; i2++) {
                    bArr[i2] = bytes[i2];
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(1, secretKeySpec);
                str2 = Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 2);
            }
            if (TextUtils.isEmpty(str2)) {
                return str2;
            }
            return "KL_" + str2;
        }
        return (String) invokeL.objValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, context) == null) {
            long currentTimeMillis = System.currentTimeMillis() - U1.a(context);
            if (currentTimeMillis < 0) {
                U1.s(context);
            }
            if (currentTimeMillis > context.getSharedPreferences("_prefs", 0).getLong("bdtsi", 24L) * 3600000) {
                W1.a(new W0(context));
            }
        }
    }

    public static void b(Info info, Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65557, null, info, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent a2 = a(info, context, str);
            if (a2.getFlags() > 0) {
                Y0 a3 = Z0.a(context);
                try {
                    a3.f39714b = Z0.a("wist", new a1(info));
                    a3.a("msg", Z0.a(str));
                } catch (JSONException unused) {
                }
                a3.a();
                context.startActivity(a2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, Map map, T0 t0) {
        String message;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, map, t0) == null) {
            try {
                t0.a();
                V0 a2 = new U0(str, "GET", a(map)).a();
                t1 t1Var = new t1();
                int a3 = a(a2, t1Var);
                if (a3 == 200) {
                    t0.a(t1Var);
                } else {
                    t0.a(a3, t1Var.f39947b);
                }
            } catch (JSONException e2) {
                message = e2.getMessage();
                i2 = 101;
                t0.a(i2, message);
            } catch (Exception e3) {
                message = e3.getMessage();
                i2 = 100;
                t0.a(i2, message);
            }
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return (ContextCompat.checkSelfPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0 ? context.getExternalCacheDir() : context.getCacheDir()).getPath();
        }
        return (String) invokeL.objValue;
    }

    public static Intent a(Info info, Context context, String str) {
        InterceptResult invokeLLL;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, info, context, str)) == null) {
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                try {
                    if (Build.VERSION.SDK_INT == 23) {
                        a("777", a(context) + "/win/");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                a("777", str);
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.setAction("android.intent.action.INSTALL_PACKAGE");
                    intent.setFlags(RouterCallback.CODE_ERROR);
                    fromFile = FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileProvider", new File(str));
                } else {
                    intent.setAction("android.intent.action.VIEW");
                    intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                    fromFile = Uri.fromFile(new File(str));
                }
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                return intent;
            } catch (Exception e3) {
                String str2 = "错误:" + e3.getMessage();
                e3.printStackTrace();
                if (info != null) {
                    Y0 a2 = Z0.a(context);
                    try {
                        a2.f39714b = Z0.a("wiin", new a1(info));
                        a2.a("msg", Z0.a(str));
                    } catch (JSONException unused) {
                    }
                    a2.a();
                }
                return intent;
            }
        }
        return (Intent) invokeLLL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, Info info) {
        InterceptResult invokeLL;
        File file;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, context, info)) == null) {
            try {
                String a2 = a(context, info.getOpen());
                file = new File(a2);
                if (file.exists()) {
                    try {
                        packageInfo = context.getPackageManager().getPackageArchiveInfo(a2, 1);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
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
            Z0.a(context).a(new a1(info), packageInfo.packageName, packageInfo.versionCode, 1).a();
            file.delete();
            return false;
        }
        return false;
    }

    public static int a(V0 v0, t1 t1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, v0, t1Var)) == null) {
            byte[] bArr = v0.f39698b;
            int i2 = v0.f39697a;
            if (i2 == 200) {
                t1Var.a(new String(bArr, "UTF-8"));
                return t1Var.f39946a;
            }
            return i2;
        }
        return invokeLL.intValue;
    }
}
