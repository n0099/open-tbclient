package d.b.c.e.j.a.j;

import d.b.c.e.p.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f42549b;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, d.b.c.e.j.a.j.a> f42550a = new HashMap<>();

    /* loaded from: classes.dex */
    public class a implements HostnameVerifier {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f42551a;

        public a(b bVar, c cVar) {
            this.f42551a = cVar;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify("httpsdns.baidu.com", sSLSession);
            if (!verify) {
                this.f42551a.e(true);
            }
            return verify;
        }
    }

    public static b a() {
        if (f42549b == null) {
            synchronized (b.class) {
                if (f42549b == null) {
                    f42549b = new b();
                }
            }
        }
        return f42549b;
    }

    public c b(String str) {
        c cVar = new c();
        d.b.c.e.j.a.j.a aVar = this.f42550a.get(str);
        if (aVar != null && !aVar.c(System.currentTimeMillis()) && aVar.a() != null && aVar.a().size() > 0) {
            cVar.g(aVar.a().get(0));
        }
        return cVar;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x00df */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:61:0x0121 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106 A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:20:0x00ad, B:22:0x00b3, B:23:0x00b7, B:48:0x00f7, B:50:0x0106, B:51:0x0109), top: B:75:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0113 A[Catch: Exception -> 0x0120, TryCatch #8 {Exception -> 0x0120, blocks: (B:53:0x010e, B:55:0x0113, B:57:0x0118, B:59:0x011d), top: B:78:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0118 A[Catch: Exception -> 0x0120, TryCatch #8 {Exception -> 0x0120, blocks: (B:53:0x010e, B:55:0x0113, B:57:0x0118, B:59:0x011d), top: B:78:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011d A[Catch: Exception -> 0x0120, TRY_LEAVE, TryCatch #8 {Exception -> 0x0120, blocks: (B:53:0x010e, B:55:0x0113, B:57:0x0118, B:59:0x011d), top: B:78:0x010e }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012a A[Catch: Exception -> 0x0137, TryCatch #5 {Exception -> 0x0137, blocks: (B:64:0x0125, B:66:0x012a, B:68:0x012f, B:70:0x0134), top: B:76:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012f A[Catch: Exception -> 0x0137, TryCatch #5 {Exception -> 0x0137, blocks: (B:64:0x0125, B:66:0x012a, B:68:0x012f, B:70:0x0134), top: B:76:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0134 A[Catch: Exception -> 0x0137, TRY_LEAVE, TryCatch #5 {Exception -> 0x0137, blocks: (B:64:0x0125, B:66:0x012a, B:68:0x012f, B:70:0x0134), top: B:76:0x0125 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final d.b.c.e.j.a.j.a c(String str, c cVar) {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        InputStream inputStream2;
        InputStream inputStream3;
        ?? r5;
        HttpURLConnection httpURLConnection3;
        InputStream inputStream4;
        InputStreamReader inputStreamReader = null;
        if (k.isEmpty(str)) {
            return null;
        }
        cVar.i(true);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                if (cVar.c()) {
                    HttpURLConnection httpURLConnection4 = (HttpURLConnection) new URL("http://180.76.76.112/v2/0011/?dn=" + ((String) str)).openConnection();
                    try {
                        httpURLConnection4.setDoOutput(true);
                        httpURLConnection4.setDoInput(true);
                        httpURLConnection4.setUseCaches(false);
                        httpURLConnection4.setConnectTimeout(5000);
                        httpURLConnection4.setReadTimeout(10000);
                        httpURLConnection4.setRequestMethod("GET");
                        httpURLConnection4.connect();
                        inputStream3 = httpURLConnection4.getInputStream();
                        str = httpURLConnection4;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = null;
                        httpURLConnection2 = httpURLConnection4;
                        inputStream2 = inputStream;
                        inputStream3 = inputStream;
                        str = httpURLConnection2;
                        r5 = inputStream2;
                        cVar.h(e.getClass().getName());
                        if (e instanceof SSLException) {
                        }
                        e.printStackTrace();
                        if (inputStream2 != null) {
                        }
                        if (inputStream3 != null) {
                        }
                        if (r5 != 0) {
                        }
                        if (str != 0) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                        httpURLConnection = httpURLConnection4;
                        bufferedReader2 = bufferedReader;
                        inputStream4 = bufferedReader;
                        httpURLConnection3 = httpURLConnection;
                        if (inputStreamReader != null) {
                        }
                        if (inputStream4 != 0) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        if (httpURLConnection3 != null) {
                        }
                        throw th;
                    }
                } else {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://180.76.76.112/v2/0011/?dn=" + ((String) str)).openConnection();
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(10000);
                    httpsURLConnection.setRequestProperty("Host", "httpsdns.baidu.com");
                    httpsURLConnection.setHostnameVerifier(new a(this, cVar));
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.connect();
                    inputStream3 = httpsURLConnection.getInputStream();
                    str = 0;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                inputStream2 = new InputStreamReader(inputStream3, "utf-8");
                try {
                    r5 = new BufferedReader(inputStream2);
                    while (true) {
                        try {
                            String readLine = r5.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Exception e3) {
                            e = e3;
                            cVar.h(e.getClass().getName());
                            if (e instanceof SSLException) {
                                cVar.e(true);
                            }
                            e.printStackTrace();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception unused) {
                                    return null;
                                }
                            }
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            if (r5 != 0) {
                                r5.close();
                            }
                            if (str != 0) {
                                str.disconnect();
                            }
                            return null;
                        }
                    }
                    d.b.c.e.j.a.j.a aVar = new d.b.c.e.j.a.j.a();
                    aVar.e(System.currentTimeMillis());
                    cVar.d();
                    d.b.c.e.j.a.j.a b2 = aVar.b(stringBuffer.toString());
                    try {
                        inputStream2.close();
                        if (inputStream3 != null) {
                            inputStream3.close();
                        }
                        r5.close();
                        if (str != 0) {
                            str.disconnect();
                        }
                    } catch (Exception unused2) {
                    }
                    return b2;
                } catch (Exception e4) {
                    e = e4;
                    r5 = 0;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader2 = null;
                    inputStreamReader = inputStream2;
                    inputStream4 = inputStream3;
                    httpURLConnection3 = str;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception unused3) {
                            throw th;
                        }
                    }
                    if (inputStream4 != 0) {
                        inputStream4.close();
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e = e5;
                inputStream2 = null;
                inputStream3 = inputStream3;
                str = str;
                r5 = inputStream2;
                cVar.h(e.getClass().getName());
                if (e instanceof SSLException) {
                }
                e.printStackTrace();
                if (inputStream2 != null) {
                }
                if (inputStream3 != null) {
                }
                if (r5 != 0) {
                }
                if (str != 0) {
                }
                return null;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = null;
                inputStream4 = inputStream3;
                httpURLConnection3 = str;
                if (inputStreamReader != null) {
                }
                if (inputStream4 != 0) {
                }
                if (bufferedReader2 != null) {
                }
                if (httpURLConnection3 != null) {
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            httpURLConnection2 = null;
            inputStream = null;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedReader = null;
        }
    }

    public c d(String str, String str2) {
        c cVar = new c();
        if (k.isEmpty(str)) {
            return cVar;
        }
        d.b.c.e.j.a.j.a aVar = this.f42550a.get(str);
        if (aVar != null && !aVar.c(System.currentTimeMillis()) && aVar.a() != null && aVar.a().size() > 0) {
            for (int i = 0; i < aVar.a().size(); i++) {
                if (!k.isEquals(str2, aVar.a().get(i))) {
                    cVar.j(i);
                    cVar.g(aVar.a().get(i));
                    return cVar;
                } else if (i == aVar.a().size() - 1) {
                    cVar.j(0);
                    cVar.g(aVar.a().get(0));
                    return cVar;
                }
            }
        }
        for (int i2 = 0; i2 < 3; i2++) {
            cVar.d();
            cVar.l(i2);
            long currentTimeMillis = System.currentTimeMillis();
            d.b.c.e.j.a.j.a c2 = c(str, cVar);
            cVar.f(System.currentTimeMillis() - currentTimeMillis);
            if (c2 != null && c2.a() != null && c2.a().size() > 0) {
                c2.d(300L);
                this.f42550a.put(str, c2);
                for (int i3 = 0; i3 < c2.a().size(); i3++) {
                    if (!k.isEquals(str2, c2.a().get(i2))) {
                        cVar.j(i3);
                        cVar.g(c2.a().get(i3));
                        return cVar;
                    } else if (i3 == c2.a().size() - 1) {
                        cVar.j(0);
                        cVar.g(c2.a().get(0));
                        return cVar;
                    }
                }
                continue;
            } else {
                d.b.c.e.j.a.j.a aVar2 = this.f42550a.get(str);
                if (aVar2 != null && aVar2.a() != null && aVar2.a().size() > 0) {
                    cVar.g(aVar2.a().get(0));
                    return cVar;
                }
            }
        }
        return cVar;
    }
}
