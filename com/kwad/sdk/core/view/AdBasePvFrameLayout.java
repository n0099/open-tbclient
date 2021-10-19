package com.kwad.sdk.core.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.d.a;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.widget.d;
/* loaded from: classes10.dex */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f72751a;

    /* renamed from: b  reason: collision with root package name */
    public float f72752b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72753c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f72754d;

    /* renamed from: e  reason: collision with root package name */
    public int f72755e;

    /* renamed from: f  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f72756f;

    /* renamed from: g  reason: collision with root package name */
    public ViewTreeObserver f72757g;

    /* renamed from: h  reason: collision with root package name */
    public au f72758h;

    /* renamed from: i  reason: collision with root package name */
    public d f72759i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBasePvFrameLayout(@NonNull Context context) {
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
        this.f72751a = 500L;
        this.f72752b = 0.1f;
        this.f72754d = true;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
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
        this.f72751a = 500L;
        this.f72752b = 0.1f;
        this.f72754d = true;
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdBasePvFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.f72751a = 500L;
        this.f72752b = 0.1f;
        this.f72754d = true;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f72758h = new au(this);
            this.f72755e = ap.l(getContext());
            this.f72754d = m();
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (c()) {
                o();
            } else {
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (!this.f72758h.a() || Math.abs(this.f72758h.f74277a.height() - getHeight()) > getHeight() * (1.0f - this.f72752b) || getHeight() <= 0 || getWidth() <= 0) {
                return false;
            }
            Rect rect = this.f72758h.f74277a;
            return rect.bottom > 0 && rect.top < this.f72755e;
        }
        return invokeV.booleanValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.f72756f == null) {
            this.f72756f = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdBasePvFrameLayout f72760a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f72760a = this;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f72760a.c()) {
                        this.f72760a.o();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.f72757g = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f72756f);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f72754d) {
            b();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            p();
            d dVar = this.f72759i;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            p();
            this.f72753c = false;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            boolean z = true;
            if (this.f72753c || (i4 | i5) != 0 || (i2 | i3) == 0) {
                z = false;
            } else {
                this.f72753c = true;
            }
            super.onSizeChanged(i2, i3, i4, i5);
            if (z) {
                n();
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            try {
                if (this.f72756f != null && this.f72757g != null && this.f72757g.isAlive()) {
                    this.f72757g.removeOnScrollChangedListener(this.f72756f);
                }
                this.f72756f = null;
            } catch (Exception e2) {
                a.a(e2);
            }
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
            this.f72752b = f2;
        }
    }

    public void setVisibleListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            this.f72759i = dVar;
        }
    }
}
