package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f44282a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f44283b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f44284c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f44282a != null) {
            this.f44283b.setXfermode(this.f44284c);
            canvas.drawRect(this.f44282a, this.f44283b);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int g2 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(0));
                int g3 = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f44282a = new Rect(g2, g3, d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2)) + g2, d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3)) + g3);
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f46875a) {
                e2.printStackTrace();
            }
        }
    }
}
