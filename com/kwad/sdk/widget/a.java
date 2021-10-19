package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.au;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final View f74405a;

    /* renamed from: b  reason: collision with root package name */
    public final c f74406b;

    /* renamed from: c  reason: collision with root package name */
    public final au f74407c;

    /* renamed from: d  reason: collision with root package name */
    public final int f74408d;

    /* renamed from: e  reason: collision with root package name */
    public float f74409e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f74410f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f74411g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f74412h;

    /* renamed from: i  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f74413i;

    public a(View view, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f74409e = 0.1f;
        this.f74412h = true;
        this.f74405a = view;
        this.f74406b = cVar;
        this.f74407c = new au(view);
        this.f74408d = ap.l(view.getContext());
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f74412h) {
            e();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            if (g()) {
                f();
                return;
            }
            i();
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            i();
            c cVar = this.f74406b;
            if (cVar != null) {
                cVar.a(this.f74405a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            if (!this.f74407c.a() || Math.abs(this.f74407c.f74277a.height() - this.f74405a.getHeight()) > this.f74405a.getHeight() * (1.0f - this.f74409e) || this.f74405a.getHeight() <= 0 || this.f74405a.getWidth() <= 0) {
                return false;
            }
            Rect rect = this.f74407c.f74277a;
            return rect.bottom > 0 && rect.top < this.f74408d;
        }
        return invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.f74413i == null) {
            this.f74413i = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.kwad.sdk.widget.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f74414a;

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
                    this.f74414a = this;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.f74414a.g()) {
                        this.f74414a.f();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.f74405a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f74413i);
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f74413i == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.f74405a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.f74413i);
            }
            this.f74413i = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74409e : invokeV.floatValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f74409e = f2;
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            this.f74411g = false;
            if (this.f74410f || (i4 | i5) != 0 || (i2 | i3) == 0) {
                return;
            }
            this.f74411g = true;
            this.f74410f = true;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f74412h = z;
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
        }
    }

    public void b(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) && this.f74411g) {
            d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i();
            this.f74410f = false;
        }
    }
}
