package d.b.h0.a.g1.o.c;

import android.util.Log;
import d.b.h0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final String f45296a = "SwanAppPayCheckNode";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f45297b;

    @Override // d.b.h0.a.g1.o.c.b
    public String a() {
        return "payinfo";
    }

    @Override // d.b.h0.a.g1.o.c.b
    public void b() {
        if (this.f45297b) {
            Log.d(this.f45296a, "onFail: ");
        }
    }

    @Override // d.b.h0.a.g1.o.c.b
    public void c() {
        if (this.f45297b) {
            Log.d(this.f45296a, "onFiltered: ");
        }
    }

    @Override // d.b.h0.a.g1.o.c.b
    public void d(JSONObject jSONObject, String str) {
        e O;
        d.b.h0.a.v1.a R;
        if (this.f45297b) {
            Log.d(this.f45296a, "onUpdate: ");
        }
        if (jSONObject == null || (O = e.O()) == null || (R = O.R()) == null) {
            return;
        }
        R.A("note_data_pay_check_list", jSONObject.toString());
    }
}
