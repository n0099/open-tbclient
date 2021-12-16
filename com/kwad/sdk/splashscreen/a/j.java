package com.kwad.sdk.splashscreen.a;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.contentalliance.detail.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.widget.SkipView;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class j extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f60084b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60085c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60086d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60087e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60088f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f60089g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f60090h;

    /* renamed from: i  reason: collision with root package name */
    public j.a f60091i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f60092j;

    public j() {
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
        this.f60084b = false;
        this.f60085c = false;
        this.f60086d = false;
        this.f60087e = false;
        this.f60091i = new j.a(this) { // from class: com.kwad.sdk.splashscreen.a.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.j.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.f60084b = false;
                    if (this.a.f60088f != null) {
                        this.a.f60088f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.j.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 a;

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
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    j jVar = this.a.a;
                                    com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f60160f;
                                    if (aVar != null) {
                                        aVar.a(jVar.f60084b, false);
                                    }
                                    com.kwad.sdk.splashscreen.g gVar = this.a.a.a;
                                    if (gVar != null) {
                                        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(gVar.f60158d);
                                        boolean z = this.a.a.f60084b;
                                        AdInfo.AdSplashInfo adSplashInfo = j2.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.a.a.f60088f.setImageDrawable(this.a.a.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.a.a.f60088f, str, this.a.a.a.f60158d);
                                        }
                                        this.a.a.f60088f.setSelected(false);
                                    }
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.kwad.sdk.utils.j.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.f60092j = new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.j.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f60093b;

            /* renamed from: c  reason: collision with root package name */
            public int f60094c;

            /* renamed from: d  reason: collision with root package name */
            public String f60095d;

            /* renamed from: e  reason: collision with root package name */
            public String f60096e;

            /* renamed from: f  reason: collision with root package name */
            public int f60097f;

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
                this.a = this;
                this.f60093b = false;
                this.f60094c = com.kwad.sdk.core.config.b.ao();
                this.f60095d = com.kwad.sdk.core.config.b.am();
                this.f60096e = com.kwad.sdk.core.config.b.at();
                this.f60097f = com.kwad.sdk.core.config.b.as();
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(int i4, int i5) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, i5) == null) {
                    j jVar = this.a;
                    if (jVar.a.a == null || jVar.f60087e) {
                        return;
                    }
                    this.a.a.a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    int i4 = this.f60094c;
                    boolean h2 = this.a.h();
                    if (h2) {
                        str = this.f60095d;
                    } else {
                        i4 = Math.min(this.f60097f, ((int) j2) / 1000);
                        str = this.f60096e;
                    }
                    this.a.f60089g.post(new Runnable(this, i4, j3, str, h2) { // from class: com.kwad.sdk.splashscreen.a.j.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f60098b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f60099c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f60100d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f60101e;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i4), Long.valueOf(j3), str, Boolean.valueOf(h2)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f60101e = this;
                            this.a = i4;
                            this.f60098b = j3;
                            this.f60099c = str;
                            this.f60100d = h2;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.a * 1000) - this.f60098b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f60099c + i5;
                                if (this.f60100d) {
                                    this.f60101e.a.f60089g.setSkipText(str2);
                                } else {
                                    this.f60101e.a.f60089g.a(str2);
                                }
                            }
                        }
                    });
                    float f2 = ((float) j3) / 1000.0f;
                    if (i4 <= 0 || f2 + 0.5d <= i4 - 1) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.g gVar = this.a.a;
                    if (gVar.a != null) {
                        if (!gVar.f60156b) {
                            gVar.d();
                        }
                        com.kwad.sdk.splashscreen.g gVar2 = this.a.a;
                        gVar2.f60156b = true;
                        if (this.f60093b || (splashScreenAdInteractionListener = gVar2.a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f60093b = true;
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    j jVar = this.a;
                    com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f60160f;
                    if (aVar != null) {
                        aVar.a(jVar.f60084b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.a.f60085c) {
                    return;
                }
                this.a.g();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.a.a.a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.a.a.f60160f;
                    if (aVar != null) {
                        aVar.a(true);
                        j jVar = this.a;
                        jVar.a.f60160f.a(jVar.f60084b, true);
                    }
                }
                this.a.f60085c = true;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void f() {
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f60093b || (splashScreenAdInteractionListener = this.a.a.a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f60093b = true;
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                }
            }
        };
    }

    private void a(SkipView skipView, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, skipView, adInfo) == null) {
            skipView.setTimerBtnVisible(h() ? false : com.kwad.sdk.core.response.a.a.aw(adInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            com.kwad.sdk.core.report.a.i(this.a.f60158d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            com.kwad.sdk.splashscreen.g gVar = this.a;
            return gVar != null && gVar.b() && com.kwad.sdk.core.config.b.ao() > 0 && !at.a(com.kwad.sdk.core.config.b.am());
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c6  */
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
            com.kwad.sdk.splashscreen.g gVar = (com.kwad.sdk.splashscreen.g) p();
            this.a = gVar;
            this.f60090h = com.kwad.sdk.core.response.a.d.j(gVar.f60158d);
            ((DetailVideoView) this.a.f60159e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f60160f;
            if (aVar2 != null) {
                aVar2.a(this.f60092j);
            }
            this.a.f60163i.a(this);
            SkipView skipView = (SkipView) this.a.f60159e.findViewById(R.id.ksad_splash_skip_view);
            this.f60089g = skipView;
            a(skipView, this.f60090h);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f60158d);
            int i2 = j2.adSplashInfo.mute;
            boolean z = true;
            if (i2 != 2) {
                if (i2 != 3) {
                    this.f60084b = false;
                    if (com.kwad.sdk.utils.b.a(q()).a()) {
                        this.f60084b = false;
                    }
                    aVar = this.a.f60160f;
                    if (aVar != null) {
                        aVar.a(this.f60084b, false);
                        this.a.f60160f.a(this.f60091i);
                    }
                    ImageView imageView = (ImageView) this.a.f60159e.findViewById(R.id.ksad_splash_sound);
                    this.f60088f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f60084b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f60088f, str, this.a.f60158d);
                    } else {
                        this.f60088f.setImageDrawable(q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f60088f.setSelected(this.f60084b);
                    this.f60088f.setOnClickListener(new View.OnClickListener(this, j2) { // from class: com.kwad.sdk.splashscreen.a.j.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AdInfo a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ j f60102b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, j2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f60102b = this;
                            this.a = j2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                j jVar = this.f60102b;
                                jVar.f60084b = !jVar.f60084b;
                                String str2 = this.f60102b.f60084b ? this.a.adSplashInfo.speakerIconUrl : this.a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f60102b.f60088f.setImageDrawable(this.f60102b.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f60102b.f60088f, str2, this.f60102b.a.f60158d);
                                }
                                this.f60102b.f60088f.setSelected(this.f60102b.f60084b);
                                j jVar2 = this.f60102b;
                                jVar2.a.f60160f.a(jVar2.f60084b, true);
                            }
                        }
                    });
                } else if (av.u(this.a.f60159e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f60084b = z;
            if (com.kwad.sdk.utils.b.a(q()).a()) {
            }
            aVar = this.a.f60160f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.a.f60159e.findViewById(R.id.ksad_splash_sound);
            this.f60088f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f60084b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f60088f.setSelected(this.f60084b);
            this.f60088f.setOnClickListener(new View.OnClickListener(this, j2) { // from class: com.kwad.sdk.splashscreen.a.j.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ j f60102b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, j2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60102b = this;
                    this.a = j2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        j jVar = this.f60102b;
                        jVar.f60084b = !jVar.f60084b;
                        String str2 = this.f60102b.f60084b ? this.a.adSplashInfo.speakerIconUrl : this.a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f60102b.f60088f.setImageDrawable(this.f60102b.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f60102b.f60088f, str2, this.f60102b.a.f60158d);
                        }
                        this.f60102b.f60088f.setSelected(this.f60102b.f60084b);
                        j jVar2 = this.f60102b;
                        jVar2.a.f60160f.a(jVar2.f60084b, true);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            com.kwad.sdk.splashscreen.b.a aVar = this.a.f60160f;
            if (aVar != null) {
                aVar.b(this.f60092j);
                this.a.f60160f.b(this.f60091i);
            }
            if (this.f60089g.getHandler() != null) {
                this.f60089g.getHandler().removeCallbacksAndMessages(null);
            }
            this.a.f60163i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d_();
            this.f60087e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f60086d) {
            return;
        }
        this.f60086d = true;
        com.kwad.sdk.core.report.a.a(this.a.f60158d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.a.f60160f) == null) {
            return;
        }
        aVar.g();
    }
}
