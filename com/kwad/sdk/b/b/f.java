package com.kwad.sdk.b.b;

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
/* loaded from: classes10.dex */
public class f extends com.kwad.sdk.b.a.a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f71051b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f71052c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f71053d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f71054e;

    /* renamed from: f  reason: collision with root package name */
    public AdTemplate f71055f;

    /* renamed from: g  reason: collision with root package name */
    public AdInfo f71056g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f71057h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f71058i;

    /* renamed from: j  reason: collision with root package name */
    public KsAppDownloadListener f71059j;

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
        this.f71058i = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.b.b.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f71060a;

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
                this.f71060a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e, com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.f71060a.e();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.a.b(th);
                        com.kwad.sdk.core.a.a.a(th);
                    }
                }
            }
        };
        this.f71059j = new com.kwad.sdk.core.download.b.c(this) { // from class: com.kwad.sdk.b.b.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f71061b;

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
                this.f71061b = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f71061b.f71054e.setText(com.kwad.sdk.core.response.b.a.u(this.f71061b.f71056g));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f71061b.f71054e.setText(com.kwad.sdk.core.response.b.a.a(this.f71061b.f71055f));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f71061b.f71054e.setText(com.kwad.sdk.core.response.b.a.u(this.f71061b.f71056g));
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.f71061b.f71054e.setText("立即打开");
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
            KSImageLoader.loadAppIcon(this.f71052c, com.kwad.sdk.core.response.b.a.n(this.f71056g), this.f71055f, 12);
            this.f71053d.setText(com.kwad.sdk.core.response.b.a.o(this.f71056g));
            this.f71054e.setText(com.kwad.sdk.core.response.b.a.u(this.f71056g));
            com.kwad.sdk.core.download.b.b bVar = this.f71057h;
            if (bVar != null) {
                bVar.a(this.f71059j);
            }
            this.f71051b.setOnClickListener(this);
            this.f71051b.setVisibility(0);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.download.b.a.a(this.f71051b.getContext(), this.f71055f, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.b.b.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ f f71062a;

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
                    this.f71062a = this;
                }

                @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        com.kwad.sdk.core.report.a.a(this.f71062a.f71055f, 2, ((com.kwad.sdk.b.a.a) this.f71062a).f71010a.f71013c.getTouchCoords());
                    }
                }
            }, this.f71057h, false);
        }
    }

    private void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ((com.kwad.sdk.b.a.a) this).f71010a.f71011a.onAdClicked(this.f71051b, null);
        }
    }

    @Override // com.kwad.sdk.b.a.a, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            AdTemplate adTemplate = ((com.kwad.sdk.b.a.a) this).f71010a.f71014d;
            this.f71055f = adTemplate;
            this.f71056g = com.kwad.sdk.core.response.b.c.i(adTemplate);
            com.kwad.sdk.b.a.b bVar = ((com.kwad.sdk.b.a.a) this).f71010a;
            this.f71057h = bVar.f71015e;
            bVar.f71016f.a(this.f71058i);
            this.f71051b.setVisibility(8);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f71051b = (ViewGroup) a(R.id.ksad_video_complete_app_container);
            this.f71052c = (ImageView) a(R.id.ksad_app_icon);
            this.f71053d = (TextView) a(R.id.ksad_app_name);
            this.f71054e = (TextView) a(R.id.ksad_app_download);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            ((com.kwad.sdk.b.a.a) this).f71010a.f71016f.b(this.f71058i);
            com.kwad.sdk.core.download.b.b bVar = this.f71057h;
            if (bVar != null) {
                bVar.b(this.f71059j);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && view == this.f71051b) {
            f();
            n();
        }
    }
}
