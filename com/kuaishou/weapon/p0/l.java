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
public class l {
    public static /* synthetic */ Interceptable $ic = null;
    public static TrustManager[] a = null;
    public static SSLSocketFactory b = null;
    public static final String c = "gzip";
    public static final int d = 1024;
    public static volatile l f;
    public static Context g;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774669, "Lcom/kuaishou/weapon/p0/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774669, "Lcom/kuaishou/weapon/p0/l;");
                return;
            }
        }
        a = new TrustManager[]{new X509TrustManager() { // from class: com.kuaishou.weapon.p0.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // javax.net.ssl.X509TrustManager
            public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, x509CertificateArr, str) == null) {
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public final X509Certificate[] getAcceptedIssuers() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (X509Certificate[]) invokeV.objValue;
            }

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // javax.net.ssl.X509TrustManager
            public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) != null) {
                    return;
                }
                try {
                    l.b(x509CertificateArr);
                } catch (Throwable unused) {
                }
            }
        }};
    }

    public l(Context context) {
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
        this.e = false;
        g = context;
    }

    private synchronized void a(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, httpsURLConnection) == null) {
            synchronized (this) {
                if (httpsURLConnection != null) {
                    try {
                        if (b == null) {
                            SSLContext sSLContext = SSLContext.getInstance("TLS");
                            sSLContext.init(null, a, new SecureRandom());
                            b = sSLContext.getSocketFactory();
                        }
                        if (b != null) {
                            httpsURLConnection.setSSLSocketFactory(b);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public static void b(X509Certificate[] x509CertificateArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, x509CertificateArr) == null) && x509CertificateArr != null) {
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
    }

    public static l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f == null) {
                synchronized (l.class) {
                    if (f == null) {
                        f = new l(context);
                    }
                }
            }
            return f;
        }
        return (l) invokeL.objValue;
    }

    private InputStream a(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, httpURLConnection)) == null) {
            if (httpURLConnection != null && httpURLConnection != null) {
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.e = true;
                    } else {
                        this.e = false;
                    }
                    return httpURLConnection.getInputStream();
                } catch (IOException unused) {
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            try {
                new h(g).c(df.m, str, true);
            } catch (Exception unused) {
            }
        }
    }

    private boolean a(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, inputStream, file)) == null) {
            if (this.e) {
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
                        if (read != -1) {
                            bufferedOutputStream.write(bArr, 0, read);
                            bufferedOutputStream.flush();
                        } else {
                            try {
                                bufferedOutputStream.close();
                                return true;
                            } catch (IOException unused2) {
                                return true;
                            }
                        }
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
        } else {
            return invokeLL.booleanValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00e4 A[Catch: Exception -> 0x00e7, TRY_LEAVE, TryCatch #6 {Exception -> 0x00e7, blocks: (B:49:0x00df, B:51:0x00e4), top: B:74:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(m mVar) {
        InterceptResult invokeL;
        InputStream inputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mVar)) == null) {
            boolean z = false;
            ByteArrayOutputStream byteArrayOutputStream3 = null;
            try {
                HttpURLConnection a2 = a(mVar.a, "POST");
                String b2 = mVar.b();
                if (!TextUtils.isEmpty(b2) && a2 != null) {
                    a2.setRequestProperty("Cookie", b2);
                }
                String c2 = mVar.c();
                if (!TextUtils.isEmpty(c2) && a2 != null) {
                    a2.setRequestProperty("env", c2);
                }
                if (mVar.a() != null) {
                    bArr = mVar.a().toString().getBytes();
                } else {
                    bArr = null;
                }
                if (bArr != null && bArr.length > 0) {
                    a2.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                    OutputStream outputStream = a2.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                }
                if (a2.getResponseCode() == 200) {
                    inputStream2 = a2.getInputStream();
                    try {
                        try {
                            new h(g).b(df.d, a2.getDate() - System.currentTimeMillis());
                            e.c("WeaponHttpTask --   date " + a2.getDate() + " " + System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            inputStream = inputStream2;
                            th = th2;
                            if (byteArrayOutputStream3 != null) {
                                try {
                                    byteArrayOutputStream3.close();
                                } catch (Exception unused) {
                                    throw th;
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th;
                        }
                    } catch (Exception unused2) {
                    }
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Exception unused3) {
                        byteArrayOutputStream = null;
                    }
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        str = byteArrayOutputStream.toString();
                        z = true;
                    } catch (Exception unused4) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused5) {
                                str = null;
                                if (!z) {
                                }
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        str = null;
                        if (!z) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream3 = byteArrayOutputStream;
                        Throwable th22 = th;
                        inputStream = inputStream2;
                        th = th22;
                        if (byteArrayOutputStream3 != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    inputStream2 = null;
                    str = null;
                    byteArrayOutputStream2 = null;
                }
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused6) {
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
            } catch (Exception unused7) {
                inputStream2 = null;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
            }
            if (!z) {
                return null;
            }
            return str;
        }
        return (String) invokeL.objValue;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    public HttpURLConnection a(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
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

    public void a(m mVar, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, mVar, jVar) == null) {
            a(mVar, jVar, "GET");
        }
    }

    public void b(m mVar, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, mVar, jVar) == null) {
            a(mVar, jVar, "POST");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00f9 A[Catch: Exception -> 0x0101, TryCatch #8 {Exception -> 0x0101, blocks: (B:56:0x00f4, B:58:0x00f9, B:60:0x00fe), top: B:85:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe A[Catch: Exception -> 0x0101, TRY_LEAVE, TryCatch #8 {Exception -> 0x0101, blocks: (B:56:0x00f4, B:58:0x00f9, B:60:0x00fe), top: B:85:0x00f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(m mVar, j jVar, String str) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        String str2;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, mVar, jVar, str) == null) {
            ByteArrayOutputStream byteArrayOutputStream3 = null;
            try {
                HttpURLConnection a2 = a(mVar.a, str);
                String b2 = mVar.b();
                if (!TextUtils.isEmpty(b2) && a2 != null) {
                    a2.setRequestProperty("Cookie", b2);
                }
                String c2 = mVar.c();
                if (!TextUtils.isEmpty(c2) && a2 != null) {
                    a2.setRequestProperty("env", c2);
                }
                if (str.equalsIgnoreCase(CommandUBCHelper.COMMAND_UBC_SOURCE_SEND)) {
                    if (mVar.a() != null) {
                        bArr = mVar.a().toString().getBytes();
                    } else {
                        bArr = null;
                    }
                    if (bArr != null && bArr.length > 0) {
                        a2.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                        OutputStream outputStream = a2.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                boolean z = false;
                if (a2.getResponseCode() == 200) {
                    inputStream2 = a2.getInputStream();
                    try {
                        try {
                            new h(g).b(df.d, a2.getDate() - System.currentTimeMillis());
                            e.c("WeaponHttpTask --   date " + a2.getDate() + " " + System.currentTimeMillis());
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                        } catch (Exception unused2) {
                            byteArrayOutputStream2 = null;
                        }
                    } catch (Throwable th) {
                        byteArrayOutputStream = null;
                        inputStream = inputStream2;
                        th = th;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception unused3) {
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (jVar != null) {
                            jVar.b(null);
                        }
                        throw th;
                    }
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                        z = true;
                        byteArrayOutputStream3 = byteArrayOutputStream2;
                        str2 = byteArrayOutputStream2.toString();
                    } catch (Exception unused4) {
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused5) {
                                return;
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (jVar != null) {
                            jVar.b(null);
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        if (byteArrayOutputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (jVar != null) {
                        }
                        throw th;
                    }
                } else {
                    inputStream2 = null;
                    str2 = null;
                }
                if (byteArrayOutputStream3 != null) {
                    try {
                        byteArrayOutputStream3.close();
                    } catch (Exception unused6) {
                        return;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (z) {
                    if (jVar != null) {
                        jVar.a(str2);
                    }
                } else if (jVar != null) {
                    jVar.b(str2);
                }
            } catch (Exception unused7) {
                inputStream2 = null;
                byteArrayOutputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        }
    }

    public boolean a(String str, File file) {
        InterceptResult invokeLL;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, file)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            InputStream inputStream = null;
            try {
                httpURLConnection = a(str, "GET");
            } catch (Throwable unused) {
                httpURLConnection = null;
            }
            try {
                inputStream = a(httpURLConnection);
                boolean a2 = a(inputStream, file);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused2) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return a2;
            } catch (Throwable unused3) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused4) {
                        return false;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }
}
