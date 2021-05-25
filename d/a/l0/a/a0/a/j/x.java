package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f40679a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f40679a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f40679a.c()) {
            bVar.f40587f.setShader(this.f40679a.b());
            return;
        }
        bVar.f40590i.setColor(this.f40679a.a());
        bVar.f40587f.setColor(this.f40679a.a());
        bVar.f40587f.setShader(null);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f40679a = new i(jSONArray);
        }
    }
}
