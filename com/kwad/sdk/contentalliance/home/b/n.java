package com.kwad.sdk.contentalliance.home.b;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.d;
import com.kwad.sdk.contentalliance.home.swipe.SwipeLayout;
import com.kwad.sdk.utils.p;
/* loaded from: classes7.dex */
public class n extends com.kwad.sdk.contentalliance.home.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public d.a f35152b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.d f35153c;

    /* renamed from: d  reason: collision with root package name */
    public SwipeLayout f35154d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.b f35155e;

    /* renamed from: f  reason: collision with root package name */
    public SwipeLayout.a f35156f;

    public n() {
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
        this.f35152b = new d.a(this) { // from class: com.kwad.sdk.contentalliance.home.b.n.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n f35157a;

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
                this.f35157a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.d.a
            public boolean a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.kwad.sdk.contentalliance.home.d.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onRefresh()");
                    p.a(this.f35157a.o(), "再按一次返回键退出", 3000L);
                    if (this.f35157a.f35155e != null) {
                        this.f35157a.f35155e.a(3);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.d.a
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onExit()");
                    Activity m = this.f35157a.m();
                    if (m != null) {
                        m.onBackPressed();
                    }
                }
            }
        };
        this.f35153c = new com.kwad.sdk.contentalliance.home.d(this.f35152b);
        this.f35156f = new SwipeLayout.a(this) { // from class: com.kwad.sdk.contentalliance.home.b.n.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ n f35158a;

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
                this.f35158a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.kwad.sdk.core.d.a.a("SwipeRightExitPresenter", "onRightSwiped");
                    this.f35158a.f35153c.a();
                }
            }

            @Override // com.kwad.sdk.contentalliance.home.swipe.SwipeLayout.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.f35154d = (SwipeLayout) b(R.id.ksad_swipe);
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            e();
            com.kwad.sdk.contentalliance.home.a.i iVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a.f35220b;
            if (iVar != null) {
                this.f35155e = iVar.c();
            }
            SwipeLayout swipeLayout = this.f35154d;
            if (swipeLayout != null) {
                swipeLayout.a(this.f35156f);
            }
            this.f35153c.a(((com.kwad.sdk.contentalliance.home.e) this).f35218a.m);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        SwipeLayout swipeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (swipeLayout = this.f35154d) != null && swipeLayout.b(this.f35156f)) {
            this.f35154d.c(this.f35156f);
        }
    }
}
