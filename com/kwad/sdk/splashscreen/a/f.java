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
    public com.kwad.sdk.splashscreen.d f36615a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f36616b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36617c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36618d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f36619e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36620f;

    /* renamed from: g  reason: collision with root package name */
    public SkipView f36621g;

    /* renamed from: h  reason: collision with root package name */
    public AdInfo f36622h;

    /* renamed from: i  reason: collision with root package name */
    public h.a f36623i;
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
        this.f36616b = false;
        this.f36617c = false;
        this.f36618d = false;
        this.f36619e = false;
        this.f36623i = new h.a(this) { // from class: com.kwad.sdk.splashscreen.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f36624a;

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
                this.f36624a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f36624a.f36616b = false;
                    if (this.f36624a.f36620f != null) {
                        this.f36624a.f36620f.post(new Runnable(this) { // from class: com.kwad.sdk.splashscreen.a.f.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass1 f36625a;

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
                                this.f36625a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    f fVar = this.f36625a.f36624a;
                                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f36615a.f36668f;
                                    if (aVar != null) {
                                        aVar.a(fVar.f36616b, false);
                                    }
                                    com.kwad.sdk.splashscreen.d dVar = this.f36625a.f36624a.f36615a;
                                    if (dVar != null) {
                                        AdInfo i4 = com.kwad.sdk.core.response.b.c.i(dVar.f36666d);
                                        boolean z = this.f36625a.f36624a.f36616b;
                                        AdInfo.AdSplashInfo adSplashInfo = i4.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.f36625a.f36624a.f36620f.setImageDrawable(this.f36625a.f36624a.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                        } else {
                                            KSImageLoader.loadImage(this.f36625a.f36624a.f36620f, str, this.f36625a.f36624a.f36615a.f36666d);
                                        }
                                        this.f36625a.f36624a.f36620f.setSelected(false);
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
            public final /* synthetic */ f f36626a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f36627b;

            /* renamed from: c  reason: collision with root package name */
            public int f36628c;

            /* renamed from: d  reason: collision with root package name */
            public int f36629d;

            /* renamed from: e  reason: collision with root package name */
            public String f36630e;

            /* renamed from: f  reason: collision with root package name */
            public String f36631f;

            /* renamed from: g  reason: collision with root package name */
            public int f36632g;

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
                this.f36626a = this;
                this.f36627b = false;
                this.f36628c = 0;
                this.f36629d = com.kwad.sdk.core.config.c.ai();
                this.f36630e = com.kwad.sdk.core.config.c.ah();
                this.f36631f = com.kwad.sdk.core.config.c.al();
                this.f36632g = com.kwad.sdk.core.config.c.ak();
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
                    f fVar = this.f36626a;
                    if (fVar.f36615a.f36663a == null || fVar.f36619e) {
                        return;
                    }
                    this.f36626a.f36615a.f36663a.onAdShowError(0, "onVideoPlayError");
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void a(long j, long j2) {
                String str;
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    this.f36628c++;
                    int i4 = this.f36629d;
                    boolean o = this.f36626a.o();
                    if (o) {
                        str = this.f36630e;
                    } else {
                        i4 = Math.min(this.f36632g, ((int) j) / 1000);
                        str = this.f36631f;
                    }
                    this.f36626a.f36621g.post(new Runnable(this, i4, j2, str, o) { // from class: com.kwad.sdk.splashscreen.a.f.2.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ int f36633a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ long f36634b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ String f36635c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ boolean f36636d;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ AnonymousClass2 f36637e;

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
                            this.f36637e = this;
                            this.f36633a = i4;
                            this.f36634b = j2;
                            this.f36635c = str;
                            this.f36636d = o;
                        }

                        @Override // java.lang.Runnable
                        @SuppressLint({"SetTextI18n"})
                        public void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                int i5 = (int) (((this.f36633a * 1000) - this.f36634b) / 1000);
                                if (i5 < 1) {
                                    i5 = 1;
                                }
                                String str2 = this.f36635c + i5;
                                if (this.f36636d) {
                                    this.f36637e.f36626a.f36621g.setSkipText(str2);
                                } else {
                                    this.f36637e.f36626a.f36621g.a(str2);
                                }
                            }
                        }
                    });
                    if (i4 <= 0 || this.f36628c <= i4) {
                        return;
                    }
                    com.kwad.sdk.splashscreen.d dVar = this.f36626a.f36615a;
                    if (dVar.f36663a != null) {
                        if (!dVar.f36664b) {
                            dVar.d();
                        }
                        com.kwad.sdk.splashscreen.d dVar2 = this.f36626a.f36615a;
                        dVar2.f36664b = true;
                        if (this.f36627b || (splashScreenAdInteractionListener = dVar2.f36663a) == null) {
                            return;
                        }
                        splashScreenAdInteractionListener.onAdShowEnd();
                        this.f36627b = true;
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
                    f fVar = this.f36626a;
                    com.kwad.sdk.splashscreen.b.a aVar = fVar.f36615a.f36668f;
                    if (aVar != null) {
                        aVar.a(fVar.f36616b, false);
                    }
                }
            }

            @Override // com.kwad.sdk.contentalliance.detail.video.d
            public void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.f36626a.f36617c) {
                    return;
                }
                this.f36626a.n();
                KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.f36626a.f36615a.f36663a;
                if (splashScreenAdInteractionListener != null) {
                    splashScreenAdInteractionListener.onAdShowStart();
                    com.kwad.sdk.splashscreen.b.a aVar = this.f36626a.f36615a.f36668f;
                    if (aVar != null) {
                        aVar.a(true);
                        f fVar = this.f36626a;
                        fVar.f36615a.f36668f.a(fVar.f36616b, true);
                    }
                }
                this.f36626a.f36617c = true;
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.f36627b || (splashScreenAdInteractionListener = this.f36626a.f36615a.f36663a) == null) {
                    return;
                }
                splashScreenAdInteractionListener.onAdShowEnd();
                this.f36627b = true;
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
            com.kwad.sdk.core.report.a.i(this.f36615a.f36666d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.sdk.splashscreen.d dVar = this.f36615a;
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
            this.f36615a = dVar;
            this.f36622h = com.kwad.sdk.core.response.b.c.i(dVar.f36666d);
            ((DetailVideoView) this.f36615a.f36667e.findViewById(R.id.ksad_splash_video_player)).setVisibility(0);
            com.kwad.sdk.splashscreen.b.a aVar2 = this.f36615a.f36668f;
            if (aVar2 != null) {
                aVar2.a(this.j);
            }
            this.f36615a.f36671i.a(this);
            SkipView skipView = (SkipView) this.f36615a.f36667e.findViewById(R.id.ksad_splash_skip_view);
            this.f36621g = skipView;
            a(skipView, this.f36622h);
            AdInfo i2 = com.kwad.sdk.core.response.b.c.i(this.f36615a.f36666d);
            int i3 = i2.adSplashInfo.mute;
            boolean z = true;
            if (i3 != 2) {
                if (i3 != 3) {
                    this.f36616b = false;
                    if (com.kwad.sdk.utils.b.a(m()).a()) {
                        this.f36616b = false;
                    }
                    aVar = this.f36615a.f36668f;
                    if (aVar != null) {
                        aVar.a(this.f36616b, false);
                        this.f36615a.f36668f.a(this.f36623i);
                    }
                    ImageView imageView = (ImageView) this.f36615a.f36667e.findViewById(R.id.ksad_splash_sound);
                    this.f36620f = imageView;
                    imageView.setVisibility(0);
                    str = !this.f36616b ? i2.adSplashInfo.speakerIconUrl : i2.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f36620f, str, this.f36615a.f36666d);
                    } else {
                        this.f36620f.setImageDrawable(m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                    }
                    this.f36620f.setSelected(this.f36616b);
                    this.f36620f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ AdInfo f36638a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ f f36639b;

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
                            this.f36639b = this;
                            this.f36638a = i2;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                f fVar = this.f36639b;
                                fVar.f36616b = !fVar.f36616b;
                                String str2 = this.f36639b.f36616b ? this.f36638a.adSplashInfo.speakerIconUrl : this.f36638a.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.f36639b.f36620f.setImageDrawable(this.f36639b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                                } else {
                                    KSImageLoader.loadImage(this.f36639b.f36620f, str2, this.f36639b.f36615a.f36666d);
                                }
                                this.f36639b.f36620f.setSelected(this.f36639b.f36616b);
                                f fVar2 = this.f36639b;
                                fVar2.f36615a.f36668f.a(fVar2.f36616b, true);
                            }
                        }
                    });
                } else if (ap.n(this.f36615a.f36667e.getContext()) <= 0) {
                    z = false;
                }
            }
            this.f36616b = z;
            if (com.kwad.sdk.utils.b.a(m()).a()) {
            }
            aVar = this.f36615a.f36668f;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.f36615a.f36667e.findViewById(R.id.ksad_splash_sound);
            this.f36620f = imageView2;
            imageView2.setVisibility(0);
            if (!this.f36616b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f36620f.setSelected(this.f36616b);
            this.f36620f.setOnClickListener(new View.OnClickListener(this, i2) { // from class: com.kwad.sdk.splashscreen.a.f.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ AdInfo f36638a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ f f36639b;

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
                    this.f36639b = this;
                    this.f36638a = i2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        f fVar = this.f36639b;
                        fVar.f36616b = !fVar.f36616b;
                        String str2 = this.f36639b.f36616b ? this.f36638a.adSplashInfo.speakerIconUrl : this.f36638a.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.f36639b.f36620f.setImageDrawable(this.f36639b.m().getResources().getDrawable(R.drawable.ksad_splash_sound_selector));
                        } else {
                            KSImageLoader.loadImage(this.f36639b.f36620f, str2, this.f36639b.f36615a.f36666d);
                        }
                        this.f36639b.f36620f.setSelected(this.f36639b.f36616b);
                        f fVar2 = this.f36639b;
                        fVar2.f36615a.f36668f.a(fVar2.f36616b, true);
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
            com.kwad.sdk.splashscreen.b.a aVar = this.f36615a.f36668f;
            if (aVar != null) {
                aVar.b(this.j);
                this.f36615a.f36668f.b(this.f36623i);
            }
            if (this.f36621g.getHandler() != null) {
                this.f36621g.getHandler().removeCallbacksAndMessages(null);
            }
            this.f36615a.f36671i.b(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.d();
            this.f36619e = true;
        }
    }

    @Override // com.kwad.sdk.core.j.d
    public void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f36618d) {
            return;
        }
        this.f36618d = true;
        com.kwad.sdk.core.report.a.a(this.f36615a.f36666d, (JSONObject) null);
    }

    @Override // com.kwad.sdk.core.j.d
    public void f() {
        com.kwad.sdk.splashscreen.b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f36615a.f36668f) == null) {
            return;
        }
        aVar.g();
    }
}
