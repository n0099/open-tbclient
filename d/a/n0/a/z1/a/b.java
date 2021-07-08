package d.a.n0.a.z1.a;

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
    public final RectF f48631a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f48632b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f48633c;

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f48634d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f48635e;

    /* renamed from: f  reason: collision with root package name */
    public final int f48636f;

    /* renamed from: g  reason: collision with root package name */
    public final int f48637g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f48638h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f48639i;
    public final Matrix j;
    public float k;
    public int l;
    public int m;
    public ImageView.ScaleType n;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f48640a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-80590772, "Ld/a/n0/a/z1/a/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-80590772, "Ld/a/n0/a/z1/a/b$a;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f48640a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48640a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48640a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48640a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f48640a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f48640a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f48640a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap, float f2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48631a = new RectF();
        this.f48632b = new RectF();
        this.f48633c = new RectF();
        this.f48638h = new RectF();
        this.j = new Matrix();
        this.n = ImageView.ScaleType.FIT_XY;
        this.l = i2;
        this.m = i3;
        this.f48636f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f48637g = height;
        this.f48633c.set(0.0f, 0.0f, this.f48636f, height);
        this.k = f2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f48634d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f48635e = paint;
        paint.setAntiAlias(true);
        this.f48635e.setShader(this.f48634d);
        Paint paint2 = new Paint();
        this.f48639i = paint2;
        paint2.setAntiAlias(true);
        this.f48639i.setColor(this.m);
        this.f48639i.setStrokeWidth(i2);
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

    @SuppressLint({"SwanDebugLog"})
    public static Drawable b(Drawable drawable, ImageView.ScaleType scaleType, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{drawable, scaleType, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
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
        return (Drawable) invokeCommon.objValue;
    }

    public ImageView.ScaleType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (ImageView.ScaleType) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.m = i2;
            this.f48639i.setColor(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.l > 0) {
                RectF rectF = this.f48638h;
                float f2 = this.k;
                canvas.drawRoundRect(rectF, f2, f2, this.f48639i);
                canvas.drawRoundRect(this.f48632b, Math.max(this.k - this.l, 0.0f), Math.max(this.k - this.l, 0.0f), this.f48635e);
                return;
            }
            RectF rectF2 = this.f48632b;
            float f3 = this.k;
            canvas.drawRoundRect(rectF2, f3, f3, this.f48635e);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.l = i2;
            this.f48639i.setStrokeWidth(i2);
        }
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.k = f2;
        }
    }

    public final void g() {
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f48638h.set(this.f48631a);
            RectF rectF = this.f48632b;
            int i2 = this.l;
            rectF.set(i2 + 0, i2 + 0, this.f48638h.width() - this.l, this.f48638h.height() - this.l);
            switch (a.f48640a[this.n.ordinal()]) {
                case 1:
                    this.f48638h.set(this.f48631a);
                    RectF rectF2 = this.f48632b;
                    int i3 = this.l;
                    rectF2.set(i3 + 0, i3 + 0, this.f48638h.width() - this.l, this.f48638h.height() - this.l);
                    this.j.set(null);
                    this.j.setTranslate((int) (((this.f48632b.width() - this.f48636f) * 0.5f) + 0.5f), (int) (((this.f48632b.height() - this.f48637g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.f48638h.set(this.f48631a);
                    RectF rectF3 = this.f48632b;
                    int i4 = this.l;
                    rectF3.set(i4 + 0, i4 + 0, this.f48638h.width() - this.l, this.f48638h.height() - this.l);
                    this.j.set(null);
                    float f2 = 0.0f;
                    if (this.f48636f * this.f48632b.height() > this.f48632b.width() * this.f48637g) {
                        width = this.f48632b.height() / this.f48637g;
                        f2 = (this.f48632b.width() - (this.f48636f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.f48632b.width() / this.f48636f;
                        height = (this.f48632b.height() - (this.f48637g * width)) * 0.5f;
                    }
                    this.j.setScale(width, width);
                    Matrix matrix = this.j;
                    int i5 = this.l;
                    matrix.postTranslate(((int) (f2 + 0.5f)) + i5, ((int) (height + 0.5f)) + i5);
                    break;
                case 3:
                    this.j.set(null);
                    float min = (((float) this.f48636f) > this.f48631a.width() || ((float) this.f48637g) > this.f48631a.height()) ? Math.min(this.f48631a.width() / this.f48636f, this.f48631a.height() / this.f48637g) : 1.0f;
                    this.j.setScale(min, min);
                    this.j.postTranslate((int) (((this.f48631a.width() - (this.f48636f * min)) * 0.5f) + 0.5f), (int) (((this.f48631a.height() - (this.f48637g * min)) * 0.5f) + 0.5f));
                    this.f48638h.set(this.f48633c);
                    this.j.mapRect(this.f48638h);
                    RectF rectF4 = this.f48632b;
                    RectF rectF5 = this.f48638h;
                    float f3 = rectF5.left;
                    int i6 = this.l;
                    rectF4.set(f3 + i6, rectF5.top + i6, rectF5.right - i6, rectF5.bottom - i6);
                    this.j.setRectToRect(this.f48633c, this.f48632b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.f48638h.set(this.f48633c);
                    this.j.setRectToRect(this.f48633c, this.f48631a, Matrix.ScaleToFit.CENTER);
                    this.j.mapRect(this.f48638h);
                    RectF rectF6 = this.f48632b;
                    RectF rectF7 = this.f48638h;
                    float f4 = rectF7.left;
                    int i7 = this.l;
                    rectF6.set(f4 + i7, rectF7.top + i7, rectF7.right - i7, rectF7.bottom - i7);
                    this.j.setRectToRect(this.f48633c, this.f48632b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.f48638h.set(this.f48633c);
                    this.j.setRectToRect(this.f48633c, this.f48631a, Matrix.ScaleToFit.END);
                    this.j.mapRect(this.f48638h);
                    RectF rectF8 = this.f48632b;
                    RectF rectF9 = this.f48638h;
                    float f5 = rectF9.left;
                    int i8 = this.l;
                    rectF8.set(f5 + i8, rectF9.top + i8, rectF9.right - i8, rectF9.bottom - i8);
                    this.j.setRectToRect(this.f48633c, this.f48632b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.f48638h.set(this.f48633c);
                    this.j.setRectToRect(this.f48633c, this.f48631a, Matrix.ScaleToFit.START);
                    this.j.mapRect(this.f48638h);
                    RectF rectF10 = this.f48632b;
                    RectF rectF11 = this.f48638h;
                    float f6 = rectF11.left;
                    int i9 = this.l;
                    rectF10.set(f6 + i9, rectF11.top + i9, rectF11.right - i9, rectF11.bottom - i9);
                    this.j.setRectToRect(this.f48633c, this.f48632b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.f48638h.set(this.f48631a);
                    RectF rectF12 = this.f48632b;
                    int i10 = this.l;
                    rectF12.set(i10 + 0, i10 + 0, this.f48638h.width() - this.l, this.f48638h.height() - this.l);
                    this.j.set(null);
                    this.j.setRectToRect(this.f48633c, this.f48632b, Matrix.ScaleToFit.FILL);
                    break;
            }
            this.f48634d.setLocalMatrix(this.j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f48637g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f48636f : invokeV.intValue;
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

    public void h(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, scaleType) == null) {
            if (scaleType == null) {
                scaleType = ImageView.ScaleType.FIT_XY;
            }
            if (this.n != scaleType) {
                this.n = scaleType;
                g();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rect) == null) {
            super.onBoundsChange(rect);
            this.f48631a.set(rect);
            g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f48635e.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.f48635e.setColorFilter(colorFilter);
        }
    }
}
