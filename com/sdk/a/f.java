package com.sdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.jni.TtsLogLoad;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.p.f;
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
import javax.net.ssl.HttpsURLConnection;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
/* loaded from: classes10.dex */
public class f<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "f";
    public static boolean b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context d;
    public g<T> e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2126493173, "Lcom/sdk/a/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2126493173, "Lcom/sdk/a/f$a;");
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593316142, "Lcom/sdk/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593316142, "Lcom/sdk/a/f;");
                return;
            }
        }
        b = com.sdk.f.f.a;
        c = UUID.randomUUID().toString();
    }

    public f(Context context, g<T> gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gVar};
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
        this.e = gVar;
    }

    public String a() {
        StringBuilder sb;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                if (this.e != null) {
                    String str = this.e.c;
                    String str2 = this.e.d;
                    if (str.equals(a.a.l)) {
                        String a2 = this.e.a(this.e.f);
                        if (com.sdk.o.a.b(a2).booleanValue()) {
                            sb = new StringBuilder();
                            sb.append(str2);
                            sb.append("?");
                            sb.append(a2);
                        } else {
                            return str2;
                        }
                    } else {
                        String str3 = this.e.e;
                        if (com.sdk.o.a.b(str3).booleanValue()) {
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
                com.sdk.o.a.a(a, e.getMessage(), Boolean.valueOf(b));
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HttpURLConnection a(String str, boolean z) {
        InterceptResult invokeLZ;
        b bVar;
        HttpURLConnection httpURLConnection;
        f.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            f.a.c.a();
            try {
                HttpURLConnection httpURLConnection2 = null;
                if (com.sdk.o.a.b(str).booleanValue()) {
                    URL url = new URL(str);
                    int a3 = com.sdk.p.f.a(this.d, null).a();
                    System.currentTimeMillis();
                    if (a(str) && a3 != f.a.b.a()) {
                        int a4 = com.sdk.j.a.a();
                        if (a4 < 23) {
                            String str2 = this.e.d;
                            if (a(str2)) {
                                ArrayList arrayList = new ArrayList();
                                if (com.sdk.o.a.b(str2).booleanValue()) {
                                    arrayList.add(str2);
                                }
                                a2 = com.sdk.p.f.a(this.d, arrayList);
                            } else {
                                a2 = com.sdk.p.f.a(this.d, null);
                            }
                            a3 = a2.a();
                            if (a4 > 21 && a3 != f.a.b.a()) {
                                bVar = new b(this.d, url);
                            } else {
                                httpURLConnection = null;
                                if (httpURLConnection != null) {
                                    return null;
                                }
                                httpURLConnection2 = httpURLConnection;
                            }
                        } else {
                            bVar = new b(this.d, url);
                        }
                        httpURLConnection = bVar.a();
                        if (httpURLConnection != null) {
                        }
                    }
                    if (httpURLConnection2 == null) {
                        httpURLConnection2 = (HttpURLConnection) url.openConnection();
                    } else if (a3 == f.a.a.a()) {
                        a3 = 2;
                    }
                    String protocol = url.getProtocol();
                    if (com.sdk.o.a.b(protocol).booleanValue() && z && SDKManager.smartTrust && "https".equals(protocol.toLowerCase(Locale.getDefault()))) {
                        httpURLConnection2 = (HttpsURLConnection) httpURLConnection2;
                    }
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setReadTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("user-agent", com.sdk.m.a.a(this.d));
                    httpURLConnection2.setRequestProperty("netType", a3 + "");
                    httpURLConnection2.setRequestProperty(TtsLogLoad.KEY_OS, "android");
                    String str3 = a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("connection==: ");
                    sb.append(httpURLConnection2);
                    Log.d(str3, sb.toString());
                    HashMap<String, Object> hashMap = this.e.h;
                    if (hashMap != null && hashMap.size() > 0) {
                        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                            httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue() + "");
                        }
                    }
                }
                return httpURLConnection2;
            } catch (Exception e) {
                com.sdk.o.b.c(e.toString());
                com.sdk.o.a.a(a + "HttpRequst 248", e.toString(), Boolean.valueOf(b));
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
                g<T> gVar = this.e;
                if (gVar != null) {
                    ArrayList<File> arrayList = gVar.g;
                    if (arrayList != null && arrayList.size() != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        str = "multipart/form-data; boundary=" + c;
                        httpURLConnection.setRequestProperty("Content-Type", str);
                        httpURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                        httpURLConnection.setRequestProperty("connection", Http2Codec.KEEP_ALIVE);
                        if (this.e != null) {
                            if (a.b.l.equals(this.e.c)) {
                                httpURLConnection.setRequestMethod("POST");
                                httpURLConnection.getRequestMethod();
                                httpURLConnection.connect();
                                g<T> gVar2 = this.e;
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                if (gVar2 != null) {
                                    try {
                                        String a2 = gVar2.a(this.e.f);
                                        if (gVar2.d.contains("/dro/log/v1.0/log")) {
                                            a2 = gVar2.f.toString();
                                        }
                                        ArrayList<File> arrayList2 = gVar2.g;
                                        if (arrayList2 != null && arrayList2.size() > 0) {
                                            byteArrayOutputStream.write(("--" + c + "\r\n").getBytes("utf-8"));
                                            byteArrayOutputStream.write("Content-Disposition: form-data; name=\"params\"".getBytes("utf-8"));
                                            byteArrayOutputStream.write("\r\n\r\n".getBytes("utf-8"));
                                            byteArrayOutputStream.write(a2.getBytes("utf-8"));
                                            byteArrayOutputStream.write("\r\n".getBytes("utf-8"));
                                            for (int i = 0; i < arrayList2.size(); i++) {
                                                File file = arrayList2.get(i);
                                                if (file != null) {
                                                    FileInputStream fileInputStream = new FileInputStream(file);
                                                    String name = file.getName();
                                                    byteArrayOutputStream.write(("--" + c + "\r\n").getBytes("utf-8"));
                                                    StringBuilder sb = new StringBuilder();
                                                    sb.append("Content-Disposition: form-data; name=\"");
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
                                                    StringBuilder sb2 = new StringBuilder();
                                                    sb2.append("\r\n--");
                                                    sb2.append(c);
                                                    sb2.append("--\r\n");
                                                    byteArrayOutputStream.write(sb2.toString().getBytes("utf-8"));
                                                    byteArrayOutputStream.flush();
                                                    fileInputStream.close();
                                                }
                                            }
                                        } else {
                                            byteArrayOutputStream.write(a2.getBytes("utf-8"));
                                        }
                                    } catch (Exception e) {
                                        com.sdk.o.b.c(e.toString());
                                        com.sdk.o.a.a(a + "HttpRequst558", e.toString(), Boolean.valueOf(b));
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
                httpURLConnection.setRequestProperty("connection", Http2Codec.KEEP_ALIVE);
                if (this.e != null) {
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
