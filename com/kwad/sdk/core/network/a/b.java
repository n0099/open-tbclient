package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidubce.AbstractBceClient;
import com.kwad.sdk.core.network.k;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f9316a = "UTF-8";

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f9317b = new OkHttpClient.Builder().connectTimeout(IMConnection.RETRY_DELAY_TIMES, TimeUnit.MILLISECONDS).readTimeout(6000, TimeUnit.MILLISECONDS).build();

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.a.a(e);
            return "";
        }
    }

    public static String a(Response response) {
        GZIPInputStream gZIPInputStream;
        InputStream inputStream;
        boolean z;
        GZIPInputStream gZIPInputStream2;
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                if (headers != null) {
                    for (String str : headers) {
                        if (str != null && "gzip".equalsIgnoreCase(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    GZIPInputStream gZIPInputStream3 = new GZIPInputStream(inputStream);
                    gZIPInputStream = gZIPInputStream3;
                    gZIPInputStream2 = gZIPInputStream3;
                } else {
                    gZIPInputStream = null;
                    gZIPInputStream2 = inputStream;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream2, f9316a), 8);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return sb.toString();
                } catch (Throwable th) {
                    th = th;
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = null;
            inputStream = null;
        }
    }

    public static OkHttpClient a() {
        return f9317b;
    }

    public static Response a(String str, Map<String, String> map) {
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", k.a());
            a(url, map);
            return a().newCall(url.build()).execute();
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
                } catch (Exception e) {
                }
            }
        }
    }

    public static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString()));
    }

    public static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody = null;
        if (map != null && !map.isEmpty()) {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), a(entry.getValue()));
                    } catch (Exception e) {
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
