package com.win.opensdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Display;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.webkit.sdk.VideoCloudSetting;
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
/* loaded from: classes7.dex */
public class G {
    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(Context context, String str) {
        try {
            return a(context) + File.separator + "win" + File.separator + e(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String a(String str, int i, String str2, boolean z) {
        if (i == 200 || i == 100) {
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

    public static String a(String str, String str2, int i) {
        if (i > 0) {
            try {
                return str.replaceAll(str2, String.valueOf(i));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static HashMap a(HashMap hashMap, int i, int i2, int i3, int i4, int i5, int i6) {
        hashMap.put("view_dx", Integer.valueOf(i));
        hashMap.put("view_dy", Integer.valueOf(i2));
        hashMap.put("view_ux", Integer.valueOf(i3));
        hashMap.put("view_uy", Integer.valueOf(i4));
        hashMap.put("view_width", Integer.valueOf(i5));
        hashMap.put("view_height", Integer.valueOf(i6));
        return hashMap;
    }

    public static HashMap a(Map map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("Accept-Encoding", Collections.singletonList("application/gzip"));
        hashMap.put("Content-Encoding", Collections.singletonList("application/gzip"));
        hashMap.put("User-Agent", Collections.singletonList(a2.f39865a));
        return hashMap;
    }

    public static void a(WebView webView, String str) {
        if (webView != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        webView.evaluateJavascript(str, null);
                    } else {
                        webView.loadUrl(str);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Info info) {
        String vv_show_urls;
        try {
            a(info, 100, "");
            if (info != null && !TextUtils.isEmpty(info.getImp_urls())) {
                vv_show_urls = info.getImp_urls();
            } else if (info == null || TextUtils.isEmpty(info.getVv_show_urls())) {
                return;
            } else {
                vv_show_urls = info.getVv_show_urls();
            }
            i(vv_show_urls);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Info info, int i, String str) {
        if (info != null) {
            i(a((String) info.getEvents().get(i, ""), i, str, info.isHo_c_sw()));
        }
    }

    public static void a(Info info, String str) {
        String vv_click_urls;
        try {
            a(info, 200, str);
            if (info != null && !TextUtils.isEmpty(info.getClick_urls())) {
                vv_click_urls = info.getClick_urls();
            } else if (info == null || TextUtils.isEmpty(info.getVv_click_urls())) {
                return;
            } else {
                vv_click_urls = info.getVv_click_urls();
            }
            i(vv_click_urls);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public static int b(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String b(Context context) {
        return context.getPackageName();
    }

    public static String b(String str) {
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
        G1 g1 = new G1(sb3, sb4.toString());
        Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
        cipher.init(2, g1.f39672b, g1.f39671a);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return new String(cipher.doFinal(bArr), "utf-8");
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int intValue = ((Integer) jSONObject.get("view_width")).intValue();
            int intValue2 = ((Integer) jSONObject.get("view_height")).intValue();
            int intValue3 = ((Integer) jSONObject.get("view_dx")).intValue();
            int intValue4 = ((Integer) jSONObject.get("view_dy")).intValue();
            int intValue5 = ((Integer) jSONObject.get("view_ux")).intValue();
            return a(a(a(a(a(a(str, "__WIDTH__", intValue), "__HEIGHT__", intValue2), "__DOWN_X__", intValue3), "__DOWN_Y__", intValue4), "__UP_X__", intValue5), "__UP_Y__", ((Integer) jSONObject.get("view_uy")).intValue());
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return new File(a(context) + File.separator + "win" + File.separator + e(str)).exists();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String c(String str) {
        byte b2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                if (Integer.toHexString(digest[i] & 255).length() == 1) {
                    stringBuffer.append("0");
                    b2 = digest[i];
                } else {
                    b2 = digest[i];
                }
                stringBuffer.append(Integer.toHexString(b2 & 255));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] d(String str) {
        Throwable th;
        InputStream inputStream;
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

    public static int e(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String e(String str) {
        String[] split;
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

    public static void f(Context context) {
        long currentTimeMillis = System.currentTimeMillis() - V1.a(context);
        if (currentTimeMillis < 0) {
            V1.v(context);
        }
        if (currentTimeMillis > context.getSharedPreferences("_prefs", 0).getLong("bdtsi", 24L) * VideoCloudSetting.HOUR_MILLISECOND) {
            X1.a(new X0(context));
        }
    }

    public static byte[] f(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) (Character.digit(str.charAt(i + 1), 16) + (Character.digit(str.charAt(i), 16) << 4));
        }
        return bArr;
    }

    public static boolean g(Context context) {
        NetworkInfo[] allNetworkInfo;
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

    public static boolean g(String str) {
        return !TextUtils.isEmpty(str) && str.length() > 3;
    }

    public static boolean h(String str) {
        return str == null || str.length() == 0;
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        X1.a(new c1(optString));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static byte[] j(String str) {
        if (str == null || str.length() == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes("UTF-8"));
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String a(String str) {
        String str2;
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
        if (h(sb3) || h(str)) {
            str2 = "";
        } else {
            byte[] bytes = sb3.getBytes("utf-8");
            byte[] bArr = new byte[16];
            for (int i = 0; i < bytes.length && i < 16; i++) {
                bArr[i] = bytes[i];
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

    public static int[] d(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                i4 = point.x;
                i3 = point.y;
                return new int[]{i4, i3};
            }
            i = defaultDisplay.getWidth();
            i2 = defaultDisplay.getHeight();
        } else {
            i = context.getResources().getDisplayMetrics().widthPixels;
            i2 = context.getResources().getDisplayMetrics().heightPixels;
        }
        int i5 = i;
        i3 = i2;
        i4 = i5;
        return new int[]{i4, i3};
    }

    public static void b(Info info, Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent a2 = a(info, context, str);
            if (a2.getFlags() > 0) {
                Z0 a3 = a1.a(context);
                try {
                    a3.f39849b = a1.a("wist", new b1(info));
                    a3.a("msg", a1.a(str));
                } catch (JSONException unused) {
                }
                a3.a();
                context.startActivity(a2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Context context, int[] iArr) {
        float f2 = context.getResources().getDisplayMetrics().density;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) ((iArr[i] / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public static void a(String str, Map map, S0 s0) {
        String message;
        int i;
        try {
            s0.a();
            U0 a2 = new T0(str, "GET", a(map)).a();
            u1 u1Var = new u1();
            int a3 = a(a2, u1Var);
            if (a3 == 200) {
                s0.a(u1Var);
            } else {
                s0.a(a3, u1Var.f40046b);
            }
        } catch (JSONException e2) {
            message = e2.getMessage();
            i = 101;
            s0.a(i, message);
        } catch (Exception e3) {
            message = e3.getMessage();
            i = 100;
            s0.a(i, message);
        }
    }

    public static String a(Context context) {
        return (ContextCompat.checkSelfPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) == 0 ? context.getExternalCacheDir() : context.getCacheDir()).getPath();
    }

    public static Intent a(Info info, Context context, String str) {
        Uri fromFile;
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
                intent.setFlags(268435456);
                fromFile = Uri.fromFile(new File(str));
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            return intent;
        } catch (Exception e3) {
            String str2 = "错误:" + e3.getMessage();
            e3.printStackTrace();
            if (info != null) {
                Z0 a2 = a1.a(context);
                try {
                    a2.f39849b = a1.a("wiin", new b1(info));
                    a2.a("msg", a1.a(str));
                } catch (JSONException unused) {
                }
                a2.a();
            }
            return intent;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (r1 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, Info info) {
        File file;
        PackageInfo packageInfo;
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
        packageInfo = null;
        if (packageInfo != null) {
            if (packageInfo.versionCode == info.getDl_vsc()) {
                return true;
            }
            if (info.getDl_vsc() == 0 && info.getDl_pkg().equals(packageInfo.packageName)) {
                return true;
            }
            a1.a(context).a(new b1(info), packageInfo.packageName, packageInfo.versionCode, 1).a();
            file.delete();
            return false;
        }
        return false;
    }

    public static int a(U0 u0, u1 u1Var) {
        byte[] bArr = u0.f39817b;
        int i = u0.f39816a;
        if (i == 200) {
            u1Var.a(new String(bArr, "UTF-8"));
            return u1Var.f40045a;
        }
        return i;
    }
}
