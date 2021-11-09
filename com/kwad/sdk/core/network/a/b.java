package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidubce.AbstractBceClient;
import com.kwad.sdk.core.network.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f64779a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f64780b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-360684867, "Lcom/kwad/sdk/core/network/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-360684867, "Lcom/kwad/sdk/core/network/a/b;");
                return;
            }
        }
        f64780b = new OkHttpClient.Builder().connectTimeout(3000L, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).connectionSpecs(Collections.singletonList(ConnectionSpec.MODERN_TLS)).build();
    }

    public static c a(String str, @Nullable Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) ? a(str, map, true) : (c) invokeLL.objValue;
    }

    public static c a(String str, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, map, map2)) == null) {
            c cVar = new c();
            try {
                Request.Builder url = new Request.Builder().url(str);
                url.addHeader("User-Agent", k.a());
                a(url, map);
                b(url, map2);
                Response execute = a().newCall(url.build()).execute();
                cVar.f64797a = execute.code();
                cVar.f64798b = a(execute);
            } catch (Exception e2) {
                a(cVar, e2);
            }
            return cVar;
        }
        return (c) invokeLLL.objValue;
    }

    public static c a(String str, Map<String, String> map, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, map, jSONObject)) == null) {
            c cVar = new c();
            try {
                Request.Builder url = new Request.Builder().url(str);
                url.addHeader("User-Agent", k.a());
                a(url, map);
                a(url, jSONObject);
                Response execute = a().newCall(url.build()).execute();
                cVar.f64797a = execute.code();
                cVar.f64798b = a(execute);
            } catch (Exception e2) {
                a(cVar, e2);
            }
            return cVar;
        }
        return (c) invokeLLL.objValue;
    }

    public static c a(String str, @Nullable Map<String, String> map, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, map, z)) == null) {
            c cVar = new c();
            try {
                Request.Builder url = new Request.Builder().url(str);
                url.addHeader("User-Agent", k.a());
                a(url, map);
                Response execute = a().newCall(url.build()).execute();
                cVar.f64797a = execute.code();
                cVar.f64798b = z ? a(execute) : "";
            } catch (Exception e2) {
                a(cVar, e2);
            }
            return cVar;
        }
        return (c) invokeLLZ.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0065 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x0012 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v7, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v8, resolved type: java.util.zip.GZIPInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static String a(Response response) {
        InterceptResult invokeL;
        InputStream inputStream;
        InputStream inputStream2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, response)) != null) {
            return (String) invokeL.objValue;
        }
        StringBuilder sb = new StringBuilder();
        GZIPInputStream gZIPInputStream = 0;
        gZIPInputStream = 0;
        gZIPInputStream = 0;
        try {
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                boolean z = false;
                if (headers != null) {
                    Iterator<String> it = headers.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(it.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    inputStream2 = new GZIPInputStream(inputStream);
                    gZIPInputStream = inputStream2;
                } else {
                    inputStream2 = inputStream;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, f64779a), 8);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                if (gZIPInputStream != 0) {
                    gZIPInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return sb.toString();
            } catch (Throwable th) {
                th = th;
                if (gZIPInputStream != 0) {
                    gZIPInputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f64780b : (OkHttpClient) invokeV.objValue;
    }

    public static void a(@NonNull c cVar, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, cVar, exc) == null) {
            f fVar = exc instanceof SocketTimeoutException ? f.f64800a : f.f64801b;
            cVar.f64797a = fVar.m;
            cVar.f64798b = fVar.n;
            if (com.kwad.sdk.b.f63999b.booleanValue()) {
                com.kwad.sdk.core.d.a.b(exc);
            }
        }
    }

    public static void a(Request.Builder builder, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65545, null, builder, map) == null) || builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void a(Request.Builder builder, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, builder, jSONObject) == null) {
            builder.post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString()));
        }
    }

    public static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, builder, map) == null) {
            if (map == null || map.isEmpty()) {
                formBody = null;
            } else {
                FormBody.Builder builder2 = new FormBody.Builder();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null) {
                        try {
                            builder2.addEncoded(entry.getKey(), a(entry.getValue()));
                        } catch (Exception unused) {
                        }
                    }
                }
                formBody = builder2.build();
            }
            if (builder == null || formBody == null) {
                return;
            }
            builder.post(formBody);
        }
    }
}
