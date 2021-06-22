package d.a.m0.g.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.m0.a.k;
import d.a.m0.a.p.d.f1;
import d.a.m0.g.c.c.f;
import d.a.m0.g.c.c.g;
import d.a.m0.g.c.c.h;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements f1 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50860b = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f50861a = new HashMap<>();

    public b() {
        c();
    }

    @Override // d.a.m0.a.p.d.f1
    public d.a.m0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.m0.a.u0.b bVar) {
        return b(str, jSONObject, bVar);
    }

    public final d.a.m0.a.u.h.b b(String str, JSONObject jSONObject, d.a.m0.a.u0.b bVar) {
        a aVar = this.f50861a.get(str);
        if (aVar != null) {
            if (f50860b) {
                Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
            }
            return aVar.a(jSONObject, bVar);
        }
        if (f50860b) {
            Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
        }
        return new d.a.m0.a.u.h.b(10002, "no such api.");
    }

    public final void c() {
        d(new d.a.m0.g.e.a());
        d(new d.a.m0.g.e.b());
        d(new d.a.m0.g.c.c.b());
        d(new f());
        d(new d.a.m0.g.c.c.c());
        d(new d.a.m0.g.i.e.a());
        d(new d.a.m0.g.c.c.d());
        d(new d.a.m0.g.g.a());
        d(new d.a.m0.g.i.c.b());
        d(new d.a.m0.g.c.c.a());
        d(new h());
        d(new d.a.m0.g.c.c.e());
        d(new g());
        d(new d.a.m0.g.i.a.a());
        d(new d.a.m0.g.i.d.b());
        d(new d.a.m0.g.i.b.a());
        d(new d.a.m0.g.i.c.a());
        d(new d.a.m0.g.i.b.b());
    }

    public void d(a aVar) {
        if (f50860b && TextUtils.isEmpty(aVar.f50859a)) {
            throw new IllegalArgumentException("action name is null");
        }
        if (f50860b && this.f50861a.containsKey(aVar.f50859a)) {
            throw new IllegalArgumentException("duplicate action: " + aVar);
        }
        this.f50861a.put(aVar.f50859a, aVar);
    }
}
