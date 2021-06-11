package d.a.l0.a.z1.a;

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
public class b extends Drawable {

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f49682d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f49683e;

    /* renamed from: f  reason: collision with root package name */
    public final int f49684f;

    /* renamed from: g  reason: collision with root package name */
    public final int f49685g;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f49687i;
    public float k;
    public int l;
    public int m;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f49679a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    public final RectF f49680b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    public final RectF f49681c = new RectF();

    /* renamed from: h  reason: collision with root package name */
    public final RectF f49686h = new RectF();
    public final Matrix j = new Matrix();
    public ImageView.ScaleType n = ImageView.ScaleType.FIT_XY;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49688a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f49688a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49688a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49688a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49688a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f49688a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f49688a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f49688a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap, float f2, int i2, int i3) {
        this.l = i2;
        this.m = i3;
        this.f49684f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f49685g = height;
        this.f49681c.set(0.0f, 0.0f, this.f49684f, height);
        this.k = f2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f49682d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f49683e = paint;
        paint.setAntiAlias(true);
        this.f49683e.setShader(this.f49682d);
        Paint paint2 = new Paint();
        this.f49687i = paint2;
        paint2.setAntiAlias(true);
        this.f49687i.setColor(this.m);
        this.f49687i.setStrokeWidth(i2);
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
                    } else if (drawable2 instanceof b) {
                        drawableArr[i4] = drawable2;
                    } else {
                        drawableArr[i4] = new b(a(drawable2), f2, i2, i3);
                        if (scaleType != null) {
                            ((b) drawableArr[i4]).h(scaleType);
                        }
                    }
                }
                return new TransitionDrawable(drawableArr);
            }
            Bitmap a2 = a(drawable);
            if (a2 != null) {
                b bVar = new b(a2, f2, i2, i3);
                if (scaleType != null) {
                    bVar.h(scaleType);
                }
                return bVar;
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
        this.f49687i.setColor(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.l > 0) {
            RectF rectF = this.f49686h;
            float f2 = this.k;
            canvas.drawRoundRect(rectF, f2, f2, this.f49687i);
            canvas.drawRoundRect(this.f49680b, Math.max(this.k - this.l, 0.0f), Math.max(this.k - this.l, 0.0f), this.f49683e);
            return;
        }
        RectF rectF2 = this.f49680b;
        float f3 = this.k;
        canvas.drawRoundRect(rectF2, f3, f3, this.f49683e);
    }

    public void e(int i2) {
        this.l = i2;
        this.f49687i.setStrokeWidth(i2);
    }

    public void f(float f2) {
        this.k = f2;
    }

    public final void g() {
        float width;
        float height;
        this.f49686h.set(this.f49679a);
        RectF rectF = this.f49680b;
        int i2 = this.l;
        rectF.set(i2 + 0, i2 + 0, this.f49686h.width() - this.l, this.f49686h.height() - this.l);
        switch (a.f49688a[this.n.ordinal()]) {
            case 1:
                this.f49686h.set(this.f49679a);
                RectF rectF2 = this.f49680b;
                int i3 = this.l;
                rectF2.set(i3 + 0, i3 + 0, this.f49686h.width() - this.l, this.f49686h.height() - this.l);
                this.j.set(null);
                this.j.setTranslate((int) (((this.f49680b.width() - this.f49684f) * 0.5f) + 0.5f), (int) (((this.f49680b.height() - this.f49685g) * 0.5f) + 0.5f));
                break;
            case 2:
                this.f49686h.set(this.f49679a);
                RectF rectF3 = this.f49680b;
                int i4 = this.l;
                rectF3.set(i4 + 0, i4 + 0, this.f49686h.width() - this.l, this.f49686h.height() - this.l);
                this.j.set(null);
                float f2 = 0.0f;
                if (this.f49684f * this.f49680b.height() > this.f49680b.width() * this.f49685g) {
                    width = this.f49680b.height() / this.f49685g;
                    f2 = (this.f49680b.width() - (this.f49684f * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    width = this.f49680b.width() / this.f49684f;
                    height = (this.f49680b.height() - (this.f49685g * width)) * 0.5f;
                }
                this.j.setScale(width, width);
                Matrix matrix = this.j;
                int i5 = this.l;
                matrix.postTranslate(((int) (f2 + 0.5f)) + i5, ((int) (height + 0.5f)) + i5);
                break;
            case 3:
                this.j.set(null);
                float min = (((float) this.f49684f) > this.f49679a.width() || ((float) this.f49685g) > this.f49679a.height()) ? Math.min(this.f49679a.width() / this.f49684f, this.f49679a.height() / this.f49685g) : 1.0f;
                this.j.setScale(min, min);
                this.j.postTranslate((int) (((this.f49679a.width() - (this.f49684f * min)) * 0.5f) + 0.5f), (int) (((this.f49679a.height() - (this.f49685g * min)) * 0.5f) + 0.5f));
                this.f49686h.set(this.f49681c);
                this.j.mapRect(this.f49686h);
                RectF rectF4 = this.f49680b;
                RectF rectF5 = this.f49686h;
                float f3 = rectF5.left;
                int i6 = this.l;
                rectF4.set(f3 + i6, rectF5.top + i6, rectF5.right - i6, rectF5.bottom - i6);
                this.j.setRectToRect(this.f49681c, this.f49680b, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.f49686h.set(this.f49681c);
                this.j.setRectToRect(this.f49681c, this.f49679a, Matrix.ScaleToFit.CENTER);
                this.j.mapRect(this.f49686h);
                RectF rectF6 = this.f49680b;
                RectF rectF7 = this.f49686h;
                float f4 = rectF7.left;
                int i7 = this.l;
                rectF6.set(f4 + i7, rectF7.top + i7, rectF7.right - i7, rectF7.bottom - i7);
                this.j.setRectToRect(this.f49681c, this.f49680b, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.f49686h.set(this.f49681c);
                this.j.setRectToRect(this.f49681c, this.f49679a, Matrix.ScaleToFit.END);
                this.j.mapRect(this.f49686h);
                RectF rectF8 = this.f49680b;
                RectF rectF9 = this.f49686h;
                float f5 = rectF9.left;
                int i8 = this.l;
                rectF8.set(f5 + i8, rectF9.top + i8, rectF9.right - i8, rectF9.bottom - i8);
                this.j.setRectToRect(this.f49681c, this.f49680b, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.f49686h.set(this.f49681c);
                this.j.setRectToRect(this.f49681c, this.f49679a, Matrix.ScaleToFit.START);
                this.j.mapRect(this.f49686h);
                RectF rectF10 = this.f49680b;
                RectF rectF11 = this.f49686h;
                float f6 = rectF11.left;
                int i9 = this.l;
                rectF10.set(f6 + i9, rectF11.top + i9, rectF11.right - i9, rectF11.bottom - i9);
                this.j.setRectToRect(this.f49681c, this.f49680b, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.f49686h.set(this.f49679a);
                RectF rectF12 = this.f49680b;
                int i10 = this.l;
                rectF12.set(i10 + 0, i10 + 0, this.f49686h.width() - this.l, this.f49686h.height() - this.l);
                this.j.set(null);
                this.j.setRectToRect(this.f49681c, this.f49680b, Matrix.ScaleToFit.FILL);
                break;
        }
        this.f49682d.setLocalMatrix(this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f49685g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f49684f;
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
        this.f49679a.set(rect);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f49683e.setAlpha(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f49683e.setColorFilter(colorFilter);
    }
}
