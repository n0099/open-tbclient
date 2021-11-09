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
/* loaded from: classes2.dex */
public class c extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f66129b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f66130c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f66131d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66132e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f66133f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f66134g;

    /* renamed from: h  reason: collision with root package name */
    public long f66135h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66136i;
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
            public final /* synthetic */ c f66137a;

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
                this.f66137a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f66137a.f66135h = j2;
                    this.f66137a.f66136i = j - j2 < 800;
                    long l = com.kwad.sdk.core.response.b.a.l(this.f66137a.f66134g);
                    if (com.kwad.sdk.core.response.b.a.k(this.f66137a.f66134g)) {
                        if (j2 < com.kwad.sdk.core.config.c.Q()) {
                            return;
                        }
                    } else if (l <= 0 || j <= l || j2 <= l) {
                        return;
                    }
                    this.f66137a.e();
                }
            }
        };
        this.n = new com.kwad.sdk.reward.a.d(this) { // from class: com.kwad.sdk.reward.b.b.b.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f66138a;

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
                this.f66138a = this;
            }

            @Override // com.kwad.sdk.reward.a.d
            public void a(long j, long j2, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i4)}) == null) {
                    this.f66138a.k = true;
                    this.f66138a.e();
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
            public final /* synthetic */ c f66139a;

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
                this.f66139a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.f66139a.l.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.l.setOnClickListener(this);
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            boolean a2 = com.kwad.sdk.core.config.c.a(this.f66134g, m());
            if (com.kwad.sdk.core.response.b.a.k(this.f66134g)) {
                n();
                return;
            }
            if (!a2 || !((com.kwad.sdk.reward.d) this).f66342a.u) {
                if (this.f66136i || this.f66135h >= com.kwad.sdk.core.response.b.a.l(this.f66134g)) {
                    com.kwad.sdk.core.report.a.a(this.f66133f, this.f66134g.adBaseInfo.skipSecond, (int) (this.f66135h / 1000));
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
            long b2 = com.kwad.sdk.core.response.b.a.b(this.f66134g) * 1000;
            AdInfo adInfo = this.f66134g;
            int i2 = adInfo.adBaseInfo.skipSecond;
            String str = "观看完整视频即可获取奖励";
            if (i2 > 0 && !com.kwad.sdk.core.response.b.a.k(adInfo) && b2 > i2) {
                str = "观看视频" + i2 + "s即可获取奖励";
            }
            com.kwad.sdk.reward.e.a(this.j, str, new e.a(this) { // from class: com.kwad.sdk.reward.b.b.b.c.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f66140a;

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
                    this.f66140a = this;
                }

                @Override // com.kwad.sdk.reward.e.a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66140a).f66342a.f66018i.g();
                        com.kwad.sdk.core.report.a.j(this.f66140a.f66133f, ((com.kwad.sdk.reward.d) this.f66140a).f66342a.f66013d);
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        if (com.kwad.sdk.core.config.c.a(this.f66140a.f66134g, this.f66140a.m()) && ((com.kwad.sdk.reward.d) this.f66140a).f66342a.u) {
                            this.f66140a.o();
                        } else {
                            this.f66140a.p();
                        }
                        com.kwad.sdk.core.report.a.a(this.f66140a.f66133f, (int) (com.kwad.sdk.core.config.c.Q() / 1000), (int) (this.f66140a.f66135h / 1000));
                    }
                }

                @Override // com.kwad.sdk.reward.e.a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        ((com.kwad.sdk.reward.d) this.f66140a).f66342a.f66018i.f();
                        com.kwad.sdk.core.report.a.k(this.f66140a.f66133f, ((com.kwad.sdk.reward.d) this.f66140a).f66342a.f66013d);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (activity = ((com.kwad.sdk.reward.d) this).f66342a.f66016g) == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66342a.f66018i.h();
        }
    }

    private void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            ((com.kwad.sdk.reward.d) this).f66342a.f66011b.e();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f66342a.f66015f;
            this.f66133f = adTemplate;
            this.f66134g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f66342a;
            this.j = aVar.f66016g;
            aVar.f66018i.a(this.m);
            ((com.kwad.sdk.reward.d) this).f66342a.p.add(this.n);
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
            this.f66130c = (ViewGroup) a(R.id.ksad_reward_container_new);
            this.f66129b = (TextView) a(R.id.ksad_detail_call_btn);
            this.f66131d = (ImageView) a(R.id.ksad_detail_close_btn);
            this.f66132e = (TextView) a(R.id.ksad_top_toolbar_close_tip);
            if (TextUtils.isEmpty(com.kwad.sdk.core.config.c.T())) {
                if (com.kwad.sdk.core.config.c.R() == 0) {
                    imageView = this.f66131d;
                    i2 = R.drawable.ksad_page_close;
                } else {
                    imageView = this.f66131d;
                    i2 = R.drawable.ksad_video_skip_icon;
                }
                imageView.setImageResource(i2);
                this.f66132e.setVisibility(8);
                view = this.f66131d;
            } else {
                this.f66132e.setText(com.kwad.sdk.core.config.c.T());
                this.f66131d.setVisibility(8);
                view = this.f66132e;
            }
            this.l = view;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.reward.d) this).f66342a.f66018i.b(this.m);
            ((com.kwad.sdk.reward.d) this).f66342a.p.remove(this.n);
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
