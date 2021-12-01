package com.kwad.sdk.reward.presenter.platdetail.kwai;

import android.animation.ValueAnimator;
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
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
import com.kwad.sdk.reward.k;
/* loaded from: classes2.dex */
public class c extends g implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f59265b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f59266c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59267d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f59268e;

    /* renamed from: f  reason: collision with root package name */
    public AdInfo f59269f;

    /* renamed from: g  reason: collision with root package name */
    public long f59270g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59271h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f59272i;

    /* renamed from: j  reason: collision with root package name */
    public View f59273j;

    /* renamed from: k  reason: collision with root package name */
    public long f59274k;
    public final f l;
    public final com.kwad.sdk.contentalliance.detail.video.d m;
    public final com.kwad.sdk.reward.a.e n;

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
        this.f59272i = false;
        this.f59273j = null;
        this.f59274k = -1L;
        this.l = new f(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.f
            public void a() {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.f59271h) {
                    k.a(((g) this.a).a);
                }
            }
        };
        this.m = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.a.f59270g = j3;
                    this.a.f59271h = j2 - j3 < 800;
                    if (this.a.f59274k < 0 || j3 <= Math.min(Math.min(this.a.f59274k, com.kwad.sdk.core.response.a.a.p(this.a.f59269f)), j2)) {
                        return;
                    }
                    this.a.e();
                }
            }
        };
        this.n = new com.kwad.sdk.reward.a.e(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.reward.a.e
            public void a(long j2, long j3, int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i4)}) == null) {
                    this.a.f59272i = true;
                    this.a.e();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.f59273j.getVisibility() == 0) {
            return;
        }
        this.f59273j.setAlpha(0.0f);
        this.f59273j.setVisibility(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.kwad.sdk.reward.presenter.platdetail.kwai.c.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                this.a = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    this.a.f59273j.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        ofFloat.start();
        this.f59273j.setOnClickListener(this);
    }

    private void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f59268e, 69, (int) (this.f59274k / 1000), (int) (this.f59270g / 1000));
            boolean z = !((g) this).a.v && com.kwad.sdk.core.config.b.R();
            if (f() || g() || this.f59270g < com.kwad.sdk.core.response.a.a.p(this.f59269f)) {
                if (z) {
                    com.kwad.sdk.reward.widget.a.a(((g) this).a);
                    return;
                }
                com.kwad.sdk.core.report.a.a(((g) this).a.f58874g, (int) (this.f59274k / 1000), (int) (this.f59270g / 1000));
            } else if (!this.f59271h && this.f59270g < com.kwad.sdk.core.response.a.a.p(this.f59269f)) {
                if (this.f59272i) {
                    h();
                    return;
                }
                return;
            } else {
                com.kwad.sdk.core.report.a.a(((g) this).a.f58874g, (int) (this.f59274k / 1000), (int) (this.f59270g / 1000));
                s();
            }
            r();
            k.a(((g) this).a);
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            ((g) this).a.u = true;
            ((g) this).a.f58878k.a(!com.kwad.sdk.core.response.a.a.aG(this.f59269f));
        }
    }

    private void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            ((g) this).a.f58869b.e();
        }
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((g) this).a.f58874g;
            this.f59268e = adTemplate;
            this.f59269f = com.kwad.sdk.core.response.a.d.j(adTemplate);
            ((g) this).a.f58878k.a(this.m);
            ((g) this).a.q.add(this.n);
            ((g) this).a.a(this.l);
            this.f59274k = com.kwad.sdk.core.response.a.a.o(this.f59269f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((g) this).a.f58878k.b(this.m);
            ((g) this).a.q.remove(this.n);
            ((g) this).a.b(this.l);
            this.f59273j.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        ImageView imageView;
        int i2;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59265b = (ViewGroup) a(R.id.ksad_reward_container_new);
            this.f59266c = (ImageView) a(R.id.ksad_detail_close_btn);
            this.f59267d = (TextView) a(R.id.ksad_top_toolbar_close_tip);
            if (TextUtils.isEmpty(com.kwad.sdk.core.config.b.V())) {
                if (com.kwad.sdk.core.config.b.S() == 0) {
                    imageView = this.f59266c;
                    i2 = R.drawable.ksad_page_close;
                } else {
                    imageView = this.f59266c;
                    i2 = R.drawable.ksad_video_skip_icon;
                }
                imageView.setImageResource(i2);
                this.f59267d.setVisibility(8);
                view = this.f59266c;
            } else {
                this.f59267d.setText(com.kwad.sdk.core.config.b.V());
                this.f59266c.setVisibility(8);
                view = this.f59267d;
            }
            this.f59273j = view;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f59273j) {
            i();
        }
    }
}
