package com.win.opensdk;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes7.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public URL f37112a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f37113b;

    /* renamed from: c  reason: collision with root package name */
    public Map f37114c;

    /* renamed from: d  reason: collision with root package name */
    public Map f37115d;

    /* renamed from: e  reason: collision with root package name */
    public String f37116e;

    /* renamed from: f  reason: collision with root package name */
    public int f37117f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37118g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37119h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f37120i = 20000;
    public int j = 20000;

    public s0(String str, String str2, Map map) {
        this.f37116e = "GET";
        this.f37112a = new URL(str);
        this.f37116e = str2;
        this.f37114c = map;
    }

    public t0 a() {
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String url = this.f37112a.toString();
        if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
            httpURLConnection = (HttpURLConnection) this.f37112a.openConnection();
        } else {
            httpURLConnection = (HttpsURLConnection) this.f37112a.openConnection();
        }
        httpURLConnection.setRequestMethod(this.f37116e);
        httpURLConnection.setInstanceFollowRedirects(this.f37119h);
        httpURLConnection.setReadTimeout(this.j);
        httpURLConnection.setConnectTimeout(this.f37120i);
        httpURLConnection.setDoInput(true);
        Map map = this.f37114c;
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                for (String str2 : (List) entry.getValue()) {
                    String str3 = "header:" + str + "=" + str2;
                    httpURLConnection.setRequestProperty(str, str2);
                }
            }
        }
        if (this.f37116e.equals("POST")) {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            PrintWriter printWriter = null;
            PrintWriter printWriter2 = null;
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                byte[] bArr = this.f37113b;
                if (bArr == null) {
                    PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                    try {
                        URL url2 = this.f37112a;
                        printWriter3.print(url2 != null ? url2.getQuery() : null);
                        printWriter3.flush();
                        printWriter2 = printWriter3;
                    } catch (Throwable th) {
                        th = th;
                        printWriter = printWriter3;
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        throw th;
                    }
                } else {
                    outputStream.write(bArr);
                    outputStream.flush();
                }
                if (printWriter2 != null) {
                    printWriter2.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.f37117f = httpURLConnection.getResponseCode();
        httpURLConnection.getContentLength();
        if (httpURLConnection.getHeaderFields() != null) {
            this.f37115d = httpURLConnection.getHeaderFields();
        }
        try {
            String contentEncoding = httpURLConnection.getContentEncoding();
            errorStream = (contentEncoding == null || !contentEncoding.contains(AsyncHttpClient.ENCODING_GZIP)) ? httpURLConnection.getInputStream() : new GZIPInputStream(httpURLConnection.getInputStream());
        } catch (IOException e2) {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream == null) {
                throw new RuntimeException("InputStream is error: " + e2.getMessage());
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
        byte[] bArr2 = new byte[4096];
        int i2 = 0;
        while (!this.f37118g && i2 != -1) {
            i2 = bufferedInputStream.read(bArr2);
            if (i2 > 0) {
                byteArrayOutputStream.write(bArr2, 0, i2);
            }
        }
        httpURLConnection.disconnect();
        byteArrayOutputStream.flush();
        errorStream.close();
        return new t0(this.f37117f, byteArrayOutputStream.toByteArray(), this.f37115d);
    }
}
