package com.win.opensdk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class L implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public String f39998b;

    /* renamed from: c  reason: collision with root package name */
    public String f39999c;

    /* renamed from: d  reason: collision with root package name */
    public N f40000d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40002f;

    /* renamed from: g  reason: collision with root package name */
    public long f40003g;

    /* renamed from: a  reason: collision with root package name */
    public int f39997a = 0;

    /* renamed from: e  reason: collision with root package name */
    public J f40001e = new J(this);

    public L(String str, String str2, N n) {
        this.f40002f = false;
        this.f39998b = str;
        this.f39999c = str2;
        this.f40000d = n;
        this.f40002f = true;
    }

    public final void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f39998b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f39997a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f40003g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f40001e != null && this.f40003g > 10) {
                this.f40001e.a(httpURLConnection.getInputStream());
            } else if (this.f40000d != null) {
                this.f40000d.a();
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
            J j = this.f40001e;
            if (j != null) {
                j.b(j.a(1, new Object[]{K.Socket}));
            }
        }
    }
}
