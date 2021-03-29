package com.win.opensdk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class L implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public String f39709b;

    /* renamed from: c  reason: collision with root package name */
    public String f39710c;

    /* renamed from: d  reason: collision with root package name */
    public N f39711d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39713f;

    /* renamed from: g  reason: collision with root package name */
    public long f39714g;

    /* renamed from: a  reason: collision with root package name */
    public int f39708a = 0;

    /* renamed from: e  reason: collision with root package name */
    public J f39712e = new J(this);

    public L(String str, String str2, N n) {
        this.f39713f = false;
        this.f39709b = str;
        this.f39710c = str2;
        this.f39711d = n;
        this.f39713f = true;
    }

    public final void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f39709b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f39708a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f39714g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f39712e != null && this.f39714g > 10) {
                this.f39712e.a(httpURLConnection.getInputStream());
            } else if (this.f39711d != null) {
                this.f39711d.a();
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
            J j = this.f39712e;
            if (j != null) {
                j.b(j.a(1, new Object[]{K.Socket}));
            }
        }
    }
}
