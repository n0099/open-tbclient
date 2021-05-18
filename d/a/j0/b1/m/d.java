package d.a.j0.b1.m;

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
    public int f49091a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49092b;

    /* renamed from: d  reason: collision with root package name */
    public String f49094d;

    /* renamed from: c  reason: collision with root package name */
    public Rect f49093c = null;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f49095e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f49096f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49097g = 0;

    public d(Context context, int i2) {
        this.f49091a = 0;
        this.f49092b = null;
        this.f49094d = null;
        this.f49092b = context;
        this.f49091a = i2;
        this.f49094d = String.valueOf(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        if (this.f49091a <= 0 || this.f49092b == null) {
            return;
        }
        d.a.j0.a0.c k = d.a.j0.a0.c.k();
        d.a.c.j.d.a m = (k == null || (str2 = this.f49094d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f49092b, this.f49091a);
            if (resBitmap != null) {
                m = new d.a.c.j.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f49094d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f49093c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f49096f == 0 && this.f49097g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f49095e == null) {
                    Matrix matrix = new Matrix();
                    this.f49095e = matrix;
                    matrix.postTranslate(this.f49096f, this.f49097g);
                    Rect rect = this.f49093c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f49095e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f49095e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        this.f49093c = new Rect(i2, i3, i4, i5);
        this.f49095e = null;
        super.setBounds(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f49093c = new Rect(rect);
        this.f49095e = null;
        super.setBounds(rect);
    }
}
