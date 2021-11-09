package com.dxmpay.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.DisplayUtils;
/* loaded from: classes11.dex */
public class GridLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f62395e;

    /* renamed from: f  reason: collision with root package name */
    public int f62396f;

    /* renamed from: g  reason: collision with root package name */
    public int f62397g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f62398h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f62399i;
    public Integer j;
    public int k;
    public int l;
    public Paint m;
    public Integer n;
    public RectF o;
    public int p;

    /* loaded from: classes11.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f62400a;

        /* renamed from: b  reason: collision with root package name */
        public int f62401b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.n = null;
        this.o = new RectF();
        this.p = 0;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f62395e = 3;
            this.f62396f = DisplayUtils.dip2px(getContext(), 1.0f);
            this.f62397g = DisplayUtils.dip2px(getContext(), 1.0f);
            this.f62398h = new RectF();
            this.f62399i = new Paint();
            this.m = new Paint();
            this.o = new RectF();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.n != null && getChildCount() > this.f62395e && this.f62397g > 0) {
                float height = getChildAt(getChildCount() - 1).getHeight();
                for (int i2 = 1; i2 < Math.ceil((getChildCount() * 1.0f) / this.f62395e); i2++) {
                    RectF rectF = this.o;
                    rectF.left = this.k;
                    int i3 = this.f62397g;
                    float f2 = i2;
                    rectF.top = (getPaddingTop() + ((i3 + height) * f2)) - i3;
                    this.o.right = getWidth() - this.k;
                    this.o.bottom = getPaddingTop() + ((this.f62397g + height) * f2);
                    canvas.drawRect(this.o, this.m);
                }
            }
            if (this.n != null && this.f62395e > 1 && this.f62396f > 0) {
                float width = getChildAt(getChildCount() - 1).getWidth();
                for (int i4 = 1; i4 < this.f62395e; i4++) {
                    RectF rectF2 = this.o;
                    int i5 = this.f62396f;
                    float f3 = i4;
                    rectF2.left = (getPaddingLeft() + ((i5 + width) * f3)) - i5;
                    RectF rectF3 = this.o;
                    rectF3.top = this.l;
                    rectF3.right = getPaddingLeft() + ((this.f62396f + width) * f3);
                    this.o.bottom = getHeight() - this.l;
                    canvas.drawRect(this.o, this.m);
                }
            }
            if (getChildCount() % this.f62395e == 0 || this.j == null) {
                return;
            }
            View childAt = getChildAt(getChildCount() - 1);
            this.f62398h.set(childAt.getLeft() + childAt.getWidth() + this.f62396f, childAt.getTop(), getLeft() + getWidth(), getTop() + getHeight());
            this.f62399i.setColor(this.j.intValue());
            canvas.drawRect(this.f62398h, this.f62399i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i7 = layoutParams.f62400a;
                    int i8 = layoutParams.f62401b;
                    childAt.layout(i7, i8, ((ViewGroup.LayoutParams) layoutParams).width + i7, ((ViewGroup.LayoutParams) layoutParams).height + i8);
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 0);
            int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int i4 = this.f62396f;
            int i5 = this.f62395e;
            int i6 = (size - (i4 * (i5 - 1))) / i5;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                View childAt = getChildAt(i9);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i2, makeMeasureSpec);
                    i8 = childAt.getMeasuredHeight();
                    if (this.p <= i8) {
                        this.p = i8;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i6, 1073741824), View.MeasureSpec.makeMeasureSpec(this.p, 1073741824));
                    if ((i9 - i7) % this.f62395e == 0) {
                        paddingLeft = getPaddingLeft();
                        if (i9 != 0) {
                            paddingTop += this.p + this.f62397g;
                        }
                    } else {
                        paddingLeft += this.f62396f + i6;
                    }
                    if (childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof LayoutParams)) {
                        layoutParams = (LayoutParams) childAt.getLayoutParams();
                    } else {
                        LayoutParams layoutParams2 = new LayoutParams(0, 0);
                        childAt.setLayoutParams(layoutParams2);
                        layoutParams = layoutParams2;
                    }
                    layoutParams.f62400a = paddingLeft;
                    layoutParams.f62401b = paddingTop;
                    ((ViewGroup.LayoutParams) layoutParams).width = i6;
                    ((ViewGroup.LayoutParams) layoutParams).height = this.p;
                } else {
                    i7++;
                }
            }
            int i10 = childCount - i7;
            int i11 = this.f62395e;
            int i12 = (i10 / i11) + (i10 % i11 != 0 ? 1 : 0);
            setMeasuredDimension(View.MeasureSpec.getSize(i2), (i8 * i12) + (this.f62397g * (i12 - 1)) + getPaddingTop() + getPaddingBottom());
        }
    }

    public void setColumnCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f62395e = i2;
        }
    }

    public void setEmptyAreaColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.j = Integer.valueOf(i2);
        }
    }

    public void setHorizontalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f62396f = i2;
        }
    }

    public void setSeparateLine(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048583, this, i2, i3, i4) == null) {
            Integer valueOf = Integer.valueOf(i2);
            this.n = valueOf;
            this.k = i3;
            this.l = i4;
            this.m.setColor(valueOf.intValue());
        }
    }

    public void setVerticalSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f62397g = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.n = null;
        this.o = new RectF();
        this.p = 0;
        a();
    }
}
