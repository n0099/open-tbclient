package com.kwad.components.ad.reward.k;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class j extends d implements com.kwad.sdk.widget.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView eQ;
    public KSCornerImageView it;
    public TextView iu;
    public KsPriceView nI;
    public com.kwad.components.ad.reward.k nM;
    public TextView uO;
    public TextView uP;
    public View uQ;
    public ViewStub vk;
    public ViewGroup vl;
    public KsStyledTextButton vm;
    public KsStyledTextButton vn;

    public j(com.kwad.components.ad.reward.k kVar, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vl = viewGroup;
        this.nM = kVar;
    }

    public j(com.kwad.components.ad.reward.k kVar, ViewStub viewStub) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kVar, viewStub};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.vk = viewStub;
        this.nM = kVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, adTemplate, aVar) == null) {
            KSImageLoader.loadAppIcon(this.it, aVar.eL(), adTemplate, 8);
            this.eQ.setText(aVar.getTitle());
            this.iu.setText(aVar.fO());
            int dimensionPixelSize = this.vl.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703cd);
            this.nI.getConfig().ab(dimensionPixelSize).ad(dimensionPixelSize).ac(this.vl.getResources().getColor(R.color.obfuscated_res_0x7f060755));
            this.nI.d(aVar.getPrice(), aVar.getOriginPrice(), true);
            String gy = aVar.gy();
            this.uQ.setVisibility(TextUtils.isEmpty(gy) ? 8 : 0);
            if (gy != null) {
                this.uO.setText(gy);
            }
            this.uP.setText(aVar.gz());
        }
    }

    private void d(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, view2, z) == null) {
            if (view2.equals(this.vn)) {
                this.nM.a(view2.getContext(), z ? 38 : 153, 1);
            } else if (view2.equals(this.vm)) {
                this.nM.a(view2.getContext(), z ? 37 : 153, 1);
            } else if (view2.equals(this.vl)) {
                this.nM.a(view2.getContext(), z ? 2 : 153, 2);
            }
        }
    }

    private void initView() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (viewGroup = this.vl) == null) {
            return;
        }
        this.it = (KSCornerImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091107);
        this.eQ = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f091109);
        this.iu = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f091106);
        this.nI = (KsPriceView) this.vl.findViewById(R.id.obfuscated_res_0x7f091108);
        this.vm = (KsStyledTextButton) this.vl.findViewById(R.id.obfuscated_res_0x7f091103);
        this.vn = (KsStyledTextButton) this.vl.findViewById(R.id.obfuscated_res_0x7f091102);
        this.uO = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f0910f6);
        this.uQ = this.vl.findViewById(R.id.obfuscated_res_0x7f0910f7);
        this.uP = (TextView) this.vl.findViewById(R.id.obfuscated_res_0x7f0910f8);
        new com.kwad.sdk.widget.f(this.vm, this);
        new com.kwad.sdk.widget.f(this.vn, this);
        new com.kwad.sdk.widget.f(this.vl, this);
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uVar) == null) {
            super.a(uVar);
            a(uVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.w(uVar.getAdTemplate()));
        }
    }

    @Override // com.kwad.sdk.widget.c
    public final void f(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            d(view2, true);
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.vl : (ViewGroup) invokeV.objValue;
    }

    @Override // com.kwad.sdk.widget.c
    public final void g(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view2) == null) && com.kwad.sdk.core.response.a.c.bF(this.nM.mAdTemplate)) {
            d(view2, false);
        }
    }

    public final void hide() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (viewGroup = this.vl) == null) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void show() {
        ViewStub viewStub;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.vl == null && (viewStub = this.vk) != null) {
                this.vl = (ViewGroup) viewStub.inflate();
                initView();
            }
            if (this.eQ == null) {
                initView();
            }
            ViewGroup viewGroup = this.vl;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
        }
    }
}
