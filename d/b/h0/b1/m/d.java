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
    public int f50360a;

    /* renamed from: b  reason: collision with root package name */
    public Context f50361b;

    /* renamed from: d  reason: collision with root package name */
    public String f50363d;

    /* renamed from: c  reason: collision with root package name */
    public Rect f50362c = null;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f50364e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f50365f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f50366g = 0;

    public d(Context context, int i) {
        this.f50360a = 0;
        this.f50361b = null;
        this.f50363d = null;
        this.f50361b = context;
        this.f50360a = i;
        this.f50363d = String.valueOf(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        if (this.f50360a <= 0 || this.f50361b == null) {
            return;
        }
        d.b.h0.a0.c k = d.b.h0.a0.c.k();
        d.b.c.j.d.a m = (k == null || (str2 = this.f50363d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f50361b, this.f50360a);
            if (resBitmap != null) {
                m = new d.b.c.j.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f50363d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f50362c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f50365f == 0 && this.f50366g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f50364e == null) {
                    Matrix matrix = new Matrix();
                    this.f50364e = matrix;
                    matrix.postTranslate(this.f50365f, this.f50366g);
                    Rect rect = this.f50362c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f50364e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f50364e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        this.f50362c = new Rect(i, i2, i3, i4);
        this.f50364e = null;
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f50362c = new Rect(rect);
        this.f50364e = null;
        super.setBounds(rect);
    }
}
