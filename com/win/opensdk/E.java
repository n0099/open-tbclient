package com.win.opensdk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class E implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public String f37635b;

    /* renamed from: c  reason: collision with root package name */
    public String f37636c;

    /* renamed from: d  reason: collision with root package name */
    public G f37637d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f37639f;

    /* renamed from: g  reason: collision with root package name */
    public long f37640g;

    /* renamed from: a  reason: collision with root package name */
    public int f37634a = 0;

    /* renamed from: e  reason: collision with root package name */
    public C f37638e = new C(this);

    public E(String str, String str2, G g2) {
        this.f37639f = false;
        this.f37635b = str;
        this.f37636c = str2;
        this.f37637d = g2;
        this.f37639f = true;
    }

    public final void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f37635b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f37634a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f37640g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f37638e != null && this.f37640g > 10) {
                this.f37638e.a(httpURLConnection.getInputStream());
            } else if (this.f37637d != null) {
                this.f37637d.a();
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
            C c2 = this.f37638e;
            if (c2 != null) {
                c2.b(c2.a(1, new Object[]{D.Socket}));
            }
        }
    }
}
