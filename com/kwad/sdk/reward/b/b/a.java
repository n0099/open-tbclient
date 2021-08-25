package com.kwad.sdk.reward.b.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.reward.d;
import com.kwad.sdk.widget.KsLogoView;
/* loaded from: classes10.dex */
public class a extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public DetailVideoView f73114b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f73115c;

    /* renamed from: d  reason: collision with root package name */
    public KsLogoView f73116d;

    /* renamed from: e  reason: collision with root package name */
    public AdTemplate f73117e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f73118f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView.a f73119g;

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
                return;
            }
        }
        this.f73119g = new DetailVideoView.a(this) { // from class: com.kwad.sdk.reward.b.b.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f73120a;

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
                this.f73120a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.DetailVideoView.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    com.kwad.sdk.core.download.b.a.a(this.f73120a.f73114b.getContext(), this.f73120a.f73117e, new a.InterfaceC1986a(this) { // from class: com.kwad.sdk.reward.b.b.a.1.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass1 f73121a;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i4 = newInitContext2.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f73121a = this;
                        }

                        @Override // com.kwad.sdk.core.download.b.a.InterfaceC1986a
                        public void a() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                this.f73121a.f73120a.e();
                            }
                        }
                    }, this.f73120a.f73118f, false);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            com.kwad.sdk.core.report.a.a(this.f73117e, 35, ((d) this).f73410a.f73075h.getTouchCoords(), ((d) this).f73410a.f73071d);
            ((d) this).f73410a.f73069b.a();
        }
    }

    @Override // com.kwad.sdk.reward.d, com.kwad.sdk.mvp.Presenter
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.reward.a aVar = ((d) this).f73410a;
            this.f73117e = aVar.f73073f;
            this.f73118f = aVar.f73077j;
            this.f73114b.setOnClickListener(this);
            this.f73116d.a(this.f73117e);
            this.f73115c.setOnClickListener(this);
            this.f73116d.setOnClickListener(this);
            this.f73114b.setClickListener(this.f73119g);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.b();
            this.f73114b = (DetailVideoView) a(R.id.ksad_video_player);
            this.f73116d = (KsLogoView) a(R.id.ksad_ad_label_play_bar);
            this.f73115c = (TextView) a(R.id.ksad_video_count_down);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.f73114b.setClickListener(null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }
}
