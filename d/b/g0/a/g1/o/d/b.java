package d.b.g0.a.g1.o.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f44579e = k.f45051a;

    /* renamed from: f  reason: collision with root package name */
    public static final b f44580f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f44581a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f44582b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f44583c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f44584d;

    public static b f() {
        return f44580f;
    }

    public void a(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow == null) {
            return;
        }
        JSONArray e2 = e();
        if (e2 != null && e2.length() > 0) {
            hybridUbcFlow.y("ma_update_recorder", e2.toString());
        }
        c();
    }

    public String b(String str) {
        if (this.f44583c) {
            return null;
        }
        if (f44579e) {
            Log.d("MaUpdateRecorder", "begin update scope id - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        d dVar = new d(str);
        dVar.a(currentTimeMillis);
        synchronized (this.f44581a) {
            this.f44582b.put(str2, dVar);
        }
        if (f44579e) {
            Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
            Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
        }
        return str2;
    }

    public void c() {
        this.f44583c = true;
        synchronized (this.f44581a) {
            this.f44581a.clear();
            this.f44582b.clear();
        }
        if (f44579e) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void d(String str) {
        if (this.f44583c) {
            return;
        }
        if (f44579e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f44581a) {
            d dVar = this.f44582b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f44581a.add(dVar);
                this.f44582b.remove(str);
            }
        }
        if (f44579e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f44581a) {
            try {
                for (d dVar : this.f44581a) {
                    if (dVar != null && (this.f44584d == null || this.f44584d.a(dVar))) {
                        jSONArray.put(dVar.d());
                    }
                }
            } catch (Exception e2) {
                if (f44579e) {
                    e2.printStackTrace();
                }
            }
        }
        if (f44579e) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }

    public void g() {
        this.f44583c = false;
        synchronized (this.f44581a) {
            this.f44581a.clear();
            this.f44582b.clear();
        }
        if (f44579e) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void h(a aVar) {
        this.f44584d = aVar;
    }
}
