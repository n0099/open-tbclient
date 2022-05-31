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
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes5.dex */
public class d08 extends nv5<oz7> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView i;
    public ImageView j;
    public TextView k;
    public TextView l;
    public TbPageContext m;
    public cz7 n;
    public LinearLayout o;
    public FinanceTab p;
    public LinearLayout q;

    /* loaded from: classes5.dex */
    public class a implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d08 a;

        public a(d08 d08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d08Var;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                FinanceTabItems e = ((pz7) jnVar).e();
                TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", e.statistic));
                int parseInt = Integer.parseInt(e.tab_type);
                if (parseInt == 0) {
                    if (!StringUtils.isNull(e.tab_url) && e.tab_url.contains(".duxiaoman.com")) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001447, e.tab_url));
                    } else {
                        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getContext(), "", e.tab_url, true);
                        tbWebViewActivityConfig.setFixTitle(true);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                    }
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
    public d08(TbPageContext<?> tbPageContext) {
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
        LinearLayout linearLayout = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091777);
        this.o = linearLayout;
        linearLayout.setOnClickListener(this);
        this.q = (LinearLayout) k.findViewById(R.id.obfuscated_res_0x7f091774);
        this.i = (BdTypeRecyclerView) k.findViewById(R.id.obfuscated_res_0x7f091772);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.m.getPageActivity());
        linearLayoutManager.setOrientation(0);
        this.i.setLayoutManager(linearLayoutManager);
        this.j = (ImageView) k.findViewById(R.id.obfuscated_res_0x7f091773);
        this.k = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091775);
        this.l = (TextView) k.findViewById(R.id.obfuscated_res_0x7f091776);
        cz7 cz7Var = new cz7(this.m, pz7.b);
        this.n = cz7Var;
        cz7Var.V(new a(this));
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.n);
        this.i.a(arrayList);
        m(j(), this.a);
    }

    @Override // com.repackage.nv5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d069a : invokeV.intValue;
    }

    @Override // com.repackage.nv5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setViewTextColor(k(), (int) R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0205);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.o, R.color.CAM_X0205);
            wq4 d = wq4.d(this.q);
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
    @Override // com.repackage.nv5
    /* renamed from: s */
    public void l(oz7 oz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oz7Var) == null) {
            if (oz7Var != null && oz7Var.e() != null) {
                FinanceTab e = oz7Var.e();
                this.p = e;
                this.k.setText(e.general_tab_text);
                this.l.setText(this.p.title);
                ArrayList arrayList = new ArrayList();
                for (FinanceTabItems financeTabItems : this.p.tabs) {
                    pz7 pz7Var = new pz7();
                    pz7Var.g(financeTabItems);
                    arrayList.add(pz7Var);
                }
                this.i.setData(arrayList);
                m(j(), this.a);
                return;
            }
            q(8);
        }
    }
}
