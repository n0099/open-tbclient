package com.kwad.components.ad.reward.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.widget.KsStyledTextButton;
/* loaded from: classes7.dex */
public final class o extends d implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public KsStyledTextButton vU;
    public View vV;
    public com.kwad.components.ad.reward.g.b vW;
    public ViewGroup vl;

    public o(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {layoutInflater, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.vl = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0443, viewGroup, false);
        initView();
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            this.vU = (KsStyledTextButton) this.vl.findViewById(R.id.obfuscated_res_0x7f091103);
            this.vV = this.vl.findViewById(R.id.obfuscated_res_0x7f091104);
            this.vU.setOnClickListener(this);
            this.vV.setOnClickListener(this);
        }
    }

    public final void b(com.kwad.components.ad.reward.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.vW = bVar;
        }
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup fR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.vl : (ViewGroup) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) || this.vW == null) {
            return;
        }
        if (view2.equals(this.vU)) {
            this.vW.onPlayAgainClick();
        } else if (view2.equals(this.vV)) {
            this.vW.bK();
        }
    }
}
