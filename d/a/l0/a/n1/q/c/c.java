package d.a.l0.a.n1.q.c;

import android.util.Log;
import d.a.l0.a.a2.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final String f47428a = "SwanAppPayCheckNode";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f47429b;

    @Override // d.a.l0.a.n1.q.c.b
    public String a() {
        return "payinfo";
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void b() {
        if (this.f47429b) {
            Log.d(this.f47428a, "onFail: ");
        }
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void c() {
        if (this.f47429b) {
            Log.d(this.f47428a, "onFiltered: ");
        }
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        e Q;
        d.a.l0.a.e2.a T;
        if (this.f47429b) {
            Log.d(this.f47428a, "onUpdate: ");
        }
        if (jSONObject == null || (Q = e.Q()) == null || (T = Q.T()) == null) {
            return;
        }
        T.B("note_data_pay_check_list", jSONObject.toString());
    }
}
