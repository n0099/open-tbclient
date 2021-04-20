package d.b.g0.f.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.k;
import d.b.g0.a.p.c.w0;
import d.b.g0.f.f.c.f;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements w0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48238b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f48239a = new HashMap<>();

    public b() {
        c();
    }

    @Override // d.b.g0.a.p.c.w0
    public d.b.g0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        return b(str, jSONObject, bVar);
    }

    public final d.b.g0.a.t.e.b b(String str, JSONObject jSONObject, d.b.g0.a.p0.b bVar) {
        a aVar = this.f48239a.get(str);
        if (aVar != null) {
            if (f48238b) {
                Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
            }
            return aVar.a(jSONObject, bVar);
        } else if (!f48238b) {
            return new d.b.g0.a.t.e.b(10002, "no such api.");
        } else {
            throw new NullPointerException("action has not found: " + str + ", params: " + jSONObject);
        }
    }

    public final void c() {
        d(new d.b.g0.f.h.a());
        d(new d.b.g0.f.h.b());
        d(new d.b.g0.f.f.c.b());
        d(new d.b.g0.f.f.c.e());
        d(new d.b.g0.f.f.c.c());
        d(new d.b.g0.f.k.b.a());
        d(new d.b.g0.f.f.c.d());
        d(new d.b.g0.f.j.a());
        d(new d.b.g0.f.k.a.a());
        d(new d.b.g0.f.f.c.a());
        d(new f());
    }

    public void d(a aVar) {
        if (f48238b && TextUtils.isEmpty(aVar.f48237a)) {
            throw new IllegalArgumentException("action name is null");
        }
        if (f48238b && this.f48239a.containsKey(aVar.f48237a)) {
            throw new IllegalArgumentException("duplicate action: " + aVar);
        }
        this.f48239a.put(aVar.f48237a, aVar);
    }
}
