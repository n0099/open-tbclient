package com.win.opensdk;

import android.text.TextUtils;
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
import org.apache.http.HttpHost;
/* loaded from: classes14.dex */
public class bk {

    /* renamed from: a  reason: collision with root package name */
    public URL f8117a;
    public byte[] b;
    public Map c;
    public Map d;
    public String e;
    public int f = -1;
    public boolean g = false;
    public boolean h = true;
    public int i = 20000;
    public int j = 20000;

    public bk(String str, String str2, Map map) {
        this.e = "GET";
        this.f8117a = new URL(str);
        this.e = str2;
        this.c = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.net.HttpURLConnection] */
    public bm eJc() {
        HttpsURLConnection httpsURLConnection;
        InputStream errorStream;
        PrintWriter printWriter;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String url = this.f8117a.toString();
        if (!TextUtils.isEmpty(url) ? url.startsWith(HttpHost.DEFAULT_SCHEME_NAME) : false) {
            httpsURLConnection = (HttpURLConnection) this.f8117a.openConnection();
        } else {
            httpsURLConnection = (HttpsURLConnection) this.f8117a.openConnection();
        }
        httpsURLConnection.setRequestMethod(this.e);
        httpsURLConnection.setInstanceFollowRedirects(this.h);
        httpsURLConnection.setReadTimeout(this.j);
        httpsURLConnection.setConnectTimeout(this.i);
        httpsURLConnection.setDoInput(true);
        Map map = this.c;
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                for (String str2 : (List) entry.getValue()) {
                    String str3 = "header:" + str + "=" + str2;
                    httpsURLConnection.setRequestProperty(str, str2);
                }
            }
        }
        if (this.e.equals("POST")) {
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            try {
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                byte[] bArr = this.b;
                if (bArr == null) {
                    printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                    try {
                        URL url2 = this.f8117a;
                        printWriter.print(url2 != null ? url2.getQuery() : null);
                        printWriter.flush();
                    } catch (Throwable th) {
                        th = th;
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        throw th;
                    }
                } else {
                    outputStream.write(bArr);
                    outputStream.flush();
                    printWriter = null;
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Throwable th2) {
                th = th2;
                printWriter = null;
            }
        }
        this.f = httpsURLConnection.getResponseCode();
        httpsURLConnection.getContentLength();
        if (httpsURLConnection.getHeaderFields() != null) {
            this.d = httpsURLConnection.getHeaderFields();
        }
        try {
            String contentEncoding = httpsURLConnection.getContentEncoding();
            errorStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? httpsURLConnection.getInputStream() : new GZIPInputStream(httpsURLConnection.getInputStream());
        } catch (IOException e) {
            errorStream = httpsURLConnection.getErrorStream();
            if (errorStream == null) {
                throw new RuntimeException("InputStream is error: " + e.getMessage());
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
        byte[] bArr2 = new byte[4096];
        int i = 0;
        while (!this.g && i != -1) {
            i = bufferedInputStream.read(bArr2);
            if (i > 0) {
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        }
        httpsURLConnection.disconnect();
        byteArrayOutputStream.flush();
        errorStream.close();
        return new bm(this.f, byteArrayOutputStream.toByteArray(), this.d);
    }
}
