package com.kwad.sdk.lib.a.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.contentalliance.refreshview.RefreshLayout;
import com.kwad.sdk.lib.a.a.b;
import com.kwad.sdk.lib.b.f;
import com.kwad.sdk.lib.b.g;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class d<MODEL, CallerContext extends com.kwad.sdk.lib.a.a.b<?, MODEL>> extends com.kwad.sdk.lib.a.a.a<MODEL, CallerContext> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RefreshLayout f38486a;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.b.c<?, MODEL> f38487c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.recycler.c<MODEL, ?> f38488d;

    /* renamed from: e  reason: collision with root package name */
    public final RefreshLayout.b f38489e;

    /* renamed from: f  reason: collision with root package name */
    public f f38490f;

    public d() {
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
        this.f38489e = new RefreshLayout.b(this) { // from class: com.kwad.sdk.lib.a.b.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f38491a;

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
                this.f38491a = this;
            }

            @Override // com.kwad.sdk.contentalliance.refreshview.RefreshLayout.b
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (com.ksad.download.d.b.a(this.f38491a.o())) {
                        this.f38491a.f38487c.k();
                        return;
                    }
                    p.a(this.f38491a.o());
                    this.f38491a.f38486a.setRefreshing(false);
                }
            }
        };
        this.f38490f = new g(this) { // from class: com.kwad.sdk.lib.a.b.d.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f38492a;

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
                this.f38492a = this;
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, int i4, String str) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4), str}) == null) && z) {
                    this.f38492a.f38486a.setRefreshing(false);
                }
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void a(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || !z || this.f38492a.f38488d.i() || z2) {
                    return;
                }
                this.f38492a.f38486a.setRefreshing(true);
            }

            @Override // com.kwad.sdk.lib.b.g, com.kwad.sdk.lib.b.f
            public void b(boolean z, boolean z2) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
                    if (!this.f38492a.f38488d.i()) {
                        this.f38492a.f38486a.setEnabled(true);
                    }
                    this.f38492a.f38486a.setRefreshing(false);
                }
            }
        };
    }

    @Override // com.kwad.sdk.lib.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            CallerContext callercontext = ((com.kwad.sdk.lib.a.a.a) this).f38465b;
            RefreshLayout refreshLayout = callercontext.j;
            this.f38486a = refreshLayout;
            this.f38487c = (com.kwad.sdk.lib.b.c<?, MODEL>) callercontext.f38469g;
            this.f38488d = callercontext.f38470h;
            refreshLayout.setEnabled(false);
            this.f38486a.setNestedScrollingEnabled(true);
            this.f38486a.setOnRefreshListener(this.f38489e);
            this.f38487c.a(this.f38490f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f38486a.setOnRefreshListener(null);
            this.f38487c.b(this.f38490f);
        }
    }
}
