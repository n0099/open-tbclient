package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47384a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47384a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47384a.c()) {
            bVar.f47363g.setShader(this.f47384a.b());
            return;
        }
        bVar.q = this.f47384a.a();
        bVar.f47363g.setColor(this.f47384a.a());
        bVar.f47362f.setShader(null);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47384a = new i(jSONArray);
        }
    }
}
