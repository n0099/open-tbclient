package com.sdk.base.framework.a;

import android.annotation.SuppressLint;
import android.content.Context;
import com.android.internal.http.multipart.Part;
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
/* loaded from: classes10.dex */
public class h<T> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f75821a = "h";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f75822b;

    /* renamed from: c  reason: collision with root package name */
    public static String f75823c;

    /* renamed from: f  reason: collision with root package name */
    public static final HostnameVerifier f75824f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public Context f75825d;

    /* renamed from: e  reason: collision with root package name */
    public k<T> f75826e;

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
        f75822b = com.sdk.base.framework.c.f.f75869b;
        f75823c = UUID.randomUUID().toString();
        f75824f = new i();
    }

    public h(Context context, k<T> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, kVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f75825d = context;
        this.f75826e = kVar;
    }

    private ByteArrayOutputStream a(k<T> kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, kVar)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (kVar != null) {
                try {
                    String b2 = k.b(this.f75826e.e());
                    if (kVar.d().contains("/dro/log/v1.0/log")) {
                        b2 = kVar.e().toString();
                    }
                    ArrayList<File> b3 = kVar.b();
                    if (b3 == null || b3.size() <= 0) {
                        byteArrayOutputStream.write(b2.getBytes("utf-8"));
                    } else {
                        byteArrayOutputStream.write(("--" + f75823c + Part.CRLF).getBytes("utf-8"));
                        byteArrayOutputStream.write("Content-Disposition: form-data; name=\"params\"".getBytes("utf-8"));
                        byteArrayOutputStream.write("\r\n\r\n".getBytes("utf-8"));
                        byteArrayOutputStream.write(b2.getBytes("utf-8"));
                        byteArrayOutputStream.write(Part.CRLF.getBytes("utf-8"));
                        for (int i2 = 0; i2 < b3.size(); i2++) {
                            File file = b3.get(i2);
                            if (file != null) {
                                FileInputStream fileInputStream = new FileInputStream(file);
                                String name = file.getName();
                                byteArrayOutputStream.write(("--" + f75823c + Part.CRLF).getBytes("utf-8"));
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
                                sb2.append(f75823c);
                                sb2.append("--\r\n");
                                byteArrayOutputStream.write(sb2.toString().getBytes("utf-8"));
                                byteArrayOutputStream.flush();
                                fileInputStream.close();
                            }
                        }
                    }
                } catch (Exception e2) {
                    com.sdk.base.framework.f.f.a.b(e2.toString());
                    com.sdk.base.framework.a.a.c.b(f75821a, e2.toString(), Boolean.valueOf(f75822b));
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
                if (this.f75826e != null) {
                    String a2 = this.f75826e.a();
                    String d2 = this.f75826e.d();
                    str = j.f75827a.k;
                    if (a2.equals(str)) {
                        String b2 = k.b(this.f75826e.e());
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
                com.sdk.base.framework.a.a.c.b(f75821a, e2.getMessage(), Boolean.valueOf(f75822b));
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
            com.sdk.base.framework.f.g.c.f75904c.a();
            try {
                HttpsURLConnection httpsURLConnection = null;
                r1 = null;
                HttpURLConnection httpURLConnection3 = null;
                if (com.sdk.base.framework.a.a.c.b(str).booleanValue()) {
                    URL url = new URL(str);
                    int a3 = com.sdk.base.framework.f.g.b.a(this.f75825d, null).a();
                    System.currentTimeMillis();
                    if (a(str) && a3 != com.sdk.base.framework.f.g.c.f75903b.a()) {
                        int b2 = com.sdk.base.framework.f.a.a.b();
                        if (b2 < 23) {
                            String d2 = this.f75826e.d();
                            if (a(d2)) {
                                ArrayList arrayList = new ArrayList();
                                if (com.sdk.base.framework.a.a.c.b(d2).booleanValue()) {
                                    arrayList.add(d2);
                                }
                                a2 = com.sdk.base.framework.f.g.b.a(this.f75825d, arrayList);
                            } else {
                                a2 = com.sdk.base.framework.f.g.b.a(this.f75825d, null);
                            }
                            a3 = a2.a();
                            if (b2 <= 21 || a3 == com.sdk.base.framework.f.g.c.f75903b.a()) {
                                httpURLConnection2 = null;
                                if (httpURLConnection2 != null) {
                                    return null;
                                }
                                httpURLConnection3 = httpURLConnection2;
                            } else {
                                aVar = new a(this.f75825d, url);
                            }
                        } else {
                            aVar = new a(this.f75825d, url);
                        }
                        httpURLConnection2 = aVar.a();
                        if (httpURLConnection2 != null) {
                        }
                    }
                    if (httpURLConnection3 == null) {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    } else {
                        httpURLConnection = httpURLConnection3;
                        if (a3 == com.sdk.base.framework.f.g.c.f75902a.a()) {
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
                                httpsURLConnection2.setHostnameVerifier(f75824f);
                                httpsURLConnection = httpsURLConnection2;
                            }
                        }
                    }
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setInstanceFollowRedirects(false);
                    httpsURLConnection.setRequestProperty("user-agent", com.sdk.base.framework.f.d.a.a(this.f75825d));
                    StringBuilder sb = new StringBuilder();
                    sb.append(a3);
                    httpsURLConnection.setRequestProperty("netType", sb.toString());
                    httpsURLConnection.setRequestProperty("os", "android");
                    HashMap<String, Object> h2 = this.f75826e.h();
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
                com.sdk.base.framework.a.a.c.b(f75821a, e2.toString(), Boolean.valueOf(f75822b));
                throw e2;
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
                k<T> kVar = this.f75826e;
                if (kVar == null || !kVar.c()) {
                    str = "application/x-www-form-urlencoded";
                } else {
                    str = "multipart/form-data; boundary=" + f75823c;
                }
                httpURLConnection.setRequestProperty("Content-Type", str);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("connection", "keep-alive");
                if (this.f75826e != null) {
                    str2 = j.f75828b.k;
                    if (str2.equals(this.f75826e.a())) {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.connect();
                        httpURLConnection.getOutputStream().write(a(this.f75826e).toByteArray());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f75826e : (k) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f75826e.a(j.f75827a.toString());
        }
    }
}
