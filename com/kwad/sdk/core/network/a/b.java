package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.network.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f36351a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f36352b;
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
        f36352b = new OkHttpClient.Builder().connectTimeout(3000L, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).build();
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0067 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:43:0x0012 */
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
        if (interceptable != null && (invokeL = interceptable.invokeL(65538, null, response)) != null) {
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
                        }
                        String next = it.next();
                        if (next != null && AsyncHttpClient.ENCODING_GZIP.equalsIgnoreCase(next)) {
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, f36351a), 8);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f36352b : (OkHttpClient) invokeV.objValue;
    }

    public static Response a(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, map)) == null) {
            try {
                Request.Builder url = new Request.Builder().url(str);
                url.addHeader("User-Agent", k.a());
                a(url, map);
                return a().newCall(url.build()).execute();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Response) invokeLL.objValue;
    }

    public static Response a(String str, Map<String, String> map, Map<String, String> map2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, map, map2)) == null) {
            try {
                Request.Builder url = new Request.Builder().url(str);
                url.addHeader("User-Agent", k.a());
                a(url, map);
                b(url, map2);
                return a().newCall(url.build()).execute();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Response) invokeLLL.objValue;
    }

    public static Response a(String str, Map<String, String> map, JSONObject jSONObject) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, str, map, jSONObject)) == null) {
            try {
                Request.Builder url = new Request.Builder().url(str);
                url.addHeader("User-Agent", k.a());
                a(url, map);
                a(url, jSONObject);
                return a().newCall(url.build()).execute();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Response) invokeLLL.objValue;
    }

    public static void a(Request.Builder builder, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, builder, map) == null) || builder == null || map == null || map.isEmpty()) {
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
        if (interceptable == null || interceptable.invokeLL(65544, null, builder, jSONObject) == null) {
            builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
        }
    }

    public static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, builder, map) == null) {
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
