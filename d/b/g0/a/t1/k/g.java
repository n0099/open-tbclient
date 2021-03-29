package d.b.g0.a.t1.k;

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
import d.b.g0.a.g1.m.a;
import d.b.g0.a.i2.k0;
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
/* loaded from: classes2.dex */
public class g extends d.b.g0.a.g1.a {

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f46339f = new AtomicLong(System.currentTimeMillis());

    /* renamed from: e  reason: collision with root package name */
    public int f46340e;

    /* loaded from: classes2.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46341a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46342b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46343c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46344d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46345e;

        public a(CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            this.f46341a = callbackHandler;
            this.f46342b = str;
            this.f46343c = str2;
            this.f46344d = str3;
            this.f46345e = str4;
        }

        @Override // d.b.g0.a.g1.m.a.b
        public void a(long j) {
            this.f46341a.handleSchemeDispatchCallback(this.f46342b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
            SwanAppNetworkUtils.a(d.b.g0.k.e.a.f().getOkHttpClient(), this.f46343c);
            g.this.q(this.f46344d);
        }

        @Override // d.b.g0.a.g1.m.a.b
        public void b(int i, long j, long j2) {
            if (System.currentTimeMillis() - g.this.p(this.f46344d) > 500) {
                if (i <= 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", i);
                        jSONObject.put("totalBytesWritten", j);
                        jSONObject.put("totalBytesExpectedToWrite", j2);
                        this.f46341a.handleSchemeDispatchCallback(this.f46345e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e2) {
                        if (a0.f46288b) {
                            e2.printStackTrace();
                        }
                    }
                }
                g.this.f44512c.put(this.f46344d, Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // d.b.g0.a.g1.m.a.b
        public void c(long j, long j2) {
            this.f46341a.handleSchemeDispatchCallback(this.f46342b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
            SwanAppNetworkUtils.a(d.b.g0.k.e.a.f().getOkHttpClient(), this.f46343c);
            g.this.q(this.f46344d);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46347a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46349c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46350d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46351e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46352f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46353g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46354h;
        public final /* synthetic */ String i;

        public b(CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.f46347a = callbackHandler;
            this.f46348b = str;
            this.f46349c = str2;
            this.f46350d = str3;
            this.f46351e = str4;
            this.f46352f = str5;
            this.f46353g = str6;
            this.f46354h = str7;
            this.i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            d.b.g0.a.z0.f.V().S();
            this.f46347a.handleSchemeDispatchCallback(this.f46348b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            g.this.q(this.f46349c);
            if (SwanAppNetworkUtils.h(null)) {
                d.b.g0.a.z1.h.t(0, this.f46350d, 0, iOException.getMessage(), this.f46351e, this.f46352f);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String y;
            String str;
            if (!TextUtils.isEmpty(this.f46353g)) {
                y = g.this.y(this.f46353g);
            } else {
                y = g.A(response, this.f46354h);
            }
            if (TextUtils.isEmpty(y)) {
                this.f46347a.handleSchemeDispatchCallback(this.f46348b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                return;
            }
            if (a0.f46288b) {
                Log.d("DownloadFileAction", "the real file path is " + y);
            }
            g.this.r(this.i, response.headers());
            if (TextUtils.isEmpty(this.f46353g)) {
                str = d.b.g0.a.z0.f.V().y().c(y);
            } else {
                str = this.f46353g;
            }
            if (TextUtils.isEmpty(str)) {
                this.f46347a.handleSchemeDispatchCallback(this.f46348b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                return;
            }
            int code = response.code();
            String message = response.message();
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", code);
                    jSONObject.put(TextUtils.isEmpty(this.f46353g) ? "tempFilePath" : "filePath", str);
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(y);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (d.b.g0.p.f.a(byteStream, file)) {
                        this.f46347a.handleSchemeDispatchCallback(this.f46348b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        this.f46347a.handleSchemeDispatchCallback(this.f46348b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e2) {
                    if (a0.f46288b) {
                        e2.printStackTrace();
                    }
                    this.f46347a.handleSchemeDispatchCallback(this.f46348b, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                g.this.q(this.f46349c);
                d.b.g0.a.z0.f.V().S();
                if (a0.f46288b) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + this.f46350d + ", msg=" + message);
                }
                d.b.g0.a.z1.h.t(code, this.f46350d, 0, message, this.f46351e, this.f46352f);
            } catch (Throwable th) {
                g.this.q(this.f46349c);
                d.b.g0.a.z0.f.V().S();
                throw th;
            }
        }
    }

    public g(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/downloadFile");
        this.f46340e = 0;
    }

    @Nullable
    public static String A(Response response, String str) {
        String str2;
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String e2 = d.b.g0.a.i2.r.e(header);
            if (!TextUtils.isEmpty(e2) && (lastIndexOf = e2.lastIndexOf(".") + 1) > 0) {
                str = e2.substring(lastIndexOf);
            }
        } else {
            String header2 = response.header("Content-Type", null);
            if (!TextUtils.isEmpty(header2)) {
                String[] split = header2.split(";");
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String c2 = d.b.g0.a.i2.r.c(split[i]);
                    if (!TextUtils.isEmpty(c2)) {
                        str = c2;
                        break;
                    }
                    i++;
                }
            }
        }
        long andIncrement = f46339f.getAndIncrement();
        StringBuilder sb = new StringBuilder();
        sb.append(andIncrement);
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        sb.append(str2);
        return d.b.g0.a.z0.f.V().y().f(sb.toString());
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
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
        if (!TextUtils.isEmpty(optString4) && d.b.g0.p.d.o(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String T = d.b.g0.a.r1.e.T();
        if (TextUtils.isEmpty(T)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String a3 = d.b.g0.a.t.c.h.c.a(T);
        Request x = x(a2, a3);
        if (x == null) {
            unitedSchemeEntity.result = t(this.f46340e);
            return false;
        }
        String httpUrl = x.url().toString();
        String z = z(httpUrl);
        JSONObject optJSONObject = a2.optJSONObject("header");
        d.b.g0.a.g1.m.b bVar = new d.b.g0.a.g1.m.b();
        HashMap<String, String> m = d.b.g0.a.g1.a.m(optJSONObject, true);
        String optString5 = a2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            d.b.g0.l.k.h g2 = d.b.g0.a.l1.g.b.g(optString5);
            if (m == null) {
                m = new HashMap<>();
            }
            m.put("X-SWAN-HOSTSIGN", d.b.g0.a.l1.g.a.b(g2));
        }
        bVar.a(m);
        d.b.g0.a.z0.f.V().b0();
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.f44512c.put(valueOf, 0L);
        d.b.g0.a.g1.m.a aVar = new d.b.g0.a.g1.m.a();
        aVar.b(new a(callbackHandler, optString3, a3, valueOf, optString));
        String m2 = d.b.g0.a.z1.h.m();
        String d2 = k0.n().d();
        d.b.g0.a.z1.h.w(httpUrl, 0);
        OkHttpClient.Builder h2 = d.b.g0.k.e.a.f().h();
        h2.addNetworkInterceptor(new d.b.g0.a.g1.m.d());
        d.b.g0.k.e.a.f().u(h2);
        h2.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(d.b.g0.a.g1.m.c.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(callbackHandler, optString3, valueOf, httpUrl, m2, d2, optString4, z, optString2));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
        return true;
    }

    @Nullable
    public final Request x(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl e2;
        if (jSONObject == null || TextUtils.isEmpty(str) || (e2 = d.b.g0.a.t.c.h.c.e(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = e2.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        int c2 = d.b.g0.a.s1.a.b.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        this.f46340e = c2;
        if (c2 != 0) {
            return null;
        }
        return new Request.Builder().url(httpUrl).tag(str).build();
    }

    @Nullable
    public final String y(@NonNull String str) {
        File parentFile;
        String d2 = d.b.g0.a.z0.f.V().y().d(str);
        if (d2 == null || d2.endsWith(File.separator) || (parentFile = new File(d2).getParentFile()) == null || !parentFile.exists()) {
            return null;
        }
        return d2;
    }

    public final String z(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return null;
        }
        return d.b.g0.p.d.l(parse.getPath());
    }
}
