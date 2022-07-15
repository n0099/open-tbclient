package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.h;
/* loaded from: classes5.dex */
public final class n extends e implements com.kwad.sdk.core.g.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public ImageView f;
    public SkipView g;
    public AdInfo h;
    public h.a i;
    public com.kwad.components.core.video.g j;

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.i = new h.a(this) { // from class: com.kwad.components.ad.splashscreen.b.n.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.b = false;
                    if (this.a.f != null) {
                        this.a.f.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.n.1.1
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
                                    int i3 = newInitContext2.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    n nVar = this.a.a;
                                    com.kwad.components.ad.splashscreen.c.a aVar = ((e) nVar).a.e;
                                    if (aVar != null) {
                                        aVar.a(nVar.b, false);
                                    }
                                    com.kwad.components.ad.splashscreen.h hVar = ((e) this.a.a).a;
                                    if (hVar != null) {
                                        AdInfo i3 = com.kwad.sdk.core.response.a.d.i(hVar.c);
                                        boolean z = this.a.a.b;
                                        AdInfo.AdSplashInfo adSplashInfo = i3.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.a.a.f.setImageDrawable(this.a.a.u().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c42));
                                        } else {
                                            KSImageLoader.loadImage(this.a.a.f, str, ((e) this.a.a).a.c);
                                        }
                                        this.a.a.f.setSelected(false);
                                    }
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.j = new com.kwad.components.core.video.g(this) { // from class: com.kwad.components.ad.splashscreen.b.n.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n a;
            public boolean b;
            public int c;
            public String d;
            public String e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
                this.b = false;
                this.c = com.kwad.components.ad.splashscreen.a.b.g();
                this.d = com.kwad.components.ad.splashscreen.a.b.c();
                this.e = com.kwad.components.ad.splashscreen.a.b.h();
            }

            @Override // com.kwad.components.core.video.g
            public final void a() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void a(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i3, i4) == null) || this.a.e) {
                    return;
                }
                com.kwad.components.ad.splashscreen.monitor.a.a();
                com.kwad.components.ad.splashscreen.monitor.a.a(((e) this.a).a.c, i3, String.valueOf(i4));
                ((e) this.a).a.a(0, "onVideoPlayError");
            }

            @Override // com.kwad.components.core.video.g
            public final void a(long j, long j2) {
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    int i3 = this.c;
                    boolean d = this.a.d();
                    if (d) {
                        str = this.d;
                    } else {
                        i3 = Math.min(this.a.h.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
                        str = this.e;
                    }
                    String str2 = str;
                    n nVar = this.a;
                    if (nVar.a(nVar.h)) {
                        this.a.g.post(new Runnable(this, i3, j2, str2, d) { // from class: com.kwad.components.ad.splashscreen.b.n.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int a;
                            public final /* synthetic */ long b;
                            public final /* synthetic */ String c;
                            public final /* synthetic */ boolean d;
                            public final /* synthetic */ AnonymousClass2 e;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i3), Long.valueOf(j2), str2, Boolean.valueOf(d)};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.e = this;
                                this.a = i3;
                                this.b = j2;
                                this.c = str2;
                                this.d = d;
                            }

                            @Override // java.lang.Runnable
                            @SuppressLint({"SetTextI18n"})
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    int i4 = (int) (((this.a * 1000) - this.b) / 1000);
                                    if (i4 <= 0) {
                                        i4 = 1;
                                    }
                                    String str3 = this.c + i4;
                                    if (this.d) {
                                        this.e.a.g.setSkipText(str3);
                                    } else {
                                        this.e.a.g.a(str3);
                                    }
                                }
                            }
                        });
                    }
                    float f = ((float) j2) / 1000.0f;
                    if (i3 <= 0 || f + 0.5d <= i3 - 1) {
                        return;
                    }
                    com.kwad.components.ad.splashscreen.h hVar = ((e) this.a).a;
                    if (!hVar.a) {
                        hVar.d();
                    }
                    n nVar2 = this.a;
                    ((e) nVar2).a.a = true;
                    if (this.b || !nVar2.a(nVar2.h)) {
                        return;
                    }
                    ((e) this.a).a.g();
                    this.b = true;
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void b() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.a.c) {
                    return;
                }
                ((e) this.a).a.f();
                com.kwad.components.ad.splashscreen.c.a aVar = ((e) this.a).a.e;
                if (aVar != null) {
                    aVar.a(true);
                    n nVar = this.a;
                    ((e) nVar).a.e.a(nVar.b, true);
                }
                this.a.c = true;
            }

            @Override // com.kwad.components.core.video.g
            public final void c() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    n nVar = this.a;
                    com.kwad.components.ad.splashscreen.c.a aVar = ((e) nVar).a.e;
                    if (aVar != null) {
                        aVar.a(nVar.b, false);
                    }
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void d() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048581, this) == null) || this.b) {
                    return;
                }
                ((e) this.a).a.g();
                this.b = true;
            }

            @Override // com.kwad.components.core.video.g
            public final void e() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void f() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048583, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void g() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void h() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                }
            }
        };
    }

    private void a(SkipView skipView, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, skipView, adInfo) == null) {
            skipView.setTimerBtnVisible(d() ? false : com.kwad.sdk.core.response.a.a.aQ(adInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, adInfo)) == null) ? d() || !com.kwad.sdk.core.response.a.a.aO(adInfo) : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            com.kwad.components.ad.splashscreen.h hVar = ((e) this).a;
            return hVar != null && hVar.b() && com.kwad.components.ad.splashscreen.a.b.g() > 0 && !at.a(com.kwad.components.ad.splashscreen.a.b.c());
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cb  */
    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        com.kwad.components.ad.splashscreen.c.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.h = com.kwad.sdk.core.response.a.d.i(((e) this).a.c);
            ((DetailVideoView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911b3)).setVisibility(0);
            com.kwad.components.ad.splashscreen.c.a aVar2 = ((e) this).a.e;
            if (aVar2 != null) {
                aVar2.a(this.j);
            }
            ((e) this).a.h.a(this);
            this.g = (SkipView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911ab);
            if (a(this.h)) {
                a(this.g, this.h);
            }
            int i = this.h.adSplashInfo.mute;
            boolean z = true;
            if (i != 2) {
                if (i != 3) {
                    this.b = false;
                    if (com.kwad.components.core.l.b.a(u()).a()) {
                        this.b = false;
                    }
                    aVar = ((e) this).a.e;
                    if (aVar != null) {
                        aVar.a(this.b, false);
                        ((e) this).a.e.a(this.i);
                    }
                    ImageView imageView = (ImageView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911b0);
                    this.f = imageView;
                    imageView.setVisibility(0);
                    str = !this.b ? this.h.adSplashInfo.speakerIconUrl : this.h.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.f, str, ((e) this).a.c);
                    } else {
                        this.f.setImageDrawable(u().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c42));
                    }
                    this.f.setSelected(this.b);
                    this.f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.b.n.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ n a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.a = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                n nVar = this.a;
                                nVar.b = !nVar.b;
                                String str2 = this.a.b ? this.a.h.adSplashInfo.speakerIconUrl : this.a.h.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.a.f.setImageDrawable(this.a.u().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c42));
                                } else {
                                    KSImageLoader.loadImage(this.a.f, str2, ((e) this.a).a.c);
                                }
                                this.a.f.setSelected(this.a.b);
                                n nVar2 = this.a;
                                ((e) nVar2).a.e.a(nVar2.b, true);
                            }
                        }
                    });
                } else if (com.kwad.sdk.utils.j.d(((e) this).a.d.getContext()) <= 0) {
                    z = false;
                }
            }
            this.b = z;
            if (com.kwad.components.core.l.b.a(u()).a()) {
            }
            aVar = ((e) this).a.e;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) ((e) this).a.d.findViewById(R.id.obfuscated_res_0x7f0911b0);
            this.f = imageView2;
            imageView2.setVisibility(0);
            if (!this.b) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.f.setSelected(this.b);
            this.f.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.b.n.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ n a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = objArr;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        n nVar = this.a;
                        nVar.b = !nVar.b;
                        String str2 = this.a.b ? this.a.h.adSplashInfo.speakerIconUrl : this.a.h.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.a.f.setImageDrawable(this.a.u().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c42));
                        } else {
                            KSImageLoader.loadImage(this.a.f, str2, ((e) this.a).a.c);
                        }
                        this.a.f.setSelected(this.a.b);
                        n nVar2 = this.a;
                        ((e) nVar2).a.e.a(nVar2.b, true);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void b() {
        com.kwad.components.ad.splashscreen.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = ((e) this).a.e) == null) {
            return;
        }
        aVar.g();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void e_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.e_();
            this.e = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void k_() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.k_();
            com.kwad.components.ad.splashscreen.c.a aVar = ((e) this).a.e;
            if (aVar != null) {
                aVar.b(this.j);
                ((e) this).a.e.b(this.i);
            }
            if (this.g.getHandler() != null) {
                this.g.getHandler().removeCallbacksAndMessages(null);
            }
            ((e) this).a.h.b(this);
        }
    }

    @Override // com.kwad.sdk.core.g.b
    public final void m_() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.d) {
            return;
        }
        this.d = true;
        com.kwad.components.ad.splashscreen.local.c.a(u());
        com.kwad.components.core.l.c.a().a(((e) this).a.c, null, null);
    }
}
