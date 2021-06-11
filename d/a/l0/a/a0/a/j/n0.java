package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f44323a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f44323a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f44323a.c()) {
            bVar.f44264g.setShader(this.f44323a.b());
            return;
        }
        bVar.q = this.f44323a.a();
        bVar.f44264g.setColor(this.f44323a.a());
        bVar.f44263f.setShader(null);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f44323a = new i(jSONArray);
        }
    }
}
