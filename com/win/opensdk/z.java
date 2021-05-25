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
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.alibaba.fastjson.asm.Label;
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
public class z {
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

    public static String a(String str, int i2, String str2, boolean z) {
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

    public static String a(String str, String str2, int i2) {
        if (i2 > 0) {
            try {
                return str.replaceAll(str2, String.valueOf(i2));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str;
    }

    public static HashMap a(HashMap hashMap, int i2, int i3, int i4, int i5, int i6, int i7) {
        hashMap.put("view_dx", Integer.valueOf(i2));
        hashMap.put("view_dy", Integer.valueOf(i3));
        hashMap.put("view_ux", Integer.valueOf(i4));
        hashMap.put("view_uy", Integer.valueOf(i5));
        hashMap.put("view_width", Integer.valueOf(i6));
        hashMap.put("view_height", Integer.valueOf(i7));
        return hashMap;
    }

    public static HashMap a(Map map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("Accept-Encoding", Collections.singletonList("application/gzip"));
        hashMap.put("Content-Encoding", Collections.singletonList("application/gzip"));
        hashMap.put("User-Agent", Collections.singletonList(x1.f37176a));
        return hashMap;
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
            g(vv_show_urls);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(Info info, int i2, String str) {
        if (info != null) {
            g(a((String) info.getEvents().get(i2, ""), i2, str, info.isHo_c_sw()));
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
            g(vv_click_urls);
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
        d1 d1Var = new d1(sb3, sb4.toString());
        Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
        cipher.init(2, d1Var.f37027b, d1Var.f37026a);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
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

    public static String c(String str) {
        byte b2;
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

    public static void c(Context context) {
        long currentTimeMillis = System.currentTimeMillis() - s1.a(context);
        if (currentTimeMillis < 0) {
            s1.r(context);
        }
        if (currentTimeMillis > context.getSharedPreferences("_prefs", 0).getLong("bdtsi", 24L) * VideoCloudSetting.HOUR_MILLISECOND) {
            u1.a(new u0(context));
        }
    }

    public static boolean d(Context context) {
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

    public static boolean f(String str) {
        return str == null || str.length() == 0;
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        u1.a(new z0(optString));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static byte[] h(String str) {
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

    public static void b(Info info, Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent a2 = a(info, context, str);
            if (a2.getFlags() > 0) {
                w0 a3 = x0.a(context);
                try {
                    a3.f37158b = x0.a("wist", new y0(info));
                    a3.a("msg", x0.a(str));
                } catch (JSONException unused) {
                }
                a3.a();
                context.startActivity(a2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str, Map map, r0 r0Var) {
        String message;
        int i2;
        try {
            r0Var.a();
            t0 a2 = new s0(str, "GET", a(map)).a();
            R0 r0 = new R0();
            int a3 = a(a2, r0);
            if (a3 == 200) {
                r0Var.a(r0);
            } else {
                r0Var.a(a3, r0.f36929b);
            }
        } catch (JSONException e2) {
            message = e2.getMessage();
            i2 = 101;
            r0Var.a(i2, message);
        } catch (Exception e3) {
            message = e3.getMessage();
            i2 = 100;
            r0Var.a(i2, message);
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
                intent.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
                fromFile = Uri.fromFile(new File(str));
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            return intent;
        } catch (Exception e3) {
            String str2 = "错误:" + e3.getMessage();
            e3.printStackTrace();
            if (info != null) {
                w0 a2 = x0.a(context);
                try {
                    a2.f37158b = x0.a("wiin", new y0(info));
                    a2.a("msg", x0.a(str));
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
            x0.a(context).a(new y0(info), packageInfo.packageName, packageInfo.versionCode, 1).a();
            file.delete();
            return false;
        }
        return false;
    }

    public static int a(t0 t0Var, R0 r0) {
        byte[] bArr = t0Var.f37123b;
        int i2 = t0Var.f37122a;
        if (i2 == 200) {
            r0.a(new String(bArr, "UTF-8"));
            return r0.f36928a;
        }
        return i2;
    }
}
