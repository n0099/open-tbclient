package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class b0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public DashPathEffect f46973a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        DashPathEffect dashPathEffect = this.f46973a;
        if (dashPathEffect != null) {
            bVar.f46971g.setPathEffect(dashPathEffect);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        float[] fArr;
        JSONArray optJSONArray;
        int length;
        if (jSONArray.length() <= 0 || (optJSONArray = jSONArray.optJSONArray(0)) == null || (length = optJSONArray.length()) <= 0) {
            fArr = null;
        } else {
            fArr = new float[length];
            for (int i = 0; i < length; i++) {
                fArr[i] = d.b.g0.a.i2.h0.f((float) optJSONArray.optDouble(i));
            }
        }
        int f2 = jSONArray.length() > 1 ? d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1)) : 0;
        if (fArr == null || f2 < 0) {
            return;
        }
        this.f46973a = new DashPathEffect(fArr, f2);
    }
}
