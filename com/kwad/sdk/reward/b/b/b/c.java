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
/* loaded from: classes6.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f36002b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f36003c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f36004d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f36005e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f36006f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f36007g;

    /* renamed from: h  reason: collision with root package name */
    public long f36008h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36009i;
    public Activity j;
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
            public final /* synthetic */ c f36010a;

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
                this.f36010a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f36010a.f36008h = j2;
                    long l = com.kwad.sdk.core.response.b.a.l(this.f36010a.f36007g);
                    if (com.kwad.sdk.core.response.b.a.k(this.f36010a.f36007g)) {
                        if (j2 < com.kwad.sdk.core.config.c.Q()) {
                            return;
                        }
                    } else if (l <= 0 || j <= l || j2 <= l) {
                        return;
                    }
                    this.f36010a.e();
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f36010a.f36009i = true;
                }
            }
        };
        this.n = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.reward.b.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f36011a;

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
                this.f36011a = this;
            }

            @Override // com.kwad.sdk.reward.a.d
            public void a(long j, long j2, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4)}) == null) {
                    this.f36011a.k = true;
                    this.f36011a.e();
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
            public final /* synthetic */ c f36012a;

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
                this.f36012a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.f36012a.l.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.l.setOnClickListener(this);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            boolean a2 = com.kwad.sdk.core.config.c.a(this.f36007g, m());
            if (com.kwad.sdk.core.response.b.a.k(this.f36007g)) {
                n();
                return;
            }
            if (!a2 || !((com.kwad.sdk.reward.d) this).f36214a.u) {
                if (this.f36009i || this.f36008h >= com.kwad.sdk.core.response.b.a.l(this.f36007g)) {
                    com.kwad.sdk.core.report.a.a(this.f36006f, this.f36007g.adBaseInfo.skipSecond, (int) (this.f36008h / 1000));
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
            long b2 = com.kwad.sdk.core.response.b.a.b(this.f36007g) * 1000;
            AdInfo adInfo = this.f36007g;
            int i2 = adInfo.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i2 > 0 && !com.kwad.sdk.core.response.b.a.k(adInfo) && b2 > i2) {
                str = "观看视频" + i2 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(this.j, str, new e.a(this) { // from class: com.kwad.sdk.reward.b.b.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f36013a;

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
                    this.f36013a = this;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f36013a).f36214a.f35891i.g();
                        com.kwad.sdk.core.report.a.j(this.f36013a.f36006f, ((com.kwad.sdk.reward.d) this.f36013a).f36214a.f35886d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (com.kwad.sdk.core.config.c.a(this.f36013a.f36007g, this.f36013a.m()) && ((com.kwad.sdk.reward.d) this.f36013a).f36214a.u) {
                            this.f36013a.o();
                        } else {
                            this.f36013a.p();
                        }
                        com.kwad.sdk.core.report.a.a(this.f36013a.f36006f, (int) (com.kwad.sdk.core.config.c.Q() / 1000), (int) (this.f36013a.f36008h / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f36013a).f36214a.f35891i.f();
                        com.kwad.sdk.core.report.a.k(this.f36013a.f36006f, ((com.kwad.sdk.reward.d) this.f36013a).f36214a.f35886d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f36214a.f35889g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            ((com.kwad.sdk.reward.d) this).f36214a.f35891i.h();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            ((com.kwad.sdk.reward.d) this).f36214a.f35884b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f36214a.f35888f;
            this.f36006f = adTemplate;
            this.f36007g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36214a;
            this.j = aVar.f35889g;
            aVar.f35891i.a(this.m);
            ((com.kwad.sdk.reward.d) this).f36214a.p.add(this.n);
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
            this.f36003c = (ViewGroup) a(R.id.ksad_reward_container_new);
            this.f36002b = (TextView) a(R.id.ksad_detail_call_btn);
            this.f36004d = (ImageView) a(R.id.ksad_detail_close_btn);
            this.f36005e = (TextView) a(R.id.ksad_top_toolbar_close_tip);
            if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.T())) {
                if (com.kwad.sdk.core.config.c.R() == 0) {
                    imageView = this.f36004d;
                    i2 = R.drawable.ksad_page_close;
                } else {
                    imageView = this.f36004d;
                    i2 = R.drawable.ksad_video_skip_icon;
                }
                imageView.setImageResource(i2);
                this.f36005e.setVisibility(8);
                view = this.f36004d;
            } else {
                this.f36005e.setText(com.kwad.sdk.core.config.c.T());
                this.f36004d.setVisibility(8);
                view = this.f36005e;
            }
            this.l = view;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f36214a.f35891i.b(this.m);
            ((com.kwad.sdk.reward.d) this).f36214a.p.remove(this.n);
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
