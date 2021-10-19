package com.kwad.sdk.splashscreen;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.j.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c extends com.kwad.sdk.contentalliance.b<d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f74208d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f74209e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f74210f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f74211g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f74212h;

    /* renamed from: i  reason: collision with root package name */
    public e f74213i;

    /* renamed from: j  reason: collision with root package name */
    public AdTemplate f74214j;
    public KsScene k;
    public AdInfo l;
    public boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f();
    }

    public static c a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, ksScene, adResultData)) == null) {
            AdTemplate adTemplate = new AdTemplate();
            if (!adResultData.adTemplateList.isEmpty()) {
                adTemplate = adResultData.adTemplateList.get(0);
            }
            c cVar = new c(context);
            cVar.a(ksScene, adTemplate);
            return cVar;
        }
        return (c) invokeLLL.objValue;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, ksScene, adTemplate) == null) {
            this.k = ksScene;
            this.f74214j = adTemplate;
            e();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.l = com.kwad.sdk.core.response.b.c.i(this.f74214j);
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            this.f74209e = build;
            this.f74214j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
            this.f74212h = new com.kwad.sdk.core.download.b.b(this.f74214j);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f74210f = (AdBaseFrameLayout) this.f71736c.findViewById(R.id.ksad_splash_root_container);
            DetailVideoView detailVideoView = (DetailVideoView) this.f71736c.findViewById(R.id.ksad_splash_video_player);
            this.f74211g = detailVideoView;
            detailVideoView.setAd(true);
            this.f74211g.setVisibility(8);
            this.f74210f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ c f74215a;

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
                    this.f74215a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) && com.kwad.sdk.core.config.c.J()) {
                        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f74215a.f74214j, new a.InterfaceC1992a(this) { // from class: com.kwad.sdk.splashscreen.c.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f74216a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f74216a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC1992a
                            public void a() {
                                String d2;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.f74216a.f74215a.f74208d != null) {
                                        this.f74216a.f74215a.f74208d.onAdClicked();
                                    }
                                    if (!com.kwad.sdk.core.response.b.a.v(this.f74216a.f74215a.l) && (d2 = ((d) this.f74216a.f74215a.f71735b).d()) != null) {
                                        ((d) this.f74216a.f74215a.f71735b).f74218b = true;
                                        ((d) this.f74216a.f74215a.f71735b).f74220d.mMiniWindowId = d2;
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        if (this.f74216a.f74215a.f71735b != null && ((d) this.f74216a.f74215a.f71735b).f74222f != null) {
                                            jSONObject.put("duration", ((d) this.f74216a.f74215a.f71735b).f74222f.c());
                                        }
                                    } catch (JSONException e2) {
                                        com.kwad.sdk.core.d.a.a(e2);
                                    }
                                    com.kwad.sdk.core.report.a.a(this.f74216a.f74215a.f74214j, jSONObject, this.f74216a.f74215a.f74210f.getTouchCoords(), (String) null);
                                }
                            }
                        }, this.f74215a.f74212h, false);
                    }
                }
            });
        }
    }

    private void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || this.m) {
            return;
        }
        this.m = true;
    }

    @Override // com.kwad.sdk.contentalliance.b
    @NonNull
    public Presenter c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.d());
            presenter.a(com.kwad.sdk.core.response.b.a.F(this.l) ? new f() : new com.kwad.sdk.splashscreen.a.c());
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.e());
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.b
    /* renamed from: d */
    public d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e eVar = new e(this.f71736c, 70);
            this.f74213i = eVar;
            eVar.a();
            if (this.f74209e == null) {
                this.f74209e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            }
            d dVar = new d();
            dVar.f74217a = this.f74208d;
            dVar.f74221e = this.f74210f;
            dVar.f74220d = this.f74214j;
            dVar.f74224h = this.k;
            dVar.f74219c = this.f74209e;
            dVar.f74225i = this.f74213i;
            dVar.f74223g = this.f74212h;
            if (com.kwad.sdk.core.response.b.a.F(this.l)) {
                com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.f74214j, this.f74211g, this.f74209e);
                dVar.f74222f = aVar;
                dVar.f74225i.a(aVar);
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.b
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.ksad_splash_screen : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            T t = this.f71735b;
            if (((d) t).f74222f != null) {
                ((d) t).f74222f.j();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.b, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            this.f74213i.b();
            T t = this.f71735b;
            com.kwad.sdk.splashscreen.b.a aVar = ((d) t).f74222f;
            ((d) t).a();
            g();
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, view, i2) == null) {
            super.onVisibilityChanged(view, i2);
        }
    }

    public void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, splashScreenAdInteractionListener) == null) {
            this.f74208d = splashScreenAdInteractionListener;
            T t = this.f71735b;
            if (t != 0) {
                ((d) t).f74217a = splashScreenAdInteractionListener;
            }
        }
    }
}
