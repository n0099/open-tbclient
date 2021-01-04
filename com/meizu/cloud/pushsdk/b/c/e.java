package com.meizu.cloud.pushsdk.b.c;

import android.net.TrafficStats;
import com.meizu.cloud.pushsdk.b.c.k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes6.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    com.meizu.cloud.pushsdk.b.h.a f11449a = new com.meizu.cloud.pushsdk.b.h.a(null);

    private static l a(final HttpURLConnection httpURLConnection) throws IOException {
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

    static void a(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        switch (iVar.c()) {
            case 0:
                httpURLConnection.setRequestMethod("GET");
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                b(httpURLConnection, iVar);
                return;
            case 2:
                httpURLConnection.setRequestMethod(HttpPut.METHOD_NAME);
                b(httpURLConnection, iVar);
                return;
            case 3:
                httpURLConnection.setRequestMethod(HttpDelete.METHOD_NAME);
                return;
            case 4:
                httpURLConnection.setRequestMethod(HttpHead.METHOD_NAME);
                return;
            case 5:
                httpURLConnection.setRequestMethod("PATCH");
                b(httpURLConnection, iVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    protected static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private HttpURLConnection b(i iVar) throws IOException {
        String fVar = iVar.a().toString();
        URL url = new URL(fVar);
        if (MinSdkChecker.isSupportNotificationChannel()) {
            TrafficStats.setThreadStatsTag("HttpURLConnectionCall".hashCode());
        }
        HttpURLConnection a2 = a(url);
        a2.setConnectTimeout(60000);
        a2.setReadTimeout(60000);
        a2.setUseCaches(false);
        a2.setDoInput(true);
        if (iVar.f() && fVar.startsWith("https://api-push.meizu.com")) {
            ((HttpsURLConnection) a2).setSSLSocketFactory(this.f11449a);
        }
        return a2;
    }

    private static void b(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        j e = iVar.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e.a().toString());
            com.meizu.cloud.pushsdk.b.g.c a2 = com.meizu.cloud.pushsdk.b.g.g.a(com.meizu.cloud.pushsdk.b.g.g.a(httpURLConnection.getOutputStream()));
            e.a(a2);
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

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
