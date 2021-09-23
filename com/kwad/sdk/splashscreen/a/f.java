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
    public com.kwad.sdk.splashscreen.d f74131a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f74132b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74133c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74134d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74135e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f74136f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f74137g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f74138h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f74139i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f74140j;

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
        this.f74132b = false;
        this.f74133c = false;
        this.f74134d = false;
        this.f74135e = false;
        this.f74139i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f74141a;

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
                this.f74141a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f74141a.f74132b = false;
                    if (this.f74141a.f74136f != null) {
                        this.f74141a.f74136f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f74142a;

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
                                this.f74142a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f74142a.f74141a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f74131a.f74187f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f74132b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f74142a.f74141a.f74131a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f74185d);
                                        boolean z = this.f74142a.f74141a.f74132b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f74142a.f74141a.f74136f.setImageDrawable(this.f74142a.f74141a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f74142a.f74141a.f74136f, str, this.f74142a.f74141a.f74131a.f74185d);
                                        }
                                        this.f74142a.f74141a.f74136f.setSelected(false);
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
        this.f74140j = new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f74143a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f74144b;

            /* renamed from: c  reason: collision with root package name */
            public int f74145c;

            /* renamed from: d  reason: collision with root package name */
            public int f74146d;

            /* renamed from: e  reason: collision with root package name */
            public String f74147e;

            /* renamed from: f  reason: collision with root package name */
            public String f74148f;

            /* renamed from: g  reason: collision with root package name */
            public int f74149g;

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
                this.f74143a = this;
                this.f74144b = false;
                this.f74145c = 0;
                this.f74146d = com.kwad.sdk.core.config.c.ai();
                this.f74147e = com.kwad.sdk.core.config.c.ah();
                this.f74148f = com.kwad.sdk.core.config.c.al();
                this.f74149g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f74143a;
                    if (fVar.f74131a.f74182a == null || fVar.f74135e) {
                        return;
                    }
                    this.f74143a.f74131a.f74182a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.f74145c++;
                    int i4 = this.f74146d;
                    boolean o = this.f74143a.o();
                    if (o) {
                        str = this.f74147e;
                    } else {
                        i4 = Math.min(this.f74149g, ((int) j2) / 1000);
                        str = this.f74148f;
                    }
                    this.f74143a.f74137g.post(new Runnable(this, i4, j3, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f74150a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f74151b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f74152c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f74153d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f74154e;

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
                            this.f74154e = this;
                            this.f74150a = i4;
                            this.f74151b = j3;
                            this.f74152c = str;
                            this.f74153d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f74150a * 1000) - this.f74151b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f74152c + i5;
                                if (this.f74153d) {
                                    this.f74154e.f74143a.f74137g.setSkipText(str2);
                                } else {
                                    this.f74154e.f74143a.f74137g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f74145c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f74143a.f74131a;
                    if (dVar.f74182a != null) {
                        if (!dVar.f74183b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f74143a.f74131a;
                        dVar2.f74183b = true;
                        if (this.f74144b || (splashScreenAdInteractionListener = dVar2.f74182a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f74144b = true;
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
                    f fVar = this.f74143a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f74131a.f74187f;
                    if (aVar != null) {
                        aVar.a(fVar.f74132b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f74143a.f74133c) {
                    return;
                }
                this.f74143a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f74143a.f74131a.f74182a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f74143a.f74131a.f74187f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f74143a;
                        fVar.f74131a.f74187f.a(fVar.f74132b, true);
                    }
                }
                this.f74143a.f74133c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f74144b || (splashScreenAdInteractionListener = this.f74143a.f74131a.f74182a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f74144b = true;
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
            com.kwad.sdk.core.report.a.i(this.f74131a.f74185d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f74131a;
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
            this.f74131a = dVar;
            this.f74138h = com.kwad.sdk.core.response.b.c.i(dVar.f74185d);
            ((DetailVideoView) this.f74131a.f74186e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f74131a.f74187f;
            if (aVar2 != null) {
                aVar2.a(this.f74140j);
            }
            this.f74131a.f74190i.a(this);
            SkipView skipView = (SkipView) this.f74131a.f74186e.findViewById(R.id.ksad_splash_skip_view);
            this.f74137g = skipView;
            a(skipView, this.f74138h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f74131a.f74185d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f74132b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f74132b = false;
                    }
                    aVar = this.f74131a.f74187f;
                    if (aVar != null) {
                        aVar.a(this.f74132b, false);
                        this.f74131a.f74187f.a(this.f74139i);
                    }
                    ImageView imageView = (ImageView) this.f74131a.f74186e.findViewById(R.id.ksad_splash_sound);
                    this.f74136f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f74132b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f74136f, str, this.f74131a.f74185d);
                    } else {
                        this.f74136f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f74136f.setSelected(this.f74132b);
                    this.f74136f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f74155a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f74156b;

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
                            this.f74156b = this;
                            this.f74155a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f74156b;
                                fVar.f74132b = !fVar.f74132b;
                                String str2 = this.f74156b.f74132b ? this.f74155a.adSplashInfo.speakerIconUrl : this.f74155a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f74156b.f74136f.setImageDrawable(this.f74156b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f74156b.f74136f, str2, this.f74156b.f74131a.f74185d);
                                }
                                this.f74156b.f74136f.setSelected(this.f74156b.f74132b);
                                f fVar2 = this.f74156b;
                                fVar2.f74131a.f74187f.a(fVar2.f74132b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f74131a.f74186e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f74132b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f74131a.f74187f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f74131a.f74186e.findViewById(R.id.ksad_splash_sound);
            this.f74136f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f74132b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f74136f.setSelected(this.f74132b);
            this.f74136f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f74155a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f74156b;

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
                    this.f74156b = this;
                    this.f74155a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f74156b;
                        fVar.f74132b = !fVar.f74132b;
                        String str2 = this.f74156b.f74132b ? this.f74155a.adSplashInfo.speakerIconUrl : this.f74155a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f74156b.f74136f.setImageDrawable(this.f74156b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f74156b.f74136f, str2, this.f74156b.f74131a.f74185d);
                        }
                        this.f74156b.f74136f.setSelected(this.f74156b.f74132b);
                        f fVar2 = this.f74156b;
                        fVar2.f74131a.f74187f.a(fVar2.f74132b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f74131a.f74187f;
            if (aVar != null) {
                aVar.b(this.f74140j);
                this.f74131a.f74187f.b(this.f74139i);
            }
            if (this.f74137g.getHandler() != null) {
                this.f74137g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f74131a.f74190i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f74135e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f74134d) {
            return;
        }
        this.f74134d = true;
        com.kwad.sdk.core.report.a.a(this.f74131a.f74185d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f74131a.f74187f) == null) {
            return;
        }
        aVar.g();
    }
}
