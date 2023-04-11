package com.cmic.sso.sdk.c.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.c.b.e;
import com.cmic.sso.sdk.c.b.g;
import com.cmic.sso.sdk.c.b.h;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes7.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public static com.cmic.sso.sdk.c.b a;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return com.cmic.sso.sdk.b.a[0] + "." + com.cmic.sso.sdk.b.a[2] + "." + com.cmic.sso.sdk.b.a[4] + "." + com.cmic.sso.sdk.b.a[6];
        }
        return (String) invokeV.objValue;
    }

    private void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized SSLSocketFactory a(g gVar, com.cmic.sso.sdk.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, gVar, aVar)) == null) {
            synchronized (this) {
                if (gVar instanceof e) {
                    com.cmic.sso.sdk.c.b bVar = new com.cmic.sso.sdk.c.b(HttpsURLConnection.getDefaultSSLSocketFactory(), aVar);
                    if (a == null) {
                        a = bVar;
                    }
                    return bVar;
                }
                if (a == null) {
                    a = new com.cmic.sso.sdk.c.b(HttpsURLConnection.getDefaultSSLSocketFactory(), aVar);
                }
                return a;
            }
        }
        return (SSLSocketFactory) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:148:0x0083 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:150:0x00cc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:66:0x01ce */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x01d9 */
    /* JADX WARN: Can't wrap try/catch for region: R(35:1|(2:145|(1:147))|3|(2:4|5)|(2:137|(29:139|10|(1:12)(1:136)|13|14|(3:16|(5:19|20|21|22|17)|74)|76|(1:(1:83)(1:84))|85|(1:87)|88|89|(3:91|93|94)(1:131)|95|96|97|98|99|100|(2:101|(1:103)(1:104))|105|106|(1:108)|109|(1:111)(1:120)|112|(2:118|119)|48|49))|9|10|(0)(0)|13|14|(0)|76|(2:78|(0)(0))|85|(0)|88|89|(0)(0)|95|96|97|98|99|100|(3:101|(0)(0)|103)|105|106|(0)|109|(0)(0)|112|(1:114)|118|119|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(36:1|(2:145|(1:147))|3|4|5|(2:137|(29:139|10|(1:12)(1:136)|13|14|(3:16|(5:19|20|21|22|17)|74)|76|(1:(1:83)(1:84))|85|(1:87)|88|89|(3:91|93|94)(1:131)|95|96|97|98|99|100|(2:101|(1:103)(1:104))|105|106|(1:108)|109|(1:111)(1:120)|112|(2:118|119)|48|49))|9|10|(0)(0)|13|14|(0)|76|(2:78|(0)(0))|85|(0)|88|89|(0)(0)|95|96|97|98|99|100|(3:101|(0)(0)|103)|105|106|(0)|109|(0)(0)|112|(1:114)|118|119|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0253, code lost:
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0276, code lost:
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0279, code lost:
        r6 = r10.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x02a9, code lost:
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02cc, code lost:
        r6 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02cf, code lost:
        r6 = r10.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02e9, code lost:
        r22.a(com.cmic.sso.sdk.c.d.a.a(r15));
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ce, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01d0, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01d1, code lost:
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01d4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01d5, code lost:
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01df, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e0, code lost:
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e4, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01e5, code lost:
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0221, code lost:
        r15 = 200050;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0228, code lost:
        r15 = 102102;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0172 A[EDGE_INSN: B:151:0x0172->B:50:0x0172 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068 A[Catch: all -> 0x01e9, Exception -> 0x01f2, TryCatch #9 {Exception -> 0x01f2, all -> 0x01e9, blocks: (B:5:0x0033, B:7:0x0048, B:13:0x0062, B:15:0x0068, B:16:0x0078, B:9:0x004c, B:11:0x0056), top: B:139:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: all -> 0x01e9, Exception -> 0x01f2, TRY_LEAVE, TryCatch #9 {Exception -> 0x01f2, all -> 0x01e9, blocks: (B:5:0x0033, B:7:0x0048, B:13:0x0062, B:15:0x0068, B:16:0x0078, B:9:0x004c, B:11:0x0056), top: B:139:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a2 A[Catch: all -> 0x01df, Exception -> 0x01e4, TryCatch #8 {Exception -> 0x01e4, all -> 0x01df, blocks: (B:17:0x0083, B:19:0x00a2, B:20:0x00aa, B:22:0x00b0), top: B:148:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc A[Catch: all -> 0x01db, Exception -> 0x01dd, TryCatch #11 {Exception -> 0x01dd, all -> 0x01db, blocks: (B:24:0x00b6, B:25:0x00cc, B:27:0x00d2, B:29:0x00d6, B:32:0x00dc, B:33:0x00ff, B:34:0x0109, B:36:0x012b, B:37:0x0134, B:40:0x013e), top: B:144:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ff A[Catch: all -> 0x01db, Exception -> 0x01dd, TryCatch #11 {Exception -> 0x01dd, all -> 0x01db, blocks: (B:24:0x00b6, B:25:0x00cc, B:27:0x00d2, B:29:0x00d6, B:32:0x00dc, B:33:0x00ff, B:34:0x0109, B:36:0x012b, B:37:0x0134, B:40:0x013e), top: B:144:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x012b A[Catch: all -> 0x01db, Exception -> 0x01dd, TryCatch #11 {Exception -> 0x01dd, all -> 0x01db, blocks: (B:24:0x00b6, B:25:0x00cc, B:27:0x00d2, B:29:0x00d6, B:32:0x00dc, B:33:0x00ff, B:34:0x0109, B:36:0x012b, B:37:0x0134, B:40:0x013e), top: B:144:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013e A[Catch: all -> 0x01db, Exception -> 0x01dd, TRY_ENTER, TRY_LEAVE, TryCatch #11 {Exception -> 0x01dd, all -> 0x01db, blocks: (B:24:0x00b6, B:25:0x00cc, B:27:0x00d2, B:29:0x00d6, B:32:0x00dc, B:33:0x00ff, B:34:0x0109, B:36:0x012b, B:37:0x0134, B:40:0x013e), top: B:144:0x00b6 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0164 A[Catch: Exception -> 0x01ce, all -> 0x02a0, LOOP:1: B:47:0x015e->B:49:0x0164, LOOP_END, TryCatch #1 {all -> 0x02a0, blocks: (B:92:0x01f9, B:96:0x022e, B:98:0x0232, B:100:0x023a, B:102:0x0242, B:46:0x015c, B:47:0x015e, B:49:0x0164, B:50:0x0172), top: B:139:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0232 A[Catch: all -> 0x02a0, TryCatch #1 {all -> 0x02a0, blocks: (B:92:0x01f9, B:96:0x022e, B:98:0x0232, B:100:0x023a, B:102:0x0242, B:46:0x015c, B:47:0x015e, B:49:0x0164, B:50:0x0172), top: B:139:0x0033 }] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.cmic.sso.sdk.c.a.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v26, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.cmic.sso.sdk.c.a.b
    @TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        String str;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        int i;
        String str2;
        InputStream inputStream;
        String sb;
        String a2;
        URL url;
        String host;
        g k;
        boolean z;
        Map<String, String> c;
        String e;
        byte[] bArr;
        int read;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            str = interceptable;
            if (str.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, aVar) != null) {
                return;
            }
        }
        ?? r6 = "";
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "请求地址: " + cVar.a());
        StringBuilder sb2 = new StringBuilder();
        try {
            try {
                a2 = cVar.a();
                url = new URL(a2);
                host = url.getHost();
                k = cVar.k();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
            outputStream = null;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            str = "";
            outputStream = null;
            httpURLConnection = null;
        }
        if ((k instanceof h) || (k instanceof e)) {
            String b = aVar.b("remote_ip");
            if (!TextUtils.isEmpty(b)) {
                url = new URL(a2.replaceFirst(host, b));
                z = true;
                if (cVar.h() == null) {
                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "开始wifi下取号");
                    httpURLConnection = (HttpURLConnection) cVar.h().openConnection(url);
                } else {
                    com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "使用当前网络环境发送请求");
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                }
                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "host = " + host);
                httpURLConnection.setRequestProperty("Host", host);
                c = cVar.c();
                if (c != null) {
                    r6 = r6;
                    for (String str4 : c.keySet()) {
                        str = r6;
                        try {
                            httpURLConnection.addRequestProperty(str4, c.get(str4));
                            r6 = str;
                            c = c;
                        } catch (Exception e3) {
                            e = e3;
                            outputStream = null;
                            inputStream = null;
                            e.printStackTrace();
                            com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                            aVar.a().a.add(e);
                            if (e instanceof EOFException) {
                            }
                            if (e instanceof UnknownHostException) {
                                aVar.a("remote_ip", a());
                            }
                            a(outputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("responseResult: ");
                            if (TextUtils.isEmpty(sb2)) {
                            }
                            sb3.append(sb);
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb3.toString());
                            if (i != 200) {
                            }
                            cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            outputStream = null;
                            Closeable closeable = null;
                            i = -1;
                            a(outputStream);
                            a(closeable);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                            ?? sb4 = new StringBuilder();
                            sb4.append("responseResult: ");
                            if (TextUtils.isEmpty(sb2)) {
                            }
                            sb4.append(str2);
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb4.toString());
                            if (i != 200) {
                            }
                            cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                            throw th;
                        }
                    }
                }
                str = r6;
                if ((httpURLConnection instanceof HttpsURLConnection) && ((k instanceof h) || (k instanceof e))) {
                    if (!z) {
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "need sni handle");
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new com.cmic.sso.sdk.c.c((HttpsURLConnection) httpURLConnection, cVar.h(), aVar));
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new HostnameVerifier(this, host) { // from class: com.cmic.sso.sdk.c.a.a.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ String a;
                            public final /* synthetic */ a b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, host};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.b = this;
                                this.a = host;
                            }

                            @Override // javax.net.ssl.HostnameVerifier
                            public boolean verify(String str5, SSLSession sSLSession) {
                                InterceptResult invokeLL;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, str5, sSLSession)) == null) {
                                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, sSLSession);
                                }
                                return invokeLL.booleanValue;
                            }
                        });
                    } else {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a(k, aVar));
                    }
                }
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setDefaultUseCaches(false);
                e = cVar.e();
                httpURLConnection.setRequestMethod(e);
                httpURLConnection.setDoOutput(true);
                if (cVar instanceof com.cmic.sso.sdk.c.c.b) {
                    httpURLConnection.connect();
                    ((com.cmic.sso.sdk.c.c.b) cVar).a(aVar);
                }
                if (!e.endsWith("POST")) {
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(cVar.d().getBytes(IMAudioTransRequest.CHARSET));
                        outputStream.flush();
                    } catch (Exception e4) {
                        e = e4;
                        inputStream = null;
                        e.printStackTrace();
                        com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", "请求失败: " + cVar.a());
                        aVar.a().a.add(e);
                        if (e instanceof EOFException) {
                        }
                        if (e instanceof UnknownHostException) {
                        }
                        a(outputStream);
                        a(inputStream);
                        if (httpURLConnection != null) {
                        }
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                        StringBuilder sb32 = new StringBuilder();
                        sb32.append("responseResult: ");
                        if (TextUtils.isEmpty(sb2)) {
                        }
                        sb32.append(sb);
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb32.toString());
                        if (i != 200) {
                        }
                        cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        Closeable closeable2 = null;
                        i = -1;
                        a(outputStream);
                        a(closeable2);
                        if (httpURLConnection != null) {
                        }
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                        ?? sb42 = new StringBuilder();
                        sb42.append("responseResult: ");
                        if (TextUtils.isEmpty(sb2)) {
                        }
                        sb42.append(str2);
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb42.toString());
                        if (i != 200) {
                        }
                        cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                i = httpURLConnection.getResponseCode();
                inputStream = httpURLConnection.getInputStream();
                bArr = new byte[2048];
                while (true) {
                    read = inputStream.read(bArr);
                    if (read > 0) {
                        break;
                    }
                    sb2.append(new String(bArr, 0, read, IMAudioTransRequest.CHARSET));
                }
                com.cmic.sso.sdk.c.d.b bVar = new com.cmic.sso.sdk.c.d.b(i, httpURLConnection.getHeaderFields(), sb2.toString());
                a(outputStream);
                a(inputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                ?? sb5 = new StringBuilder();
                sb5.append("responseResult: ");
                if (!TextUtils.isEmpty(sb2)) {
                    str3 = str;
                } else {
                    str3 = sb2.toString();
                }
                sb5.append(str3);
                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb5.toString());
                if (i != 200 || i == 301 || i == 302) {
                    cVar2.a(bVar);
                }
                cVar2.a(com.cmic.sso.sdk.c.d.a.a(i));
                return;
            }
        }
        z = false;
        if (cVar.h() == null) {
        }
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "host = " + host);
        httpURLConnection.setRequestProperty("Host", host);
        c = cVar.c();
        if (c != null) {
        }
        str = r6;
        if (httpURLConnection instanceof HttpsURLConnection) {
            if (!z) {
            }
        }
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDefaultUseCaches(false);
        e = cVar.e();
        httpURLConnection.setRequestMethod(e);
        httpURLConnection.setDoOutput(true);
        if (cVar instanceof com.cmic.sso.sdk.c.c.b) {
        }
        if (!e.endsWith("POST")) {
        }
        i = httpURLConnection.getResponseCode();
        inputStream = httpURLConnection.getInputStream();
        bArr = new byte[2048];
        while (true) {
            read = inputStream.read(bArr);
            if (read > 0) {
            }
            sb2.append(new String(bArr, 0, read, IMAudioTransRequest.CHARSET));
        }
        com.cmic.sso.sdk.c.d.b bVar2 = new com.cmic.sso.sdk.c.d.b(i, httpURLConnection.getHeaderFields(), sb2.toString());
        a(outputStream);
        a(inputStream);
        if (httpURLConnection != null) {
        }
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
        ?? sb52 = new StringBuilder();
        sb52.append("responseResult: ");
        if (!TextUtils.isEmpty(sb2)) {
        }
        sb52.append(str3);
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb52.toString());
        if (i != 200) {
        }
        cVar2.a(bVar2);
    }
}
