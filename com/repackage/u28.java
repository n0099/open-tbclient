package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.Profile.FinanceTab;
import tbclient.Profile.FinanceTabItems;
/* loaded from: classes7.dex */
public class u28 extends uw5<f28> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TbPageContext m;
    public t18 n;
    public LinearLayout o;
    public FinanceTab p;
    public LinearLayout q;

    /* loaded from: classes7.dex */
    public class a implements bp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(u28 u28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.bp
        public void b(View view2, ro roVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, roVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                FinanceTabItems e = ((g28) roVar).e();
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", e.statistic));
                int parseInt = Integer.parseInt(e.tab_type);
                if (parseInt == 0) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, e.tab_url));
                } else if (parseInt == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001451));
                } else if (parseInt == 2) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001447, e.tab_url));
                }
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", e.statistic));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u28(TbPageContext<?> tbPageContext) {
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
        this.m = tbPageContext;
        View k = k();
        LinearLayout linearLayout = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917c2);
        this.o = linearLayout;
        linearLayout.setOnClickListener(this);
        this.q = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f0917bf);
        this.i = (BdTypeRecyclerView) k.findViewById(R.id.obfuscated_res_0x7f0917bd);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.m.getPageActivity());
        linearLayoutManager.setOrientation(0);
        this.i.setLayoutManager(linearLayoutManager);
        this.j = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f0917be);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917c0);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f0917c1);
        t18 t18Var = new t18(this.m, g28.b);
        this.n = t18Var;
        t18Var.V(new a(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n);
        this.i.a(arrayList);
        m(j(), this.a);
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d06a5 : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(k(), (int) R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0205);
            gs4 d = gs4.d(this.q);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(getContext(), "", this.p.general_tab_url, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: s */
    public void l(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f28Var) == null) {
            if (f28Var != null && f28Var.e() != null) {
                FinanceTab e = f28Var.e();
                this.p = e;
                this.k.setText(e.general_tab_text);
                this.l.setText(this.p.title);
                ArrayList arrayList = new ArrayList();
                for (FinanceTabItems financeTabItems : this.p.tabs) {
                    g28 g28Var = new g28();
                    g28Var.g(financeTabItems);
                    arrayList.add(g28Var);
                }
                this.i.setData(arrayList);
                m(j(), this.a);
                return;
            }
            q(8);
        }
    }
}
