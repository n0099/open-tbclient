package com.kwad.sdk.contentalliance.profile.tabvideo.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.contentalliance.widget.KSProfilePageLoadingView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.recycler.c;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.lib.a.a.a<AdTemplate, b<?, AdTemplate>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f35382a;

    /* renamed from: c  reason: collision with root package name */
    public c<AdTemplate, ?> f35383c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f35384d;

    /* renamed from: e  reason: collision with root package name */
    public KSProfilePageLoadingView f35385e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f35386f;

    /* renamed from: g  reason: collision with root package name */
    public KSPageLoadingView.a f35387g;

    /* renamed from: h  reason: collision with root package name */
    public f f35388h;

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
        this.f35387g = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35389a;

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
                this.f35389a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f35389a.f35384d == null) {
                    return;
                }
                this.f35389a.f35384d.k();
            }
        };
        this.f35388h = new g(this) { // from class: com.kwad.sdk.contentalliance.profile.tabvideo.b.a.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35390a;

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
                this.f35390a = this;
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    this.f35390a.f35385e.a();
                    if (z) {
                        if (this.f35390a.f35383c.i()) {
                            if (v.a(this.f35390a.f35385e.getContext())) {
                                this.f35390a.f35385e.d();
                            } else {
                                this.f35390a.f35385e.c();
                            }
                        }
                    } else if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                        p.a(this.f35390a.o());
                    } else {
                        p.b(this.f35390a.o());
                    }
                    this.f35390a.f35386f.a(this.f35390a.f35384d.j());
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    if (!z) {
                        this.f35390a.f35386f.a();
                    } else if (this.f35390a.f35383c.i()) {
                        this.f35390a.f35385e.b();
                    }
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    this.f35390a.f35385e.a();
                    if (z) {
                        if (this.f35390a.f35383c.i()) {
                            this.f35390a.f35385e.d();
                        } else if (!this.f35390a.f35382a.d(this.f35390a.f35386f)) {
                            this.f35390a.f35382a.c(this.f35390a.f35386f);
                        }
                    }
                    this.f35390a.f35386f.a(this.f35390a.f35384d.j());
                }
            }
        };
    }

    /* JADX DEBUG: Type inference failed for r0v3. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f38465b;
            com.kwad.sdk.lib.b.c cVar = callercontext.f38469g;
            this.f35384d = cVar;
            this.f35382a = callercontext.f38471i;
            this.f35383c = callercontext.f38470h;
            cVar.a(this.f35388h);
            this.f35385e.setRetryClickListener(this.f35387g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f35384d.b(this.f35388h);
            this.f35385e.setRetryClickListener(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f35385e = (KSProfilePageLoadingView) b(R.id.ksad_page_loading);
            this.f35386f = new com.kwad.sdk.contentalliance.widget.d(o(), false);
        }
    }
}
