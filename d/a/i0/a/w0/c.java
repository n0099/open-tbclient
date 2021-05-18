package d.a.i0.a.w0;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.i0.a.a2.e;
import d.a.i0.a.f1.e.b;
import d.a.i0.a.k;
import d.a.i0.a.n0.l.b;
import d.a.i0.a.n1.f;
import d.a.i0.a.v2.w;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements d.a.i0.a.m.c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45346e = k.f43025a;

    /* loaded from: classes2.dex */
    public static class a implements d.a.i0.a.w0.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45347a;

        public a(String str) {
            this.f45347a = str;
        }

        @Override // d.a.i0.a.w0.a
        public void onResult(boolean z) {
            if (z) {
                d.a.i0.a.j0.c.b.s(AppRuntime.getAppContext().getContentResolver(), this.f45347a, 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends ResponseCallback<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.w0.a f45348a;

        public b(d.a.i0.a.w0.a aVar) {
            this.f45348a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(JSONObject jSONObject, int i2) {
            d.a.i0.a.w0.a aVar = this.f45348a;
            if (aVar == null) {
                return;
            }
            if (jSONObject != null) {
                if (c.f45346e) {
                    Log.d("SwanHistoryManager", "上报数据 onSuccess: response=" + jSONObject);
                }
                if (jSONObject.optInt("errno", -1) == 0) {
                    this.f45348a.onResult(true);
                    return;
                } else {
                    this.f45348a.onResult(false);
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
            d.a.i0.a.w0.a aVar = this.f45348a;
            if (aVar == null) {
                return;
            }
            aVar.onResult(false);
        }
    }

    @WorkerThread
    public static void c(e eVar, b.C0752b c0752b) {
        b.a L;
        if (eVar == null || (L = eVar.L()) == null || TextUtils.equals("1", L.c0())) {
            return;
        }
        String H = L.H();
        if (TextUtils.equals("sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u", H) || TextUtils.equals("g4X7FfGEDt7G1ksLibU22o0wB2p49W0D", H) || TextUtils.equals("VlKQRMSyT32ln2AG84dmTjW6qldpGsNk", H)) {
            return;
        }
        if (f45346e) {
            Log.d("SwanHistoryManager", "addHistory: " + L.K() + " / " + H);
        }
        d.a.i0.a.w0.b a2 = d.a.i0.a.w0.b.a(L);
        boolean c2 = d.a.i0.a.j0.c.b.c(AppRuntime.getAppContext().getContentResolver(), a2, c0752b);
        a aVar = new a(H);
        if (c2) {
            e("ADD", a2.f45337a, a2.f45341e, a2.f45338b, a2.f45343g, a2.j, aVar);
        }
        if (!f45346e || c2) {
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
            if (f45346e) {
                e2.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static void e(String str, String str2, long j, String str3, String str4, String str5, d.a.i0.a.w0.a aVar) {
        String c2 = d.a.i0.a.c1.a.n().c();
        String d2 = d(str, str2, j, str3, str4, str5);
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        if (f45346e) {
            Log.d("SwanHistoryManager", "reportHistoryDataToServer: 上行参数" + d2);
        }
        b bVar = new b(aVar);
        d.a.i0.m.d.a aVar2 = new d.a.i0.m.d.a();
        aVar2.f47794b = "POST";
        aVar2.f47793a = c2;
        aVar2.f47798f = true;
        aVar2.f47799g = true;
        aVar2.f47796d = RequestBody.create(f.f43519a, d2);
        aVar2.f47797e = bVar;
        d.a.i0.m.e.a.g().e(aVar2);
    }
}
