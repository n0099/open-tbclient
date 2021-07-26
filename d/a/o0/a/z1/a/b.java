package d.a.o0.a.z1.a;

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
    public final RectF f49135a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f49136b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f49137c;

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f49138d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f49139e;

    /* renamed from: f  reason: collision with root package name */
    public final int f49140f;

    /* renamed from: g  reason: collision with root package name */
    public final int f49141g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f49142h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f49143i;
    public final Matrix j;
    public float k;
    public int l;
    public int m;
    public ImageView.ScaleType n;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f49144a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-586149397, "Ld/a/o0/a/z1/a/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-586149397, "Ld/a/o0/a/z1/a/b$a;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f49144a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f49144a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f49144a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f49144a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f49144a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f49144a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f49144a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
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
        this.f49135a = new RectF();
        this.f49136b = new RectF();
        this.f49137c = new RectF();
        this.f49142h = new RectF();
        this.j = new Matrix();
        this.n = ImageView.ScaleType.FIT_XY;
        this.l = i2;
        this.m = i3;
        this.f49140f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f49141g = height;
        this.f49137c.set(0.0f, 0.0f, this.f49140f, height);
        this.k = f2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f49138d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f49139e = paint;
        paint.setAntiAlias(true);
        this.f49139e.setShader(this.f49138d);
        Paint paint2 = new Paint();
        this.f49143i = paint2;
        paint2.setAntiAlias(true);
        this.f49143i.setColor(this.m);
        this.f49143i.setStrokeWidth(i2);
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
            this.f49143i.setColor(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.l > 0) {
                RectF rectF = this.f49142h;
                float f2 = this.k;
                canvas.drawRoundRect(rectF, f2, f2, this.f49143i);
                canvas.drawRoundRect(this.f49136b, Math.max(this.k - this.l, 0.0f), Math.max(this.k - this.l, 0.0f), this.f49139e);
                return;
            }
            RectF rectF2 = this.f49136b;
            float f3 = this.k;
            canvas.drawRoundRect(rectF2, f3, f3, this.f49139e);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.l = i2;
            this.f49143i.setStrokeWidth(i2);
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
            this.f49142h.set(this.f49135a);
            RectF rectF = this.f49136b;
            int i2 = this.l;
            rectF.set(i2 + 0, i2 + 0, this.f49142h.width() - this.l, this.f49142h.height() - this.l);
            switch (a.f49144a[this.n.ordinal()]) {
                case 1:
                    this.f49142h.set(this.f49135a);
                    RectF rectF2 = this.f49136b;
                    int i3 = this.l;
                    rectF2.set(i3 + 0, i3 + 0, this.f49142h.width() - this.l, this.f49142h.height() - this.l);
                    this.j.set(null);
                    this.j.setTranslate((int) (((this.f49136b.width() - this.f49140f) * 0.5f) + 0.5f), (int) (((this.f49136b.height() - this.f49141g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.f49142h.set(this.f49135a);
                    RectF rectF3 = this.f49136b;
                    int i4 = this.l;
                    rectF3.set(i4 + 0, i4 + 0, this.f49142h.width() - this.l, this.f49142h.height() - this.l);
                    this.j.set(null);
                    float f2 = 0.0f;
                    if (this.f49140f * this.f49136b.height() > this.f49136b.width() * this.f49141g) {
                        width = this.f49136b.height() / this.f49141g;
                        f2 = (this.f49136b.width() - (this.f49140f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.f49136b.width() / this.f49140f;
                        height = (this.f49136b.height() - (this.f49141g * width)) * 0.5f;
                    }
                    this.j.setScale(width, width);
                    Matrix matrix = this.j;
                    int i5 = this.l;
                    matrix.postTranslate(((int) (f2 + 0.5f)) + i5, ((int) (height + 0.5f)) + i5);
                    break;
                case 3:
                    this.j.set(null);
                    float min = (((float) this.f49140f) > this.f49135a.width() || ((float) this.f49141g) > this.f49135a.height()) ? Math.min(this.f49135a.width() / this.f49140f, this.f49135a.height() / this.f49141g) : 1.0f;
                    this.j.setScale(min, min);
                    this.j.postTranslate((int) (((this.f49135a.width() - (this.f49140f * min)) * 0.5f) + 0.5f), (int) (((this.f49135a.height() - (this.f49141g * min)) * 0.5f) + 0.5f));
                    this.f49142h.set(this.f49137c);
                    this.j.mapRect(this.f49142h);
                    RectF rectF4 = this.f49136b;
                    RectF rectF5 = this.f49142h;
                    float f3 = rectF5.left;
                    int i6 = this.l;
                    rectF4.set(f3 + i6, rectF5.top + i6, rectF5.right - i6, rectF5.bottom - i6);
                    this.j.setRectToRect(this.f49137c, this.f49136b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.f49142h.set(this.f49137c);
                    this.j.setRectToRect(this.f49137c, this.f49135a, Matrix.ScaleToFit.CENTER);
                    this.j.mapRect(this.f49142h);
                    RectF rectF6 = this.f49136b;
                    RectF rectF7 = this.f49142h;
                    float f4 = rectF7.left;
                    int i7 = this.l;
                    rectF6.set(f4 + i7, rectF7.top + i7, rectF7.right - i7, rectF7.bottom - i7);
                    this.j.setRectToRect(this.f49137c, this.f49136b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.f49142h.set(this.f49137c);
                    this.j.setRectToRect(this.f49137c, this.f49135a, Matrix.ScaleToFit.END);
                    this.j.mapRect(this.f49142h);
                    RectF rectF8 = this.f49136b;
                    RectF rectF9 = this.f49142h;
                    float f5 = rectF9.left;
                    int i8 = this.l;
                    rectF8.set(f5 + i8, rectF9.top + i8, rectF9.right - i8, rectF9.bottom - i8);
                    this.j.setRectToRect(this.f49137c, this.f49136b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.f49142h.set(this.f49137c);
                    this.j.setRectToRect(this.f49137c, this.f49135a, Matrix.ScaleToFit.START);
                    this.j.mapRect(this.f49142h);
                    RectF rectF10 = this.f49136b;
                    RectF rectF11 = this.f49142h;
                    float f6 = rectF11.left;
                    int i9 = this.l;
                    rectF10.set(f6 + i9, rectF11.top + i9, rectF11.right - i9, rectF11.bottom - i9);
                    this.j.setRectToRect(this.f49137c, this.f49136b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.f49142h.set(this.f49135a);
                    RectF rectF12 = this.f49136b;
                    int i10 = this.l;
                    rectF12.set(i10 + 0, i10 + 0, this.f49142h.width() - this.l, this.f49142h.height() - this.l);
                    this.j.set(null);
                    this.j.setRectToRect(this.f49137c, this.f49136b, Matrix.ScaleToFit.FILL);
                    break;
            }
            this.f49138d.setLocalMatrix(this.j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f49141g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f49140f : invokeV.intValue;
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
            this.f49135a.set(rect);
            g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f49139e.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.f49139e.setColorFilter(colorFilter);
        }
    }
}
