package com.cmic.sso.sdk.c.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.cmic.sso.sdk.e.q;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
/* loaded from: classes10.dex */
public class a implements b {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [120=4, 126=6] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091 A[Catch: all -> 0x0284, TryCatch #0 {all -> 0x0284, blocks: (B:46:0x0175, B:48:0x017b, B:51:0x018b, B:16:0x006c, B:18:0x0091, B:19:0x009a), top: B:103:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0264  */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.cmic.sso.sdk.c.a.a] */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // com.cmic.sso.sdk.c.a.b
    @TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Throwable th;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        StringBuilder sb;
        StringBuilder sb2;
        int i;
        int responseCode;
        String str = "请求地址: " + cVar.a();
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", str);
        int i2 = -1;
        try {
            try {
                URL url = new URL(cVar.a());
                if (cVar.eoE() != null) {
                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "开始wifi下取号");
                    httpURLConnection = (HttpURLConnection) cVar.eoE().openConnection(url);
                } else {
                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "使用当前网络环境发送请求");
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                try {
                    Map<String, String> c = cVar.c();
                    if (c != null) {
                        for (String str2 : c.keySet()) {
                            httpURLConnection.addRequestProperty(str2, c.get(str2));
                        }
                    }
                    a(httpURLConnection, aVar, cVar.a());
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setDefaultUseCaches(false);
                    String e = cVar.e();
                    httpURLConnection.setRequestMethod(e);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.connect();
                    if (cVar instanceof com.cmic.sso.sdk.c.c.b) {
                        ((com.cmic.sso.sdk.c.c.b) cVar).b(aVar);
                    }
                    if (e.endsWith("POST")) {
                        OutputStream outputStream2 = httpURLConnection.getOutputStream();
                        try {
                            outputStream2.write(cVar.d().getBytes("utf-8"));
                            outputStream2.flush();
                            outputStream = outputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            inputStream = null;
                            outputStream = outputStream2;
                            sb2 = null;
                            e.printStackTrace();
                            com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                            if (e instanceof SSLHandshakeException) {
                            }
                            com.cmic.sso.sdk.d.a.oZX.add(e);
                            if (!(e instanceof EOFException)) {
                            }
                            a(outputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (!TextUtils.isEmpty(sb2) ? "" : sb2.toString()));
                            switch (i) {
                                case 200:
                                case 301:
                                case 302:
                                    break;
                            }
                        } catch (Throwable th2) {
                            inputStream = null;
                            outputStream = outputStream2;
                            th = th2;
                            sb = null;
                            a(outputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i2);
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (!TextUtils.isEmpty(sb) ? "" : sb.toString()));
                            switch (i2) {
                                case 200:
                                case 301:
                                case 302:
                                    cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                    break;
                                default:
                                    cVar2.a(com.cmic.sso.sdk.c.d.a.PK(i2));
                                    break;
                            }
                            throw th;
                        }
                    } else {
                        outputStream = null;
                    }
                    try {
                        responseCode = httpURLConnection.getResponseCode();
                        try {
                            inputStream = httpURLConnection.getInputStream();
                        } catch (Exception e3) {
                            e = e3;
                            sb2 = null;
                            inputStream = null;
                        } catch (Throwable th3) {
                            i2 = responseCode;
                            inputStream = null;
                            th = th3;
                            sb = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        inputStream = null;
                        sb2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = null;
                        sb = null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    inputStream = null;
                    outputStream = null;
                    sb2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                    outputStream = null;
                    sb = null;
                }
            } catch (Throwable th6) {
                sb = -1;
                i2 = str;
                th = th6;
            }
        } catch (Exception e6) {
            e = e6;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
            sb2 = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
            sb = null;
        }
        try {
            byte[] bArr = new byte[2048];
            sb2 = new StringBuilder();
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb2.append(new String(bArr, 0, read, "utf-8"));
                } catch (Exception e7) {
                    e = e7;
                    e.printStackTrace();
                    com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                    if (e instanceof SSLHandshakeException) {
                        aVar.a("isNeedToGetCert", true);
                    }
                    com.cmic.sso.sdk.d.a.oZX.add(e);
                    i = !(e instanceof EOFException) ? 200050 : 102102;
                    a(outputStream);
                    a(inputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (!TextUtils.isEmpty(sb2) ? "" : sb2.toString()));
                    switch (i) {
                        case 200:
                        case 301:
                        case 302:
                            cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                            return;
                        default:
                            cVar2.a(com.cmic.sso.sdk.c.d.a.PK(i));
                            return;
                    }
                }
            }
            com.cmic.sso.sdk.c.d.b bVar = new com.cmic.sso.sdk.c.d.b(responseCode, httpURLConnection.getHeaderFields(), sb2.toString());
            a(outputStream);
            a(inputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (TextUtils.isEmpty(sb2) ? "" : sb2.toString()));
            switch (responseCode) {
                case 200:
                case 301:
                case 302:
                    cVar2.a(bVar);
                    return;
                default:
                    cVar2.a(com.cmic.sso.sdk.c.d.a.PK(responseCode));
                    return;
            }
        } catch (Exception e8) {
            e = e8;
            sb2 = null;
        } catch (Throwable th8) {
            i2 = responseCode;
            th = th8;
            sb = null;
            a(outputStream);
            a(inputStream);
            if (httpURLConnection != null) {
            }
            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i2);
            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (!TextUtils.isEmpty(sb) ? "" : sb.toString()));
            switch (i2) {
                case 200:
                case 301:
                case 302:
                    break;
            }
            throw th;
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(HttpURLConnection httpURLConnection, com.cmic.sso.sdk.a aVar, String str) {
        String a2;
        if ((httpURLConnection instanceof HttpsURLConnection) && !aVar.b("CLOSE_CERT_VERIFY", true) && !str.contains("https://config.cmpassport.com/client/uniConfig")) {
            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "开启证书校验");
            if (str.contains("getAuthToken")) {
                a2 = q.a(q.f());
            } else {
                a2 = q.a(q.g());
            }
            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "cer: " + a2);
            if (!TextUtils.isEmpty(a2)) {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new com.cmic.sso.sdk.c.e.a(a2).eoG().getSocketFactory());
            }
        }
    }
}
