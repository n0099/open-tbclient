package com.kwad.sdk.contentalliance.detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.sdk.contentalliance.b<c> implements com.kwad.sdk.contentalliance.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f34332d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public h f34333e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34334f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f34335g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34336h;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.b
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
        }
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            this.f34333e = hVar;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && o() && !this.f34334f) {
            this.f34334f = true;
            j();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && o() && this.f34334f) {
            this.f34334f = false;
            k();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && o() && !this.f34335g) {
            this.f34335g = true;
            l();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && o() && this.f34335g) {
            this.f34335g = false;
            m();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = getArguments() != null ? getArguments().getInt("KEY_INDEX_IN_VIEW_PAGER") : -1;
            SlidePlayViewPager slidePlayViewPager = this.f34332d;
            if (slidePlayViewPager == null || i2 != slidePlayViewPager.getRealPosition()) {
                return;
            }
            e();
            g();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void j() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (t = this.f34293b) == 0 || ((c) t).f34575b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f34575b) {
            aVar.j();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void k() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (t = this.f34293b) == 0 || ((c) t).f34575b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f34575b) {
            aVar.k();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void l() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t = this.f34293b) == 0 || ((c) t).f34575b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f34575b) {
            aVar.l();
        }
    }

    @Override // com.kwad.sdk.contentalliance.a.a
    public void m() {
        T t;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (t = this.f34293b) == 0 || ((c) t).f34575b == null) {
            return;
        }
        for (com.kwad.sdk.contentalliance.a.a aVar : ((c) t).f34575b) {
            aVar.m();
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f34336h : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onActivityCreated(bundle);
            this.f34336h = true;
            i();
            T t = this.f34293b;
            if (t == 0 || ((c) t).f34576c == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f34576c) {
                cVar.e();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            T t = this.f34293b;
            if (t == 0 || ((c) t).f34576c == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f34576c) {
                cVar.a(i2, i3, intent);
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, layoutInflater, viewGroup, bundle)) == null) {
            if (viewGroup instanceof SlidePlayViewPager) {
                this.f34332d = (SlidePlayViewPager) viewGroup;
            }
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroy();
            T t = this.f34293b;
            if (t == 0 || ((c) t).f34576c == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f34576c) {
                cVar.g();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            T t = this.f34293b;
            if (t != 0) {
                ((c) t).a();
            }
            this.f34336h = false;
            f();
            h();
            T t2 = this.f34293b;
            if (t2 == 0 || ((c) t2).f34576c == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t2).f34576c) {
                cVar.f();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            T t = this.f34293b;
            if (t == 0 || ((c) t).f34576c == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f34576c) {
                cVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onResume();
            T t = this.f34293b;
            if (t == 0 || ((c) t).f34576c == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : ((c) t).f34576c) {
                cVar.c();
            }
        }
    }
}
