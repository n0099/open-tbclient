package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47749a;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47749a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47749a.c()) {
            bVar.f47692g.setShader(this.f47749a.b());
            return;
        }
        bVar.q = this.f47749a.a();
        bVar.f47692g.setColor(this.f47749a.a());
        bVar.f47691f.setShader(null);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47749a = new i(jSONArray);
        }
    }
}
