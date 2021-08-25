package com.kwad.sdk.core.page.recycle;

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
/* loaded from: classes10.dex */
public class b extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Rect f71909a;

    /* renamed from: b  reason: collision with root package name */
    public int f71910b;

    /* renamed from: c  reason: collision with root package name */
    public int f71911c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f71912d;

    /* renamed from: e  reason: collision with root package name */
    public int f71913e;

    /* renamed from: f  reason: collision with root package name */
    public a f71914f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f71915g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f71916h;

    /* loaded from: classes10.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f71913e = Integer.MIN_VALUE;
        this.f71916h = false;
    }

    private void a(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65539, this, i2, i3, i4) == null) {
            if (this.f71913e == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.f71913e = iArr[1];
            }
            int a2 = f.a(this).a();
            int b2 = f.a(this).b();
            if (a2 == -1 || b2 == -1) {
                return;
            }
            if (i2 < a2 || i2 > b2) {
                if (i2 > b2) {
                    scrollBy(0, i3);
                } else {
                    scrollBy(0, -i3);
                }
                a(i2, i3, i4);
                return;
            }
            int i5 = i2 - a2;
            if (getChildCount() > i5) {
                int[] iArr2 = new int[2];
                getChildAt(i5).getLocationOnScreen(iArr2);
                scrollBy(0, (iArr2[1] - this.f71913e) - i4);
            }
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            Rect rect = this.f71909a;
            if (rect == null) {
                this.f71909a = new Rect();
            } else {
                rect.setEmpty();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    this.f71909a.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                }
            }
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter instanceof d) {
                ((d) adapter).a();
            }
        }
    }

    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3) == null) {
            a(i2, getHeight(), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDetachedFromWindow();
            a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.f71910b != 0) {
                b();
                Rect rect = this.f71909a;
                if (rect != null && !rect.isEmpty()) {
                    canvas.save();
                    canvas.clipRect(this.f71909a);
                    canvas.drawColor(this.f71910b);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (this.f71915g) {
                return false;
            }
            if (motionEvent.getAction() == 0 && this.f71916h) {
                stopScroll();
            }
            a aVar = this.f71914f;
            if (aVar == null || !aVar.a(motionEvent)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            int size = View.MeasureSpec.getSize(i3);
            int i4 = this.f71911c;
            if (i4 > 0 && i4 < size) {
                i3 = View.MeasureSpec.makeMeasureSpec(this.f71911c, View.MeasureSpec.getMode(i3));
            }
            super.onMeasure(i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.f71915g) {
                return false;
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            if (this.f71912d) {
                a(i2, 0);
            } else {
                super.scrollToPosition(i2);
            }
        }
    }

    public void setDisableScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f71915g = z;
        }
    }

    public void setDownStop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f71916h = z;
        }
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f71914f = aVar;
        }
    }

    public void setUnderneathColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f71910b = i2;
            b();
            invalidate();
        }
    }

    public void setUseCustomScrollToPosition(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f71912d = z;
        }
    }
}
