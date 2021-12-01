package com.kwad.sdk.reward.presenter.a.kwai;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.compliance.widget.ComplianceTextView;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.page.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.reward.a.f;
import com.kwad.sdk.reward.g;
/* loaded from: classes2.dex */
public class a extends g implements c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FrameLayout f59050b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.core.page.c f59051c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f59052d;

    /* renamed from: e  reason: collision with root package name */
    public AdBaseFrameLayout f59053e;

    /* renamed from: f  reason: collision with root package name */
    public View f59054f;

    /* renamed from: g  reason: collision with root package name */
    public View f59055g;

    /* renamed from: h  reason: collision with root package name */
    public ComplianceTextView f59056h;

    /* renamed from: i  reason: collision with root package name */
    public volatile long f59057i;

    /* renamed from: j  reason: collision with root package name */
    public volatile boolean f59058j;

    /* renamed from: k  reason: collision with root package name */
    public final com.kwad.sdk.contentalliance.detail.video.d f59059k;
    public final f l;

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
        this.f59057i = 0L;
        this.f59058j = false;
        this.f59059k = new e(this) { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                    super.a(j2, j3);
                    this.a.f59057i = j3;
                    this.a.f59058j = j2 - j3 < 800;
                }
            }
        };
        this.l = new f(this) { // from class: com.kwad.sdk.reward.presenter.a.kwai.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.f59050b == null || this.a.f59051c == null || !this.a.f59051c.d()) {
                    return;
                }
                this.a.f59056h.setVisibility(8);
                this.a.f59050b.setVisibility(0);
                this.a.f59051c.e();
            }
        };
    }

    @Override // com.kwad.sdk.reward.g, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.f59052d = ((g) this).a.f58874g;
            if (this.f59051c == null) {
                com.kwad.sdk.core.page.c cVar = new com.kwad.sdk.core.page.c(q(), this.f59052d, 4, false);
                this.f59051c = cVar;
                cVar.a(this);
                this.f59051c.a(new c.C2023c().b(false).a(true).a("").b(com.kwad.sdk.core.response.a.b.i(this.f59052d)).a());
                this.f59050b.addView(this.f59051c.a());
                this.f59054f = this.f59051c.b();
                this.f59055g = this.f59051c.c();
            }
            this.f59057i = 0L;
            this.f59058j = false;
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            this.f59053e = aVar.f58877j;
            aVar.a(this.l);
            ((g) this).a.f58878k.a(this.f59059k);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            ((g) this).a.b(this.l);
            ((g) this).a.f58878k.b(this.f59059k);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c_();
            this.f59050b = (FrameLayout) a(R.id.ksad_interactive_landing_page_container);
            this.f59056h = (ComplianceTextView) a(R.id.ksad_compliance_view);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d_();
            com.kwad.sdk.core.page.c cVar = this.f59051c;
            if (cVar != null) {
                cVar.g();
            }
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onBackBtnClicked(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            com.kwad.sdk.reward.a aVar = ((g) this).a;
            if (aVar.f58869b != null) {
                long p = com.kwad.sdk.core.response.a.a.p(com.kwad.sdk.core.response.a.d.j(aVar.f58874g));
                boolean z = true;
                if (p >= 0 && !this.f59058j && this.f59057i < p) {
                    z = false;
                }
                if (z) {
                    ((g) this).a.f58869b.e();
                }
            }
            ((g) this).a.f58869b.a(false);
            h();
        }
    }

    @Override // com.kwad.sdk.core.page.c.a
    public void onCloseBtnClicked(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
        }
    }
}
