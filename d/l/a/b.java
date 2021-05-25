package d.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes6.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f66412b;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.f.b f66414d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f66415e;

    /* renamed from: f  reason: collision with root package name */
    public final c f66416f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66411a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f66413c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f66415e = sVGAVideoEntity;
        this.f66416f = cVar;
        this.f66414d = new d.l.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f66412b;
    }

    public final SVGAVideoEntity b() {
        return this.f66415e;
    }

    public final void c(boolean z) {
        if (this.f66411a == z) {
            return;
        }
        this.f66411a = z;
        invalidateSelf();
    }

    public final void d(int i2) {
        if (this.f66412b == i2) {
            return;
        }
        this.f66412b = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f66411a || canvas == null) {
            return;
        }
        this.f66414d.a(canvas, this.f66412b, this.f66413c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f66413c = scaleType;
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
