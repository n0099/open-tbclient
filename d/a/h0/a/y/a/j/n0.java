package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f45183a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f45183a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f45183a.c()) {
            bVar.f45124g.setShader(this.f45183a.b());
            return;
        }
        bVar.q = this.f45183a.a();
        bVar.f45124g.setColor(this.f45183a.a());
        bVar.f45123f.setShader(null);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f45183a = new i(jSONArray);
        }
    }
}
