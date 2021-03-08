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
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidubce.http.Headers;
import com.win.opensdk.core.Info;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class v {
    public static int a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static String a(Context context, String str) {
        try {
            return a(context) + File.separator + "win" + File.separator + e(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, int i) {
        if (i > 0) {
            try {
                return str.replaceAll(str2, String.valueOf(i));
            } catch (Exception e) {
                e.printStackTrace();
                return str;
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
        hashMap.put(Headers.ACCEPT_ENCODING, Collections.singletonList("application/gzip"));
        hashMap.put("Content-Encoding", Collections.singletonList("application/gzip"));
        hashMap.put("User-Agent", Collections.singletonList(cb.f8139a));
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
            } catch (Exception e) {
            }
        }
    }

    public static void a(Info info, int i, String str) {
        if (info != null) {
            i(d((String) info.getEvents().get(i, ""), i, str, info.isHo_c_sw()));
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(String str, String str2) {
        try {
            Runtime.getRuntime().exec("chmod " + str + " " + str2);
        } catch (Exception e) {
            e.printStackTrace();
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

    public static byte[] abX(String str) {
        if (str == null || str.length() == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes("UTF-8"));
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] abY(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static int b(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }

    public static String b(Context context) {
        return context.getPackageName();
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
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static boolean b(Context context, String str) {
        try {
            return new File(a(context) + File.separator + "win" + File.separator + e(str)).exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int c(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static String d(String str, int i, String str2, boolean z) {
        if (i == 200 || i == 100) {
            try {
                String replaceAll = str.replaceAll("__TIMESTAMP__", String.valueOf(System.currentTimeMillis()));
                return z ? b(replaceAll, str2) : replaceAll;
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    public static void d(Info info) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int e(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String e(String str) {
        String str2;
        String[] split;
        try {
            str2 = str.length() > 250 ? str.substring(0, 250) : str;
            try {
                return (!str2.contains("/") || (split = str2.split("/")) == null || split.length <= 0) ? str2 : split[split.length - 1];
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return str2;
            }
        } catch (Exception e2) {
            e = e2;
            str2 = str;
        }
    }

    public static void f(Context context) {
        long currentTimeMillis = System.currentTimeMillis() - bp.a(context);
        if (currentTimeMillis < 0) {
            bp.v(context);
        }
        if (!(currentTimeMillis > context.getSharedPreferences("_prefs", 0).getLong("bdtsi", 24L) * BdKVCache.MILLS_1Hour)) {
            return;
        }
        bt.a(new bs(context));
    }

    public static boolean g(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo.isConnectedOrConnecting()) {
                return true;
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
                        bt.a(new cg(optString));
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static int[] iL(Context context) {
        int i;
        int i2;
        if (context instanceof Activity) {
            Display defaultDisplay = ((Activity) context).getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                i = point.x;
                i2 = point.y;
            } else {
                i = defaultDisplay.getWidth();
                i2 = defaultDisplay.getHeight();
            }
        } else {
            i = context.getResources().getDisplayMetrics().widthPixels;
            i2 = context.getResources().getDisplayMetrics().heightPixels;
        }
        return new int[]{i, i2};
    }

    public static String b(String str) {
        Cipher cipher;
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("Y2wyaQ==", 2);
            StringBuilder sb2 = new StringBuilder();
            for (byte b : decode) {
                sb2.append((char) b);
            }
            String sb3 = sb.append(sb2.toString()).append("4c6k").toString();
            StringBuilder sb4 = new StringBuilder();
            byte[] decode2 = Base64.decode("YjJsbw==", 0);
            StringBuilder sb5 = new StringBuilder();
            for (byte b2 : decode2) {
                sb5.append((char) b2);
            }
            y yVar = new y(sb3, sb4.append(sb5.toString()).append("o7my").toString());
            char c = 65535;
            int hashCode = "CBC".hashCode();
            if (hashCode == 66500) {
                c = 0;
            } else if (hashCode != 66623) {
            }
            if (c == 0) {
                cipher = Cipher.getInstance("DES/CBC/NoPadding");
                cipher.init(2, yVar.qkD, yVar.qkC);
            } else if (c == 1) {
                cipher = Cipher.getInstance("DES/OFB/PKCS5Padding");
                cipher.init(2, yVar.qkD, yVar.qkC);
            } else if (c != 2) {
                cipher = Cipher.getInstance("DES");
                cipher.init(2, yVar.qkD);
            } else {
                cipher = Cipher.getInstance("DES/CFB/PKCS5Padding");
                cipher.init(2, yVar.qkD, yVar.qkC);
            }
            byte[] bArr = new byte[str.length() / 2];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
            }
            return new String(cipher.doFinal(bArr), "utf-8");
        }
        return str;
    }

    public static String a(String str) {
        String encodeToString;
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            byte[] decode = Base64.decode("aTFob21lOGw=", 0);
            StringBuilder sb2 = new StringBuilder();
            for (byte b : decode) {
                sb2.append((char) b);
            }
            String sb3 = sb.append(sb2.toString()).append("mloo0ks9").toString();
            if (h(sb3) || h(str)) {
                encodeToString = "";
            } else {
                byte[] bytes = sb3.getBytes("utf-8");
                byte[] bArr = new byte[16];
                for (int i = 0; i < bytes.length && i < bArr.length; i++) {
                    bArr[i] = bytes[i];
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, com.baidu.sapi2.utils.e.q);
                Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.q);
                cipher.init(1, secretKeySpec);
                encodeToString = Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 2);
            }
            if (!TextUtils.isEmpty(encodeToString)) {
                encodeToString = "KL_" + encodeToString;
            }
            return encodeToString;
        }
        return str;
    }

    public static void a(Info info, Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent b = b(info, context, str);
            if (b.getFlags() > 0) {
                bx iT = ca.iT(context);
                try {
                    iT.qlo = ca.a("wist", new cd(info));
                    iT.hD("msg", ca.a(str));
                } catch (JSONException e) {
                }
                iT.a();
                context.startActivity(b);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void b(Context context, int[] iArr) {
        float f = context.getResources().getDisplayMetrics().density;
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) ((iArr[i] / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
    }

    public static void a(String str, Map map, bh bhVar) {
        try {
            bhVar.a();
            bm eJc = new bk(str, "GET", a(map)).eJc();
            ep epVar = new ep();
            int a2 = a(eJc, epVar);
            if (a2 == 200) {
                bhVar.a(epVar);
            } else {
                bhVar.a(a2, epVar.b);
            }
        } catch (JSONException e) {
            bhVar.a(101, e.getMessage());
        } catch (Exception e2) {
            bhVar.a(100, e2.getMessage());
        }
    }

    public static String a(Context context) {
        return ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath();
    }

    public static Intent b(Info info, Context context, String str) {
        Uri fromFile;
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
                intent.setFlags(RouterCallback.CODE_ERROR);
                fromFile = FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".fileProvider", new File(str));
            } else {
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                fromFile = Uri.fromFile(new File(str));
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            return intent;
        } catch (Exception e2) {
            String str2 = "错误:" + e2.getMessage();
            e2.printStackTrace();
            if (info != null) {
                bx iT = ca.iT(context);
                try {
                    iT.qlo = ca.a("wiin", new cd(info));
                    iT.hD("msg", ca.a(str));
                } catch (JSONException e3) {
                }
                iT.a();
            }
            return intent;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r2 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, Info info) {
        File file;
        PackageInfo packageInfo;
        try {
            String a2 = a(context, info.getOpen());
            file = new File(a2);
            if (file.exists()) {
                try {
                    packageInfo = context.getPackageManager().getPackageArchiveInfo(a2, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
            ca.iT(context).a(new cd(info), packageInfo.packageName, packageInfo.versionCode, 1).a();
            file.delete();
            return false;
        }
        return false;
    }

    public static int a(bm bmVar, ep epVar) {
        byte[] bArr = bmVar.b;
        int i = bmVar.f8119a;
        if (i == 200) {
            epVar.a(new String(bArr, "UTF-8"));
            return epVar.f8164a;
        }
        return i;
    }
}
