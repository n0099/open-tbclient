package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static c a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, map)) == null) {
            StringBuilder sb = new StringBuilder();
            c cVar = new c();
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                a(httpURLConnection, map);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Accept", "application/json");
                httpURLConnection.setRequestProperty("User-Agent", k.a());
                cVar.f36355a = httpURLConnection.getResponseCode();
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
            } catch (MalformedURLException | IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
            cVar.f36356b = sb.toString();
            return cVar;
        }
        return (c) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
                try {
                    httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                } catch (IOException e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = null;
            } catch (Throwable th) {
                th = th;
                outputStream = null;
            }
            try {
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
                cVar.f36355a = responseCode;
                if (responseCode == 200) {
                    cVar.f36356b = a(httpURLConnection.getInputStream());
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Exception e4) {
                e = e4;
                OutputStream outputStream3 = outputStream2;
                httpURLConnection2 = httpURLConnection;
                outputStream = outputStream3;
                try {
                    com.kwad.sdk.core.d.a.a(e);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return cVar;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            com.kwad.sdk.core.d.a.a(e5);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                OutputStream outputStream4 = outputStream2;
                httpURLConnection2 = httpURLConnection;
                outputStream = outputStream4;
                if (httpURLConnection2 != null) {
                }
                if (outputStream != null) {
                }
                throw th;
            }
            if (outputStream2 != null) {
                outputStream2.close();
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

    public static String a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (IOException e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e3) {
                                com.kwad.sdk.core.d.a.a(e3);
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                            return null;
                        } catch (IOException e4) {
                            com.kwad.sdk.core.d.a.a(e4);
                            return null;
                        }
                    }
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            com.kwad.sdk.core.d.a.a(e5);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        com.kwad.sdk.core.d.a.a(e6);
                    }
                }
            }
            return new String(byteArrayOutputStream.toByteArray());
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
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

    public static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, httpURLConnection, map) == null) || map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
