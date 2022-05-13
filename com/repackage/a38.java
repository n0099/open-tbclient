package com.repackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.PersonOftenFuncItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a38 extends uw5<l28> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonOftenFuncItemView i;
    public PersonOftenFuncItemView j;
    public PersonOftenFuncItemView k;
    public PersonOftenFuncItemView l;
    public PersonOftenFuncItemView m;
    public PersonOftenFuncItemView n;
    public PersonOftenFuncItemView o;
    public PersonOftenFuncItemView p;
    public PersonOftenFuncItemView q;
    public LinearLayout r;
    public LinearLayout s;
    public TextView t;
    public View u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a38(TbPageContext<?> tbPageContext) {
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
        View k = k();
        this.r = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091608);
        this.s = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917cd);
        this.t = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917cc);
        this.i = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f0913dd);
        this.j = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f0905e0);
        this.k = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f0912c7);
        this.l = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f090051);
        this.m = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f0914af);
        this.n = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f0904d0);
        this.o = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f0913a1);
        this.p = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f091e1e);
        this.u = k.findViewById(R.id.obfuscated_res_0x7f090389);
        this.q = (PersonOftenFuncItemView) k.findViewById(R.id.obfuscated_res_0x7f091607);
        this.v = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090f73);
        this.w = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090fa7);
        this.x = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f090fb4);
        m(j(), this.a);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06a8 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(k(), (int) R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0204);
            gs4 d = gs4.d(this.r);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.k, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.m, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.i.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.j.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.l.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.m.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q.b, (int) R.color.CAM_X0105);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: s */
    public void l(l28 l28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l28Var) == null) {
            if (l28Var != null && l28Var.e() != null && !ListUtils.isEmpty(l28Var.e())) {
                List<i28> e = l28Var.e();
                this.i.a(e.get(0));
                this.j.a(e.get(1));
                this.k.a(e.get(2));
                this.q.a(e.get(3));
                this.l.a(e.get(4));
                this.m.a(e.get(5));
                this.n.a(e.get(6));
                this.o.a(e.get(7));
                this.p.a(e.get(8));
                this.v.removeAllViews();
                this.w.removeAllViews();
                this.x.removeAllViews();
                if (TbSingleton.getInstance().isBusinessAccount()) {
                    this.x.setVisibility(0);
                    this.q.setVisibility(0);
                    this.v.addView(this.q);
                    this.v.addView(this.i);
                    this.v.addView(this.j);
                    this.v.addView(this.k);
                    this.w.addView(this.l);
                    this.w.addView(this.m);
                    this.w.addView(this.n);
                    this.w.addView(this.o);
                    this.x.addView(this.p);
                    for (int i = 0; i < 3; i++) {
                        PersonOftenFuncItemView personOftenFuncItemView = new PersonOftenFuncItemView(getContext());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                        layoutParams.weight = 1.0f;
                        personOftenFuncItemView.setLayoutParams(layoutParams);
                        this.x.addView(personOftenFuncItemView);
                    }
                } else {
                    this.x.setVisibility(8);
                    this.q.setVisibility(8);
                    this.v.addView(this.i);
                    this.v.addView(this.j);
                    this.v.addView(this.k);
                    this.v.addView(this.l);
                    this.w.addView(this.m);
                    this.w.addView(this.n);
                    this.w.addView(this.o);
                    this.w.addView(this.p);
                }
                m(j(), this.a);
                return;
            }
            q(8);
        }
    }
}
