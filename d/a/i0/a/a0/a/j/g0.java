package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class g0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f40436a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f40436a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f40436a.c()) {
            bVar.f40414g.setShader(this.f40436a.b());
            return;
        }
        bVar.q = this.f40436a.a();
        bVar.f40414g.setColor(this.f40436a.a());
        bVar.f40413f.setShader(null);
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f40436a = new i(jSONArray);
        }
    }
}
