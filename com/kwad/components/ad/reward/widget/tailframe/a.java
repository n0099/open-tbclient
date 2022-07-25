package com.kwad.components.ad.reward.widget.tailframe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.k;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.c;
import com.kwad.sdk.widget.f;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public TextView cE;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public JSONObject mReportExtData;
    public k nM;
    public View wU;
    public ImageView wV;
    public com.kwad.components.ad.widget.tailframe.appbar.a wW;
    public TailFrameBarH5View wX;
    public b wY;
    public TextProgressBar wZ;
    public View xa;
    public int xb;

    public a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.xb = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        r1 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, view2, z) == null) {
            if (d.p(this.mAdTemplate)) {
                this.nM.a(this.wU.getContext(), z ? 1 : 153, view2 == this.xa ? 1 : 2);
            } else if (com.kwad.sdk.core.response.a.a.am(this.mAdInfo)) {
                com.kwad.components.core.c.a.a.a(new a.C0352a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.wZ).ae(r1).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean rl;
                    public final /* synthetic */ a xc;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.xc = this;
                        this.rl = z;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.xc.wY == null) {
                            return;
                        }
                        this.xc.wY.R(this.rl);
                    }
                }));
            } else {
                com.kwad.components.core.c.a.a.a(new a.C0352a(view2.getContext()).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(view2 == this.wZ).ae(r1).a(new a.b(this, z) { // from class: com.kwad.components.ad.reward.widget.tailframe.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ boolean rl;
                    public final /* synthetic */ a xc;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = objArr;
                            Object[] objArr = {this, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.xc = this;
                        this.rl = z;
                    }

                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.xc.wY == null) {
                            return;
                        }
                        this.xc.wY.R(this.rl);
                    }
                }));
            }
        }
    }

    private void bindDownloadListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mApkDownloadHelper = new com.kwad.components.core.c.a.c(this.mAdTemplate, this.mReportExtData, new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.ad.reward.widget.tailframe.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a xc;

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
                    this.xc = this;
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.xc.wW.u(this.xc.mAdInfo);
                        this.xc.wZ.f(com.kwad.sdk.core.response.a.a.al(this.xc.mAdInfo), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.xc.wW.u(this.xc.mAdInfo);
                        this.xc.wZ.f(com.kwad.sdk.core.response.a.a.aJ(this.xc.mAdTemplate), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.xc.wW.u(this.xc.mAdInfo);
                        this.xc.wZ.f(com.kwad.sdk.core.response.a.a.al(this.xc.mAdInfo), 0);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        this.xc.wW.u(this.xc.mAdInfo);
                        this.xc.wZ.f(com.kwad.sdk.core.response.a.a.P(this.xc.mAdInfo), 0);
                    }
                }

                @Override // com.kwad.sdk.core.download.kwai.a
                public final void onPaused(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                        this.xc.wW.u(this.xc.mAdInfo);
                        this.xc.wZ.f(com.kwad.sdk.core.response.a.a.aX(i), i);
                    }
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                        this.xc.wW.u(this.xc.mAdInfo);
                        this.xc.wZ.f(com.kwad.sdk.core.response.a.a.aW(i), i);
                    }
                }
            });
        }
    }

    private void jh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.wU.setOnClickListener(null);
            this.mApkDownloadHelper = null;
        }
    }

    private void jj() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            if (!com.kwad.sdk.core.response.a.a.am(this.mAdInfo) && !d.p(this.mAdTemplate)) {
                this.wX.c(this.mAdTemplate);
                TextView h5OpenBtn = this.wX.getH5OpenBtn();
                this.cE = h5OpenBtn;
                h5OpenBtn.setClickable(true);
                this.wX.setVisibility(0);
                new f(this.cE, this);
                return;
            }
            this.wW.c(this.mAdTemplate);
            this.wW.setVisibility(0);
            this.wZ = this.wW.getTextProgressBar();
            if (!d.p(this.mAdTemplate)) {
                this.wZ.setClickable(true);
                new f(this.wZ, this);
                bindDownloadListener();
                return;
            }
            View btnInstallContainer = this.wW.getBtnInstallContainer();
            this.xa = btnInstallContainer;
            btnInstallContainer.setClickable(true);
            new f(this.xa, this);
        }
    }

    public void E(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(this.xb, (ViewGroup) null, false);
            this.wU = inflate;
            this.wV = (ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f0911c0);
            this.bq = (KsLogoView) this.wU.findViewById(R.id.obfuscated_res_0x7f0911bd);
            this.wW = (com.kwad.components.ad.widget.tailframe.appbar.a) this.wU.findViewById(R.id.obfuscated_res_0x7f09119a);
            this.wX = (TailFrameBarH5View) this.wU.findViewById(R.id.obfuscated_res_0x7f0911b0);
        }
    }

    public void a(@NonNull AdTemplate adTemplate, JSONObject jSONObject, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adTemplate, jSONObject, bVar) == null) {
            this.mAdTemplate = adTemplate;
            this.mAdInfo = d.bQ(adTemplate);
            this.mReportExtData = jSONObject;
            this.wY = bVar;
            this.bq.T(this.mAdTemplate);
            jj();
            this.wU.setClickable(true);
            new f(this.wU, this);
        }
    }

    public final void d(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.wX.e(z, z2);
        }
    }

    public final void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.wW;
            if (aVar != null) {
                aVar.jl();
                this.wW.setVisibility(8);
            }
            TailFrameBarH5View tailFrameBarH5View = this.wX;
            if (tailFrameBarH5View != null) {
                tailFrameBarH5View.jl();
                this.wX.setVisibility(8);
            }
            jh();
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            b(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    public final void iP() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            com.kwad.components.ad.widget.tailframe.appbar.a aVar = this.wW;
            if (aVar != null) {
                aVar.jl();
            }
            TailFrameBarH5View tailFrameBarH5View = this.wX;
            if (tailFrameBarH5View != null) {
                tailFrameBarH5View.jl();
            }
        }
    }

    public final View ji() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.wU : (View) invokeV.objValue;
    }

    public final void setCallerContext(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, kVar) == null) {
            this.nM = kVar;
        }
    }
}
