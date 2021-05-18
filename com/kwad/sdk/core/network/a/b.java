package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.baidu.down.loopj.android.http.AsyncHttpClient;
import com.baidubce.AbstractBceClient;
import com.kwad.sdk.core.network.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f32459a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f32460b = new OkHttpClient.Builder().connectTimeout(3000, TimeUnit.MILLISECONDS).readTimeout(6000, TimeUnit.MILLISECONDS).connectionSpecs(Collections.singletonList(ConnectionSpec.MODERN_TLS)).build();

    public static String a(String str) {
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0063 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:37:0x000e */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.zip.GZIPInputStream */
    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: java.util.zip.GZIPInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static String a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
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
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, f32459a), 8);
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
        return f32460b;
    }

    public static Response a(String str, Map<String, String> map) {
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", k.a());
            a(url, map);
            return a().newCall(url.build()).execute();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Response a(String str, Map<String, String> map, Map<String, String> map2) {
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

    public static Response a(String str, Map<String, String> map, JSONObject jSONObject) {
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

    public static void a(Request.Builder builder, Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
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
        builder.post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString()));
    }

    public static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
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
