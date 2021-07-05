package com.kwad.sdk.contentalliance.detail.a.b;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.b;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f34381b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f34382c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34383d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f34384e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34385f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f34386g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f34387h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f34388i;
    public e j;

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
        this.f34385f = false;
        this.f34386g = new com.kwad.sdk.contentalliance.a.b(this) { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34389a;

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
                this.f34389a = this;
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void j() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.j();
                    if (com.ksad.download.d.b.a(this.f34389a.o()) || ((b) this.f34389a).f34553a.m.a()) {
                        this.f34389a.f34382c.setVisibility(8);
                    } else {
                        this.f34389a.g();
                    }
                    if (((b) this.f34389a).f34553a.m.b() && !this.f34389a.f34385f) {
                        this.f34389a.h();
                    }
                    this.f34389a.f34385f = true;
                }
            }

            @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
            public void k() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    super.k();
                    this.f34389a.f();
                    this.f34389a.f34385f = false;
                }
            }
        };
        Runnable runnable = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34391a;

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
                this.f34391a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34391a.f();
                }
            }
        };
        this.f34387h = runnable;
        this.f34388i = new aq(runnable);
        this.j = new f(this) { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f34392a;

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
                this.f34392a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.a();
                    this.f34392a.f();
                    com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayCompleted");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayError");
                    this.f34392a.f();
                    p.a(this.f34392a.o(), "网络错误");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    super.b();
                    com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayStart");
                    this.f34392a.f34384e.removeCallbacks(this.f34392a.f34388i);
                    this.f34392a.f34382c.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    super.d();
                    this.f34392a.f34384e.removeCallbacks(this.f34392a.f34388i);
                    com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlaying");
                    this.f34392a.f();
                    this.f34392a.f34382c.setVisibility(8);
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    super.e();
                    com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPreparing");
                    this.f34392a.h();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    super.f();
                    com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayBufferingPaused");
                    this.f34392a.e();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    super.g();
                    com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onVideoPlayBufferingPlaying");
                    this.f34392a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            int i2 = 0;
            if (!com.ksad.download.d.b.a(o())) {
                f();
                viewGroup = this.f34382c;
            } else if (this.f34381b.getVisibility() == 0 && this.f34381b.c()) {
                return;
            } else {
                this.f34381b.setVisibility(0);
                if (!this.f34381b.c()) {
                    this.f34381b.b();
                }
                viewGroup = this.f34382c;
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        LottieAnimationView lottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (lottieAnimationView = this.f34381b) == null) {
            return;
        }
        if (lottieAnimationView.c()) {
            this.f34381b.d();
        }
        this.f34381b.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f34381b.d();
            this.f34381b.setVisibility(8);
            p.a(o(), "网络错误");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            if (com.ksad.download.d.b.a(o())) {
                e();
            } else {
                f();
            }
            this.f34384e.removeCallbacks(this.f34388i);
            this.f34384e.postDelayed(this.f34388i, 10000L);
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.core.d.a.a("DetailLoadingPresenter", "onBind");
            this.f34383d.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.contentalliance.detail.a.b.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34390a;

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
                    this.f34390a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        if (!com.ksad.download.d.b.a(this.f34390a.o())) {
                            p.a(this.f34390a.o(), "网络错误");
                        } else if (((b) this.f34390a).f34553a.m.a()) {
                        } else {
                            ((b) this.f34390a).f34553a.m.f();
                        }
                    }
                }
            });
            ((b) this).f34553a.f34575b.add(this.f34386g);
            ((b) this).f34553a.m.a(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            Handler handler = this.f34384e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            ((b) this).f34553a.f34575b.remove(this.f34386g);
            com.kwad.sdk.contentalliance.detail.video.b bVar = ((b) this).f34553a.m;
            if (bVar != null) {
                bVar.b(this.j);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34384e = new Handler();
            this.f34382c = (ViewGroup) b(R.id.ksad_error_container);
            this.f34383d = (TextView) b(R.id.ksad_retry_btn);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_bottom_loading_animation_view);
            int i2 = R.raw.ksad_detail_loading_amin_bottom;
            ((LottieAnimationView) b(R.id.ksad_center_loading_animation_view)).setVisibility(8);
            lottieAnimationView.setVisibility(0);
            this.f34381b = lottieAnimationView;
            lottieAnimationView.setRepeatMode(1);
            this.f34381b.setRepeatCount(-1);
            this.f34381b.setAnimation(i2);
            this.f34381b.setRepeatMode(1);
            this.f34381b.setRepeatCount(-1);
        }
    }
}
