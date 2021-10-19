package com.kwad.sdk.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebViewClient;
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
import com.kwad.sdk.utils.av;
/* loaded from: classes10.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public int f72433c;

    /* renamed from: d  reason: collision with root package name */
    public int f72434d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f72435e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f72436f;

    /* renamed from: g  reason: collision with root package name */
    public int f72437g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72438h;

    /* renamed from: i  reason: collision with root package name */
    public int f72439i;

    /* renamed from: j  reason: collision with root package name */
    public int f72440j;
    public NestedScrollingChildHelper k;
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
        this.f72435e = new int[2];
        this.f72436f = new int[2];
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
        this.f72435e = new int[2];
        this.f72436f = new int[2];
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
        this.f72435e = new int[2];
        this.f72436f = new int[2];
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, attributeSet) == null) {
            this.m = 0;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.k = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
            this.f72440j = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f72439i = viewConfiguration.getScaledMinimumFlingVelocity();
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
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.k.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.k.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.k.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.k.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048582, this, i2, i3) == null) {
            if (this.m != 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? av.c((Activity) getContext()) : av.b(getContext())) - (com.kwad.sdk.utils.d.a() ? av.a(getContext()) : 0)) - this.m, 1073741824);
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
                this.f72437g = 0;
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            int y = (int) motionEvent.getY();
            motionEvent.offsetLocation(0.0f, this.f72437g);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        int i2 = this.f72433c - y;
                        if (dispatchNestedPreScroll(0, i2, this.f72436f, this.f72435e)) {
                            i2 -= this.f72436f[1];
                            obtain.offsetLocation(0.0f, this.f72435e[1]);
                            this.f72437g += this.f72435e[1];
                        }
                        int scrollY = getScrollY();
                        this.f72433c = y - this.f72435e[1];
                        int max = Math.max(0, scrollY + i2);
                        int i3 = i2 - (max - scrollY);
                        if (dispatchNestedScroll(0, max - i3, 0, i3, this.f72435e)) {
                            this.f72433c = this.f72433c - this.f72435e[1];
                            obtain.offsetLocation(0.0f, iArr[1]);
                            this.f72437g += this.f72435e[1];
                        }
                        if (Math.abs(this.f72436f[1]) >= 5 || Math.abs(this.f72435e[1]) >= 5) {
                            if (!this.f72438h) {
                                this.f72438h = true;
                                super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                            }
                            onTouchEvent = false;
                        } else {
                            if (this.f72438h) {
                                this.f72438h = false;
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
                this.l.computeCurrentVelocity(1000, this.f72440j);
                float f2 = -VelocityTrackerCompat.getYVelocity(this.l, MotionEventCompat.getPointerId(motionEvent, actionIndex));
                if (Math.abs(f2) > this.f72439i && !dispatchNestedPreFling(0.0f, f2) && hasNestedScrollingParent()) {
                    dispatchNestedFling(0.0f, f2, true);
                }
                boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
                stopNestedScroll();
                if (Math.abs(motionEvent.getY() - this.f72433c) < 10.0f && Math.abs(motionEvent.getX() - this.f72434d) < 10.0f) {
                    d();
                }
                onTouchEvent = onTouchEvent2;
                z = true;
            } else {
                this.f72433c = y;
                this.f72434d = (int) motionEvent.getX();
                startNestedScroll(2);
                int[] iArr2 = this.f72436f;
                iArr2[0] = 0;
                iArr2[1] = 0;
                int[] iArr3 = this.f72435e;
                iArr3[0] = 0;
                iArr3[1] = 0;
                onTouchEvent = super.onTouchEvent(motionEvent);
                this.f72438h = false;
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
            this.k.setNestedScrollingEnabled(z);
        }
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, webViewClient) == null) {
            super.setWebViewClient(webViewClient);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.k.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.stopNestedScroll();
        }
    }
}
