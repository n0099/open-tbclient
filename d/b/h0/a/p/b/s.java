package d.b.h0.a.p.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aperf.bosuploader.BaseUrlManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.h0.a.n0.a;
import d.b.h0.a.p.c.j0;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class s implements j0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46156a = d.b.h0.a.k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public static int f46157b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f46158c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f46159d = 2;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.o1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.i f46160a;

        public a(a.i iVar) {
            this.f46160a = iVar;
        }

        @Override // d.b.h0.a.o1.a
        public void a(JSONObject jSONObject) {
            String str;
            if (jSONObject != null) {
                if (jSONObject.optInt("errno") == 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject != null) {
                        this.f46160a.a(optJSONObject.optString("tip"), s.this.i(optJSONObject.optJSONArray("list")), false);
                        return;
                    }
                } else {
                    str = jSONObject.optString("tipmsg");
                    this.f46160a.a(str, null, false);
                }
            }
            str = null;
            this.f46160a.a(str, null, false);
        }

        @Override // d.b.h0.a.o1.a
        public void onFail(String str) {
            this.f46160a.a(str, null, false);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends ResponseCallback<JSONObject> {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final d.b.h0.a.o1.a f46162a;

        public b(@Nullable d.b.h0.a.o1.a aVar) {
            this.f46162a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i) {
            d.b.h0.a.o1.a aVar = this.f46162a;
            if (aVar == null) {
                return;
            }
            if (jSONObject == null) {
                aVar.onFail("request fail");
            } else {
                aVar.a(jSONObject);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            String string = response.body().string();
            if (s.f46156a) {
                Log.d("SwanAppPushIdImpl", "statusCode:" + i + ", response=" + string);
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return new JSONObject(string);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            if (s.f46156a) {
                Log.e("SwanAppPushIdImpl", "SimpleResponseCallback", exc);
            }
            d.b.h0.a.o1.a aVar = this.f46162a;
            if (aVar != null) {
                aVar.onFail(exc.toString());
            }
        }
    }

    public static String j() {
        return d.b.h0.a.b0.c.u(String.format("%s/ma/formid/multi_action", BaseUrlManager.ONLINE_URL));
    }

    public static String k() {
        return d.b.h0.a.b0.c.u(String.format("%s/ma/formid/new", BaseUrlManager.ONLINE_URL));
    }

    public static String l() {
        return d.b.h0.a.b0.c.u(String.format("%s/ma/component/sub/create", BaseUrlManager.ONLINE_URL));
    }

    public static String m() {
        return d.b.h0.a.b0.c.u(String.format("%s/ma/component/msgtpl", BaseUrlManager.ONLINE_URL));
    }

    public static String n() {
        return d.b.h0.a.b0.c.u(String.format("%s/ma/payid/new", BaseUrlManager.ONLINE_URL));
    }

    @Override // d.b.h0.a.p.c.j0
    public void a(@NonNull String str, @NonNull Set<String> set, @NonNull a.i iVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.cons.b.f1883h, str);
            JSONArray jSONArray = new JSONArray();
            if (set != null && set.size() > 0) {
                for (String str2 : set) {
                    jSONArray.put(str2);
                }
            }
            jSONObject.put("template_ids", jSONArray);
        } catch (JSONException e2) {
            if (f46156a) {
                e2.printStackTrace();
            }
        }
        SwanAppNetworkUtils.k(m(), jSONObject.toString(), new b(new a(iVar)));
    }

    @Override // d.b.h0.a.p.c.j0
    public String b() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Uri.Builder buildUpon = Uri.parse(j()).buildUpon();
        buildUpon.appendQueryParameter("timestamp", String.valueOf(seconds)).appendQueryParameter("rasign", d.b.h0.a.b0.b.b().c(seconds)).appendQueryParameter("delta", "smartapp_formid");
        return buildUpon.toString();
    }

    @Override // d.b.h0.a.p.c.j0
    public void c(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, d.b.h0.a.n0.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.alipay.sdk.cons.b.f1883h, str);
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
            if (f46156a) {
                e2.printStackTrace();
            }
        }
        SwanAppNetworkUtils.k(h(f46159d), jSONObject.toString(), new b(bVar));
    }

    @Override // d.b.h0.a.p.c.j0
    public void d(String str, d.b.h0.a.i1.g.a aVar) {
        o(h(f46158c), str, aVar);
    }

    @Override // d.b.h0.a.p.c.j0
    public void e(@NonNull String str, d.b.h0.a.n0.b bVar) {
        String h2 = h(f46157b);
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) d.b.h0.k.e.a.f().postFormRequest().url(h2)).cookieManager(d.b.h0.a.w0.a.m().a())).addParam("appkey", str).build().executeAsyncOnUIBack(new b(bVar));
    }

    public final String h(int i) {
        long seconds;
        StringBuilder sb;
        String str;
        String str2 = "timestamp=" + TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        String str3 = "delta=smartapp_formid";
        if (i == f46157b) {
            sb = new StringBuilder(k());
            str = "rasign=" + d.b.h0.a.b0.b.b().c(seconds);
        } else if (i == f46159d) {
            sb = new StringBuilder(l());
            str = "rasign=" + d.b.h0.a.b0.b.b().c(seconds);
        } else {
            sb = new StringBuilder(n());
            str = "rasign=" + d.b.h0.a.b0.b.b().d(seconds);
            str3 = "delta=payid";
        }
        sb.append("&");
        sb.append(str2);
        sb.append("&");
        sb.append(str);
        sb.append("&");
        sb.append(str3);
        return d.b.h0.a.b0.c.u(sb.toString());
    }

    public final List<d.b.h0.a.n0.d> i(JSONArray jSONArray) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("template_id");
                String optString2 = optJSONObject.optString("template_title");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    arrayList.add(new d.b.h0.a.n0.d(optString, optString2));
                }
            }
        }
        return arrayList;
    }

    public final void o(String str, String str2, d.b.h0.a.o1.a aVar) {
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) d.b.h0.k.e.a.f().postFormRequest().url(str)).cookieManager(d.b.h0.a.w0.a.m().a())).addParam("appkey", str2).build().executeAsyncOnUIBack(new b(aVar));
    }
}
