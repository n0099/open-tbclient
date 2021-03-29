package d.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes6.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f66215b;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.f.b f66217d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f66218e;

    /* renamed from: f  reason: collision with root package name */
    public final c f66219f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66214a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f66216c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f66218e = sVGAVideoEntity;
        this.f66219f = cVar;
        this.f66217d = new d.l.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f66215b;
    }

    public final SVGAVideoEntity b() {
        return this.f66218e;
    }

    public final void c(boolean z) {
        if (this.f66214a == z) {
            return;
        }
        this.f66214a = z;
        invalidateSelf();
    }

    public final void d(int i) {
        if (this.f66215b == i) {
            return;
        }
        this.f66215b = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f66214a || canvas == null) {
            return;
        }
        this.f66217d.a(canvas, this.f66215b, this.f66216c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f66216c = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
