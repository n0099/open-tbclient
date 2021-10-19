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
    public com.kwad.sdk.splashscreen.d f74166a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f74167b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f74168c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f74169d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f74170e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f74171f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f74172g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f74173h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f74174i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.detail.video.d f74175j;

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
        this.f74167b = false;
        this.f74168c = false;
        this.f74169d = false;
        this.f74170e = false;
        this.f74174i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f74176a;

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
                this.f74176a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f74176a.f74167b = false;
                    if (this.f74176a.f74171f != null) {
                        this.f74176a.f74171f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f74177a;

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
                                this.f74177a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f74177a.f74176a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f74166a.f74222f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f74167b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f74177a.f74176a.f74166a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f74220d);
                                        boolean z = this.f74177a.f74176a.f74167b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f74177a.f74176a.f74171f.setImageDrawable(this.f74177a.f74176a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f74177a.f74176a.f74171f, str, this.f74177a.f74176a.f74166a.f74220d);
                                        }
                                        this.f74177a.f74176a.f74171f.setSelected(false);
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
        this.f74175j = new com.kwad.sdk.contentalliance.detail.video.d(this) { // from class: com.kwad.sdk.splashscreen.a.f.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f74178a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f74179b;

            /* renamed from: c  reason: collision with root package name */
            public int f74180c;

            /* renamed from: d  reason: collision with root package name */
            public int f74181d;

            /* renamed from: e  reason: collision with root package name */
            public String f74182e;

            /* renamed from: f  reason: collision with root package name */
            public String f74183f;

            /* renamed from: g  reason: collision with root package name */
            public int f74184g;

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
                this.f74178a = this;
                this.f74179b = false;
                this.f74180c = 0;
                this.f74181d = com.kwad.sdk.core.config.c.ai();
                this.f74182e = com.kwad.sdk.core.config.c.ah();
                this.f74183f = com.kwad.sdk.core.config.c.al();
                this.f74184g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f74178a;
                    if (fVar.f74166a.f74217a == null || fVar.f74170e) {
                        return;
                    }
                    this.f74178a.f74166a.f74217a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j2, long j3) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                    this.f74180c++;
                    int i4 = this.f74181d;
                    boolean o = this.f74178a.o();
                    if (o) {
                        str = this.f74182e;
                    } else {
                        i4 = Math.min(this.f74184g, ((int) j2) / 1000);
                        str = this.f74183f;
                    }
                    this.f74178a.f74172g.post(new Runnable(this, i4, j3, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f74185a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f74186b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f74187c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f74188d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f74189e;

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
                            this.f74189e = this;
                            this.f74185a = i4;
                            this.f74186b = j3;
                            this.f74187c = str;
                            this.f74188d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f74185a * 1000) - this.f74186b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f74187c + i5;
                                if (this.f74188d) {
                                    this.f74189e.f74178a.f74172g.setSkipText(str2);
                                } else {
                                    this.f74189e.f74178a.f74172g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f74180c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f74178a.f74166a;
                    if (dVar.f74217a != null) {
                        if (!dVar.f74218b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f74178a.f74166a;
                        dVar2.f74218b = true;
                        if (this.f74179b || (splashScreenAdInteractionListener = dVar2.f74217a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f74179b = true;
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
                    f fVar = this.f74178a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f74166a.f74222f;
                    if (aVar != null) {
                        aVar.a(fVar.f74167b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f74178a.f74168c) {
                    return;
                }
                this.f74178a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f74178a.f74166a.f74217a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f74178a.f74166a.f74222f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f74178a;
                        fVar.f74166a.f74222f.a(fVar.f74167b, true);
                    }
                }
                this.f74178a.f74168c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f74179b || (splashScreenAdInteractionListener = this.f74178a.f74166a.f74217a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f74179b = true;
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
            com.kwad.sdk.core.report.a.i(this.f74166a.f74220d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f74166a;
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
            this.f74166a = dVar;
            this.f74173h = com.kwad.sdk.core.response.b.c.i(dVar.f74220d);
            ((DetailVideoView) this.f74166a.f74221e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f74166a.f74222f;
            if (aVar2 != null) {
                aVar2.a(this.f74175j);
            }
            this.f74166a.f74225i.a(this);
            SkipView skipView = (SkipView) this.f74166a.f74221e.findViewById(R.id.ksad_splash_skip_view);
            this.f74172g = skipView;
            a(skipView, this.f74173h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f74166a.f74220d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f74167b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f74167b = false;
                    }
                    aVar = this.f74166a.f74222f;
                    if (aVar != null) {
                        aVar.a(this.f74167b, false);
                        this.f74166a.f74222f.a(this.f74174i);
                    }
                    ImageView imageView = (ImageView) this.f74166a.f74221e.findViewById(R.id.ksad_splash_sound);
                    this.f74171f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f74167b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f74171f, str, this.f74166a.f74220d);
                    } else {
                        this.f74171f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f74171f.setSelected(this.f74167b);
                    this.f74171f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f74190a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f74191b;

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
                            this.f74191b = this;
                            this.f74190a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f74191b;
                                fVar.f74167b = !fVar.f74167b;
                                String str2 = this.f74191b.f74167b ? this.f74190a.adSplashInfo.speakerIconUrl : this.f74190a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f74191b.f74171f.setImageDrawable(this.f74191b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f74191b.f74171f, str2, this.f74191b.f74166a.f74220d);
                                }
                                this.f74191b.f74171f.setSelected(this.f74191b.f74167b);
                                f fVar2 = this.f74191b;
                                fVar2.f74166a.f74222f.a(fVar2.f74167b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f74166a.f74221e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f74167b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f74166a.f74222f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f74166a.f74221e.findViewById(R.id.ksad_splash_sound);
            this.f74171f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f74167b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f74171f.setSelected(this.f74167b);
            this.f74171f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f74190a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f74191b;

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
                    this.f74191b = this;
                    this.f74190a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f74191b;
                        fVar.f74167b = !fVar.f74167b;
                        String str2 = this.f74191b.f74167b ? this.f74190a.adSplashInfo.speakerIconUrl : this.f74190a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f74191b.f74171f.setImageDrawable(this.f74191b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f74191b.f74171f, str2, this.f74191b.f74166a.f74220d);
                        }
                        this.f74191b.f74171f.setSelected(this.f74191b.f74167b);
                        f fVar2 = this.f74191b;
                        fVar2.f74166a.f74222f.a(fVar2.f74167b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f74166a.f74222f;
            if (aVar != null) {
                aVar.b(this.f74175j);
                this.f74166a.f74222f.b(this.f74174i);
            }
            if (this.f74172g.getHandler() != null) {
                this.f74172g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f74166a.f74225i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f74170e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f74169d) {
            return;
        }
        this.f74169d = true;
        com.kwad.sdk.core.report.a.a(this.f74166a.f74220d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f74166a.f74222f) == null) {
            return;
        }
        aVar.g();
    }
}
