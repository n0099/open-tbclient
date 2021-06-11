package i.a.a.c;

import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
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
/* loaded from: classes8.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f72031b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f72032c;

    /* renamed from: d  reason: collision with root package name */
    public static String f72033d;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, List<Cookie>> f72034a = new HashMap<>();

    /* renamed from: i.a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1990a implements CookieJar {
        public C1990a() {
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            List<Cookie> list = (List) a.this.f72034a.get(httpUrl.host());
            return list != null ? list : new ArrayList();
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            a.this.f72034a.put(httpUrl.host(), list);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i.a.a.c.b.a f72036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Request f72037b;

        public b(a aVar, i.a.a.c.b.a aVar2, Request request) {
            this.f72036a = aVar2;
            this.f72037b = request;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            this.f72036a.a(this.f72037b, iOException);
            RLog.error("HttpCore", "HttpCore -- enqueuePost--1-onFailure:" + iOException.getMessage(), new Object[0]);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            String unused = a.f72033d = response.body().string();
            try {
                this.f72036a.b(a.f72033d);
                RLog.debug("HttpCore", "HttpCore -- enqueuePost-onResponse:" + a.f72033d);
            } catch (Exception e2) {
                RLog.error("HttpCore", "HttpCore -- enqueuePost--2-onFailure:" + e2.getMessage(), new Object[0]);
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
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().addInterceptor(new i.a.a.c.d.a(3)).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).cookieJar(new C1990a());
        cookieJar.dns(i.a.a.c.c.a.b());
        f72031b = cookieJar.build();
        RLog.info("HttpCore", "HttpCore -- init");
    }

    public static a e() {
        if (f72032c == null) {
            synchronized (a.class) {
                if (f72032c == null) {
                    f72032c = new a();
                }
            }
        }
        return f72032c;
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
        RLog.debug("HttpCore", "HttpCore -- enqueuePost--url:" + g2);
        Request.Builder url = new Request.Builder().url(g2);
        Request build2 = url.addHeader("X-AppId", i2 + "").addHeader("traceid", str2).addHeader("version", str3).addHeader("pakagename", str4).addHeader("X-HostId", str5).addHeader("X-AuthType", String.valueOf(i3)).post(build).build();
        try {
            f72031b.newCall(build2).enqueue(new b(this, aVar, build2));
        } catch (Exception e2) {
            e2.printStackTrace();
            RLog.error("HttpCore", "HttpCore -- enqueuePost--3-onFailure:" + e2.getMessage(), new Object[0]);
        }
        return f72033d;
    }

    public final void f(Map<String, String> map, FormBody.Builder builder) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue() == null ? "" : entry.getValue());
        }
    }
}
