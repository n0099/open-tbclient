package d.b.c.j.d;

import android.content.res.ColorStateList;
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
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Log;
import android.widget.ImageView;
/* loaded from: classes.dex */
public class b extends Drawable {

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f42849d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f42850e;

    /* renamed from: f  reason: collision with root package name */
    public final int f42851f;

    /* renamed from: g  reason: collision with root package name */
    public final int f42852g;
    public final Paint i;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f42846a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f42847b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public final RectF f42848c = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public final RectF f42853h = new RectF();
    public final Matrix j = new Matrix();
    public float k = 0.0f;
    public boolean l = false;
    public float m = 0.0f;
    public ColorStateList n = ColorStateList.valueOf(0);
    public ImageView.ScaleType o = ImageView.ScaleType.FIT_XY;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42854a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f42854a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f42854a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f42854a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f42854a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f42854a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f42854a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f42854a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap) {
        this.f42851f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f42852g = height;
        this.f42848c.set(0.0f, 0.0f, this.f42851f, height);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f42849d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f42850e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f42850e.setAntiAlias(true);
        this.f42850e.setShader(this.f42849d);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        this.i.setColor(this.n.getColorForState(getState(), 0));
        this.i.setStrokeWidth(this.m);
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

    public static Drawable b(Drawable drawable) {
        if (drawable == null || (drawable instanceof b) || (drawable instanceof ColorDrawable)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), b(layerDrawable.getDrawable(i)));
            }
            return layerDrawable;
        } else if (drawable instanceof StateListDrawable) {
            return (StateListDrawable) drawable;
        } else {
            Bitmap a2 = a(drawable);
            if (a2 != null && !a2.isRecycled()) {
                return new b(a2);
            }
            Log.w("BdRoundedDrawable", "Failed to create bitmap from drawable!");
            return drawable;
        }
    }

    public b c(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.n = colorStateList;
        this.i.setColor(colorStateList.getColorForState(getState(), 0));
        return this;
    }

    public b d(int i) {
        float f2 = i;
        this.m = f2;
        this.i.setStrokeWidth(f2);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l) {
            if (this.m > 0.0f) {
                canvas.drawOval(this.f42853h, this.i);
                canvas.drawOval(this.f42847b, this.f42850e);
                return;
            }
            canvas.drawOval(this.f42847b, this.f42850e);
        } else if (this.m > 0.0f) {
            RectF rectF = this.f42853h;
            float f2 = this.k;
            canvas.drawRoundRect(rectF, f2, f2, this.i);
            canvas.drawRoundRect(this.f42847b, Math.max(this.k - this.m, 0.0f), Math.max(this.k - this.m, 0.0f), this.f42850e);
        } else {
            RectF rectF2 = this.f42847b;
            float f3 = this.k;
            canvas.drawRoundRect(rectF2, f3, f3, this.f42850e);
        }
    }

    public b e(float f2) {
        this.k = f2;
        return this;
    }

    public b f(boolean z) {
        this.l = z;
        return this;
    }

    public b g(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }
        if (this.o != scaleType) {
            this.o = scaleType;
            h();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f42852g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f42851f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h() {
        float width;
        float height;
        this.f42853h.set(this.f42846a);
        RectF rectF = this.f42847b;
        float f2 = this.m;
        rectF.set(f2, f2, this.f42853h.width() - this.m, this.f42853h.height() - this.m);
        float f3 = 0.0f;
        switch (a.f42854a[this.o.ordinal()]) {
            case 1:
                this.f42853h.set(this.f42846a);
                RectF rectF2 = this.f42847b;
                float f4 = this.m;
                rectF2.set(f4, f4, this.f42853h.width() - this.m, this.f42853h.height() - this.m);
                this.j.set(null);
                this.j.setTranslate((int) (((this.f42847b.width() - this.f42851f) * 0.5f) + 0.5f), (int) (((this.f42847b.height() - this.f42852g) * 0.5f) + 0.5f));
                break;
            case 2:
                this.f42853h.set(this.f42846a);
                RectF rectF3 = this.f42847b;
                float f5 = this.m;
                rectF3.set(f5, f5, this.f42853h.width() - this.m, this.f42853h.height() - this.m);
                this.j.set(null);
                if (this.f42851f * this.f42847b.height() > this.f42847b.width() * this.f42852g) {
                    width = this.f42847b.height() / this.f42852g;
                    f3 = (this.f42847b.width() - (this.f42851f * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    width = this.f42847b.width() / this.f42851f;
                    height = (this.f42847b.height() - (this.f42852g * width)) * 0.5f;
                }
                this.j.setScale(width, width);
                Matrix matrix = this.j;
                float f6 = this.m;
                matrix.postTranslate(((int) (f3 + 0.5f)) + f6, ((int) (height + 0.5f)) + f6);
                break;
            case 3:
                this.j.set(null);
                float min = (((float) this.f42851f) > this.f42846a.width() || ((float) this.f42852g) > this.f42846a.height()) ? Math.min(this.f42846a.width() / this.f42851f, this.f42846a.height() / this.f42852g) : 1.0f;
                this.j.setScale(min, min);
                this.j.postTranslate((int) (((this.f42846a.width() - (this.f42851f * min)) * 0.5f) + 0.5f), (int) (((this.f42846a.height() - (this.f42852g * min)) * 0.5f) + 0.5f));
                this.f42853h.set(this.f42848c);
                this.j.mapRect(this.f42853h);
                RectF rectF4 = this.f42847b;
                RectF rectF5 = this.f42853h;
                float f7 = rectF5.left;
                float f8 = this.m;
                rectF4.set(f7 + f8, rectF5.top + f8, rectF5.right - f8, rectF5.bottom - f8);
                this.j.setRectToRect(this.f42848c, this.f42847b, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.f42853h.set(this.f42848c);
                this.j.setRectToRect(this.f42848c, this.f42846a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.f42853h);
                RectF rectF6 = this.f42847b;
                RectF rectF7 = this.f42853h;
                float f9 = rectF7.left;
                float f10 = this.m;
                rectF6.set(f9 + f10, rectF7.top + f10, rectF7.right - f10, rectF7.bottom - f10);
                this.j.setRectToRect(this.f42848c, this.f42847b, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.f42853h.set(this.f42848c);
                this.j.setRectToRect(this.f42848c, this.f42846a, Matrix.ScaleToFit.END);
                this.j.mapRect(this.f42853h);
                RectF rectF8 = this.f42847b;
                RectF rectF9 = this.f42853h;
                float f11 = rectF9.left;
                float f12 = this.m;
                rectF8.set(f11 + f12, rectF9.top + f12, rectF9.right - f12, rectF9.bottom - f12);
                this.j.setRectToRect(this.f42848c, this.f42847b, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.f42853h.set(this.f42848c);
                this.j.setRectToRect(this.f42848c, this.f42846a, Matrix.ScaleToFit.START);
                this.j.mapRect(this.f42853h);
                RectF rectF10 = this.f42847b;
                RectF rectF11 = this.f42853h;
                float f13 = rectF11.left;
                float f14 = this.m;
                rectF10.set(f13 + f14, rectF11.top + f14, rectF11.right - f14, rectF11.bottom - f14);
                this.j.setRectToRect(this.f42848c, this.f42847b, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.f42853h.set(this.f42846a);
                RectF rectF12 = this.f42847b;
                float f15 = this.m;
                rectF12.set(f15 + 0.0f, f15 + 0.0f, this.f42853h.width() - this.m, this.f42853h.height() - this.m);
                this.j.set(null);
                this.j.setRectToRect(this.f42848c, this.f42847b, Matrix.ScaleToFit.FILL);
                break;
        }
        RectF rectF13 = this.f42853h;
        float f16 = this.m;
        rectF13.inset(f16 / 2.0f, f16 / 2.0f);
        this.f42849d.setLocalMatrix(this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.n.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f42846a.set(rect);
        h();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.n.getColorForState(iArr, 0);
        if (this.i.getColor() != colorForState) {
            this.i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f42850e.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f42850e.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
