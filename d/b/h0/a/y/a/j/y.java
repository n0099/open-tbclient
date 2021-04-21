package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class y extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f47782a;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i = this.f47782a;
        if (i > 0) {
            bVar.i.setTextSize(i);
        }
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                this.f47782a = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
