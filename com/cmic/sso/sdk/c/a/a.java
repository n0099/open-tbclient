package com.cmic.sso.sdk.c.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes7.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
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

    /* JADX WARN: Removed duplicated region for block: B:106:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0299  */
    @Override // com.cmic.sso.sdk.c.a.b
    @TargetApi(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.cmic.sso.sdk.c.c.c cVar, com.cmic.sso.sdk.c.d.c cVar2, com.cmic.sso.sdk.a aVar) {
        String str;
        InputStream inputStream;
        StringBuilder sb;
        Closeable closeable;
        int i;
        HttpURLConnection httpURLConnection;
        int i2;
        HttpURLConnection httpURLConnection2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048576, this, cVar, cVar2, aVar) != null) {
            return;
        }
        String str2 = "";
        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "请求地址: " + cVar.a());
        try {
            URL url = new URL(cVar.a());
            if (cVar.h() != null) {
                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "开始wifi下取号");
                httpURLConnection2 = (HttpURLConnection) cVar.h().openConnection(url);
            } else {
                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "使用当前网络环境发送请求");
                httpURLConnection2 = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection = httpURLConnection2;
            try {
                try {
                    Map<String, String> c = cVar.c();
                    if (c != null) {
                        for (String str3 : c.keySet()) {
                            httpURLConnection.addRequestProperty(str3, c.get(str3));
                        }
                    }
                    if ((httpURLConnection instanceof HttpsURLConnection) && Build.VERSION.SDK_INT < 20) {
                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "5.0以下启动tls 1.2");
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new com.cmic.sso.sdk.c.b(HttpsURLConnection.getDefaultSSLSocketFactory()));
                    }
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setDefaultUseCaches(false);
                    String e = cVar.e();
                    httpURLConnection.setRequestMethod(e);
                    httpURLConnection.setDoOutput(true);
                    if (cVar instanceof com.cmic.sso.sdk.c.c.b) {
                        httpURLConnection.connect();
                        try {
                            ((com.cmic.sso.sdk.c.c.b) cVar).a(aVar);
                        } catch (Exception e2) {
                            e = e2;
                            str = "";
                            inputStream = null;
                            sb = null;
                            closeable = null;
                            i = -1;
                            try {
                                e.printStackTrace();
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("请求失败: ");
                                sb2.append(cVar.a());
                                com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", sb2.toString());
                                aVar.a().a.add(e);
                                i2 = !(e instanceof EOFException) ? 200050 : 102102;
                                a(closeable);
                                a(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i2);
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("responseResult: ");
                                sb3.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb3.toString());
                                if (i2 == 200 && i2 != 301 && i2 != 302) {
                                    cVar2.a(com.cmic.sso.sdk.c.d.a.a(i2));
                                    return;
                                }
                                cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                            } catch (Throwable th) {
                                th = th;
                                a(closeable);
                                a(inputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                                StringBuilder sb4 = new StringBuilder();
                                sb4.append("responseResult: ");
                                sb4.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                                com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb4.toString());
                                if (i == 200 && i != 301 && i != 302) {
                                    cVar2.a(com.cmic.sso.sdk.c.d.a.a(i));
                                } else {
                                    cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                }
                                throw th;
                            }
                        }
                    }
                    if (e.endsWith("POST")) {
                        closeable = httpURLConnection.getOutputStream();
                        try {
                            closeable.write(cVar.d().getBytes(IMAudioTransRequest.CHARSET));
                            closeable.flush();
                        } catch (Exception e3) {
                            e = e3;
                            str = "";
                            inputStream = null;
                            sb = null;
                            i = -1;
                            e.printStackTrace();
                            StringBuilder sb22 = new StringBuilder();
                            sb22.append("请求失败: ");
                            sb22.append(cVar.a());
                            com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", sb22.toString());
                            aVar.a().a.add(e);
                            if (!(e instanceof EOFException)) {
                            }
                            a(closeable);
                            a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i2);
                            StringBuilder sb32 = new StringBuilder();
                            sb32.append("responseResult: ");
                            sb32.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb32.toString());
                            if (i2 == 200) {
                            }
                            cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                        } catch (Throwable th2) {
                            th = th2;
                            str = "";
                            inputStream = null;
                            sb = null;
                            i = -1;
                            a(closeable);
                            a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                            StringBuilder sb42 = new StringBuilder();
                            sb42.append("responseResult: ");
                            sb42.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb42.toString());
                            if (i == 200) {
                            }
                            cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                            throw th;
                        }
                    } else {
                        closeable = null;
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
                                        sb.append(new String(bArr, 0, read, IMAudioTransRequest.CHARSET));
                                        str2 = str;
                                    } catch (Exception e4) {
                                        e = e4;
                                        i = responseCode;
                                        e.printStackTrace();
                                        StringBuilder sb222 = new StringBuilder();
                                        sb222.append("请求失败: ");
                                        sb222.append(cVar.a());
                                        com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", sb222.toString());
                                        aVar.a().a.add(e);
                                        if (!(e instanceof EOFException)) {
                                        }
                                        a(closeable);
                                        a(inputStream);
                                        if (httpURLConnection != null) {
                                        }
                                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i2);
                                        StringBuilder sb322 = new StringBuilder();
                                        sb322.append("responseResult: ");
                                        sb322.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb322.toString());
                                        if (i2 == 200) {
                                        }
                                        cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                                    } catch (Throwable th3) {
                                        th = th3;
                                        i = responseCode;
                                        a(closeable);
                                        a(inputStream);
                                        if (httpURLConnection != null) {
                                        }
                                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                                        StringBuilder sb422 = new StringBuilder();
                                        sb422.append("responseResult: ");
                                        sb422.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                                        com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb422.toString());
                                        if (i == 200) {
                                        }
                                        cVar2.a((com.cmic.sso.sdk.c.d.b) null);
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
                            com.cmic.sso.sdk.c.d.b bVar = new com.cmic.sso.sdk.c.d.b(responseCode, httpURLConnection.getHeaderFields(), sb.toString());
                            a(closeable);
                            a(inputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + responseCode);
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("responseResult: ");
                            sb5.append(TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb5.toString());
                            if (responseCode != 200 && responseCode != 301 && responseCode != 302) {
                                cVar2.a(com.cmic.sso.sdk.c.d.a.a(responseCode));
                            } else {
                                cVar2.a(bVar);
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = "";
                            i = responseCode;
                            sb = null;
                            e.printStackTrace();
                            StringBuilder sb2222 = new StringBuilder();
                            sb2222.append("请求失败: ");
                            sb2222.append(cVar.a());
                            com.cmic.sso.sdk.e.c.a("ConnectionInterceptor", sb2222.toString());
                            aVar.a().a.add(e);
                            if (!(e instanceof EOFException)) {
                            }
                            a(closeable);
                            a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i2);
                            StringBuilder sb3222 = new StringBuilder();
                            sb3222.append("responseResult: ");
                            sb3222.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb3222.toString());
                            if (i2 == 200) {
                            }
                            cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                        } catch (Throwable th5) {
                            th = th5;
                            str = "";
                            i = responseCode;
                            sb = null;
                            a(closeable);
                            a(inputStream);
                            if (httpURLConnection != null) {
                            }
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", "responseCode: " + i);
                            StringBuilder sb4222 = new StringBuilder();
                            sb4222.append("responseResult: ");
                            sb4222.append(!TextUtils.isEmpty(sb) ? str : sb.toString());
                            com.cmic.sso.sdk.e.c.b("ConnectionInterceptor", sb4222.toString());
                            if (i == 200) {
                            }
                            cVar2.a((com.cmic.sso.sdk.c.d.b) null);
                            throw th;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str = "";
                        i = responseCode;
                        inputStream = null;
                    } catch (Throwable th6) {
                        th = th6;
                        str = "";
                        i = responseCode;
                        inputStream = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                }
            } catch (Throwable th7) {
                th = th7;
                str = "";
                inputStream = null;
                sb = null;
                closeable = null;
            }
        } catch (Exception e9) {
            e = e9;
            str = "";
            inputStream = null;
            sb = null;
            closeable = null;
            i = -1;
            httpURLConnection = null;
        } catch (Throwable th8) {
            th = th8;
            str = "";
            inputStream = null;
            sb = null;
            closeable = null;
            i = -1;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
