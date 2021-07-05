package com.kwad.sdk.reward.b.b.b;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.e;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f38925b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f38926c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f38927d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f38928e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f38929f;

    /* renamed from: g  reason: collision with root package name */
    public long f38930g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38931h;

    /* renamed from: i  reason: collision with root package name */
    public Activity f38932i;
    public com.kwad.sdk.contentalliance.detail.video.e j;

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
        this.j = new f(this) { // from class: com.kwad.sdk.reward.b.b.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38933a;

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
                this.f38933a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f38933a.f38931h = true;
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f38933a.f38930g = j2;
                    long m = com.kwad.sdk.core.response.b.a.m(this.f38933a.f38929f);
                    if (com.kwad.sdk.core.response.b.a.l(this.f38933a.f38929f)) {
                        if (j2 < 5000) {
                            return;
                        }
                    } else if (m <= 0 || j <= m || j2 <= m) {
                        return;
                    }
                    this.f38933a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(65539, this, f2) == null) && this.f38925b.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38925b.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f38925b.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(AdIconUtil.BAIDU_LOGO_ID, this, f2) == null) && this.f38926c.getVisibility() == 0) {
            int a2 = ao.a(o(), 40.0f);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f38926c.getLayoutParams();
            layoutParams.rightMargin = (int) (a2 * f2);
            this.f38926c.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.f38927d.getVisibility() == 0) {
            return;
        }
        this.f38927d.setAlpha(0.0f);
        this.f38927d.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.reward.b.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f38934a;

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
                this.f38934a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.f38934a.f38927d.setAlpha(floatValue);
                    this.f38934a.a(floatValue);
                    this.f38934a.b(floatValue);
                }
            }
        });
        ofFloat.start();
        this.f38927d.setOnClickListener(this);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            boolean a2 = com.kwad.sdk.core.config.c.a(this.f38929f);
            if (com.kwad.sdk.core.response.b.a.l(this.f38929f)) {
                g();
            } else if (a2) {
                h();
            } else if (this.f38931h || this.f38930g >= com.kwad.sdk.core.response.b.a.m(this.f38929f)) {
                com.kwad.sdk.core.report.b.a(this.f38928e, this.f38929f.adBaseInfo.skipSecond, (int) (this.f38930g / 1000));
                q();
                p();
            }
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            long b2 = com.kwad.sdk.core.response.b.a.b(this.f38929f) * 1000;
            AdInfo adInfo = this.f38929f;
            int i2 = adInfo.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i2 > 0 && !com.kwad.sdk.core.response.b.a.l(adInfo) && b2 > i2) {
                str = "观看视频" + i2 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(this.f38932i, str, new e.a(this) { // from class: com.kwad.sdk.reward.b.b.b.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f38935a;

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
                    this.f38935a = this;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f38935a).f39062a.f38819i.f();
                        com.kwad.sdk.core.report.b.j(this.f38935a.f38928e, ((com.kwad.sdk.reward.d) this.f38935a).f39062a.f38814d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.f38935a.p();
                        com.kwad.sdk.core.report.b.a(this.f38935a.f38928e, 5, (int) (this.f38935a.f38930g / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f38935a).f39062a.f38819i.e();
                        com.kwad.sdk.core.report.b.k(this.f38935a.f38928e, ((com.kwad.sdk.reward.d) this.f38935a).f39062a.f38814d);
                    }
                }
            });
        }
    }

    private void h() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f39062a.f38817g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.g();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            ((com.kwad.sdk.reward.d) this).f39062a.f38812b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f39062a.f38816f;
            this.f38928e = adTemplate;
            this.f38929f = com.kwad.sdk.core.response.b.c.j(adTemplate);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f39062a;
            this.f38932i = aVar.f38817g;
            aVar.f38819i.a(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.b(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f38926c = (ViewGroup) b(R.id.ksad_reward_container_new);
            this.f38925b = (TextView) b(R.id.ksad_detail_call_btn);
            this.f38927d = (ImageView) b(R.id.ksad_detail_close_btn);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f38927d) {
            f();
        }
    }
}
