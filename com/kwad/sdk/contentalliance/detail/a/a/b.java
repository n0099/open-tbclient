package com.kwad.sdk.contentalliance.detail.a.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public TextView f34354b;

    /* renamed from: c  reason: collision with root package name */
    public String f34355c;

    /* renamed from: d  reason: collision with root package name */
    public AdBaseFrameLayout f34356d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f34357e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34358f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f34359g;

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
        this.f34359g = new Runnable(this) { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f34360a;

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
                this.f34360a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        ao.a(this.f34360a.f34354b, this.f34360a.f34355c, this.f34360a.e());
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        this.f34360a.f34354b.setText(this.f34360a.f34355c);
                        this.f34360a.f34354b.setVisibility(0);
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            AdTemplate adTemplate = this.f34357e;
            String v = adTemplate != null ? com.kwad.sdk.core.response.b.a.v(com.kwad.sdk.core.response.b.c.j(adTemplate)) : "广告";
            TextView textView = new TextView(o());
            textView.setText(v);
            textView.setPadding(ao.a(o(), 2.0f), ao.a(o(), 0.0f), ao.a(o(), 2.0f), ao.a(o(), 1.0f));
            textView.setGravity(17);
            textView.setTextColor(-1291845633);
            textView.setBackground(o().getResources().getDrawable(R.drawable.ksad_content_logo_bg));
            textView.setTextSize(10.0f);
            return ao.a(textView);
        }
        return (Bitmap) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f34357e, 25, this.f34356d.getTouchCoords());
        }
    }

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f34553a;
            AdTemplate adTemplate = cVar.j;
            this.f34357e = adTemplate;
            this.f34358f = cVar.o;
            this.f34355c = com.kwad.sdk.core.response.b.c.w(adTemplate);
            if (com.kwad.sdk.core.response.b.c.c(this.f34357e)) {
                this.f34354b.post(this.f34359g);
            } else if (ag.a(this.f34355c)) {
                this.f34354b.setVisibility(8);
                return;
            } else {
                this.f34354b.setText(this.f34355c);
            }
            this.f34354b.setVisibility(0);
            this.f34354b.setOnClickListener(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            this.f34354b.removeCallbacks(this.f34359g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34356d = (AdBaseFrameLayout) b(R.id.ksad_root_container);
            this.f34354b = (TextView) b(R.id.ksad_bottom_content_describe);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && com.kwad.sdk.core.response.b.c.c(this.f34357e)) {
            com.kwad.sdk.core.download.b.a.a(this.f34354b.getContext(), this.f34357e, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.contentalliance.detail.a.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f34361a;

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
                    this.f34361a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f34361a.f();
                    }
                }
            }, this.f34358f);
        }
    }
}
