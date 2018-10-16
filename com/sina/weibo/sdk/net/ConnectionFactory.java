package com.sina.weibo.sdk.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.webkit.net.BdNetTask;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
public class ConnectionFactory {
    public static HttpURLConnection createConnect(String str, Context context) {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
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
            } else {
                if (proxy == null) {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection();
                } else {
                    httpsURLConnection = (HttpsURLConnection) url.openConnection(proxy);
                }
                try {
                    httpsURLConnection.setHostnameVerifier(new MyHostnameVerifier(url.getHost()));
                    httpsURLConnection.setSSLSocketFactory(HttpsHelper.getSSL(context));
                    httpURLConnection = httpsURLConnection;
                } catch (MalformedURLException e) {
                    httpURLConnection = httpsURLConnection;
                } catch (IOException e2) {
                    httpURLConnection = httpsURLConnection;
                }
            }
        } catch (MalformedURLException e3) {
            httpURLConnection = null;
        } catch (IOException e4) {
            httpURLConnection = null;
        }
        httpURLConnection.setUseCaches(false);
        try {
            httpURLConnection.setRequestMethod("POST");
        } catch (ProtocolException e5) {
        }
        httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
        httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        httpURLConnection.setReadTimeout(HttpConstants.HTTP_CONNECT_TIMEOUT);
        httpURLConnection.setConnectTimeout(BdNetTask.TIMEOUT_READ);
        return httpURLConnection;
    }

    /* loaded from: classes2.dex */
    private static class MyHostnameVerifier implements HostnameVerifier {
        private String host;

        public MyHostnameVerifier(String str) {
            this.host = str;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.host, sSLSession);
        }
    }
}
