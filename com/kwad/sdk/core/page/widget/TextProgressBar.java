package com.kwad.sdk.core.page.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.av;
/* loaded from: classes2.dex */
public class TextProgressBar extends ProgressBar {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f64920a;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public String f64921b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f64922c;

    /* renamed from: d  reason: collision with root package name */
    public LinearGradient f64923d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f64924e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64925f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f64926g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64927h;

    /* renamed from: i  reason: collision with root package name */
    public int f64928i;
    public int j;
    public Drawable k;
    public int l;
    public Rect m;
    public int[] n;
    public int o;
    public int p;
    public RectF q;
    public boolean r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1839523294, "Lcom/kwad/sdk/core/page/widget/TextProgressBar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1839523294, "Lcom/kwad/sdk/core/page/widget/TextProgressBar;");
                return;
            }
        }
        f64920a = KsAdSDKImpl.get().isDebugLogEnable();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProgressBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64926g = false;
        this.f64927h = true;
        this.m = new Rect();
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f64926g = false;
        this.f64927h = true;
        this.m = new Rect();
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Paint paint = new Paint();
            this.f64922c = paint;
            paint.setAntiAlias(true);
            this.f64922c.setColor(-1);
            this.f64922c.setTextSize(av.a(getContext(), 12.0f));
            this.l = av.a(getContext(), 2.0f);
            this.q = new RectF();
            this.o = -1;
            this.p = -45056;
        }
    }

    private void setProgressText(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2) == null) {
            this.f64921b = String.valueOf((int) (((i2 * 1.0f) / getMax()) * 100.0f)) + "%";
        }
    }

    public void a(@ColorInt int i2, @ColorInt int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            this.r = true;
            this.o = i2;
            this.p = i3;
            postInvalidate();
        }
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            this.f64921b = str;
            this.f64925f = true;
            setProgress(i2);
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            synchronized (this) {
                if (this.f64926g) {
                    canvas.save();
                    canvas.rotate(90.0f);
                    canvas.translate(0.0f, -getWidth());
                    super.onDraw(canvas);
                    canvas.restore();
                } else {
                    super.onDraw(canvas);
                }
                if (!TextUtils.isEmpty(this.f64921b)) {
                    this.f64922c.getTextBounds(this.f64921b, 0, this.f64921b.length(), this.m);
                }
                int height = (getHeight() / 2) - this.m.centerY();
                if (this.k != null) {
                    int intrinsicWidth = this.k.getIntrinsicWidth();
                    int intrinsicHeight = this.k.getIntrinsicHeight();
                    int width2 = (((getWidth() - this.m.width()) - intrinsicWidth) - this.l) / 2;
                    int i2 = intrinsicWidth + width2;
                    this.k.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i2, (getHeight() + intrinsicHeight) / 2);
                    this.k.draw(canvas);
                    width = i2 + this.l;
                } else {
                    width = (getWidth() / 2) - this.m.centerX();
                }
                if (this.n != null) {
                    float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
                    float f2 = width;
                    if (progress >= f2) {
                        if (this.f64923d == null) {
                            this.f64923d = new LinearGradient(f2, 0.0f, width + this.m.width(), 0.0f, this.n, (float[]) null, Shader.TileMode.CLAMP);
                            Matrix matrix = new Matrix();
                            this.f64924e = matrix;
                            this.f64923d.setLocalMatrix(matrix);
                        }
                        this.f64922c.setShader(this.f64923d);
                        this.f64924e.setScale(((progress - f2) * 1.0f) / this.m.width(), 1.0f, f2, 0.0f);
                        this.f64923d.setLocalMatrix(this.f64924e);
                    } else {
                        this.f64922c.setShader(null);
                    }
                    canvas.drawText(this.f64921b, f2, height, this.f64922c);
                } else {
                    if (!isIndeterminate() && !this.r) {
                        this.f64922c.setColor(this.o);
                        if (this.f64921b != null) {
                            canvas.drawText(this.f64921b, width, height, this.f64922c);
                        }
                    }
                    float width3 = (getWidth() * getProgress()) / getMax();
                    int save = canvas.save();
                    this.q.set(width3, 0.0f, getWidth(), getHeight());
                    canvas.clipRect(this.q);
                    this.f64922c.setColor(this.p);
                    if (this.f64921b != null) {
                        canvas.drawText(this.f64921b, width, height, this.f64922c);
                    }
                    canvas.restoreToCount(save);
                    int save2 = canvas.save();
                    this.q.set(0.0f, 0.0f, width3, getHeight());
                    canvas.clipRect(this.q);
                    this.f64922c.setColor(this.o);
                    if (this.f64921b != null) {
                        canvas.drawText(this.f64921b, width, height, this.f64922c);
                    }
                    canvas.restoreToCount(save2);
                }
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            synchronized (this) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null && !TextUtils.isEmpty(this.f64921b)) {
                    Rect rect = new Rect();
                    this.f64922c.getTextBounds(this.f64921b, 0, this.f64921b.length(), rect);
                    if (layoutParams.width == -2) {
                        int width = rect.width() + this.f64928i + this.j;
                        layoutParams.width = width;
                        i2 = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
                    }
                    if (layoutParams.height == -2) {
                        int height = rect.height();
                        layoutParams.height = height;
                        i3 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
                    }
                }
                if (this.f64926g) {
                    super.onMeasure(i3, i2);
                    setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
                } else {
                    super.onMeasure(i2, i3);
                }
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i2, i3, i4, i5) == null) {
            if (this.f64926g) {
                super.onSizeChanged(i3, i2, i4, i5);
            } else {
                super.onSizeChanged(i2, i3, i4, i5);
            }
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            this.k = drawable;
        }
    }

    public void setDrawablePadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setHasProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f64927h = z;
        }
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, i4, i5) == null) {
            this.f64928i = i2;
            this.j = i4;
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            if (!this.f64927h) {
                i2 = 0;
            }
            super.setProgress(i2);
        }
    }

    public void setTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.r = false;
            this.o = i2;
            postInvalidate();
        }
    }

    public void setTextDimen(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            this.f64922c.setTextSize(f2);
        }
    }

    public void setTextDimenSp(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f64922c.setTextSize(TypedValue.applyDimension(2, i2, getResources().getDisplayMetrics()));
        }
    }

    public void setVertical(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f64926g = z;
        }
    }
}
