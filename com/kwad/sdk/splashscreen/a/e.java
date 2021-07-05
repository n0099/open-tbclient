package com.kwad.sdk.splashscreen.a;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends Presenter implements com.kwad.sdk.core.i.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.c f39241a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f39242b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39243c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f39244d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f39245e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f39246f;

    /* renamed from: g  reason: collision with root package name */
    public g.a f39247g;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.e f39248h;

    public e() {
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
        this.f39242b = false;
        this.f39243c = false;
        this.f39244d = false;
        this.f39245e = false;
        this.f39247g = new g.a(this) { // from class: com.kwad.sdk.splashscreen.a.e.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f39249a;

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
                this.f39249a = this;
            }

            @Override // com.kwad.sdk.utils.g.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f39249a.f39242b = false;
                    if (this.f39249a.f39246f != null) {
                        this.f39249a.f39246f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.e.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f39250a;

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
                                this.f39250a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    e eVar = this.f39250a.f39249a;
                                    com.kwad.sdk.splashscreen.b.a aVar = eVar.f39241a.f39278e;
                                    if (aVar != null) {
                                        aVar.a(eVar.f39242b, false);
                                    }
                                    com.kwad.sdk.splashscreen.c cVar = this.f39250a.f39249a.f39241a;
                                    if (cVar != null) {
                                        AdInfo j = com.kwad.sdk.core.response.b.c.j(cVar.f39276c);
                                        boolean z = this.f39250a.f39249a.f39242b;
                                        AdInfo.AdSplashInfo adSplashInfo = j.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f39250a.f39249a.f39246f.setImageDrawable(this.f39250a.f39249a.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f39250a.f39249a.f39246f, str, this.f39250a.f39249a.f39241a.f39276c);
                                        }
                                        this.f39250a.f39249a.f39246f.setSelected(false);
                                    }
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.kwad.sdk.utils.g.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.f39248h = new com.kwad.sdk.contentalliance.detail.video.e(this) { // from class: com.kwad.sdk.splashscreen.a.e.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ e f39251a;

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
                this.f39251a = this;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void a() {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (splashScreenAdInteractionListener = this.f39251a.f39241a.f39274a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    e eVar = this.f39251a;
                    if (eVar.f39241a.f39274a == null || eVar.f39245e) {
                        return;
                    }
                    this.f39251a.f39241a.f39274a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void a(long j, long j2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    e eVar = this.f39251a;
                    com.kwad.sdk.splashscreen.b.a aVar = eVar.f39241a.f39278e;
                    if (aVar != null) {
                        aVar.a(eVar.f39242b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f39251a.f39243c) {
                    return;
                }
                this.f39251a.e();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f39251a.f39241a.f39274a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f39251a.f39241a.f39278e;
                    if (aVar != null) {
                        aVar.a(true);
                        e eVar = this.f39251a;
                        eVar.f39241a.f39278e.a(eVar.f39242b, true);
                    }
                }
                this.f39251a.f39243c = true;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.e
            public void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            com.kwad.sdk.core.report.b.h(this.f39241a.f39276c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    @Override // com.kwad.sdk.mvp.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        com.kwad.sdk.splashscreen.b.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            com.kwad.sdk.splashscreen.c cVar = (com.kwad.sdk.splashscreen.c) n();
            this.f39241a = cVar;
            ((DetailVideoView) cVar.f39277d.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f39241a.f39278e;
            if (aVar2 != null) {
                aVar2.a(this.f39248h);
            }
            this.f39241a.f39281h.a(this);
            AdInfo j = com.kwad.sdk.core.response.b.c.j(this.f39241a.f39276c);
            int i2 = j.adSplashInfo.mute;
            boolean z = true;
            if (i2 != 2) {
                if (i2 != 3) {
                    this.f39242b = false;
                    if (com.kwad.sdk.utils.b.a().b()) {
                        this.f39242b = false;
                    }
                    aVar = this.f39241a.f39278e;
                    if (aVar != null) {
                        aVar.a(this.f39242b, false);
                        this.f39241a.f39278e.a(this.f39247g);
                    }
                    ImageView imageView = (ImageView) this.f39241a.f39277d.findViewById(R.id.ksad_splash_sound);
                    this.f39246f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f39242b ? j.adSplashInfo.speakerIconUrl : j.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f39246f, str, this.f39241a.f39276c);
                    } else {
                        this.f39246f.setImageDrawable(o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f39246f.setSelected(this.f39242b);
                    this.f39246f.setOnClickListener(new View.OnClickListener(this, j) { // from class: com.kwad.sdk.splashscreen.a.e.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f39252a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ e f39253b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, j};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f39253b = this;
                            this.f39252a = j;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                e eVar = this.f39253b;
                                eVar.f39242b = !eVar.f39242b;
                                String str2 = this.f39253b.f39242b ? this.f39252a.adSplashInfo.speakerIconUrl : this.f39252a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f39253b.f39246f.setImageDrawable(this.f39253b.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f39253b.f39246f, str2, this.f39253b.f39241a.f39276c);
                                }
                                this.f39253b.f39246f.setSelected(this.f39253b.f39242b);
                                e eVar2 = this.f39253b;
                                eVar2.f39241a.f39278e.a(eVar2.f39242b, true);
                            }
                        }
                    });
                } else if (ah.j(this.f39241a.f39277d.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f39242b = z;
            if (com.kwad.sdk.utils.b.a().b()) {
            }
            aVar = this.f39241a.f39278e;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f39241a.f39277d.findViewById(R.id.ksad_splash_sound);
            this.f39246f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f39242b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f39246f.setSelected(this.f39242b);
            this.f39246f.setOnClickListener(new View.OnClickListener(this, j) { // from class: com.kwad.sdk.splashscreen.a.e.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f39252a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ e f39253b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, j};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f39253b = this;
                    this.f39252a = j;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        e eVar = this.f39253b;
                        eVar.f39242b = !eVar.f39242b;
                        String str2 = this.f39253b.f39242b ? this.f39252a.adSplashInfo.speakerIconUrl : this.f39252a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f39253b.f39246f.setImageDrawable(this.f39253b.o().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f39253b.f39246f, str2, this.f39253b.f39241a.f39276c);
                        }
                        this.f39253b.f39246f.setSelected(this.f39253b.f39242b);
                        e eVar2 = this.f39253b;
                        eVar2.f39241a.f39278e.a(eVar2.f39242b, true);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void b() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f39241a.f39278e) == null) {
            return;
        }
        aVar.e();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b_();
            com.kwad.sdk.splashscreen.b.a aVar = this.f39241a.f39278e;
            if (aVar != null) {
                aVar.b(this.f39248h);
                this.f39241a.f39278e.b(this.f39247g);
            }
            this.f39241a.f39281h.b(this);
        }
    }

    @Override // com.kwad.sdk.core.i.c
    public void c_() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f39244d) {
            return;
        }
        this.f39244d = true;
        com.kwad.sdk.core.report.b.a(this.f39241a.f39276c, (JSONObject) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.d();
            this.f39245e = true;
        }
    }
}
