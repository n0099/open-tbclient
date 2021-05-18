package d.a.i0.e.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import d.a.i0.a.k;
import d.a.i0.a.p.d.u;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes3.dex */
public class a implements u {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46348a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final d.a.i0.e.s.c<JSONObject> f46349b = new d.a.i0.e.s.c<>();

    /* renamed from: c  reason: collision with root package name */
    public static final long f46350c = TimeUnit.MINUTES.toMillis(2);

    @Override // d.a.i0.a.p.d.u
    public void a(String str, String str2) {
    }

    @Override // d.a.i0.a.p.d.u
    public File b(Context context, String str) {
        return null;
    }

    @Override // d.a.i0.a.p.d.u
    public JSONObject c(Context context, String str) {
        if (f46348a) {
            Log.i("BoxPrivateBehavior", "getIMUnReadMessageList params=" + str);
        }
        String str2 = d.a.i0.a.a2.d.g().getAppId() + d.a.i0.a.a2.d.g().r().j().c(context);
        JSONObject c2 = f46349b.c(str2);
        if (f46348a) {
            Log.i("BoxPrivateBehavior", "getIMUnReadMessageList k=" + str2);
        }
        if (c2 != null) {
            if (f46348a) {
                Log.i("BoxPrivateBehavior", "getIMUnReadMessageList ret with cache=" + c2);
            }
            return c2;
        } else if (q0.N()) {
            return null;
        } else {
            JSONObject f2 = f(context, str);
            if (f46348a) {
                Log.i("BoxPrivateBehavior", "getIMUnReadMessageList ret with request=" + f2);
            }
            return f46349b.a(str2, f2, f46350c);
        }
    }

    @Override // d.a.i0.a.p.d.u
    public void d() {
        f46349b.b();
    }

    public final JSONObject e(int i2) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        w.f(jSONObject2, "pa_type", 7);
        w.f(jSONObject2, "pa_unread_sums", Integer.valueOf(i2));
        jSONArray.put(jSONObject2);
        w.f(jSONObject, "un_read_list", jSONArray);
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        r9 = r4.optString("pa_uid");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject f(Context context, String str) {
        String str2;
        ResponseBody responseBody;
        d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
        ResponseBody responseBody2 = null;
        if (Q == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    str2 = null;
                    break;
                }
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject.optInt("pa_type") == 7) {
                    break;
                }
                i3++;
            }
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String n = d.a.i0.a.c1.a.n().n();
            d.a.i0.m.d.a aVar = new d.a.i0.m.d.a(n, new Request.Builder().url(n).post(new FormBody.Builder().add("appkey", Q.D()).add(com.alipay.sdk.cons.b.k, str2).build()).build().body(), null);
            aVar.f47798f = true;
            aVar.f47799g = true;
            aVar.f47800h = true;
            aVar.f47794b = "POST";
            HttpRequestBuilder a2 = d.a.i0.m.e.b.a(aVar);
            d.a.i0.m.e.a.g().t(a2, aVar);
            try {
                Response executeSync = a2.build().executeSync();
                if (!executeSync.isSuccessful()) {
                    d.a.i0.t.d.d(null);
                    return null;
                }
                responseBody = executeSync.body();
                if (responseBody == null) {
                    d.a.i0.t.d.d(responseBody);
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(responseBody.string());
                    if (!"0".equals(jSONObject.optString("errno"))) {
                        d.a.i0.t.d.d(responseBody);
                        return null;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
                    if (optJSONObject2 != null) {
                        i2 = optJSONObject2.optInt("num");
                    }
                    JSONObject e2 = e(i2);
                    d.a.i0.a.c1.a.G().g(e2);
                    d.a.i0.t.d.d(responseBody);
                    return e2;
                } catch (IOException | JSONException unused) {
                    d.a.i0.t.d.d(responseBody);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    responseBody2 = responseBody;
                    d.a.i0.t.d.d(responseBody2);
                    throw th;
                }
            } catch (IOException | JSONException unused2) {
                responseBody = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (JSONException unused3) {
        }
    }
}
