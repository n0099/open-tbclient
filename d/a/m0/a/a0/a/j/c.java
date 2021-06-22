package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f44376a;

    /* renamed from: b  reason: collision with root package name */
    public float f44377b;

    /* renamed from: c  reason: collision with root package name */
    public float f44378c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44379d;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44376a != null) {
            if (!this.f44379d && Math.abs(this.f44378c) >= 360.0f) {
                Path path = bVar.j;
                RectF rectF = this.f44376a;
                float f2 = rectF.bottom;
                float f3 = rectF.top;
                path.addCircle((rectF.right + rectF.left) / 2.0f, (f2 + f3) / 2.0f, (f2 - f3) / 2.0f, Path.Direction.CW);
                bVar.j.arcTo(this.f44376a, 0.0f, this.f44377b);
                return;
            }
            float f4 = this.f44378c % 360.0f;
            if (f4 < 0.0f && !this.f44379d) {
                f4 += 360.0f;
            } else if (f4 > 0.0f && this.f44379d) {
                f4 -= 360.0f;
            }
            bVar.j.arcTo(this.f44376a, this.f44377b, f4);
        }
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int g2 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(0));
            int g3 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(1));
            int g4 = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
            this.f44376a = new RectF(g2 - g4, g3 - g4, g2 + g4, g3 + g4);
            this.f44377b = degrees;
            this.f44378c = degrees2 - degrees;
        }
        if (jSONArray.length() > 5) {
            this.f44379d = jSONArray.optBoolean(5);
        }
    }
}
