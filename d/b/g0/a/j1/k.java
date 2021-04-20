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
    public static final boolean f45285e = d.b.g0.a.k.f45443a;

    /* renamed from: f  reason: collision with root package name */
    public static k f45286f;

    /* renamed from: b  reason: collision with root package name */
    public String[] f45288b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, JSONArray> f45287a = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    public String f45289c = "";

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f45290d = new HashMap();

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
        public AtomicInteger f45291a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        public boolean f45292b;

        /* renamed from: c  reason: collision with root package name */
        public int f45293c;

        /* renamed from: d  reason: collision with root package name */
        public a f45294d;

        public b(int i, a aVar) {
            this.f45293c = i;
            this.f45294d = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar;
            if (this.f45292b || this.f45291a.incrementAndGet() < this.f45293c || (aVar = this.f45294d) == null) {
                return;
            }
            aVar.b(d.b.g0.a.h.aiapps_debug_report_fail);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            this.f45292b = true;
            k.this.f45287a = new ArrayMap();
            a aVar = this.f45294d;
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
                    if (k.f45285e) {
                        Log.d("TraceDataManager", "Trace Data publish fail for IOException", e2);
                    }
                }
            }
            return null;
        }
    }

    public static k e() {
        if (f45286f == null) {
            synchronized (k.class) {
                if (f45286f == null) {
                    f45286f = new k();
                }
            }
        }
        return f45286f;
    }

    public void c(JSONObject jSONObject) {
        if (this.f45287a == null || jSONObject == null) {
            return;
        }
        String U = d.b.g0.a.z0.f.V().U();
        JSONArray jSONArray = this.f45287a.get(U);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            this.f45287a.put(U, jSONArray);
        }
        jSONArray.put(jSONObject);
    }

    public final String d(int i) {
        if (!f() || i >= this.f45288b.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(this.f45288b[i]);
        sb.append(":");
        sb.append(this.f45289c);
        sb.append("/uploadTraceData");
        sb.append("?");
        for (Map.Entry<String, String> entry : this.f45290d.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public boolean f() {
        String[] strArr = this.f45288b;
        return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(this.f45289c)) ? false : true;
    }

    public void g(a aVar) {
        if (!f()) {
            d.b.g0.a.q1.b.f.d.e(d.b.g0.a.r1.d.e().n(), d.b.g0.a.h.aiapps_debug_report_invalid_params).C();
            return;
        }
        Map<String, JSONArray> map = this.f45287a;
        if (map != null && map.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.f45287a.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("path", entry.getKey());
                    jSONObject.putOpt("data", entry.getValue().toString());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e2) {
                if (f45285e) {
                    Log.e("TraceDataManager", "Maybe the format of the Trace data is incorrect", e2);
                }
            }
            d.b.g0.k.c.f postRequest = d.b.g0.k.e.a.f().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.f45288b.length, 4);
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
            if (f45285e) {
                Log.d("TraceDataManager", "IP : " + string);
                Log.d("TraceDataManager", "Port : " + string2);
                Log.d("TraceDataManager", "Project ID : " + string3);
            }
            this.f45288b = string.split("_");
            this.f45289c = string2;
            this.f45290d.put("projectId", string3);
        } else if (f45285e) {
            Log.d("TraceDataManager", "Trace Data Params is invalid");
        }
    }
}
