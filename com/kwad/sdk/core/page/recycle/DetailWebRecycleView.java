package com.kwad.sdk.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.p;
/* loaded from: classes6.dex */
public class DetailWebRecycleView extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f34754a;

    /* renamed from: b  reason: collision with root package name */
    public int f34755b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34756c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34757d;

    /* renamed from: e  reason: collision with root package name */
    public int f34758e;

    /* renamed from: f  reason: collision with root package name */
    public int f34759f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34760g;

    /* renamed from: h  reason: collision with root package name */
    public int f34761h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f34762i;
    public ax j;

    /* loaded from: classes6.dex */
    public interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DetailWebRecycleView(Context context) {
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
    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
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
    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f34755b = 1000;
        this.f34756c = false;
        this.f34757d = false;
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.core.page.recycle.DetailWebRecycleView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DetailWebRecycleView f34763a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34763a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        Object a2 = p.a(this.f34763a, "mGapWorker");
                        if (a2 != null) {
                            p.a(a2, "postFromTraversal", this.f34763a, 0, Integer.valueOf(this.f34763a.f34755b));
                        }
                    } catch (RuntimeException e2) {
                        com.kwad.sdk.core.d.a.b(e2);
                    }
                }
            }
        };
        this.f34762i = runnable;
        this.j = new ax(runnable);
        this.f34761h = context instanceof Activity ? av.c((Activity) context) : av.b(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            postDelayed(this.j, 50L);
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.j);
        }
    }

    @Override // com.kwad.sdk.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            a aVar = this.f34754a;
            if (aVar == null || !aVar.a(motionEvent)) {
                this.f34759f = computeVerticalScrollOffset();
                if (motionEvent.getY() <= this.f34758e - this.f34759f) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int computeVerticalScrollOffset = computeVerticalScrollOffset();
            this.f34759f = computeVerticalScrollOffset;
            if (computeVerticalScrollOffset >= this.f34758e) {
                return false;
            }
            fling((int) f2, (int) f3);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), iArr}) == null) {
            int computeVerticalScrollOffset = computeVerticalScrollOffset();
            this.f34759f = computeVerticalScrollOffset;
            if ((i3 > 0 && computeVerticalScrollOffset < this.f34758e) && !this.f34760g && this.f34759f < this.f34761h) {
                scrollBy(0, i3);
                iArr[1] = i3;
            }
            if (i3 < 0 && this.f34759f > 0 && !ViewCompat.canScrollVertically(view, -1)) {
                scrollBy(0, i3);
                iArr[1] = i3;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onScrollStateChanged(i2);
            if (i2 == 0) {
                View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    int bottom2 = getBottom() - getPaddingBottom();
                    int position = getLayoutManager().getPosition(childAt);
                    if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                        this.f34760g = true;
                        return;
                    }
                }
                this.f34760g = false;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, view, view2, i2)) == null) ? (i2 & 2) != 0 : invokeLLI.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view, view2) == null) {
            if (this.f34757d) {
                this.f34757d = false;
            } else if (this.f34756c) {
            } else {
                super.requestChildFocus(view, view2);
            }
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f34756c = z;
        }
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f34757d = z;
        }
    }

    public void setInterceptTouchListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f34754a = aVar;
        }
    }

    public void setTopViewHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f34758e = i2;
        }
    }
}
