package d.a.h0.a.j1;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidubce.AbstractBceClient;
import d.a.h0.a.q1.b.b.g;
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
/* loaded from: classes3.dex */
public class k {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42937e = d.a.h0.a.k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public static k f42938f;

    /* renamed from: b  reason: collision with root package name */
    public String[] f42940b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, JSONArray> f42939a = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    public String f42941c = "";

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f42942d = new HashMap();

    /* loaded from: classes3.dex */
    public static abstract class a {
        public final void b(int i2) {
            Application c2 = d.a.h0.a.w0.a.c();
            if (c2 != null) {
                c(c2.getString(i2));
            }
        }

        public abstract void c(String str);
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f42943a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        public boolean f42944b;

        /* renamed from: c  reason: collision with root package name */
        public int f42945c;

        /* renamed from: d  reason: collision with root package name */
        public a f42946d;

        public b(int i2, a aVar) {
            this.f42945c = i2;
            this.f42946d = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar;
            if (this.f42944b || this.f42943a.incrementAndGet() < this.f42945c || (aVar = this.f42946d) == null) {
                return;
            }
            aVar.b(d.a.h0.a.h.aiapps_debug_report_fail);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            this.f42944b = true;
            k.this.f42939a = new ArrayMap();
            a aVar = this.f42946d;
            if (aVar != null) {
                aVar.b(d.a.h0.a.h.aiapps_debug_report_success);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            if (response != null && response.body() != null && response.isSuccessful()) {
                try {
                    return response.body().string();
                } catch (IOException e2) {
                    if (k.f42937e) {
                        Log.d("TraceDataManager", "Trace Data publish fail for IOException", e2);
                    }
                }
            }
            return null;
        }
    }

    public static k e() {
        if (f42938f == null) {
            synchronized (k.class) {
                if (f42938f == null) {
                    f42938f = new k();
                }
            }
        }
        return f42938f;
    }

    public void c(JSONObject jSONObject) {
        if (this.f42939a == null || jSONObject == null) {
            return;
        }
        String U = d.a.h0.a.z0.f.V().U();
        JSONArray jSONArray = this.f42939a.get(U);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            this.f42939a.put(U, jSONArray);
        }
        jSONArray.put(jSONObject);
    }

    public final String d(int i2) {
        if (!f() || i2 >= this.f42940b.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(this.f42940b[i2]);
        sb.append(":");
        sb.append(this.f42941c);
        sb.append("/uploadTraceData");
        sb.append("?");
        for (Map.Entry<String, String> entry : this.f42942d.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public boolean f() {
        String[] strArr = this.f42940b;
        return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(this.f42941c)) ? false : true;
    }

    public void g(a aVar) {
        if (!f()) {
            d.a.h0.a.q1.b.f.d.e(d.a.h0.a.r1.d.e().v(), d.a.h0.a.h.aiapps_debug_report_invalid_params).C();
            return;
        }
        Map<String, JSONArray> map = this.f42939a;
        if (map != null && map.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.f42939a.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("path", entry.getKey());
                    jSONObject.putOpt("data", entry.getValue().toString());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e2) {
                if (f42937e) {
                    Log.e("TraceDataManager", "Maybe the format of the Trace data is incorrect", e2);
                }
            }
            d.a.h0.k.c.f postRequest = d.a.h0.k.e.a.f().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.f42940b.length, 4);
            b bVar = new b(min, aVar);
            for (int i2 = 0; i2 < min; i2++) {
                postRequest.url(d(i2));
                postRequest.build().executeAsync(bVar);
            }
            return;
        }
        g.a aVar2 = new g.a(d.a.h0.a.r1.d.e().v());
        aVar2.U(d.a.h0.a.h.aiapps_debug_report_performance);
        aVar2.w(d.a.h0.a.h.aiapps_debug_report_no_data);
        aVar2.n(new d.a.h0.a.j2.g.a());
        aVar2.O(d.a.h0.a.h.aiapps_ok, null);
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
            if (f42937e) {
                Log.d("TraceDataManager", "IP : " + string);
                Log.d("TraceDataManager", "Port : " + string2);
                Log.d("TraceDataManager", "Project ID : " + string3);
            }
            this.f42940b = string.split("_");
            this.f42941c = string2;
            this.f42942d.put("projectId", string3);
        } else if (f42937e) {
            Log.d("TraceDataManager", "Trace Data Params is invalid");
        }
    }
}
