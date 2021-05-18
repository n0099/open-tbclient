package d.a.i0.a.n1.q.c;

import android.util.Log;
import d.a.i0.a.a2.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final String f43578a = "SwanAppPayCheckNode";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f43579b;

    @Override // d.a.i0.a.n1.q.c.b
    public String a() {
        return "payinfo";
    }

    @Override // d.a.i0.a.n1.q.c.b
    public void b() {
        if (this.f43579b) {
            Log.d(this.f43578a, "onFail: ");
        }
    }

    @Override // d.a.i0.a.n1.q.c.b
    public void c() {
        if (this.f43579b) {
            Log.d(this.f43578a, "onFiltered: ");
        }
    }

    @Override // d.a.i0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        e Q;
        d.a.i0.a.e2.a T;
        if (this.f43579b) {
            Log.d(this.f43578a, "onUpdate: ");
        }
        if (jSONObject == null || (Q = e.Q()) == null || (T = Q.T()) == null) {
            return;
        }
        T.B("note_data_pay_check_list", jSONObject.toString());
    }
}
