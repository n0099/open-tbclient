package com.sdk.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import com.sdk.base.framework.utils.app.AppUtils;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.o.f;
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
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "g";
    public static boolean b;
    public static final String c;
    public static final HostnameVerifier d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context e;
    public h f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final /* synthetic */ a[] k;
        public transient /* synthetic */ FieldHolder $fh;
        public final String l;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2126522964, "Lcom/sdk/a/g$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2126522964, "Lcom/sdk/a/g$a;");
                    return;
                }
            }
            a = new a("GET", 0, "GET");
            b = new a("POST", 1, "POST");
            c = new a(HttpPut.METHOD_NAME, 2, HttpPut.METHOD_NAME);
            d = new a("HEAD", 3, "HEAD");
            e = new a("MOVE", 4, "MOVE");
            f = new a("COPY", 5, "COPY");
            g = new a(HttpDelete.METHOD_NAME, 6, HttpDelete.METHOD_NAME);
            h = new a(HttpOptions.METHOD_NAME, 7, HttpOptions.METHOD_NAME);
            i = new a(HttpTrace.METHOD_NAME, 8, HttpTrace.METHOD_NAME);
            a aVar = new a("CONNECT", 9, "CONNECT");
            j = aVar;
            k = new a[]{a, b, c, d, e, f, g, h, i, aVar};
        }

        public a(String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str3 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.l = str2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (a[]) k.clone() : (a[]) invokeV.objValue;
        }

        @Override // java.lang.Enum
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.l : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593316111, "Lcom/sdk/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593316111, "Lcom/sdk/a/g;");
                return;
            }
        }
        b = com.sdk.f.g.b;
        c = UUID.randomUUID().toString();
        d = new f();
    }

    public g(Context context, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = context;
        this.f = hVar;
    }

    public String a() {
        StringBuilder sb;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.f != null) {
                    String str = this.f.c;
                    String str2 = this.f.d;
                    if (str.equals(a.a.l)) {
                        String a2 = this.f.a(this.f.f);
                        if (com.sdk.n.a.b(a2).booleanValue()) {
                            sb = new StringBuilder();
                            sb.append(str2);
                            sb.append("?");
                            sb.append(a2);
                        } else {
                            return str2;
                        }
                    } else {
                        String str3 = this.f.e;
                        if (com.sdk.n.a.b(str3).booleanValue()) {
                            sb = new StringBuilder();
                            sb.append(str2);
                            sb.append("?unikey=");
                            sb.append(str3);
                        } else {
                            return str2;
                        }
                    }
                    return sb.toString();
                }
                return null;
            } catch (Exception e) {
                com.sdk.n.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x013f */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpURLConnection a(String str, boolean z) {
        InterceptResult invokeLZ;
        HttpURLConnection httpURLConnection;
        b bVar;
        HttpURLConnection httpURLConnection2;
        f.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            f.a.c.a();
            try {
                HttpsURLConnection httpsURLConnection = null;
                r2 = null;
                HttpURLConnection httpURLConnection3 = null;
                if (com.sdk.n.a.b(str).booleanValue()) {
                    URL url = new URL(str);
                    int a3 = com.sdk.o.f.a(this.e, null).a();
                    System.currentTimeMillis();
                    if (a(str) && a3 != f.a.b.a()) {
                        int androidSDKVersion = AppUtils.getAndroidSDKVersion(this.e);
                        if (androidSDKVersion < 23) {
                            String str2 = this.f.d;
                            if (a(str2)) {
                                ArrayList arrayList = new ArrayList();
                                if (com.sdk.n.a.b(str2).booleanValue()) {
                                    arrayList.add(str2);
                                }
                                a2 = com.sdk.o.f.a(this.e, arrayList);
                            } else {
                                a2 = com.sdk.o.f.a(this.e, null);
                            }
                            a3 = a2.a();
                            if (androidSDKVersion > 21 && a3 != f.a.b.a()) {
                                bVar = new b(this.e, url);
                            } else {
                                httpURLConnection2 = null;
                                if (httpURLConnection2 != null) {
                                    return null;
                                }
                                httpURLConnection3 = httpURLConnection2;
                            }
                        } else {
                            bVar = new b(this.e, url);
                        }
                        httpURLConnection2 = bVar.a();
                        if (httpURLConnection2 != null) {
                        }
                    }
                    if (httpURLConnection3 == null) {
                        httpURLConnection = (HttpURLConnection) url.openConnection();
                    } else {
                        httpURLConnection = httpURLConnection3;
                        if (a3 == f.a.a.a()) {
                            a3 = 2;
                            httpURLConnection = httpURLConnection3;
                        }
                    }
                    String protocol = url.getProtocol();
                    httpsURLConnection = httpURLConnection;
                    httpsURLConnection = httpURLConnection;
                    if (com.sdk.n.a.b(protocol).booleanValue() && z) {
                        httpsURLConnection = httpURLConnection;
                        if (SDKManager.smartTrust) {
                            httpsURLConnection = httpURLConnection;
                            if ("https".equals(protocol.toLowerCase(Locale.getDefault()))) {
                                HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) httpURLConnection;
                                httpsURLConnection2.setHostnameVerifier(d);
                                httpsURLConnection = httpsURLConnection2;
                            }
                        }
                    }
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setInstanceFollowRedirects(false);
                    httpsURLConnection.setRequestProperty("user-agent", com.sdk.l.a.a(this.e));
                    httpsURLConnection.setRequestProperty("netType", a3 + "");
                    httpsURLConnection.setRequestProperty("os", "android");
                    HashMap hashMap = this.f.h;
                    if (hashMap != null && hashMap.size() > 0) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            httpsURLConnection.setRequestProperty((String) entry.getKey(), entry.getValue() + "");
                        }
                    }
                }
                return httpsURLConnection;
            } catch (Exception e) {
                com.sdk.n.b.c(e.toString());
                com.sdk.n.a.a(a, e.toString(), Boolean.valueOf(b));
                throw e;
            }
        }
        return (HttpURLConnection) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpURLConnection a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpURLConnection)) == null) {
            if (httpURLConnection != null) {
                h hVar = this.f;
                if (hVar != null) {
                    ArrayList arrayList = hVar.g;
                    if (arrayList != null && arrayList.size() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str = "multipart/form-data; boundary=" + c;
                        httpURLConnection.setRequestProperty("Content-Type", str);
                        httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                        httpURLConnection.setRequestProperty("connection", "keep-alive");
                        if (this.f != null) {
                            if (a.b.l.equals(this.f.c)) {
                                httpURLConnection.setRequestMethod("POST");
                                httpURLConnection.getRequestMethod();
                                httpURLConnection.connect();
                                h hVar2 = this.f;
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                if (hVar2 != null) {
                                    try {
                                        String a2 = hVar2.a(this.f.f);
                                        if (hVar2.d.contains("/dro/log/v1.0/log")) {
                                            a2 = hVar2.f.toString();
                                        }
                                        ArrayList arrayList2 = hVar2.g;
                                        if (arrayList2 != null && arrayList2.size() > 0) {
                                            byteArrayOutputStream.write(("--" + c + "\r\n").getBytes(IMAudioTransRequest.CHARSET));
                                            byteArrayOutputStream.write("Content-Disposition: form-data; name=\"params\"".getBytes(IMAudioTransRequest.CHARSET));
                                            byteArrayOutputStream.write("\r\n\r\n".getBytes(IMAudioTransRequest.CHARSET));
                                            byteArrayOutputStream.write(a2.getBytes(IMAudioTransRequest.CHARSET));
                                            byteArrayOutputStream.write("\r\n".getBytes(IMAudioTransRequest.CHARSET));
                                            for (int i = 0; i < arrayList2.size(); i++) {
                                                File file = (File) arrayList2.get(i);
                                                if (file != null) {
                                                    FileInputStream fileInputStream = new FileInputStream(file);
                                                    String name = file.getName();
                                                    byteArrayOutputStream.write(("--" + c + "\r\n").getBytes(IMAudioTransRequest.CHARSET));
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("Content-Disposition: form-data; name=\"");
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
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("\r\n--");
                                                    sb2.append(c);
                                                    sb2.append("--\r\n");
                                                    byteArrayOutputStream.write(sb2.toString().getBytes(IMAudioTransRequest.CHARSET));
                                                    byteArrayOutputStream.flush();
                                                    fileInputStream.close();
                                                }
                                            }
                                        } else {
                                            byteArrayOutputStream.write(a2.getBytes(IMAudioTransRequest.CHARSET));
                                        }
                                    } catch (Exception e) {
                                        com.sdk.n.b.c(e.toString());
                                        com.sdk.n.a.a(a, e.toString(), Boolean.valueOf(b));
                                    }
                                }
                                httpURLConnection.getOutputStream().write(byteArrayOutputStream.toByteArray());
                            } else {
                                httpURLConnection.setRequestMethod("GET");
                                httpURLConnection.getRequestMethod();
                                httpURLConnection.connect();
                            }
                        }
                    }
                }
                str = "application/x-www-form-urlencoded";
                httpURLConnection.setRequestProperty("Content-Type", str);
                httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                httpURLConnection.setRequestProperty("connection", "keep-alive");
                if (this.f != null) {
                }
            }
            return httpURLConnection;
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public final boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (!SDKManager.isStrong || str.contains("/api/netm/v1.0/qhbt") || str.contains("/api/netm/v1.0/qhbv") || str.contains("/st/api/v1.0/ses")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
