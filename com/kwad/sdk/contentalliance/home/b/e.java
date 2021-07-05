package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class e extends com.kwad.sdk.contentalliance.home.e implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f35116b;

    /* renamed from: c  reason: collision with root package name */
    public SceneImpl f35117c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35118d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35119e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.i.c f35120f;

    public e() {
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
        this.f35120f = new com.kwad.sdk.core.i.d(this) { // from class: com.kwad.sdk.contentalliance.home.b.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f35121a;

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
                this.f35121a = this;
            }

            @Override // com.kwad.sdk.core.i.d, com.kwad.sdk.core.i.c
            public void c_() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35121a.f35119e) {
                    return;
                }
                this.f35121a.f35119e = true;
                this.f35121a.f();
                this.f35121a.h();
            }
        };
    }

    private void e() {
        Activity m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) && (m = m()) != null && com.kwad.sdk.utils.d.a(m)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f35116b.getLayoutParams();
            int i2 = marginLayoutParams.topMargin;
            marginLayoutParams.topMargin = i2 + i2;
            this.f35116b.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.f35116b.c()) {
            return;
        }
        this.f35116b.b();
    }

    private void g() {
        com.kwad.sdk.plugin.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || (dVar = (com.kwad.sdk.plugin.d) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.d.class)) == null) {
            return;
        }
        dVar.a(o(), ((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35223e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            com.kwad.sdk.core.report.e.e(this.f35117c);
        }
    }

    private void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            com.kwad.sdk.core.report.e.f(this.f35117c);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a;
            this.f35117c = fVar.f35223e;
            com.kwad.sdk.core.i.a aVar = fVar.f35224f.f35240a;
            this.f35118d = aVar;
            if (aVar != null) {
                aVar.a(this.f35120f);
            }
            this.f35116b.setVisibility(0);
            this.f35116b.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35119e = false;
            this.f35116b.d();
            com.kwad.sdk.core.i.a aVar = this.f35118d;
            if (aVar != null) {
                aVar.b(this.f35120f);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            LottieAnimationView lottieAnimationView = (LottieAnimationView) b(R.id.ksad_live_entry_icon);
            this.f35116b = lottieAnimationView;
            lottieAnimationView.setAnimation(R.raw.ksad_live_home_entry_icon);
            e();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || ao.a()) {
            return;
        }
        g();
        p();
    }
}
