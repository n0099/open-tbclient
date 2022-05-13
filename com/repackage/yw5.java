package com.repackage;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class yw5 extends uw5<s26> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public ww5 l;
    public xw5 m;
    public xw5 n;
    public p26 o;
    public q26 p;
    public q26 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes7.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yw5(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
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
        this.u = str;
        t(k());
    }

    @Override // com.repackage.uw5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d018b : invokeV.intValue;
    }

    @Override // com.repackage.uw5
    public void m(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(k(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            ww5 ww5Var = this.l;
            if (ww5Var != null) {
                ww5Var.m(tbPageContext, i);
            }
            xw5 xw5Var = this.m;
            if (xw5Var != null) {
                xw5Var.m(tbPageContext, i);
            }
            xw5 xw5Var2 = this.n;
            if (xw5Var2 != null) {
                xw5Var2.m(tbPageContext, i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        q26 q26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.k()) {
                p26 p26Var = this.o;
                if (p26Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, p26Var);
                }
                s(this.o.getThreadData());
            } else if (view2 == this.m.k()) {
                q26 q26Var2 = this.p;
                if (q26Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, q26Var2);
                }
                s(this.p.getThreadData());
            } else if (view2 != this.n.k() || (q26Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, q26Var);
                }
                s(this.q.getThreadData());
            }
        }
    }

    public final void s(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(j().getPageActivity()).createFromThreadCfg(threadData, null, fx5.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            fx5.a(threadData.getTid());
            j().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void t(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090503);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090af3);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090af2);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0907f5);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f0907f6);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new ww5(this.b, null, null);
            }
            this.l.v(0, 0, 0, 0);
            this.l.w(8);
            this.l.x(8);
            if (this.l.k().getParent() != null) {
                ((ViewGroup) this.l.k().getParent()).removeView(this.l.k());
            }
            this.l.k().setOnClickListener(this);
            this.l.k().setVisibility(8);
            this.k.addView(this.l.k());
            if (this.m == null) {
                this.m = new xw5(this.b);
            }
            this.m.v(8);
            this.m.w(0, dimensionPixelSize, 0, 0);
            if (this.m.k().getParent() != null) {
                ((ViewGroup) this.m.k().getParent()).removeView(this.m.k());
            }
            this.m.k().setOnClickListener(this);
            this.m.k().setVisibility(8);
            this.k.addView(this.m.k());
            if (this.n == null) {
                this.n = new xw5(this.b);
            }
            this.n.v(8);
            this.n.w(0, dimensionPixelSize, 0, 0);
            if (this.n.k().getParent() != null) {
                ((ViewGroup) this.n.k().getParent()).removeView(this.n.k());
            }
            this.n.k().setOnClickListener(this);
            this.n.k().setVisibility(8);
            this.k.addView(this.n.k());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.uw5
    /* renamed from: u */
    public void l(s26 s26Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, s26Var) == null) || s26Var == null || s26Var.e() == null) {
            return;
        }
        if (!TextUtils.isEmpty(s26Var.e().b)) {
            this.j.setText(s26Var.e().b);
        }
        List<ThreadData> list = s26Var.e().a;
        if (ListUtils.getCount(list) >= 1) {
            p26 p26Var = new p26();
            this.o = p26Var;
            p26Var.e(list.get(0));
            this.l.k().setVisibility(0);
            this.l.l(this.o);
        }
        if (ListUtils.getCount(list) >= 2) {
            q26 q26Var = new q26();
            this.p = q26Var;
            q26Var.e(list.get(1));
            this.m.k().setVisibility(0);
            this.m.l(this.p);
            this.m.x(8);
        }
        if (ListUtils.getCount(list) >= 3) {
            q26 q26Var2 = new q26();
            this.q = q26Var2;
            q26Var2.e(list.get(2));
            this.n.k().setVisibility(0);
            this.n.l(this.q);
            this.n.x(8);
        }
    }

    public void v(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }
}
