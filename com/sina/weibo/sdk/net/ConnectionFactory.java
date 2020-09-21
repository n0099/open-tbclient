package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.net.BdNetTask;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes24.dex */
public class ConnectionFactory {
    public static HttpURLConnection createConnect(String str, Context context) {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str) || (!str.startsWith("http://") && !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            throw new RuntimeException("非法url请求");
        }
        try {
            URL url = new URL(str);
            Pair<String, Integer> apn = NetStateManager.getAPN();
            Proxy proxy = apn != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) apn.first, ((Integer) apn.second).intValue())) : null;
            if (str.startsWith("http://")) {
                if (proxy == null) {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } else {
                    httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
                }
            } else if (proxy == null) {
                httpURLConnection = (HttpsURLConnection) url.openConnection();
            } else {
                httpURLConnection = (HttpsURLConnection) url.openConnection(proxy);
            }
        } catch (MalformedURLException e) {
            httpURLConnection = null;
        } catch (IOException e2) {
            httpURLConnection = null;
        }
        httpURLConnection.setUseCaches(false);
        try {
            httpURLConnection.setRequestMethod("POST");
        } catch (ProtocolException e3) {
        }
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(BdNetTask.TIMEOUT_READ);
        return httpURLConnection;
    }
}
