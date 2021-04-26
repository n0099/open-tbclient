package d.a.h0.a.q1.a;

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
/* loaded from: classes3.dex */
public class c extends Drawable {

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f43577d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f43578e;

    /* renamed from: f  reason: collision with root package name */
    public final int f43579f;

    /* renamed from: g  reason: collision with root package name */
    public final int f43580g;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f43582i;
    public float k;
    public int l;
    public int m;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f43574a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f43575b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public final RectF f43576c = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public final RectF f43581h = new RectF();
    public final Matrix j = new Matrix();
    public ImageView.ScaleType n = ImageView.ScaleType.FIT_XY;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43583a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f43583a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43583a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43583a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43583a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43583a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43583a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43583a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public c(Bitmap bitmap, float f2, int i2, int i3) {
        this.l = i2;
        this.m = i3;
        this.f43579f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f43580g = height;
        this.f43576c.set(0.0f, 0.0f, this.f43579f, height);
        this.k = f2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f43577d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f43578e = paint;
        paint.setAntiAlias(true);
        this.f43578e.setShader(this.f43577d);
        Paint paint2 = new Paint();
        this.f43582i = paint2;
        paint2.setAntiAlias(true);
        this.f43582i.setColor(this.m);
        this.f43582i.setStrokeWidth(i2);
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
    public static Drawable b(Drawable drawable, ImageView.ScaleType scaleType, float f2, int i2, int i3) {
        if (drawable != null) {
            if (drawable instanceof TransitionDrawable) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                int numberOfLayers = transitionDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i4 = 0; i4 < numberOfLayers; i4++) {
                    Drawable drawable2 = transitionDrawable.getDrawable(i4);
                    if (drawable2 instanceof ColorDrawable) {
                        drawableArr[i4] = drawable2;
                    } else if (drawable2 instanceof c) {
                        drawableArr[i4] = drawable2;
                    } else {
                        drawableArr[i4] = new c(a(drawable2), f2, i2, i3);
                        if (scaleType != null) {
                            ((c) drawableArr[i4]).h(scaleType);
                        }
                    }
                }
                return new TransitionDrawable(drawableArr);
            }
            Bitmap a2 = a(drawable);
            if (a2 != null) {
                c cVar = new c(a2, f2, i2, i3);
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

    public void d(int i2) {
        this.m = i2;
        this.f43582i.setColor(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l > 0) {
            RectF rectF = this.f43581h;
            float f2 = this.k;
            canvas.drawRoundRect(rectF, f2, f2, this.f43582i);
            canvas.drawRoundRect(this.f43575b, Math.max(this.k - this.l, 0.0f), Math.max(this.k - this.l, 0.0f), this.f43578e);
            return;
        }
        RectF rectF2 = this.f43575b;
        float f3 = this.k;
        canvas.drawRoundRect(rectF2, f3, f3, this.f43578e);
    }

    public void e(int i2) {
        this.l = i2;
        this.f43582i.setStrokeWidth(i2);
    }

    public void f(float f2) {
        this.k = f2;
    }

    public final void g() {
        float width;
        float height;
        this.f43581h.set(this.f43574a);
        RectF rectF = this.f43575b;
        int i2 = this.l;
        rectF.set(i2 + 0, i2 + 0, this.f43581h.width() - this.l, this.f43581h.height() - this.l);
        switch (a.f43583a[this.n.ordinal()]) {
            case 1:
                this.f43581h.set(this.f43574a);
                RectF rectF2 = this.f43575b;
                int i3 = this.l;
                rectF2.set(i3 + 0, i3 + 0, this.f43581h.width() - this.l, this.f43581h.height() - this.l);
                this.j.set(null);
                this.j.setTranslate((int) (((this.f43575b.width() - this.f43579f) * 0.5f) + 0.5f), (int) (((this.f43575b.height() - this.f43580g) * 0.5f) + 0.5f));
                break;
            case 2:
                this.f43581h.set(this.f43574a);
                RectF rectF3 = this.f43575b;
                int i4 = this.l;
                rectF3.set(i4 + 0, i4 + 0, this.f43581h.width() - this.l, this.f43581h.height() - this.l);
                this.j.set(null);
                float f2 = 0.0f;
                if (this.f43579f * this.f43575b.height() > this.f43575b.width() * this.f43580g) {
                    width = this.f43575b.height() / this.f43580g;
                    f2 = (this.f43575b.width() - (this.f43579f * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    width = this.f43575b.width() / this.f43579f;
                    height = (this.f43575b.height() - (this.f43580g * width)) * 0.5f;
                }
                this.j.setScale(width, width);
                Matrix matrix = this.j;
                int i5 = this.l;
                matrix.postTranslate(((int) (f2 + 0.5f)) + i5, ((int) (height + 0.5f)) + i5);
                break;
            case 3:
                this.j.set(null);
                float min = (((float) this.f43579f) > this.f43574a.width() || ((float) this.f43580g) > this.f43574a.height()) ? Math.min(this.f43574a.width() / this.f43579f, this.f43574a.height() / this.f43580g) : 1.0f;
                this.j.setScale(min, min);
                this.j.postTranslate((int) (((this.f43574a.width() - (this.f43579f * min)) * 0.5f) + 0.5f), (int) (((this.f43574a.height() - (this.f43580g * min)) * 0.5f) + 0.5f));
                this.f43581h.set(this.f43576c);
                this.j.mapRect(this.f43581h);
                RectF rectF4 = this.f43575b;
                RectF rectF5 = this.f43581h;
                float f3 = rectF5.left;
                int i6 = this.l;
                rectF4.set(f3 + i6, rectF5.top + i6, rectF5.right - i6, rectF5.bottom - i6);
                this.j.setRectToRect(this.f43576c, this.f43575b, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.f43581h.set(this.f43576c);
                this.j.setRectToRect(this.f43576c, this.f43574a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.f43581h);
                RectF rectF6 = this.f43575b;
                RectF rectF7 = this.f43581h;
                float f4 = rectF7.left;
                int i7 = this.l;
                rectF6.set(f4 + i7, rectF7.top + i7, rectF7.right - i7, rectF7.bottom - i7);
                this.j.setRectToRect(this.f43576c, this.f43575b, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.f43581h.set(this.f43576c);
                this.j.setRectToRect(this.f43576c, this.f43574a, Matrix.ScaleToFit.END);
                this.j.mapRect(this.f43581h);
                RectF rectF8 = this.f43575b;
                RectF rectF9 = this.f43581h;
                float f5 = rectF9.left;
                int i8 = this.l;
                rectF8.set(f5 + i8, rectF9.top + i8, rectF9.right - i8, rectF9.bottom - i8);
                this.j.setRectToRect(this.f43576c, this.f43575b, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.f43581h.set(this.f43576c);
                this.j.setRectToRect(this.f43576c, this.f43574a, Matrix.ScaleToFit.START);
                this.j.mapRect(this.f43581h);
                RectF rectF10 = this.f43575b;
                RectF rectF11 = this.f43581h;
                float f6 = rectF11.left;
                int i9 = this.l;
                rectF10.set(f6 + i9, rectF11.top + i9, rectF11.right - i9, rectF11.bottom - i9);
                this.j.setRectToRect(this.f43576c, this.f43575b, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.f43581h.set(this.f43574a);
                RectF rectF12 = this.f43575b;
                int i10 = this.l;
                rectF12.set(i10 + 0, i10 + 0, this.f43581h.width() - this.l, this.f43581h.height() - this.l);
                this.j.set(null);
                this.j.setRectToRect(this.f43576c, this.f43575b, Matrix.ScaleToFit.FILL);
                break;
        }
        this.f43577d.setLocalMatrix(this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f43580g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f43579f;
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
        this.f43574a.set(rect);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f43578e.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f43578e.setColorFilter(colorFilter);
    }
}
