package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.ba;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;

    /* renamed from: b  reason: collision with root package name */
    public final j f59791b;

    /* renamed from: c  reason: collision with root package name */
    public final ba f59792c;

    /* renamed from: d  reason: collision with root package name */
    public final int f59793d;

    /* renamed from: e  reason: collision with root package name */
    public float f59794e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59795f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59796g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59797h;

    /* renamed from: i  reason: collision with root package name */
    public ViewTreeObserver.OnScrollChangedListener f59798i;

    public h(View view, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, jVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59794e = 0.1f;
        this.f59797h = true;
        this.a = view;
        this.f59791b = jVar;
        this.f59792c = new ba(view);
        this.f59793d = av.o(view.getContext());
    }

    private void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.f59797h) {
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
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            i();
            j jVar = this.f59791b;
            if (jVar != null) {
                jVar.a(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (!this.f59792c.a() || Math.abs(this.f59792c.a.height() - this.a.getHeight()) > this.a.getHeight() * (1.0f - this.f59794e) || this.a.getHeight() <= 0 || this.a.getWidth() <= 0) {
                return false;
            }
            Rect rect = this.f59792c.a;
            return rect.bottom > 0 && rect.top < this.f59793d;
        }
        return invokeV.booleanValue;
    }

    private void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && this.f59798i == null) {
            this.f59798i = new ViewTreeObserver.OnScrollChangedListener(this) { // from class: com.kwad.sdk.widget.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ h a;

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
                    this.a = this;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public void onScrollChanged() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.g()) {
                        this.a.f();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.f59798i);
            }
        }
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f59798i == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.f59798i);
            }
            this.f59798i = null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59794e : invokeV.floatValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
            this.f59794e = f2;
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4, i5) == null) {
            this.f59796g = false;
            if (this.f59795f || (i4 | i5) != 0 || (i2 | i3) == 0) {
                return;
            }
            this.f59796g = true;
            this.f59795f = true;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f59797h = z;
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
        if ((interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) && this.f59796g) {
            d();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i();
            this.f59795f = false;
        }
    }
}
