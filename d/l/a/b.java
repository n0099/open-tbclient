package d.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes6.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f65683b;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.f.b f65685d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f65686e;

    /* renamed from: f  reason: collision with root package name */
    public final c f65687f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f65682a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f65684c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f65686e = sVGAVideoEntity;
        this.f65687f = cVar;
        this.f65685d = new d.l.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f65683b;
    }

    public final SVGAVideoEntity b() {
        return this.f65686e;
    }

    public final void c(boolean z) {
        if (this.f65682a == z) {
            return;
        }
        this.f65682a = z;
        invalidateSelf();
    }

    public final void d(int i2) {
        if (this.f65683b == i2) {
            return;
        }
        this.f65683b = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f65682a || canvas == null) {
            return;
        }
        this.f65685d.a(canvas, this.f65683b, this.f65684c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f65684c = scaleType;
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
