package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f44463a;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f44463a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f44463a.c()) {
            bVar.f44371f.setShader(this.f44463a.b());
            return;
        }
        bVar.f44374i.setColor(this.f44463a.a());
        bVar.f44371f.setColor(this.f44463a.a());
        bVar.f44371f.setShader(null);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f44463a = new i(jSONArray);
        }
    }
}
