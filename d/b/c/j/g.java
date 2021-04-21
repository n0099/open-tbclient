package d.b.c.j;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.DynamicDrawableSpan;
import java.io.InputStream;
/* loaded from: classes.dex */
public class g extends DynamicDrawableSpan {

    /* renamed from: e  reason: collision with root package name */
    public Drawable f43186e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f43187f;

    /* renamed from: g  reason: collision with root package name */
    public int f43188g;

    /* renamed from: h  reason: collision with root package name */
    public Context f43189h;
    public a i;
    public Rect j;

    /* loaded from: classes.dex */
    public interface a {
        Drawable a(g gVar);
    }

    public g(a aVar, int i, int i2) {
        super(i2);
        this.j = new Rect();
        this.f43188g = i;
        this.i = aVar;
    }

    public void a(Drawable drawable) {
        this.f43186e = drawable;
    }

    public void b(int i, int i2, int i3, int i4) {
        this.j.set(i, i2, i3, i4);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        canvas.save();
        int i6 = drawable.getBounds().bottom;
        if (((DynamicDrawableSpan) this).mVerticalAlignment == 0) {
            i4 = i5;
        }
        canvas.translate(f2, i4 - (drawable.getBounds().bottom - 4));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = this.f43186e;
        if (drawable == null) {
            a aVar = this.i;
            drawable = aVar != null ? aVar.a(this) : null;
        }
        if (drawable != null) {
            return drawable;
        }
        try {
            if (this.f43187f != null) {
                InputStream openInputStream = this.f43189h.getContentResolver().openInputStream(this.f43187f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f43189h.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else {
                drawable = this.f43189h.getResources().getDrawable(this.f43188g);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
        } catch (Exception unused2) {
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.f43186e == null && this.i != null) {
            if (fontMetricsInt != null) {
                int i3 = -this.j.bottom;
                fontMetricsInt.ascent = i3;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = i3;
                fontMetricsInt.bottom = 0;
            }
            return this.j.right;
        }
        return super.getSize(paint, charSequence, i, i2, fontMetricsInt);
    }
}
