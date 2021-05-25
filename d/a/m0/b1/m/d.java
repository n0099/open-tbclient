package d.a.m0.b1.m;

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
    public int f49116a;

    /* renamed from: b  reason: collision with root package name */
    public Context f49117b;

    /* renamed from: d  reason: collision with root package name */
    public String f49119d;

    /* renamed from: c  reason: collision with root package name */
    public Rect f49118c = null;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f49120e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f49121f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f49122g = 0;

    public d(Context context, int i2) {
        this.f49116a = 0;
        this.f49117b = null;
        this.f49119d = null;
        this.f49117b = context;
        this.f49116a = i2;
        this.f49119d = String.valueOf(i2);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String str;
        String str2;
        if (this.f49116a <= 0 || this.f49117b == null) {
            return;
        }
        d.a.m0.a0.c k = d.a.m0.a0.c.k();
        d.a.c.j.d.a m = (k == null || (str2 = this.f49119d) == null) ? null : k.m(str2);
        if (m == null) {
            Bitmap resBitmap = BitmapHelper.getResBitmap(this.f49117b, this.f49116a);
            if (resBitmap != null) {
                m = new d.a.c.j.d.a(resBitmap, false, (String) null);
            }
            if (k != null && m != null && (str = this.f49119d) != null) {
                k.d(str, m);
            }
        }
        if (m != null) {
            int r = m.r();
            int m2 = m.m();
            if (r <= 0 || m2 <= 0 || this.f49118c == null) {
                return;
            }
            canvas.save();
            canvas.clipRect(super.getBounds());
            if (m2 <= 0 && r <= 0 && this.f49121f == 0 && this.f49122g == 0) {
                m.e(canvas, 0.0f, 0.0f, null);
            } else {
                if (this.f49120e == null) {
                    Matrix matrix = new Matrix();
                    this.f49120e = matrix;
                    matrix.postTranslate(this.f49121f, this.f49122g);
                    Rect rect = this.f49118c;
                    float f2 = (rect.right - rect.left) / r;
                    float f3 = (rect.bottom - rect.top) / m2;
                    if (f2 >= f3) {
                        f2 = f3;
                    }
                    if (f2 < 1.0f) {
                        this.f49120e.postScale(f2, f2);
                    }
                }
                m.f(canvas, this.f49120e, null);
            }
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i2, int i3, int i4, int i5) {
        this.f49118c = new Rect(i2, i3, i4, i5);
        this.f49120e = null;
        super.setBounds(i2, i3, i4, i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        this.f49118c = new Rect(rect);
        this.f49120e = null;
        super.setBounds(rect);
    }
}
