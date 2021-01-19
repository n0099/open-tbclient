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
/* loaded from: classes3.dex */
public class s {
    private static final String java = s.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private int f13756a;

    /* renamed from: case  reason: not valid java name */
    private int f68case;

    /* renamed from: case  reason: not valid java name and collision with other field name */
    private String f69case;

    /* renamed from: java  reason: collision with other field name */
    private int f70java;
    private boolean pYM;
    private Map<String, List<String>> pZA;
    private Map<String, List<String>> pZB;
    private long pZf;
    private boolean pZm;
    private URL pZy;
    public byte[] pZz;

    public s(String str, String str2, Map<String, List<String>> map) {
        this(str, str2, map, (byte) 0);
    }

    private s(String str, String str2, Map<String, List<String>> map, byte b2) {
        this.f69case = "GET";
        this.f70java = -1;
        this.pZf = -1L;
        this.pYM = false;
        this.pZm = true;
        this.pZy = new URL(str);
        this.f69case = str2;
        this.pZA = map;
        this.f68case = 20000;
        this.f13756a = 20000;
    }

    public final t eGD() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e(byteArrayOutputStream);
        return new t(this.f70java, byteArrayOutputStream.toByteArray(), this.pZB);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v45, types: [java.net.HttpURLConnection] */
    private void e(OutputStream outputStream) {
        HttpsURLConnection httpsURLConnection;
        InputStream errorStream;
        PrintWriter printWriter;
        String url = this.pZy.toString();
        if (!TextUtils.isEmpty(url) ? url.startsWith(HttpHost.DEFAULT_SCHEME_NAME) : false) {
            httpsURLConnection = (HttpURLConnection) this.pZy.openConnection();
        } else {
            httpsURLConnection = (HttpsURLConnection) this.pZy.openConnection();
        }
        httpsURLConnection.setRequestMethod(this.f69case);
        httpsURLConnection.setInstanceFollowRedirects(this.pZm);
        httpsURLConnection.setReadTimeout(this.f13756a);
        httpsURLConnection.setConnectTimeout(this.f68case);
        httpsURLConnection.setDoInput(true);
        Map<String, List<String>> map = this.pZA;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                for (String str : entry.getValue()) {
                    new StringBuilder("header:").append(key).append("=").append(str);
                    httpsURLConnection.setRequestProperty(key, str);
                }
            }
        }
        if (this.f69case.equals("POST")) {
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);
            try {
                OutputStream outputStream2 = httpsURLConnection.getOutputStream();
                byte[] bArr = this.pZz;
                if (bArr == null) {
                    printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream2, "UTF-8"), true);
                    try {
                        printWriter.print(this.pZy != null ? this.pZy.getQuery() : null);
                        printWriter.flush();
                    } catch (Throwable th) {
                        th = th;
                        if (printWriter != null) {
                            printWriter.close();
                        }
                        throw th;
                    }
                } else {
                    outputStream2.write(bArr);
                    outputStream2.flush();
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
        this.f70java = httpsURLConnection.getResponseCode();
        this.pZf = httpsURLConnection.getContentLength();
        if (httpsURLConnection.getHeaderFields() != null) {
            this.pZB = httpsURLConnection.getHeaderFields();
        }
        try {
            String contentEncoding = httpsURLConnection.getContentEncoding();
            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                errorStream = new GZIPInputStream(httpsURLConnection.getInputStream());
            } else {
                errorStream = httpsURLConnection.getInputStream();
            }
        } catch (IOException e) {
            errorStream = httpsURLConnection.getErrorStream();
            if (errorStream == null) {
                throw new RuntimeException("InputStream is error: " + e.getMessage());
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(errorStream);
        byte[] bArr2 = new byte[4096];
        int i = 0;
        while (!this.pYM && i != -1) {
            i = bufferedInputStream.read(bArr2);
            if (i > 0) {
                outputStream.write(bArr2, 0, i);
            }
        }
        httpsURLConnection.disconnect();
        outputStream.flush();
        errorStream.close();
    }
}
