package com.kwad.sdk.contentalliance.home.viewpager;

import android.database.DataSetObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes7.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public int f35304h;

    /* renamed from: i  reason: collision with root package name */
    public final DataSetObserver f35305i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((KsFragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35304h = 5000;
        this.f35305i = new DataSetObserver(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35306a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f35306a = this;
            }

            @Override // android.database.DataSetObserver
            public void onChanged() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.onChanged();
                    com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "onChanged");
                    b bVar = this.f35306a;
                    ((a) bVar).f35281c = -1;
                    ((a) bVar).f35280b = -1;
                    bVar.f35283e.a(SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_SCROLL_END);
                }
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 - this.f35304h : invokeI.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(SlidePlayViewPager slidePlayViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, slidePlayViewPager) == null) {
            super.a(slidePlayViewPager);
            slidePlayViewPager.a(this.f35305i);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, adTemplate, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            this.f35282d = i2;
            if (list == null || list.isEmpty()) {
                return;
            }
            int i4 = 5000;
            if (adTemplate != null) {
                int a2 = a(this.f35283e.getCurrentItem());
                int indexOf = (this.f35282d != 0 || i3 <= -1) ? list.indexOf(adTemplate) : i3;
                StringBuilder sb = new StringBuilder();
                sb.append("mStartIndex=");
                sb.append(this.f35304h);
                sb.append("--beforeUpdatedIndex=");
                sb.append(a2);
                sb.append("--afterUpdatedIndex");
                sb.append(indexOf);
                sb.append("--feedReplacedIndex=");
                sb.append(i3);
                sb.append("--mSourceType=");
                sb.append(this.f35282d == 0 ? "FEED" : "PROFILE");
                com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", sb.toString());
                if (a2 >= 0 && indexOf >= 0) {
                    i4 = this.f35304h + (a2 - indexOf);
                }
            }
            this.f35304h = i4;
            ((a) this).f35279a.clear();
            ((a) this).f35279a.addAll(list);
            if (this.f35282d == 1 && e(a(this.f35283e.getCurrentItem())) == null) {
                this.f35304h = this.f35283e.getCurrentItem();
                com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "correct mStartIndex:" + this.f35304h);
            }
            ((a) this).f35281c = -2;
            if (!z) {
                ((a) this).f35280b = this.f35283e.getCurrentItem();
            }
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "replaceFeed notifyDataSetChanged mStartIndex:" + this.f35304h);
            notifyDataSetChanged();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            super.a(z);
            this.f35283e.b(this.f35305i);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f35304h : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.b(i2);
            this.f35304h += i2;
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (b() + a()) - 1 : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 + this.f35304h : invokeI.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 10000;
        }
        return invokeV.intValue;
    }
}
