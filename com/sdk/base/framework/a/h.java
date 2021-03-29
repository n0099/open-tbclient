package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.android.internal.http.multipart.Part;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.sdk.base.module.manager.SDKManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes6.dex */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38475a = "h";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f38476b = com.sdk.base.framework.c.f.f38520b;

    /* renamed from: c  reason: collision with root package name */
    public static String f38477c = UUID.randomUUID().toString();

    /* renamed from: f  reason: collision with root package name */
    public static final HostnameVerifier f38478f = new i();

    /* renamed from: d  reason: collision with root package name */
    public Context f38479d;

    /* renamed from: e  reason: collision with root package name */
    public k<T> f38480e;

    public h(Context context, k<T> kVar) {
        this.f38479d = context;
        this.f38480e = kVar;
    }

    private ByteArrayOutputStream a(k<T> kVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (kVar != null) {
            try {
                String b2 = k.b(this.f38480e.e());
                if (kVar.d().contains("/dro/log/v1.0/log")) {
                    b2 = kVar.e().toString();
                }
                ArrayList<File> b3 = kVar.b();
                if (b3 == null || b3.size() <= 0) {
                    byteArrayOutputStream.write(b2.getBytes("utf-8"));
                } else {
                    byteArrayOutputStream.write(("--" + f38477c + Part.CRLF).getBytes("utf-8"));
                    byteArrayOutputStream.write("Content-Disposition: form-data; name=\"params\"".getBytes("utf-8"));
                    byteArrayOutputStream.write("\r\n\r\n".getBytes("utf-8"));
                    byteArrayOutputStream.write(b2.getBytes("utf-8"));
                    byteArrayOutputStream.write(Part.CRLF.getBytes("utf-8"));
                    for (int i = 0; i < b3.size(); i++) {
                        File file = b3.get(i);
                        if (file != null) {
                            FileInputStream fileInputStream = new FileInputStream(file);
                            String name = file.getName();
                            byteArrayOutputStream.write(("--" + f38477c + Part.CRLF).getBytes("utf-8"));
                            StringBuilder sb = new StringBuilder("Content-Disposition: form-data; name=\"");
                            sb.append(name);
                            sb.append("\"; filename=\"");
                            sb.append(name);
                            sb.append("\"\r\n");
                            byteArrayOutputStream.write(sb.toString().getBytes("utf-8"));
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
                            StringBuilder sb2 = new StringBuilder("\r\n--");
                            sb2.append(f38477c);
                            sb2.append("--\r\n");
                            byteArrayOutputStream.write(sb2.toString().getBytes("utf-8"));
                            byteArrayOutputStream.flush();
                            fileInputStream.close();
                        }
                    }
                }
            } catch (Exception e2) {
                com.sdk.base.framework.f.f.a.b(e2.toString());
                com.sdk.base.framework.a.a.c.b(f38475a, e2.toString(), Boolean.valueOf(f38476b));
            }
        }
        return byteArrayOutputStream;
    }

    public static boolean a(String str) {
        return (!SDKManager.isIsStrong() || str.contains("/api/netm/v1.0/qhbt") || str.contains("/api/netm/v1.0/qhbv") || str.contains("/dro/netm/v1.0/gmctc") || str.contains("/st/api/v1.0/ses")) ? false : true;
    }

    public final String a() {
        String str;
        StringBuilder sb;
        try {
            if (this.f38480e != null) {
                String a2 = this.f38480e.a();
                String d2 = this.f38480e.d();
                str = j.f38481a.k;
                if (a2.equals(str)) {
                    String b2 = k.b(this.f38480e.e());
                    if (!com.sdk.base.framework.a.a.c.b(b2).booleanValue()) {
                        return d2;
                    }
                    sb = new StringBuilder();
                    sb.append(d2);
                    sb.append("?");
                    sb.append(b2);
                } else if (!com.sdk.base.framework.a.a.c.b((String) null).booleanValue()) {
                    return d2;
                } else {
                    sb = new StringBuilder();
                    sb.append(d2);
                    sb.append("?unikey=");
                    sb.append((String) null);
                }
                return sb.toString();
            }
        } catch (Exception e2) {
            com.sdk.base.framework.a.a.c.b(f38475a, e2.getMessage(), Boolean.valueOf(f38476b));
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x013b */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v5 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v11 java.lang.Object)] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HttpURLConnection a(String str, boolean z) {
        HttpURLConnection httpURLConnection;
        a aVar;
        HttpURLConnection httpURLConnection2;
        com.sdk.base.framework.f.g.c a2;
        com.sdk.base.framework.f.g.c.f38553c.a();
        try {
            HttpsURLConnection httpsURLConnection = null;
            r1 = null;
            HttpURLConnection httpURLConnection3 = null;
            if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
                URL url = new URL(str);
                int a3 = com.sdk.base.framework.f.g.b.a(this.f38479d, null).a();
                System.currentTimeMillis();
                if (a(str) && a3 != com.sdk.base.framework.f.g.c.f38552b.a()) {
                    int b2 = com.sdk.base.framework.f.a.a.b();
                    if (b2 < 23) {
                        String d2 = this.f38480e.d();
                        if (a(d2)) {
                            ArrayList arrayList = new ArrayList();
                            if (com.sdk.base.framework.a.a.c.b(d2).booleanValue()) {
                                arrayList.add(d2);
                            }
                            a2 = com.sdk.base.framework.f.g.b.a(this.f38479d, arrayList);
                        } else {
                            a2 = com.sdk.base.framework.f.g.b.a(this.f38479d, null);
                        }
                        a3 = a2.a();
                        if (b2 <= 21 || a3 == com.sdk.base.framework.f.g.c.f38552b.a()) {
                            httpURLConnection2 = null;
                            if (httpURLConnection2 != null) {
                                return null;
                            }
                            httpURLConnection3 = httpURLConnection2;
                        } else {
                            aVar = new a(this.f38479d, url);
                        }
                    } else {
                        aVar = new a(this.f38479d, url);
                    }
                    httpURLConnection2 = aVar.a();
                    if (httpURLConnection2 != null) {
                    }
                }
                if (httpURLConnection3 == null) {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                } else {
                    httpURLConnection = httpURLConnection3;
                    if (a3 == com.sdk.base.framework.f.g.c.f38551a.a()) {
                        a3 = 2;
                        httpURLConnection = httpURLConnection3;
                    }
                }
                String protocol = url.getProtocol();
                httpsURLConnection = httpURLConnection;
                httpsURLConnection = httpURLConnection;
                if (com.sdk.base.framework.a.a.c.b(protocol).booleanValue() && z) {
                    httpsURLConnection = httpURLConnection;
                    if (SDKManager.isSmartTrust()) {
                        httpsURLConnection = httpURLConnection;
                        if ("https".equals(protocol.toLowerCase(Locale.getDefault()))) {
                            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) httpURLConnection;
                            httpsURLConnection2.setHostnameVerifier(f38478f);
                            httpsURLConnection = httpsURLConnection2;
                        }
                    }
                }
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setInstanceFollowRedirects(false);
                httpsURLConnection.setRequestProperty("user-agent", com.sdk.base.framework.f.d.a.a(this.f38479d));
                StringBuilder sb = new StringBuilder();
                sb.append(a3);
                httpsURLConnection.setRequestProperty("netType", sb.toString());
                httpsURLConnection.setRequestProperty(IXAdRequestInfo.OS, "android");
                HashMap<String, Object> h2 = this.f38480e.h();
                if (h2 != null && h2.size() > 0) {
                    for (Map.Entry<String, Object> entry : h2.entrySet()) {
                        Object value = entry.getValue();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(value);
                        httpsURLConnection.setRequestProperty(entry.getKey(), sb2.toString());
                    }
                }
            }
            return httpsURLConnection;
        } catch (Exception e2) {
            com.sdk.base.framework.f.f.a.b(e2.toString());
            com.sdk.base.framework.a.a.c.b(f38475a, e2.toString(), Boolean.valueOf(f38476b));
            throw e2;
        }
    }

    public final HttpURLConnection a(HttpURLConnection httpURLConnection) {
        String str;
        String str2;
        if (httpURLConnection != null) {
            k<T> kVar = this.f38480e;
            if (kVar == null || !kVar.c()) {
                str = "application/x-www-form-urlencoded";
            } else {
                str = "multipart/form-data; boundary=" + f38477c;
            }
            httpURLConnection.setRequestProperty("Content-Type", str);
            httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
            httpURLConnection.setRequestProperty("connection", "keep-alive");
            if (this.f38480e != null) {
                str2 = j.f38482b.k;
                if (str2.equals(this.f38480e.a())) {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.connect();
                    httpURLConnection.getOutputStream().write(a(this.f38480e).toByteArray());
                } else {
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.connect();
                }
            }
        }
        return httpURLConnection;
    }

    public final k<T> b() {
        return this.f38480e;
    }

    public final void c() {
        this.f38480e.a(j.f38481a.toString());
    }
}
