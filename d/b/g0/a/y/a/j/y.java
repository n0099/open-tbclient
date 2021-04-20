package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class y extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47453a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i = this.f47453a;
        if (i > 0) {
            bVar.i.setTextSize(i);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                this.f47453a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45443a) {
                e2.printStackTrace();
            }
        }
    }
}
