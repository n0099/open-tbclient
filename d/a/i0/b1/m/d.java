package d.a.i0.b1.m;

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
    public int f48263a;

    /* renamed from: b  reason: collision with root package name */
    public Context f48264b;

    /* renamed from: d  reason: collision with root package name */
    public String f48266d;

    /* renamed from: c  reason: collision with root package name */
    public Rect f48265c = null;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f48267e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f48268f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f48269g = 0;

    public d(Context context, int i2) {
        this.f48263a = 0;
        this.f48264b = null;
        this.f48266d = null;
        this.f48264b = context;
        this.f48263a = i2;
        this.f48266d = String.valueOf(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        if (this.f48263a <= 0 || this.f48264b == null) {
            return;
        }
        d.a.i0.a0.c k = d.a.i0.a0.c.k();
        d.a.c.j.d.a m = (k == null || (str2 = this.f48266d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f48264b, this.f48263a);
            if (resBitmap != null) {
                m = new d.a.c.j.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f48266d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f48265c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f48268f == 0 && this.f48269g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f48267e == null) {
                    Matrix matrix = new Matrix();
                    this.f48267e = matrix;
                    matrix.postTranslate(this.f48268f, this.f48269g);
                    Rect rect = this.f48265c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f48267e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f48267e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        this.f48265c = new Rect(i2, i3, i4, i5);
        this.f48267e = null;
        super.setBounds(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f48265c = new Rect(rect);
        this.f48267e = null;
        super.setBounds(rect);
    }
}
