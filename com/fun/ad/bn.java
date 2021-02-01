package com.fun.ad;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.http.Headers;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public Context f7774a;

    public bn(Context context) {
        this.f7774a = context.getApplicationContext();
    }

    public static String a(Context context, Uri.Builder builder) {
        TelephonyManager telephonyManager;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        builder.appendQueryParameter("w", String.valueOf(displayMetrics.widthPixels));
        builder.appendQueryParameter("h", String.valueOf(displayMetrics.heightPixels));
        builder.appendQueryParameter("dpi", String.valueOf(displayMetrics.densityDpi));
        builder.appendQueryParameter("model", Build.MODEL);
        builder.appendQueryParameter("manu", Build.MANUFACTURER);
        builder.appendQueryParameter("sysv", String.valueOf(Build.VERSION.SDK_INT));
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && !TextUtils.isEmpty(telephonyManager.getDeviceId())) {
            builder.appendQueryParameter("imei", telephonyManager.getDeviceId());
        }
        builder.appendQueryParameter("locale", Locale.getDefault().getDisplayName());
        TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager2 != null) {
            builder.appendQueryParameter("opcode", telephonyManager2.getSimOperator());
            builder.appendQueryParameter("net", String.valueOf(telephonyManager2.getNetworkType()));
        }
        builder.appendQueryParameter("sdkna", Build.PRODUCT);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            builder.appendQueryParameter("appv", String.valueOf(packageInfo.versionCode));
            builder.appendQueryParameter("appvn", packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        builder.appendQueryParameter("app", context.getPackageName());
        builder.appendQueryParameter("plat", "a");
        return builder.build().toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(a(this.f7774a, Uri.parse("https://pp.xdplt.com/report").buildUpon())).openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
            httpURLConnection.setRequestProperty("Content-Encoding", "application/gzip");
            httpURLConnection.setRequestProperty(com.baidubce.http.Headers.ACCEPT_ENCODING, "application/gzip");
            httpURLConnection.setRequestProperty("Charsert", "UTF-8");
            httpURLConnection.setRequestProperty("Accept", "application/gzip");
            httpURLConnection.setRequestProperty("Content-Type", "application/gzip");
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            JSONArray jSONArray = new JSONArray();
            bk io2 = bk.io(this.f7774a);
            ArrayList arrayList = (ArrayList) io2.a();
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    bf bfVar = (bf) it.next();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("e", bfVar.f7769b);
                    jSONObject.put("pid", bfVar.c);
                    jSONObject.put(IXAdRequestInfo.CELL_ID, bfVar.e);
                    jSONObject.put("type", bfVar.d);
                    jSONArray.put(jSONObject);
                }
                outputStreamWriter.write(jSONArray.toString());
                outputStreamWriter.flush();
                outputStreamWriter.close();
                outputStream.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        io2.getWritableDatabase().delete("ad_todo_list", "_id=?", new String[]{String.valueOf(((bf) it2.next()).f7768a)});
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
