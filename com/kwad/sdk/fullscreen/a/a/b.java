package com.kwad.sdk.fullscreen.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f35872b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f35873c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f35874d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f35875e;

    /* renamed from: f  reason: collision with root package name */
    public String f35876f;

    /* renamed from: g  reason: collision with root package name */
    public long f35877g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f35878h;

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
        this.f35878h = new e(this) { // from class: com.kwad.sdk.fullscreen.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f35879a;

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
                this.f35879a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 < this.f35879a.f35877g) {
                    return;
                }
                this.f35879a.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.f35873c.getVisibility() == 0) {
            return;
        }
        String e2 = com.kwad.sdk.core.response.b.b.e(this.f35874d);
        if (TextUtils.isEmpty(e2)) {
            return;
        }
        this.f35873c.setText(e2);
        this.f35873c.setVisibility(0);
        this.f35873c.setOnClickListener(this);
        f();
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.core.report.a.c(this.f35874d, 18, ((com.kwad.sdk.reward.d) this).f36403a.f36075d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f35874d, 40, ((com.kwad.sdk.reward.d) this).f36403a.f36079h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f36403a.f36075d);
            ((com.kwad.sdk.reward.d) this).f36403a.f36073b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f36403a.f36077f;
            this.f35874d = adTemplate;
            this.f35877g = com.kwad.sdk.core.response.b.b.d(adTemplate);
            String e2 = com.kwad.sdk.core.response.b.b.e(this.f35874d);
            this.f35876f = e2;
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f36403a;
            this.f35875e = aVar.j;
            aVar.f36080i.a(this.f35878h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f35873c = (TextView) a(R.id.ksad_detail_call_btn);
            this.f35872b = (ImageView) a(R.id.ksad_skip_icon);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            if (TextUtils.isEmpty(this.f35876f)) {
                return;
            }
            ((com.kwad.sdk.reward.d) this).f36403a.f36080i.b(this.f35878h);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f35873c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f35874d, new a.InterfaceC0415a(this) { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f35880a;

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
                    this.f35880a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0415a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f35880a.n();
                    }
                }
            }, this.f35875e, false);
        }
    }
}
