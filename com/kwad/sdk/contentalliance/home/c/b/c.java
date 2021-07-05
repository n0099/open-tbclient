package com.kwad.sdk.contentalliance.home.c.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class c extends com.kwad.sdk.contentalliance.home.c.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public SlidePlayViewPager f35190b;

    /* renamed from: c  reason: collision with root package name */
    public View f35191c;

    /* renamed from: d  reason: collision with root package name */
    public View f35192d;

    /* renamed from: e  reason: collision with root package name */
    public View f35193e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public View f35194f;

    /* renamed from: g  reason: collision with root package name */
    public int f35195g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.c.b f35196h;

    /* renamed from: i  reason: collision with root package name */
    public AdTemplate f35197i;
    public com.kwad.sdk.contentalliance.home.c.a j;

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
        this.j = new com.kwad.sdk.contentalliance.home.c.a(this) { // from class: com.kwad.sdk.contentalliance.home.c.b.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f35198a;

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
                this.f35198a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.c.a
            public void a(int i4, View view, boolean z) {
                View view2;
                int i5;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i4), view, Boolean.valueOf(z)}) == null) {
                    this.f35198a.f35194f = view;
                    if (this.f35198a.f35195g == i4) {
                        this.f35198a.f35193e.setSelected(!z);
                        view2 = this.f35198a.f35193e;
                        i5 = 0;
                    } else {
                        view2 = this.f35198a.f35193e;
                        i5 = 8;
                    }
                    view2.setVisibility(i5);
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.c.a
            public void a(int i4, AdTemplate adTemplate) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, adTemplate) == null) {
                    if (this.f35198a.f35195g == i4) {
                        this.f35198a.f35192d.setSelected(true);
                        com.kwad.sdk.contentalliance.detail.video.b c2 = this.f35198a.f35196h.c();
                        if (c2 != null) {
                            this.f35198a.f35193e.setSelected(!c2.a());
                            return;
                        }
                    } else {
                        this.f35198a.f35192d.setSelected(false);
                    }
                    this.f35198a.f35193e.setVisibility(8);
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            e.b((AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a).f38573i, 1);
        }
    }

    @Override // com.kwad.sdk.lib.widget.recycler.b.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.widget.recycler.b.b) this).f38574a;
            this.f35190b = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f35176a;
            this.f35194f = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f35177b;
            this.f35195g = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f38572h;
            AdTemplate adTemplate = (AdTemplate) ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f38573i;
            this.f35197i = adTemplate;
            com.kwad.sdk.contentalliance.home.c.b bVar = ((com.kwad.sdk.contentalliance.home.c.a.b) callercontext).f35178c;
            this.f35196h = bVar;
            if (adTemplate == bVar.a()) {
                this.f35192d.setSelected(true);
                com.kwad.sdk.contentalliance.detail.video.b c2 = this.f35196h.c();
                if (c2 != null) {
                    this.f35193e.setSelected(!c2.a());
                    this.f35193e.setVisibility(0);
                    this.f35196h.d().add(this.j);
                }
            } else {
                this.f35192d.setSelected(false);
            }
            this.f35193e.setVisibility(8);
            this.f35196h.d().add(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35196h.d().remove(this.j);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35191c = b(R.id.ksad_slide_profile_container);
            this.f35192d = b(R.id.ksad_slide_profile_selected);
            this.f35193e = b(R.id.ksad_slide_profile_video_play_btn);
            this.f35191c.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f35191c) {
            if (this.f35197i != this.f35196h.a()) {
                this.f35190b.a(this.f35197i);
            } else {
                View view2 = this.f35194f;
                if (view2 != null) {
                    view2.performClick();
                }
            }
            e();
        }
    }
}
