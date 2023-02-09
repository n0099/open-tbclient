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
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.h;
/* loaded from: classes8.dex */
public final class n extends e implements com.kwad.sdk.core.h.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h.a dv;
    public ImageView eE;
    public AdInfo mAdInfo;
    public boolean yG;
    public boolean yJ;
    public volatile boolean zu;
    public boolean zv;
    public SkipView zw;
    public com.kwad.components.core.video.g zx;

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
        this.zu = false;
        this.zv = false;
        this.yG = false;
        this.yJ = false;
        this.dv = new h.a(this) { // from class: com.kwad.components.ad.splashscreen.b.n.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ n zy;

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
                this.zy = this;
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.zy.zu = false;
                    if (this.zy.eE != null) {
                        this.zy.eE.post(new Runnable(this) { // from class: com.kwad.components.ad.splashscreen.b.n.1.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass1 zz;

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
                                this.zz = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    n nVar = this.zz.zy;
                                    com.kwad.components.ad.splashscreen.c.a aVar = nVar.yF.yc;
                                    if (aVar != null) {
                                        aVar.c(nVar.zu, false);
                                    }
                                    com.kwad.components.ad.splashscreen.h hVar = this.zz.zy.yF;
                                    if (hVar != null) {
                                        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(hVar.mAdTemplate);
                                        boolean z = this.zz.zy.zu;
                                        AdInfo.AdSplashInfo adSplashInfo = bQ.adSplashInfo;
                                        String str = z ? adSplashInfo.speakerIconUrl : adSplashInfo.speakerMuteIconUrl;
                                        if (TextUtils.isEmpty(str)) {
                                            this.zz.zy.eE.setImageDrawable(this.zz.zy.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf4));
                                        } else {
                                            KSImageLoader.loadImage(this.zz.zy.eE, str, this.zz.zy.yF.mAdTemplate);
                                        }
                                        this.zz.zy.eE.setSelected(false);
                                    }
                                }
                            }
                        });
                    }
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }
        };
        this.zx = new com.kwad.components.core.video.g(this) { // from class: com.kwad.components.ad.splashscreen.b.n.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public boolean zA;
            public int zB;
            public String zC;
            public String zD;
            public final /* synthetic */ n zy;

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
                this.zy = this;
                this.zA = false;
                this.zB = com.kwad.components.ad.splashscreen.a.b.jP();
                this.zC = com.kwad.components.ad.splashscreen.a.b.jL();
                this.zD = com.kwad.components.ad.splashscreen.a.b.jQ();
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlayBufferingPaused() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlayBufferingPlaying() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlayCompleted() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.zA) {
                    return;
                }
                this.zy.yF.jF();
                this.zA = true;
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlayError(int i3, int i4) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeII(1048579, this, i3, i4) == null) || this.zy.yJ) {
                    return;
                }
                com.kwad.components.splash.monitor.a.qG();
                com.kwad.components.splash.monitor.a.d(this.zy.yF.mAdTemplate, i3, String.valueOf(i4));
                this.zy.yF.e(0, "onVideoPlayError");
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlayPaused() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlayProgress(long j, long j2) {
                String str;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                    int i3 = this.zB;
                    boolean jX = this.zy.jX();
                    if (jX) {
                        str = this.zC;
                    } else {
                        i3 = Math.min(this.zy.mAdInfo.adSplashInfo.videoDisplaySecond, ((int) j) / 1000);
                        str = this.zD;
                    }
                    String str2 = str;
                    n nVar = this.zy;
                    if (nVar.p(nVar.mAdInfo)) {
                        this.zy.zw.post(new Runnable(this, i3, j2, str2, jX) { // from class: com.kwad.components.ad.splashscreen.b.n.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ int zE;
                            public final /* synthetic */ long zF;
                            public final /* synthetic */ String zG;
                            public final /* synthetic */ boolean zH;
                            public final /* synthetic */ AnonymousClass2 zI;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                                    newInitContext2.initArgs = r2;
                                    Object[] objArr = {this, Integer.valueOf(i3), Long.valueOf(j2), str2, Boolean.valueOf(jX)};
                                    interceptable3.invokeUnInit(65536, newInitContext2);
                                    int i4 = newInitContext2.flag;
                                    if ((i4 & 1) != 0) {
                                        int i5 = i4 & 2;
                                        newInitContext2.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext2);
                                        return;
                                    }
                                }
                                this.zI = this;
                                this.zE = i3;
                                this.zF = j2;
                                this.zG = str2;
                                this.zH = jX;
                            }

                            @Override // java.lang.Runnable
                            @SuppressLint({"SetTextI18n"})
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    int i4 = (int) (((this.zE * 1000) - this.zF) / 1000);
                                    if (i4 <= 0) {
                                        i4 = 1;
                                    }
                                    String str3 = this.zG + i4;
                                    if (this.zH) {
                                        this.zI.zy.zw.setSkipText(str3);
                                    } else {
                                        this.zI.zy.zw.ac(str3);
                                    }
                                }
                            }
                        });
                    }
                    float f = ((float) j2) / 1000.0f;
                    if (i3 <= 0 || f + 0.5d <= i3 - 1) {
                        return;
                    }
                    com.kwad.components.ad.splashscreen.h hVar = this.zy.yF;
                    if (!hVar.yb) {
                        hVar.jC();
                    }
                    n nVar2 = this.zy;
                    nVar2.yF.yb = true;
                    if (this.zA || !nVar2.p(nVar2.mAdInfo)) {
                        return;
                    }
                    this.zy.yF.jF();
                    this.zA = true;
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlayStart() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    n nVar = this.zy;
                    com.kwad.components.ad.splashscreen.c.a aVar = nVar.yF.yc;
                    if (aVar != null) {
                        aVar.c(nVar.zu, false);
                    }
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPlaying() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048583, this) == null) || this.zy.zv) {
                    return;
                }
                this.zy.yF.jE();
                com.kwad.components.ad.splashscreen.c.a aVar = this.zy.yF.yc;
                if (aVar != null) {
                    aVar.ad(true);
                    n nVar = this.zy;
                    nVar.yF.yc.c(nVar.zu, true);
                }
                n.b(this.zy, true);
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPrepared() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                }
            }

            @Override // com.kwad.components.core.video.g
            public final void onVideoPreparing() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048585, this) == null) {
                }
            }
        };
    }

    private void a(SkipView skipView, AdInfo adInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, skipView, adInfo) == null) {
            skipView.setTimerBtnVisible(jX() ? false : com.kwad.sdk.core.response.a.a.bA(adInfo));
        }
    }

    public static /* synthetic */ boolean b(n nVar, boolean z) {
        nVar.zv = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean jX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            com.kwad.components.ad.splashscreen.h hVar = this.yF;
            return hVar != null && hVar.jz() && com.kwad.components.ad.splashscreen.a.b.jP() > 0 && !ax.dT(com.kwad.components.ad.splashscreen.a.b.jL());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(AdInfo adInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, this, adInfo)) == null) ? jX() || !com.kwad.sdk.core.response.a.a.bx(adInfo) : invokeL.booleanValue;
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aR() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.yG) {
            return;
        }
        this.yG = true;
        com.kwad.components.ad.splashscreen.local.c.V(getContext());
        com.kwad.components.core.m.c.ox().a(this.yF.mAdTemplate, null, null);
    }

    @Override // com.kwad.sdk.core.h.b
    public final void aS() {
        com.kwad.components.ad.splashscreen.c.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.yF.yc) == null) {
            return;
        }
        aVar.pause();
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
    public final void aq() {
        com.kwad.components.ad.splashscreen.c.a aVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
            this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
            ((DetailVideoView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0912f8)).setVisibility(0);
            com.kwad.components.ad.splashscreen.c.a aVar2 = this.yF.yc;
            if (aVar2 != null) {
                aVar2.a(this.zx);
            }
            this.yF.yd.a(this);
            this.zw = (SkipView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0912f0);
            if (p(this.mAdInfo)) {
                a(this.zw, this.mAdInfo);
            }
            int i = this.mAdInfo.adSplashInfo.mute;
            boolean z = true;
            if (i != 2) {
                if (i != 3) {
                    this.zu = false;
                    if (com.kwad.components.core.m.b.at(getContext()).ov()) {
                        this.zu = false;
                    }
                    aVar = this.yF.yc;
                    if (aVar != null) {
                        aVar.c(this.zu, false);
                        this.yF.yc.a(this.dv);
                    }
                    ImageView imageView = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0912f5);
                    this.eE = imageView;
                    imageView.setVisibility(0);
                    str = !this.zu ? this.mAdInfo.adSplashInfo.speakerIconUrl : this.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                    if (TextUtils.isEmpty(str)) {
                        KSImageLoader.loadImage(this.eE, str, this.yF.mAdTemplate);
                    } else {
                        this.eE.setImageDrawable(getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf4));
                    }
                    this.eE.setSelected(this.zu);
                    this.eE.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.b.n.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ n zy;

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
                            this.zy = this;
                        }

                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                n nVar = this.zy;
                                nVar.zu = !nVar.zu;
                                String str2 = this.zy.zu ? this.zy.mAdInfo.adSplashInfo.speakerIconUrl : this.zy.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                                if (TextUtils.isEmpty(str2)) {
                                    this.zy.eE.setImageDrawable(this.zy.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf4));
                                } else {
                                    KSImageLoader.loadImage(this.zy.eE, str2, this.zy.yF.mAdTemplate);
                                }
                                this.zy.eE.setSelected(this.zy.zu);
                                n nVar2 = this.zy;
                                nVar2.yF.yc.c(nVar2.zu, true);
                            }
                        }
                    });
                } else if (com.kwad.sdk.utils.j.cc(this.yF.mRootContainer.getContext()) <= 0) {
                    z = false;
                }
            }
            this.zu = z;
            if (com.kwad.components.core.m.b.at(getContext()).ov()) {
            }
            aVar = this.yF.yc;
            if (aVar != null) {
            }
            ImageView imageView2 = (ImageView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f0912f5);
            this.eE = imageView2;
            imageView2.setVisibility(0);
            if (!this.zu) {
            }
            if (TextUtils.isEmpty(str)) {
            }
            this.eE.setSelected(this.zu);
            this.eE.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.splashscreen.b.n.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ n zy;

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
                    this.zy = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        n nVar = this.zy;
                        nVar.zu = !nVar.zu;
                        String str2 = this.zy.zu ? this.zy.mAdInfo.adSplashInfo.speakerIconUrl : this.zy.mAdInfo.adSplashInfo.speakerMuteIconUrl;
                        if (TextUtils.isEmpty(str2)) {
                            this.zy.eE.setImageDrawable(this.zy.getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080cf4));
                        } else {
                            KSImageLoader.loadImage(this.zy.eE, str2, this.zy.yF.mAdTemplate);
                        }
                        this.zy.eE.setSelected(this.zy.zu);
                        n nVar2 = this.zy;
                        nVar2.yF.yc.c(nVar2.zu, true);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.yJ = true;
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onUnbind();
            com.kwad.components.ad.splashscreen.c.a aVar = this.yF.yc;
            if (aVar != null) {
                aVar.b(this.zx);
                this.yF.yc.b(this.dv);
            }
            if (this.zw.getHandler() != null) {
                this.zw.getHandler().removeCallbacksAndMessages(null);
            }
            this.yF.yd.b(this);
        }
    }
}
