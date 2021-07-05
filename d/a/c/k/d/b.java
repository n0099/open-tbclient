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
/* loaded from: classes8.dex */
public class b extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final RectF f44811a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f44812b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f44813c;

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f44814d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f44815e;

    /* renamed from: f  reason: collision with root package name */
    public final int f44816f;

    /* renamed from: g  reason: collision with root package name */
    public final int f44817g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f44818h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f44819i;
    public final Matrix j;
    public float k;
    public boolean l;
    public float m;
    public ColorStateList n;
    public ImageView.ScaleType o;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f44820a;
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
            f44820a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44820a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44820a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44820a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f44820a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f44820a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f44820a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
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
        this.f44811a = new RectF();
        this.f44812b = new RectF();
        this.f44813c = new RectF();
        this.f44818h = new RectF();
        this.j = new Matrix();
        this.k = 0.0f;
        this.l = false;
        this.m = 0.0f;
        this.n = ColorStateList.valueOf(0);
        this.o = ImageView.ScaleType.FIT_XY;
        this.f44816f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f44817g = height;
        this.f44813c.set(0.0f, 0.0f, this.f44816f, height);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f44814d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f44815e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f44815e.setAntiAlias(true);
        this.f44815e.setShader(this.f44814d);
        Paint paint2 = new Paint();
        this.f44819i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f44819i.setAntiAlias(true);
        this.f44819i.setColor(this.n.getColorForState(getState(), 0));
        this.f44819i.setStrokeWidth(this.m);
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
            this.f44819i.setColor(colorStateList.getColorForState(getState(), 0));
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
            this.f44819i.setStrokeWidth(f2);
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
                    canvas.drawOval(this.f44818h, this.f44819i);
                    canvas.drawOval(this.f44812b, this.f44815e);
                    return;
                }
                canvas.drawOval(this.f44812b, this.f44815e);
            } else if (this.m > 0.0f) {
                RectF rectF = this.f44818h;
                float f2 = this.k;
                canvas.drawRoundRect(rectF, f2, f2, this.f44819i);
                canvas.drawRoundRect(this.f44812b, Math.max(this.k - this.m, 0.0f), Math.max(this.k - this.m, 0.0f), this.f44815e);
            } else {
                RectF rectF2 = this.f44812b;
                float f3 = this.k;
                canvas.drawRoundRect(rectF2, f3, f3, this.f44815e);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f44817g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f44816f : invokeV.intValue;
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
            this.f44818h.set(this.f44811a);
            RectF rectF = this.f44812b;
            float f2 = this.m;
            rectF.set(f2, f2, this.f44818h.width() - this.m, this.f44818h.height() - this.m);
            float f3 = 0.0f;
            switch (a.f44820a[this.o.ordinal()]) {
                case 1:
                    this.f44818h.set(this.f44811a);
                    RectF rectF2 = this.f44812b;
                    float f4 = this.m;
                    rectF2.set(f4, f4, this.f44818h.width() - this.m, this.f44818h.height() - this.m);
                    this.j.set(null);
                    this.j.setTranslate((int) (((this.f44812b.width() - this.f44816f) * 0.5f) + 0.5f), (int) (((this.f44812b.height() - this.f44817g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.f44818h.set(this.f44811a);
                    RectF rectF3 = this.f44812b;
                    float f5 = this.m;
                    rectF3.set(f5, f5, this.f44818h.width() - this.m, this.f44818h.height() - this.m);
                    this.j.set(null);
                    if (this.f44816f * this.f44812b.height() > this.f44812b.width() * this.f44817g) {
                        width = this.f44812b.height() / this.f44817g;
                        f3 = (this.f44812b.width() - (this.f44816f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.f44812b.width() / this.f44816f;
                        height = (this.f44812b.height() - (this.f44817g * width)) * 0.5f;
                    }
                    this.j.setScale(width, width);
                    Matrix matrix = this.j;
                    float f6 = this.m;
                    matrix.postTranslate(((int) (f3 + 0.5f)) + f6, ((int) (height + 0.5f)) + f6);
                    break;
                case 3:
                    this.j.set(null);
                    float min = (((float) this.f44816f) > this.f44811a.width() || ((float) this.f44817g) > this.f44811a.height()) ? Math.min(this.f44811a.width() / this.f44816f, this.f44811a.height() / this.f44817g) : 1.0f;
                    this.j.setScale(min, min);
                    this.j.postTranslate((int) (((this.f44811a.width() - (this.f44816f * min)) * 0.5f) + 0.5f), (int) (((this.f44811a.height() - (this.f44817g * min)) * 0.5f) + 0.5f));
                    this.f44818h.set(this.f44813c);
                    this.j.mapRect(this.f44818h);
                    RectF rectF4 = this.f44812b;
                    RectF rectF5 = this.f44818h;
                    float f7 = rectF5.left;
                    float f8 = this.m;
                    rectF4.set(f7 + f8, rectF5.top + f8, rectF5.right - f8, rectF5.bottom - f8);
                    this.j.setRectToRect(this.f44813c, this.f44812b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.f44818h.set(this.f44813c);
                    this.j.setRectToRect(this.f44813c, this.f44811a, Matrix.ScaleToFit.CENTER);
                    this.j.mapRect(this.f44818h);
                    RectF rectF6 = this.f44812b;
                    RectF rectF7 = this.f44818h;
                    float f9 = rectF7.left;
                    float f10 = this.m;
                    rectF6.set(f9 + f10, rectF7.top + f10, rectF7.right - f10, rectF7.bottom - f10);
                    this.j.setRectToRect(this.f44813c, this.f44812b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.f44818h.set(this.f44813c);
                    this.j.setRectToRect(this.f44813c, this.f44811a, Matrix.ScaleToFit.END);
                    this.j.mapRect(this.f44818h);
                    RectF rectF8 = this.f44812b;
                    RectF rectF9 = this.f44818h;
                    float f11 = rectF9.left;
                    float f12 = this.m;
                    rectF8.set(f11 + f12, rectF9.top + f12, rectF9.right - f12, rectF9.bottom - f12);
                    this.j.setRectToRect(this.f44813c, this.f44812b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.f44818h.set(this.f44813c);
                    this.j.setRectToRect(this.f44813c, this.f44811a, Matrix.ScaleToFit.START);
                    this.j.mapRect(this.f44818h);
                    RectF rectF10 = this.f44812b;
                    RectF rectF11 = this.f44818h;
                    float f13 = rectF11.left;
                    float f14 = this.m;
                    rectF10.set(f13 + f14, rectF11.top + f14, rectF11.right - f14, rectF11.bottom - f14);
                    this.j.setRectToRect(this.f44813c, this.f44812b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.f44818h.set(this.f44811a);
                    RectF rectF12 = this.f44812b;
                    float f15 = this.m;
                    rectF12.set(f15 + 0.0f, f15 + 0.0f, this.f44818h.width() - this.m, this.f44818h.height() - this.m);
                    this.j.set(null);
                    this.j.setRectToRect(this.f44813c, this.f44812b, Matrix.ScaleToFit.FILL);
                    break;
            }
            RectF rectF13 = this.f44818h;
            float f16 = this.m;
            rectF13.inset(f16 / 2.0f, f16 / 2.0f);
            this.f44814d.setLocalMatrix(this.j);
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
            this.f44811a.set(rect);
            h();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, iArr)) == null) {
            int colorForState = this.n.getColorForState(iArr, 0);
            if (this.f44819i.getColor() != colorForState) {
                this.f44819i.setColor(colorForState);
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
            this.f44815e.setAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, colorFilter) == null) {
            this.f44815e.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }
}
