package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    public Rect f45142a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f45143b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffXfermode f45144c = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (this.f45142a != null) {
            this.f45143b.setXfermode(this.f45144c);
            canvas.drawRect(this.f45142a, this.f45143b);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f45142a = new Rect(f2, f3, d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(2)) + f2, d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(3)) + f3);
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
