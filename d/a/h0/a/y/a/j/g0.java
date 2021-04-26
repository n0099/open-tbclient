package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f45146a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f45146a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f45146a.c()) {
            bVar.f45124g.setShader(this.f45146a.b());
            return;
        }
        bVar.q = this.f45146a.a();
        bVar.f45124g.setColor(this.f45146a.a());
        bVar.f45123f.setShader(null);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f45146a = new i(jSONArray);
        }
    }
}
