package d.a.n0.b1.m;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.baidu.tbadk.core.util.BitmapHelper;
/* loaded from: classes3.dex */
public class d extends BitmapDrawable {

    /* renamed from: a  reason: collision with root package name */
    public int f52897a;

    /* renamed from: b  reason: collision with root package name */
    public Context f52898b;

    /* renamed from: d  reason: collision with root package name */
    public String f52900d;

    /* renamed from: c  reason: collision with root package name */
    public Rect f52899c = null;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f52901e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f52902f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f52903g = 0;

    public d(Context context, int i2) {
        this.f52897a = 0;
        this.f52898b = null;
        this.f52900d = null;
        this.f52898b = context;
        this.f52897a = i2;
        this.f52900d = String.valueOf(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        if (this.f52897a <= 0 || this.f52898b == null) {
            return;
        }
        d.a.n0.a0.c k = d.a.n0.a0.c.k();
        d.a.c.k.d.a m = (k == null || (str2 = this.f52900d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f52898b, this.f52897a);
            if (resBitmap != null) {
                m = new d.a.c.k.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f52900d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f52899c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f52902f == 0 && this.f52903g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f52901e == null) {
                    Matrix matrix = new Matrix();
                    this.f52901e = matrix;
                    matrix.postTranslate(this.f52902f, this.f52903g);
                    Rect rect = this.f52899c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f52901e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f52901e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        this.f52899c = new Rect(i2, i3, i4, i5);
        this.f52901e = null;
        super.setBounds(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f52899c = new Rect(rect);
        this.f52901e = null;
        super.setBounds(rect);
    }
}
