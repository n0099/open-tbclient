package org.acra.util;

import com.baidu.browser.explorer.BdExplorePopView;
import com.baidu.cyberplayer.sdk.internal.HttpUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
/* loaded from: classes.dex */
public final class b {
    private String a;
    private String b;
    private int c = BdExplorePopView.SELECTION_TOP_DUR;
    private int d = BdExplorePopView.SELECTION_TOP_DUR;
    private int e = 3;

    public void a(String str) {
        this.a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(int i) {
        this.e = i;
    }

    public void a(URL url, Map map) {
        HttpClient a = a();
        HttpPost b = b(url, map);
        org.acra.a.b.a(org.acra.a.a, "Sending request to " + url);
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            it.next();
        }
        HttpResponse execute = a.execute(b, new BasicHttpContext());
        if (execute != null) {
            if (execute.getStatusLine() != null) {
                String num = Integer.toString(execute.getStatusLine().getStatusCode());
                if (num.startsWith("4") || num.startsWith("5")) {
                    throw new IOException("Host returned error code " + num);
                }
            }
            EntityUtils.toString(execute.getEntity());
        }
    }

    private HttpClient a() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        basicHttpParams.setParameter("http.protocol.cookie-policy", "rfc2109");
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.c);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.d);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", new PlainSocketFactory(), 80));
        if (org.acra.a.d().L()) {
            schemeRegistry.register(new Scheme("https", new a(), 443));
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        defaultHttpClient.setHttpRequestRetryHandler(new d(basicHttpParams, this.e));
        return defaultHttpClient;
    }

    private UsernamePasswordCredentials b() {
        if (this.a == null && this.b == null) {
            return null;
        }
        return new UsernamePasswordCredentials(this.a, this.b);
    }

    private HttpPost b(URL url, Map map) {
        HttpPost httpPost = new HttpPost(url.toString());
        UsernamePasswordCredentials b = b();
        if (b != null) {
            httpPost.addHeader(BasicScheme.authenticate(b, "UTF-8", false));
        }
        httpPost.setHeader(HttpUtils.HEADER_NAME_USER_AGENT, "Android");
        httpPost.setHeader("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        httpPost.setEntity(new StringEntity(a(map), "UTF-8"));
        return httpPost;
    }

    private String a(Map map) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : map.keySet()) {
            if (sb.length() != 0) {
                sb.append('&');
            }
            Object obj2 = map.get(obj);
            if (obj2 == null) {
                obj2 = "";
            }
            sb.append(URLEncoder.encode(obj.toString(), "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(obj2.toString(), "UTF-8"));
        }
        return sb.toString();
    }
}
