package com.win.opensdk;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.protocol.HTTP;
/* loaded from: classes7.dex */
public class L implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public String f40093b;

    /* renamed from: c  reason: collision with root package name */
    public String f40094c;

    /* renamed from: d  reason: collision with root package name */
    public N f40095d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f40097f;

    /* renamed from: g  reason: collision with root package name */
    public long f40098g;

    /* renamed from: a  reason: collision with root package name */
    public int f40092a = 0;

    /* renamed from: e  reason: collision with root package name */
    public J f40096e = new J(this);

    public L(String str, String str2, N n) {
        this.f40097f = false;
        this.f40093b = str;
        this.f40094c = str2;
        this.f40095d = n;
        this.f40097f = true;
    }

    public final void a() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        try {
            URL url = new URL(this.f40093b);
            HttpURLConnection httpURLConnection = url.toString().startsWith("https://") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Range", "bytes=" + this.f40092a + "-");
            httpURLConnection.setRequestProperty(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            httpURLConnection.connect();
            this.f40098g = (long) httpURLConnection.getContentLength();
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            if (this.f40096e != null && this.f40098g > 10) {
                this.f40096e.a(httpURLConnection.getInputStream());
            } else if (this.f40095d != null) {
                this.f40095d.a();
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
            J j = this.f40096e;
            if (j != null) {
                j.b(j.a(1, new Object[]{K.Socket}));
            }
        }
    }
}
