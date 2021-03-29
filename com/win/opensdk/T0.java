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
public class T0 {

    /* renamed from: a  reason: collision with root package name */
    public URL f39800a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f39801b;

    /* renamed from: c  reason: collision with root package name */
    public Map f39802c;

    /* renamed from: d  reason: collision with root package name */
    public Map f39803d;

    /* renamed from: e  reason: collision with root package name */
    public String f39804e;

    /* renamed from: f  reason: collision with root package name */
    public int f39805f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39806g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39807h = true;
    public int i = 20000;
    public int j = 20000;

    public T0(String str, String str2, Map map) {
        this.f39804e = "GET";
        this.f39800a = new URL(str);
        this.f39804e = str2;
        this.f39802c = map;
    }

    public U0 a() {
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String url = this.f39800a.toString();
        if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
            httpURLConnection = (HttpURLConnection) this.f39800a.openConnection();
        } else {
            httpURLConnection = (HttpsURLConnection) this.f39800a.openConnection();
        }
        httpURLConnection.setRequestMethod(this.f39804e);
        httpURLConnection.setInstanceFollowRedirects(this.f39807h);
        httpURLConnection.setReadTimeout(this.j);
        httpURLConnection.setConnectTimeout(this.i);
        httpURLConnection.setDoInput(true);
        Map map = this.f39802c;
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                for (String str2 : (List) entry.getValue()) {
                    String str3 = "header:" + str + "=" + str2;
                    httpURLConnection.setRequestProperty(str, str2);
                }
            }
        }
        if (this.f39804e.equals("POST")) {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            PrintWriter printWriter = null;
            PrintWriter printWriter2 = null;
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                byte[] bArr = this.f39801b;
                if (bArr == null) {
                    PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                    try {
                        URL url2 = this.f39800a;
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
        this.f39805f = httpURLConnection.getResponseCode();
        httpURLConnection.getContentLength();
        if (httpURLConnection.getHeaderFields() != null) {
            this.f39803d = httpURLConnection.getHeaderFields();
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
        int i = 0;
        while (!this.f39806g && i != -1) {
            i = bufferedInputStream.read(bArr2);
            if (i > 0) {
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        }
        httpURLConnection.disconnect();
        byteArrayOutputStream.flush();
        errorStream.close();
        return new U0(this.f39805f, byteArrayOutputStream.toByteArray(), this.f39803d);
    }
}
