package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47027a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47027a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47027a.c()) {
            bVar.f46970g.setShader(this.f47027a.b());
            return;
        }
        bVar.q = this.f47027a.a();
        bVar.f46970g.setColor(this.f47027a.a());
        bVar.f46969f.setShader(null);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47027a = new i(jSONArray);
        }
    }
}
