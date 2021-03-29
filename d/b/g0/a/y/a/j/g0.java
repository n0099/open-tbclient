package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f46992a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f46992a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f46992a.c()) {
            bVar.f46971g.setShader(this.f46992a.b());
            return;
        }
        bVar.q = this.f46992a.a();
        bVar.f46971g.setColor(this.f46992a.a());
        bVar.f46970f.setShader(null);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f46992a = new i(jSONArray);
        }
    }
}
