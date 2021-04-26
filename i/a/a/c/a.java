package i.a.a.c;

import d.r.b.a.a.f.d.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f68052b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f68053c;

    /* renamed from: d  reason: collision with root package name */
    public static String f68054d;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, List<Cookie>> f68055a = new HashMap<>();

    /* renamed from: i.a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1874a implements CookieJar {
        public C1874a() {
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> list = (List) a.this.f68055a.get(httpUrl.host());
            return list != null ? list : new ArrayList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            a.this.f68055a.put(httpUrl.host(), list);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i.a.a.c.b.a f68057a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f68058b;

        public b(a aVar, i.a.a.c.b.a aVar2, Request request) {
            this.f68057a = aVar2;
            this.f68058b = request;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f68057a.a(this.f68058b, iOException);
            d.e("HttpCore", "HttpCore -- enqueuePost--1-onFailure:" + iOException.getMessage(), new Object[0]);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            String unused = a.f68054d = response.body().string();
            try {
                this.f68057a.b(a.f68054d);
                d.f("HttpCore", "HttpCore -- enqueuePost-onResponse:" + a.f68054d);
            } catch (Exception e2) {
                d.e("HttpCore", "HttpCore -- enqueuePost--2-onFailure:" + e2.getMessage(), new Object[0]);
                e2.printStackTrace();
            }
        }
    }

    static {
        MediaType.parse("application/json;charset=utf-8");
        MediaType.parse("application/octet-stream");
        MediaType.parse("text/x-markdown;charset=utf-8");
    }

    public a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        f68052b = okHttpClient;
        okHttpClient.newBuilder().addInterceptor(new i.a.a.c.c.a(3)).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).cookieJar(new C1874a());
        d.f("HttpCore", "HttpCore -- init");
    }

    public static a e() {
        if (f68053c == null) {
            synchronized (a.class) {
                if (f68053c == null) {
                    f68053c = new a();
                }
            }
        }
        return f68053c;
    }

    public static String g(String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (map == null) {
            new HashMap();
        } else {
            boolean z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z && !str.contains("?")) {
                    z = false;
                    sb.append("?");
                } else {
                    sb.append("&");
                }
                sb.append(entry.getKey());
                sb.append("=");
                if (entry.getValue() == null) {
                    sb.append(" ");
                } else {
                    sb.append(entry.getValue());
                }
            }
        }
        return sb.toString();
    }

    public String d(String str, Map<String, String> map, int i2, String str2, String str3, String str4, String str5, int i3, i.a.a.c.b.a aVar) {
        if (map == null) {
            map = new HashMap<>();
        }
        FormBody.Builder builder = new FormBody.Builder();
        f(map, builder);
        FormBody build = builder.build();
        String g2 = g(str, null);
        d.f("HttpCore", "HttpCore -- enqueuePost--url:" + g2);
        Request.Builder url = new Request.Builder().url(g2);
        Request build2 = url.addHeader("X-AppId", i2 + "").addHeader("traceid", str2).addHeader("version", str3).addHeader("pakagename", str4).addHeader("X-HostId", str5).addHeader("X-AuthType", String.valueOf(i3)).post(build).build();
        try {
            f68052b.newCall(build2).enqueue(new b(this, aVar, build2));
        } catch (Exception e2) {
            e2.printStackTrace();
            d.e("HttpCore", "HttpCore -- enqueuePost--3-onFailure:" + e2.getMessage(), new Object[0]);
        }
        return f68054d;
    }

    public final void f(Map<String, String> map, FormBody.Builder builder) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue() == null ? "" : entry.getValue());
        }
    }
}
