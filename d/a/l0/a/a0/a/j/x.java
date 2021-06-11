package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f44355a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f44355a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f44355a.c()) {
            bVar.f44263f.setShader(this.f44355a.b());
            return;
        }
        bVar.f44266i.setColor(this.f44355a.a());
        bVar.f44263f.setColor(this.f44355a.a());
        bVar.f44263f.setShader(null);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f44355a = new i(jSONArray);
        }
    }
}
