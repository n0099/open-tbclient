package d.a.l0.a.n1.q.c;

import android.util.Log;
import d.a.l0.a.a2.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final String f43752a = "SwanAppPayCheckNode";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f43753b;

    @Override // d.a.l0.a.n1.q.c.b
    public String a() {
        return "payinfo";
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void b() {
        if (this.f43753b) {
            Log.d(this.f43752a, "onFail: ");
        }
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void c() {
        if (this.f43753b) {
            Log.d(this.f43752a, "onFiltered: ");
        }
    }

    @Override // d.a.l0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        e Q;
        d.a.l0.a.e2.a T;
        if (this.f43753b) {
            Log.d(this.f43752a, "onUpdate: ");
        }
        if (jSONObject == null || (Q = e.Q()) == null || (T = Q.T()) == null) {
            return;
        }
        T.B("note_data_pay_check_list", jSONObject.toString());
    }
}
