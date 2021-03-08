package com.win.opensdk;

import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes14.dex */
public class aj implements Runnable {
    public String b;
    public String c;
    public boolean f;
    public long g;
    public ao qkK;

    /* renamed from: a  reason: collision with root package name */
    public int f8110a = 0;
    public af qkL = new af(this);

    public aj(String str, String str2, ao aoVar) {
        this.f = false;
        this.b = str;
        this.c = str2;
        this.qkK = aoVar;
        this.f = true;
    }

    public final void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.b);
            HttpURLConnection httpURLConnection = url.toString().startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty(Headers.RANGE, "bytes=" + this.f8110a + Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.g = httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.qkL != null && this.g > 10) {
                this.qkL.a(httpURLConnection.getInputStream());
            } else if (this.qkK != null) {
                this.qkK.a();
            }
        } catch (IOException e) {
            if (!Thread.currentThread().isInterrupted()) {
                throw e;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Exception e) {
            af afVar = this.qkL;
            if (afVar != null) {
                afVar.b(afVar.m(1, new Object[]{K.Socket}));
            }
        }
    }
}
