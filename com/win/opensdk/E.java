package com.win.opensdk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class E implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public String f36809b;

    /* renamed from: c  reason: collision with root package name */
    public String f36810c;

    /* renamed from: d  reason: collision with root package name */
    public G f36811d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f36813f;

    /* renamed from: g  reason: collision with root package name */
    public long f36814g;

    /* renamed from: a  reason: collision with root package name */
    public int f36808a = 0;

    /* renamed from: e  reason: collision with root package name */
    public C f36812e = new C(this);

    public E(String str, String str2, G g2) {
        this.f36813f = false;
        this.f36809b = str;
        this.f36810c = str2;
        this.f36811d = g2;
        this.f36813f = true;
    }

    public final void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f36809b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f36808a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f36814g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f36812e != null && this.f36814g > 10) {
                this.f36812e.a(httpURLConnection.getInputStream());
            } else if (this.f36811d != null) {
                this.f36811d.a();
            }
        } catch (IOException e2) {
            if (!Thread.currentThread().isInterrupted()) {
                throw e2;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Exception unused) {
            C c2 = this.f36812e;
            if (c2 != null) {
                c2.b(c2.a(1, new Object[]{D.Socket}));
            }
        }
    }
}
