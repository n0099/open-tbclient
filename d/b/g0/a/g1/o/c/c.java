package d.b.g0.a.g1.o.c;

import android.util.Log;
import d.b.g0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final String f44967a = "SwanAppPayCheckNode";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f44968b;

    @Override // d.b.g0.a.g1.o.c.b
    public String a() {
        return "payinfo";
    }

    @Override // d.b.g0.a.g1.o.c.b
    public void b() {
        if (this.f44968b) {
            Log.d(this.f44967a, "onFail: ");
        }
    }

    @Override // d.b.g0.a.g1.o.c.b
    public void c() {
        if (this.f44968b) {
            Log.d(this.f44967a, "onFiltered: ");
        }
    }

    @Override // d.b.g0.a.g1.o.c.b
    public void d(JSONObject jSONObject, String str) {
        e O;
        d.b.g0.a.v1.a R;
        if (this.f44968b) {
            Log.d(this.f44967a, "onUpdate: ");
        }
        if (jSONObject == null || (O = e.O()) == null || (R = O.R()) == null) {
            return;
        }
        R.A("note_data_pay_check_list", jSONObject.toString());
    }
}
