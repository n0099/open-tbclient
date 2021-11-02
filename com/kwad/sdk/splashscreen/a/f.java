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
    public com.kwad.sdk.splashscreen.d f66555a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f66556b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66557c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f66558d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66559e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f66560f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f66561g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f66562h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f66563i;
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
        this.f66556b = false;
        this.f66557c = false;
        this.f66558d = false;
        this.f66559e = false;
        this.f66563i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f66564a;

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
                this.f66564a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f66564a.f66556b = false;
                    if (this.f66564a.f66560f != null) {
                        this.f66564a.f66560f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f66565a;

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
                                this.f66565a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f66565a.f66564a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f66555a.f66608f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f66556b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f66565a.f66564a.f66555a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f66606d);
                                        boolean z = this.f66565a.f66564a.f66556b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f66565a.f66564a.f66560f.setImageDrawable(this.f66565a.f66564a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f66565a.f66564a.f66560f, str, this.f66565a.f66564a.f66555a.f66606d);
                                        }
                                        this.f66565a.f66564a.f66560f.setSelected(false);
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
            public final /* synthetic */ f f66566a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f66567b;

            /* renamed from: c  reason: collision with root package name */
            public int f66568c;

            /* renamed from: d  reason: collision with root package name */
            public int f66569d;

            /* renamed from: e  reason: collision with root package name */
            public String f66570e;

            /* renamed from: f  reason: collision with root package name */
            public String f66571f;

            /* renamed from: g  reason: collision with root package name */
            public int f66572g;

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
                this.f66566a = this;
                this.f66567b = false;
                this.f66568c = 0;
                this.f66569d = com.kwad.sdk.core.config.c.ai();
                this.f66570e = com.kwad.sdk.core.config.c.ah();
                this.f66571f = com.kwad.sdk.core.config.c.al();
                this.f66572g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f66566a;
                    if (fVar.f66555a.f66603a == null || fVar.f66559e) {
                        return;
                    }
                    this.f66566a.f66555a.f66603a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f66568c++;
                    int i4 = this.f66569d;
                    boolean o = this.f66566a.o();
                    if (o) {
                        str = this.f66570e;
                    } else {
                        i4 = Math.min(this.f66572g, ((int) j) / 1000);
                        str = this.f66571f;
                    }
                    this.f66566a.f66561g.post(new Runnable(this, i4, j2, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f66573a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f66574b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f66575c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f66576d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f66577e;

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
                            this.f66577e = this;
                            this.f66573a = i4;
                            this.f66574b = j2;
                            this.f66575c = str;
                            this.f66576d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f66573a * 1000) - this.f66574b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f66575c + i5;
                                if (this.f66576d) {
                                    this.f66577e.f66566a.f66561g.setSkipText(str2);
                                } else {
                                    this.f66577e.f66566a.f66561g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f66568c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f66566a.f66555a;
                    if (dVar.f66603a != null) {
                        if (!dVar.f66604b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f66566a.f66555a;
                        dVar2.f66604b = true;
                        if (this.f66567b || (splashScreenAdInteractionListener = dVar2.f66603a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f66567b = true;
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
                    f fVar = this.f66566a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f66555a.f66608f;
                    if (aVar != null) {
                        aVar.a(fVar.f66556b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f66566a.f66557c) {
                    return;
                }
                this.f66566a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f66566a.f66555a.f66603a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f66566a.f66555a.f66608f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f66566a;
                        fVar.f66555a.f66608f.a(fVar.f66556b, true);
                    }
                }
                this.f66566a.f66557c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f66567b || (splashScreenAdInteractionListener = this.f66566a.f66555a.f66603a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f66567b = true;
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
            com.kwad.sdk.core.report.a.i(this.f66555a.f66606d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f66555a;
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
            this.f66555a = dVar;
            this.f66562h = com.kwad.sdk.core.response.b.c.i(dVar.f66606d);
            ((DetailVideoView) this.f66555a.f66607e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f66555a.f66608f;
            if (aVar2 != null) {
                aVar2.a(this.j);
            }
            this.f66555a.f66611i.a(this);
            SkipView skipView = (SkipView) this.f66555a.f66607e.findViewById(R.id.ksad_splash_skip_view);
            this.f66561g = skipView;
            a(skipView, this.f66562h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f66555a.f66606d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f66556b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f66556b = false;
                    }
                    aVar = this.f66555a.f66608f;
                    if (aVar != null) {
                        aVar.a(this.f66556b, false);
                        this.f66555a.f66608f.a(this.f66563i);
                    }
                    ImageView imageView = (ImageView) this.f66555a.f66607e.findViewById(R.id.ksad_splash_sound);
                    this.f66560f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f66556b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f66560f, str, this.f66555a.f66606d);
                    } else {
                        this.f66560f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f66560f.setSelected(this.f66556b);
                    this.f66560f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f66578a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f66579b;

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
                            this.f66579b = this;
                            this.f66578a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f66579b;
                                fVar.f66556b = !fVar.f66556b;
                                String str2 = this.f66579b.f66556b ? this.f66578a.adSplashInfo.speakerIconUrl : this.f66578a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f66579b.f66560f.setImageDrawable(this.f66579b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f66579b.f66560f, str2, this.f66579b.f66555a.f66606d);
                                }
                                this.f66579b.f66560f.setSelected(this.f66579b.f66556b);
                                f fVar2 = this.f66579b;
                                fVar2.f66555a.f66608f.a(fVar2.f66556b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f66555a.f66607e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f66556b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f66555a.f66608f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f66555a.f66607e.findViewById(R.id.ksad_splash_sound);
            this.f66560f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f66556b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f66560f.setSelected(this.f66556b);
            this.f66560f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f66578a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f66579b;

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
                    this.f66579b = this;
                    this.f66578a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f66579b;
                        fVar.f66556b = !fVar.f66556b;
                        String str2 = this.f66579b.f66556b ? this.f66578a.adSplashInfo.speakerIconUrl : this.f66578a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f66579b.f66560f.setImageDrawable(this.f66579b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f66579b.f66560f, str2, this.f66579b.f66555a.f66606d);
                        }
                        this.f66579b.f66560f.setSelected(this.f66579b.f66556b);
                        f fVar2 = this.f66579b;
                        fVar2.f66555a.f66608f.a(fVar2.f66556b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f66555a.f66608f;
            if (aVar != null) {
                aVar.b(this.j);
                this.f66555a.f66608f.b(this.f66563i);
            }
            if (this.f66561g.getHandler() != null) {
                this.f66561g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f66555a.f66611i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f66559e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f66558d) {
            return;
        }
        this.f66558d = true;
        com.kwad.sdk.core.report.a.a(this.f66555a.f66606d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f66555a.f66608f) == null) {
            return;
        }
        aVar.g();
    }
}
