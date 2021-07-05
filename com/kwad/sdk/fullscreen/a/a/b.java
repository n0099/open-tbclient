package com.kwad.sdk.fullscreen.a.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.e;
import com.kwad.sdk.contentalliance.detail.video.f;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.reward.d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f37533b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f37534c;

    /* renamed from: d  reason: collision with root package name */
    public AdTemplate f37535d;

    /* renamed from: e  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f37536e;

    /* renamed from: f  reason: collision with root package name */
    public String f37537f;

    /* renamed from: g  reason: collision with root package name */
    public long f37538g;

    /* renamed from: h  reason: collision with root package name */
    public e f37539h;

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
        this.f37539h = new f(this) { // from class: com.kwad.sdk.fullscreen.a.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f37540a;

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
                this.f37540a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || j2 < this.f37540a.f37538g) {
                    return;
                }
                this.f37540a.e();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65540, this) == null) || this.f37534c.getVisibility() == 0) {
            return;
        }
        String j = com.kwad.sdk.core.response.b.b.j(this.f37535d);
        if (TextUtils.isEmpty(j)) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f37534c.getLayoutParams();
        ImageView imageView = this.f37533b;
        if (imageView == null || imageView.getVisibility() != 0) {
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.rightMargin = ao.a(o(), 40.0f);
        }
        this.f37534c.setLayoutParams(layoutParams);
        this.f37534c.setText(j);
        this.f37534c.setVisibility(0);
        this.f37534c.setOnClickListener(this);
        f();
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.core.report.b.c(this.f37535d, 18, ((com.kwad.sdk.reward.d) this).f39062a.f38814d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            com.kwad.sdk.core.report.b.a(this.f37535d, 40, ((com.kwad.sdk.reward.d) this).f39062a.f38818h.getTouchCoords(), ((com.kwad.sdk.reward.d) this).f39062a.f38814d);
            ((com.kwad.sdk.reward.d) this).f39062a.f38812b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.reward.d) this).f39062a.f38816f;
            this.f37535d = adTemplate;
            this.f37538g = com.kwad.sdk.core.response.b.b.i(adTemplate);
            String j = com.kwad.sdk.core.response.b.b.j(this.f37535d);
            this.f37537f = j;
            if (TextUtils.isEmpty(j)) {
                return;
            }
            com.kwad.sdk.reward.a aVar = ((com.kwad.sdk.reward.d) this).f39062a;
            this.f37536e = aVar.j;
            aVar.f38819i.a(this.f37539h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            if (TextUtils.isEmpty(this.f37537f)) {
                return;
            }
            ((com.kwad.sdk.reward.d) this).f39062a.f38819i.b(this.f37539h);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f37534c = (TextView) b(R.id.ksad_detail_call_btn);
            this.f37533b = (ImageView) b(R.id.ksad_skip_icon);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f37534c) {
            com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f37535d, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.fullscreen.a.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f37541a;

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
                    this.f37541a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f37541a.g();
                    }
                }
            }, this.f37536e);
        }
    }
}
