package com.meizu.cloud.pushsdk.b.c;

import android.net.TrafficStats;
import com.meizu.cloud.pushsdk.b.c.k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes6.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.h.a f37777a = new com.meizu.cloud.pushsdk.b.h.a(null);

    public static l a(final HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getDoInput()) {
            final com.meizu.cloud.pushsdk.b.g.d a2 = com.meizu.cloud.pushsdk.b.g.g.a(com.meizu.cloud.pushsdk.b.g.g.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
            return new l() { // from class: com.meizu.cloud.pushsdk.b.c.e.1
                @Override // com.meizu.cloud.pushsdk.b.c.l
                public com.meizu.cloud.pushsdk.b.g.d a() {
                    return a2;
                }
            };
        }
        return null;
    }

    public static void a(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        String str;
        String str2;
        int c2 = iVar.c();
        if (c2 != 0) {
            if (c2 == 1) {
                str2 = "POST";
            } else if (c2 == 2) {
                str2 = HttpPut.METHOD_NAME;
            } else if (c2 == 3) {
                str = HttpDelete.METHOD_NAME;
            } else if (c2 == 4) {
                str = "HEAD";
            } else if (c2 != 5) {
                throw new IllegalStateException("Unknown method type.");
            } else {
                str2 = "PATCH";
            }
            httpURLConnection.setRequestMethod(str2);
            b(httpURLConnection, iVar);
            return;
        }
        str = "GET";
        httpURLConnection.setRequestMethod(str);
    }

    public static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private HttpURLConnection b(i iVar) throws IOException {
        String fVar = iVar.a().toString();
        URL url = new URL(fVar);
        if (MinSdkChecker.isSupportNotificationChannel()) {
            TrafficStats.setThreadStatsTag(2006537699);
        }
        HttpURLConnection a2 = a(url);
        a2.setConnectTimeout(60000);
        a2.setReadTimeout(60000);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if (iVar.f() && fVar.startsWith("https://api-push.meizu.com")) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(this.f37777a);
        }
        return a2;
    }

    public static void b(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        j e2 = iVar.e();
        if (e2 != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e2.a().toString());
            com.meizu.cloud.pushsdk.b.g.c a2 = com.meizu.cloud.pushsdk.b.g.g.a(com.meizu.cloud.pushsdk.b.g.g.a(httpURLConnection.getOutputStream()));
            e2.a(a2);
            a2.close();
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.c.a
    public k a(i iVar) throws IOException {
        HttpURLConnection b2 = b(iVar);
        for (String str : iVar.d().b()) {
            String a2 = iVar.a(str);
            com.meizu.cloud.pushsdk.b.a.a.b("current header name " + str + " value " + a2);
            b2.addRequestProperty(str, a2);
        }
        a(b2, iVar);
        int responseCode = b2.getResponseCode();
        return new k.a().a(responseCode).a(iVar.d()).a(b2.getResponseMessage()).a(iVar).a(a(b2)).a();
    }

    public HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
