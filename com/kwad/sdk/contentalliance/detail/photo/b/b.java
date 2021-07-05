package com.kwad.sdk.contentalliance.detail.photo.b;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.i.c;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.am;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f34634b;

    /* renamed from: c  reason: collision with root package name */
    public ViewStub f34635c;

    /* renamed from: d  reason: collision with root package name */
    public View f34636d;

    /* renamed from: e  reason: collision with root package name */
    public LottieAnimationView f34637e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.b f34638f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f34639g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f34640h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34641i;
    public boolean j;
    public ValueAnimator k;
    public ValueAnimator l;
    public final com.kwad.sdk.contentalliance.a.a m;
    public final e n;
    public final c o;

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
                return;
            }
        }
        this.f34640h = false;
        this.f34641i = false;
        this.j = false;
        this.m = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34642a;

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
                this.f34642a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.f34642a.f34634b.getCurrentItem() != this.f34642a.f34634b.getPreItem()) {
                        ae.d(this.f34642a.o());
                        this.f34642a.e();
                    }
                }
            }
        };
        this.n = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34643a;

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
                this.f34643a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    super.a(j, j2);
                    this.f34643a.a(j2);
                }
            }
        };
        this.o = new c(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34644a;

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
                this.f34644a = this;
            }

            @Override // com.kwad.sdk.core.i.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34644a.f34640h = false;
                }
            }

            @Override // com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34644a.f34640h = true;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            if (!ae.c(o())) {
                e();
            } else if (!((com.kwad.sdk.contentalliance.detail.b) this).f34553a.n && this.f34640h && j >= com.kwad.sdk.core.config.c.ai() && !this.f34641i) {
                this.f34641i = true;
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.n = true;
                if (this.f34635c.getParent() != null) {
                    this.f34636d = this.f34635c.inflate();
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_guider_up_anim);
                    this.f34637e = lottieAnimationView;
                    lottieAnimationView.setAnimation(R.raw.ksad_detail_guider_slide_up_new);
                    this.f34637e.setRepeatMode(1);
                    this.f34637e.setRepeatCount(-1);
                }
                this.f34637e.b();
                ValueAnimator a2 = am.a(this.f34636d, true);
                this.k = a2;
                a2.start();
                this.f34634b.a(false, 2);
                this.f34636d.setClickable(true);
                this.f34636d.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.b.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ b f34645a;

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
                        this.f34645a = this;
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        InterceptResult invokeLL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                            this.f34645a.g();
                            return false;
                        }
                        return invokeLL.booleanValue;
                    }
                });
                com.kwad.sdk.core.report.e.r(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.f34641i = false;
            this.j = false;
            com.kwad.sdk.contentalliance.detail.video.b bVar = this.f34638f;
            if (bVar != null) {
                bVar.b(this.n);
            }
            com.kwad.sdk.core.i.a aVar = this.f34639g;
            if (aVar != null) {
                aVar.b(this.o);
                this.f34640h = false;
            }
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.remove(this.m);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            ValueAnimator valueAnimator = this.k;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator valueAnimator2 = this.l;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65546, this) == null) || this.j) {
            return;
        }
        this.j = true;
        ae.d(o());
        ValueAnimator a2 = am.a(this.f34636d, false);
        this.l = a2;
        a2.start();
        SlidePlayViewPager slidePlayViewPager = this.f34634b;
        if (slidePlayViewPager != null) {
            slidePlayViewPager.a(true, 2);
        }
        e();
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        com.kwad.sdk.contentalliance.detail.c cVar;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (ae.c(o()) && (hVar = (cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a).f34574a) != null) {
                SlidePlayViewPager slidePlayViewPager = cVar.l;
                this.f34634b = slidePlayViewPager;
                com.kwad.sdk.core.i.a aVar = hVar.f35240a;
                this.f34639g = aVar;
                com.kwad.sdk.contentalliance.detail.video.b bVar = cVar.m;
                this.f34638f = bVar;
                if (bVar == null || slidePlayViewPager == null || aVar == null) {
                    return;
                }
                bVar.a(this.n);
                this.f34639g.a(this.o);
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34575b.add(this.m);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            e();
            f();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34635c = (ViewStub) b(R.id.ksad_slide_up_guide_view_stub);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            e();
            f();
        }
    }
}
