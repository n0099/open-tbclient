package d.a.l0.a.c2.f;

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
import d.a.l0.a.n1.o.a;
import d.a.l0.a.v2.q0;
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
public class f extends d.a.l0.a.n1.a {

    /* renamed from: f  reason: collision with root package name */
    public static AtomicLong f40967f = new AtomicLong(System.currentTimeMillis());

    /* renamed from: e  reason: collision with root package name */
    public int f40968e;

    /* loaded from: classes3.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40969a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f40970b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f40971c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40972d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f40973e;

        public a(CallbackHandler callbackHandler, String str, String str2, String str3, String str4) {
            this.f40969a = callbackHandler;
            this.f40970b = str;
            this.f40971c = str2;
            this.f40972d = str3;
            this.f40973e = str4;
        }

        @Override // d.a.l0.a.n1.o.a.b
        public void a(long j) {
            this.f40969a.handleSchemeDispatchCallback(this.f40970b, UnitedSchemeUtility.wrapCallbackParams(1001, "download file failed because file size exceeds limit").toString());
            SwanAppNetworkUtils.a(d.a.l0.m.e.a.g().getOkHttpClient(), this.f40971c);
            f.this.q(this.f40972d);
        }

        @Override // d.a.l0.a.n1.o.a.b
        public void b(int i2, long j, long j2) {
            if (System.currentTimeMillis() - f.this.p(this.f40972d) > 500) {
                if (i2 <= 100) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("progress", i2);
                        jSONObject.put("totalBytesWritten", j);
                        jSONObject.put("totalBytesExpectedToWrite", j2);
                        this.f40969a.handleSchemeDispatchCallback(this.f40973e, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } catch (Exception e2) {
                        if (a0.f40949b) {
                            e2.printStackTrace();
                        }
                    }
                }
                f.this.f43687c.put(this.f40972d, Long.valueOf(System.currentTimeMillis()));
            }
        }

        @Override // d.a.l0.a.n1.o.a.b
        public void c(long j, long j2) {
            this.f40969a.handleSchemeDispatchCallback(this.f40970b, UnitedSchemeUtility.wrapCallbackParams(1001, "progress callback fail()").toString());
            SwanAppNetworkUtils.a(d.a.l0.m.e.a.g().getOkHttpClient(), this.f40971c);
            f.this.q(this.f40972d);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40975a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f40976b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f40977c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f40978d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f40979e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40980f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f40981g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40982h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f40983i;

        public b(CallbackHandler callbackHandler, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.f40975a = callbackHandler;
            this.f40976b = str;
            this.f40977c = str2;
            this.f40978d = str3;
            this.f40979e = str4;
            this.f40980f = str5;
            this.f40981g = str6;
            this.f40982h = str7;
            this.f40983i = str8;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            d.a.l0.a.g1.f.V().S();
            this.f40975a.handleSchemeDispatchCallback(this.f40976b, UnitedSchemeUtility.wrapCallbackParams(1001, iOException.getMessage()).toString());
            f.this.q(this.f40977c);
            if (SwanAppNetworkUtils.i(null)) {
                d.a.l0.a.j2.k.s(0, this.f40978d, 0, iOException.getMessage(), this.f40979e, this.f40980f);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String y;
            String str;
            if (!TextUtils.isEmpty(this.f40981g)) {
                y = f.this.y(this.f40981g);
            } else {
                y = f.A(response, this.f40982h);
            }
            if (TextUtils.isEmpty(y)) {
                this.f40975a.handleSchemeDispatchCallback(this.f40976b, UnitedSchemeUtility.wrapCallbackParams(1001, "realFilePath create fail").toString());
                return;
            }
            if (a0.f40949b) {
                Log.d("DownloadFileAction", "the real file path is " + y);
            }
            f.this.r(this.f40983i, response.headers());
            if (TextUtils.isEmpty(this.f40981g)) {
                str = d.a.l0.a.g1.f.V().I().h(y);
            } else {
                str = this.f40981g;
            }
            if (TextUtils.isEmpty(str)) {
                this.f40975a.handleSchemeDispatchCallback(this.f40976b, UnitedSchemeUtility.wrapCallbackParams(1001, "parse tmpFilePath from realFilePath fail").toString());
                return;
            }
            int code = response.code();
            String message = response.message();
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("statusCode", code);
                    jSONObject.put(TextUtils.isEmpty(this.f40981g) ? "tempFilePath" : "filePath", str);
                    InputStream byteStream = response.body().byteStream();
                    File file = new File(y);
                    if (file.exists()) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (d.a.l0.t.g.a(byteStream, file)) {
                        this.f40975a.handleSchemeDispatchCallback(this.f40976b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
                    } else {
                        this.f40975a.handleSchemeDispatchCallback(this.f40976b, UnitedSchemeUtility.wrapCallbackParams(1001, "streamToFile fail").toString());
                    }
                } catch (Exception e2) {
                    if (a0.f40949b) {
                        e2.printStackTrace();
                    }
                    this.f40975a.handleSchemeDispatchCallback(this.f40976b, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                }
                f.this.q(this.f40977c);
                d.a.l0.a.g1.f.V().S();
                if (a0.f40949b) {
                    Log.d("DownloadFileAction", "onResponse: respCode: " + code + ", url=" + this.f40978d + ", msg=" + message);
                }
                d.a.l0.a.j2.k.s(code, this.f40978d, 0, message, this.f40979e, this.f40980f);
            } catch (Throwable th) {
                f.this.q(this.f40977c);
                d.a.l0.a.g1.f.V().S();
                throw th;
            }
        }
    }

    public f(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/downloadFile");
        this.f40968e = 0;
    }

    @Nullable
    public static String A(Response response, String str) {
        String str2;
        int lastIndexOf;
        String header = response.header("Content-Disposition", null);
        if (!TextUtils.isEmpty(header)) {
            String e2 = d.a.l0.a.v2.s.e(header);
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
                    String c2 = d.a.l0.a.v2.s.c(split[i2]);
                    if (!TextUtils.isEmpty(c2)) {
                        str = c2;
                        break;
                    }
                    i2++;
                }
            }
        }
        long andIncrement = f40967f.getAndIncrement();
        StringBuilder sb = new StringBuilder();
        sb.append(andIncrement);
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = "." + str;
        }
        sb.append(str2);
        return d.a.l0.a.g1.f.V().I().c(sb.toString());
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
        if (!TextUtils.isEmpty(optString4) && d.a.l0.t.d.w(optString4)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal path");
            return false;
        }
        String V = d.a.l0.a.a2.e.V();
        if (TextUtils.isEmpty(V)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal appId");
            return false;
        }
        String a3 = d.a.l0.a.u.e.j.h.a(V);
        Request x = x(a2, a3);
        if (x == null) {
            unitedSchemeEntity.result = t(this.f40968e);
            return false;
        }
        String httpUrl = x.url().toString();
        String z = z(httpUrl);
        JSONObject optJSONObject = a2.optJSONObject("header");
        d.a.l0.a.n1.o.b bVar = new d.a.l0.a.n1.o.b();
        HashMap<String, String> m = d.a.l0.a.n1.a.m(optJSONObject, true);
        String optString5 = a2.optString("__plugin__");
        if (!TextUtils.isEmpty(optString5)) {
            d.a.l0.n.h.h h2 = d.a.l0.a.t1.g.b.h(optString5);
            if (m == null) {
                m = new HashMap<>();
            }
            m.put("X-SWAN-HOSTSIGN", d.a.l0.a.t1.g.a.b(h2));
        }
        bVar.a(m);
        d.a.l0.a.g1.f.V().b0();
        String valueOf = String.valueOf(System.currentTimeMillis());
        this.f43687c.put(valueOf, 0L);
        d.a.l0.a.n1.o.a aVar = new d.a.l0.a.n1.o.a();
        aVar.b(new a(callbackHandler, optString3, a3, valueOf, optString));
        String l = d.a.l0.a.j2.k.l();
        String f2 = q0.n().f();
        if (SwanAppNetworkUtils.i(null)) {
            d.a.l0.a.j2.k.x(httpUrl, 0);
        }
        OkHttpClient.Builder i2 = d.a.l0.m.e.a.g().i();
        i2.addNetworkInterceptor(new d.a.l0.a.n1.o.d());
        d.a.l0.m.e.a.g().v(i2);
        i2.addInterceptor(bVar).addNetworkInterceptor(aVar).build().newCall(d.a.l0.a.n1.o.c.f(x, "downloadFile", a2.optString("__plugin__"))).enqueue(new b(callbackHandler, optString3, valueOf, httpUrl, l, f2, optString4, z, optString2));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(n(a3), 0));
        return true;
    }

    @Nullable
    public final Request x(@Nullable JSONObject jSONObject, @Nullable String str) {
        HttpUrl f2;
        if (jSONObject == null || TextUtils.isEmpty(str) || (f2 = d.a.l0.a.u.e.j.h.f(jSONObject.optString("url"))) == null) {
            return null;
        }
        String httpUrl = f2.toString();
        if (TextUtils.isEmpty(httpUrl)) {
            return null;
        }
        int c2 = d.a.l0.a.b2.a.b.c("downloadFile", httpUrl, jSONObject.optString("__plugin__"));
        this.f40968e = c2;
        if (c2 != 0) {
            return null;
        }
        return new Request.Builder().url(httpUrl).tag(str).build();
    }

    @Nullable
    public final String y(@NonNull String str) {
        File parentFile;
        String i2 = d.a.l0.a.g1.f.V().I().i(str);
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
        return d.a.l0.t.d.s(parse.getPath());
    }
}
