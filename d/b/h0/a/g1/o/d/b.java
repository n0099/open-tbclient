package d.b.h0.a.g1.o.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45300e = k.f45772a;

    /* renamed from: f  reason: collision with root package name */
    public static final b f45301f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f45302a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f45303b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f45304c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f45305d;

    public static b f() {
        return f45301f;
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
        if (this.f45304c) {
            return null;
        }
        if (f45300e) {
            Log.d("MaUpdateRecorder", "begin update scope id - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        d dVar = new d(str);
        dVar.a(currentTimeMillis);
        synchronized (this.f45302a) {
            this.f45303b.put(str2, dVar);
        }
        if (f45300e) {
            Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
            Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
        }
        return str2;
    }

    public void c() {
        this.f45304c = true;
        synchronized (this.f45302a) {
            this.f45302a.clear();
            this.f45303b.clear();
        }
        if (f45300e) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void d(String str) {
        if (this.f45304c) {
            return;
        }
        if (f45300e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f45302a) {
            d dVar = this.f45303b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f45302a.add(dVar);
                this.f45303b.remove(str);
            }
        }
        if (f45300e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f45302a) {
            try {
                for (d dVar : this.f45302a) {
                    if (dVar != null && (this.f45305d == null || this.f45305d.a(dVar))) {
                        jSONArray.put(dVar.d());
                    }
                }
            } catch (Exception e2) {
                if (f45300e) {
                    e2.printStackTrace();
                }
            }
        }
        if (f45300e) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }

    public void g() {
        this.f45304c = false;
        synchronized (this.f45302a) {
            this.f45302a.clear();
            this.f45303b.clear();
        }
        if (f45300e) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void h(a aVar) {
        this.f45305d = aVar;
    }
}
