package d.m.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes6.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f67355b;

    /* renamed from: d  reason: collision with root package name */
    public final d.m.a.f.b f67357d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f67358e;

    /* renamed from: f  reason: collision with root package name */
    public final c f67359f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67354a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f67356c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f67358e = sVGAVideoEntity;
        this.f67359f = cVar;
        this.f67357d = new d.m.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f67355b;
    }

    public final SVGAVideoEntity b() {
        return this.f67358e;
    }

    public final void c(boolean z) {
        if (this.f67354a == z) {
            return;
        }
        this.f67354a = z;
        invalidateSelf();
    }

    public final void d(int i) {
        if (this.f67355b == i) {
            return;
        }
        this.f67355b = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f67354a || canvas == null) {
            return;
        }
        this.f67357d.a(canvas, this.f67355b, this.f67356c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f67356c = scaleType;
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
