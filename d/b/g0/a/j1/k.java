package d.b.g0.a.j1;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidubce.AbstractBceClient;
import d.b.g0.a.q1.b.b.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44893e = d.b.g0.a.k.f45051a;

    /* renamed from: f  reason: collision with root package name */
    public static k f44894f;

    /* renamed from: b  reason: collision with root package name */
    public String[] f44896b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, JSONArray> f44895a = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    public String f44897c = "";

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f44898d = new HashMap();

    /* loaded from: classes2.dex */
    public static abstract class a {
        public final void b(int i) {
            Application c2 = d.b.g0.a.w0.a.c();
            if (c2 != null) {
                c(c2.getString(i));
            }
        }

        public abstract void c(String str);
    }

    /* loaded from: classes2.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f44899a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        public boolean f44900b;

        /* renamed from: c  reason: collision with root package name */
        public int f44901c;

        /* renamed from: d  reason: collision with root package name */
        public a f44902d;

        public b(int i, a aVar) {
            this.f44901c = i;
            this.f44902d = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar;
            if (this.f44900b || this.f44899a.incrementAndGet() < this.f44901c || (aVar = this.f44902d) == null) {
                return;
            }
            aVar.b(d.b.g0.a.h.aiapps_debug_report_fail);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            this.f44900b = true;
            k.this.f44895a = new ArrayMap();
            a aVar = this.f44902d;
            if (aVar != null) {
                aVar.b(d.b.g0.a.h.aiapps_debug_report_success);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) {
            if (response != null && response.body() != null && response.isSuccessful()) {
                try {
                    return response.body().string();
                } catch (IOException e2) {
                    if (k.f44893e) {
                        Log.d("TraceDataManager", "Trace Data publish fail for IOException", e2);
                    }
                }
            }
            return null;
        }
    }

    public static k e() {
        if (f44894f == null) {
            synchronized (k.class) {
                if (f44894f == null) {
                    f44894f = new k();
                }
            }
        }
        return f44894f;
    }

    public void c(JSONObject jSONObject) {
        if (this.f44895a == null || jSONObject == null) {
            return;
        }
        String U = d.b.g0.a.z0.f.V().U();
        JSONArray jSONArray = this.f44895a.get(U);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            this.f44895a.put(U, jSONArray);
        }
        jSONArray.put(jSONObject);
    }

    public final String d(int i) {
        if (!f() || i >= this.f44896b.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(this.f44896b[i]);
        sb.append(":");
        sb.append(this.f44897c);
        sb.append("/uploadTraceData");
        sb.append("?");
        for (Map.Entry<String, String> entry : this.f44898d.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public boolean f() {
        String[] strArr = this.f44896b;
        return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(this.f44897c)) ? false : true;
    }

    public void g(a aVar) {
        if (!f()) {
            d.b.g0.a.q1.b.f.d.e(d.b.g0.a.r1.d.e().n(), d.b.g0.a.h.aiapps_debug_report_invalid_params).C();
            return;
        }
        Map<String, JSONArray> map = this.f44895a;
        if (map != null && map.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.f44895a.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("path", entry.getKey());
                    jSONObject.putOpt("data", entry.getValue().toString());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e2) {
                if (f44893e) {
                    Log.e("TraceDataManager", "Maybe the format of the Trace data is incorrect", e2);
                }
            }
            d.b.g0.k.c.f postRequest = d.b.g0.k.e.a.f().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.f44896b.length, 4);
            b bVar = new b(min, aVar);
            for (int i = 0; i < min; i++) {
                postRequest.url(d(i));
                postRequest.build().executeAsync(bVar);
            }
            return;
        }
        g.a aVar2 = new g.a(d.b.g0.a.r1.d.e().n());
        aVar2.U(d.b.g0.a.h.aiapps_debug_report_performance);
        aVar2.w(d.b.g0.a.h.aiapps_debug_report_no_data);
        aVar2.n(new d.b.g0.a.j2.g.a());
        aVar2.O(d.b.g0.a.h.aiapps_ok, null);
        aVar2.X();
    }

    public void h(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String string = bundle.getString("tool_ip");
        String string2 = bundle.getString("tool_port");
        String string3 = bundle.getString("projectId");
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
            if (f44893e) {
                Log.d("TraceDataManager", "IP : " + string);
                Log.d("TraceDataManager", "Port : " + string2);
                Log.d("TraceDataManager", "Project ID : " + string3);
            }
            this.f44896b = string.split("_");
            this.f44897c = string2;
            this.f44898d.put("projectId", string3);
        } else if (f44893e) {
            Log.d("TraceDataManager", "Trace Data Params is invalid");
        }
    }
}
