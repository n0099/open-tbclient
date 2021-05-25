package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class b0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public DashPathEffect f40591a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        DashPathEffect dashPathEffect = this.f40591a;
        if (dashPathEffect != null) {
            bVar.f40588g.setPathEffect(dashPathEffect);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        float[] fArr;
        JSONArray optJSONArray;
        int length;
        if (jSONArray.length() <= 0 || (optJSONArray = jSONArray.optJSONArray(0)) == null || (length = optJSONArray.length()) <= 0) {
            fArr = null;
        } else {
            fArr = new float[length];
            for (int i2 = 0; i2 < length; i2++) {
                fArr[i2] = d.a.l0.a.v2.n0.g((float) optJSONArray.optDouble(i2));
            }
        }
        int g2 = jSONArray.length() > 1 ? d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1)) : 0;
        if (fArr == null || g2 < 0) {
            return;
        }
        this.f40591a = new DashPathEffect(fArr, g2);
    }
}
