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
    public static final boolean f44971e = k.f45443a;

    /* renamed from: f  reason: collision with root package name */
    public static final b f44972f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f44973a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f44974b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f44975c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f44976d;

    public static b f() {
        return f44972f;
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
        if (this.f44975c) {
            return null;
        }
        if (f44971e) {
            Log.d("MaUpdateRecorder", "begin update scope id - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        d dVar = new d(str);
        dVar.a(currentTimeMillis);
        synchronized (this.f44973a) {
            this.f44974b.put(str2, dVar);
        }
        if (f44971e) {
            Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
            Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
        }
        return str2;
    }

    public void c() {
        this.f44975c = true;
        synchronized (this.f44973a) {
            this.f44973a.clear();
            this.f44974b.clear();
        }
        if (f44971e) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void d(String str) {
        if (this.f44975c) {
            return;
        }
        if (f44971e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f44973a) {
            d dVar = this.f44974b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f44973a.add(dVar);
                this.f44974b.remove(str);
            }
        }
        if (f44971e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f44973a) {
            try {
                for (d dVar : this.f44973a) {
                    if (dVar != null && (this.f44976d == null || this.f44976d.a(dVar))) {
                        jSONArray.put(dVar.d());
                    }
                }
            } catch (Exception e2) {
                if (f44971e) {
                    e2.printStackTrace();
                }
            }
        }
        if (f44971e) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }

    public void g() {
        this.f44975c = false;
        synchronized (this.f44973a) {
            this.f44973a.clear();
            this.f44974b.clear();
        }
        if (f44971e) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void h(a aVar) {
        this.f44976d = aVar;
    }
}
