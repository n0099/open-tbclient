package com.kwad.sdk.contentalliance.home.viewpager.a;

import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.b.b;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.c;
/* loaded from: classes7.dex */
public class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f35299b;

    /* renamed from: c  reason: collision with root package name */
    public int f35300c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f35301d;

    public b() {
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

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            SlidePlayViewPager slidePlayViewPager = ((c) this).f35307a.f35310c;
            this.f35301d = slidePlayViewPager;
            slidePlayViewPager.a(new ViewPager.OnPageChangeListener(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35302a;

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
                    this.f35302a = this;
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i2, float f2, int i3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                        this.f35302a.f35300c = i2;
                        if (this.f35302a.f35301d.getAdapter() != null) {
                            this.f35302a.f35301d.getAdapter().a(i2, false);
                        }
                        this.f35302a.f35301d.a(i2 > this.f35302a.f35300c ? SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_NEXT : SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_MOVE_TO_PRE);
                    }
                }
            });
            this.f35301d.setOnPageScrollEndListener(new b.f(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35303a;

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
                    this.f35303a = this;
                }

                @Override // com.kwad.sdk.contentalliance.b.b.f
                public void a() {
                    int currentItem;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35303a.f35299b == (currentItem = ((c) this.f35303a).f35307a.f35310c.getCurrentItem())) {
                        return;
                    }
                    this.f35303a.f35299b = currentItem;
                    if (this.f35303a.f35301d.getAdapter() != null) {
                        this.f35303a.f35301d.getAdapter().a(currentItem, true);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.d();
            if (this.f35301d.getAdapter() != null) {
                this.f35301d.getAdapter().a(true);
            }
        }
    }
}
