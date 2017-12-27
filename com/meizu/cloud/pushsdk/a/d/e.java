package com.meizu.cloud.pushsdk.a.d;

import com.meizu.cloud.pushsdk.a.d.k;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
/* loaded from: classes2.dex */
public class e implements a {
    i a;

    public e(i iVar) {
        this.a = iVar;
    }

    @Override // com.meizu.cloud.pushsdk.a.d.a
    public k a() throws IOException {
        HttpURLConnection a = a(this.a);
        for (String str : this.a.d().b()) {
            String a2 = this.a.a(str);
            com.meizu.cloud.pushsdk.a.a.a.b("current header name " + str + " value " + a2);
            a.addRequestProperty(str, a2);
        }
        a(a, this.a);
        int responseCode = a.getResponseCode();
        return new k.a().a(responseCode).a(this.a.d()).a(a.getResponseMessage()).a(this.a).a(a(a)).a();
    }

    private static l a(final HttpURLConnection httpURLConnection) throws IOException {
        if (!httpURLConnection.getDoInput()) {
            return null;
        }
        final com.meizu.cloud.pushsdk.a.h.c a = com.meizu.cloud.pushsdk.a.h.f.a(com.meizu.cloud.pushsdk.a.h.f.a(a(httpURLConnection.getResponseCode()) ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream()));
        return new l() { // from class: com.meizu.cloud.pushsdk.a.d.e.1
            @Override // com.meizu.cloud.pushsdk.a.d.l
            public com.meizu.cloud.pushsdk.a.h.c a() {
                return a;
            }
        };
    }

    protected static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    private HttpURLConnection a(i iVar) throws IOException {
        String fVar = iVar.a().toString();
        HttpURLConnection a = a(new URL(fVar));
        a.setConnectTimeout(60000);
        a.setReadTimeout(60000);
        a.setUseCaches(false);
        a.setDoInput(true);
        if (iVar.f() && fVar.startsWith("https://push.statics")) {
            ((HttpsURLConnection) a).setSSLSocketFactory(com.meizu.cloud.pushsdk.platform.a.a());
            ((HttpsURLConnection) a).setHostnameVerifier(com.meizu.cloud.pushsdk.platform.a.b());
        }
        return a;
    }

    protected HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    static void a(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        switch (iVar.c()) {
            case 0:
                httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
                return;
            case 1:
                httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
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

    private static void b(HttpURLConnection httpURLConnection, i iVar) throws IOException {
        j e = iVar.e();
        if (e != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", e.a().toString());
            com.meizu.cloud.pushsdk.a.h.b a = com.meizu.cloud.pushsdk.a.h.f.a(com.meizu.cloud.pushsdk.a.h.f.a(httpURLConnection.getOutputStream()));
            e.a(a);
            a.close();
        }
    }
}
