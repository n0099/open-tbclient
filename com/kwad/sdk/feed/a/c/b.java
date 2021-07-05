package com.kwad.sdk.feed.a.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.widget.KSPageLoadingView;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.lib.widget.recycler.d;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.feed.a.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public d f37388c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<AdTemplate, ?> f37389d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, AdTemplate> f37390e;

    /* renamed from: f  reason: collision with root package name */
    public KSPageLoadingView f37391f;

    /* renamed from: g  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.widget.d f37392g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f37393h;

    /* renamed from: i  reason: collision with root package name */
    public KSPageLoadingView.a f37394i;
    public f j;

    public b() {
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
        this.f37394i = new KSPageLoadingView.a(this) { // from class: com.kwad.sdk.feed.a.c.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f37395a;

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
                this.f37395a = this;
            }

            @Override // com.kwad.sdk.contentalliance.widget.KSPageLoadingView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f37395a.f37390e == null) {
                    return;
                }
                this.f37395a.f37390e.k();
            }
        };
        this.j = new g(this) { // from class: com.kwad.sdk.feed.a.c.b.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f37396a;

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
                this.f37396a = this;
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) {
                    this.f37396a.f37391f.a();
                    if (z) {
                        if (this.f37396a.f37389d.i()) {
                            if (com.kwad.sdk.core.network.f.f36364g.k == i4) {
                                this.f37396a.f37391f.c();
                            } else if (v.a(this.f37396a.f37391f.getContext())) {
                                this.f37396a.f37391f.b(this.f37396a.f37393h.e());
                            } else {
                                this.f37396a.f37391f.a(this.f37396a.f37393h.e());
                            }
                        }
                    } else if (com.kwad.sdk.core.network.f.f36358a.k == i4) {
                        p.a(this.f37396a.o());
                    } else if (com.kwad.sdk.core.network.f.f36364g.k != i4) {
                        p.b(this.f37396a.o());
                    }
                    this.f37396a.f37392g.a(this.f37396a.f37390e.j());
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    if (!z) {
                        this.f37396a.f37392g.a();
                    } else if (this.f37396a.f37389d.i()) {
                        this.f37396a.f37391f.b();
                    }
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                    this.f37396a.f37391f.a();
                    if (z) {
                        if (this.f37396a.f37389d.i()) {
                            this.f37396a.f37391f.b(this.f37396a.f37393h.e());
                        } else if (!this.f37396a.f37388c.d(this.f37396a.f37392g)) {
                            this.f37396a.f37388c.c(this.f37396a.f37392g);
                        }
                    }
                    this.f37396a.f37392g.a(this.f37396a.f37390e.j());
                }
            }
        };
    }

    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: com.kwad.sdk.lib.widget.recycler.c<MODEL, ?>, com.kwad.sdk.lib.widget.recycler.c<com.kwad.sdk.core.response.model.AdTemplate, ?> */
    @Override // com.kwad.sdk.feed.a.b.a, com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.feed.a.b.b bVar = ((com.kwad.sdk.feed.a.b.a) this).f37377a;
            this.f37393h = bVar.f37379b;
            com.kwad.sdk.lib.b.c cVar = bVar.f38469g;
            this.f37390e = cVar;
            this.f37389d = bVar.f38470h;
            this.f37388c = bVar.f38471i;
            cVar.a(this.j);
            this.f37391f.setRetryClickListener(this.f37394i);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f37390e.b(this.j);
            this.f37391f.setRetryClickListener(null);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f37391f = (KSPageLoadingView) b(R.id.ksad_page_loading);
            this.f37392g = new com.kwad.sdk.contentalliance.widget.d(o(), true);
        }
    }
}
