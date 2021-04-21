package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47713a;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47713a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47713a.c()) {
            bVar.f47692g.setShader(this.f47713a.b());
            return;
        }
        bVar.q = this.f47713a.a();
        bVar.f47692g.setColor(this.f47713a.a());
        bVar.f47691f.setShader(null);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47713a = new i(jSONArray);
        }
    }
}
