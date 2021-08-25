package com.kwad.sdk.reward.b.b.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.e;
/* loaded from: classes10.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f73192b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f73193c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f73194d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f73195e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f73196f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f73197g;

    /* renamed from: h  reason: collision with root package name */
    public long f73198h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73199i;

    /* renamed from: j  reason: collision with root package name */
    public Activity f73200j;
    public boolean k;
    public View l;
    public com.kwad.sdk.contentalliance.detail.video.d m;
    public com.kwad.sdk.reward.a.d n;

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
                return;
            }
        }
        this.k = false;
        this.l = null;
        this.m = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.b.b.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73201a;

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
                this.f73201a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.f73201a.f73198h = j3;
                    long l = com.kwad.sdk.core.response.b.a.l(this.f73201a.f73197g);
                    if (com.kwad.sdk.core.response.b.a.k(this.f73201a.f73197g)) {
                        if (j3 < com.kwad.sdk.core.config.c.Q()) {
                            return;
                        }
                    } else if (l <= 0 || j2 <= l || j3 <= l) {
                        return;
                    }
                    this.f73201a.e();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f73201a.f73199i = true;
                }
            }
        };
        this.n = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.reward.b.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73202a;

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
                this.f73202a = this;
            }

            @Override // com.kwad.sdk.reward.a.d
            public void a(long j2, long j3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4)}) == null) {
                    this.f73202a.k = true;
                    this.f73202a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65545, this) == null) || this.l.getVisibility() == 0) {
            return;
        }
        this.l.setAlpha(0.0f);
        this.l.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.reward.b.b.b.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f73203a;

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
                this.f73203a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.f73203a.l.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.l.setOnClickListener(this);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            boolean a2 = com.kwad.sdk.core.config.c.a(this.f73197g, m());
            if (com.kwad.sdk.core.response.b.a.k(this.f73197g)) {
                n();
                return;
            }
            if (!a2 || !((com.kwad.sdk.reward.d) this).f73410a.u) {
                if (this.f73199i || this.f73198h >= com.kwad.sdk.core.response.b.a.l(this.f73197g)) {
                    com.kwad.sdk.core.report.a.a(this.f73196f, this.f73197g.adBaseInfo.skipSecond, (int) (this.f73198h / 1000));
                    q();
                    p();
                    return;
                } else if (!this.k) {
                    return;
                }
            }
            o();
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            long b2 = com.kwad.sdk.core.response.b.a.b(this.f73197g) * 1000;
            AdInfo adInfo = this.f73197g;
            int i2 = adInfo.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i2 > 0 && !com.kwad.sdk.core.response.b.a.k(adInfo) && b2 > i2) {
                str = "观看视频" + i2 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(this.f73200j, str, new e.a(this) { // from class: com.kwad.sdk.reward.b.b.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f73204a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73204a = this;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f73204a).f73410a.f73076i.g();
                        com.kwad.sdk.core.report.a.j(this.f73204a.f73196f, ((com.kwad.sdk.reward.d) this.f73204a).f73410a.f73071d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (com.kwad.sdk.core.config.c.a(this.f73204a.f73197g, this.f73204a.m()) && ((com.kwad.sdk.reward.d) this.f73204a).f73410a.u) {
                            this.f73204a.o();
                        } else {
                            this.f73204a.p();
                        }
                        com.kwad.sdk.core.report.a.a(this.f73204a.f73196f, (int) (com.kwad.sdk.core.config.c.Q() / 1000), (int) (this.f73204a.f73198h / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f73204a).f73410a.f73076i.f();
                        com.kwad.sdk.core.report.a.k(this.f73204a.f73196f, ((com.kwad.sdk.reward.d) this.f73204a).f73410a.f73071d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f73410a.f73074g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            ((com.kwad.sdk.reward.d) this).f73410a.f73076i.h();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            ((com.kwad.sdk.reward.d) this).f73410a.f73069b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f73410a.f73073f;
            this.f73196f = adTemplate;
            this.f73197g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f73410a;
            this.f73200j = aVar.f73074g;
            aVar.f73076i.a(this.m);
            ((com.kwad.sdk.reward.d) this).f73410a.p.add(this.n);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        ImageView imageView;
        int i2;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f73193c = (ViewGroup) a(R.id.ksad_reward_container_new);
            this.f73192b = (TextView) a(R.id.ksad_detail_call_btn);
            this.f73194d = (ImageView) a(R.id.ksad_detail_close_btn);
            this.f73195e = (TextView) a(R.id.ksad_top_toolbar_close_tip);
            if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.T())) {
                if (com.kwad.sdk.core.config.c.R() == 0) {
                    imageView = this.f73194d;
                    i2 = R.drawable.ksad_page_close;
                } else {
                    imageView = this.f73194d;
                    i2 = R.drawable.ksad_video_skip_icon;
                }
                imageView.setImageResource(i2);
                this.f73195e.setVisibility(8);
                view = this.f73194d;
            } else {
                this.f73195e.setText(com.kwad.sdk.core.config.c.T());
                this.f73194d.setVisibility(8);
                view = this.f73195e;
            }
            this.l = view;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f73410a.f73076i.b(this.m);
            ((com.kwad.sdk.reward.d) this).f73410a.p.remove(this.n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.l) {
            f();
        }
    }
}
