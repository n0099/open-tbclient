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
/* loaded from: classes6.dex */
public class s0 {

    /* renamed from: a  reason: collision with root package name */
    public URL f37938a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f37939b;

    /* renamed from: c  reason: collision with root package name */
    public Map f37940c;

    /* renamed from: d  reason: collision with root package name */
    public Map f37941d;

    /* renamed from: e  reason: collision with root package name */
    public String f37942e;

    /* renamed from: f  reason: collision with root package name */
    public int f37943f = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f37944g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f37945h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f37946i = 20000;
    public int j = 20000;

    public s0(String str, String str2, Map map) {
        this.f37942e = "GET";
        this.f37938a = new URL(str);
        this.f37942e = str2;
        this.f37940c = map;
    }

    public t0 a() {
        HttpURLConnection httpURLConnection;
        InputStream errorStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String url = this.f37938a.toString();
        if (!TextUtils.isEmpty(url) ? url.startsWith("http") : false) {
            httpURLConnection = (HttpURLConnection) this.f37938a.openConnection();
        } else {
            httpURLConnection = (HttpsURLConnection) this.f37938a.openConnection();
        }
        httpURLConnection.setRequestMethod(this.f37942e);
        httpURLConnection.setInstanceFollowRedirects(this.f37945h);
        httpURLConnection.setReadTimeout(this.j);
        httpURLConnection.setConnectTimeout(this.f37946i);
        httpURLConnection.setDoInput(true);
        Map map = this.f37940c;
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                for (String str2 : (List) entry.getValue()) {
                    String str3 = "header:" + str + "=" + str2;
                    httpURLConnection.setRequestProperty(str, str2);
                }
            }
        }
        if (this.f37942e.equals("POST")) {
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            PrintWriter printWriter = null;
            PrintWriter printWriter2 = null;
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                byte[] bArr = this.f37939b;
                if (bArr == null) {
                    PrintWriter printWriter3 = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                    try {
                        URL url2 = this.f37938a;
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
        this.f37943f = httpURLConnection.getResponseCode();
        httpURLConnection.getContentLength();
        if (httpURLConnection.getHeaderFields() != null) {
            this.f37941d = httpURLConnection.getHeaderFields();
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
        while (!this.f37944g && i2 != -1) {
            i2 = bufferedInputStream.read(bArr2);
            if (i2 > 0) {
                byteArrayOutputStream.write(bArr2, 0, i2);
            }
        }
        httpURLConnection.disconnect();
        byteArrayOutputStream.flush();
        errorStream.close();
        return new t0(this.f37943f, byteArrayOutputStream.toByteArray(), this.f37941d);
    }
}
