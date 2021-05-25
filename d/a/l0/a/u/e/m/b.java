package d.a.l0.a.u.e.m;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.mobstat.Config;
import d.a.l0.a.a1.e;
import d.a.l0.a.k2.h.c;
import d.a.l0.a.k2.h.d;
import d.a.l0.a.v2.q;
import d.a.l0.t.j;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.l0.a.u.e.m.a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile d.a.l0.t.b f45145d;

    /* renamed from: e  reason: collision with root package name */
    public static long f45146e;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            long unused = b.f45146e = b.f45145d.d();
        }
    }

    public b(@NonNull d.a.l0.a.u.c.b bVar) {
        super(bVar);
        synchronized (b.class) {
            if (f45145d == null) {
                L();
            }
        }
    }

    public static synchronized void L() {
        synchronized (b.class) {
            if (f45145d == null) {
                try {
                    f45145d = new c("swan_js_global_storage", 2, e.g().getAbsolutePath());
                } catch (NoClassDefFoundError | UnsatisfiedLinkError unused) {
                    f45145d = new j("swan_js_global_storage");
                    d.i(1, "swan_js_global_storage");
                }
                M();
            }
        }
    }

    public static void M() {
        if (f45145d != null) {
            q.e().execute(new a());
        }
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b D(String str) {
        return super.D(str);
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b E(String str) {
        return super.E(str);
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b F(String str) {
        return super.F(str);
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b G(String str) {
        return super.G(str);
    }

    @Override // d.a.l0.a.u.e.m.a
    public void H() {
        M();
    }

    public d.a.l0.a.u.h.b K() {
        return w();
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b r() {
        return super.r();
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b s() {
        return super.s();
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b t(String str) {
        return super.t(str);
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.t.b v(@NonNull d.a.l0.a.a2.e eVar) {
        return f45145d;
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SavedStateHandle.KEYS, new JSONArray((Collection) f45145d.a()));
            jSONObject.put("currentSize", f45146e / 1024);
            jSONObject.put("limitSize", 10240);
            return new d.a.l0.a.u.h.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.a.l0.a.u.c.d.f44812c) {
                e2.printStackTrace();
            }
            return new d.a.l0.a.u.h.b(202, "JSONException");
        }
    }

    @Override // d.a.l0.a.u.e.m.a
    public d.a.l0.a.u.h.b x(String str) {
        return super.x(str);
    }

    @Override // d.a.l0.a.u.e.m.a
    public boolean y() {
        return false;
    }

    @Override // d.a.l0.a.u.e.m.a
    public boolean z(@Nullable d.a.l0.a.a2.e eVar, @NonNull String str, @NonNull String str2) {
        return (f45146e - ((long) f45145d.getString(str, "").length())) + ((long) str2.length()) > Config.FULL_TRACE_LOG_LIMIT;
    }
}
