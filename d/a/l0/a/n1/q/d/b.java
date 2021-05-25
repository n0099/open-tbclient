package d.a.l0.a.n1.q.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43756e = k.f43199a;

    /* renamed from: f  reason: collision with root package name */
    public static final b f43757f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f43758a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f43759b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f43760c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f43761d;

    public static b f() {
        return f43757f;
    }

    public void a(HybridUbcFlow hybridUbcFlow) {
        if (hybridUbcFlow == null) {
            return;
        }
        JSONArray e2 = e();
        if (e2 != null && e2.length() > 0) {
            hybridUbcFlow.A("ma_update_recorder", e2.toString());
        }
        c();
    }

    public String b(String str) {
        if (this.f43760c) {
            return null;
        }
        if (f43756e) {
            Log.d("MaUpdateRecorder", "begin update scope id - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        d dVar = new d(str);
        dVar.a(currentTimeMillis);
        synchronized (this.f43758a) {
            this.f43759b.put(str2, dVar);
        }
        if (f43756e) {
            Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
            Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
        }
        return str2;
    }

    public void c() {
        this.f43760c = true;
        synchronized (this.f43758a) {
            this.f43758a.clear();
            this.f43759b.clear();
        }
        if (f43756e) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void d(String str) {
        if (this.f43760c) {
            return;
        }
        if (f43756e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f43758a) {
            d dVar = this.f43759b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f43758a.add(dVar);
                this.f43759b.remove(str);
            }
        }
        if (f43756e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f43758a) {
            try {
                for (d dVar : this.f43758a) {
                    if (dVar != null && (this.f43761d == null || this.f43761d.a(dVar))) {
                        jSONArray.put(dVar.d());
                    }
                }
            } catch (Exception e2) {
                if (f43756e) {
                    e2.printStackTrace();
                }
            }
        }
        if (f43756e) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }

    public void g() {
        this.f43760c = false;
        synchronized (this.f43758a) {
            this.f43758a.clear();
            this.f43759b.clear();
        }
        if (f43756e) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void h(a aVar) {
        this.f43761d = aVar;
    }
}
