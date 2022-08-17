package com.kwad.components.ad.interstitial.b.kwai;

import android.app.Dialog;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.b.a.h;
import com.kwad.components.core.webview.b.a.r;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bd;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b extends a {
    public static /* synthetic */ Interceptable $ic = null;
    public static long gO = 400;
    public transient /* synthetic */ FieldHolder $fh;
    public com.kwad.sdk.core.h.b bX;
    public aa dP;
    public d eN;
    public Vibrator eO;
    @Nullable
    public com.kwad.components.ad.f.kwai.kwai.b gY;
    public FrameLayout hP;
    public boolean hQ;
    public boolean hR;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2047986429, "Lcom/kwad/components/ad/interstitial/b/kwai/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2047986429, "Lcom/kwad/components/ad/interstitial/b/kwai/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hQ = false;
        this.bX = new c(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b hS;

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
                this.hS = this;
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aR() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.hS.dP != null && !this.hS.hQ) {
                        this.hS.hQ = true;
                        this.hS.dP.py();
                        this.hS.dP.pz();
                    }
                    if (this.hS.dP != null) {
                        this.hS.dP.pC();
                    }
                    if (this.hS.gY != null) {
                        this.hS.gY.eB();
                    }
                    if (this.hS.hR || this.hS.gh.gn || this.hS.gh.fo == null) {
                        return;
                    }
                    this.hS.gh.fo.onAdShow();
                    com.kwad.components.ad.interstitial.monitor.b.cr().a(this.hS.gh.mAdTemplate, 3);
                    this.hS.hR = true;
                }
            }

            @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
            public final void aS() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    if (this.hS.dP != null) {
                        this.hS.dP.pD();
                    }
                    if (this.hS.gY != null) {
                        this.hS.gY.eA();
                    }
                }
            }
        };
    }

    @NonNull
    private f a(com.kwad.sdk.core.webview.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65562, this, bVar)) == null) ? new f(bVar, this.gh.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b hS;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.hS = this;
            }

            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || aVar == null) {
                    return;
                }
                if (!this.hS.gh.gn && this.hS.gh.fo != null) {
                    this.hS.gh.fo.onAdClicked();
                }
                this.hS.gh.gl = true;
                if (!this.hS.gh.gn) {
                    this.hS.gh.cy();
                }
                if (this.hS.gh.gi == null || !com.kwad.components.ad.interstitial.kwai.b.co()) {
                    return;
                }
                this.hS.gh.gi.dismiss();
            }
        }) : (f) invokeL.objValue;
    }

    public static void b(AdTemplate adTemplate, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65565, null, adTemplate, z) == null) {
            com.kwad.sdk.core.report.a.a(adTemplate, 14, -1L, -1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65569, this, new Object[]{Double.valueOf(d)}) == null) {
            this.gh.a(new c.b(getContext()).m(true).b(d).y(2).a(this.gh.gq.getTouchCoords()).z(Cea708Decoder.COMMAND_DF5));
            if (this.eO == null || aj.Y(getContext(), "android.permission.VIBRATE") != 0) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                this.eO.vibrate(VibrationEffect.createOneShot(gO, -1));
            } else {
                this.eO.vibrate(gO);
            }
        }
    }

    private com.kwad.components.core.webview.b.kwai.d cM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            h hVar = new h();
            hVar.NQ = this.gh.gx;
            return new com.kwad.components.core.webview.b.kwai.d(hVar);
        }
        return (com.kwad.components.core.webview.b.kwai.d) invokeV.objValue;
    }

    private com.kwad.components.ad.f.kwai.kwai.a cP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) {
            com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
            this.gh.gs.add(new c.InterfaceC0318c(this, aVar) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b hS;
                public final /* synthetic */ com.kwad.components.ad.f.kwai.kwai.a hd;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.hS = this;
                    this.hd = aVar;
                }

                @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0318c
                public final void cH() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.hd.ey();
                    }
                }
            });
            return aVar;
        }
        return (com.kwad.components.ad.f.kwai.kwai.a) invokeV.objValue;
    }

    private ah cV() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            ah ahVar = new ah(getContext(), this.gh.mAdTemplate);
            ahVar.a(new ah.a(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b hS;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.hS = this;
                }

                @Override // com.kwad.components.core.webview.jshandler.ah.a
                public final boolean dc() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048576, this)) == null) {
                        com.kwad.components.core.page.a.launch(this.hS.getContext(), this.hS.gh.mAdTemplate);
                        this.hS.gh.a(true, -1, (com.kwad.sdk.core.video.videoview.a) null);
                        bd.runOnUiThreadDelay(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.8.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass8 hU;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.hU = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    this.hU.hS.cY();
                                }
                            }
                        }, 0L);
                        return false;
                    }
                    return invokeV2.booleanValue;
                }
            });
            return ahVar;
        }
        return (ah) invokeV.objValue;
    }

    @NonNull
    private q cW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) ? new q(new q.b(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b hS;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.hS = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(q.a aVar) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, aVar) == null) || this.hS.gh.gi == null) {
                    return;
                }
                this.hS.gh.gq.post(new Runnable(this, aVar) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.10.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AnonymousClass10 hX;
                    public final /* synthetic */ q.a hg;

                    {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable3.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable3.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hX = this;
                        this.hg = aVar;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable3 = $ic;
                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                            if (this.hg.type == 0 && !this.hX.hS.gh.gl && !this.hX.hS.gh.gm && com.kwad.components.ad.interstitial.c.a.c(this.hX.hS.gh)) {
                                this.hX.hS.gh.gm = true;
                                com.kwad.components.ad.interstitial.a.b.J(this.hX.hS.getContext());
                                return;
                            }
                            this.hX.hS.dJ();
                            this.hX.hS.gh.gi.dismiss();
                            this.hX.hS.gh.a(this.hg.type == 3, this.hg.Mh, (com.kwad.sdk.core.video.videoview.a) null);
                            if (this.hX.hS.gh.fo != null) {
                                this.hX.hS.gh.fo.onAdClosed();
                            }
                        }
                    }
                });
            }
        }) : (q) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY() {
        com.kwad.components.ad.interstitial.b.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65574, this) == null) || (cVar = this.gh) == null) {
            return;
        }
        Dialog dialog = cVar.gi;
        if (dialog != null) {
            dialog.dismiss();
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.gh.fo;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @NonNull
    private com.kwad.components.core.webview.b.kwai.h dG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) ? new com.kwad.components.core.webview.b.kwai.h(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b hS;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.hS = this;
            }

            @Override // com.kwad.components.core.webview.b.kwai.e, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                    super.a(str, cVar);
                    bd.runOnUiThreadDelay(new Runnable(this, cVar) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.9.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ com.kwad.sdk.core.webview.kwai.c hV;
                        public final /* synthetic */ AnonymousClass9 hW;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cVar};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.hW = this;
                            this.hV = cVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                com.kwad.components.core.webview.b.a.d dVar = new com.kwad.components.core.webview.b.a.d();
                                dVar.NM = ae.isWifiConnected(this.hW.hS.getContext()) || this.hW.hS.gh.cN.isDataFlowAutoStart() || b.h(this.hW.hS.gh.mAdTemplate);
                                this.hV.a(dVar);
                            }
                        }
                    }, 0L);
                }
            }
        } : (com.kwad.components.core.webview.b.kwai.h) invokeV.objValue;
    }

    private com.kwad.components.core.webview.jshandler.d dH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) ? new com.kwad.components.core.webview.jshandler.d(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b hS;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.hS = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.d, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str, cVar) == null) {
                    super.a(str, cVar);
                    r rVar = new r();
                    try {
                        rVar.parseJson(new JSONObject(str));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.e.b.printStackTrace(e);
                    }
                    bd.runOnUiThread(new Runnable(this, rVar) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.11.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ r hY;
                        public final /* synthetic */ AnonymousClass11 hZ;

                        {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, rVar};
                                interceptable3.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable3.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.hZ = this;
                            this.hY = rVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable3 = $ic;
                            if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                if (TextUtils.equals("start", this.hY.NY)) {
                                    if (this.hZ.hS.gh.gn || this.hZ.hS.gh.fo == null) {
                                        return;
                                    }
                                    this.hZ.hS.gh.fo.onVideoPlayStart();
                                } else if (!TextUtils.equals("end", this.hY.NY) || this.hZ.hS.gh.gn || this.hZ.hS.gh.fo == null) {
                                } else {
                                    this.hZ.hS.gh.fo.onVideoPlayEnd();
                                }
                            }
                        }
                    });
                }
            }
        } : (com.kwad.components.core.webview.jshandler.d) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            aa aaVar = this.dP;
            if (aaVar != null) {
                aaVar.pA();
                this.dP.pB();
            }
            com.kwad.components.ad.f.kwai.kwai.b bVar = this.gY;
            if (bVar != null) {
                bVar.eA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65579, this) == null) {
            if (getContext() != null) {
                this.eO = (Vibrator) getContext().getSystemService("vibrator");
            }
            float bm = com.kwad.sdk.core.response.a.b.bm(this.gh.mAdTemplate);
            if (this.eN == null) {
                d dVar = new d(bm);
                this.eN = dVar;
                dVar.a(new com.kwad.sdk.core.g.b(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b hS;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hS = this;
                    }

                    @Override // com.kwad.sdk.core.g.b
                    public final void a(double d) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Double.valueOf(d)}) == null) {
                            if (com.kwad.sdk.b.kwai.a.g(this.hS.ca(), 100)) {
                                this.hS.c(d);
                            }
                            bd.a(new Runnable(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 hT;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.hT = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.hT.hS.eN.vb();
                                    }
                                }
                            }, null, 500L);
                        }
                    }

                    @Override // com.kwad.sdk.core.g.b
                    public final void bX() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        }
                    }
                });
            }
            this.eN.d(bm);
            this.eN.bz(getContext());
        }
    }

    private w.a getOpenNewPageListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) ? new w.a(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b hS;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.hS = this;
            }

            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                    AdWebViewActivityProxy.launch(this.hS.getContext(), new AdWebViewActivityProxy.a.C0361a().ao(bVar.title).ap(bVar.url).N(this.hS.gh.mAdTemplate).nx());
                }
            }
        } : (w.a) invokeV.objValue;
    }

    public static boolean h(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, adTemplate)) == null) {
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
            return ad != null && ad.exists();
        }
        return invokeL.booleanValue;
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.core.webview.b.e
    public final void a(aa aaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aaVar) == null) {
            super.a(aaVar);
            this.dP = aaVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.core.webview.b.e
    public final void a(com.kwad.sdk.components.h hVar, com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar, bVar) == null) {
            super.a(hVar, bVar);
            com.kwad.components.ad.f.kwai.kwai.b j = com.kwad.components.ad.f.kwai.kwai.b.j(this.gh.mAdTemplate);
            this.gY = j;
            if (j != null) {
                j.a(new b.InterfaceC0309b(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b hS;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hS = this;
                    }

                    @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0309b
                    public final void C(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                            if (i == com.kwad.components.ad.f.kwai.kwai.b.kt) {
                                this.hS.gh.b(this.hS.getContext(), this.hS.gh.mAdTemplate);
                                b.b(this.hS.gh.mAdTemplate, true);
                            }
                            this.hS.cY();
                        }
                    }
                });
                hVar.c(this.gY);
                this.gY.ez();
            }
            hVar.c(cW());
            hVar.c(new w(getOpenNewPageListener()));
            if (com.kwad.sdk.core.response.a.b.bZ(com.kwad.sdk.core.response.a.d.bQ(this.gh.mAdTemplate))) {
                hVar.c(new ab(new ab.a(this) { // from class: com.kwad.components.ad.interstitial.b.kwai.b.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ b hS;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.hS = this;
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ab.a
                    public final void dd() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.hS.db();
                        }
                    }
                }));
            }
            hVar.c(dG());
            hVar.c(cV());
            hVar.c(cM());
            hVar.c(a(bVar));
            hVar.c(dH());
            hVar.c(cP());
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.aq();
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            float aI = com.kwad.sdk.b.kwai.a.aI(getContext());
            aVar.width = (int) ((az.getScreenWidth(getContext()) / aI) + 0.5f);
            aVar.height = (int) ((az.getScreenHeight(getContext()) / aI) + 0.5f);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "ksad-interstitial-card" : (String) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hP : (FrameLayout) invokeV.objValue;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.hP.setVisibility(8);
            com.kwad.components.core.webview.b.d.b bVar = this.gh.gp;
            if (bVar != null) {
                bVar.u(bZ());
            }
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.core.webview.b.e
    public final void dE() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            cY();
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dF() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.dP != null && this.gh.gt.dK()) {
                this.hQ = true;
                this.dP.py();
                this.dP.pz();
            }
            this.gh.gt.a(this.bX);
        }
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onCreate();
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0911eb);
            this.hP = frameLayout;
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onUnbind();
            this.hQ = false;
            this.hR = false;
            if (this.eO != null && aj.Y(getContext(), "android.permission.VIBRATE") == 0) {
                this.eO.cancel();
            }
            d dVar = this.eN;
            if (dVar != null) {
                dVar.bA(getContext());
            }
            com.kwad.components.ad.interstitial.c.b bVar = this.gh.gt;
            if (bVar != null) {
                bVar.b(this.bX);
            }
        }
    }
}
