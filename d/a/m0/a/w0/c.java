package d.a.m0.a.w0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.m0.a.a2.e;
import d.a.m0.a.f1.e.b;
import d.a.m0.a.k;
import d.a.m0.a.n0.l.b;
import d.a.m0.a.n1.f;
import d.a.m0.a.v2.w;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements d.a.m0.a.m.c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49304e = k.f46983a;

    /* loaded from: classes3.dex */
    public static class a implements d.a.m0.a.w0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49305a;

        public a(String str) {
            this.f49305a = str;
        }

        @Override // d.a.m0.a.w0.a
        public void onResult(boolean z) {
            if (z) {
                d.a.m0.a.j0.c.b.s(AppRuntime.getAppContext().getContentResolver(), this.f49305a, 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.w0.a f49306a;

        public b(d.a.m0.a.w0.a aVar) {
            this.f49306a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            d.a.m0.a.w0.a aVar = this.f49306a;
            if (aVar == null) {
                return;
            }
            if (jSONObject != null) {
                if (c.f49304e) {
                    Log.d("SwanHistoryManager", "上报数据 onSuccess: response=" + jSONObject);
                }
                if (jSONObject.optInt("errno", -1) == 0) {
                    this.f49306a.onResult(true);
                    return;
                } else {
                    this.f49306a.onResult(false);
                    return;
                }
            }
            aVar.onResult(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public JSONObject parseResponse(Response response, int i2) throws Exception {
            if (response == null || response.body() == null) {
                return null;
            }
            return w.d(response.body().string());
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            d.a.m0.a.w0.a aVar = this.f49306a;
            if (aVar == null) {
                return;
            }
            aVar.onResult(false);
        }
    }

    @WorkerThread
    public static void c(e eVar, b.C0822b c0822b) {
        b.a L;
        if (eVar == null || (L = eVar.L()) == null || TextUtils.equals("1", L.c0())) {
            return;
        }
        String H = L.H();
        if (TextUtils.equals("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u", H) || TextUtils.equals("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D", H) || TextUtils.equals("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", H)) {
            return;
        }
        if (f49304e) {
            Log.d("SwanHistoryManager", "addHistory: " + L.K() + " / " + H);
        }
        d.a.m0.a.w0.b a2 = d.a.m0.a.w0.b.a(L);
        boolean c2 = d.a.m0.a.j0.c.b.c(AppRuntime.getAppContext().getContentResolver(), a2, c0822b);
        a aVar = new a(H);
        if (c2) {
            e("ADD", a2.f49295a, a2.f49299e, a2.f49296b, a2.f49301g, a2.j, aVar);
        }
        if (!f49304e || c2) {
            return;
        }
        Log.e("SwanHistoryManager", "addHistoryAsync Failed!");
    }

    public static String d(String str, String str2, long j, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cmd", str);
            if (TextUtils.isEmpty(str3)) {
                jSONObject2.put("bundle_id", str2);
            } else {
                jSONObject2.put("appkey", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put("pkg_type", Integer.parseInt(str4));
            }
            if (!TextUtils.isEmpty(str5)) {
                jSONObject2.put("version_code", Integer.parseInt(str5));
            }
            jSONObject2.put("time", j);
            jSONArray.put(jSONObject2);
            jSONObject.put("items", jSONArray);
        } catch (JSONException e2) {
            if (f49304e) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static void e(String str, String str2, long j, String str3, String str4, String str5, d.a.m0.a.w0.a aVar) {
        String c2 = d.a.m0.a.c1.a.n().c();
        String d2 = d(str, str2, j, str3, str4, str5);
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        if (f49304e) {
            Log.d("SwanHistoryManager", "reportHistoryDataToServer: 上行参数" + d2);
        }
        b bVar = new b(aVar);
        d.a.m0.m.d.a aVar2 = new d.a.m0.m.d.a();
        aVar2.f51752b = "POST";
        aVar2.f51751a = c2;
        aVar2.f51756f = true;
        aVar2.f51757g = true;
        aVar2.f51754d = RequestBody.create(f.f47477a, d2);
        aVar2.f51755e = bVar;
        d.a.m0.m.e.a.g().e(aVar2);
    }
}
