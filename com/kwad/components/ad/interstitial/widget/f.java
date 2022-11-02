package com.kwad.components.ad.interstitial.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes7.dex */
public final class f extends KSFrameLayout implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsLogoView bq;
    public ImageView cw;
    public KSFrameLayout dN;
    public TextView dh;

    /* renamed from: do  reason: not valid java name */
    public ImageView f9do;
    public KSFrameLayout hn;
    public String iD;
    @Nullable
    public View iE;
    public ImageView iF;
    public TextProgressBar iG;
    public ViewGroup iH;
    public ViewGroup iI;
    public ImageView iJ;
    public View iK;
    public View iL;
    public TextView iM;
    public ImageView iN;
    public TextView iO;
    public TextView iP;
    public TextView iQ;
    public TextProgressBar iR;
    public TextView iS;
    public i iT;
    public final a iU;
    public boolean iV;
    public AdTemplate mAdTemplate;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean iX;
        public boolean iY;
        public int iZ;
        public boolean ja;

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
                    return;
                }
            }
            this.iX = false;
            this.iY = false;
            this.iZ = 0;
            this.ja = true;
        }

        public final void E(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.iZ = i;
            }
        }

        public final int ee() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.iZ : invokeV.intValue;
        }

        public final boolean ef() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.ja : invokeV.booleanValue;
        }

        public final void v(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.iX = z;
            }
        }

        public final void w(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.iY = z;
            }
        }

        public final void x(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
                this.ja = z;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NonNull Context context, a aVar) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.iD = "%s秒后进入试玩页";
        this.iV = false;
        this.iU = aVar;
        FrameLayout.inflate(context, aVar.ef() ? R.layout.obfuscated_res_0x7f0d0440 : R.layout.obfuscated_res_0x7f0d043f, this);
        s(this.iU.iX);
    }

    private void a(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, this, view2, i) == null) {
            com.kwad.sdk.b.kwai.a.b(view2, 0, com.kwad.sdk.b.kwai.a.a(getContext(), i), 0, 0);
        }
    }

    private void a(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65539, this, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = com.kwad.sdk.b.kwai.a.a(getContext(), i);
            layoutParams.height = com.kwad.sdk.b.kwai.a.a(getContext(), i2);
            view2.setLayoutParams(layoutParams);
        }
    }

    private void a(KSFrameLayout kSFrameLayout, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, kSFrameLayout, z) == null) {
            kSFrameLayout.setClickable(true);
            new com.kwad.sdk.widget.f(kSFrameLayout, this);
            this.dN.setWidthBasedRatio(!z);
        }
    }

    private void b(View view2, boolean z) {
        i iVar;
        i iVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65542, this, view2, z) == null) {
            i iVar3 = this.iT;
            if (iVar3 != null) {
                iVar3.p(z);
                this.iT.a(this.hn);
            }
            if (view2.equals(this)) {
                i iVar4 = this.iT;
                if (iVar4 != null) {
                    iVar4.di();
                }
            } else if (view2.equals(this.iK)) {
                if (!(1 == this.iU.ee()) || (iVar2 = this.iT) == null) {
                    return;
                }
                iVar2.dh();
            } else if (view2.equals(this.iR)) {
                i iVar5 = this.iT;
                if (iVar5 != null) {
                    iVar5.dj();
                }
            } else if (view2.equals(this.iI)) {
                i iVar6 = this.iT;
                if (iVar6 != null) {
                    iVar6.du();
                }
            } else if (view2.equals(this.iG)) {
                i iVar7 = this.iT;
                if (iVar7 != null) {
                    iVar7.dk();
                }
            } else if (view2.equals(this.iL)) {
                i iVar8 = this.iT;
                if (iVar8 != null) {
                    iVar8.dn();
                }
            } else if (view2.equals(this.dN)) {
                i iVar9 = this.iT;
                if (iVar9 != null) {
                    iVar9.dl();
                }
            } else if (view2.equals(this.f9do)) {
                i iVar10 = this.iT;
                if (iVar10 != null) {
                    iVar10.dm();
                }
            } else if (view2.equals(this.cw)) {
                i iVar11 = this.iT;
                if (iVar11 != null) {
                    iVar11.mo81do();
                }
            } else if (view2.equals(this.iO)) {
                i iVar12 = this.iT;
                if (iVar12 != null) {
                    iVar12.dp();
                }
            } else if (view2.equals(this.dh)) {
                i iVar13 = this.iT;
                if (iVar13 != null) {
                    iVar13.dq();
                }
            } else if (view2.equals(this.iN)) {
                i iVar14 = this.iT;
                if (iVar14 != null) {
                    iVar14.dr();
                }
            } else if (view2.equals(this.iP)) {
                i iVar15 = this.iT;
                if (iVar15 != null) {
                    iVar15.ds();
                }
            } else if (!view2.equals(this.iQ) || (iVar = this.iT) == null) {
            } else {
                iVar.dt();
            }
        }
    }

    private void dY() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            a(this.iN, 40, 40);
            a(this.iR, 130, 30);
            this.iP.setTextSize(14.0f);
            a(this.iR, 11);
            a(this.iP, 7);
            a(this.iQ, 7);
        }
    }

    private void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            setClickable(true);
            this.hn = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f091109);
            this.dN = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f09110a);
            this.iE = findViewById(R.id.obfuscated_res_0x7f0910fe);
            this.iF = (ImageView) findViewById(R.id.obfuscated_res_0x7f09110e);
            this.f9do = (ImageView) findViewById(R.id.obfuscated_res_0x7f091253);
            this.bq = (KsLogoView) findViewById(R.id.obfuscated_res_0x7f091080);
            this.iH = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09110d);
            this.iI = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f09110b);
            this.iG = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f0910fd);
            this.iK = findViewById(R.id.obfuscated_res_0x7f0910fa);
            TextProgressBar textProgressBar = this.iG;
            if (textProgressBar != null) {
                textProgressBar.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), 10.0f));
                this.iG.setTextColor(-1);
            }
            this.iJ = (ImageView) findViewById(R.id.obfuscated_res_0x7f091106);
            this.iM = (TextView) findViewById(R.id.obfuscated_res_0x7f0910fb);
            this.iN = (ImageView) findViewById(R.id.obfuscated_res_0x7f091105);
            this.iP = (TextView) findViewById(R.id.obfuscated_res_0x7f091107);
            this.iQ = (TextView) findViewById(R.id.obfuscated_res_0x7f0910fc);
            this.iR = (TextProgressBar) findViewById(R.id.obfuscated_res_0x7f09108e);
            this.iL = findViewById(R.id.obfuscated_res_0x7f091079);
            this.cw = (ImageView) findViewById(R.id.obfuscated_res_0x7f091090);
            this.iO = (TextView) findViewById(R.id.obfuscated_res_0x7f091094);
            this.dh = (TextView) findViewById(R.id.obfuscated_res_0x7f09108c);
            new com.kwad.sdk.widget.f(this, this);
            new com.kwad.sdk.widget.f(this.f9do, this);
            new com.kwad.sdk.widget.f(this.iG, this);
            new com.kwad.sdk.widget.f(this.iR, this);
            new com.kwad.sdk.widget.f(this.iK, this);
            new com.kwad.sdk.widget.f(this.iI, this);
            new com.kwad.sdk.widget.f(this.iM, this);
            new com.kwad.sdk.widget.f(this.iL, this);
            new com.kwad.sdk.widget.f(this.cw, this);
            new com.kwad.sdk.widget.f(this.iO, this);
            new com.kwad.sdk.widget.f(this.dh, this);
            new com.kwad.sdk.widget.f(this.iN, this);
            new com.kwad.sdk.widget.f(this.iP, this);
            new com.kwad.sdk.widget.f(this.iQ, this);
            this.iJ.setOnClickListener(new View.OnClickListener(this) { // from class: com.kwad.components.ad.interstitial.widget.f.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ f iW;

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
                    this.iW = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.iW.iJ.setSelected(!this.iW.iJ.isSelected());
                        if (this.iW.iT != null) {
                            this.iW.iT.o(this.iW.iJ.isSelected());
                        }
                    }
                }
            });
            this.iS = (TextView) findViewById(R.id.obfuscated_res_0x7f09110c);
            a(this.dN, z);
            if (ag.zL()) {
                return;
            }
            dY();
        }
    }

    public final void B(String str) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (textView = this.iM) == null) {
            return;
        }
        if (str != null) {
            textView.setText(str);
        }
        if (!this.iU.iY || this.iV || this.iM.getVisibility() == 0) {
            return;
        }
        this.iM.setVisibility(0);
    }

    public final void a(float f, com.kwad.sdk.core.video.videoview.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), aVar}) == null) {
            this.dN.setRatio(f);
            this.dN.addView(aVar);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aVar.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 17;
            aVar.setLayoutParams(layoutParams);
        }
    }

    public final void a(AdTemplate adTemplate, AdInfo adInfo) {
        TextView textView;
        String bl;
        TextProgressBar textProgressBar;
        String al;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, adTemplate, adInfo) == null) {
            this.iN.setImageResource(R.drawable.obfuscated_res_0x7f080c32);
            if (com.kwad.sdk.core.response.a.a.bD(adInfo)) {
                KSImageLoader.loadCircleIcon(this.iN, com.kwad.sdk.core.response.a.a.bI(adInfo), getContext().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080c32));
                this.iP.setText(com.kwad.sdk.core.response.a.a.bm(adInfo));
                this.iQ.setText(com.kwad.sdk.core.response.a.a.ad(adInfo));
                if (com.kwad.sdk.core.response.a.a.bE(adInfo)) {
                    textProgressBar = this.iR;
                    al = com.kwad.components.ad.c.b.ah();
                } else {
                    textProgressBar = this.iR;
                    al = com.kwad.components.ad.c.b.ak();
                }
            } else if (com.kwad.components.ad.interstitial.kwai.b.c(adInfo)) {
                AdProductInfo bN = com.kwad.sdk.core.response.a.a.bN(adInfo);
                KSImageLoader.loadWithRadius(this.iN, bN.icon, adTemplate, 4);
                this.iP.setText(bN.name);
                this.iQ.setVisibility(8);
                textProgressBar = this.iR;
                al = com.kwad.components.ad.c.b.ai();
            } else {
                if (com.kwad.sdk.core.response.a.a.am(adInfo)) {
                    KSImageLoader.loadWithRadius(this.iN, com.kwad.sdk.core.response.a.a.bn(adInfo), adTemplate, 4);
                    textView = this.iP;
                    bl = com.kwad.sdk.core.response.a.a.ae(adInfo);
                } else {
                    KSImageLoader.loadWithRadius(this.iN, com.kwad.sdk.core.response.a.d.bU(adTemplate), adTemplate, 4);
                    textView = this.iP;
                    bl = com.kwad.sdk.core.response.a.a.bl(adInfo);
                }
                textView.setText(bl);
                this.iQ.setText(com.kwad.sdk.core.response.a.a.ad(adInfo));
                textProgressBar = this.iR;
                al = com.kwad.sdk.core.response.a.a.al(adInfo);
            }
            textProgressBar.f(al, 0);
        }
    }

    public final void a(String str, AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, adTemplate) == null) || ax.dT(str)) {
            return;
        }
        this.f9do.setImageDrawable(null);
        KSImageLoader.loadImage(this.f9do, str, adTemplate);
    }

    public final void b(boolean z, int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) || (textView = this.iS) == null) {
            return;
        }
        textView.setVisibility(0);
        if (i >= 0) {
            this.iS.setText(String.format(this.iD, String.valueOf(i)));
        }
    }

    public final void b(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f9do == null) {
            return;
        }
        this.f9do.setVisibility(z ? 0 : 8);
        this.f9do.setClickable(z2);
    }

    public final void dZ() {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (textView = this.iM) == null) {
            return;
        }
        textView.setVisibility(8);
        this.iV = true;
    }

    public final void ea() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (view2 = this.iK) == null) {
            return;
        }
        view2.setVisibility(8);
    }

    public final void eb() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            t(false);
            this.iI.setVisibility(0);
            this.iF.setVisibility(0);
        }
    }

    public final void ec() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.iI.setVisibility(8);
            this.iF.setVisibility(8);
            t(true);
        }
    }

    public final boolean ed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ViewGroup viewGroup = this.iI;
            return viewGroup != null && viewGroup.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void f(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.width = i;
            marginLayoutParams.height = i2;
            setLayoutParams(marginLayoutParams);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            b(view2, true);
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, view2) == null) && com.kwad.sdk.core.response.a.c.bF(this.mAdTemplate)) {
            b(view2, false);
        }
    }

    public final void g(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            TextProgressBar textProgressBar = this.iG;
            if (textProgressBar != null) {
                textProgressBar.f(str, 0);
            }
            TextProgressBar textProgressBar2 = this.iR;
            if (textProgressBar2 != null) {
                textProgressBar2.f(str, 0);
            }
        }
    }

    @Nullable
    public final View getBlurBgView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.iE : (View) invokeV.objValue;
    }

    public final ImageView getTailFrameView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.iF : (ImageView) invokeV.objValue;
    }

    public final void i(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, adTemplate) == null) {
            this.bq.T(adTemplate);
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, adTemplate) == null) {
            this.mAdTemplate = adTemplate;
        }
    }

    public final void setViewListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, iVar) == null) {
            this.iT = iVar;
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || this.iH == null) {
            return;
        }
        this.iH.setVisibility(z ? 0 : 8);
    }

    public final void u(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (imageView = this.iJ) == null) {
            return;
        }
        imageView.setSelected(z);
    }
}
