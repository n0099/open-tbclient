package d.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes6.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f66214b;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.f.b f66216d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f66217e;

    /* renamed from: f  reason: collision with root package name */
    public final c f66218f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66213a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f66215c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f66217e = sVGAVideoEntity;
        this.f66218f = cVar;
        this.f66216d = new d.l.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f66214b;
    }

    public final SVGAVideoEntity b() {
        return this.f66217e;
    }

    public final void c(boolean z) {
        if (this.f66213a == z) {
            return;
        }
        this.f66213a = z;
        invalidateSelf();
    }

    public final void d(int i) {
        if (this.f66214b == i) {
            return;
        }
        this.f66214b = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f66213a || canvas == null) {
            return;
        }
        this.f66216d.a(canvas, this.f66214b, this.f66215c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f66215c = scaleType;
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
