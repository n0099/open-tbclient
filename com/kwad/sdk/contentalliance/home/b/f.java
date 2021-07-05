package com.kwad.sdk.contentalliance.home.b;

import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.contentalliance.home.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public KSPageLoadingView f35122b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f35123c;

    /* renamed from: d  reason: collision with root package name */
    public SlidePlayViewPager f35124d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35125e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35126f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f35127g;

    /* renamed from: h  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f35128h;

    /* renamed from: i  reason: collision with root package name */
    public SlidePlayTouchViewPager.a f35129i;
    public com.kwad.sdk.contentalliance.home.a.d j;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public f() {
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
        this.f35127g = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.home.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35130a;

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
                this.f35130a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35130a.f35123c == null) {
                    return;
                }
                this.f35130a.f35123c.a(0);
                this.f35130a.e();
            }
        };
        this.f35128h = new ViewPager.SimpleOnPageChangeListener(this) { // from class: com.kwad.sdk.contentalliance.home.b.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35131a;

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
                this.f35131a = this;
            }

            @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                    this.f35131a.f35125e = false;
                }
            }
        };
        this.f35129i = new SlidePlayTouchViewPager.a(this) { // from class: com.kwad.sdk.contentalliance.home.b.f.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35132a;

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
                this.f35132a = this;
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
                    this.f35132a.f35125e = true;
                }
            }
        };
        this.j = new com.kwad.sdk.contentalliance.home.a.d(this) { // from class: com.kwad.sdk.contentalliance.home.b.f.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f35133a;

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
                this.f35133a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    this.f35133a.f35122b.a();
                    if (this.f35133a.f35124d.j()) {
                        if (com.kwad.sdk.core.network.f.f36364g.k == i4) {
                            this.f35133a.f35122b.c();
                        } else if (!v.a(this.f35133a.f35122b.getContext())) {
                            this.f35133a.f35122b.a(this.f35133a.f35126f.e());
                        } else if (com.kwad.sdk.core.network.f.j.k == i4) {
                            this.f35133a.f35122b.d();
                        } else {
                            this.f35133a.f35122b.b(this.f35133a.f35126f.e());
                        }
                    } else if (this.f35133a.f35125e) {
                        if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                            p.a(this.f35133a.o());
                        } else if (com.kwad.sdk.core.network.f.f36364g.k != i4) {
                            p.b(this.f35133a.o());
                        } else if (com.kwad.sdk.core.config.c.X()) {
                            p.c(this.f35133a.o());
                        }
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4)}) == null) {
                    this.f35133a.f35122b.a();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:
                if (r4.f35133a.f35125e != false) goto L20;
             */
            @Override // com.kwad.sdk.contentalliance.home.a.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void a(boolean z, boolean z2, int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 || i4 == 3) {
                                this.f35133a.f35122b.e();
                                return;
                            } else if (i4 != 4) {
                                return;
                            }
                        }
                        this.f35133a.f35122b.a();
                        return;
                    }
                    this.f35133a.f35122b.b();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            for (a aVar : ((com.kwad.sdk.contentalliance.home.e) this).f35218a.p) {
                aVar.a();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a;
            com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f35220b;
            this.f35123c = iVar;
            this.f35126f = fVar.f35224f.f35240a;
            iVar.a(this.j);
            this.f35124d.a(this.f35129i);
            this.f35124d.a(this.f35128h);
            this.f35122b.setRetryClickListener(this.f35127g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35125e = false;
            this.f35123c.b(this.j);
            this.f35122b.setRetryClickListener(null);
            this.f35124d.b(this.f35129i);
            this.f35124d.b(this.f35128h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35124d = (SlidePlayViewPager) b(R.id.ksad_slide_play_view_pager);
            this.f35122b = (KSPageLoadingView) b(R.id.ksad_page_loading);
        }
    }
}
