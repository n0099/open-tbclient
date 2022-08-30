package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.webview.KsAdWebView;
/* loaded from: classes7.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int GI;
    public int GJ;
    public final int[] GK;
    public final int[] GL;
    public int GM;
    public boolean GN;
    public int GO;
    public int GP;
    public NestedScrollingChildHelper GQ;
    public VelocityTracker GR;
    public int GS;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollWebView(Context context) {
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
        this.GK = new int[2];
        this.GL = new int[2];
        nX();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
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
        this.GK = new int[2];
        this.GL = new int[2];
        nX();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
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
        this.GK = new int[2];
        this.GL = new int[2];
        nX();
    }

    private void nX() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.GS = 0;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.GQ = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
            this.GP = viewConfiguration.getScaledMaximumFlingVelocity();
            this.GO = viewConfiguration.getScaledMinimumFlingVelocity();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) ? this.GQ.dispatchNestedFling(f, f2, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? this.GQ.dispatchNestedPreFling(f, f2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) ? this.GQ.dispatchNestedPreScroll(i, i2, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) ? this.GQ.dispatchNestedScroll(i, i2, i3, i4, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.GQ.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.GQ.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i, i2) == null) {
            if (this.GS != 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.b.kwai.a.d((Activity) getContext()) : com.kwad.sdk.b.kwai.a.getScreenHeight(getContext())) - (com.kwad.components.core.m.e.oB() ? com.kwad.sdk.b.kwai.a.aH(getContext()) : 0)) - this.GS, 1073741824);
            }
            super.onMeasure(i, i2);
        }
    }

    @Override // com.kwad.components.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            if (hasFocus()) {
                return;
            }
            requestFocus();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean onTouchEvent;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            boolean z = false;
            if (actionMasked == 0) {
                this.GM = 0;
            }
            if (this.GR == null) {
                this.GR = VelocityTracker.obtain();
            }
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            int y = (int) motionEvent.getY();
            motionEvent.offsetLocation(0.0f, this.GM);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i = this.GI - y;
                        if (dispatchNestedPreScroll(0, i, this.GL, this.GK)) {
                            i -= this.GL[1];
                            obtain.offsetLocation(0.0f, this.GK[1]);
                            this.GM += this.GK[1];
                        }
                        int scrollY = getScrollY();
                        this.GI = y - this.GK[1];
                        int max = Math.max(0, scrollY + i);
                        int i2 = i - (max - scrollY);
                        if (dispatchNestedScroll(0, max - i2, 0, i2, this.GK)) {
                            this.GI = this.GI - this.GK[1];
                            obtain.offsetLocation(0.0f, iArr[1]);
                            this.GM += this.GK[1];
                        }
                        if (Math.abs(this.GL[1]) >= 5 || Math.abs(this.GK[1]) >= 5) {
                            if (!this.GN) {
                                this.GN = true;
                                super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                            }
                            onTouchEvent = false;
                        } else {
                            if (this.GN) {
                                this.GN = false;
                                onTouchEvent = false;
                            } else {
                                onTouchEvent = super.onTouchEvent(obtain);
                            }
                            obtain.recycle();
                        }
                    } else if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            stopNestedScroll();
                            onTouchEvent = super.onTouchEvent(motionEvent);
                        }
                        onTouchEvent = false;
                    }
                }
                this.GR.addMovement(motionEvent);
                this.GR.computeCurrentVelocity(1000, this.GP);
                float f = -VelocityTrackerCompat.getYVelocity(this.GR, MotionEventCompat.getPointerId(motionEvent, actionIndex));
                if (Math.abs(f) > this.GO && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                    dispatchNestedFling(0.0f, f, true);
                }
                boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
                stopNestedScroll();
                if (Math.abs(motionEvent.getY() - this.GI) < 10.0f) {
                    Math.abs(motionEvent.getX() - this.GJ);
                }
                onTouchEvent = onTouchEvent2;
                z = true;
            } else {
                this.GI = y;
                this.GJ = (int) motionEvent.getX();
                startNestedScroll(2);
                int[] iArr2 = this.GL;
                iArr2[0] = 0;
                iArr2[1] = 0;
                int[] iArr3 = this.GK;
                iArr3[0] = 0;
                iArr3[1] = 0;
                onTouchEvent = super.onTouchEvent(motionEvent);
                this.GN = false;
            }
            if (!z) {
                this.GR.addMovement(motionEvent);
            }
            return onTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.GQ.setNestedScrollingEnabled(z);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i)) == null) ? this.GQ.startNestedScroll(i) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.GQ.stopNestedScroll();
        }
    }
}
