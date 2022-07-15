package com.kwad.components.core.page.widget;

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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class TextProgressBar extends ProgressBar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String a;
    public Paint b;
    public LinearGradient c;
    public Matrix d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public Drawable j;
    public int k;
    public Rect l;
    public int[] m;
    public int n;
    public int o;
    public RectF p;
    public boolean q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextProgressBar(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = true;
        this.l = new Rect();
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
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = true;
        this.l = new Rect();
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Paint paint = new Paint();
            this.b = paint;
            paint.setAntiAlias(true);
            this.b.setColor(-1);
            this.b.setTextSize(com.kwad.sdk.b.kwai.a.a(getContext(), 12.0f));
            this.k = com.kwad.sdk.b.kwai.a.a(getContext(), 2.0f);
            this.p = new RectF();
            this.n = -1;
            this.o = -117146;
        }
    }

    private void setProgressText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            this.a = String.valueOf((int) (((i * 1.0f) / getMax()) * 100.0f)) + "%";
        }
    }

    public final void a(@ColorInt int i, @ColorInt int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            this.q = true;
            this.n = i;
            this.o = i2;
            postInvalidate();
        }
    }

    public final void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) == null) {
            this.a = str;
            this.e = true;
            setProgress(i);
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            synchronized (this) {
                if (this.f) {
                    canvas.save();
                    canvas.rotate(90.0f);
                    canvas.translate(0.0f, -getWidth());
                    super.onDraw(canvas);
                    canvas.restore();
                } else {
                    super.onDraw(canvas);
                }
                if (!TextUtils.isEmpty(this.a)) {
                    this.b.getTextBounds(this.a, 0, this.a.length(), this.l);
                }
                int height = (getHeight() / 2) - this.l.centerY();
                if (this.j != null) {
                    int intrinsicWidth = this.j.getIntrinsicWidth();
                    int intrinsicHeight = this.j.getIntrinsicHeight();
                    int width2 = (((getWidth() - this.l.width()) - intrinsicWidth) - this.k) / 2;
                    int i = intrinsicWidth + width2;
                    this.j.setBounds(width2, (getHeight() - intrinsicHeight) / 2, i, (getHeight() + intrinsicHeight) / 2);
                    this.j.draw(canvas);
                    width = i + this.k;
                } else {
                    width = (getWidth() / 2) - this.l.centerX();
                }
                if (this.m != null) {
                    float progress = ((getProgress() * 1.0f) / getMax()) * getWidth();
                    float f = width;
                    if (progress >= f) {
                        if (this.c == null) {
                            this.c = new LinearGradient(f, 0.0f, width + this.l.width(), 0.0f, this.m, (float[]) null, Shader.TileMode.CLAMP);
                            Matrix matrix = new Matrix();
                            this.d = matrix;
                            this.c.setLocalMatrix(matrix);
                        }
                        this.b.setShader(this.c);
                        this.d.setScale(((progress - f) * 1.0f) / this.l.width(), 1.0f, f, 0.0f);
                        this.c.setLocalMatrix(this.d);
                    } else {
                        this.b.setShader(null);
                    }
                    canvas.drawText(this.a, f, height, this.b);
                    return;
                }
                if (!isIndeterminate() && !this.q) {
                    this.b.setColor(this.n);
                    if (this.a != null) {
                        canvas.drawText(this.a, width, height, this.b);
                    }
                    return;
                }
                float width3 = (getWidth() * getProgress()) / getMax();
                int save = canvas.save();
                this.p.set(width3, 0.0f, getWidth(), getHeight());
                canvas.clipRect(this.p);
                this.b.setColor(this.o);
                if (this.a != null) {
                    canvas.drawText(this.a, width, height, this.b);
                }
                canvas.restoreToCount(save);
                int save2 = canvas.save();
                this.p.set(0.0f, 0.0f, width3, getHeight());
                canvas.clipRect(this.p);
                this.b.setColor(this.n);
                if (this.a != null) {
                    canvas.drawText(this.a, width, height, this.b);
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            synchronized (this) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null && !TextUtils.isEmpty(this.a)) {
                    Rect rect = new Rect();
                    this.b.getTextBounds(this.a, 0, this.a.length(), rect);
                    if (layoutParams.width == -2) {
                        int width = rect.width() + this.h + this.i;
                        layoutParams.width = width;
                        i = View.MeasureSpec.makeMeasureSpec(width, 1073741824);
                    }
                    if (layoutParams.height == -2) {
                        int height = rect.height();
                        layoutParams.height = height;
                        i2 = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
                    }
                }
                if (!this.f) {
                    super.onMeasure(i, i2);
                    return;
                }
                super.onMeasure(i2, i);
                setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048580, this, i, i2, i3, i4) == null) {
            if (this.f) {
                super.onSizeChanged(i2, i, i3, i4);
            } else {
                super.onSizeChanged(i, i2, i3, i4);
            }
        }
    }

    public void setDrawableLeft(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, drawable) == null) {
            this.j = drawable;
        }
    }

    public void setDrawablePadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.k = i;
        }
    }

    public void setHasProgress(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.g = z;
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            this.h = i;
            this.i = i3;
        }
    }

    @Override // android.widget.ProgressBar
    public void setProgress(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (this.g) {
                super.setProgress(i);
            } else {
                super.setProgress(0);
            }
        }
    }

    public void setTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.q = false;
            this.n = i;
            postInvalidate();
        }
    }

    public void setTextDimen(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f) == null) {
            this.b.setTextSize(f);
        }
    }

    public void setTextDimenSp(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.b.setTextSize(TypedValue.applyDimension(2, i, getResources().getDisplayMetrics()));
        }
    }

    public void setVertical(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.f = z;
        }
    }
}
