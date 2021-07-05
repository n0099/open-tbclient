package com.kwad.sdk.contentalliance.home.viewpager.a;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.home.a.d;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.c;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.contentalliance.refreshview.e;
/* loaded from: classes7.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f35286b;

    /* renamed from: c  reason: collision with root package name */
    public i f35287c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public e f35288d;

    /* renamed from: e  reason: collision with root package name */
    public RefreshLayout.b f35289e;

    /* renamed from: f  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f35290f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f35291g;

    /* renamed from: h  reason: collision with root package name */
    public d f35292h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f35293i;

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
                return;
            }
        }
        this.f35289e = new RefreshLayout.b(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35294a;

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
                this.f35294a = this;
            }

            @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35294a.g();
                }
            }
        };
        this.f35290f = new SlidePlayTouchViewPager.a(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35295a;

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
                this.f35295a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f35295a.f();
                }
            }
        };
        this.f35291g = new ViewPager.OnPageChangeListener(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35296a;

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
                this.f35296a = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i4, float f2, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i4), Float.valueOf(f2), Integer.valueOf(i5)}) == null) {
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i4) == null) {
                    int a2 = this.f35296a.f35286b.getAdapter().a(i4);
                    int a3 = this.f35296a.f35286b.getAdapter().a();
                    if (a3 <= 0 || a2 < a3 - 3) {
                        return;
                    }
                    com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "preloadMoreData position=" + a2);
                    this.f35296a.f();
                }
            }
        };
        this.f35292h = new com.kwad.sdk.contentalliance.home.a.e(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35297a;

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
                this.f35297a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
            public void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    if (this.f35297a.f35288d != null) {
                        this.f35297a.f35288d.setRefreshing(false);
                    }
                    this.f35297a.f35286b.i();
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
                    if (!z) {
                        this.f35297a.f35286b.a(this.f35297a.f35287c.d());
                        this.f35297a.f35286b.i();
                        return;
                    }
                    if (this.f35297a.f35288d != null) {
                        this.f35297a.f35288d.setRefreshing(false);
                    }
                    this.f35297a.f35286b.postDelayed(this.f35297a.f35293i, 300L);
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, boolean z2, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                    super.a(z, z2, i4, i5);
                    this.f35297a.f35286b.h();
                }
            }
        };
        this.f35293i = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.home.viewpager.a.a.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35298a;

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
                this.f35298a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f35298a.f35286b.b(this.f35298a.f35287c.d());
                    this.f35298a.f35286b.i();
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
            this.f35287c.a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadMore");
            this.f35287c.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.d.a.a("ViewPagerDataFetcherPresenter", "loadData");
            this.f35287c.a(1);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.c, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.home.viewpager.d dVar = ((c) this).f35307a;
            this.f35287c = dVar.f35308a;
            SlidePlayViewPager slidePlayViewPager = dVar.f35310c;
            this.f35286b = slidePlayViewPager;
            slidePlayViewPager.a(this.f35291g);
            this.f35287c.a(this.f35292h);
            e eVar = ((c) this).f35307a.f35311d;
            this.f35288d = eVar;
            if (eVar != null) {
                eVar.setOnRefreshListener(this.f35289e);
            }
            this.f35286b.a(this.f35290f);
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35286b.b(this.f35291g);
            this.f35287c.b(this.f35292h);
            this.f35286b.removeCallbacks(this.f35293i);
            this.f35287c.b();
        }
    }
}
