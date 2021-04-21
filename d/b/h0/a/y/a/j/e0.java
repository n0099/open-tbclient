package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47708a = -1;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i = this.f47708a;
        if (i >= 0) {
            bVar.f47692g.setStrokeMiter(i);
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47708a = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
        }
    }
}
