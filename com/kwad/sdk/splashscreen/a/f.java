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
    public com.kwad.sdk.splashscreen.d f67467a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f67468b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67469c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67470d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67471e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f67472f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f67473g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f67474h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f67475i;
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
        this.f67468b = false;
        this.f67469c = false;
        this.f67470d = false;
        this.f67471e = false;
        this.f67475i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f67476a;

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
                this.f67476a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f67476a.f67468b = false;
                    if (this.f67476a.f67472f != null) {
                        this.f67476a.f67472f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f67477a;

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
                                this.f67477a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f67477a.f67476a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f67467a.f67520f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f67468b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f67477a.f67476a.f67467a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f67518d);
                                        boolean z = this.f67477a.f67476a.f67468b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f67477a.f67476a.f67472f.setImageDrawable(this.f67477a.f67476a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f67477a.f67476a.f67472f, str, this.f67477a.f67476a.f67467a.f67518d);
                                        }
                                        this.f67477a.f67476a.f67472f.setSelected(false);
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
            public final /* synthetic */ f f67478a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f67479b;

            /* renamed from: c  reason: collision with root package name */
            public int f67480c;

            /* renamed from: d  reason: collision with root package name */
            public int f67481d;

            /* renamed from: e  reason: collision with root package name */
            public String f67482e;

            /* renamed from: f  reason: collision with root package name */
            public String f67483f;

            /* renamed from: g  reason: collision with root package name */
            public int f67484g;

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
                this.f67478a = this;
                this.f67479b = false;
                this.f67480c = 0;
                this.f67481d = com.kwad.sdk.core.config.c.ai();
                this.f67482e = com.kwad.sdk.core.config.c.ah();
                this.f67483f = com.kwad.sdk.core.config.c.al();
                this.f67484g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f67478a;
                    if (fVar.f67467a.f67515a == null || fVar.f67471e) {
                        return;
                    }
                    this.f67478a.f67467a.f67515a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f67480c++;
                    int i4 = this.f67481d;
                    boolean o = this.f67478a.o();
                    if (o) {
                        str = this.f67482e;
                    } else {
                        i4 = Math.min(this.f67484g, ((int) j) / 1000);
                        str = this.f67483f;
                    }
                    this.f67478a.f67473g.post(new Runnable(this, i4, j2, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f67485a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f67486b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f67487c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f67488d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f67489e;

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
                            this.f67489e = this;
                            this.f67485a = i4;
                            this.f67486b = j2;
                            this.f67487c = str;
                            this.f67488d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f67485a * 1000) - this.f67486b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f67487c + i5;
                                if (this.f67488d) {
                                    this.f67489e.f67478a.f67473g.setSkipText(str2);
                                } else {
                                    this.f67489e.f67478a.f67473g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f67480c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f67478a.f67467a;
                    if (dVar.f67515a != null) {
                        if (!dVar.f67516b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f67478a.f67467a;
                        dVar2.f67516b = true;
                        if (this.f67479b || (splashScreenAdInteractionListener = dVar2.f67515a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f67479b = true;
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
                    f fVar = this.f67478a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f67467a.f67520f;
                    if (aVar != null) {
                        aVar.a(fVar.f67468b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f67478a.f67469c) {
                    return;
                }
                this.f67478a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f67478a.f67467a.f67515a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f67478a.f67467a.f67520f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f67478a;
                        fVar.f67467a.f67520f.a(fVar.f67468b, true);
                    }
                }
                this.f67478a.f67469c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f67479b || (splashScreenAdInteractionListener = this.f67478a.f67467a.f67515a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f67479b = true;
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
            com.kwad.sdk.core.report.a.i(this.f67467a.f67518d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f67467a;
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
            this.f67467a = dVar;
            this.f67474h = com.kwad.sdk.core.response.b.c.i(dVar.f67518d);
            ((DetailVideoView) this.f67467a.f67519e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f67467a.f67520f;
            if (aVar2 != null) {
                aVar2.a(this.j);
            }
            this.f67467a.f67523i.a(this);
            SkipView skipView = (SkipView) this.f67467a.f67519e.findViewById(R.id.ksad_splash_skip_view);
            this.f67473g = skipView;
            a(skipView, this.f67474h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f67467a.f67518d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f67468b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f67468b = false;
                    }
                    aVar = this.f67467a.f67520f;
                    if (aVar != null) {
                        aVar.a(this.f67468b, false);
                        this.f67467a.f67520f.a(this.f67475i);
                    }
                    ImageView imageView = (ImageView) this.f67467a.f67519e.findViewById(R.id.ksad_splash_sound);
                    this.f67472f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f67468b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f67472f, str, this.f67467a.f67518d);
                    } else {
                        this.f67472f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f67472f.setSelected(this.f67468b);
                    this.f67472f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f67490a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f67491b;

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
                            this.f67491b = this;
                            this.f67490a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f67491b;
                                fVar.f67468b = !fVar.f67468b;
                                String str2 = this.f67491b.f67468b ? this.f67490a.adSplashInfo.speakerIconUrl : this.f67490a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f67491b.f67472f.setImageDrawable(this.f67491b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f67491b.f67472f, str2, this.f67491b.f67467a.f67518d);
                                }
                                this.f67491b.f67472f.setSelected(this.f67491b.f67468b);
                                f fVar2 = this.f67491b;
                                fVar2.f67467a.f67520f.a(fVar2.f67468b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f67467a.f67519e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f67468b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f67467a.f67520f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f67467a.f67519e.findViewById(R.id.ksad_splash_sound);
            this.f67472f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f67468b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f67472f.setSelected(this.f67468b);
            this.f67472f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f67490a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f67491b;

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
                    this.f67491b = this;
                    this.f67490a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f67491b;
                        fVar.f67468b = !fVar.f67468b;
                        String str2 = this.f67491b.f67468b ? this.f67490a.adSplashInfo.speakerIconUrl : this.f67490a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f67491b.f67472f.setImageDrawable(this.f67491b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f67491b.f67472f, str2, this.f67491b.f67467a.f67518d);
                        }
                        this.f67491b.f67472f.setSelected(this.f67491b.f67468b);
                        f fVar2 = this.f67491b;
                        fVar2.f67467a.f67520f.a(fVar2.f67468b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f67467a.f67520f;
            if (aVar != null) {
                aVar.b(this.j);
                this.f67467a.f67520f.b(this.f67475i);
            }
            if (this.f67473g.getHandler() != null) {
                this.f67473g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f67467a.f67523i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f67471e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f67470d) {
            return;
        }
        this.f67470d = true;
        com.kwad.sdk.core.report.a.a(this.f67467a.f67518d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f67467a.f67520f) == null) {
            return;
        }
        aVar.g();
    }
}
