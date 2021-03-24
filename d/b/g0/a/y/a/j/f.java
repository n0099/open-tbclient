package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f46987a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f46988b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f46989c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f46987a != null) {
            this.f46988b.setXfermode(this.f46989c);
            canvas.drawRect(this.f46987a, this.f46988b);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f46987a = new Rect(f2, f3, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2)) + f2, d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3)) + f3);
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
