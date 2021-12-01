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
/* loaded from: classes2.dex */
public class j extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.splashscreen.g a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f59503b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59504c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59505d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59506e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59507f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f59508g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f59509h;

    /* renamed from: i  reason: collision with root package name */
    public j.a f59510i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f59511j;

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
        this.f59503b = false;
        this.f59504c = false;
        this.f59505d = false;
        this.f59506e = false;
        this.f59510i = new j.a(this) { // from class: com.kwad.sdk.splashscreen.a.j.1
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
                    this.a.f59503b = false;
                    if (this.a.f59507f != null) {
                        this.a.f59507f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.j.1.1
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
                                    com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f59579f;
                                    if (aVar != null) {
                                        aVar.a(jVar.f59503b, false);
                                    }
                                    com.kwad.sdk.splashscreen.g gVar = this.a.a.a;
                                    if (gVar != null) {
                                        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(gVar.f59577d);
                                        boolean z = this.a.a.f59503b;
                                        AdInfo.AdSplashInfo adSplashInfo = j2.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.a.a.f59507f.setImageDrawable(this.a.a.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.a.a.f59507f, str, this.a.a.a.f59577d);
                                        }
                                        this.a.a.f59507f.setSelected(false);
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
        this.f59511j = new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.j.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ j a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f59512b;

            /* renamed from: c  reason: collision with root package name */
            public int f59513c;

            /* renamed from: d  reason: collision with root package name */
            public String f59514d;

            /* renamed from: e  reason: collision with root package name */
            public String f59515e;

            /* renamed from: f  reason: collision with root package name */
            public int f59516f;

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
                this.f59512b = false;
                this.f59513c = com.kwad.sdk.core.config.b.ao();
                this.f59514d = com.kwad.sdk.core.config.b.am();
                this.f59515e = com.kwad.sdk.core.config.b.at();
                this.f59516f = com.kwad.sdk.core.config.b.as();
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
                    if (jVar.a.a == null || jVar.f59506e) {
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
                    int i4 = this.f59513c;
                    boolean h2 = this.a.h();
                    if (h2) {
                        str = this.f59514d;
                    } else {
                        i4 = Math.min(this.f59516f, ((int) j2) / 1000);
                        str = this.f59515e;
                    }
                    this.a.f59508g.post(new Runnable(this, i4, j3, str, h2) { // from class: com.kwad.sdk.splashscreen.a.j.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ int a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f59517b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f59518c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f59519d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f59520e;

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
                            this.f59520e = this;
                            this.a = i4;
                            this.f59517b = j3;
                            this.f59518c = str;
                            this.f59519d = h2;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.a * 1000) - this.f59517b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f59518c + i5;
                                if (this.f59519d) {
                                    this.f59520e.a.f59508g.setSkipText(str2);
                                } else {
                                    this.f59520e.a.f59508g.a(str2);
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
                        if (!gVar.f59575b) {
                            gVar.d();
                        }
                        com.kwad.sdk.splashscreen.g gVar2 = this.a.a;
                        gVar2.f59575b = true;
                        if (this.f59512b || (splashScreenAdInteractionListener = gVar2.a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f59512b = true;
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
                    com.kwad.sdk.splashscreen.b.a aVar = jVar.a.f59579f;
                    if (aVar != null) {
                        aVar.a(jVar.f59503b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.a.f59504c) {
                    return;
                }
                this.a.g();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.a.a.a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.a.a.f59579f;
                    if (aVar != null) {
                        aVar.a(true);
                        j jVar = this.a;
                        jVar.a.f59579f.a(jVar.f59503b, true);
                    }
                }
                this.a.f59504c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f59512b || (splashScreenAdInteractionListener = this.a.a.a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f59512b = true;
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
            com.kwad.sdk.core.report.a.i(this.a.f59577d);
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
            this.f59509h = com.kwad.sdk.core.response.a.d.j(gVar.f59577d);
            ((DetailVideoView) this.a.f59578e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.a.f59579f;
            if (aVar2 != null) {
                aVar2.a(this.f59511j);
            }
            this.a.f59582i.a(this);
            SkipView skipView = (SkipView) this.a.f59578e.findViewById(R.id.ksad_splash_skip_view);
            this.f59508g = skipView;
            a(skipView, this.f59509h);
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(this.a.f59577d);
            int i2 = j2.adSplashInfo.mute;
            boolean z = true;
            if (i2 != 2) {
                if (i2 != 3) {
                    this.f59503b = false;
                    if (com.kwad.sdk.utils.b.a(q()).a()) {
                        this.f59503b = false;
                    }
                    aVar = this.a.f59579f;
                    if (aVar != null) {
                        aVar.a(this.f59503b, false);
                        this.a.f59579f.a(this.f59510i);
                    }
                    ImageView imageView = (ImageView) this.a.f59578e.findViewById(R.id.ksad_splash_sound);
                    this.f59507f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f59503b ? j2.adSplashInfo.speakerIconUrl : j2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f59507f, str, this.a.f59577d);
                    } else {
                        this.f59507f.setImageDrawable(q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f59507f.setSelected(this.f59503b);
                    this.f59507f.setOnClickListener(new View.OnClickListener(this, j2) { // from class: com.kwad.sdk.splashscreen.a.j.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ AdInfo a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ j f59521b;

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
                            this.f59521b = this;
                            this.a = j2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                j jVar = this.f59521b;
                                jVar.f59503b = !jVar.f59503b;
                                String str2 = this.f59521b.f59503b ? this.a.adSplashInfo.speakerIconUrl : this.a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f59521b.f59507f.setImageDrawable(this.f59521b.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f59521b.f59507f, str2, this.f59521b.a.f59577d);
                                }
                                this.f59521b.f59507f.setSelected(this.f59521b.f59503b);
                                j jVar2 = this.f59521b;
                                jVar2.a.f59579f.a(jVar2.f59503b, true);
                            }
                        }
                    });
                } else if (av.u(this.a.f59578e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f59503b = z;
            if (com.kwad.sdk.utils.b.a(q()).a()) {
            }
            aVar = this.a.f59579f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.a.f59578e.findViewById(R.id.ksad_splash_sound);
            this.f59507f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f59503b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f59507f.setSelected(this.f59503b);
            this.f59507f.setOnClickListener(new View.OnClickListener(this, j2) { // from class: com.kwad.sdk.splashscreen.a.j.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AdInfo a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ j f59521b;

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
                    this.f59521b = this;
                    this.a = j2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        j jVar = this.f59521b;
                        jVar.f59503b = !jVar.f59503b;
                        String str2 = this.f59521b.f59503b ? this.a.adSplashInfo.speakerIconUrl : this.a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f59521b.f59507f.setImageDrawable(this.f59521b.q().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f59521b.f59507f, str2, this.f59521b.a.f59577d);
                        }
                        this.f59521b.f59507f.setSelected(this.f59521b.f59503b);
                        j jVar2 = this.f59521b;
                        jVar2.a.f59579f.a(jVar2.f59503b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.a.f59579f;
            if (aVar != null) {
                aVar.b(this.f59511j);
                this.a.f59579f.b(this.f59510i);
            }
            if (this.f59508g.getHandler() != null) {
                this.f59508g.getHandler().removeCallbacksAndMessages(null);
            }
            this.a.f59582i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d_();
            this.f59506e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f59505d) {
            return;
        }
        this.f59505d = true;
        com.kwad.sdk.core.report.a.a(this.a.f59577d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.a.f59579f) == null) {
            return;
        }
        aVar.g();
    }
}
