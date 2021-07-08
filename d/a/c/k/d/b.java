package d.a.c.k.d;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class b extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f41827a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f41828b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f41829c;

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f41830d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f41831e;

    /* renamed from: f  reason: collision with root package name */
    public final int f41832f;

    /* renamed from: g  reason: collision with root package name */
    public final int f41833g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f41834h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f41835i;
    public final Matrix j;
    public float k;
    public boolean l;
    public float m;
    public ColorStateList n;
    public ImageView.ScaleType o;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41836a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1910688284, "Ld/a/c/k/d/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1910688284, "Ld/a/c/k/d/b$a;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f41836a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41836a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41836a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41836a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41836a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41836a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41836a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f41827a = new RectF();
        this.f41828b = new RectF();
        this.f41829c = new RectF();
        this.f41834h = new RectF();
        this.j = new Matrix();
        this.k = 0.0f;
        this.l = false;
        this.m = 0.0f;
        this.n = ColorStateList.valueOf(0);
        this.o = ImageView.ScaleType.FIT_XY;
        this.f41832f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f41833g = height;
        this.f41829c.set(0.0f, 0.0f, this.f41832f, height);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f41830d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f41831e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f41831e.setAntiAlias(true);
        this.f41831e.setShader(this.f41830d);
        Paint paint2 = new Paint();
        this.f41835i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f41835i.setAntiAlias(true);
        this.f41835i.setColor(this.n.getColorForState(getState(), 0));
        this.f41835i.setStrokeWidth(this.m);
    }

    public static Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
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
        return (Bitmap) invokeL.objValue;
    }

    public static Drawable b(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, drawable)) == null) {
            if (drawable == null || (drawable instanceof b) || (drawable instanceof ColorDrawable)) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), b(layerDrawable.getDrawable(i2)));
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
        return (Drawable) invokeL.objValue;
    }

    public b c(ColorStateList colorStateList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, colorStateList)) == null) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.n = colorStateList;
            this.f41835i.setColor(colorStateList.getColorForState(getState(), 0));
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            float f2 = i2;
            this.m = f2;
            this.f41835i.setStrokeWidth(f2);
            return this;
        }
        return (b) invokeI.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.l) {
                if (this.m > 0.0f) {
                    canvas.drawOval(this.f41834h, this.f41835i);
                    canvas.drawOval(this.f41828b, this.f41831e);
                    return;
                }
                canvas.drawOval(this.f41828b, this.f41831e);
            } else if (this.m > 0.0f) {
                RectF rectF = this.f41834h;
                float f2 = this.k;
                canvas.drawRoundRect(rectF, f2, f2, this.f41835i);
                canvas.drawRoundRect(this.f41828b, Math.max(this.k - this.m, 0.0f), Math.max(this.k - this.m, 0.0f), this.f41831e);
            } else {
                RectF rectF2 = this.f41828b;
                float f3 = this.k;
                canvas.drawRoundRect(rectF2, f3, f3, this.f41831e);
            }
        }
    }

    public b e(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            this.k = f2;
            return this;
        }
        return (b) invokeF.objValue;
    }

    public b f(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.l = z;
            return this;
        }
        return (b) invokeZ.objValue;
    }

    public b g(ImageView.ScaleType scaleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, scaleType)) == null) {
            if (scaleType == null) {
                scaleType = ImageView.ScaleType.FIT_XY;
            }
            if (this.o != scaleType) {
                this.o = scaleType;
                h();
            }
            return this;
        }
        return (b) invokeL.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41833g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f41832f : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public final void h() {
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f41834h.set(this.f41827a);
            RectF rectF = this.f41828b;
            float f2 = this.m;
            rectF.set(f2, f2, this.f41834h.width() - this.m, this.f41834h.height() - this.m);
            float f3 = 0.0f;
            switch (a.f41836a[this.o.ordinal()]) {
                case 1:
                    this.f41834h.set(this.f41827a);
                    RectF rectF2 = this.f41828b;
                    float f4 = this.m;
                    rectF2.set(f4, f4, this.f41834h.width() - this.m, this.f41834h.height() - this.m);
                    this.j.set(null);
                    this.j.setTranslate((int) (((this.f41828b.width() - this.f41832f) * 0.5f) + 0.5f), (int) (((this.f41828b.height() - this.f41833g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.f41834h.set(this.f41827a);
                    RectF rectF3 = this.f41828b;
                    float f5 = this.m;
                    rectF3.set(f5, f5, this.f41834h.width() - this.m, this.f41834h.height() - this.m);
                    this.j.set(null);
                    if (this.f41832f * this.f41828b.height() > this.f41828b.width() * this.f41833g) {
                        width = this.f41828b.height() / this.f41833g;
                        f3 = (this.f41828b.width() - (this.f41832f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.f41828b.width() / this.f41832f;
                        height = (this.f41828b.height() - (this.f41833g * width)) * 0.5f;
                    }
                    this.j.setScale(width, width);
                    Matrix matrix = this.j;
                    float f6 = this.m;
                    matrix.postTranslate(((int) (f3 + 0.5f)) + f6, ((int) (height + 0.5f)) + f6);
                    break;
                case 3:
                    this.j.set(null);
                    float min = (((float) this.f41832f) > this.f41827a.width() || ((float) this.f41833g) > this.f41827a.height()) ? Math.min(this.f41827a.width() / this.f41832f, this.f41827a.height() / this.f41833g) : 1.0f;
                    this.j.setScale(min, min);
                    this.j.postTranslate((int) (((this.f41827a.width() - (this.f41832f * min)) * 0.5f) + 0.5f), (int) (((this.f41827a.height() - (this.f41833g * min)) * 0.5f) + 0.5f));
                    this.f41834h.set(this.f41829c);
                    this.j.mapRect(this.f41834h);
                    RectF rectF4 = this.f41828b;
                    RectF rectF5 = this.f41834h;
                    float f7 = rectF5.left;
                    float f8 = this.m;
                    rectF4.set(f7 + f8, rectF5.top + f8, rectF5.right - f8, rectF5.bottom - f8);
                    this.j.setRectToRect(this.f41829c, this.f41828b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.f41834h.set(this.f41829c);
                    this.j.setRectToRect(this.f41829c, this.f41827a, Matrix.ScaleToFit.CENTER);
                    this.j.mapRect(this.f41834h);
                    RectF rectF6 = this.f41828b;
                    RectF rectF7 = this.f41834h;
                    float f9 = rectF7.left;
                    float f10 = this.m;
                    rectF6.set(f9 + f10, rectF7.top + f10, rectF7.right - f10, rectF7.bottom - f10);
                    this.j.setRectToRect(this.f41829c, this.f41828b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.f41834h.set(this.f41829c);
                    this.j.setRectToRect(this.f41829c, this.f41827a, Matrix.ScaleToFit.END);
                    this.j.mapRect(this.f41834h);
                    RectF rectF8 = this.f41828b;
                    RectF rectF9 = this.f41834h;
                    float f11 = rectF9.left;
                    float f12 = this.m;
                    rectF8.set(f11 + f12, rectF9.top + f12, rectF9.right - f12, rectF9.bottom - f12);
                    this.j.setRectToRect(this.f41829c, this.f41828b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.f41834h.set(this.f41829c);
                    this.j.setRectToRect(this.f41829c, this.f41827a, Matrix.ScaleToFit.START);
                    this.j.mapRect(this.f41834h);
                    RectF rectF10 = this.f41828b;
                    RectF rectF11 = this.f41834h;
                    float f13 = rectF11.left;
                    float f14 = this.m;
                    rectF10.set(f13 + f14, rectF11.top + f14, rectF11.right - f14, rectF11.bottom - f14);
                    this.j.setRectToRect(this.f41829c, this.f41828b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.f41834h.set(this.f41827a);
                    RectF rectF12 = this.f41828b;
                    float f15 = this.m;
                    rectF12.set(f15 + 0.0f, f15 + 0.0f, this.f41834h.width() - this.m, this.f41834h.height() - this.m);
                    this.j.set(null);
                    this.j.setRectToRect(this.f41829c, this.f41828b, Matrix.ScaleToFit.FILL);
                    break;
            }
            RectF rectF13 = this.f41834h;
            float f16 = this.m;
            rectF13.inset(f16 / 2.0f, f16 / 2.0f);
            this.f41830d.setLocalMatrix(this.j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.n.isStateful() : invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rect) == null) {
            super.onBoundsChange(rect);
            this.f41827a.set(rect);
            h();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iArr)) == null) {
            int colorForState = this.n.getColorForState(iArr, 0);
            if (this.f41835i.getColor() != colorForState) {
                this.f41835i.setColor(colorForState);
                return true;
            }
            return super.onStateChange(iArr);
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f41831e.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, colorFilter) == null) {
            this.f41831e.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }
}
