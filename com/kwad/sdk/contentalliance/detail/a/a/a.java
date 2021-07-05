package com.kwad.sdk.contentalliance.detail.a.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
/* loaded from: classes7.dex */
public class a extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public AdBaseFrameLayout f34349b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f34350c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f34351d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34352e;

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
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f34351d, 24, this.f34349b.getTouchCoords());
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        TextView textView;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            AdTemplate adTemplate = cVar.j;
            this.f34351d = adTemplate;
            this.f34352e = cVar.o;
            String u = com.kwad.sdk.core.response.b.c.u(adTemplate);
            if (ag.a(u) && com.kwad.sdk.core.response.b.c.c(this.f34351d)) {
                u = o().getString(R.string.ksad_ad_default_username);
            }
            if (ag.a(u)) {
                textView = this.f34350c;
                i2 = 8;
            } else {
                this.f34350c.setText(u);
                this.f34350c.setOnClickListener(this);
                textView = this.f34350c;
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            this.f34349b = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34350c = (TextView) b(R.id.ksad_bottom_author_name);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) && com.kwad.sdk.core.response.b.c.c(this.f34351d)) {
            com.kwad.sdk.core.download.b.a.a(this.f34350c.getContext(), this.f34351d, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.contentalliance.detail.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ a f34353a;

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
                    this.f34353a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34353a.e();
                    }
                }
            }, this.f34352e);
        }
    }
}
