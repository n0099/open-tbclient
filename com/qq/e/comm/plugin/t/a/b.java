package com.qq.e.comm.plugin.t.a;

import com.qq.e.comm.plugin.t.a.a;
import com.qq.e.comm.plugin.t.b.e;
import com.qq.e.comm.plugin.t.b.f;
import com.qq.e.comm.plugin.t.j;
import com.qq.e.comm.plugin.util.ab;
import com.qq.e.comm.util.GDTLogger;
import java.io.BufferedOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements a {
    private HttpURLConnection a(e eVar, HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, String> entry : eVar.d().entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.setRequestProperty("User-Agent", j.f12541a);
        if (eVar.g() > 0) {
            httpURLConnection.setConnectTimeout(eVar.g());
        } else {
            httpURLConnection.setConnectTimeout(30000);
        }
        if (eVar.h() > 0) {
            httpURLConnection.setReadTimeout(eVar.h());
        } else {
            httpURLConnection.setReadTimeout(30000);
        }
        return httpURLConnection;
    }

    private HttpURLConnection a(e eVar, URL url, HttpURLConnection httpURLConnection) throws Exception {
        switch (eVar.b()) {
            case POST:
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setChunkedStreamingMode(0);
                byte[] a2 = eVar.a();
                if (a2 == null || a2.length <= 0) {
                    return httpURLConnection;
                }
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(a2);
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                return httpURLConnection;
            case GET:
                GDTLogger.d(url.toString());
                boolean i = eVar.i();
                httpURLConnection.setInstanceFollowRedirects(i);
                return i ? ab.a(httpURLConnection) : httpURLConnection;
            default:
                return httpURLConnection;
        }
    }

    @Override // com.qq.e.comm.plugin.t.a.a
    public f a(a.InterfaceC1206a interfaceC1206a) throws Exception {
        e a2 = interfaceC1206a.a();
        URL url = new URL(a2.f());
        return a2.a(a(a2, url, a(a2, (HttpURLConnection) url.openConnection())));
    }
}
