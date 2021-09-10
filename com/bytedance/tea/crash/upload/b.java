package com.bytedance.tea.crash.upload;

import android.text.TextUtils;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import c.b.c.b.l;
import c.b.c.b.m;
import c.b.c.b.n.d;
import c.b.c.b.n.e;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68917a;

    /* renamed from: b  reason: collision with root package name */
    public static c.b.c.b.n.b f68918b;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f68919a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f68920b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f68921c;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ a[] f68922e;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public final int f68923d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1937383323, "Lcom/bytedance/tea/crash/upload/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1937383323, "Lcom/bytedance/tea/crash/upload/b$a;");
                    return;
                }
            }
            f68919a = new a("NONE", 0, 0);
            f68920b = new a("GZIP", 1, 1);
            a aVar = new a("DEFLATER", 2, 2);
            f68921c = aVar;
            f68922e = new a[]{f68919a, f68920b, aVar};
        }

        public a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f68923d = i3;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f68922e.clone() : (a[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.bytedance.tea.crash.upload.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class EnumC1935b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC1935b f68924a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1935b f68925b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1935b f68926c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC1935b f68927d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC1935b f68928e;

        /* renamed from: f  reason: collision with root package name */
        public static final EnumC1935b f68929f;

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ EnumC1935b[] f68930h;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final int f68931g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1937383292, "Lcom/bytedance/tea/crash/upload/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1937383292, "Lcom/bytedance/tea/crash/upload/b$b;");
                    return;
                }
            }
            f68924a = new EnumC1935b("NONE", 0, 0);
            f68925b = new EnumC1935b("MOBILE", 1, 1);
            f68926c = new EnumC1935b("MOBILE_2G", 2, 2);
            f68927d = new EnumC1935b("MOBILE_3G", 3, 3);
            f68928e = new EnumC1935b(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 4, 4);
            EnumC1935b enumC1935b = new EnumC1935b("MOBILE_4G", 5, 5);
            f68929f = enumC1935b;
            f68930h = new EnumC1935b[]{f68924a, f68925b, f68926c, f68927d, f68928e, enumC1935b};
        }

        public EnumC1935b(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f68931g = i3;
        }

        public static EnumC1935b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1935b) Enum.valueOf(EnumC1935b.class, str) : (EnumC1935b) invokeL.objValue;
        }

        public static EnumC1935b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1935b[]) f68930h.clone() : (EnumC1935b[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1110831938, "Lcom/bytedance/tea/crash/upload/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1110831938, "Lcom/bytedance/tea/crash/upload/b;");
        }
    }

    public static e a(long j2, String str, byte[] bArr, a aVar, String str2, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j2), str, bArr, aVar, str2, Boolean.valueOf(z)})) == null) {
            if (str == null) {
                return new e(201);
            }
            if (bArr == null) {
                bArr = new byte[0];
            }
            int length = bArr.length;
            String str3 = null;
            if (a.f68920b == aVar && length > 128) {
                bArr = l(bArr);
                str3 = AsyncHttpClient.ENCODING_GZIP;
            } else if (a.f68921c == aVar && length > 128) {
                bArr = i(bArr);
                str3 = "deflate";
            }
            String str4 = str3;
            byte[] bArr2 = bArr;
            if (bArr2 == null) {
                return new e(202);
            }
            if (z) {
                byte[] a2 = TTEncryptUtils.a(bArr2, bArr2.length);
                if (a2 != null) {
                    if (TextUtils.isEmpty(new URL(str).getQuery())) {
                        if (!str.endsWith("?")) {
                            str = str + "?";
                        }
                    } else if (!str.endsWith("&")) {
                        str = str + "&";
                    }
                    str = str + "tt_data=a";
                    str2 = "application/octet-stream;tt-data=a";
                    bArr2 = a2;
                }
                return e(str, bArr2, str2, str4, "POST", true, true);
            }
            return e(str, bArr2, str2, str4, "POST", true, false);
        }
        return (e) invokeCommon.objValue;
    }

    public static e b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) ? d(str, str2, k()) : (e) invokeLL.objValue;
    }

    public static e c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            try {
                d dVar = new d(str, "UTF-8", true);
                dVar.c("json", str2);
                dVar.b("file", new File(str3));
                String a2 = dVar.a();
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    if ("succ".equals(jSONObject.optString("succ_kind"))) {
                        return new e(0, jSONObject);
                    }
                    return new e(204, a2);
                } catch (JSONException e2) {
                    return new e(205, e2);
                }
            } catch (IOException e3) {
                e3.printStackTrace();
                return new e(207);
            }
        }
        return (e) invokeLLL.objValue;
    }

    public static e d(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, z)) == null) {
            try {
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    return a(2097152L, str, str2.getBytes(), a.f68920b, "application/json; charset=utf-8", z);
                }
                return new e(201);
            } catch (Throwable th) {
                l.k.c(th);
                return new e(207, th);
            }
        }
        return (e) invokeLLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0115 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e e(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        InputStream inputStream;
        URL url;
        byte[] h2;
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{str, bArr, str2, str3, str4, Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (e) invokeCommon.objValue;
        }
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            if (f68918b != null) {
                str = f68918b.a(str, bArr);
            }
            LinkedList<Pair> linkedList = new LinkedList();
            if (z2) {
                url = new URL(c.b.c.a.a.a.a.c(str, linkedList));
            } else {
                url = new URL(str);
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            if (z2) {
                try {
                    if (!linkedList.isEmpty()) {
                        for (Pair pair : linkedList) {
                            if (pair != null) {
                                httpURLConnection2.setRequestProperty((String) pair.first, (String) pair.second);
                            }
                        }
                    }
                } catch (Throwable th) {
                    httpURLConnection = httpURLConnection2;
                    th = th;
                    inputStream = null;
                    try {
                        l.k.c(th);
                        return new e(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        l.g.a(inputStream);
                    }
                }
            }
            if (z) {
                httpURLConnection2.setDoOutput(true);
            } else {
                httpURLConnection2.setDoOutput(false);
            }
            if (str2 != null) {
                httpURLConnection2.setRequestProperty("Content-Type", str2);
            }
            if (str3 != null) {
                httpURLConnection2.setRequestProperty("Content-Encoding", str3);
            }
            httpURLConnection2.setRequestProperty("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
            if (str4 != null) {
                httpURLConnection2.setRequestMethod(str4);
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            l.g.a(dataOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            l.g.a(dataOutputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        dataOutputStream = null;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 200) {
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                            try {
                                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                                try {
                                    h2 = h(gZIPInputStream2);
                                    l.g.a(gZIPInputStream2);
                                } catch (Throwable th4) {
                                    th = th4;
                                    gZIPInputStream = gZIPInputStream2;
                                    l.g.a(gZIPInputStream);
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } else {
                            h2 = h(inputStream);
                        }
                        e m = m(h2);
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        l.g.a(inputStream);
                        return m;
                    } catch (Throwable th6) {
                        httpURLConnection = httpURLConnection2;
                        th = th6;
                        l.k.c(th);
                        return new e(207, th);
                    }
                }
                e eVar = new e(206, "http response code " + responseCode);
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception unused3) {
                    }
                }
                l.g.a(null);
                return eVar;
            }
            throw new IllegalArgumentException("request method is not null");
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    public static String f(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, map)) == null) ? m.f().a() : (String) invokeL.objValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static byte[] h(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65544, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    l.g.a(byteArrayOutputStream);
                }
            }
        }
    }

    public static byte[] i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[8192];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        }
        return (byte[]) invokeL.objValue;
    }

    public static e j(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, str, str2)) == null) ? d(str, str2, g()) : (e) invokeLL.objValue;
    }

    public static boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public static byte[] l(byte[] bArr) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                try {
                    l.k.c(th);
                    return null;
                } finally {
                    gZIPOutputStream.close();
                }
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public static e m(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, bArr)) == null) {
            if (bArr != null && bArr.length != 0) {
                String str = new String(bArr, Charset.forName("utf-8"));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.length() > 0) {
                        return new e(0, jSONObject);
                    }
                    return new e(204, str);
                } catch (JSONException unused) {
                    return new e(204, str);
                }
            }
            return new e(203);
        }
        return (e) invokeL.objValue;
    }
}
