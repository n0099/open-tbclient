package com.kwad.components.core.page.recycle;

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
import com.kwad.components.core.m.o;
import com.kwad.sdk.utils.q;
/* loaded from: classes8.dex */
public class DetailWebRecycleView extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int GA;
    public int GB;
    public boolean GC;
    public int GD;
    public a GE;
    public Runnable GF;
    public o GG;
    public int Gx;
    public boolean Gy;
    public boolean Gz;

    /* loaded from: classes8.dex */
    public interface a {
        boolean nW();
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
    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet) {
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
    public DetailWebRecycleView(Context context, @Nullable AttributeSet attributeSet, int i) {
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
        this.Gx = 1000;
        this.Gy = false;
        this.Gz = false;
        Runnable runnable = new Runnable(this) { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DetailWebRecycleView GH;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.GH = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        Object c = q.c(this.GH, "mGapWorker");
                        if (c != null) {
                            q.a(c, "postFromTraversal", this.GH, 0, Integer.valueOf(this.GH.Gx));
                        }
                    } catch (RuntimeException e) {
                        com.kwad.sdk.core.e.b.printStackTraceOnly(e);
                    }
                }
            }
        };
        this.GF = runnable;
        this.GG = new o(runnable);
        this.GD = context instanceof Activity ? com.kwad.sdk.b.kwai.a.d((Activity) context) : com.kwad.sdk.b.kwai.a.getScreenHeight(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAttachedToWindow();
            postDelayed(this.GG, 50L);
        }
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDetachedFromWindow();
            removeCallbacks(this.GG);
        }
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            a aVar = this.GE;
            if (aVar == null || !aVar.nW()) {
                this.GB = computeVerticalScrollOffset();
                if (motionEvent.getY() <= this.GA - this.GB) {
                    return super.onInterceptTouchEvent(motionEvent);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            int computeVerticalScrollOffset = computeVerticalScrollOffset();
            this.GB = computeVerticalScrollOffset;
            if (computeVerticalScrollOffset >= this.GA) {
                return false;
            }
            fling((int) f, (int) f2);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view2, int i, int i2, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), iArr}) == null) {
            int computeVerticalScrollOffset = computeVerticalScrollOffset();
            this.GB = computeVerticalScrollOffset;
            if ((i2 > 0 && computeVerticalScrollOffset < this.GA) && !this.GC && this.GB < this.GD) {
                scrollBy(0, i2);
                iArr[1] = i2;
            }
            if (i2 < 0 && this.GB > 0 && !ViewCompat.canScrollVertically(view2, -1)) {
                scrollBy(0, i2);
                iArr[1] = i2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            super.onScrollStateChanged(i);
            if (i == 0) {
                View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
                if (childAt != null) {
                    int bottom = childAt.getBottom();
                    int bottom2 = getBottom() - getPaddingBottom();
                    int position = getLayoutManager().getPosition(childAt);
                    if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                        this.GC = true;
                        return;
                    }
                }
                this.GC = false;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view2, View view3, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048582, this, view2, view3, i)) == null) ? (i & 2) != 0 : invokeLLI.booleanValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, view3) == null) {
            if (this.Gz) {
                this.Gz = false;
            } else if (this.Gy) {
            } else {
                super.requestChildFocus(view2, view3);
            }
        }
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.Gy = z;
        }
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.Gz = z;
        }
    }

    public void setInterceptTouchListener(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.GE = aVar;
        }
    }

    public void setTopViewHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.GA = i;
        }
    }
}
