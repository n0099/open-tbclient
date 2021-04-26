package d.a.h0.f.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.k;
import d.a.h0.a.p.c.w0;
import d.a.h0.f.f.c.f;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements w0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46028b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f46029a = new HashMap<>();

    public b() {
        c();
    }

    @Override // d.a.h0.a.p.c.w0
    public d.a.h0.a.t.e.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.h0.a.p0.b bVar) {
        return b(str, jSONObject, bVar);
    }

    public final d.a.h0.a.t.e.b b(String str, JSONObject jSONObject, d.a.h0.a.p0.b bVar) {
        a aVar = this.f46029a.get(str);
        if (aVar != null) {
            if (f46028b) {
                Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
            }
            return aVar.a(jSONObject, bVar);
        } else if (!f46028b) {
            return new d.a.h0.a.t.e.b(10002, "no such api.");
        } else {
            throw new NullPointerException("action has not found: " + str + ", params: " + jSONObject);
        }
    }

    public final void c() {
        d(new d.a.h0.f.h.a());
        d(new d.a.h0.f.h.b());
        d(new d.a.h0.f.f.c.b());
        d(new d.a.h0.f.f.c.e());
        d(new d.a.h0.f.f.c.c());
        d(new d.a.h0.f.k.b.a());
        d(new d.a.h0.f.f.c.d());
        d(new d.a.h0.f.j.a());
        d(new d.a.h0.f.k.a.a());
        d(new d.a.h0.f.f.c.a());
        d(new f());
    }

    public void d(a aVar) {
        if (f46028b && TextUtils.isEmpty(aVar.f46027a)) {
            throw new IllegalArgumentException("action name is null");
        }
        if (f46028b && this.f46029a.containsKey(aVar.f46027a)) {
            throw new IllegalArgumentException("duplicate action: " + aVar);
        }
        this.f46029a.put(aVar.f46027a, aVar);
    }
}
