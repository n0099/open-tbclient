package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f44431a;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f44431a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f44431a.c()) {
            bVar.f44372g.setShader(this.f44431a.b());
            return;
        }
        bVar.q = this.f44431a.a();
        bVar.f44372g.setColor(this.f44431a.a());
        bVar.f44371f.setShader(null);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f44431a = new i(jSONArray);
        }
    }
}
