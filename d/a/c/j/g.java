package d.a.c.j;

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
    public Drawable f39327e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f39328f;

    /* renamed from: g  reason: collision with root package name */
    public int f39329g;

    /* renamed from: h  reason: collision with root package name */
    public Context f39330h;

    /* renamed from: i  reason: collision with root package name */
    public a f39331i;
    public Rect j;

    /* loaded from: classes.dex */
    public interface a {
        Drawable a(g gVar);
    }

    public g(a aVar, int i2, int i3) {
        super(i3);
        this.j = new Rect();
        this.f39329g = i2;
        this.f39331i = aVar;
    }

    public void a(Drawable drawable) {
        this.f39327e = drawable;
    }

    public void b(int i2, int i3, int i4, int i5) {
        this.j.set(i2, i3, i4, i5);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        canvas.save();
        int i7 = drawable.getBounds().bottom;
        if (((DynamicDrawableSpan) this).mVerticalAlignment == 0) {
            i5 = i6;
        }
        canvas.translate(f2, i5 - (drawable.getBounds().bottom - 4));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        Drawable drawable = this.f39327e;
        if (drawable == null) {
            a aVar = this.f39331i;
            drawable = aVar != null ? aVar.a(this) : null;
        }
        if (drawable != null) {
            return drawable;
        }
        try {
            if (this.f39328f != null) {
                InputStream openInputStream = this.f39330h.getContentResolver().openInputStream(this.f39328f);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f39330h.getResources(), BitmapFactory.decodeStream(openInputStream));
                try {
                    bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                    openInputStream.close();
                    return bitmapDrawable;
                } catch (Exception unused) {
                    drawable = bitmapDrawable;
                }
            } else {
                drawable = this.f39330h.getResources().getDrawable(this.f39329g);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
        } catch (Exception unused2) {
        }
        return drawable;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        if (this.f39327e == null && this.f39331i != null) {
            if (fontMetricsInt != null) {
                int i4 = -this.j.bottom;
                fontMetricsInt.ascent = i4;
                fontMetricsInt.descent = 0;
                fontMetricsInt.top = i4;
                fontMetricsInt.bottom = 0;
            }
            return this.j.right;
        }
        return super.getSize(paint, charSequence, i2, i3, fontMetricsInt);
    }
}
