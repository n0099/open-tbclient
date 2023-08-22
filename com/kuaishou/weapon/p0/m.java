package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes10.dex */
public class m {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "gzip";
    public static final int c = 1024;
    public static volatile m d;
    public static Context e;
    public static TrustManager[] f;
    public static SSLSocketFactory g;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes10.dex */
    public static class a implements X509TrustManager {
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

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
                try {
                    m.b(x509CertificateArr);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (X509Certificate[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774638, "Lcom/kuaishou/weapon/p0/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774638, "Lcom/kuaishou/weapon/p0/m;");
                return;
            }
        }
        f = new TrustManager[]{new a()};
    }

    public m(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        e = context;
    }

    public static m a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (d == null) {
                synchronized (m.class) {
                    if (d == null) {
                        d = new m(context);
                    }
                }
            }
            return d;
        }
        return (m) invokeL.objValue;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, httpURLConnection)) == null) {
            if (httpURLConnection != null && httpURLConnection != null) {
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.a = true;
                    } else {
                        this.a = false;
                    }
                    return httpURLConnection.getInputStream();
                } catch (IOException unused) {
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    private HttpURLConnection a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            try {
                URL url = new URL(str);
                if ("https".equals(url.getProtocol())) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    a(httpsURLConnection2);
                    httpsURLConnection = httpsURLConnection2;
                } else {
                    httpsURLConnection = (HttpURLConnection) url.openConnection();
                }
                try {
                    httpsURLConnection.setRequestMethod(str2);
                    httpsURLConnection.setAllowUserInteraction(true);
                    httpsURLConnection.setInstanceFollowRedirects(true);
                    httpsURLConnection.setChunkedStreamingMode(0);
                    httpsURLConnection.setConnectTimeout(10000);
                    httpsURLConnection.setReadTimeout(5000);
                    httpsURLConnection.setRequestProperty(BOSTokenRequest.CHARSET, "UTF-8");
                    httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    if (str2.equalsIgnoreCase(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND)) {
                        httpsURLConnection.setDoInput(true);
                        httpsURLConnection.setDoOutput(true);
                        httpsURLConnection.setUseCaches(false);
                        return httpsURLConnection;
                    }
                    return httpsURLConnection;
                } catch (Exception unused) {
                    return httpsURLConnection;
                }
            } catch (Exception unused2) {
                return null;
            }
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            try {
                new i(e).b(f3.m, str, true);
            } catch (Exception unused) {
            }
        }
    }

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, httpsURLConnection) == null) {
            synchronized (this) {
                if (httpsURLConnection != null) {
                    try {
                        if (g == null) {
                            SSLContext sSLContext = SSLContext.getInstance("TLS");
                            sSLContext.init(null, f, new SecureRandom());
                            g = sSLContext.getSocketFactory();
                        }
                        if (g != null) {
                            httpsURLConnection.setSSLSocketFactory(g);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (this.a) {
            try {
                inputStream = new GZIPInputStream(inputStream);
            } catch (IOException unused) {
            }
        }
        if (inputStream == null) {
            return false;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        try {
                            bufferedOutputStream.close();
                            return true;
                        } catch (IOException unused2) {
                            return true;
                        }
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                }
            } catch (Throwable unused3) {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return false;
            }
        } catch (Throwable unused5) {
            bufferedOutputStream = null;
        }
    }

    public static void b(X509Certificate[] x509CertificateArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, x509CertificateArr) == null) || x509CertificateArr == null) {
            return;
        }
        try {
            if (x509CertificateArr.length != 0) {
                String name = x509CertificateArr[0].getIssuerX500Principal().getName();
                if (Pattern.compile(".*(GeoTrust|VeriSign|Symantec|GlobalSign|Entrust|Thawte|DigiCert).*", 2).matcher(name).matches()) {
                    return;
                }
                a(name);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ca, code lost:
        if (r11 != null) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8 A[Catch: Exception -> 0x00db, TRY_LEAVE, TryCatch #4 {Exception -> 0x00db, blocks: (B:51:0x00d3, B:53:0x00d8), top: B:80:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(n nVar) {
        InterceptResult invokeL;
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, nVar)) != null) {
            return (String) invokeL.objValue;
        }
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            HttpURLConnection a2 = a(nVar.a, "POST");
            String a3 = nVar.a();
            if (!TextUtils.isEmpty(a3) && a2 != null) {
                a2.setRequestProperty("Cookie", a3);
            }
            String b2 = nVar.b();
            if (!TextUtils.isEmpty(b2) && a2 != null) {
                a2.setRequestProperty("env", b2);
            }
            byte[] bytes = nVar.c() != null ? nVar.c().toString().getBytes() : null;
            if (bytes != null && bytes.length > 0) {
                a2.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                OutputStream outputStream = a2.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                outputStream.close();
            }
            if (a2.getResponseCode() == 200) {
                inputStream2 = a2.getInputStream();
                try {
                    try {
                        new i(e).b(f3.f, a2.getDate() - System.currentTimeMillis());
                        StringBuilder sb = new StringBuilder("WeaponHttpTask --   date ");
                        sb.append(a2.getDate());
                        sb.append(" ");
                        sb.append(System.currentTimeMillis());
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        th = th;
                        inputStream2 = inputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused) {
                                throw th;
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception unused3) {
                    byteArrayOutputStream = null;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Exception unused4) {
                            str = null;
                            if (z) {
                            }
                        }
                    }
                    if (inputStream2 != null) {
                        str = null;
                        inputStream2.close();
                        if (z) {
                            return str;
                        }
                        return null;
                    }
                    str = null;
                    if (z) {
                    }
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    str = byteArrayOutputStream.toString();
                    z = true;
                } catch (Exception unused5) {
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    str = null;
                    if (z) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                    }
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
            } else {
                inputStream2 = null;
                byteArrayOutputStream = null;
                str = null;
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused6) {
                    if (z) {
                    }
                }
            }
        } catch (Exception unused7) {
            inputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public String a(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map)) == null) {
            String str = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                str = str + "&" + entry.getKey() + "=" + entry.getValue();
            }
            return str.substring(1);
        }
        return (String) invokeL.objValue;
    }

    public void a(n nVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, nVar, kVar) == null) {
            a(nVar, kVar, "GET");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00eb A[Catch: Exception -> 0x00f3, TryCatch #5 {Exception -> 0x00f3, blocks: (B:58:0x00e6, B:60:0x00eb, B:62:0x00f0), top: B:85:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0 A[Catch: Exception -> 0x00f3, TRY_LEAVE, TryCatch #5 {Exception -> 0x00f3, blocks: (B:58:0x00e6, B:60:0x00eb, B:62:0x00f0), top: B:85:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f8 A[Catch: Exception -> 0x0106, TRY_ENTER, TryCatch #2 {Exception -> 0x0106, blocks: (B:45:0x00cb, B:47:0x00d0, B:50:0x00d7, B:72:0x0103, B:67:0x00f8, B:69:0x00fd), top: B:83:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00fd A[Catch: Exception -> 0x0106, TryCatch #2 {Exception -> 0x0106, blocks: (B:45:0x00cb, B:47:0x00d0, B:50:0x00d7, B:72:0x0103, B:67:0x00f8, B:69:0x00fd), top: B:83:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(n nVar, k kVar, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, nVar, kVar, str) == null) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            String str3 = null;
            try {
                try {
                    HttpURLConnection a2 = a(nVar.a, str);
                    String a3 = nVar.a();
                    if (!TextUtils.isEmpty(a3) && a2 != null) {
                        a2.setRequestProperty("Cookie", a3);
                    }
                    String b2 = nVar.b();
                    if (!TextUtils.isEmpty(b2) && a2 != null) {
                        a2.setRequestProperty("env", b2);
                    }
                    if (str.equalsIgnoreCase(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND)) {
                        byte[] bytes = nVar.c() != null ? nVar.c().toString().getBytes() : null;
                        if (bytes != null && bytes.length > 0) {
                            a2.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                            OutputStream outputStream = a2.getOutputStream();
                            outputStream.write(bytes);
                            outputStream.flush();
                            outputStream.close();
                        }
                    }
                    z = false;
                    if (a2.getResponseCode() == 200) {
                        inputStream2 = a2.getInputStream();
                        try {
                            try {
                                new i(e).b(f3.f, a2.getDate() - System.currentTimeMillis());
                                StringBuilder sb = new StringBuilder("WeaponHttpTask --   date ");
                                sb.append(a2.getDate());
                                sb.append(" ");
                                sb.append(System.currentTimeMillis());
                            } catch (Throwable th2) {
                                inputStream = inputStream2;
                                th = th2;
                                th = th;
                                inputStream2 = inputStream;
                                byteArrayOutputStream = null;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused) {
                                        throw th;
                                    }
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (kVar != null) {
                                    kVar.a(null);
                                }
                                throw th;
                            }
                        } catch (Exception unused2) {
                        }
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (Exception unused3) {
                            byteArrayOutputStream = null;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (kVar == null) {
                                return;
                            }
                            kVar.a(str3);
                        }
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                            z = true;
                            byteArrayOutputStream2 = byteArrayOutputStream;
                            str2 = byteArrayOutputStream.toString();
                        } catch (Exception unused4) {
                            if (byteArrayOutputStream != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            if (kVar == null) {
                            }
                            kVar.a(str3);
                        } catch (Throwable th3) {
                            th = th3;
                            if (byteArrayOutputStream != null) {
                            }
                            if (inputStream2 != null) {
                            }
                            if (kVar != null) {
                            }
                            throw th;
                        }
                    } else {
                        inputStream2 = null;
                        str2 = null;
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                } catch (Exception unused5) {
                    return;
                }
            } catch (Exception unused6) {
                inputStream2 = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
            if (z) {
                if (kVar != null) {
                    kVar.b(str2);
                }
            } else if (kVar != null) {
                str3 = str2;
                kVar.a(str3);
            }
        }
    }

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048580, this, str, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            httpURLConnection = a(str, "GET");
            try {
                inputStream = a(httpURLConnection);
                boolean a2 = a(inputStream, file);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a2;
            } catch (Throwable unused2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused3) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            }
        } catch (Throwable unused4) {
            httpURLConnection = null;
        }
    }

    public void b(n nVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, nVar, kVar) == null) {
            a(nVar, kVar, "POST");
        }
    }
}
