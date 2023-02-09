package com.kwad.components.ad.reward.k;

import android.animation.Animator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.widget.KSRatingBar;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class n extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public TextView eQ;
    public TextView iu;
    public AdTemplate mAdTemplate;
    public DetailVideoView mj;
    public ImageView nC;
    public com.kwad.components.ad.reward.k nM;
    public ViewGroup pV;
    public int qC;
    public ViewGroup vM;
    public KSRatingBar vN;
    public TextView vO;
    public KsStyledTextButton vP;
    public TextView vQ;
    public ViewStub vk;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String kY;
        public String np;
        public String title;
        public float vS;
        public String vT;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static a m(AdInfo adInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adInfo)) == null) {
                if (adInfo == null) {
                    return null;
                }
                a aVar = new a();
                aVar.title = com.kwad.sdk.core.response.a.a.bl(adInfo);
                aVar.np = com.kwad.sdk.core.response.a.a.ad(adInfo);
                aVar.kY = com.kwad.sdk.core.response.a.a.bn(adInfo);
                aVar.vS = com.kwad.sdk.core.response.a.a.aj(adInfo);
                aVar.vT = com.kwad.sdk.core.response.a.a.ah(adInfo);
                return aVar;
            }
            return (a) invokeL.objValue;
        }

        public final String eL() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.kY : (String) invokeV.objValue;
        }

        public final String fO() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.np : (String) invokeV.objValue;
        }

        public final float getRating() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.vS : invokeV.floatValue;
        }

        public final String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.title : (String) invokeV.objValue;
        }

        public final String ja() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.vT : (String) invokeV.objValue;
        }
    }

    public n(AdTemplate adTemplate, com.kwad.components.ad.reward.k kVar, ViewGroup viewGroup, DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, kVar, viewGroup, detailVideoView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.qC = Integer.MIN_VALUE;
        this.mAdTemplate = adTemplate;
        this.pV = viewGroup;
        this.nM = kVar;
        this.mj = detailVideoView;
    }

    public n(AdTemplate adTemplate, com.kwad.components.ad.reward.k kVar, ViewStub viewStub, DetailVideoView detailVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {adTemplate, kVar, viewStub, detailVideoView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.qC = Integer.MIN_VALUE;
        this.mAdTemplate = adTemplate;
        this.vk = viewStub;
        this.nM = kVar;
        this.mj = detailVideoView;
    }

    private void iZ() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (viewGroup = this.vM) == null) {
            return;
        }
        boolean cB = ag.cB(viewGroup.getContext());
        if (this.vM.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.vM.getLayoutParams();
            if (cB) {
                int dimensionPixelSize = this.vM.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070392);
                layoutParams.width = -1;
                layoutParams.height = dimensionPixelSize;
            } else {
                layoutParams.width = com.kwad.sdk.b.kwai.a.getScreenWidth(this.vM.getContext()) / 2;
                layoutParams.height = -1;
            }
            this.vM.setLayoutParams(layoutParams);
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.vM = (ViewGroup) this.pV.findViewById(R.id.obfuscated_res_0x7f091209);
            this.bq = (KsLogoView) this.pV.findViewById(R.id.obfuscated_res_0x7f09120d);
            this.nC = (ImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f09120c);
            this.eQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091210);
            this.vN = (KSRatingBar) this.pV.findViewById(R.id.obfuscated_res_0x7f09120f);
            this.vO = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09120a);
            this.iu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f09120b);
            this.vP = (KsStyledTextButton) this.pV.findViewById(R.id.obfuscated_res_0x7f091208);
            this.vQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091207);
            this.vM.setOnClickListener(this);
            this.vQ.setOnClickListener(this);
            this.vP.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, view2) == null) || view2 == null || view2.getWidth() == 0) {
            return;
        }
        if (ag.cB(view2.getContext())) {
            view2.setVisibility(0);
            Animator a2 = r.a(this.mAdTemplate, this.vM, this.mj);
            if (a2 != null) {
                a2.start();
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = -view2.getWidth();
            this.vM.setLayoutParams(marginLayoutParams);
            Animator a3 = r.a(this.mAdTemplate, this.mj, view2);
            view2.setVisibility(0);
            if (a3 != null) {
                a3.start();
            }
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uVar) == null) {
            super.a(uVar);
            AdTemplate adTemplate = uVar.getAdTemplate();
            this.bq.T(adTemplate);
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            a m = a.m(bQ);
            this.eQ.setText(m.getTitle());
            this.vO.setText(m.ja());
            this.iu.setText(m.fO());
            this.vP.setText(com.kwad.sdk.core.response.a.a.al(bQ));
            boolean am = com.kwad.sdk.core.response.a.a.am(bQ);
            boolean cB = ag.cB(this.vM.getContext());
            Resources resources = this.vM.getResources();
            ViewGroup.LayoutParams layoutParams = this.nC.getLayoutParams();
            int i = 18;
            if (layoutParams != null) {
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070393);
                if (!cB) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070395);
                    i = 14;
                } else if (am) {
                    dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070394);
                    i = 24;
                }
                layoutParams.width = dimensionPixelSize;
                layoutParams.height = dimensionPixelSize;
                this.nC.setLayoutParams(layoutParams);
            }
            KSImageLoader.loadAppIcon(this.nC, m.eL(), adTemplate, i);
            if (cB && am) {
                if (m.getRating() < 0.0f) {
                    this.vN.setVisibility(8);
                } else {
                    this.vN.setVisibility(0);
                    this.vN.setStar(m.getRating());
                }
                if (m.ja() == null) {
                    this.vO.setVisibility(8);
                } else {
                    this.vO.setVisibility(0);
                    this.vO.setText(m.ja());
                }
            }
            if (am) {
                return;
            }
            this.vO.setVisibility(8);
            this.vN.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void aa(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            Resources resources = this.vM.getResources();
            ViewGroup.LayoutParams layoutParams = this.vM.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (z) {
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = fR().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070390);
                }
                this.vM.setBackgroundColor(-1);
                this.eQ.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060782));
                this.iu.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06077e));
                this.qC = com.kwad.sdk.b.kwai.a.A(this.mj);
                com.kwad.sdk.b.kwai.a.i(this.mj, 49);
            } else {
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = 0;
                }
                this.eQ.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060783));
                this.iu.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f06077f));
                this.vM.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060780));
            }
            if (marginLayoutParams != null) {
                this.vM.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final void bt() {
        DetailVideoView detailVideoView;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (detailVideoView = this.mj) == null || (i = this.qC) == Integer.MIN_VALUE) {
            return;
        }
        com.kwad.sdk.b.kwai.a.i(detailVideoView, i);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.pV : (ViewGroup) invokeV.objValue;
    }

    public final void hide() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (viewGroup = this.pV) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            if (view2.equals(this.vQ)) {
                this.nM.fu();
                com.kwad.sdk.core.report.a.r(this.mAdTemplate, 164);
            } else if (view2.equals(this.vM)) {
                this.nM.a(view2.getContext(), 2, 2);
            } else if (view2.equals(this.vP)) {
                this.nM.a(view2.getContext(), 2, 1);
            }
        }
    }

    public final void show() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.pV == null && (viewStub = this.vk) != null) {
                this.pV = (ViewGroup) viewStub.inflate();
                initView();
            }
            if (this.bq == null) {
                initView();
            }
            if (this.pV != null) {
                iZ();
                this.pV.setVisibility(0);
                this.pV.post(new Runnable(this) { // from class: com.kwad.components.ad.reward.k.n.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ n vR;

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
                        this.vR = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            n nVar = this.vR;
                            nVar.p(nVar.vM);
                        }
                    }
                });
                u.b bVar = new u.b();
                bVar.aca = 205;
                com.kwad.sdk.core.report.a.a(this.mAdTemplate, 164, bVar, (JSONObject) null);
            }
        }
    }
}
