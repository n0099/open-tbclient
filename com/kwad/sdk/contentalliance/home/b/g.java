package com.kwad.sdk.contentalliance.home.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayViewPager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.p;
import com.kwad.sdk.utils.v;
/* loaded from: classes7.dex */
public class g extends com.kwad.sdk.contentalliance.home.e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.core.i.a f35134b;

    /* renamed from: c  reason: collision with root package name */
    public SlidePlayViewPager f35135c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.i f35136d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.home.a.d f35137e;

    /* renamed from: f  reason: collision with root package name */
    public NetworkMonitor.a f35138f;

    public g() {
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
        this.f35137e = new com.kwad.sdk.contentalliance.home.a.e(this) { // from class: com.kwad.sdk.contentalliance.home.b.g.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f35139a;

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
                this.f35139a = this;
            }

            @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
            public void a(boolean z, int i4) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i4)}) == null) && NetworkMonitor.a().b() && this.f35139a.f35134b != null && this.f35139a.f35134b.e() && v.c(this.f35139a.o())) {
                    this.f35139a.f();
                }
            }
        };
        this.f35138f = new NetworkMonitor.a(this) { // from class: com.kwad.sdk.contentalliance.home.b.g.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f35140a;

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
                this.f35140a = this;
            }

            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public void a(NetworkMonitor.NetworkState networkState) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, networkState) == null) && networkState == NetworkMonitor.NetworkState.NETWORK_MOBILE && NetworkMonitor.a().b() && this.f35140a.f35135c != null && !this.f35140a.f35135c.j() && this.f35140a.f35134b != null && this.f35140a.f35134b.e()) {
                    this.f35140a.f();
                }
            }
        };
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            if (this.f35138f != null) {
                NetworkMonitor.a().b(this.f35138f);
                this.f35138f = null;
            }
            com.kwad.sdk.contentalliance.home.a.i iVar = this.f35136d;
            if (iVar != null) {
                iVar.b(this.f35137e);
                this.f35137e = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            p.a(o(), o().getString(R.string.ksad_network_dataFlow_tip));
            NetworkMonitor.a().c();
            e();
        }
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.home.f fVar = ((com.kwad.sdk.contentalliance.home.e) this).f35218a;
            com.kwad.sdk.contentalliance.home.h hVar = fVar.f35224f;
            if (hVar == null) {
                return;
            }
            com.kwad.sdk.core.i.a aVar = hVar.f35240a;
            this.f35134b = aVar;
            if (aVar == null) {
                return;
            }
            com.kwad.sdk.contentalliance.home.a.i iVar = fVar.f35220b;
            this.f35136d = iVar;
            this.f35135c = fVar.f35221c;
            iVar.a(this.f35137e);
            NetworkMonitor.a().a(this.f35138f);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            e();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            e();
        }
    }
}
