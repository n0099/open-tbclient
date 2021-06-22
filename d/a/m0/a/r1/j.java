package d.a.m0.a.r1;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidubce.AbstractBceClient;
import d.a.m0.a.k;
import d.a.m0.a.z1.b.b.h;
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
public class j {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f48231e = k.f46983a;

    /* renamed from: f  reason: collision with root package name */
    public static j f48232f;

    /* renamed from: b  reason: collision with root package name */
    public String[] f48234b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, JSONArray> f48233a = new ArrayMap();

    /* renamed from: c  reason: collision with root package name */
    public String f48235c = "";

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f48236d = new HashMap();

    /* loaded from: classes3.dex */
    public static abstract class a {
        public final void b(int i2) {
            Application b2 = d.a.m0.a.c1.a.b();
            if (b2 != null) {
                c(b2.getString(i2));
            }
        }

        public abstract void c(String str);
    }

    /* loaded from: classes3.dex */
    public class b extends ResponseCallback {

        /* renamed from: a  reason: collision with root package name */
        public AtomicInteger f48237a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        public boolean f48238b;

        /* renamed from: c  reason: collision with root package name */
        public int f48239c;

        /* renamed from: d  reason: collision with root package name */
        public a f48240d;

        public b(int i2, a aVar) {
            this.f48239c = i2;
            this.f48240d = aVar;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            a aVar;
            if (this.f48238b || this.f48237a.incrementAndGet() < this.f48239c || (aVar = this.f48240d) == null) {
                return;
            }
            aVar.b(d.a.m0.a.h.aiapps_debug_report_fail);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            this.f48238b = true;
            j.this.f48233a = new ArrayMap();
            a aVar = this.f48240d;
            if (aVar != null) {
                aVar.b(d.a.m0.a.h.aiapps_debug_report_success);
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) {
            if (response != null && response.body() != null && response.isSuccessful()) {
                try {
                    return response.body().string();
                } catch (IOException e2) {
                    if (j.f48231e) {
                        Log.d("TraceDataManager", "Trace Data publish fail for IOException", e2);
                    }
                }
            }
            return null;
        }
    }

    public static j e() {
        if (f48232f == null) {
            synchronized (j.class) {
                if (f48232f == null) {
                    f48232f = new j();
                }
            }
        }
        return f48232f;
    }

    public void c(JSONObject jSONObject) {
        if (this.f48233a == null || jSONObject == null) {
            return;
        }
        String U = d.a.m0.a.g1.f.V().U();
        JSONArray jSONArray = this.f48233a.get(U);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            this.f48233a.put(U, jSONArray);
        }
        jSONArray.put(jSONObject);
    }

    public final String d(int i2) {
        if (!f() || i2 >= this.f48234b.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(this.f48234b[i2]);
        sb.append(":");
        sb.append(this.f48235c);
        sb.append("/uploadTraceData");
        sb.append("?");
        for (Map.Entry<String, String> entry : this.f48236d.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public boolean f() {
        String[] strArr = this.f48234b;
        return (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(this.f48235c)) ? false : true;
    }

    public void g(a aVar) {
        if (!f()) {
            d.a.m0.a.z1.b.f.e.f(d.a.m0.a.a2.d.g().x(), d.a.m0.a.h.aiapps_debug_report_invalid_params).F();
            return;
        }
        Map<String, JSONArray> map = this.f48233a;
        if (map != null && map.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, JSONArray> entry : this.f48233a.entrySet()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("path", entry.getKey());
                    jSONObject.putOpt("data", entry.getValue().toString());
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e2) {
                if (f48231e) {
                    Log.e("TraceDataManager", "Maybe the format of the Trace data is incorrect", e2);
                }
            }
            d.a.m0.m.c.f postRequest = d.a.m0.m.e.a.g().postRequest();
            postRequest.requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONArray.toString()));
            postRequest.connectionTimeout(3000);
            int min = Math.min(this.f48234b.length, 4);
            b bVar = new b(min, aVar);
            for (int i2 = 0; i2 < min; i2++) {
                postRequest.url(d(i2));
                postRequest.build().executeAsync(bVar);
            }
            return;
        }
        h.a aVar2 = new h.a(d.a.m0.a.a2.d.g().x());
        aVar2.U(d.a.m0.a.h.aiapps_debug_report_performance);
        aVar2.v(d.a.m0.a.h.aiapps_debug_report_no_data);
        aVar2.n(new d.a.m0.a.w2.h.a());
        aVar2.O(d.a.m0.a.h.aiapps_confirm, null);
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
            if (f48231e) {
                Log.d("TraceDataManager", "IP : " + string);
                Log.d("TraceDataManager", "Port : " + string2);
                Log.d("TraceDataManager", "Project ID : " + string3);
            }
            this.f48234b = string.split("_");
            this.f48235c = string2;
            this.f48236d.put("projectId", string3);
        } else if (f48231e) {
            Log.d("TraceDataManager", "Trace Data Params is invalid");
        }
    }
}
