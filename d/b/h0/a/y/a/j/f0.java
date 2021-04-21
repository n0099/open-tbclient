package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class f0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public k0 f47712a;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        k0 k0Var = this.f47712a;
        if (k0Var == null || !k0Var.b()) {
            return;
        }
        bVar.m = this.f47712a;
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        this.f47712a = new k0(jSONArray);
    }
}
