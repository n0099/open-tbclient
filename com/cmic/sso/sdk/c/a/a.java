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
/* loaded from: classes6.dex */
public class a implements b {
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [120=4, 126=6, 127=4] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091 A[Catch: all -> 0x027d, TryCatch #11 {all -> 0x027d, blocks: (B:16:0x006c, B:18:0x0091, B:19:0x0098), top: B:100:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x025f  */
    @Override // com.cmic.sso.sdk.c.a.b
    @TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        Throwable th;
        int i;
        StringBuilder sb;
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        int i2;
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "请求地址: " + cVar.a());
        try {
            URL url = new URL(cVar.a());
            if (cVar.eoX() != null) {
                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "开始wifi下取号");
                httpURLConnection = (HttpURLConnection) cVar.eoX().openConnection(url);
            } else {
                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "使用当前网络环境发送请求");
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            try {
                Map<String, String> c = cVar.c();
                if (c != null) {
                    for (String str : c.keySet()) {
                        httpURLConnection.addRequestProperty(str, c.get(str));
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
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(cVar.d().getBytes("utf-8"));
                        outputStream.flush();
                    } catch (Exception e2) {
                        e = e2;
                        i = -1;
                        sb = null;
                        inputStream = null;
                        try {
                            e.printStackTrace();
                            com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                            if (e instanceof SSLHandshakeException) {
                                aVar.a("isNeedToGetCert", true);
                            }
                            com.cmic.sso.sdk.d.a.pmH.add(e);
                            i2 = !(e instanceof EOFException) ? 200050 : 102102;
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
                                    return;
                                default:
                                    cVar2.a(com.cmic.sso.sdk.c.d.a.Or(i2));
                                    return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            a(outputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (TextUtils.isEmpty(sb) ? "" : sb.toString()));
                            switch (i) {
                                case 200:
                                case 301:
                                case 302:
                                    cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                    break;
                                default:
                                    cVar2.a(com.cmic.sso.sdk.c.d.a.Or(i));
                                    break;
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i = -1;
                        sb = null;
                        inputStream = null;
                        a(outputStream);
                        a(inputStream);
                        if (httpURLConnection != null) {
                        }
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (TextUtils.isEmpty(sb) ? "" : sb.toString()));
                        switch (i) {
                            case 200:
                            case 301:
                            case 302:
                                break;
                        }
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                i = httpURLConnection.getResponseCode();
                try {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[2048];
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                sb2.append(new String(bArr, 0, read, "utf-8"));
                            } catch (Exception e3) {
                                e = e3;
                                sb = sb2;
                                e.printStackTrace();
                                com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                                if (e instanceof SSLHandshakeException) {
                                }
                                com.cmic.sso.sdk.d.a.pmH.add(e);
                                if (!(e instanceof EOFException)) {
                                }
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
                            } catch (Throwable th4) {
                                th = th4;
                                sb = sb2;
                                a(outputStream);
                                a(inputStream);
                                if (httpURLConnection != null) {
                                }
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (TextUtils.isEmpty(sb) ? "" : sb.toString()));
                                switch (i) {
                                    case 200:
                                    case 301:
                                    case 302:
                                        break;
                                }
                                throw th;
                            }
                        }
                        com.cmic.sso.sdk.c.d.b bVar = new com.cmic.sso.sdk.c.d.b(i, httpURLConnection.getHeaderFields(), sb2.toString());
                        a(outputStream);
                        a(inputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseResult: " + (TextUtils.isEmpty(sb2) ? "" : sb2.toString()));
                        switch (i) {
                            case 200:
                            case 301:
                            case 302:
                                cVar2.a(bVar);
                                return;
                            default:
                                cVar2.a(com.cmic.sso.sdk.c.d.a.Or(i));
                                return;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        sb = null;
                    } catch (Throwable th5) {
                        th = th5;
                        sb = null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    sb = null;
                    inputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    sb = null;
                    inputStream = null;
                }
            } catch (Exception e6) {
                e = e6;
                i = -1;
                sb = null;
                inputStream = null;
                outputStream = null;
            } catch (Throwable th7) {
                th = th7;
                i = -1;
                sb = null;
                inputStream = null;
                outputStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            i = -1;
            sb = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th8) {
            th = th8;
            i = -1;
            sb = null;
            inputStream = null;
            outputStream = null;
            httpURLConnection = null;
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
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new com.cmic.sso.sdk.c.e.a(a2).eoZ().getSocketFactory());
            }
        }
    }
}
