package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47028a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47028a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47028a.c()) {
            bVar.f46971g.setShader(this.f47028a.b());
            return;
        }
        bVar.q = this.f47028a.a();
        bVar.f46971g.setColor(this.f47028a.a());
        bVar.f46970f.setShader(null);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47028a = new i(jSONArray);
        }
    }
}
