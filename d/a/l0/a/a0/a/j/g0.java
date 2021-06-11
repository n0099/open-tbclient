package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f44286a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f44286a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f44286a.c()) {
            bVar.f44264g.setShader(this.f44286a.b());
            return;
        }
        bVar.q = this.f44286a.a();
        bVar.f44264g.setColor(this.f44286a.a());
        bVar.f44263f.setShader(null);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f44286a = new i(jSONArray);
        }
    }
}
