package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidubce.AbstractBceClient;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.n;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {
    public static final Pattern c = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String a = "UTF-8";
    public static OkHttpClient d = null;
    public static OkHttpClient b = b();

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", n.c());
            url.addHeader("BrowserUa", n.d());
            url.addHeader("SystemUa", n.a());
            a(url, map);
            b(url, map2);
            Response execute = a().newCall(url.build()).execute();
            int code = execute.code();
            cVar.a = code;
            cVar.b = code;
            cVar.d = a(execute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", n.c());
            url.addHeader("BrowserUa", n.d());
            url.addHeader("SystemUa", n.a());
            a(url, map);
            a(url, jSONObject);
            Response execute = a().newCall(url.build()).execute();
            int code = execute.code();
            cVar.a = code;
            cVar.b = code;
            cVar.d = a(execute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", n.c());
            url.addHeader("BrowserUa", n.d());
            url.addHeader("SystemUa", n.a());
            a(url, map);
            Response execute = a().newCall(url.build()).execute();
            int code = execute.code();
            cVar.a = code;
            cVar.b = code;
            cVar.d = z ? a(execute) : "";
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.b.a(e);
            return "";
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0068 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.Reader, java.io.InputStreamReader] */
    public static String a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
        ?? r4;
        InputStream inputStream3;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = response.body().byteStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
            inputStream2 = null;
        }
        try {
            List<String> headers = response.headers("Content-Encoding");
            boolean z = false;
            if (headers != null) {
                Iterator<String> it = headers.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if ("gzip".equalsIgnoreCase(it.next())) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                inputStream3 = new GZIPInputStream(inputStream);
                inputStream2 = inputStream3;
            } else {
                inputStream2 = null;
                inputStream3 = inputStream;
            }
            try {
                r4 = new InputStreamReader(inputStream3, a);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(r4, 8);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                com.kwad.sdk.crash.utils.b.a(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.a((Closeable) r4);
                                com.kwad.sdk.crash.utils.b.a(inputStream2);
                                com.kwad.sdk.crash.utils.b.a(inputStream);
                                return sb.toString();
                            }
                            sb.append(readLine);
                        } catch (Throwable th2) {
                            bufferedReader = bufferedReader2;
                            th = th2;
                            com.kwad.sdk.crash.utils.b.a(bufferedReader);
                            com.kwad.sdk.crash.utils.b.a((Closeable) r4);
                            com.kwad.sdk.crash.utils.b.a(inputStream2);
                            com.kwad.sdk.crash.utils.b.a(inputStream);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                r4 = 0;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream2 = null;
            r4 = inputStream2;
            com.kwad.sdk.crash.utils.b.a(bufferedReader);
            com.kwad.sdk.crash.utils.b.a((Closeable) r4);
            com.kwad.sdk.crash.utils.b.a(inputStream2);
            com.kwad.sdk.crash.utils.b.a(inputStream);
            throw th;
        }
    }

    public static OkHttpClient a() {
        if (com.kwad.b.kwai.a.b.booleanValue()) {
            if (d == null) {
                d = b.newBuilder().build();
            }
            return d;
        }
        return b;
    }

    public static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.c = exc;
        if (cVar.b == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = c.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.b = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            f fVar = f.a;
            cVar.a = fVar.p;
            cVar.d = fVar.q;
        } else {
            cVar.a = f.b.p;
            try {
                cVar.d = f.b.q + "/n" + Log.getStackTraceString(exc);
            } catch (Exception unused2) {
            }
        }
        if (com.kwad.b.kwai.a.b.booleanValue()) {
            com.kwad.sdk.core.d.b.b(exc);
        }
    }

    public static void a(Request.Builder builder, @Nullable Map<String, String> map) {
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

    public static OkHttpClient b() {
        if (b == null) {
            OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().connectTimeout(3000L, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).connectionSpecs(Collections.singletonList(ConnectionSpec.MODERN_TLS));
            try {
                connectionSpecs.dns(new c());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.a(th);
            }
            b = connectionSpecs.build();
        }
        return b;
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
