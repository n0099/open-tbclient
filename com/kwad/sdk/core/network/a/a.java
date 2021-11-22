package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, map)) == null) ? a(str, map, true) : (c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str, Map<String, String> map, String str2, boolean z) {
        InterceptResult invokeCommon;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, map, str2, Boolean.valueOf(z)})) == null) {
            c cVar = new c();
            HttpURLConnection httpURLConnection2 = null;
            r1 = null;
            r1 = null;
            OutputStream outputStream2 = null;
            httpURLConnection2 = null;
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Exception e2) {
                e = e2;
                outputStream = null;
            } catch (Throwable th) {
                th = th;
                outputStream = null;
            }
            try {
                l.a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-Type", z ? "application/json" : "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("User-Agent", k.a());
                a(httpURLConnection, map);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream2 = httpURLConnection.getOutputStream();
                    outputStream2.write(str2.getBytes());
                    outputStream2.flush();
                }
                int responseCode = httpURLConnection.getResponseCode();
                cVar.f65710a = responseCode;
                if (responseCode == 200) {
                    cVar.f65711b = a(httpURLConnection.getInputStream());
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                com.kwad.sdk.crash.utils.b.a(outputStream2);
            } catch (Exception e3) {
                e = e3;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection2 = httpURLConnection;
                outputStream = outputStream3;
                try {
                    a(cVar, e);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.a(outputStream);
                    return cVar;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.a(outputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                OutputStream outputStream4 = outputStream2;
                httpURLConnection2 = httpURLConnection;
                outputStream = outputStream4;
                if (httpURLConnection2 != null) {
                }
                com.kwad.sdk.crash.utils.b.a(outputStream);
                throw th;
            }
            return cVar;
        }
        return (c) invokeCommon.objValue;
    }

    public static c a(String str, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, map, map2)) == null) {
            if (map2 != null) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : map2.entrySet()) {
                    String a2 = a(entry.getValue());
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(a2);
                    sb.append("&");
                }
                str2 = sb.substring(0, sb.length() - 1);
            } else {
                str2 = null;
            }
            return a(str, map, str2, false);
        }
        return (c) invokeLLL.objValue;
    }

    public static c a(String str, Map<String, String> map, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, map, jSONObject)) == null) {
            return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
        }
        return (c) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str, Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, map, z)) == null) {
            c cVar = new c();
            HttpURLConnection httpURLConnection = null;
            r1 = null;
            r1 = null;
            InputStream inputStream2 = null;
            httpURLConnection = null;
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    l.a(httpURLConnection2);
                    a(httpURLConnection2, map);
                    httpURLConnection2.setRequestMethod("GET");
                    httpURLConnection2.setRequestProperty("Accept", "application/json");
                    httpURLConnection2.setRequestProperty("User-Agent", k.a());
                    cVar.f65710a = httpURLConnection2.getResponseCode();
                    StringBuilder sb = new StringBuilder();
                    if (z) {
                        inputStream2 = httpURLConnection2.getInputStream();
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            sb.append(new String(bArr, 0, read));
                        }
                    }
                    cVar.f65711b = sb.toString();
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    com.kwad.sdk.crash.utils.b.a(inputStream2);
                } catch (Exception e2) {
                    e = e2;
                    InputStream inputStream3 = inputStream2;
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream3;
                    try {
                        a(cVar, e);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        com.kwad.sdk.crash.utils.b.a(inputStream);
                        return cVar;
                    } catch (Throwable th) {
                        th = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        com.kwad.sdk.crash.utils.b.a(inputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    InputStream inputStream4 = inputStream2;
                    httpURLConnection = httpURLConnection2;
                    inputStream = inputStream4;
                    if (httpURLConnection != null) {
                    }
                    com.kwad.sdk.crash.utils.b.a(inputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
            return cVar;
        }
        return (c) invokeLLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, inputStream)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    String str = new String(byteArrayOutputStream.toByteArray());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            com.kwad.sdk.core.d.a.a(e2);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        com.kwad.sdk.core.d.a.a(e3);
                    }
                    return str;
                } catch (IOException e4) {
                    e = e4;
                    com.kwad.sdk.core.d.a.a(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            com.kwad.sdk.core.d.a.a(e5);
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e6) {
                            com.kwad.sdk.core.d.a.a(e6);
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        com.kwad.sdk.core.d.a.a(e7);
                    }
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        com.kwad.sdk.core.d.a.a(e8);
                    }
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
            if (inputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void a(@NonNull c cVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, cVar, exc) == null) {
            f fVar = exc instanceof SocketTimeoutException ? f.f65713a : f.f65714b;
            cVar.f65710a = fVar.m;
            cVar.f65711b = fVar.n;
            if (com.kwad.sdk.b.f64912b.booleanValue()) {
                com.kwad.sdk.core.d.a.b(exc);
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, httpURLConnection, map) == null) || map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
