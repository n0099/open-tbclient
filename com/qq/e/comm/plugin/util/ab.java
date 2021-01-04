package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.qq.e.comm.managers.GDTADManager;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ab {
    public static String a() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) appContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 0) {
                return null;
            }
            int networkType = ((TelephonyManager) appContext.getSystemService("phone")).getNetworkType();
            if (networkType == 0) {
                networkType = activeNetworkInfo.getSubtype();
            }
            return "" + networkType;
        } catch (Exception e) {
            return null;
        }
    }

    public static HttpURLConnection a(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection == null) {
            return null;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger("httpRedirectMax", 3);
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        int i = 0;
        while (i < integer) {
            httpURLConnection2.connect();
            try {
                if (!a(httpURLConnection2.getResponseCode())) {
                    break;
                }
                String headerField = httpURLConnection2.getHeaderField("location");
                httpURLConnection2.disconnect();
                httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                httpURLConnection2.setConnectTimeout(connectTimeout);
                httpURLConnection2.setReadTimeout(readTimeout);
                if (requestProperties != null) {
                    for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        if (value != null && !value.isEmpty()) {
                            for (String str : value) {
                                httpURLConnection2.addRequestProperty(key, str);
                            }
                        }
                    }
                }
                i++;
            } catch (IndexOutOfBoundsException e) {
                throw new IOException(e.getMessage());
            }
        }
        if (i == integer) {
            com.qq.e.comm.plugin.y.u.a(100322, integer, null);
            throw new IOException("HttpURLConnection exceed max redirect " + integer + " " + httpURLConnection2.getURL());
        } else if (i > 0) {
            com.qq.e.comm.plugin.y.d dVar = new com.qq.e.comm.plugin.y.d();
            dVar.a("http_from", httpURLConnection.getURL().toString());
            dVar.a("http_to", httpURLConnection2.getURL().toString());
            com.qq.e.comm.plugin.y.u.a(100342, i, null, dVar);
            return httpURLConnection2;
        } else {
            return httpURLConnection2;
        }
    }

    public static boolean a(int i) {
        return i == 302 || i == 301 || i == 303;
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
            }
        }
        return false;
    }
}
