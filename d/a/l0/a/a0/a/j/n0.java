package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f40647a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f40647a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f40647a.c()) {
            bVar.f40588g.setShader(this.f40647a.b());
            return;
        }
        bVar.q = this.f40647a.a();
        bVar.f40588g.setColor(this.f40647a.a());
        bVar.f40587f.setShader(null);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f40647a = new i(jSONArray);
        }
    }
}
