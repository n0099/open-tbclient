package com.repackage;

import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class mq7 extends jq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewStub o;
    public ViewStub p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mq7(TbPageContext tbPageContext, View view2) {
        super(tbPageContext, view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ViewStub viewStub = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09241d);
        this.o = viewStub;
        viewStub.inflate();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.topMargin = ((mi.i(tbPageContext.getPageActivity()) / 2) + mi.f(tbPageContext.getPageActivity(), R.dimen.tbds239)) - mi.f(tbPageContext.getPageActivity(), R.dimen.tbds140);
        this.o.setLayoutParams(layoutParams);
        this.q = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0922fa);
        ViewStub viewStub2 = (ViewStub) view2.findViewById(R.id.obfuscated_res_0x7f09241a);
        this.p = viewStub2;
        viewStub2.inflate();
        this.r = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092050);
        this.s = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09161f);
        this.t = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092051);
        this.u = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090165);
        this.v = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092052);
        this.w = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091943);
    }

    @Override // com.repackage.jq7
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.a(i);
            gs4 d = gs4.d(this.q);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X03);
            d.A(R.string.F_X02);
            gs4 d2 = gs4.d(this.r);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.tbds29);
            d2.A(R.string.F_X01);
            gs4 d3 = gs4.d(this.t);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.tbds29);
            d3.A(R.string.F_X01);
            gs4 d4 = gs4.d(this.v);
            d4.v(R.color.CAM_X0108);
            d4.z(R.dimen.tbds29);
            d4.A(R.string.F_X01);
            gs4 d5 = gs4.d(this.s);
            d5.v(R.color.CAM_X0302);
            d5.z(R.dimen.tbds29);
            d5.A(R.string.F_X01);
            gs4 d6 = gs4.d(this.u);
            d6.v(R.color.CAM_X0302);
            d6.z(R.dimen.tbds29);
            d6.A(R.string.F_X01);
            gs4 d7 = gs4.d(this.w);
            d7.v(R.color.CAM_X0302);
            d7.z(R.dimen.tbds29);
            d7.A(R.string.F_X01);
        }
    }

    @Override // com.repackage.jq7
    public void c(kq7 kq7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kq7Var) == null) || kq7Var == null) {
            return;
        }
        this.q.setText(kq7Var.a);
        f(kq7Var.a());
    }

    @Override // com.repackage.jq7
    public void d(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            super.d(onClickListener);
            this.s.setOnClickListener(onClickListener);
            this.u.setOnClickListener(onClickListener);
            this.w.setOnClickListener(onClickListener);
        }
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 1) {
                this.s.setText(R.string.obfuscated_res_0x7f0f0cd5);
            } else if (i == 2) {
                this.s.setText(R.string.obfuscated_res_0x7f0f0cd6);
            } else if (i != 3) {
            } else {
                this.s.setText(R.string.obfuscated_res_0x7f0f0cd7);
            }
        }
    }
}
