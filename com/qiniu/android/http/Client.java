package com.qiniu.android.http;

import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.storage.UploadManager;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Client {
    private OkHttpClient httpClient;
    private final UrlConverter nmZ;

    public Client() {
        this(null, 10, 30, null, null);
    }

    public Client(ProxyConfiguration proxyConfiguration, int i, int i2, UrlConverter urlConverter, final Dns dns) {
        OkHttpClient.Builder newBuilder;
        this.nmZ = urlConverter;
        OkHttpClient dGe = UploadManager.dGe();
        if (dGe == null) {
            newBuilder = new OkHttpClient.Builder();
        } else {
            newBuilder = dGe.newBuilder();
            newBuilder.interceptors().clear();
            newBuilder.networkInterceptors().clear();
        }
        if (proxyConfiguration != null) {
            newBuilder.proxy(proxyConfiguration.proxy());
            if (proxyConfiguration.user != null && proxyConfiguration.password != null) {
                newBuilder.proxyAuthenticator(proxyConfiguration.authenticator());
            }
        }
        if (dns != null) {
            newBuilder.dns(new okhttp3.Dns() { // from class: com.qiniu.android.http.Client.1
                @Override // okhttp3.Dns
                public List<InetAddress> lookup(String str) throws UnknownHostException {
                    try {
                        return dns.lookup(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return okhttp3.Dns.SYSTEM.lookup(str);
                    }
                }
            });
        }
        newBuilder.networkInterceptors().add(new Interceptor() { // from class: com.qiniu.android.http.Client.2
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                long currentTimeMillis = System.currentTimeMillis();
                Response proceed = chain.proceed(request);
                long currentTimeMillis2 = System.currentTimeMillis();
                ResponseTag responseTag = (ResponseTag) request.tag();
                String str = "";
                try {
                    str = chain.connection().socket().getRemoteSocketAddress().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                responseTag.ip = str;
                responseTag.duration = currentTimeMillis2 - currentTimeMillis;
                return proceed;
            }
        });
        newBuilder.connectTimeout(i, TimeUnit.SECONDS);
        newBuilder.readTimeout(i2, TimeUnit.SECONDS);
        newBuilder.writeTimeout(0L, TimeUnit.SECONDS);
        this.httpClient = newBuilder.build();
    }

    private static String e(Response response) {
        String header = response.header("X-Via", "");
        if (header.equals("")) {
            header = response.header("X-Px", "");
            if (header.equals("")) {
                header = response.header("Fw-Via", "");
                if (!header.equals("")) {
                }
            }
        }
        return header;
    }

    private static String f(Response response) {
        MediaType contentType = response.body().contentType();
        return contentType == null ? "" : contentType.type() + "/" + contentType.subtype();
    }

    private static JSONObject aD(byte[] bArr) throws Exception {
        String str = new String(bArr, "utf-8");
        return StringUtils.Rt(str) ? new JSONObject() : new JSONObject(str);
    }

    private static ResponseInfo a(Response response, String str, long j, UpToken upToken, long j2) {
        JSONObject jSONObject;
        String str2;
        Exception exc;
        JSONObject aD;
        int code = response.code();
        String header = response.header("X-Reqid");
        String str3 = header == null ? null : header.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP)[0];
        byte[] bArr = null;
        String str4 = null;
        try {
            bArr = response.body().bytes();
        } catch (IOException e) {
            str4 = e.getMessage();
        }
        if (f(response).equals("application/json") && bArr != null) {
            try {
                aD = aD(bArr);
            } catch (Exception e2) {
                jSONObject = null;
                exc = e2;
            }
            try {
                if (response.code() != 200) {
                    str4 = aD.optString(BdStatsConstant.StatsType.ERROR, new String(bArr, "utf-8"));
                }
                jSONObject = aD;
                str2 = str4;
            } catch (Exception e3) {
                jSONObject = aD;
                exc = e3;
                if (response.code() < 300) {
                    str4 = exc.getMessage();
                }
                str2 = str4;
                HttpUrl url = response.request().url();
                return ResponseInfo.a(jSONObject, code, str3, response.header("X-Log"), e(response), url.host(), url.encodedPath(), str, url.port(), j, g(response), str2, upToken, j2);
            }
        } else {
            String str5 = bArr == null ? "null body" : new String(bArr);
            jSONObject = null;
            str2 = str5;
        }
        HttpUrl url2 = response.request().url();
        return ResponseInfo.a(jSONObject, code, str3, response.header("X-Log"), e(response), url2.host(), url2.encodedPath(), str, url2.port(), j, g(response), str2, upToken, j2);
    }

    private static long g(Response response) {
        try {
            RequestBody body = response.request().body();
            if (body == null) {
                return 0L;
            }
            return body.contentLength();
        } catch (Throwable th) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(Response response, String str, long j, UpToken upToken, long j2, final CompletionHandler completionHandler) {
        final ResponseInfo a = a(response, str, j, upToken, j2);
        AsyncRun.B(new Runnable() { // from class: com.qiniu.android.http.Client.3
            @Override // java.lang.Runnable
            public void run() {
                CompletionHandler.this.a(a, a.nnw);
            }
        });
    }

    public void a(final Request.Builder builder, StringMap stringMap, final UpToken upToken, final long j, final CompletionHandler completionHandler) {
        if (stringMap != null) {
            stringMap.a(new StringMap.Consumer() { // from class: com.qiniu.android.http.Client.4
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void G(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        if (upToken != null) {
            builder.header("User-Agent", UserAgent.dFV().Rp(upToken.nmO));
        } else {
            builder.header("User-Agent", UserAgent.dFV().Rp("pandora"));
        }
        final ResponseTag responseTag = new ResponseTag();
        this.httpClient.newCall(builder.tag(responseTag).build()).enqueue(new Callback() { // from class: com.qiniu.android.http.Client.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                iOException.printStackTrace();
                int i = -1;
                String message = iOException.getMessage();
                if (iOException instanceof CancellationHandler.CancellationException) {
                    i = -2;
                } else if (iOException instanceof UnknownHostException) {
                    i = -1003;
                } else if (message != null && message.indexOf("Broken pipe") == 0) {
                    i = -1005;
                } else if (iOException instanceof SocketTimeoutException) {
                    i = MessageConfig.ERROR_TASK_OUTTIME;
                } else if (iOException instanceof ConnectException) {
                    i = -1004;
                }
                HttpUrl url = call.request().url();
                completionHandler.a(ResponseInfo.a(null, i, "", "", "", url.host(), url.encodedPath(), "", url.port(), responseTag.duration, -1L, iOException.getMessage(), upToken, j), null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseTag responseTag2 = (ResponseTag) response.request().tag();
                Client.a(response, responseTag2.ip, responseTag2.duration, upToken, j, completionHandler);
            }
        });
    }

    public void a(String str, byte[] bArr, int i, int i2, StringMap stringMap, UpToken upToken, long j, ProgressHandler progressHandler, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        CountingRequestBody create;
        Object obj;
        if (this.nmZ != null) {
            str = this.nmZ.EN(str);
        }
        if (bArr != null && bArr.length > 0) {
            MediaType parse = MediaType.parse("application/octet-stream");
            if (stringMap != null && (obj = stringMap.get("Content-Type")) != null) {
                parse = MediaType.parse(obj.toString());
            }
            create = RequestBody.create(parse, bArr, i, i2);
        } else {
            create = RequestBody.create((MediaType) null, new byte[0]);
        }
        if (progressHandler != null || cancellationHandler != null) {
            create = new CountingRequestBody(create, progressHandler, j, cancellationHandler);
        }
        a(new Request.Builder().url(str).post(create), stringMap, upToken, j, completionHandler);
    }

    public void a(String str, PostArgs postArgs, UpToken upToken, ProgressHandler progressHandler, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        RequestBody create;
        long length;
        if (postArgs.file != null) {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.file);
            length = postArgs.file.length();
        } else {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.data);
            length = postArgs.data.length;
        }
        a(str, postArgs.nno, upToken, length, progressHandler, postArgs.fileName, create, completionHandler, cancellationHandler);
    }

    private void a(String str, StringMap stringMap, UpToken upToken, long j, ProgressHandler progressHandler, String str2, RequestBody requestBody, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        if (this.nmZ != null) {
            str = this.nmZ.EN(str);
        }
        final MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("file", str2, requestBody);
        stringMap.a(new StringMap.Consumer() { // from class: com.qiniu.android.http.Client.6
            @Override // com.qiniu.android.utils.StringMap.Consumer
            public void G(String str3, Object obj) {
                builder.addFormDataPart(str3, obj.toString());
            }
        });
        builder.setType(MediaType.parse("multipart/form-data"));
        RequestBody build = builder.build();
        if (progressHandler != null || cancellationHandler != null) {
            build = new CountingRequestBody(build, progressHandler, j, cancellationHandler);
        }
        a(new Request.Builder().url(str).post(build), (StringMap) null, upToken, j, completionHandler);
    }

    public void a(String str, StringMap stringMap, UpToken upToken, CompletionHandler completionHandler) {
        a(new Request.Builder().get().url(str), stringMap, upToken, 0L, completionHandler);
    }

    /* renamed from: com.qiniu.android.http.Client$7  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass7 implements StringMap.Consumer {
        final /* synthetic */ Request.Builder nne;

        @Override // com.qiniu.android.utils.StringMap.Consumer
        public void G(String str, Object obj) {
            this.nne.header(str, obj.toString());
        }
    }

    /* renamed from: com.qiniu.android.http.Client$8  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass8 implements StringMap.Consumer {
        final /* synthetic */ MultipartBody.Builder nnh;

        @Override // com.qiniu.android.utils.StringMap.Consumer
        public void G(String str, Object obj) {
            this.nnh.addFormDataPart(str, obj.toString());
        }
    }

    /* renamed from: com.qiniu.android.http.Client$9  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass9 implements StringMap.Consumer {
        final /* synthetic */ Request.Builder nne;

        @Override // com.qiniu.android.utils.StringMap.Consumer
        public void G(String str, Object obj) {
            this.nne.header(str, obj.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ResponseTag {
        public long duration;
        public String ip;

        private ResponseTag() {
            this.ip = "";
            this.duration = -1L;
        }
    }
}
