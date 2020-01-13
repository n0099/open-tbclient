package com.sina.weibo.sdk.network.impl;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidubce.http.Headers;
import com.sina.weibo.sdk.net.NetStateManager;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.network.base.RequestBodyHelper;
import com.sina.weibo.sdk.network.base.UriUtils;
import com.sina.weibo.sdk.network.base.WbResponse;
import com.sina.weibo.sdk.network.base.WbResponseBody;
import com.sina.weibo.sdk.network.exception.RequestException;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpHost;
import org.apache.http.protocol.HTTP;
/* loaded from: classes5.dex */
public class RequestEngine {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v29, types: [java.net.HttpURLConnection] */
    public static WbResponse request(IRequestParam iRequestParam) throws RequestException {
        HttpsURLConnection httpsURLConnection;
        String url = iRequestParam.getUrl();
        if (TextUtils.isEmpty(url) || (!url.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && !url.startsWith("https"))) {
            throw new RequestException("非法的请求地址");
        }
        String buildCompleteUri = UriUtils.buildCompleteUri(url, iRequestParam.getGetBundle());
        Pair<String, Integer> apn = NetStateManager.getAPN();
        Proxy proxy = null;
        if (apn != null) {
            proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) apn.first, ((Integer) apn.second).intValue()));
        }
        try {
            final URL url2 = new URL(buildCompleteUri);
            if (proxy == null) {
                httpsURLConnection = (HttpURLConnection) url2.openConnection();
            } else {
                httpsURLConnection = (HttpsURLConnection) url2.openConnection(proxy);
            }
            if ("https".equalsIgnoreCase(url2.getProtocol())) {
                HttpsURLConnection httpsURLConnection2 = httpsURLConnection;
                httpsURLConnection2.setHostnameVerifier(new HostnameVerifier() { // from class: com.sina.weibo.sdk.network.impl.RequestEngine.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public boolean verify(String str, SSLSession sSLSession) {
                        String host = url2.getHost();
                        if (TextUtils.isEmpty(host) || !host.equals(str)) {
                            return false;
                        }
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
                    }
                });
                try {
                    httpsURLConnection2.setSSLSocketFactory(SSLContext.getDefault().getSocketFactory());
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                    httpsURLConnection2.setSSLSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
                }
            }
            setRequestHeader(httpsURLConnection, iRequestParam.getHeader());
            Bundle bundle = new Bundle();
            String str = "------------" + RequestBodyHelper.getBoundry();
            if (iRequestParam.getMethod() == IRequestParam.RequestType.POST) {
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
                httpsURLConnection.setRequestProperty("Charset", "UTF-8");
                httpsURLConnection.setUseCaches(false);
                if (iRequestParam.getPostBundle().getByteArray(RequestParam.KEY_PARAM_BODY_BYTE_ARRAY) != null) {
                    bundle.putString("Content-Type", "application/octet-stream");
                } else if (RequestBodyHelper.isMultipartRequest(iRequestParam)) {
                    bundle.putString("Content-Type", "multipart/form-data;boundary=" + str);
                } else {
                    bundle.putString("Content-Type", "application/x-www-form-urlencoded");
                }
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
            } else if (iRequestParam.getMethod() == IRequestParam.RequestType.GET) {
                httpsURLConnection.setRequestMethod("GET");
            } else if (iRequestParam.getMethod() == IRequestParam.RequestType.PATCH) {
                httpsURLConnection.setRequestMethod("PATCH");
            }
            httpsURLConnection.setReadTimeout(iRequestParam.getResponseTimeout());
            httpsURLConnection.setConnectTimeout(iRequestParam.getRequestTimeout());
            setRequestHeader(httpsURLConnection, bundle);
            httpsURLConnection.connect();
            if (iRequestParam.getMethod() != IRequestParam.RequestType.GET) {
                RequestBodyHelper.fillRequestBody(iRequestParam, httpsURLConnection, str);
            }
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                return new WbResponse(new WbResponseBody(httpsURLConnection.getInputStream(), httpsURLConnection.getContentLength()));
            }
            if (responseCode == 302 || responseCode == 301) {
                iRequestParam.setUrl(httpsURLConnection.getHeaderField(Headers.LOCATION));
                return request(iRequestParam);
            }
            throw new RequestException("服务器异常" + new WbResponseBody(httpsURLConnection.getErrorStream(), httpsURLConnection.getContentLength()).string());
        } catch (MalformedURLException e2) {
            LogUtil.v("weibosdk", e2.toString());
            throw new RequestException("请求异常" + e2.toString());
        } catch (IOException e3) {
            LogUtil.v("weibosdk", e3.toString());
            throw new RequestException("请求异常" + e3.toString());
        }
    }

    private static void setRequestHeader(HttpURLConnection httpURLConnection, Bundle bundle) {
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
            }
        }
    }
}
