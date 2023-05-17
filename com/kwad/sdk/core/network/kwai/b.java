package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidubce.AbstractBceClient;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
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
/* loaded from: classes9.dex */
public final class b {
    public static final Pattern YW = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String YX = "UTF-8";
    public static OkHttpClient YY = null;
    public static OkHttpClient YZ = tG();

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", o.getUserAgent());
            url.addHeader("BrowserUa", o.tD());
            url.addHeader("SystemUa", o.tC());
            a(url, map);
            Response execute = tF().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.XT = code;
            cVar.XV = z ? a(execute) : "";
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
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
                r4 = new InputStreamReader(inputStream3, YX);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(r4, 8);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                return sb.toString();
                            }
                            sb.append(readLine);
                        } catch (Throwable th2) {
                            bufferedReader = bufferedReader2;
                            th = th2;
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
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
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
    }

    public static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.XU = exc;
        if (cVar.XT == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = YW.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.XT = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            f fVar = f.XY;
            cVar.code = fVar.errorCode;
            cVar.XV = fVar.Qd;
        } else {
            cVar.code = f.XZ.errorCode;
            try {
                cVar.XV = f.XZ.Qd + "/n" + Log.getStackTraceString(exc);
            } catch (Exception unused2) {
            }
        }
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            com.kwad.sdk.core.e.b.printStackTraceOnly(exc);
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

    public static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        if (map == null || map.isEmpty()) {
            formBody = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
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

    public static com.kwad.sdk.core.network.c doGet(String str, @Nullable Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", o.getUserAgent());
            url.addHeader("BrowserUa", o.tD());
            url.addHeader("SystemUa", o.tC());
            a(url, map);
            b(url, map2);
            Response execute = tF().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.XT = code;
            cVar.XV = a(execute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            url.addHeader("User-Agent", o.getUserAgent());
            url.addHeader("BrowserUa", o.tD());
            url.addHeader("SystemUa", o.tC());
            a(url, map);
            a(url, jSONObject);
            Response execute = tF().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.XT = code;
            cVar.XV = a(execute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
            return "";
        }
    }

    public static OkHttpClient tF() {
        if (com.kwad.b.kwai.a.aw.booleanValue()) {
            if (YY == null) {
                YY = YZ.newBuilder().build();
            }
            return YY;
        }
        return YZ;
    }

    public static OkHttpClient tG() {
        if (YZ == null) {
            OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().connectTimeout(3000L, TimeUnit.MILLISECONDS).readTimeout(LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, TimeUnit.MILLISECONDS).connectionSpecs(Collections.singletonList(ConnectionSpec.MODERN_TLS));
            try {
                connectionSpecs.dns(new c());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.b.printStackTrace(th);
            }
            YZ = connectionSpecs.build();
        }
        return YZ;
    }
}
