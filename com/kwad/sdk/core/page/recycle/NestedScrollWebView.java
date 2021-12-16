package com.kwad.sdk.core.page.recycle;

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
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
/* loaded from: classes3.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f58166c;

    /* renamed from: d  reason: collision with root package name */
    public int f58167d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f58168e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f58169f;

    /* renamed from: g  reason: collision with root package name */
    public int f58170g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58171h;

    /* renamed from: i  reason: collision with root package name */
    public int f58172i;

    /* renamed from: j  reason: collision with root package name */
    public int f58173j;

    /* renamed from: k  reason: collision with root package name */
    public NestedScrollingChildHelper f58174k;
    public VelocityTracker l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollWebView(Context context) {
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
        this.f58168e = new int[2];
        this.f58169f = new int[2];
        a((AttributeSet) null);
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
        this.f58168e = new int[2];
        this.f58169f = new int[2];
        a(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f58168e = new int[2];
        this.f58169f = new int[2];
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, attributeSet) == null) {
            this.m = 0;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.f58174k = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
            this.f58173j = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f58172i = viewConfiguration.getScaledMinimumFlingVelocity();
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.f58174k.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.f58174k.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.f58174k.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.f58174k.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f58174k.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f58174k.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            if (this.m != 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.a.kwai.a.b((Activity) getContext()) : com.kwad.sdk.a.kwai.a.b(getContext())) - (com.kwad.sdk.utils.d.a() ? com.kwad.sdk.a.kwai.a.a(getContext()) : 0)) - this.m, 1073741824);
            }
            super.onMeasure(i2, i3);
        }
    }

    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048583, this, i2, i3, i4, i5) == null) {
            super.onScrollChanged(i2, i3, i4, i5);
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
                this.f58170g = 0;
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            int y = (int) motionEvent.getY();
            motionEvent.offsetLocation(0.0f, this.f58170g);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.f58166c - y;
                        if (dispatchNestedPreScroll(0, i2, this.f58169f, this.f58168e)) {
                            i2 -= this.f58169f[1];
                            obtain.offsetLocation(0.0f, this.f58168e[1]);
                            this.f58170g += this.f58168e[1];
                        }
                        int scrollY = getScrollY();
                        this.f58166c = y - this.f58168e[1];
                        int max = Math.max(0, scrollY + i2);
                        int i3 = i2 - (max - scrollY);
                        if (dispatchNestedScroll(0, max - i3, 0, i3, this.f58168e)) {
                            this.f58166c = this.f58166c - this.f58168e[1];
                            obtain.offsetLocation(0.0f, iArr[1]);
                            this.f58170g += this.f58168e[1];
                        }
                        if (Math.abs(this.f58169f[1]) >= 5 || Math.abs(this.f58168e[1]) >= 5) {
                            if (!this.f58171h) {
                                this.f58171h = true;
                                super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                            }
                            onTouchEvent = false;
                        } else {
                            if (this.f58171h) {
                                this.f58171h = false;
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
                this.l.addMovement(motionEvent);
                this.l.computeCurrentVelocity(1000, this.f58173j);
                float f2 = -VelocityTrackerCompat.getYVelocity(this.l, MotionEventCompat.getPointerId(motionEvent, actionIndex));
                if (Math.abs(f2) > this.f58172i && !dispatchNestedPreFling(0.0f, f2) && hasNestedScrollingParent()) {
                    dispatchNestedFling(0.0f, f2, true);
                }
                boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
                stopNestedScroll();
                if (Math.abs(motionEvent.getY() - this.f58166c) < 10.0f && Math.abs(motionEvent.getX() - this.f58167d) < 10.0f) {
                    d();
                }
                onTouchEvent = onTouchEvent2;
                z = true;
            } else {
                this.f58166c = y;
                this.f58167d = (int) motionEvent.getX();
                startNestedScroll(2);
                int[] iArr2 = this.f58169f;
                iArr2[0] = 0;
                iArr2[1] = 0;
                int[] iArr3 = this.f58168e;
                iArr3[0] = 0;
                iArr3[1] = 0;
                onTouchEvent = super.onTouchEvent(motionEvent);
                this.f58171h = false;
            }
            if (!z) {
                this.l.addMovement(motionEvent);
            }
            return onTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.f58174k.setNestedScrollingEnabled(z);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? this.f58174k.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f58174k.stopNestedScroll();
        }
    }
}
