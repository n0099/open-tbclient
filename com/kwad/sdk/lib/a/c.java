package com.kwad.sdk.lib.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class c<PAGE, MODEL> extends KsFragment implements a.InterfaceC0470a, b<PAGE> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f38493a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f38494b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f38495c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public RefreshLayout f38496d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f38497e;

    /* renamed from: f  reason: collision with root package name */
    public a f38498f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f38499g;

    public c() {
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

    @NonNull
    private com.kwad.sdk.lib.a.a.b<PAGE, MODEL> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f2 = f();
            f2.f38467e = this;
            f2.f38468f = this.f38494b;
            f2.k = this;
            f2.f38469g = c();
            com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> d2 = d();
            this.f38495c = d2;
            com.kwad.sdk.lib.widget.recycler.d dVar = new com.kwad.sdk.lib.widget.recycler.d(d2);
            f2.f38470h = this.f38495c;
            f2.f38471i = dVar;
            f2.j = this.f38496d;
            f2.l = h();
            return f2;
        }
        return (com.kwad.sdk.lib.a.a.b) invokeV.objValue;
    }

    public abstract int a();

    public void a(@NonNull Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, presenter) == null) {
        }
    }

    public abstract int b();

    public abstract com.kwad.sdk.lib.b.c<PAGE, MODEL> c();

    public abstract com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> d();

    @Override // com.kwad.sdk.lib.a.a.InterfaceC0470a
    @NonNull
    public final Presenter e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.lib.a.b.b(g()));
            if (this.f38497e) {
                presenter.a((Presenter) new com.kwad.sdk.lib.a.b.d());
            }
            presenter.a((Presenter) new com.kwad.sdk.lib.a.b.a());
            a(presenter);
            presenter.a((Presenter) new com.kwad.sdk.lib.a.b.c());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    public com.kwad.sdk.lib.a.a.b<PAGE, MODEL> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new com.kwad.sdk.lib.a.a.b<>() : (com.kwad.sdk.lib.a.a.b) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public final RecyclerView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38494b : (RecyclerView) invokeV.objValue;
    }

    public RefreshLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (RefreshLayout) invokeV.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityCreated(@Nullable Bundle bundle) {
        List<com.kwad.sdk.contentalliance.a.c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onActivityCreated(bundle);
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f38499g;
            if (bVar == null || (list = bVar.f38466d) == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : list) {
                cVar.e();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i2, int i3, Intent intent) {
        List<com.kwad.sdk.contentalliance.a.c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048588, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f38499g;
            if (bVar == null || (list = bVar.f38466d) == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : list) {
                cVar.a(i2, i3, intent);
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onCreate(bundle);
            this.f38498f = new a(this, this);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, layoutInflater, viewGroup, bundle)) == null) {
            if (this.f38493a == null) {
                ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(a(), viewGroup, false);
                this.f38493a = viewGroup2;
                this.f38494b = (RecyclerView) viewGroup2.findViewById(b());
                RefreshLayout j = j();
                this.f38496d = j;
                this.f38497e = j != null;
            }
            return this.f38493a;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f38499g;
            if (bVar == null || (list = bVar.f38466d) == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : list) {
                cVar.g();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onDestroyView();
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f38499g;
            if (bVar == null || (list = bVar.f38466d) == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : list) {
                cVar.f();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPause();
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f38499g;
            if (bVar == null || (list = bVar.f38466d) == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : list) {
                cVar.d();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        List<com.kwad.sdk.contentalliance.a.c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            com.kwad.sdk.lib.a.a.b<PAGE, MODEL> bVar = this.f38499g;
            if (bVar == null || (list = bVar.f38466d) == null) {
                return;
            }
            for (com.kwad.sdk.contentalliance.a.c cVar : list) {
                cVar.c();
            }
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            if (this.f38498f != null) {
                com.kwad.sdk.lib.a.a.b<PAGE, MODEL> k = k();
                this.f38499g = k;
                this.f38498f.a(k);
            }
        }
    }
}
