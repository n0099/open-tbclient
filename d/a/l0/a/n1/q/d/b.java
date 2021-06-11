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
    public static final boolean f47432e = k.f46875a;

    /* renamed from: f  reason: collision with root package name */
    public static final b f47433f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f47434a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f47435b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f47436c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f47437d;

    public static b f() {
        return f47433f;
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
        if (this.f47436c) {
            return null;
        }
        if (f47432e) {
            Log.d("MaUpdateRecorder", "begin update scope id - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        d dVar = new d(str);
        dVar.a(currentTimeMillis);
        synchronized (this.f47434a) {
            this.f47435b.put(str2, dVar);
        }
        if (f47432e) {
            Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
            Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
        }
        return str2;
    }

    public void c() {
        this.f47436c = true;
        synchronized (this.f47434a) {
            this.f47434a.clear();
            this.f47435b.clear();
        }
        if (f47432e) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void d(String str) {
        if (this.f47436c) {
            return;
        }
        if (f47432e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f47434a) {
            d dVar = this.f47435b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f47434a.add(dVar);
                this.f47435b.remove(str);
            }
        }
        if (f47432e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f47434a) {
            try {
                for (d dVar : this.f47434a) {
                    if (dVar != null && (this.f47437d == null || this.f47437d.a(dVar))) {
                        jSONArray.put(dVar.d());
                    }
                }
            } catch (Exception e2) {
                if (f47432e) {
                    e2.printStackTrace();
                }
            }
        }
        if (f47432e) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }

    public void g() {
        this.f47436c = false;
        synchronized (this.f47434a) {
            this.f47434a.clear();
            this.f47435b.clear();
        }
        if (f47432e) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void h(a aVar) {
        this.f47437d = aVar;
    }
}
