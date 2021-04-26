package d.a.h0.a.g1.o.c;

import android.util.Log;
import d.a.h0.a.r1.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public final String f42610a = "SwanAppPayCheckNode";

    /* renamed from: b  reason: collision with root package name */
    public final boolean f42611b;

    @Override // d.a.h0.a.g1.o.c.b
    public String a() {
        return "payinfo";
    }

    @Override // d.a.h0.a.g1.o.c.b
    public void b() {
        if (this.f42611b) {
            Log.d(this.f42610a, "onFail: ");
        }
    }

    @Override // d.a.h0.a.g1.o.c.b
    public void c() {
        if (this.f42611b) {
            Log.d(this.f42610a, "onFiltered: ");
        }
    }

    @Override // d.a.h0.a.g1.o.c.b
    public void d(JSONObject jSONObject, String str) {
        e O;
        d.a.h0.a.v1.a R;
        if (this.f42611b) {
            Log.d(this.f42610a, "onUpdate: ");
        }
        if (jSONObject == null || (O = e.O()) == null || (R = O.R()) == null) {
            return;
        }
        R.A("note_data_pay_check_list", jSONObject.toString());
    }
}
