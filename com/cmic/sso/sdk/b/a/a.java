package com.cmic.sso.sdk.b.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.cmic.sso.sdk.d.q;
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
/* loaded from: classes9.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e7  */
    @Override // com.cmic.sso.sdk.b.a.b
    @TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.b.c.c cVar, com.cmic.sso.sdk.b.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        String str;
        InputStream inputStream;
        StringBuilder sb;
        OutputStream outputStream;
        int i2;
        HttpURLConnection httpURLConnection;
        int i3;
        HttpURLConnection httpURLConnection2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048576, this, cVar, cVar2, aVar) != null) {
            return;
        }
        String str2 = "";
        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "请求地址: " + cVar.a());
        try {
            URL url = new URL(cVar.a());
            if (cVar.h() != null) {
                com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "开始wifi下取号");
                httpURLConnection2 = (HttpURLConnection) cVar.h().openConnection(url);
            } else {
                com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "使用当前网络环境发送请求");
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection = httpURLConnection2;
            try {
                Map<String, String> c2 = cVar.c();
                if (c2 != null) {
                    for (String str3 : c2.keySet()) {
                        httpURLConnection.addRequestProperty(str3, c2.get(str3));
                    }
                }
                a(httpURLConnection, aVar, cVar.a());
                httpURLConnection.setDoInput(true);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setDefaultUseCaches(false);
                String e2 = cVar.e();
                httpURLConnection.setRequestMethod(e2);
                httpURLConnection.setDoOutput(true);
                if (cVar instanceof com.cmic.sso.sdk.b.c.b) {
                    httpURLConnection.connect();
                    ((com.cmic.sso.sdk.b.c.b) cVar).a(aVar);
                }
                if (e2.endsWith("POST")) {
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(cVar.d().getBytes("utf-8"));
                        outputStream.flush();
                    } catch (Exception e3) {
                        e = e3;
                        str = "";
                        inputStream = null;
                        sb = null;
                        i2 = -1;
                        try {
                            e.printStackTrace();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("请求失败: ");
                            sb2.append(cVar.a());
                            com.cmic.sso.sdk.d.c.a("ConnectionInterceptor", sb2.toString());
                            if (e instanceof SSLHandshakeException) {
                            }
                            aVar.a().f69515a.add(e);
                            if (e instanceof EOFException) {
                            }
                            a(outputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + i3);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("responseResult: ");
                            sb3.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb3.toString());
                            if (i3 == 200) {
                            }
                            cVar2.a((com.cmic.sso.sdk.b.d.b) null);
                        } catch (Throwable th) {
                            th = th;
                            a(outputStream);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + i2);
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("responseResult: ");
                            sb4.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb4.toString());
                            if (i2 == 200 && i2 != 301 && i2 != 302) {
                                cVar2.a(com.cmic.sso.sdk.b.d.a.a(i2));
                            } else {
                                cVar2.a((com.cmic.sso.sdk.b.d.b) null);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str = "";
                        inputStream = null;
                        sb = null;
                        i2 = -1;
                        a(outputStream);
                        a(inputStream);
                        if (httpURLConnection != null) {
                        }
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + i2);
                        StringBuilder sb42 = new StringBuilder();
                        sb42.append("responseResult: ");
                        sb42.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb42.toString());
                        if (i2 == 200) {
                        }
                        cVar2.a((com.cmic.sso.sdk.b.d.b) null);
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                int responseCode = httpURLConnection.getResponseCode();
                try {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr = new byte[2048];
                        sb = new StringBuilder();
                        while (true) {
                            try {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                str = str2;
                                try {
                                    sb.append(new String(bArr, 0, read, "utf-8"));
                                    str2 = str;
                                } catch (Exception e4) {
                                    e = e4;
                                    i2 = responseCode;
                                    e.printStackTrace();
                                    StringBuilder sb22 = new StringBuilder();
                                    sb22.append("请求失败: ");
                                    sb22.append(cVar.a());
                                    com.cmic.sso.sdk.d.c.a("ConnectionInterceptor", sb22.toString());
                                    if (e instanceof SSLHandshakeException) {
                                    }
                                    aVar.a().f69515a.add(e);
                                    if (e instanceof EOFException) {
                                    }
                                    a(outputStream);
                                    a(inputStream);
                                    if (httpURLConnection != null) {
                                    }
                                    com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + i3);
                                    StringBuilder sb32 = new StringBuilder();
                                    sb32.append("responseResult: ");
                                    sb32.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                                    com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb32.toString());
                                    if (i3 == 200) {
                                    }
                                    cVar2.a((com.cmic.sso.sdk.b.d.b) null);
                                } catch (Throwable th3) {
                                    th = th3;
                                    i2 = responseCode;
                                    a(outputStream);
                                    a(inputStream);
                                    if (httpURLConnection != null) {
                                    }
                                    com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + i2);
                                    StringBuilder sb422 = new StringBuilder();
                                    sb422.append("responseResult: ");
                                    sb422.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                                    com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb422.toString());
                                    if (i2 == 200) {
                                    }
                                    cVar2.a((com.cmic.sso.sdk.b.d.b) null);
                                    throw th;
                                }
                            } catch (Exception e5) {
                                e = e5;
                                str = str2;
                            } catch (Throwable th4) {
                                th = th4;
                                str = str2;
                            }
                        }
                        str = str2;
                        com.cmic.sso.sdk.b.d.b bVar = new com.cmic.sso.sdk.b.d.b(responseCode, httpURLConnection.getHeaderFields(), sb.toString());
                        a(outputStream);
                        a(inputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("responseResult: ");
                        sb5.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb5.toString());
                        if (responseCode != 200 && responseCode != 301 && responseCode != 302) {
                            cVar2.a(com.cmic.sso.sdk.b.d.a.a(responseCode));
                        } else {
                            cVar2.a(bVar);
                        }
                    } catch (Exception e6) {
                        e = e6;
                        str = "";
                        i2 = responseCode;
                        sb = null;
                        e.printStackTrace();
                        StringBuilder sb222 = new StringBuilder();
                        sb222.append("请求失败: ");
                        sb222.append(cVar.a());
                        com.cmic.sso.sdk.d.c.a("ConnectionInterceptor", sb222.toString());
                        if (e instanceof SSLHandshakeException) {
                            aVar.a("isNeedToGetCert", true);
                        }
                        aVar.a().f69515a.add(e);
                        i3 = e instanceof EOFException ? 200050 : 102102;
                        a(outputStream);
                        a(inputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + i3);
                        StringBuilder sb322 = new StringBuilder();
                        sb322.append("responseResult: ");
                        sb322.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb322.toString());
                        if (i3 == 200 && i3 != 301 && i3 != 302) {
                            cVar2.a(com.cmic.sso.sdk.b.d.a.a(i3));
                        } else {
                            cVar2.a((com.cmic.sso.sdk.b.d.b) null);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        str = "";
                        i2 = responseCode;
                        sb = null;
                        a(outputStream);
                        a(inputStream);
                        if (httpURLConnection != null) {
                        }
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "responseCode: " + i2);
                        StringBuilder sb4222 = new StringBuilder();
                        sb4222.append("responseResult: ");
                        sb4222.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", sb4222.toString());
                        if (i2 == 200) {
                        }
                        cVar2.a((com.cmic.sso.sdk.b.d.b) null);
                        throw th;
                    }
                } catch (Exception e7) {
                    e = e7;
                    str = "";
                    i2 = responseCode;
                    inputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    str = "";
                    i2 = responseCode;
                    inputStream = null;
                }
            } catch (Exception e8) {
                e = e8;
                str = "";
                inputStream = null;
                sb = null;
                outputStream = null;
            } catch (Throwable th7) {
                th = th7;
                str = "";
                inputStream = null;
                sb = null;
                outputStream = null;
            }
        } catch (Exception e9) {
            e = e9;
            str = "";
            inputStream = null;
            sb = null;
            outputStream = null;
            i2 = -1;
            httpURLConnection = null;
        } catch (Throwable th8) {
            th = th8;
            str = "";
            inputStream = null;
            sb = null;
            outputStream = null;
            i2 = -1;
            httpURLConnection = null;
        }
    }

    private void a(Closeable closeable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, this, closeable) == null) || closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void a(HttpURLConnection httpURLConnection, com.cmic.sso.sdk.a aVar, String str) {
        String a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, this, httpURLConnection, aVar, str) == null) || !(httpURLConnection instanceof HttpsURLConnection) || aVar.b("CLOSE_CERT_VERIFY", true) || str.contains("https://config2.cmpassport.com/client/uniConfig")) {
            return;
        }
        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "开启证书校验");
        if (str.contains(TbConfig.TMP_LOG_DIR_NAME)) {
            a2 = q.a(q.h());
        } else {
            a2 = q.a(q.f());
        }
        com.cmic.sso.sdk.d.c.b("ConnectionInterceptor", "cer: " + a2);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new com.cmic.sso.sdk.b.e.a(a2).a().getSocketFactory());
    }
}
