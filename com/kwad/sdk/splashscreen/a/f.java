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
/* loaded from: classes6.dex */
public class f extends Presenter implements com.kwad.sdk.core.j.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.d f36426a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36427b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36428c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36429d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36430e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36431f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f36432g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f36433h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f36434i;
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
        this.f36427b = false;
        this.f36428c = false;
        this.f36429d = false;
        this.f36430e = false;
        this.f36434i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f36435a;

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
                this.f36435a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36435a.f36427b = false;
                    if (this.f36435a.f36431f != null) {
                        this.f36435a.f36431f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f36436a;

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
                                this.f36436a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f36436a.f36435a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f36426a.f36479f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f36427b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f36436a.f36435a.f36426a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f36477d);
                                        boolean z = this.f36436a.f36435a.f36427b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f36436a.f36435a.f36431f.setImageDrawable(this.f36436a.f36435a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f36436a.f36435a.f36431f, str, this.f36436a.f36435a.f36426a.f36477d);
                                        }
                                        this.f36436a.f36435a.f36431f.setSelected(false);
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
            public final /* synthetic */ f f36437a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f36438b;

            /* renamed from: c  reason: collision with root package name */
            public int f36439c;

            /* renamed from: d  reason: collision with root package name */
            public int f36440d;

            /* renamed from: e  reason: collision with root package name */
            public String f36441e;

            /* renamed from: f  reason: collision with root package name */
            public String f36442f;

            /* renamed from: g  reason: collision with root package name */
            public int f36443g;

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
                this.f36437a = this;
                this.f36438b = false;
                this.f36439c = 0;
                this.f36440d = com.kwad.sdk.core.config.c.ai();
                this.f36441e = com.kwad.sdk.core.config.c.ah();
                this.f36442f = com.kwad.sdk.core.config.c.al();
                this.f36443g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f36437a;
                    if (fVar.f36426a.f36474a == null || fVar.f36430e) {
                        return;
                    }
                    this.f36437a.f36426a.f36474a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f36439c++;
                    int i4 = this.f36440d;
                    boolean o = this.f36437a.o();
                    if (o) {
                        str = this.f36441e;
                    } else {
                        i4 = Math.min(this.f36443g, ((int) j) / 1000);
                        str = this.f36442f;
                    }
                    this.f36437a.f36432g.post(new Runnable(this, i4, j2, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f36444a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f36445b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f36446c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f36447d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f36448e;

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
                            this.f36448e = this;
                            this.f36444a = i4;
                            this.f36445b = j2;
                            this.f36446c = str;
                            this.f36447d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f36444a * 1000) - this.f36445b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f36446c + i5;
                                if (this.f36447d) {
                                    this.f36448e.f36437a.f36432g.setSkipText(str2);
                                } else {
                                    this.f36448e.f36437a.f36432g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f36439c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f36437a.f36426a;
                    if (dVar.f36474a != null) {
                        if (!dVar.f36475b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f36437a.f36426a;
                        dVar2.f36475b = true;
                        if (this.f36438b || (splashScreenAdInteractionListener = dVar2.f36474a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f36438b = true;
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
                    f fVar = this.f36437a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f36426a.f36479f;
                    if (aVar != null) {
                        aVar.a(fVar.f36427b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f36437a.f36428c) {
                    return;
                }
                this.f36437a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f36437a.f36426a.f36474a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f36437a.f36426a.f36479f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f36437a;
                        fVar.f36426a.f36479f.a(fVar.f36427b, true);
                    }
                }
                this.f36437a.f36428c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f36438b || (splashScreenAdInteractionListener = this.f36437a.f36426a.f36474a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f36438b = true;
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
            com.kwad.sdk.core.report.a.i(this.f36426a.f36477d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f36426a;
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
            this.f36426a = dVar;
            this.f36433h = com.kwad.sdk.core.response.b.c.i(dVar.f36477d);
            ((DetailVideoView) this.f36426a.f36478e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f36426a.f36479f;
            if (aVar2 != null) {
                aVar2.a(this.j);
            }
            this.f36426a.f36482i.a(this);
            SkipView skipView = (SkipView) this.f36426a.f36478e.findViewById(R.id.ksad_splash_skip_view);
            this.f36432g = skipView;
            a(skipView, this.f36433h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f36426a.f36477d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f36427b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f36427b = false;
                    }
                    aVar = this.f36426a.f36479f;
                    if (aVar != null) {
                        aVar.a(this.f36427b, false);
                        this.f36426a.f36479f.a(this.f36434i);
                    }
                    ImageView imageView = (ImageView) this.f36426a.f36478e.findViewById(R.id.ksad_splash_sound);
                    this.f36431f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f36427b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f36431f, str, this.f36426a.f36477d);
                    } else {
                        this.f36431f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f36431f.setSelected(this.f36427b);
                    this.f36431f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f36449a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f36450b;

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
                            this.f36450b = this;
                            this.f36449a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f36450b;
                                fVar.f36427b = !fVar.f36427b;
                                String str2 = this.f36450b.f36427b ? this.f36449a.adSplashInfo.speakerIconUrl : this.f36449a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f36450b.f36431f.setImageDrawable(this.f36450b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f36450b.f36431f, str2, this.f36450b.f36426a.f36477d);
                                }
                                this.f36450b.f36431f.setSelected(this.f36450b.f36427b);
                                f fVar2 = this.f36450b;
                                fVar2.f36426a.f36479f.a(fVar2.f36427b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f36426a.f36478e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f36427b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f36426a.f36479f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f36426a.f36478e.findViewById(R.id.ksad_splash_sound);
            this.f36431f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f36427b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f36431f.setSelected(this.f36427b);
            this.f36431f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f36449a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f36450b;

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
                    this.f36450b = this;
                    this.f36449a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f36450b;
                        fVar.f36427b = !fVar.f36427b;
                        String str2 = this.f36450b.f36427b ? this.f36449a.adSplashInfo.speakerIconUrl : this.f36449a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f36450b.f36431f.setImageDrawable(this.f36450b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f36450b.f36431f, str2, this.f36450b.f36426a.f36477d);
                        }
                        this.f36450b.f36431f.setSelected(this.f36450b.f36427b);
                        f fVar2 = this.f36450b;
                        fVar2.f36426a.f36479f.a(fVar2.f36427b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f36426a.f36479f;
            if (aVar != null) {
                aVar.b(this.j);
                this.f36426a.f36479f.b(this.f36434i);
            }
            if (this.f36432g.getHandler() != null) {
                this.f36432g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f36426a.f36482i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f36430e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f36429d) {
            return;
        }
        this.f36429d = true;
        com.kwad.sdk.core.report.a.a(this.f36426a.f36477d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f36426a.f36479f) == null) {
            return;
        }
        aVar.g();
    }
}
