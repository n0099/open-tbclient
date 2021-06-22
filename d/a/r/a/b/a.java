package d.a.r.a.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f68169c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f68170d = 1;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f68171a = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    /* renamed from: b  reason: collision with root package name */
    public Context f68172b;

    /* renamed from: d.a.r.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC1860a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f68173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ byte[] f68174f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f68175g;

        public RunnableC1860a(b bVar, byte[] bArr, c cVar) {
            this.f68173e = bVar;
            this.f68174f = bArr;
            this.f68175g = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.e(this.f68173e.b(), this.f68173e.a(), this.f68174f, this.f68173e.d(), this.f68173e.c(), this.f68175g);
        }
    }

    public a(Context context) {
        this.f68172b = context;
    }

    public static a a(Context context) {
        if (f68169c == null) {
            synchronized (a.class) {
                if (f68169c == null) {
                    f68169c = new a(context);
                }
            }
        }
        return f68169c;
    }

    public static Headers c(Map<String, String> map) {
        try {
            Headers.Builder builder = new Headers.Builder();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    String str2 = str.toString();
                    builder.add(str2, map.get(str2));
                }
            }
            return builder.build();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b() {
        String defaultUserAgent;
        int length;
        int i2;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                defaultUserAgent = WebSettings.getDefaultUserAgent(this.f68172b);
            } catch (Exception unused) {
            }
            StringBuffer stringBuffer = new StringBuffer();
            length = defaultUserAgent.length();
            for (i2 = 0; i2 < length; i2++) {
                char charAt = defaultUserAgent.charAt(i2);
                if (charAt <= 31 || charAt >= 127) {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    stringBuffer.append(charAt);
                }
            }
            d.a.r.a.e.c.a("HttpExecutor", "getUserAgent:" + stringBuffer.toString());
            return stringBuffer.toString();
        }
        defaultUserAgent = System.getProperty("http.agent");
        StringBuffer stringBuffer2 = new StringBuffer();
        length = defaultUserAgent.length();
        while (i2 < length) {
        }
        d.a.r.a.e.c.a("HttpExecutor", "getUserAgent:" + stringBuffer2.toString());
        return stringBuffer2.toString();
    }

    public final void e(String str, String str2, byte[] bArr, Map<String, String> map, String str3, c cVar) {
        Request.Builder addHeader;
        try {
            if ("POST".equals(str)) {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "application/x-www-form-urlencoded";
                }
                addHeader = new Request.Builder().url(str2).headers(c(map)).removeHeader("User-Agent").addHeader("User-Agent", b()).post(RequestBody.create(MediaType.parse(str3), bArr));
            } else {
                addHeader = new Request.Builder().url(str2).headers(c(map)).removeHeader("User-Agent").addHeader("User-Agent", b());
            }
            Response execute = this.f68171a.newCall(addHeader.build()).execute();
            byte[] bytes = execute.body().bytes();
            d.a.r.a.e.c.c("HttpExecutor", "requestUrl:" + str2 + "\nrequest method: " + str + "\nrequest contentType: " + str3 + "\nresponse : " + new String(bytes));
            cVar.a(execute.code(), bytes);
        } catch (Exception e2) {
            e2.printStackTrace();
            if (cVar != null) {
                cVar.b(f68170d, "Http Unknown exception".getBytes());
            }
        }
    }
}
