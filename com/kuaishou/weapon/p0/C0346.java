package com.kuaishou.weapon.p0;

import android.text.TextUtils;
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
import com.yy.hiidostatis.defs.obj.ParamableElem;
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
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼﹶ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0346 implements InterfaceC0352 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final String f149 = "gzip";

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final int f150 = 1024;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static volatile C0346 f151;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static TrustManager[] f152;

    /* renamed from: ˆ  reason: contains not printable characters */
    public static SSLSocketFactory f153;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean f154;

    /* renamed from: com.kuaishou.weapon.p0.ʼﹶ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static class C0347 implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0347() {
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
                    C0346.m309(x509CertificateArr);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(337179357, "Lcom/kuaishou/weapon/p0/ʼﹶ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(337179357, "Lcom/kuaishou/weapon/p0/ʼﹶ;");
                return;
            }
        }
        f152 = new TrustManager[]{new C0347()};
    }

    public C0346() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f154 = false;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static C0346 m302() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f151 == null) {
                synchronized (C0346.class) {
                    if (f151 == null) {
                        f151 = new C0346();
                    }
                }
            }
            return f151;
        }
        return (C0346) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private InputStream m303(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, httpURLConnection)) == null) {
            if (httpURLConnection != null && httpURLConnection != null) {
                try {
                    if ("gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding())) {
                        this.f154 = true;
                    } else {
                        this.f154 = false;
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
    /* JADX WARN: Type inference failed for: r6v5, types: [java.net.HttpURLConnection] */
    /* renamed from: ʻ  reason: contains not printable characters */
    private HttpURLConnection m304(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2)) == null) {
            try {
                URL url = new URL(str);
                if ("https".equals(url.getProtocol())) {
                    HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                    m306(httpsURLConnection2);
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
                    httpsURLConnection.setRequestProperty("User-Agent", "Android/" + WeaponHI.sKSAppkey + "/" + WeaponHI.hostVersionName);
                    if (str2.equalsIgnoreCase("post")) {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m305(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            C0374.m390().m407(C0374.f309, str, true);
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private synchronized void m306(HttpsURLConnection httpsURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, httpsURLConnection) == null) {
            synchronized (this) {
                if (httpsURLConnection != null) {
                    try {
                        if (f153 == null) {
                            SSLContext sSLContext = SSLContext.getInstance("TLS");
                            sSLContext.init(null, f152, new SecureRandom());
                            f153 = sSLContext.getSocketFactory();
                        }
                        if (f153 != null) {
                            httpsURLConnection.setSSLSocketFactory(f153);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m308(InputStream inputStream, File file) {
        InterceptResult invokeLL;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65544, this, inputStream, file)) != null) {
            return invokeLL.booleanValue;
        }
        if (this.f154) {
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

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m309(X509Certificate[] x509CertificateArr) {
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
                m305(name);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c5, code lost:
        if (r11 == null) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e A[Catch: all -> 0x00c8, Exception -> 0x00d7, TRY_LEAVE, TryCatch #9 {Exception -> 0x00d7, all -> 0x00c8, blocks: (B:5:0x0008, B:8:0x0018, B:9:0x001d, B:12:0x0027, B:13:0x002c, B:15:0x0032, B:16:0x003a, B:25:0x005c, B:28:0x0061, B:29:0x0076, B:31:0x007e, B:17:0x003f, B:19:0x0045, B:20:0x004e, B:22:0x0054), top: B:95:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00d3 A[Catch: Exception -> 0x00d6, TRY_LEAVE, TryCatch #9 {Exception -> 0x00d6, blocks: (B:58:0x00ce, B:60:0x00d3), top: B:91:0x00ce }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00eb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String m310(C0348 c0348) {
        InterceptResult invokeL;
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        byte[] bArr;
        String m317;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, c0348)) != null) {
            return (String) invokeL.objValue;
        }
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            HttpURLConnection m304 = m304(c0348.f155, "POST");
            String str2 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str2) && m304 != null) {
                m304.setRequestProperty("Cookie", str2);
            }
            String str3 = WeaponHI.encryENV;
            if (!TextUtils.isEmpty(str3) && m304 != null) {
                m304.setRequestProperty("env", str3);
            }
            if (c0348.m318() != null) {
                m317 = C0355.m360(c0348.m318());
            } else if (c0348.m316() != null) {
                m317 = c0348.m316().toString();
            } else if (c0348.m317() != null) {
                m317 = c0348.m317();
            } else {
                bArr = null;
                if (bArr != null && bArr.length > 0) {
                    m304.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                    OutputStream outputStream = m304.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                }
                if (m304.getResponseCode() != 200) {
                    inputStream2 = m304.getInputStream();
                    try {
                        try {
                            C0374.m389(WeaponHI.mContext).m405(C0374.f295, m304.getDate() - System.currentTimeMillis());
                        } catch (Exception unused) {
                        }
                        try {
                            byteArrayOutputStream = new ByteArrayOutputStream();
                        } catch (Exception unused2) {
                            byteArrayOutputStream = null;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused3) {
                                    str = null;
                                    if (z) {
                                        return str;
                                    }
                                    return null;
                                }
                            }
                            if (inputStream2 != null) {
                                str = null;
                                inputStream2.close();
                                if (z) {
                                }
                            }
                            str = null;
                            if (z) {
                            }
                        }
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        th = th;
                        inputStream2 = inputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception unused4) {
                                throw th;
                            }
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
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
                            byteArrayOutputStream.write(bArr2, 0, read);
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
            }
            bArr = m317.getBytes();
            if (bArr != null) {
                m304.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                OutputStream outputStream2 = m304.getOutputStream();
                outputStream2.write(bArr);
                outputStream2.flush();
                outputStream2.close();
            }
            if (m304.getResponseCode() != 200) {
            }
            if (byteArrayOutputStream != null) {
            }
        } catch (Exception unused7) {
            inputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m311(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            try {
                StringBuilder sb = new StringBuilder();
                Iterator<String> keys = jSONObject.keys();
                if (jSONObject != null) {
                    String str = "";
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = jSONObject.getString(next);
                        sb.append(str);
                        sb.append(next);
                        sb.append("=");
                        sb.append(string);
                        str = ParamableElem.DIVIDE_PARAM;
                    }
                    return sb.toString();
                }
            } catch (Exception unused) {
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kuaishou.weapon.p0.InterfaceC0352
    /* renamed from: ʻ  reason: contains not printable characters */
    public void mo312(C0348 c0348, InterfaceC0353 interfaceC0353) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c0348, interfaceC0353) == null) {
            m313(c0348, interfaceC0353, "POST");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00de A[Catch: Exception -> 0x00e1, TRY_LEAVE, TryCatch #9 {Exception -> 0x00e1, blocks: (B:61:0x00d9, B:63:0x00de), top: B:96:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m313(C0348 c0348, InterfaceC0353 interfaceC0353, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream3;
        String str2;
        byte[] bArr;
        String m317;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLLL(1048579, this, c0348, interfaceC0353, str) != null) {
            return;
        }
        boolean z = false;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        r1 = null;
        r1 = null;
        String str3 = null;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            HttpURLConnection m304 = m304(c0348.f155, str);
            String str4 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str4) && m304 != null) {
                m304.setRequestProperty("Cookie", str4);
            }
            String str5 = WeaponHI.encryENV;
            if (!TextUtils.isEmpty(str5) && m304 != null) {
                m304.setRequestProperty("env", str5);
            }
            if (str.equalsIgnoreCase("post")) {
                if (c0348.m318() != null) {
                    m317 = C0355.m360(c0348.m318());
                } else if (c0348.m316() != null) {
                    m317 = c0348.m316().toString();
                } else if (c0348.m317() != null) {
                    m317 = c0348.m317();
                } else {
                    bArr = null;
                    if (bArr != null && bArr.length > 0) {
                        m304.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                        OutputStream outputStream = m304.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.flush();
                        outputStream.close();
                    }
                }
                bArr = m317.getBytes();
                if (bArr != null) {
                    m304.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                    OutputStream outputStream2 = m304.getOutputStream();
                    outputStream2.write(bArr);
                    outputStream2.flush();
                    outputStream2.close();
                }
            }
            if (m304.getResponseCode() == 200) {
                inputStream2 = m304.getInputStream();
                try {
                    try {
                        C0374.m389(WeaponHI.mContext).m405(C0374.f295, m304.getDate() - System.currentTimeMillis());
                    } catch (Throwable th2) {
                        inputStream = inputStream2;
                        th = th2;
                        InputStream inputStream4 = inputStream;
                        th = th;
                        inputStream2 = inputStream4;
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
                        }
                    }
                    if (inputStream2 == null) {
                        inputStream3 = inputStream2;
                        inputStream3.close();
                        if (z) {
                        }
                    } else if (z) {
                    }
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
                    String byteArrayOutputStream4 = byteArrayOutputStream.toString();
                    z = true;
                    inputStream3 = inputStream2;
                    str2 = byteArrayOutputStream4;
                    byteArrayOutputStream3 = byteArrayOutputStream;
                } catch (Exception unused5) {
                    if (byteArrayOutputStream != null) {
                    }
                    if (inputStream2 == null) {
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
                str2 = null;
                inputStream3 = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.close();
                } catch (Exception unused6) {
                }
            }
        } catch (Exception unused7) {
            inputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
        if (inputStream3 != null) {
            str3 = str2;
            inputStream3.close();
            if (z) {
                if (interfaceC0353 != null) {
                    interfaceC0353.mo239(str3);
                    return;
                }
                return;
            } else if (interfaceC0353 != null) {
                interfaceC0353.mo240(str3);
                return;
            } else {
                return;
            }
        }
        str3 = str2;
        if (z) {
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m314(String str, File file) {
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
            httpURLConnection = m304(str, "GET");
            try {
                inputStream = m303(httpURLConnection);
                boolean m308 = m308(inputStream, file);
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
                return m308;
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

    @Override // com.kuaishou.weapon.p0.InterfaceC0352
    /* renamed from: ʼ  reason: contains not printable characters */
    public void mo315(C0348 c0348, InterfaceC0353 interfaceC0353) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, c0348, interfaceC0353) == null) {
            m313(c0348, interfaceC0353, "GET");
        }
    }
}
