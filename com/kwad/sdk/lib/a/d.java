package com.kwad.sdk.lib.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class d extends KsFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View f38500a;

    /* renamed from: b  reason: collision with root package name */
    public PagerSlidingTabStrip f38501b;

    /* renamed from: c  reason: collision with root package name */
    public ViewPager f38502c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.viewpager.tabstrip.a f38503d;

    /* renamed from: e  reason: collision with root package name */
    public int f38504e;

    /* renamed from: f  reason: collision with root package name */
    public int f38505f;

    /* renamed from: g  reason: collision with root package name */
    public String f38506g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f38507h;

    /* renamed from: i  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f38508i;

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38505f = -1;
        this.f38506g = null;
        this.f38507h = new ViewPager.OnPageChangeListener(this) { // from class: com.kwad.sdk.lib.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f38509a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f38510b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f38511c;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f38509a = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    if (this.f38509a.j()) {
                        if (i4 == 0 && this.f38511c && this.f38510b) {
                            d dVar = this.f38509a;
                            dVar.a(dVar.g());
                            this.f38510b = false;
                            this.f38511c = false;
                        } else if (i4 == 2) {
                            this.f38510b = true;
                        }
                    }
                    if (this.f38509a.f38508i != null) {
                        this.f38509a.f38508i.onPageScrollStateChanged(i4);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i4, float f2, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i4), Float.valueOf(f2), Integer.valueOf(i5)}) == null) {
                    if (this.f38509a.f38508i != null) {
                        this.f38509a.f38508i.onPageScrolled(i4, f2, i5);
                    }
                    this.f38510b = true;
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4) == null) {
                    this.f38511c = true;
                    if (!this.f38510b || !this.f38509a.j()) {
                        this.f38509a.a(i4);
                    }
                    if (this.f38509a.f38508i != null) {
                        this.f38509a.f38508i.onPageSelected(i4);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        com.kwad.sdk.lib.widget.viewpager.tabstrip.a aVar;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || (aVar = this.f38503d) == null || i2 == (i3 = this.f38504e)) {
            return;
        }
        aVar.a(i3);
        this.f38503d.a(i2);
        this.f38504e = i2;
    }

    private String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65540, this, i2)) == null) ? this.f38503d.c(i2) : (String) invokeI.objValue;
    }

    private int e() {
        InterceptResult invokeV;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (h() == null || this.f38503d == null || (a2 = a(h())) < 0) {
                return 0;
            }
            return a2;
        }
        return invokeV.intValue;
    }

    public abstract int a();

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f38503d.a(str) : invokeL.intValue;
    }

    public void a(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, bundle) == null) {
            a(i2, bundle, false);
        }
    }

    public void a(int i2, Bundle bundle, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), bundle, Boolean.valueOf(z)}) == null) {
            this.f38503d.a(i2, bundle);
            this.f38502c.setCurrentItem(i2, z);
        }
    }

    public void a(List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            this.f38503d.a(list);
            this.f38501b.c();
        }
    }

    public abstract int b();

    public abstract int c();

    public abstract List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d();

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ViewPager viewPager = this.f38502c;
            return viewPager != null ? viewPager.getCurrentItem() : e();
        }
        return invokeV.intValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (TextUtils.isEmpty(this.f38506g)) {
                int i2 = this.f38505f;
                return i2 >= 0 ? b(i2) : i();
            }
            return this.f38506g;
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(a(), viewGroup, false);
            this.f38500a = inflate;
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            bundle.putInt("last_selected_item_pos", g());
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        ViewPager viewPager;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.f38501b = (PagerSlidingTabStrip) this.f38500a.findViewById(b());
            this.f38502c = (ViewPager) this.f38500a.findViewById(c());
            this.f38503d = new com.kwad.sdk.lib.widget.viewpager.tabstrip.a(getActivity(), getChildFragmentManager());
            List<com.kwad.sdk.lib.widget.viewpager.tabstrip.b> d2 = d();
            this.f38502c.setAdapter(this.f38503d);
            if (d2 != null && !d2.isEmpty()) {
                this.f38503d.a(d2);
                this.f38504e = e();
                if (getArguments() == null || !getArguments().containsKey("last_selected_item_pos")) {
                    viewPager = this.f38502c;
                    i2 = this.f38504e;
                } else {
                    viewPager = this.f38502c;
                    i2 = getArguments().getInt("last_selected_item_pos");
                }
                viewPager.setCurrentItem(i2, false);
            }
            this.f38501b.setViewPager(this.f38502c);
            this.f38501b.setOnPageChangeListener(this.f38507h);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewStateRestored(@Nullable Bundle bundle) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            if (bundle != null && (i2 = bundle.getInt("last_selected_item_pos", -1)) != -1) {
                a(i2, f() ? bundle : null);
            }
            super.onViewStateRestored(bundle);
        }
    }
}
