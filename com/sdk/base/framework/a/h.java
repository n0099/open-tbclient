package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class h<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "h";
    public static boolean b;
    public static String c;
    public static final HostnameVerifier f;
    public transient /* synthetic */ FieldHolder $fh;
    public Context d;
    public k<T> e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1040379391, "Lcom/sdk/base/framework/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1040379391, "Lcom/sdk/base/framework/a/h;");
                return;
            }
        }
        b = com.sdk.base.framework.c.f.b;
        c = UUID.randomUUID().toString();
        f = new i();
    }

    public h(Context context, k<T> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = context;
        this.e = kVar;
    }

    private ByteArrayOutputStream a(k<T> kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, kVar)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (kVar != null) {
                try {
                    String b2 = k.b(this.e.e());
                    if (kVar.d().contains("/dro/log/v1.0/log")) {
                        b2 = kVar.e().toString();
                    }
                    ArrayList<File> b3 = kVar.b();
                    if (b3 == null || b3.size() <= 0) {
                        byteArrayOutputStream.write(b2.getBytes(IMAudioTransRequest.CHARSET));
                    } else {
                        byteArrayOutputStream.write(("--" + c + "\r\n").getBytes(IMAudioTransRequest.CHARSET));
                        byteArrayOutputStream.write("Content-Disposition: form-data; name=\"params\"".getBytes(IMAudioTransRequest.CHARSET));
                        byteArrayOutputStream.write("\r\n\r\n".getBytes(IMAudioTransRequest.CHARSET));
                        byteArrayOutputStream.write(b2.getBytes(IMAudioTransRequest.CHARSET));
                        byteArrayOutputStream.write("\r\n".getBytes(IMAudioTransRequest.CHARSET));
                        for (int i = 0; i < b3.size(); i++) {
                            File file = b3.get(i);
                            if (file != null) {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                String name = file.getName();
                                byteArrayOutputStream.write(("--" + c + "\r\n").getBytes(IMAudioTransRequest.CHARSET));
                                StringBuilder sb = new StringBuilder("Content-Disposition: form-data; name=\"");
                                sb.append(name);
                                sb.append("\"; filename=\"");
                                sb.append(name);
                                sb.append("\"\r\n");
                                byteArrayOutputStream.write(sb.toString().getBytes(IMAudioTransRequest.CHARSET));
                                byteArrayOutputStream.write("Content-Type: application/octet-stream\r\n".getBytes(IMAudioTransRequest.CHARSET));
                                byteArrayOutputStream.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes(IMAudioTransRequest.CHARSET));
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                StringBuilder sb2 = new StringBuilder("\r\n--");
                                sb2.append(c);
                                sb2.append("--\r\n");
                                byteArrayOutputStream.write(sb2.toString().getBytes(IMAudioTransRequest.CHARSET));
                                byteArrayOutputStream.flush();
                                fileInputStream.close();
                            }
                        }
                    }
                } catch (Exception e) {
                    com.sdk.base.framework.f.f.a.b(e.toString());
                    com.sdk.base.framework.a.a.c.b(a, e.toString(), Boolean.valueOf(b));
                }
            }
            return byteArrayOutputStream;
        }
        return (ByteArrayOutputStream) invokeL.objValue;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (!SDKManager.isIsStrong() || str.contains("/api/netm/v1.0/qhbt") || str.contains("/api/netm/v1.0/qhbv") || str.contains("/dro/netm/v1.0/gmctc") || str.contains("/st/api/v1.0/ses")) ? false : true : invokeL.booleanValue;
    }

    public final String a() {
        InterceptResult invokeV;
        String str;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.e != null) {
                    String a2 = this.e.a();
                    String d = this.e.d();
                    str = j.a.k;
                    if (a2.equals(str)) {
                        String b2 = k.b(this.e.e());
                        if (!com.sdk.base.framework.a.a.c.b(b2).booleanValue()) {
                            return d;
                        }
                        sb = new StringBuilder();
                        sb.append(d);
                        sb.append("?");
                        sb.append(b2);
                    } else if (!com.sdk.base.framework.a.a.c.b((String) null).booleanValue()) {
                        return d;
                    } else {
                        sb = new StringBuilder();
                        sb.append(d);
                        sb.append("?unikey=");
                        sb.append((String) null);
                    }
                    return sb.toString();
                }
            } catch (Exception e) {
                com.sdk.base.framework.a.a.c.b(a, e.getMessage(), Boolean.valueOf(b));
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x013f */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v5 int)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r7v11 java.lang.Object)] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HttpURLConnection a(String str, boolean z) {
        InterceptResult invokeLZ;
        HttpURLConnection httpURLConnection;
        a aVar;
        HttpURLConnection httpURLConnection2;
        com.sdk.base.framework.f.g.c a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            com.sdk.base.framework.f.g.c.c.a();
            try {
                HttpsURLConnection httpsURLConnection = null;
                r1 = null;
                HttpURLConnection httpURLConnection3 = null;
                if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
                    URL url = new URL(str);
                    int a3 = com.sdk.base.framework.f.g.b.a(this.d, null).a();
                    System.currentTimeMillis();
                    if (a(str) && a3 != com.sdk.base.framework.f.g.c.b.a()) {
                        int b2 = com.sdk.base.framework.f.a.a.b();
                        if (b2 < 23) {
                            String d = this.e.d();
                            if (a(d)) {
                                ArrayList arrayList = new ArrayList();
                                if (com.sdk.base.framework.a.a.c.b(d).booleanValue()) {
                                    arrayList.add(d);
                                }
                                a2 = com.sdk.base.framework.f.g.b.a(this.d, arrayList);
                            } else {
                                a2 = com.sdk.base.framework.f.g.b.a(this.d, null);
                            }
                            a3 = a2.a();
                            if (b2 <= 21 || a3 == com.sdk.base.framework.f.g.c.b.a()) {
                                httpURLConnection2 = null;
                                if (httpURLConnection2 != null) {
                                    return null;
                                }
                                httpURLConnection3 = httpURLConnection2;
                            } else {
                                aVar = new a(this.d, url);
                            }
                        } else {
                            aVar = new a(this.d, url);
                        }
                        httpURLConnection2 = aVar.a();
                        if (httpURLConnection2 != null) {
                        }
                    }
                    if (httpURLConnection3 == null) {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    } else {
                        httpURLConnection = httpURLConnection3;
                        if (a3 == com.sdk.base.framework.f.g.c.a.a()) {
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
                                httpsURLConnection2.setHostnameVerifier(f);
                                httpsURLConnection = httpsURLConnection2;
                            }
                        }
                    }
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setInstanceFollowRedirects(false);
                    httpsURLConnection.setRequestProperty("user-agent", com.sdk.base.framework.f.d.a.a(this.d));
                    StringBuilder sb = new StringBuilder();
                    sb.append(a3);
                    httpsURLConnection.setRequestProperty("netType", sb.toString());
                    httpsURLConnection.setRequestProperty("os", "android");
                    HashMap<String, Object> h = this.e.h();
                    if (h != null && h.size() > 0) {
                        for (Map.Entry<String, Object> entry : h.entrySet()) {
                            Object value = entry.getValue();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(value);
                            httpsURLConnection.setRequestProperty(entry.getKey(), sb2.toString());
                        }
                    }
                }
                return httpsURLConnection;
            } catch (Exception e) {
                com.sdk.base.framework.f.f.a.b(e.toString());
                com.sdk.base.framework.a.a.c.b(a, e.toString(), Boolean.valueOf(b));
                throw e;
            }
        }
        return (HttpURLConnection) invokeLZ.objValue;
    }

    public final HttpURLConnection a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection)) == null) {
            if (httpURLConnection != null) {
                k<T> kVar = this.e;
                if (kVar == null || !kVar.c()) {
                    str = "application/x-www-form-urlencoded";
                } else {
                    str = "multipart/form-data; boundary=" + c;
                }
                httpURLConnection.setRequestProperty("Content-Type", str);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("connection", "keep-alive");
                if (this.e != null) {
                    str2 = j.b.k;
                    if (str2.equals(this.e.a())) {
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
        return (HttpURLConnection) invokeL.objValue;
    }

    public final k<T> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (k) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.e.a(j.a.toString());
        }
    }
}
