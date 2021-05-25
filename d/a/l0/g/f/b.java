package d.a.l0.g.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.l0.a.k;
import d.a.l0.a.p.d.f1;
import d.a.l0.g.c.c.f;
import d.a.l0.g.c.c.g;
import d.a.l0.g.c.c.h;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements f1 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47078b = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, a> f47079a = new HashMap<>();

    public b() {
        c();
    }

    @Override // d.a.l0.a.p.d.f1
    public d.a.l0.a.u.h.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        return b(str, jSONObject, bVar);
    }

    public final d.a.l0.a.u.h.b b(String str, JSONObject jSONObject, d.a.l0.a.u0.b bVar) {
        a aVar = this.f47079a.get(str);
        if (aVar != null) {
            if (f47078b) {
                Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
            }
            return aVar.a(jSONObject, bVar);
        }
        if (f47078b) {
            Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
        }
        return new d.a.l0.a.u.h.b(10002, "no such api.");
    }

    public final void c() {
        d(new d.a.l0.g.e.a());
        d(new d.a.l0.g.e.b());
        d(new d.a.l0.g.c.c.b());
        d(new f());
        d(new d.a.l0.g.c.c.c());
        d(new d.a.l0.g.i.e.a());
        d(new d.a.l0.g.c.c.d());
        d(new d.a.l0.g.g.a());
        d(new d.a.l0.g.i.c.b());
        d(new d.a.l0.g.c.c.a());
        d(new h());
        d(new d.a.l0.g.c.c.e());
        d(new g());
        d(new d.a.l0.g.i.a.a());
        d(new d.a.l0.g.i.d.b());
        d(new d.a.l0.g.i.b.a());
        d(new d.a.l0.g.i.c.a());
        d(new d.a.l0.g.i.b.b());
    }

    public void d(a aVar) {
        if (f47078b && TextUtils.isEmpty(aVar.f47077a)) {
            throw new IllegalArgumentException("action name is null");
        }
        if (f47078b && this.f47079a.containsKey(aVar.f47077a)) {
            throw new IllegalArgumentException("duplicate action: " + aVar);
        }
        this.f47079a.put(aVar.f47077a, aVar);
    }
}
