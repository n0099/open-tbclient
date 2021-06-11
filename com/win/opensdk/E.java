package com.win.opensdk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class E implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public String f40488b;

    /* renamed from: c  reason: collision with root package name */
    public String f40489c;

    /* renamed from: d  reason: collision with root package name */
    public G f40490d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40492f;

    /* renamed from: g  reason: collision with root package name */
    public long f40493g;

    /* renamed from: a  reason: collision with root package name */
    public int f40487a = 0;

    /* renamed from: e  reason: collision with root package name */
    public C f40491e = new C(this);

    public E(String str, String str2, G g2) {
        this.f40492f = false;
        this.f40488b = str;
        this.f40489c = str2;
        this.f40490d = g2;
        this.f40492f = true;
    }

    public final void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f40488b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f40487a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f40493g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f40491e != null && this.f40493g > 10) {
                this.f40491e.a(httpURLConnection.getInputStream());
            } else if (this.f40490d != null) {
                this.f40490d.a();
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
            C c2 = this.f40491e;
            if (c2 != null) {
                c2.b(c2.a(1, new Object[]{D.Socket}));
            }
        }
    }
}
