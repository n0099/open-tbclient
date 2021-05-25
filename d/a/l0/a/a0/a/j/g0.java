package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f40610a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f40610a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f40610a.c()) {
            bVar.f40588g.setShader(this.f40610a.b());
            return;
        }
        bVar.q = this.f40610a.a();
        bVar.f40588g.setColor(this.f40610a.a());
        bVar.f40587f.setShader(null);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f40610a = new i(jSONArray);
        }
    }
}
