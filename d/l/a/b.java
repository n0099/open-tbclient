package d.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.opensource.svgaplayer.SVGAVideoEntity;
/* loaded from: classes6.dex */
public final class b extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    public int f67208b;

    /* renamed from: d  reason: collision with root package name */
    public final d.l.a.f.b f67210d;

    /* renamed from: e  reason: collision with root package name */
    public final SVGAVideoEntity f67211e;

    /* renamed from: f  reason: collision with root package name */
    public final c f67212f;

    /* renamed from: a  reason: collision with root package name */
    public boolean f67207a = true;

    /* renamed from: c  reason: collision with root package name */
    public ImageView.ScaleType f67209c = ImageView.ScaleType.MATRIX;

    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        this.f67211e = sVGAVideoEntity;
        this.f67212f = cVar;
        this.f67210d = new d.l.a.f.b(sVGAVideoEntity, cVar);
    }

    public final int a() {
        return this.f67208b;
    }

    public final SVGAVideoEntity b() {
        return this.f67211e;
    }

    public final void c(boolean z) {
        if (this.f67207a == z) {
            return;
        }
        this.f67207a = z;
        invalidateSelf();
    }

    public final void d(int i) {
        if (this.f67208b == i) {
            return;
        }
        this.f67208b = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f67207a || canvas == null) {
            return;
        }
        this.f67210d.a(canvas, this.f67208b, this.f67209c);
    }

    public final void e(ImageView.ScaleType scaleType) {
        this.f67209c = scaleType;
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
