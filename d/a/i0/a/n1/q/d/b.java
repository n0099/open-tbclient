package d.a.i0.a.n1.q.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.i0.a.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43582e = k.f43025a;

    /* renamed from: f  reason: collision with root package name */
    public static final b f43583f = new b();

    /* renamed from: a  reason: collision with root package name */
    public final List<d> f43584a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, d> f43585b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public boolean f43586c = false;

    /* renamed from: d  reason: collision with root package name */
    public a f43587d;

    public static b f() {
        return f43583f;
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
        if (this.f43586c) {
            return null;
        }
        if (f43582e) {
            Log.d("MaUpdateRecorder", "begin update scope id - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = Thread.currentThread().getName() + "-" + UUID.randomUUID().toString();
        d dVar = new d(str);
        dVar.a(currentTimeMillis);
        synchronized (this.f43584a) {
            this.f43585b.put(str2, dVar);
        }
        if (f43582e) {
            Log.d("MaUpdateRecorder", "begin update uni tag - " + str2);
            Log.d("MaUpdateRecorder", "begin update ts - " + currentTimeMillis);
        }
        return str2;
    }

    public void c() {
        this.f43586c = true;
        synchronized (this.f43584a) {
            this.f43584a.clear();
            this.f43585b.clear();
        }
        if (f43582e) {
            Log.d("MaUpdateRecorder", AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public void d(String str) {
        if (this.f43586c) {
            return;
        }
        if (f43582e) {
            Log.d("MaUpdateRecorder", "end update uni tag - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f43584a) {
            d dVar = this.f43585b.get(str);
            if (dVar != null) {
                dVar.c(currentTimeMillis);
                this.f43584a.add(dVar);
                this.f43585b.remove(str);
            }
        }
        if (f43582e) {
            Log.d("MaUpdateRecorder", "end update ts - " + currentTimeMillis);
        }
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.f43584a) {
            try {
                for (d dVar : this.f43584a) {
                    if (dVar != null && (this.f43587d == null || this.f43587d.a(dVar))) {
                        jSONArray.put(dVar.d());
                    }
                }
            } catch (Exception e2) {
                if (f43582e) {
                    e2.printStackTrace();
                }
            }
        }
        if (f43582e) {
            Log.d("MaUpdateRecorder", jSONArray.toString());
        }
        return jSONArray;
    }

    public void g() {
        this.f43586c = false;
        synchronized (this.f43584a) {
            this.f43584a.clear();
            this.f43585b.clear();
        }
        if (f43582e) {
            Log.d("MaUpdateRecorder", "reset");
        }
    }

    public void h(a aVar) {
        this.f43587d = aVar;
    }
}
