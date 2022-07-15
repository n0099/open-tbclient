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
/* loaded from: classes6.dex */
public class nx5 extends jx5<b36> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout i;
    public TextView j;
    public LinearLayout k;
    public lx5 l;
    public mx5 m;
    public mx5 n;
    public y26 o;
    public z26 p;
    public z26 q;
    public View r;
    public View s;
    public a t;
    public String u;

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view2, BaseCardInfo baseCardInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nx5(TbPageContext<?> tbPageContext, String str) {
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
        s(h());
    }

    @Override // com.repackage.jx5
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.obfuscated_res_0x7f0d0185 : invokeV.intValue;
    }

    @Override // com.repackage.jx5
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i) == null) {
            SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
            lx5 lx5Var = this.l;
            if (lx5Var != null) {
                lx5Var.j(tbPageContext, i);
            }
            mx5 mx5Var = this.m;
            if (mx5Var != null) {
                mx5Var.j(tbPageContext, i);
            }
            mx5 mx5Var2 = this.n;
            if (mx5Var2 != null) {
                mx5Var2.j(tbPageContext, i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        z26 z26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.u));
            if (view2 == this.l.h()) {
                y26 y26Var = this.o;
                if (y26Var == null) {
                    return;
                }
                a aVar = this.t;
                if (aVar != null) {
                    aVar.a(view2, y26Var);
                }
                r(this.o.getThreadData());
            } else if (view2 == this.m.h()) {
                z26 z26Var2 = this.p;
                if (z26Var2 == null) {
                    return;
                }
                a aVar2 = this.t;
                if (aVar2 != null) {
                    aVar2.a(view2, z26Var2);
                }
                r(this.p.getThreadData());
            } else if (view2 != this.n.h() || (z26Var = this.q) == null) {
            } else {
                a aVar3 = this.t;
                if (aVar3 != null) {
                    aVar3.a(view2, z26Var);
                }
                r(this.q.getThreadData());
            }
        }
    }

    public final void r(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(g().getPageActivity()).createFromThreadCfg(threadData, null, ux5.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(0);
            ux5.a(threadData.getTid());
            g().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void s(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view2) == null) {
            this.i = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f0904df);
            this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090ad0);
            this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090acf);
            this.r = view2.findViewById(R.id.obfuscated_res_0x7f0907cb);
            this.s = view2.findViewById(R.id.obfuscated_res_0x7f0907cc);
            int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.l == null) {
                this.l = new lx5(this.b, null, null);
            }
            this.l.u(0, 0, 0, 0);
            this.l.v(8);
            this.l.w(8);
            if (this.l.h().getParent() != null) {
                ((ViewGroup) this.l.h().getParent()).removeView(this.l.h());
            }
            this.l.h().setOnClickListener(this);
            this.l.h().setVisibility(8);
            this.k.addView(this.l.h());
            if (this.m == null) {
                this.m = new mx5(this.b);
            }
            this.m.u(8);
            this.m.v(0, dimensionPixelSize, 0, 0);
            if (this.m.h().getParent() != null) {
                ((ViewGroup) this.m.h().getParent()).removeView(this.m.h());
            }
            this.m.h().setOnClickListener(this);
            this.m.h().setVisibility(8);
            this.k.addView(this.m.h());
            if (this.n == null) {
                this.n = new mx5(this.b);
            }
            this.n.u(8);
            this.n.v(0, dimensionPixelSize, 0, 0);
            if (this.n.h().getParent() != null) {
                ((ViewGroup) this.n.h().getParent()).removeView(this.n.h());
            }
            this.n.h().setOnClickListener(this);
            this.n.h().setVisibility(8);
            this.k.addView(this.n.h());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jx5
    /* renamed from: t */
    public void i(b36 b36Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, b36Var) == null) || b36Var == null || b36Var.c() == null) {
            return;
        }
        if (!TextUtils.isEmpty(b36Var.c().b)) {
            this.j.setText(b36Var.c().b);
        }
        List<ThreadData> list = b36Var.c().a;
        if (ListUtils.getCount(list) >= 1) {
            y26 y26Var = new y26();
            this.o = y26Var;
            y26Var.c(list.get(0));
            this.l.h().setVisibility(0);
            this.l.i(this.o);
        }
        if (ListUtils.getCount(list) >= 2) {
            z26 z26Var = new z26();
            this.p = z26Var;
            z26Var.c(list.get(1));
            this.m.h().setVisibility(0);
            this.m.i(this.p);
            this.m.w(8);
        }
        if (ListUtils.getCount(list) >= 3) {
            z26 z26Var2 = new z26();
            this.q = z26Var2;
            z26Var2.c(list.get(2));
            this.n.h().setVisibility(0);
            this.n.i(this.q);
            this.n.w(8);
        }
    }

    public void u(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.t = aVar;
        }
    }
}
