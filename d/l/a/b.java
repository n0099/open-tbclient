package d.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes7.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f70302b;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.f.b f70304d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f70305e;

    /* renamed from: f  reason: collision with root package name */
    public final c f70306f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f70301a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f70303c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f70305e = sVGAVideoEntity;
        this.f70306f = cVar;
        this.f70304d = new d.l.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f70302b;
    }

    public final SVGAVideoEntity b() {
        return this.f70305e;
    }

    public final void c(boolean z) {
        if (this.f70301a == z) {
            return;
        }
        this.f70301a = z;
        invalidateSelf();
    }

    public final void d(int i2) {
        if (this.f70302b == i2) {
            return;
        }
        this.f70302b = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f70301a || canvas == null) {
            return;
        }
        this.f70304d.a(canvas, this.f70302b, this.f70303c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f70303c = scaleType;
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
