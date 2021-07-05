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
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.view.g;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.splashscreen.a.d;
import com.kwad.sdk.splashscreen.a.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends com.kwad.sdk.contentalliance.c<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public KsSplashScreenAd.SplashScreenAdInteractionListener f39254d;

    /* renamed from: e  reason: collision with root package name */
    public KsVideoPlayConfig f39255e;

    /* renamed from: f  reason: collision with root package name */
    public AdBaseFrameLayout f39256f;

    /* renamed from: g  reason: collision with root package name */
    public DetailVideoView f39257g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.core.download.b.b f39258h;

    /* renamed from: i  reason: collision with root package name */
    public g f39259i;
    public AdTemplate j;
    public KsScene k;
    public AdInfo l;
    public boolean m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context) {
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

    public static b a(Context context, @NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, ksScene, adResultData)) == null) {
            AdTemplate adTemplate = new AdTemplate();
            if (!adResultData.adTemplateList.isEmpty()) {
                adTemplate = adResultData.adTemplateList.get(0);
            }
            b bVar = new b(context);
            bVar.a(ksScene, adTemplate);
            return bVar;
        }
        return (b) invokeLLL.objValue;
    }

    private void a(KsScene ksScene, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, ksScene, adTemplate) == null) {
            this.k = ksScene;
            this.j = adTemplate;
            e();
        }
    }

    private void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.l = com.kwad.sdk.core.response.b.c.j(this.j);
            KsVideoPlayConfig build = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            this.f39255e = build;
            this.j.mInitVoiceStatus = build.isVideoSoundEnable() ? 2 : 1;
            this.f39258h = new com.kwad.sdk.core.download.b.b(this.j);
        }
    }

    private void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.f39256f = (AdBaseFrameLayout) this.f34328c.findViewById(R.id.ksad_splash_root_container);
            DetailVideoView detailVideoView = (DetailVideoView) this.f34328c.findViewById(R.id.ksad_splash_video_player);
            this.f39257g = detailVideoView;
            detailVideoView.setAd(true);
            this.f39257g.setVisibility(8);
            this.f39256f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.sdk.splashscreen.b.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ b f39260a;

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
                    this.f39260a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        com.kwad.sdk.core.download.b.a.a(view.getContext(), this.f39260a.j, new a.InterfaceC0426a(this) { // from class: com.kwad.sdk.splashscreen.b.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f39261a;

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
                                this.f39261a = this;
                            }

                            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0426a
                            public void a() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    if (this.f39261a.f39260a.f39254d != null) {
                                        this.f39261a.f39260a.f39254d.onAdClicked();
                                    }
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        if (this.f39261a.f39260a.f34327b != null && ((c) this.f39261a.f39260a.f34327b).f39278e != null) {
                                            jSONObject.put("duration", ((c) this.f39261a.f39260a.f34327b).f39278e.c());
                                        }
                                    } catch (JSONException e2) {
                                        com.kwad.sdk.core.d.a.a(e2);
                                    }
                                    com.kwad.sdk.core.report.b.a(this.f39261a.f39260a.j, jSONObject, this.f39261a.f39260a.f39256f.getTouchCoords(), (String) null);
                                }
                            }
                        }, this.f39260a.f39258h);
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

    @Override // com.kwad.sdk.contentalliance.c
    @NonNull
    public Presenter c() {
        InterceptResult invokeV;
        Presenter cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Presenter presenter = new Presenter();
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.a());
            presenter.a((Presenter) new com.kwad.sdk.splashscreen.a.b());
            if (com.kwad.sdk.core.response.b.a.J(this.l)) {
                presenter.a((Presenter) new e());
                cVar = new d();
            } else {
                cVar = new com.kwad.sdk.splashscreen.a.c();
            }
            presenter.a(cVar);
            return presenter;
        }
        return (Presenter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.contentalliance.c
    /* renamed from: d */
    public c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g gVar = new g(this.f34328c, 70);
            this.f39259i = gVar;
            gVar.a();
            if (this.f39255e == null) {
                this.f39255e = new KsVideoPlayConfig.Builder().videoSoundEnable(this.l.adSplashInfo.mute != 1).skipThirtySecond(true).build();
            }
            c cVar = new c();
            cVar.f39274a = this.f39254d;
            cVar.f39277d = this.f39256f;
            cVar.f39276c = this.j;
            cVar.f39280g = this.k;
            cVar.f39275b = this.f39255e;
            cVar.f39281h = this.f39259i;
            cVar.f39279f = this.f39258h;
            if (com.kwad.sdk.core.response.b.a.J(this.l)) {
                com.kwad.sdk.splashscreen.b.a aVar = new com.kwad.sdk.splashscreen.b.a(this.j, this.f39257g, this.f39255e);
                cVar.f39278e = aVar;
                cVar.f39281h.a(aVar);
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.c
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? R.layout.ksad_splash_screen : invokeV.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.c, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            T t = this.f34327b;
            if (((c) t).f39278e != null) {
                ((c) t).f39278e.g();
            }
        }
    }

    @Override // com.kwad.sdk.contentalliance.c, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            this.f39259i.b();
            T t = this.f34327b;
            if (((c) t).f39278e != null) {
                ((c) t).f39278e.f();
            }
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
            this.f39254d = splashScreenAdInteractionListener;
            T t = this.f34327b;
            if (t != 0) {
                ((c) t).f39274a = splashScreenAdInteractionListener;
            }
        }
    }
}
