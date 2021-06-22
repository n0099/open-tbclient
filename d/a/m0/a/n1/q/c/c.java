package d.a.m0.a.n1.q.c;

import android.util.Log;
import d.a.m0.a.a2.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final String f47536a = "SwanAppPayCheckNode";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f47537b;

    @Override // d.a.m0.a.n1.q.c.b
    public String a() {
        return "payinfo";
    }

    @Override // d.a.m0.a.n1.q.c.b
    public void b() {
        if (this.f47537b) {
            Log.d(this.f47536a, "onFail: ");
        }
    }

    @Override // d.a.m0.a.n1.q.c.b
    public void c() {
        if (this.f47537b) {
            Log.d(this.f47536a, "onFiltered: ");
        }
    }

    @Override // d.a.m0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        e Q;
        d.a.m0.a.e2.a T;
        if (this.f47537b) {
            Log.d(this.f47536a, "onUpdate: ");
        }
        if (jSONObject == null || (Q = e.Q()) == null || (T = Q.T()) == null) {
            return;
        }
        T.B("note_data_pay_check_list", jSONObject.toString());
    }
}
