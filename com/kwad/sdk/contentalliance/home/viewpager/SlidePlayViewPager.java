package com.kwad.sdk.contentalliance.home.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.refreshview.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.util.List;
/* loaded from: classes7.dex */
public class SlidePlayViewPager extends SlidePlayTouchViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public KsFragment f35276g;

    /* renamed from: h  reason: collision with root package name */
    public Presenter f35277h;

    /* renamed from: i  reason: collision with root package name */
    public d f35278i;
    public a j;
    public i k;
    public com.kwad.sdk.contentalliance.detail.b.b l;
    public h m;
    public f n;
    public int o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidePlayViewPager(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidePlayViewPager(Context context, AttributeSet attributeSet) {
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
        this.o = 0;
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            d dVar = new d();
            this.f35278i = dVar;
            dVar.f35308a = this.k;
            dVar.f35309b = this.f35276g;
            dVar.f35310c = this;
            dVar.f35311d = this.f35271d;
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Presenter presenter = new Presenter();
            this.f35277h = presenter;
            presenter.a((Presenter) new com.kwad.sdk.contentalliance.home.viewpager.a.b());
            this.f35277h.a((Presenter) new com.kwad.sdk.contentalliance.home.viewpager.a.a());
            this.f35277h.a((View) this);
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public final void a(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.j) == null) {
            return;
        }
        super.a(aVar.c(i2), z);
    }

    public void a(@NonNull f fVar, @NonNull e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar, eVar) == null) {
            this.n = fVar;
            this.f35276g = fVar.f35219a;
            this.f35271d = eVar;
            this.k = fVar.f35220b;
            this.l = fVar.f35222d;
            this.m = fVar.f35224f;
            this.o = 0;
            b();
            this.f35268a = fVar.k;
            ((SlidePlayTouchViewPager) this).f35269b = true;
            b bVar = new b(this.f35276g.getChildFragmentManager());
            this.j = bVar;
            bVar.a(this.l);
            this.j.a(this.m);
            this.j.a(this);
            u();
            t();
            this.f35277h.a(this.f35278i);
            setAdapter(this.j);
            setCurrentItem(this.n.j);
        }
    }

    public void a(@NonNull AdTemplate adTemplate) {
        int b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, adTemplate) == null) || (b2 = this.k.b(adTemplate)) <= -1) {
            return;
        }
        a(b2, false);
    }

    public void a(@NonNull AdTemplate adTemplate, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, adTemplate, i2) == null) {
            this.o = i2;
            this.f35268a = i2 == 1 ? false : this.n.k;
            this.j.a(this.k.d(), adTemplate, i2, this.k.a(adTemplate), false);
        }
    }

    public void a(@NonNull List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.j.a(list);
        }
    }

    public void a(boolean z) {
        int realPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (realPosition = getRealPosition()) <= -1 || realPosition >= getAdapter().a() - 1) {
            return;
        }
        a(realPosition + 1, z);
    }

    public void b(@NonNull List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            a aVar = this.j;
            if (aVar != null) {
                aVar.a(false);
            }
            if (this.f35276g.getHost() == null) {
                com.kwad.sdk.core.d.a.c("SlidePlayViewPager", "mFragment mHost is null");
                return;
            }
            b();
            b bVar = new b(this.f35276g.getChildFragmentManager());
            this.j = bVar;
            bVar.a(this.l);
            this.j.a(this.m);
            this.j.a(this);
            setAdapter(this.j);
            this.j.a(list);
            setCurrentItem(0);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f35277h.j();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b.b
    public a getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (a) invokeV.objValue;
    }

    public List<AdTemplate> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            a aVar = this.j;
            if (aVar != null) {
                return aVar.d();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager
    public int getFirstValidItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            a aVar = this.j;
            return aVar != null ? aVar.b() : super.getFirstValidItemPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager
    public int getLastValidItemPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            a aVar = this.j;
            return aVar != null ? aVar.c() : super.getLastValidItemPosition();
        }
        return invokeV.intValue;
    }

    public int getRealPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            a aVar = this.j;
            if (aVar != null) {
                return aVar.a(getCurrentItem());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f35268a = false;
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f35268a = this.n.k;
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            a aVar = this.j;
            return aVar == null || aVar.d().size() == 0;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int realPosition = this.f35278i.f35310c.getRealPosition();
            return realPosition > -1 && realPosition < this.j.a() - 1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDetachedFromWindow();
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public final void setCurrentItem(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i2) == null) || (aVar = this.j) == null) {
            return;
        }
        super.setCurrentItem(aVar.c(i2));
    }

    @Override // com.kwad.sdk.contentalliance.b.b
    public void setInitStartPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            a aVar = this.j;
            if (aVar != null) {
                super.setInitStartPosition(aVar.c(i2));
            }
            super.setInitStartPosition(i2);
        }
    }
}
