package com.kwad.sdk.core.network.a;

import android.net.http.Headers;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidubce.AbstractBceClient;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bn;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
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
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http2.Http2Codec;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c {
    public static final Pattern auo = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String aup = "UTF-8";
    public static OkHttpClient auq = null;
    public static OkHttpClient aur = CI();

    public static OkHttpClient CH() {
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            if (auq == null) {
                auq = aur.newBuilder().build();
            }
            return auq;
        }
        return aur;
    }

    public static OkHttpClient CI() {
        if (aur == null) {
            OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().connectTimeout(3000L, TimeUnit.MILLISECONDS).readTimeout(LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, TimeUnit.MILLISECONDS).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                connectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
            aur = connectionSpecs.build();
        }
        return aur;
    }

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z) {
        String str2;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            Response execute = CH().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.atk = code;
            if (z) {
                str2 = a(execute);
            } else {
                str2 = "";
            }
            cVar.atm = str2;
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            b(url, map2);
            Response execute = CH().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.atk = code;
            cVar.atm = a(execute);
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
                r4 = new InputStreamReader(inputStream3, aup);
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(r4, 8);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r4);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                return sb.toString();
                            }
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
        cVar.atl = exc;
        if (cVar.atk == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = auo.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.atk = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.atn;
            cVar.code = eVar.errorCode;
            cVar.atm = eVar.msg;
        } else {
            cVar.code = e.ato.errorCode;
            cVar.atm = e.ato.msg + "/" + bn.s(exc);
        }
        if (com.kwad.framework.a.a.mc.booleanValue()) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(exc);
        }
    }

    public static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", p.getUserAgent());
        builder.addHeader("BrowserUa", p.CE());
        builder.addHeader("SystemUa", p.CD());
    }

    public static long b(Response response) {
        try {
            return Long.parseLong(response.header(Headers.CONTENT_LEN));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            return "";
        }
    }

    public static void a(Request.Builder builder, @Nullable Map<String, String> map) {
        if (builder != null && map != null && !map.isEmpty()) {
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
    }

    public static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString()));
    }

    public static com.kwad.sdk.core.network.c doGet(String str, @Nullable Map<String, String> map) {
        return a(str, map, true);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.io.BufferedInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Response response, OutputStream outputStream, long j, AdHttpResponseListener adHttpResponseListener) {
        Throwable th;
        Closeable closeable;
        InputStream inputStream;
        InputStream inputStream2;
        boolean z;
        InputStream inputStream3;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                long b = b(response);
                if (headers != null) {
                    for (String str : headers) {
                        if ("gzip".equalsIgnoreCase(str)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                if (z) {
                    inputStream3 = new GZIPInputStream(inputStream);
                    inputStream2 = inputStream3;
                } else {
                    inputStream2 = null;
                    inputStream3 = inputStream;
                }
                try {
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream3);
                    try {
                        byte[] bArr = new byte[1024];
                        long j2 = 0;
                        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                        if (i > 0) {
                            do {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                j2 += read;
                                AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, b);
                            } while (j2 <= j);
                        } else if (i < 0) {
                            if (outputStream != null) {
                                bufferedOutputStream = new BufferedOutputStream(outputStream);
                            }
                            while (true) {
                                int read2 = bufferedInputStream.read(bArr);
                                if (read2 == -1) {
                                    break;
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.write(bArr, 0, read2);
                                }
                                j2 += read2;
                                if (AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j2, b)) {
                                    break;
                                }
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.flush();
                            }
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = null;
                        bufferedOutputStream = bufferedInputStream;
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedOutputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                        com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = null;
                }
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                inputStream2 = null;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStream = null;
            inputStream2 = null;
        }
    }

    public static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        if (map != null && !map.isEmpty()) {
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
        } else {
            formBody = null;
        }
        if (builder != null && formBody != null) {
            builder.post(formBody);
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder post = new Request.Builder().url(str).post(type.build());
            a(post, map);
            Response execute = CH().newCall(post.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.atk = code;
            cVar.atm = a(execute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            a(url, jSONObject);
            Response execute = CH().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.atk = code;
            cVar.atm = a(execute);
        } catch (Exception e) {
            a(cVar, e);
        }
        return cVar;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j, @Nullable AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder url = new Request.Builder().url(str);
        HashMap hashMap = new HashMap();
        hashMap.put("Accept-Language", "zh-CN");
        hashMap.put(HTTP.CONN_DIRECTIVE, Http2Codec.KEEP_ALIVE);
        hashMap.put(BOSTokenRequest.CHARSET, "UTF-8");
        a(url);
        a(url, hashMap);
        Response execute = CH().newCall(url.build()).execute();
        int code = execute.code();
        cVar.code = code;
        cVar.atk = code;
        if (execute.code() == 200) {
            a(execute, outputStream, j, adHttpResponseListener);
            return true;
        }
        throw new FileNotFoundException(str);
    }
}
