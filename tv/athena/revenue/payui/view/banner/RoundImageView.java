package tv.athena.revenue.payui.view.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.tieba.p6c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010,B#\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020\u000b¢\u0006\u0004\b(\u0010.J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0006J/\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0014J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u0014J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001eR\u0016\u0010%\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001e¨\u0006/"}, d2 = {"Ltv/athena/revenue/payui/view/banner/RoundImageView;", "Landroid/widget/ImageView;", "Landroid/graphics/Canvas;", "canvas", "", "draw", "(Landroid/graphics/Canvas;)V", "drawBottomLeft", "drawBottomRight", "drawTopLeft", "drawTopRight", "", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "bottomLeft", "setBottomLeftRadius", "(I)V", "bottomRight", "setBottomRightRadius", "cornerRadius", "setRadius", "topLeft", "setTopLeftRadius", "topRight", "setTopRightRadius", "mBottomLeft", "I", "mBottomRight", "Landroid/graphics/Paint;", "mImagePaint", "Landroid/graphics/Paint;", "mRoundPaint", "mTopToLeft", "mTopToRight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "payui-main_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public final class RoundImageView extends ImageView {
    public int a;
    public int b;
    public int c;
    public int d;
    public Paint e;
    public Paint f;

    public RoundImageView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (canvas != null) {
            canvas.saveLayer(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.f, 31);
        }
        super.draw(canvas);
        if (canvas == null) {
            Intrinsics.throwNpe();
        }
        c(canvas);
        d(canvas);
        a(canvas);
        b(canvas);
        canvas.restore();
    }

    public final void setBottomLeftRadius(int i) {
        this.c = i;
        invalidate();
    }

    public final void setBottomRightRadius(int i) {
        this.d = i;
        invalidate();
    }

    public final void setRadius(int i) {
        this.a = i;
        this.b = i;
        this.c = i;
        this.d = i;
        invalidate();
    }

    public final void setTopLeftRadius(int i) {
        this.a = i;
        invalidate();
    }

    public final void setTopRightRadius(int i) {
        this.b = i;
        invalidate();
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new Paint();
        this.f = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p6c.PayUi_RoundImageView, i, 0);
        this.a = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.b = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        this.e.setColor(-1);
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f.setXfermode(null);
    }

    public final void a(Canvas canvas) {
        if (this.c > 0) {
            int height = getHeight();
            Path path = new Path();
            float f = height;
            path.moveTo(0.0f, f - this.c);
            path.lineTo(0.0f, f);
            path.lineTo(this.c, f);
            float f2 = 2;
            int i = this.c;
            path.arcTo(new RectF(0.0f, f - (i * f2), i * f2, f), 90.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    public final void c(Canvas canvas) {
        if (this.a > 0) {
            Path path = new Path();
            path.moveTo(0.0f, this.a);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.a, 0.0f);
            int i = this.a;
            float f = 2;
            path.arcTo(new RectF(0.0f, 0.0f, i * f, i * f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    public final void d(Canvas canvas) {
        if (this.b > 0) {
            int width = getWidth();
            Path path = new Path();
            float f = width;
            path.moveTo(f - this.b, 0.0f);
            path.lineTo(f, 0.0f);
            path.lineTo(f, this.b);
            float f2 = 2;
            int i = this.b;
            path.arcTo(new RectF(f - (i * f2), 0.0f, f, i * f2), 0.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    public final void b(Canvas canvas) {
        if (this.d > 0) {
            int height = getHeight();
            int width = getWidth();
            Path path = new Path();
            float f = width;
            float f2 = height;
            path.moveTo(f - this.d, f2);
            path.lineTo(f, f2);
            path.lineTo(f, f2 - this.d);
            float f3 = 2;
            int i = this.d;
            path.arcTo(new RectF(f - (i * f3), f2 - (f3 * i), f, f2), 0.0f, 90.0f);
            path.close();
            canvas.drawPath(path, this.e);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }
}
