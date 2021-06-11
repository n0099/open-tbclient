package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f44268a;

    /* renamed from: b  reason: collision with root package name */
    public float f44269b;

    /* renamed from: c  reason: collision with root package name */
    public float f44270c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44271d;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44268a != null) {
            if (!this.f44271d && Math.abs(this.f44270c) >= 360.0f) {
                Path path = bVar.j;
                RectF rectF = this.f44268a;
                float f2 = rectF.bottom;
                float f3 = rectF.top;
                path.addCircle((rectF.right + rectF.left) / 2.0f, (f2 + f3) / 2.0f, (f2 - f3) / 2.0f, Path.Direction.CW);
                bVar.j.arcTo(this.f44268a, 0.0f, this.f44269b);
                return;
            }
            float f4 = this.f44270c % 360.0f;
            if (f4 < 0.0f && !this.f44271d) {
                f4 += 360.0f;
            } else if (f4 > 0.0f && this.f44271d) {
                f4 -= 360.0f;
            }
            bVar.j.arcTo(this.f44268a, this.f44269b, f4);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 4) {
            int g2 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
            int g3 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
            int g4 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2));
            float degrees = (float) Math.toDegrees((float) jSONArray.optDouble(3));
            float degrees2 = (float) Math.toDegrees((float) jSONArray.optDouble(4));
            this.f44268a = new RectF(g2 - g4, g3 - g4, g2 + g4, g3 + g4);
            this.f44269b = degrees;
            this.f44270c = degrees2 - degrees;
        }
        if (jSONArray.length() > 5) {
            this.f44271d = jSONArray.optBoolean(5);
        }
    }
}
