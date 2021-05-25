package d.a.l0.a.p.c;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import d.a.l0.a.p.d.u0;
import d.a.l0.a.s0.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d0 implements u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43955a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static int f43956b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f43957c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f43958d = 2;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.x1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.j f43959a;

        public a(a.j jVar) {
            this.f43959a = jVar;
        }

        @Override // d.a.l0.a.x1.a
        public void a(String str) {
            this.f43959a.a(str, null, false);
        }

        @Override // d.a.l0.a.x1.a
        public void b(JSONObject jSONObject) {
            String str;
            if (jSONObject != null) {
                if (jSONObject.optInt("errno") == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        this.f43959a.a(optJSONObject.optString("tip"), d0.this.i(optJSONObject.optJSONArray("list")), false);
                        return;
                    }
                } else {
                    str = jSONObject.optString("tipmsg");
                    this.f43959a.a(str, null, false);
                }
            }
            str = null;
            this.f43959a.a(str, null, false);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends ResponseCallback<JSONObject> {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final d.a.l0.a.x1.a f43961a;

        public b(@Nullable d.a.l0.a.x1.a aVar) {
            this.f43961a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            d.a.l0.a.x1.a aVar = this.f43961a;
            if (aVar == null) {
                return;
            }
            if (jSONObject == null) {
                aVar.a("request fail");
            } else {
                aVar.b(jSONObject);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            String string = response.body().string();
            if (d0.f43955a) {
                Log.d("SwanAppPushIdImpl", "statusCode:" + i2 + ", response=" + string);
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new JSONObject(string);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (d0.f43955a) {
                Log.e("SwanAppPushIdImpl", "SimpleResponseCallback", exc);
            }
            d.a.l0.a.x1.a aVar = this.f43961a;
            if (aVar != null) {
                aVar.a(exc.toString());
            }
        }
    }

    public static String j() {
        return d.a.l0.a.d0.c.w(String.format("%s/ma/formid/multi_action", d.a.l0.a.d0.c.f41309a), true);
    }

    public static String k() {
        return d.a.l0.a.d0.c.w(String.format("%s/ma/formid/new", d.a.l0.a.d0.c.f41309a), true);
    }

    public static String l() {
        return d.a.l0.a.d0.c.w(String.format("%s/ma/component/sub/create", d.a.l0.a.d0.c.f41309a), true);
    }

    public static String m() {
        return d.a.l0.a.d0.c.w(String.format("%s/ma/component/msgtpl", d.a.l0.a.d0.c.f41309a), true);
    }

    public static String n() {
        return d.a.l0.a.d0.c.w(String.format("%s/ma/payid/new", d.a.l0.a.d0.c.f41309a), true);
    }

    @Override // d.a.l0.a.p.d.u0
    public void a(@NonNull String str, @NonNull Set<String> set, @NonNull a.j jVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", str);
            JSONArray jSONArray = new JSONArray();
            if (set != null && set.size() > 0) {
                for (String str2 : set) {
                    jSONArray.put(str2);
                }
            }
            jSONObject.put("template_ids", jSONArray);
        } catch (JSONException e2) {
            if (f43955a) {
                e2.printStackTrace();
            }
        }
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(m(), new b(new a(jVar)));
        aVar.a(d.a.l0.a.n1.f.f43693a, jSONObject.toString());
        if (d.a.l0.m.e.a.g().c()) {
            aVar.f47974f = true;
        }
        aVar.f47975g = true;
        d.a.l0.m.e.a.g().e(aVar);
    }

    @Override // d.a.l0.a.p.d.u0
    public String b() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Uri.Builder buildUpon = Uri.parse(j()).buildUpon();
        buildUpon.appendQueryParameter("timestamp", String.valueOf(seconds)).appendQueryParameter("rasign", d.a.l0.a.d0.b.b().c(seconds)).appendQueryParameter("delta", "smartapp_formid");
        return buildUpon.toString();
    }

    @Override // d.a.l0.a.p.d.u0
    public void c(@NonNull String str, d.a.l0.a.s0.b bVar) {
        String h2 = h(f43956b);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) d.a.l0.m.e.a.g().postFormRequest().url(h2)).cookieManager(d.a.l0.a.c1.a.p().a())).addParam("appkey", str).build().executeAsyncOnUIBack(new b(bVar));
    }

    @Override // d.a.l0.a.p.d.u0
    public void d(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, d.a.l0.a.s0.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_key", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sub_id", str2);
            if (z) {
                jSONObject2.put("template_id", list.get(0));
            } else {
                JSONArray jSONArray = new JSONArray();
                for (String str3 : list) {
                    jSONArray.put(str3);
                }
                jSONObject2.put("template_ids", jSONArray);
            }
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            jSONObject.put("detail", jSONArray2);
        } catch (JSONException e2) {
            if (f43955a) {
                e2.printStackTrace();
            }
        }
        d.a.l0.m.d.a aVar = new d.a.l0.m.d.a(h(f43958d), new b(bVar));
        aVar.a(d.a.l0.a.n1.f.f43693a, jSONObject.toString());
        aVar.f47974f = true;
        aVar.f47975g = true;
        d.a.l0.m.e.a.g().e(aVar);
    }

    @Override // d.a.l0.a.p.d.u0
    public void e(String str, d.a.l0.a.q1.g.a aVar) {
        o(h(f43957c), str, aVar);
    }

    public final String h(int i2) {
        long seconds;
        StringBuilder sb;
        String str;
        String str2 = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        String str3 = "delta=smartapp_formid";
        if (i2 == f43956b) {
            sb = new StringBuilder(k());
            str = "rasign=" + d.a.l0.a.d0.b.b().c(seconds);
        } else if (i2 == f43958d) {
            sb = new StringBuilder(l());
            str = "rasign=" + d.a.l0.a.d0.b.b().c(seconds);
        } else {
            sb = new StringBuilder(n());
            str = "rasign=" + d.a.l0.a.d0.b.b().d(seconds);
            str3 = "delta=payid";
        }
        sb.append("&");
        sb.append(str2);
        sb.append("&");
        sb.append(str);
        sb.append("&");
        sb.append(str3);
        return d.a.l0.a.d0.c.v(sb.toString());
    }

    public final List<d.a.l0.a.s0.d> i(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("template_id");
                String optString2 = optJSONObject.optString("template_title");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    arrayList.add(new d.a.l0.a.s0.d(optString, optString2));
                }
            }
        }
        return arrayList;
    }

    public final void o(String str, String str2, d.a.l0.a.x1.a aVar) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) d.a.l0.m.e.a.g().postFormRequest().url(str)).cookieManager(d.a.l0.a.c1.a.p().a())).userAgent(d.a.l0.m.b.b().a())).addParam("appkey", str2).build().executeAsyncOnUIBack(new b(aVar));
    }
}
