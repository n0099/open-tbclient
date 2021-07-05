package com.kwad.sdk.a.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class f extends com.kwad.sdk.a.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f34105b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f34106c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f34107d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34108e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f34109f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f34110g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f34111h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f34112i;
    public KsAppDownloadListener j;

    public f() {
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
        this.f34112i = new com.kwad.sdk.contentalliance.detail.video.f(this) { // from class: com.kwad.sdk.a.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f34113a;

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
                this.f34113a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.f, com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34113a.e();
                }
            }
        };
        this.j = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.a.b.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f34114a;

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
                this.f34114a = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f34114a.f34108e.setText(com.kwad.sdk.core.response.b.a.w(this.f34114a.f34110g));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f34114a.f34108e.setText(com.kwad.sdk.core.response.b.a.a(this.f34114a.f34109f));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f34114a.f34108e.setText(com.kwad.sdk.core.response.b.a.w(this.f34114a.f34110g));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f34114a.f34108e.setText("立即打开");
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i4) == null) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            KSImageLoader.loadAppIcon(this.f34106c, com.kwad.sdk.core.response.b.a.o(this.f34110g), this.f34109f, 12);
            this.f34107d.setText(com.kwad.sdk.core.response.b.a.q(this.f34110g));
            this.f34108e.setText(com.kwad.sdk.core.response.b.a.w(this.f34110g));
            com.kwad.sdk.core.download.b.b bVar = this.f34111h;
            if (bVar != null) {
                bVar.a(this.j);
            }
            this.f34105b.setOnClickListener(this);
            this.f34105b.setVisibility(0);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.download.b.a.a(this.f34105b.getContext(), this.f34109f, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.a.b.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f34115a;

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
                    this.f34115a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.b.a(this.f34115a.f34109f, 2, ((com.kwad.sdk.a.a.a) this.f34115a).f34067a.f34070c.getTouchCoords());
                    }
                }
            }, this.f34111h);
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ((com.kwad.sdk.a.a.a) this).f34067a.f34068a.onAdClicked(this.f34105b, null);
        }
    }

    @Override // com.kwad.sdk.a.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.a.a.a) this).f34067a.f34071d;
            this.f34109f = adTemplate;
            this.f34110g = com.kwad.sdk.core.response.b.c.j(adTemplate);
            com.kwad.sdk.a.a.b bVar = ((com.kwad.sdk.a.a.a) this).f34067a;
            this.f34111h = bVar.f34072e;
            bVar.f34073f.a(this.f34112i);
            this.f34105b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b_();
            ((com.kwad.sdk.a.a.a) this).f34067a.f34073f.b(this.f34112i);
            com.kwad.sdk.core.download.b.b bVar = this.f34111h;
            if (bVar != null) {
                bVar.b(this.j);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f34105b = (ViewGroup) b(R.id.ksad_video_complete_app_container);
            this.f34106c = (ImageView) b(R.id.ksad_app_icon);
            this.f34107d = (TextView) b(R.id.ksad_app_name);
            this.f34108e = (TextView) b(R.id.ksad_app_download);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f34105b) {
            f();
            g();
        }
    }
}
