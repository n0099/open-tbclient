package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f46988a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f46989b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f46990c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f46988a != null) {
            this.f46989b.setXfermode(this.f46990c);
            canvas.drawRect(this.f46988a, this.f46989b);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f46988a = new Rect(f2, f3, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2)) + f2, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3)) + f3);
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45051a) {
                e2.printStackTrace();
            }
        }
    }
}
