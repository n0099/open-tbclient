package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ww5 extends rw5<q26> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public View n;
    public View o;
    public String p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww5(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s(k());
    }

    @Override // com.repackage.rw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0191 : invokeV.intValue;
    }

    @Override // com.repackage.rw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.n, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0106, 1);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            if (view2 == this.j || view2 == this.k || view2 == this.l || view2 == this.m) {
                TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 8).param("fid", this.p));
                UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.b.getPageActivity()), new String[]{(String) view2.getTag()}, true);
            }
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090507);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090508);
            this.k = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090509);
            this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050a);
            this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09050b);
            this.j.setOnClickListener(this);
            this.k.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.m.setOnClickListener(this);
            this.n = view2.findViewById(R.id.obfuscated_res_0x7f0907fe);
            this.o = view2.findViewById(R.id.obfuscated_res_0x7f0907ff);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.rw5
    /* renamed from: t */
    public void l(q26 q26Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, q26Var) == null) || q26Var == null || q26Var.e() == null) {
            return;
        }
        if (!TextUtils.isEmpty(q26Var.e().title)) {
            this.i.setText(q26Var.e().title);
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        if (q26Var.e().sub_nodes.size() >= 1) {
            this.j.setVisibility(0);
            this.j.setTag(q26Var.e().sub_nodes.get(0).url);
            this.j.setText(q26Var.e().sub_nodes.get(0).title);
        }
        if (q26Var.e().sub_nodes.size() >= 2) {
            this.k.setVisibility(0);
            this.k.setTag(q26Var.e().sub_nodes.get(1).url);
            this.k.setText(q26Var.e().sub_nodes.get(1).title);
        }
        if (q26Var.e().sub_nodes.size() >= 3) {
            this.l.setVisibility(0);
            this.l.setTag(q26Var.e().sub_nodes.get(2).url);
            this.l.setText(q26Var.e().sub_nodes.get(2).title);
        }
        if (q26Var.e().sub_nodes.size() >= 4) {
            this.m.setVisibility(0);
            this.m.setTag(q26Var.e().sub_nodes.get(3).url);
            this.m.setText(q26Var.e().sub_nodes.get(3).title);
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }
}
