package com.kwad.sdk;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.nps.utils.Constant;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
/* loaded from: classes10.dex */
public final class j implements com.kwad.framework.filedownloader.a.b {
    public Request akA;
    public Response akB;
    public final OkHttpClient aky;
    public final Request.Builder akz;

    /* loaded from: classes10.dex */
    public static class a implements c.b {
        public OkHttpClient.Builder akC;
        public volatile OkHttpClient aky;

        public a() {
        }

        public a(boolean z) {
            if (z) {
                this.akC = j.yK();
            } else {
                this.akC = j.yL();
            }
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b aX(String str) {
            OkHttpClient okHttpClient;
            if (this.aky == null) {
                synchronized (a.class) {
                    if (this.aky == null) {
                        if (this.akC != null) {
                            okHttpClient = this.akC.build();
                        } else {
                            okHttpClient = new OkHttpClient();
                        }
                        this.aky = okHttpClient;
                        this.akC = null;
                    }
                }
            }
            return new j(str, this.aky, (byte) 0);
        }
    }

    public j(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.akz.addHeader(str, str2);
    }

    public /* synthetic */ j(String str, OkHttpClient okHttpClient, byte b) {
        this(str, okHttpClient);
    }

    public j(Request.Builder builder, OkHttpClient okHttpClient) {
        this.akz = builder;
        this.aky = okHttpClient;
    }

    private String bQ(String str) {
        String aW = aW("Content-Type");
        String extension = q.getExtension(str);
        boolean isEmpty = TextUtils.isEmpty(aW);
        String str2 = Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
        if (!isEmpty && TextUtils.isEmpty(extension)) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(aW);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            if (!TextUtils.isEmpty(extensionFromMimeType)) {
                str2 = "." + extensionFromMimeType;
            }
            sb.append(str2);
            return sb.toString();
        } else if (TextUtils.isEmpty(str)) {
            return System.currentTimeMillis() + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
        } else {
            return str;
        }
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String aW(String str) {
        String str2;
        if ("Content-Disposition".equals(str)) {
            try {
            } catch (Exception unused) {
                str2 = "";
            }
            if (TextUtils.isEmpty(com.kwad.framework.filedownloader.f.f.bo(this.akB.header(str)))) {
                List<String> pathSegments = this.akB.request().url().pathSegments();
                str2 = pathSegments.get(pathSegments.size() - 1);
                return "attachment; filename=\"" + bQ(str2) + "\"";
            }
            return this.akB.header(str);
        }
        Response response = this.akB;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    public static OkHttpClient.Builder yI() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.kwad.sdk.j.a()).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    public static OkHttpClient.Builder yJ() {
        return new OkHttpClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).addInterceptor(new com.kwad.sdk.j.a()).protocols(Util.immutableList(Protocol.HTTP_1_1)).readTimeout(0L, TimeUnit.MILLISECONDS).connectionPool(new ConnectionPool(6, 60000L, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true);
    }

    public static /* synthetic */ OkHttpClient.Builder yK() {
        return yJ();
    }

    public static /* synthetic */ OkHttpClient.Builder yL() {
        return yI();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        if (this.akA == null) {
            this.akA = this.akz.build();
        }
        this.akB = this.aky.newCall(this.akA).execute();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        Response response = this.akB;
        if (response != null) {
            return ((com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class)).wrapInputStream(response.body().byteStream());
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        Response response = this.akB;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> uS() {
        if (this.akA == null) {
            this.akA = this.akz.build();
        }
        return this.akA.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> uT() {
        Response response = this.akB;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void uU() {
        this.akA = null;
        Response response = this.akB;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.akB.body());
        }
        this.akB = null;
    }
}
