package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.http.Headers;
import com.sdk.base.module.manager.SDKManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes16.dex */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4473a = h.class.getSimpleName();
    private static boolean b = com.sdk.base.framework.c.f.b;
    private static String c = UUID.randomUUID().toString();
    private Context d;
    private j<T> e;

    public h(Context context, j<T> jVar) {
        this.d = context;
        this.e = jVar;
    }

    private ByteArrayOutputStream a(j<T> jVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (jVar != null) {
            try {
                String b2 = j.b(this.e.f());
                if (jVar.e().contains("/dro/log/v1.0/log")) {
                    b2 = jVar.f().toString();
                }
                ArrayList<File> c2 = jVar.c();
                if (c2 == null || c2.size() <= 0) {
                    byteArrayOutputStream.write(b2.getBytes("utf-8"));
                } else {
                    byteArrayOutputStream.write(("--" + c + "\r\n").getBytes("utf-8"));
                    byteArrayOutputStream.write("Content-Disposition: form-data; name=\"params\"".getBytes("utf-8"));
                    byteArrayOutputStream.write("\r\n\r\n".getBytes("utf-8"));
                    byteArrayOutputStream.write(b2.getBytes("utf-8"));
                    byteArrayOutputStream.write("\r\n".getBytes("utf-8"));
                    for (int i = 0; i < c2.size(); i++) {
                        File file = c2.get(i);
                        if (file != null) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            String name = file.getName();
                            byteArrayOutputStream.write(("--" + c + "\r\n").getBytes("utf-8"));
                            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + name + "\"; filename=\"" + name + "\"\r\n").getBytes("utf-8"));
                            byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes("utf-8"));
                            byteArrayOutputStream.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes("utf-8"));
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            byteArrayOutputStream.write(("\r\n--" + c + "--\r\n").getBytes("utf-8"));
                            byteArrayOutputStream.flush();
                            fileInputStream.close();
                        }
                    }
                }
            } catch (Exception e) {
                com.sdk.base.framework.f.g.a.b(e.toString());
                com.sdk.base.framework.a.a.c.b(f4473a, e.toString(), Boolean.valueOf(b));
            }
        }
        return byteArrayOutputStream;
    }

    private static boolean b(String str) {
        return (!SDKManager.isIsStrong() || str.contains("/api/netm/v1.0/qhbt") || str.contains("/api/netm/v1.0/qhbv") || str.contains("/dro/netm/v1.0/gmctc") || str.contains("/st/api/v1.0/ses")) ? false : true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0080 -> B:10:0x0049). Please submit an issue!!! */
    public final String a() {
        String str;
        try {
            if (this.e != null) {
                String a2 = this.e.a();
                String e = this.e.e();
                str = i.f4474a.k;
                if (a2.equals(str)) {
                    String b2 = j.b(this.e.f());
                    return com.sdk.base.framework.a.a.c.b(b2).booleanValue() ? e + "?" + b2 : e;
                }
                j<T> jVar = this.e;
                return com.sdk.base.framework.a.a.c.b((String) null).booleanValue() ? e + "?unikey=" + ((String) null) : e;
            }
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f4473a, e2.getMessage(), Boolean.valueOf(b));
        }
        return null;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r0v6 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : 0x010e: INVOKE  (r0v17 java.lang.Object A[REMOVE]) = (r0v16 java.util.Map$Entry<java.lang.String, java.lang.Object>) type: INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object)] */
    @SuppressLint({"DefaultLocale"})
    public final HttpURLConnection a(String str) {
        HttpURLConnection httpURLConnection;
        int i;
        com.sdk.base.framework.f.h.c.c.a();
        try {
            if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
                URL url = new URL(str);
                int a2 = com.sdk.base.framework.f.h.b.a(this.d, (ArrayList<String>) null).a();
                System.currentTimeMillis();
                if (!b(str) || a2 == com.sdk.base.framework.f.h.c.b.a()) {
                    httpURLConnection = null;
                } else {
                    int b2 = com.sdk.base.framework.f.a.a.b();
                    if (b2 < 23) {
                        String e = this.e.e();
                        if (b(e)) {
                            ArrayList arrayList = new ArrayList();
                            if (com.sdk.base.framework.a.a.c.b(e).booleanValue()) {
                                arrayList.add(e);
                            }
                            a2 = com.sdk.base.framework.f.h.b.a(this.d, arrayList).a();
                        } else {
                            a2 = com.sdk.base.framework.f.h.b.a(this.d, (ArrayList<String>) null).a();
                        }
                        httpURLConnection = (b2 <= 21 || a2 == com.sdk.base.framework.f.h.c.b.a()) ? null : new a(this.d, url).a();
                    } else {
                        httpURLConnection = new a(this.d, url).a();
                    }
                    if (httpURLConnection == null) {
                        return null;
                    }
                }
                if (httpURLConnection == null) {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    i = a2;
                } else {
                    i = a2 == com.sdk.base.framework.f.h.c.f4499a.a() ? 2 : a2;
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setInstanceFollowRedirects(true);
                if (com.sdk.base.framework.f.h.g.c == this.e.b()) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                }
                httpURLConnection.setRequestProperty("user-agent", com.sdk.base.framework.f.e.a.a(this.d));
                httpURLConnection.setRequestProperty("netType", new StringBuilder().append(i).toString());
                httpURLConnection.setRequestProperty("os", "android");
                HashMap<String, Object> i2 = this.e.i();
                if (i2 != null && i2.size() > 0) {
                    for (Map.Entry<String, Object> entry : i2.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), new StringBuilder().append(entry.getValue()).toString());
                    }
                }
                return httpURLConnection;
            }
            return null;
        } catch (Exception e2) {
            com.sdk.base.framework.f.g.a.b(e2.toString());
            com.sdk.base.framework.a.a.c.b(f4473a, e2.toString(), Boolean.valueOf(b));
            throw e2;
        }
    }

    public final HttpURLConnection a(HttpURLConnection httpURLConnection) {
        String str;
        if (httpURLConnection != null) {
            if (this.e == null || !this.e.d()) {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            } else {
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + c);
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty(Headers.CONN_DIRECTIVE, "keep-alive");
            if (this.e != null) {
                str = i.b.k;
                if (str.equals(this.e.a())) {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.connect();
                    httpURLConnection.getOutputStream().write(a(this.e).toByteArray());
                } else {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                }
            }
        }
        return httpURLConnection;
    }

    public final j<T> b() {
        return this.e;
    }

    public final void c() {
        this.e.a(i.f4474a.toString());
    }
}
