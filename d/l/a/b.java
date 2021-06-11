package d.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes7.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f70198b;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.f.b f70200d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f70201e;

    /* renamed from: f  reason: collision with root package name */
    public final c f70202f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f70197a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f70199c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f70201e = sVGAVideoEntity;
        this.f70202f = cVar;
        this.f70200d = new d.l.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f70198b;
    }

    public final SVGAVideoEntity b() {
        return this.f70201e;
    }

    public final void c(boolean z) {
        if (this.f70197a == z) {
            return;
        }
        this.f70197a = z;
        invalidateSelf();
    }

    public final void d(int i2) {
        if (this.f70198b == i2) {
            return;
        }
        this.f70198b = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f70197a || canvas == null) {
            return;
        }
        this.f70200d.a(canvas, this.f70198b, this.f70199c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f70199c = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
