package d.a.h0.a.t1.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.a.h0.a.g1.m.a;
import d.a.h0.a.i2.k0;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends d.a.h0.a.g1.a {

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f44451f = new AtomicLong(System.currentTimeMillis());

    /* renamed from: e  reason: collision with root package name */
    public int f44452e;

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44453a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44454b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44455c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44456d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44457e;

        public a(CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            this.f44453a = callbackHandler;
            this.f44454b = str;
            this.f44455c = str2;
            this.f44456d = str3;
            this.f44457e = str4;
        }

        @Override // d.a.h0.a.g1.m.a.b
        public void a(long j) {
            this.f44453a.handleSchemeDispatchCallback(this.f44454b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
            SwanAppNetworkUtils.a(d.a.h0.k.e.a.f().getOkHttpClient(), this.f44455c);
            g.this.q(this.f44456d);
        }

        @Override // d.a.h0.a.g1.m.a.b
        public void b(int i2, long j, long j2) {
            if (System.currentTimeMillis() - g.this.p(this.f44456d) > 500) {
                if (i2 <= 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", i2);
                        jSONObject.put("totalBytesWritten", j);
                        jSONObject.put("totalBytesExpectedToWrite", j2);
                        this.f44453a.handleSchemeDispatchCallback(this.f44457e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e2) {
                        if (a0.f44398b) {
                            e2.printStackTrace();
                        }
                    }
                }
                g.this.f42546c.put(this.f44456d, Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // d.a.h0.a.g1.m.a.b
        public void c(long j, long j2) {
            this.f44453a.handleSchemeDispatchCallback(this.f44454b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
            SwanAppNetworkUtils.a(d.a.h0.k.e.a.f().getOkHttpClient(), this.f44455c);
            g.this.q(this.f44456d);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44459a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f44460b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44461c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44462d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44464f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44465g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44466h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f44467i;

        public b(CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.f44459a = callbackHandler;
            this.f44460b = str;
            this.f44461c = str2;
            this.f44462d = str3;
            this.f44463e = str4;
            this.f44464f = str5;
            this.f44465g = str6;
            this.f44466h = str7;
            this.f44467i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            d.a.h0.a.z0.f.V().S();
            this.f44459a.handleSchemeDispatchCallback(this.f44460b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            g.this.q(this.f44461c);
            if (SwanAppNetworkUtils.h(null)) {
                d.a.h0.a.z1.h.t(0, this.f44462d, 0, iOException.getMessage(), this.f44463e, this.f44464f);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String y;
            String str;
            if (!TextUtils.isEmpty(this.f44465g)) {
                y = g.this.y(this.f44465g);
            } else {
                y = g.A(response, this.f44466h);
            }
            if (TextUtils.isEmpty(y)) {
                this.f44459a.handleSchemeDispatchCallback(this.f44460b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                return;
            }
            if (a0.f44398b) {
                Log.d("DownloadFileAction", "the real file path is " + y);
            }
            g.this.r(this.f44467i, response.headers());
            if (TextUtils.isEmpty(this.f44465g)) {
                str = d.a.h0.a.z0.f.V().I().h(y);
            } else {
                str = this.f44465g;
            }
            if (TextUtils.isEmpty(str)) {
                this.f44459a.handleSchemeDispatchCallback(this.f44460b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                return;
            }
            int code = response.code();
            String message = response.message();
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", code);
                    jSONObject.put(TextUtils.isEmpty(this.f44465g) ? "tempFilePath" : "filePath", str);
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(y);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (d.a.h0.p.f.a(byteStream, file)) {
                        this.f44459a.handleSchemeDispatchCallback(this.f44460b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        this.f44459a.handleSchemeDispatchCallback(this.f44460b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e2) {
                    if (a0.f44398b) {
                        e2.printStackTrace();
                    }
                    this.f44459a.handleSchemeDispatchCallback(this.f44460b, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                g.this.q(this.f44461c);
                d.a.h0.a.z0.f.V().S();
                if (a0.f44398b) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + this.f44462d + ", msg=" + message);
                }
                d.a.h0.a.z1.h.t(code, this.f44462d, 0, message, this.f44463e, this.f44464f);
            } catch (Throwable th) {
                g.this.q(this.f44461c);
                d.a.h0.a.z0.f.V().S();
                throw th;
            }
        }
    }

    public g(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.f44452e = 0;
    }

    @Nullable
    public static String A(Response response, String str) {
        String str2;
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String e2 = d.a.h0.a.i2.r.e(header);
            if (!TextUtils.isEmpty(e2) && (lastIndexOf = e2.lastIndexOf(".") + 1) > 0) {
                str = e2.substring(lastIndexOf);
            }
        } else {
            String header2 = response.header("Content-Type", null);
            if (!TextUtils.isEmpty(header2)) {
                String[] split = header2.split(";");
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String c2 = d.a.h0.a.i2.r.c(split[i2]);
                    if (!TextUtils.isEmpty(c2)) {
                        str = c2;
                        break;
                    }
                    i2++;
                }
            }
        }
        long andIncrement = f44451f.getAndIncrement();
        StringBuilder sb = new StringBuilder();
        sb.append(andIncrement);
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        sb.append(str2);
        return d.a.h0.a.z0.f.V().I().b(sb.toString());
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        }
        String optString = a2.optString("onProgressUpdate");
        String optString2 = a2.optString("headersReceivedEvent");
        String optString3 = a2.optString("cb");
        if (TextUtils.isEmpty(optString3)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal resultCallback");
            return false;
        }
        String optString4 = a2.optString("filePath");
        if (!TextUtils.isEmpty(optString4) && d.a.h0.p.d.o(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String T = d.a.h0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String a3 = d.a.h0.a.t.c.h.c.a(T);
        Request x = x(a2, a3);
        if (x == null) {
            unitedSchemeEntity.result = t(this.f44452e);
            return false;
        }
        String httpUrl = x.url().toString();
        String z = z(httpUrl);
        JSONObject optJSONObject = a2.optJSONObject("header");
        d.a.h0.a.g1.m.b bVar = new d.a.h0.a.g1.m.b();
        HashMap<String, String> m = d.a.h0.a.g1.a.m(optJSONObject, true);
        String optString5 = a2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            d.a.h0.l.k.h g2 = d.a.h0.a.l1.g.b.g(optString5);
            if (m == null) {
                m = new HashMap<>();
            }
            m.put("X-SWAN-HOSTSIGN", d.a.h0.a.l1.g.a.b(g2));
        }
        bVar.a(m);
        d.a.h0.a.z0.f.V().b0();
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.f42546c.put(valueOf, 0L);
        d.a.h0.a.g1.m.a aVar = new d.a.h0.a.g1.m.a();
        aVar.b(new a(callbackHandler, optString3, a3, valueOf, optString));
        String m2 = d.a.h0.a.z1.h.m();
        String d2 = k0.n().d();
        d.a.h0.a.z1.h.w(httpUrl, 0);
        OkHttpClient.Builder h2 = d.a.h0.k.e.a.f().h();
        h2.addNetworkInterceptor(new d.a.h0.a.g1.m.d());
        d.a.h0.k.e.a.f().u(h2);
        h2.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(d.a.h0.a.g1.m.c.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(callbackHandler, optString3, valueOf, httpUrl, m2, d2, optString4, z, optString2));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
        return true;
    }

    @Nullable
    public final Request x(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl e2;
        if (jSONObject == null || TextUtils.isEmpty(str) || (e2 = d.a.h0.a.t.c.h.c.e(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = e2.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        int c2 = d.a.h0.a.s1.a.b.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        this.f44452e = c2;
        if (c2 != 0) {
            return null;
        }
        return new Request.Builder().url(httpUrl).tag(str).build();
    }

    @Nullable
    public final String y(@NonNull String str) {
        File parentFile;
        String i2 = d.a.h0.a.z0.f.V().I().i(str);
        if (i2 == null || i2.endsWith(File.separator) || (parentFile = new File(i2).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return i2;
    }

    public final String z(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return d.a.h0.p.d.l(parse.getPath());
    }
}
