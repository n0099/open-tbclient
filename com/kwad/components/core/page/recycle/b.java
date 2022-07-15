package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public a f;
    public boolean g;
    public boolean h;

    /* loaded from: classes5.dex */
    public interface a {
        boolean a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = Integer.MIN_VALUE;
        this.h = false;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Rect rect = this.a;
            if (rect == null) {
                this.a = new Rect();
            } else {
                rect.setEmpty();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    this.a.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                }
            }
        }
    }

    private void a(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TRACKBALL, this, i, i2) == null) {
            a(i, getHeight(), 0);
        }
    }

    private void a(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeIII(65541, this, i, i2, i3) != null) {
            return;
        }
        while (true) {
            if (this.e == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.e = iArr[1];
            }
            int a2 = f.a(this).a();
            int b = f.a(this).b();
            if (a2 == -1 || b == -1) {
                return;
            }
            if (i >= a2 && i <= b) {
                int i4 = i - a2;
                if (getChildCount() > i4) {
                    int[] iArr2 = new int[2];
                    getChildAt(i4).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.e) - i3);
                    return;
                }
                return;
            } else if (i > b) {
                scrollBy(0, i2);
                a(i, i2, i3);
                return;
            } else {
                scrollBy(0, -i2);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter instanceof d) {
                ((d) adapter).a();
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onDetachedFromWindow();
            b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            if (this.b != 0) {
                a();
                Rect rect = this.a;
                if (rect != null && !rect.isEmpty()) {
                    canvas.save();
                    canvas.clipRect(this.a);
                    canvas.drawColor(this.b);
                    canvas.restore();
                }
            }
            super.onDraw(canvas);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (this.g) {
                return false;
            }
            if (motionEvent.getAction() == 0 && this.h) {
                stopScroll();
            }
            a aVar = this.f;
            if (aVar == null || !aVar.a()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            int size = View.MeasureSpec.getSize(i2);
            int i3 = this.c;
            if (i3 > 0 && i3 < size) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.c, View.MeasureSpec.getMode(i2));
            }
            super.onMeasure(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.g) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (this.d) {
                a(i, 0);
            } else {
                super.scrollToPosition(i);
            }
        }
    }

    public void setDisableScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.g = z;
        }
    }

    public void setDownStop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.h = z;
        }
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public void setUnderneathColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.b = i;
            a();
            invalidate();
        }
    }

    public void setUseCustomScrollToPosition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.d = z;
        }
    }
}
