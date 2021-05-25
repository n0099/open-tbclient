package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class q0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f40668a;

    /* renamed from: b  reason: collision with root package name */
    public int f40669b;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (bVar.b() == 0) {
            bVar.c(canvas.save());
        }
        canvas.translate(this.f40668a, this.f40669b);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 1) {
            this.f40668a = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            this.f40669b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
        }
    }
}
