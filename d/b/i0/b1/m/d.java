package d.b.i0.b1.m;

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
    public int f50696a;

    /* renamed from: b  reason: collision with root package name */
    public Context f50697b;

    /* renamed from: d  reason: collision with root package name */
    public String f50699d;

    /* renamed from: c  reason: collision with root package name */
    public Rect f50698c = null;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f50700e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f50701f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50702g = 0;

    public d(Context context, int i) {
        this.f50696a = 0;
        this.f50697b = null;
        this.f50699d = null;
        this.f50697b = context;
        this.f50696a = i;
        this.f50699d = String.valueOf(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        if (this.f50696a <= 0 || this.f50697b == null) {
            return;
        }
        d.b.i0.a0.c k = d.b.i0.a0.c.k();
        d.b.c.j.d.a m = (k == null || (str2 = this.f50699d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f50697b, this.f50696a);
            if (resBitmap != null) {
                m = new d.b.c.j.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f50699d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f50698c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f50701f == 0 && this.f50702g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f50700e == null) {
                    Matrix matrix = new Matrix();
                    this.f50700e = matrix;
                    matrix.postTranslate(this.f50701f, this.f50702g);
                    Rect rect = this.f50698c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f50700e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f50700e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.f50698c = new Rect(i, i2, i3, i4);
        this.f50700e = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f50698c = new Rect(rect);
        this.f50700e = null;
        super.setBounds(rect);
    }
}
