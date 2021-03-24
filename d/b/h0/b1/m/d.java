package d.b.h0.b1.m;

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
    public int f49966a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49967b;

    /* renamed from: d  reason: collision with root package name */
    public String f49969d;

    /* renamed from: c  reason: collision with root package name */
    public Rect f49968c = null;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f49970e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f49971f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49972g = 0;

    public d(Context context, int i) {
        this.f49966a = 0;
        this.f49967b = null;
        this.f49969d = null;
        this.f49967b = context;
        this.f49966a = i;
        this.f49969d = String.valueOf(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        if (this.f49966a <= 0 || this.f49967b == null) {
            return;
        }
        d.b.h0.a0.c j = d.b.h0.a0.c.j();
        d.b.b.j.d.a l = (j == null || (str2 = this.f49969d) == null) ? null : j.l(str2);
        if (l == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f49967b, this.f49966a);
            if (resBitmap != null) {
                l = new d.b.b.j.d.a(resBitmap, false, (String) null);
            }
            if (j != null && l != null && (str = this.f49969d) != null) {
                j.d(str, l);
            }
        }
        if (l != null) {
            int r = l.r();
            int m = l.m();
            if (r <= 0 || m <= 0 || this.f49968c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m <= 0 && r <= 0 && this.f49971f == 0 && this.f49972g == 0) {
                l.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f49970e == null) {
                    Matrix matrix = new Matrix();
                    this.f49970e = matrix;
                    matrix.postTranslate(this.f49971f, this.f49972g);
                    Rect rect = this.f49968c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f49970e.postScale(f2, f2);
                    }
                }
                l.f(canvas, this.f49970e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.f49968c = new Rect(i, i2, i3, i4);
        this.f49970e = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f49968c = new Rect(rect);
        this.f49970e = null;
        super.setBounds(rect);
    }
}
