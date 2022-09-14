package com.kwad.components.ad.reward.k;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.l;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public final class i extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdTemplate adTemplate;
    public TextView eQ;
    public KSCornerImageView it;
    public TextView iu;
    public View kP;
    public l.a nf;
    public ViewGroup pV;
    public DialogFragment vf;
    public TextView vg;
    public View vh;
    public View vi;
    public View vj;

    public i(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dialogFragment, adTemplate, layoutInflater, viewGroup, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vf = dialogFragment;
        this.adTemplate = adTemplate;
        this.nf = aVar;
        this.pV = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d045a, viewGroup, false);
        initView();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.it = (KSCornerImageView) this.pV.findViewById(R.id.obfuscated_res_0x7f091175);
            this.eQ = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091177);
            this.iu = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091173);
            this.vg = (TextView) this.pV.findViewById(R.id.obfuscated_res_0x7f091176);
            this.vh = this.pV.findViewById(R.id.obfuscated_res_0x7f091174);
            this.kP = this.pV.findViewById(R.id.obfuscated_res_0x7f091170);
            this.vi = this.pV.findViewById(R.id.obfuscated_res_0x7f091172);
            this.vj = this.pV.findViewById(R.id.obfuscated_res_0x7f091171);
            this.kP.setOnClickListener(this);
            this.vi.setOnClickListener(this);
            this.vj.setOnClickListener(this);
            this.it.setOnClickListener(this);
            this.eQ.setOnClickListener(this);
            this.iu.setOnClickListener(this);
            this.vh.setOnClickListener(this);
        }
    }

    public final void a(l.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            KSImageLoader.loadAppIcon(this.it, cVar.eL(), this.adTemplate, 4);
            this.eQ.setText(cVar.getTitle());
            this.iu.setText(cVar.fO());
            this.vg.setText(cVar.fP());
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pV : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        l.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.equals(this.kP)) {
                this.vf.dismiss();
                l.a aVar2 = this.nf;
                if (aVar2 != null) {
                    aVar2.fI();
                }
            } else if (view2.equals(this.vi)) {
                this.vf.dismiss();
                l.a aVar3 = this.nf;
                if (aVar3 != null) {
                    aVar3.G(false);
                }
            } else if (view2.equals(this.vj)) {
                this.vf.dismiss();
                l.a aVar4 = this.nf;
                if (aVar4 != null) {
                    aVar4.fI();
                }
            } else if (view2.equals(this.it)) {
                l.a aVar5 = this.nf;
                if (aVar5 != null) {
                    aVar5.g(127, 2);
                }
            } else if (view2.equals(this.eQ)) {
                l.a aVar6 = this.nf;
                if (aVar6 != null) {
                    aVar6.g(128, 2);
                }
            } else if (view2.equals(this.iu)) {
                l.a aVar7 = this.nf;
                if (aVar7 != null) {
                    aVar7.g(129, 2);
                }
            } else if (!view2.equals(this.vh) || (aVar = this.nf) == null) {
            } else {
                aVar.g(131, 2);
            }
        }
    }
}
