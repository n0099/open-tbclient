package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f40505a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f40505a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f40505a.c()) {
            bVar.f40413f.setShader(this.f40505a.b());
            return;
        }
        bVar.f40416i.setColor(this.f40505a.a());
        bVar.f40413f.setColor(this.f40505a.a());
        bVar.f40413f.setShader(null);
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f40505a = new i(jSONArray);
        }
    }
}
