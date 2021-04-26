package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f45188a;

    /* renamed from: b  reason: collision with root package name */
    public int f45189b;

    /* renamed from: c  reason: collision with root package name */
    public int f45190c;

    /* renamed from: d  reason: collision with root package name */
    public float f45191d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f45192e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f45193f = 1.0f;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (TextUtils.isEmpty(this.f45188a)) {
            return;
        }
        TextPaint textPaint = bVar.f45126i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f45190c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f45192e == 0.0d) {
            Rect rect = new Rect();
            String str = this.f45188a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f45191d != -1.0f) {
                float f7 = this.f45191d;
                if (rect.width() > f7) {
                    this.f45192e = f7 / rect.width();
                }
            }
            this.f45192e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f45193f);
        textPaint.setColor(bVar.q);
        bVar.d(textPaint);
        canvas.scale(this.f45192e, 1.0f);
        canvas.drawText(this.f45188a, this.f45189b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.f45188a = jSONArray.optString(0);
                this.f45189b = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f45190c = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.f45191d = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(3));
                }
                this.f45193f = d.a.h0.a.i2.h0.f(1.0f);
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
