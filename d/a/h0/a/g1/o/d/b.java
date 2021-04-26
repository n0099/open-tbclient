package d.a.h0.a.g1.o.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f42614e = k.f43101a;

    /* renamed from: f  reason: collision with root package name */
    public static final b f42615f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f42616a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f42617b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f42618c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f42619d;

    public static b f() {
        return f42615f;
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
        if (this.f42618c) {
            return null;
        }
        if (f42614e) {
            Log.d("MaUpdateRecorder", "begin update scope id - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        d dVar = new d(str);
        dVar.a(currentTimeMillis);
        synchronized (this.f42616a) {
            this.f42617b.put(str2, dVar);
        }
        if (f42614e) {
            Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
            Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
        }
        return str2;
    }

    public void c() {
        this.f42618c = true;
        synchronized (this.f42616a) {
            this.f42616a.clear();
            this.f42617b.clear();
        }
        if (f42614e) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void d(String str) {
        if (this.f42618c) {
            return;
        }
        if (f42614e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f42616a) {
            d dVar = this.f42617b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f42616a.add(dVar);
                this.f42617b.remove(str);
            }
        }
        if (f42614e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f42616a) {
            try {
                for (d dVar : this.f42616a) {
                    if (dVar != null && (this.f42619d == null || this.f42619d.a(dVar))) {
                        jSONArray.put(dVar.d());
                    }
                }
            } catch (Exception e2) {
                if (f42614e) {
                    e2.printStackTrace();
                }
            }
        }
        if (f42614e) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }

    public void g() {
        this.f42618c = false;
        synchronized (this.f42616a) {
            this.f42616a.clear();
            this.f42617b.clear();
        }
        if (f42614e) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void h(a aVar) {
        this.f42619d = aVar;
    }
}
