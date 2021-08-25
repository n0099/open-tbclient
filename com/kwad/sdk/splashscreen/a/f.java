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
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.SkipView;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f73632a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f73633b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f73634c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73635d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f73636e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f73637f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f73638g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f73639h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f73640i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f73641j;

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
        this.f73633b = false;
        this.f73634c = false;
        this.f73635d = false;
        this.f73636e = false;
        this.f73640i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f73642a;

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
                this.f73642a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f73642a.f73633b = false;
                    if (this.f73642a.f73637f != null) {
                        this.f73642a.f73637f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f73643a;

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
                                this.f73643a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f73643a.f73642a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f73632a.f73688f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f73633b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f73643a.f73642a.f73632a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f73686d);
                                        boolean z = this.f73643a.f73642a.f73633b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f73643a.f73642a.f73637f.setImageDrawable(this.f73643a.f73642a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f73643a.f73642a.f73637f, str, this.f73643a.f73642a.f73632a.f73686d);
                                        }
                                        this.f73643a.f73642a.f73637f.setSelected(false);
                                    }
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.f73641j = new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f73644a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f73645b;

            /* renamed from: c  reason: collision with root package name */
            public int f73646c;

            /* renamed from: d  reason: collision with root package name */
            public int f73647d;

            /* renamed from: e  reason: collision with root package name */
            public String f73648e;

            /* renamed from: f  reason: collision with root package name */
            public String f73649f;

            /* renamed from: g  reason: collision with root package name */
            public int f73650g;

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
                this.f73644a = this;
                this.f73645b = false;
                this.f73646c = 0;
                this.f73647d = com.kwad.sdk.core.config.c.ai();
                this.f73648e = com.kwad.sdk.core.config.c.ah();
                this.f73649f = com.kwad.sdk.core.config.c.al();
                this.f73650g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f73644a;
                    if (fVar.f73632a.f73683a == null || fVar.f73636e) {
                        return;
                    }
                    this.f73644a.f73632a.f73683a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.f73646c++;
                    int i4 = this.f73647d;
                    boolean o = this.f73644a.o();
                    if (o) {
                        str = this.f73648e;
                    } else {
                        i4 = Math.min(this.f73650g, ((int) j2) / 1000);
                        str = this.f73649f;
                    }
                    this.f73644a.f73638g.post(new Runnable(this, i4, j3, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f73651a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f73652b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f73653c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f73654d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f73655e;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i4), Long.valueOf(j3), str, Boolean.valueOf(o)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f73655e = this;
                            this.f73651a = i4;
                            this.f73652b = j3;
                            this.f73653c = str;
                            this.f73654d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f73651a * 1000) - this.f73652b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f73653c + i5;
                                if (this.f73654d) {
                                    this.f73655e.f73644a.f73638g.setSkipText(str2);
                                } else {
                                    this.f73655e.f73644a.f73638g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f73646c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f73644a.f73632a;
                    if (dVar.f73683a != null) {
                        if (!dVar.f73684b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f73644a.f73632a;
                        dVar2.f73684b = true;
                        if (this.f73645b || (splashScreenAdInteractionListener = dVar2.f73683a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f73645b = true;
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
                    f fVar = this.f73644a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f73632a.f73688f;
                    if (aVar != null) {
                        aVar.a(fVar.f73633b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f73644a.f73634c) {
                    return;
                }
                this.f73644a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f73644a.f73632a.f73683a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f73644a.f73632a.f73688f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f73644a;
                        fVar.f73632a.f73688f.a(fVar.f73633b, true);
                    }
                }
                this.f73644a.f73634c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f73645b || (splashScreenAdInteractionListener = this.f73644a.f73632a.f73683a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f73645b = true;
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
            skipView.setTimerBtnVisible(o() ? false : com.kwad.sdk.core.response.b.a.aj(adInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            com.kwad.sdk.core.report.a.i(this.f73632a.f73686d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f73632a;
            return dVar != null && dVar.b() && com.kwad.sdk.core.config.c.ai() > 0 && !an.a(com.kwad.sdk.core.config.c.ah());
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
            com.kwad.sdk.splashscreen.d dVar = (com.kwad.sdk.splashscreen.d) l();
            this.f73632a = dVar;
            this.f73639h = com.kwad.sdk.core.response.b.c.i(dVar.f73686d);
            ((DetailVideoView) this.f73632a.f73687e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f73632a.f73688f;
            if (aVar2 != null) {
                aVar2.a(this.f73641j);
            }
            this.f73632a.f73691i.a(this);
            SkipView skipView = (SkipView) this.f73632a.f73687e.findViewById(R.id.ksad_splash_skip_view);
            this.f73638g = skipView;
            a(skipView, this.f73639h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f73632a.f73686d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f73633b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f73633b = false;
                    }
                    aVar = this.f73632a.f73688f;
                    if (aVar != null) {
                        aVar.a(this.f73633b, false);
                        this.f73632a.f73688f.a(this.f73640i);
                    }
                    ImageView imageView = (ImageView) this.f73632a.f73687e.findViewById(R.id.ksad_splash_sound);
                    this.f73637f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f73633b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f73637f, str, this.f73632a.f73686d);
                    } else {
                        this.f73637f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f73637f.setSelected(this.f73633b);
                    this.f73637f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f73656a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f73657b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, i2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f73657b = this;
                            this.f73656a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f73657b;
                                fVar.f73633b = !fVar.f73633b;
                                String str2 = this.f73657b.f73633b ? this.f73656a.adSplashInfo.speakerIconUrl : this.f73656a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f73657b.f73637f.setImageDrawable(this.f73657b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f73657b.f73637f, str2, this.f73657b.f73632a.f73686d);
                                }
                                this.f73657b.f73637f.setSelected(this.f73657b.f73633b);
                                f fVar2 = this.f73657b;
                                fVar2.f73632a.f73688f.a(fVar2.f73633b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f73632a.f73687e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f73633b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f73632a.f73688f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f73632a.f73687e.findViewById(R.id.ksad_splash_sound);
            this.f73637f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f73633b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f73637f.setSelected(this.f73633b);
            this.f73637f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f73656a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f73657b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this, i2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f73657b = this;
                    this.f73656a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f73657b;
                        fVar.f73633b = !fVar.f73633b;
                        String str2 = this.f73657b.f73633b ? this.f73656a.adSplashInfo.speakerIconUrl : this.f73656a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f73657b.f73637f.setImageDrawable(this.f73657b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f73657b.f73637f, str2, this.f73657b.f73632a.f73686d);
                        }
                        this.f73657b.f73637f.setSelected(this.f73657b.f73633b);
                        f fVar2 = this.f73657b;
                        fVar2.f73632a.f73688f.a(fVar2.f73633b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f73632a.f73688f;
            if (aVar != null) {
                aVar.b(this.f73641j);
                this.f73632a.f73688f.b(this.f73640i);
            }
            if (this.f73638g.getHandler() != null) {
                this.f73638g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f73632a.f73691i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f73636e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f73635d) {
            return;
        }
        this.f73635d = true;
        com.kwad.sdk.core.report.a.a(this.f73632a.f73686d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f73632a.f73688f) == null) {
            return;
        }
        aVar.g();
    }
}
