package d.b.g0.a.q1.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.util.Log;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class c extends Drawable {

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f45900d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f45901e;

    /* renamed from: f  reason: collision with root package name */
    public final int f45902f;

    /* renamed from: g  reason: collision with root package name */
    public final int f45903g;
    public final Paint i;
    public float k;
    public int l;
    public int m;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f45897a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f45898b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public final RectF f45899c = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public final RectF f45904h = new RectF();
    public final Matrix j = new Matrix();
    public ImageView.ScaleType n = ImageView.ScaleType.FIT_XY;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45905a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f45905a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45905a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45905a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45905a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45905a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45905a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45905a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public c(Bitmap bitmap, float f2, int i, int i2) {
        this.l = i;
        this.m = i2;
        this.f45902f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f45903g = height;
        this.f45899c.set(0.0f, 0.0f, this.f45902f, height);
        this.k = f2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f45900d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f45901e = paint;
        paint.setAntiAlias(true);
        this.f45901e.setShader(this.f45900d);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setAntiAlias(true);
        this.i.setColor(this.m);
        this.i.setStrokeWidth(i);
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    @SuppressLint({"SwanDebugLog"})
    public static Drawable b(Drawable drawable, ImageView.ScaleType scaleType, float f2, int i, int i2) {
        if (drawable != null) {
            if (drawable instanceof TransitionDrawable) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                int numberOfLayers = transitionDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    Drawable drawable2 = transitionDrawable.getDrawable(i3);
                    if (drawable2 instanceof ColorDrawable) {
                        drawableArr[i3] = drawable2;
                    } else if (drawable2 instanceof c) {
                        drawableArr[i3] = drawable2;
                    } else {
                        drawableArr[i3] = new c(a(drawable2), f2, i, i2);
                        if (scaleType != null) {
                            ((c) drawableArr[i3]).h(scaleType);
                        }
                    }
                }
                return new TransitionDrawable(drawableArr);
            }
            Bitmap a2 = a(drawable);
            if (a2 != null) {
                c cVar = new c(a2, f2, i, i2);
                if (scaleType != null) {
                    cVar.h(scaleType);
                }
                return cVar;
            }
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
        }
        return drawable;
    }

    public ImageView.ScaleType c() {
        return this.n;
    }

    public void d(int i) {
        this.m = i;
        this.i.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l > 0) {
            RectF rectF = this.f45904h;
            float f2 = this.k;
            canvas.drawRoundRect(rectF, f2, f2, this.i);
            canvas.drawRoundRect(this.f45898b, Math.max(this.k - this.l, 0.0f), Math.max(this.k - this.l, 0.0f), this.f45901e);
            return;
        }
        RectF rectF2 = this.f45898b;
        float f3 = this.k;
        canvas.drawRoundRect(rectF2, f3, f3, this.f45901e);
    }

    public void e(int i) {
        this.l = i;
        this.i.setStrokeWidth(i);
    }

    public void f(float f2) {
        this.k = f2;
    }

    public final void g() {
        float width;
        float height;
        this.f45904h.set(this.f45897a);
        RectF rectF = this.f45898b;
        int i = this.l;
        rectF.set(i + 0, i + 0, this.f45904h.width() - this.l, this.f45904h.height() - this.l);
        switch (a.f45905a[this.n.ordinal()]) {
            case 1:
                this.f45904h.set(this.f45897a);
                RectF rectF2 = this.f45898b;
                int i2 = this.l;
                rectF2.set(i2 + 0, i2 + 0, this.f45904h.width() - this.l, this.f45904h.height() - this.l);
                this.j.set(null);
                this.j.setTranslate((int) (((this.f45898b.width() - this.f45902f) * 0.5f) + 0.5f), (int) (((this.f45898b.height() - this.f45903g) * 0.5f) + 0.5f));
                break;
            case 2:
                this.f45904h.set(this.f45897a);
                RectF rectF3 = this.f45898b;
                int i3 = this.l;
                rectF3.set(i3 + 0, i3 + 0, this.f45904h.width() - this.l, this.f45904h.height() - this.l);
                this.j.set(null);
                float f2 = 0.0f;
                if (this.f45902f * this.f45898b.height() > this.f45898b.width() * this.f45903g) {
                    width = this.f45898b.height() / this.f45903g;
                    f2 = (this.f45898b.width() - (this.f45902f * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    width = this.f45898b.width() / this.f45902f;
                    height = (this.f45898b.height() - (this.f45903g * width)) * 0.5f;
                }
                this.j.setScale(width, width);
                Matrix matrix = this.j;
                int i4 = this.l;
                matrix.postTranslate(((int) (f2 + 0.5f)) + i4, ((int) (height + 0.5f)) + i4);
                break;
            case 3:
                this.j.set(null);
                float min = (((float) this.f45902f) > this.f45897a.width() || ((float) this.f45903g) > this.f45897a.height()) ? Math.min(this.f45897a.width() / this.f45902f, this.f45897a.height() / this.f45903g) : 1.0f;
                this.j.setScale(min, min);
                this.j.postTranslate((int) (((this.f45897a.width() - (this.f45902f * min)) * 0.5f) + 0.5f), (int) (((this.f45897a.height() - (this.f45903g * min)) * 0.5f) + 0.5f));
                this.f45904h.set(this.f45899c);
                this.j.mapRect(this.f45904h);
                RectF rectF4 = this.f45898b;
                RectF rectF5 = this.f45904h;
                float f3 = rectF5.left;
                int i5 = this.l;
                rectF4.set(f3 + i5, rectF5.top + i5, rectF5.right - i5, rectF5.bottom - i5);
                this.j.setRectToRect(this.f45899c, this.f45898b, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.f45904h.set(this.f45899c);
                this.j.setRectToRect(this.f45899c, this.f45897a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.f45904h);
                RectF rectF6 = this.f45898b;
                RectF rectF7 = this.f45904h;
                float f4 = rectF7.left;
                int i6 = this.l;
                rectF6.set(f4 + i6, rectF7.top + i6, rectF7.right - i6, rectF7.bottom - i6);
                this.j.setRectToRect(this.f45899c, this.f45898b, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.f45904h.set(this.f45899c);
                this.j.setRectToRect(this.f45899c, this.f45897a, Matrix.ScaleToFit.END);
                this.j.mapRect(this.f45904h);
                RectF rectF8 = this.f45898b;
                RectF rectF9 = this.f45904h;
                float f5 = rectF9.left;
                int i7 = this.l;
                rectF8.set(f5 + i7, rectF9.top + i7, rectF9.right - i7, rectF9.bottom - i7);
                this.j.setRectToRect(this.f45899c, this.f45898b, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.f45904h.set(this.f45899c);
                this.j.setRectToRect(this.f45899c, this.f45897a, Matrix.ScaleToFit.START);
                this.j.mapRect(this.f45904h);
                RectF rectF10 = this.f45898b;
                RectF rectF11 = this.f45904h;
                float f6 = rectF11.left;
                int i8 = this.l;
                rectF10.set(f6 + i8, rectF11.top + i8, rectF11.right - i8, rectF11.bottom - i8);
                this.j.setRectToRect(this.f45899c, this.f45898b, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.f45904h.set(this.f45897a);
                RectF rectF12 = this.f45898b;
                int i9 = this.l;
                rectF12.set(i9 + 0, i9 + 0, this.f45904h.width() - this.l, this.f45904h.height() - this.l);
                this.j.set(null);
                this.j.setRectToRect(this.f45899c, this.f45898b, Matrix.ScaleToFit.FILL);
                break;
        }
        this.f45900d.setLocalMatrix(this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f45903g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f45902f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        if (this.n != scaleType) {
            this.n = scaleType;
            g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f45897a.set(rect);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f45901e.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f45901e.setColorFilter(colorFilter);
    }
}
