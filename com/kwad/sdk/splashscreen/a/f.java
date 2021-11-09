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
/* loaded from: classes2.dex */
public class f extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f66554a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f66555b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66556c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66557d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66558e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f66559f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f66560g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f66561h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f66562i;
    public com.kwad.sdk.contentalliance.detail.video.d j;

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
        this.f66555b = false;
        this.f66556c = false;
        this.f66557d = false;
        this.f66558e = false;
        this.f66562i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f66563a;

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
                this.f66563a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66563a.f66555b = false;
                    if (this.f66563a.f66559f != null) {
                        this.f66563a.f66559f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f66564a;

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
                                this.f66564a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f66564a.f66563a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f66554a.f66607f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f66555b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f66564a.f66563a.f66554a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f66605d);
                                        boolean z = this.f66564a.f66563a.f66555b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f66564a.f66563a.f66559f.setImageDrawable(this.f66564a.f66563a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f66564a.f66563a.f66559f, str, this.f66564a.f66563a.f66554a.f66605d);
                                        }
                                        this.f66564a.f66563a.f66559f.setSelected(false);
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
        this.j = new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f66565a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f66566b;

            /* renamed from: c  reason: collision with root package name */
            public int f66567c;

            /* renamed from: d  reason: collision with root package name */
            public int f66568d;

            /* renamed from: e  reason: collision with root package name */
            public String f66569e;

            /* renamed from: f  reason: collision with root package name */
            public String f66570f;

            /* renamed from: g  reason: collision with root package name */
            public int f66571g;

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
                this.f66565a = this;
                this.f66566b = false;
                this.f66567c = 0;
                this.f66568d = com.kwad.sdk.core.config.c.ai();
                this.f66569e = com.kwad.sdk.core.config.c.ah();
                this.f66570f = com.kwad.sdk.core.config.c.al();
                this.f66571g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f66565a;
                    if (fVar.f66554a.f66602a == null || fVar.f66558e) {
                        return;
                    }
                    this.f66565a.f66554a.f66602a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f66567c++;
                    int i4 = this.f66568d;
                    boolean o = this.f66565a.o();
                    if (o) {
                        str = this.f66569e;
                    } else {
                        i4 = Math.min(this.f66571g, ((int) j) / 1000);
                        str = this.f66570f;
                    }
                    this.f66565a.f66560g.post(new Runnable(this, i4, j2, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f66572a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f66573b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f66574c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f66575d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f66576e;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext2 = TitanRuntime.newInitContext();
                                newInitContext2.initArgs = r2;
                                Object[] objArr = {this, Integer.valueOf(i4), Long.valueOf(j2), str, Boolean.valueOf(o)};
                                interceptable3.invokeUnInit(65536, newInitContext2);
                                int i5 = newInitContext2.flag;
                                if ((i5 & 1) != 0) {
                                    int i6 = i5 & 2;
                                    newInitContext2.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext2);
                                    return;
                                }
                            }
                            this.f66576e = this;
                            this.f66572a = i4;
                            this.f66573b = j2;
                            this.f66574c = str;
                            this.f66575d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f66572a * 1000) - this.f66573b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f66574c + i5;
                                if (this.f66575d) {
                                    this.f66576e.f66565a.f66560g.setSkipText(str2);
                                } else {
                                    this.f66576e.f66565a.f66560g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f66567c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f66565a.f66554a;
                    if (dVar.f66602a != null) {
                        if (!dVar.f66603b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f66565a.f66554a;
                        dVar2.f66603b = true;
                        if (this.f66566b || (splashScreenAdInteractionListener = dVar2.f66602a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f66566b = true;
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
                    f fVar = this.f66565a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f66554a.f66607f;
                    if (aVar != null) {
                        aVar.a(fVar.f66555b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f66565a.f66556c) {
                    return;
                }
                this.f66565a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f66565a.f66554a.f66602a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f66565a.f66554a.f66607f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f66565a;
                        fVar.f66554a.f66607f.a(fVar.f66555b, true);
                    }
                }
                this.f66565a.f66556c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f66566b || (splashScreenAdInteractionListener = this.f66565a.f66554a.f66602a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f66566b = true;
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
            com.kwad.sdk.core.report.a.i(this.f66554a.f66605d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f66554a;
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
            this.f66554a = dVar;
            this.f66561h = com.kwad.sdk.core.response.b.c.i(dVar.f66605d);
            ((DetailVideoView) this.f66554a.f66606e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f66554a.f66607f;
            if (aVar2 != null) {
                aVar2.a(this.j);
            }
            this.f66554a.f66610i.a(this);
            SkipView skipView = (SkipView) this.f66554a.f66606e.findViewById(R.id.ksad_splash_skip_view);
            this.f66560g = skipView;
            a(skipView, this.f66561h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f66554a.f66605d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f66555b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f66555b = false;
                    }
                    aVar = this.f66554a.f66607f;
                    if (aVar != null) {
                        aVar.a(this.f66555b, false);
                        this.f66554a.f66607f.a(this.f66562i);
                    }
                    ImageView imageView = (ImageView) this.f66554a.f66606e.findViewById(R.id.ksad_splash_sound);
                    this.f66559f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f66555b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f66559f, str, this.f66554a.f66605d);
                    } else {
                        this.f66559f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f66559f.setSelected(this.f66555b);
                    this.f66559f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f66577a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f66578b;

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
                            this.f66578b = this;
                            this.f66577a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f66578b;
                                fVar.f66555b = !fVar.f66555b;
                                String str2 = this.f66578b.f66555b ? this.f66577a.adSplashInfo.speakerIconUrl : this.f66577a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f66578b.f66559f.setImageDrawable(this.f66578b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f66578b.f66559f, str2, this.f66578b.f66554a.f66605d);
                                }
                                this.f66578b.f66559f.setSelected(this.f66578b.f66555b);
                                f fVar2 = this.f66578b;
                                fVar2.f66554a.f66607f.a(fVar2.f66555b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f66554a.f66606e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f66555b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f66554a.f66607f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f66554a.f66606e.findViewById(R.id.ksad_splash_sound);
            this.f66559f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f66555b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f66559f.setSelected(this.f66555b);
            this.f66559f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f66577a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f66578b;

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
                    this.f66578b = this;
                    this.f66577a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f66578b;
                        fVar.f66555b = !fVar.f66555b;
                        String str2 = this.f66578b.f66555b ? this.f66577a.adSplashInfo.speakerIconUrl : this.f66577a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f66578b.f66559f.setImageDrawable(this.f66578b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f66578b.f66559f, str2, this.f66578b.f66554a.f66605d);
                        }
                        this.f66578b.f66559f.setSelected(this.f66578b.f66555b);
                        f fVar2 = this.f66578b;
                        fVar2.f66554a.f66607f.a(fVar2.f66555b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f66554a.f66607f;
            if (aVar != null) {
                aVar.b(this.j);
                this.f66554a.f66607f.b(this.f66562i);
            }
            if (this.f66560g.getHandler() != null) {
                this.f66560g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f66554a.f66610i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f66558e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f66557d) {
            return;
        }
        this.f66557d = true;
        com.kwad.sdk.core.report.a.a(this.f66554a.f66605d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f66554a.f66607f) == null) {
            return;
        }
        aVar.g();
    }
}
