package com.kwad.sdk.contentalliance.detail.photo.newui.c;

import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.photo.f.f;
import com.kwad.sdk.contentalliance.detail.photo.f.j;
import com.kwad.sdk.contentalliance.detail.photo.f.k;
import com.kwad.sdk.contentalliance.trends.view.c;
import com.kwad.sdk.contentalliance.trends.view.d;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f34858b;

    /* renamed from: c  reason: collision with root package name */
    public c f34859c;

    public b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34859c = new d(this) { // from class: com.kwad.sdk.contentalliance.detail.photo.newui.c.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34860a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f34860a = this;
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34860a.f34858b.setVisibility(4);
                }
            }

            @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34860a.f34858b.setVisibility(0);
                }
            }
        };
        if (z && com.kwad.sdk.core.config.c.N()) {
            a((Presenter) new j(true));
        }
        a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.newui.d.a());
        if (com.kwad.sdk.core.config.c.f()) {
            a((Presenter) new com.kwad.sdk.contentalliance.detail.photo.e.b());
        }
        if (com.kwad.sdk.core.config.c.j()) {
            a((Presenter) new f());
        }
        if (com.kwad.sdk.core.config.c.h()) {
            a((Presenter) new k());
        }
        if (z && com.kwad.sdk.core.config.c.O()) {
            a((Presenter) new j(false));
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            if (com.kwad.sdk.core.response.b.c.B(((com.kwad.sdk.contentalliance.detail.b) this).f34553a.j)) {
                ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.a(this.f34859c);
                if (((com.kwad.sdk.contentalliance.detail.b) this).f34553a.f34574a.l) {
                    this.f34858b.setVisibility(4);
                }
            }
            this.f34858b.setPadding(0, 0, 0, ao.a(o(), 0.0f));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.contentalliance.detail.b) this).f34553a.b(this.f34859c);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34858b = (LinearLayout) b(R.id.ksad_photo_detail_bottom_toolbar);
        }
    }
}
