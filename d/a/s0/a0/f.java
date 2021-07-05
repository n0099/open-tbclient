package d.a.s0.a0;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
import d.a.r0.r.q.b2;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends b<d.a.s0.g0.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout m;
    public TextView n;
    public LinearLayout o;
    public d p;
    public e q;
    public e r;
    public d.a.s0.g0.a s;
    public d.a.s0.g0.b t;
    public d.a.s0.g0.b u;
    public View v;
    public View w;
    public a x;
    public String y;

    /* loaded from: classes9.dex */
    public interface a {
        void a(View view, BaseCardInfo baseCardInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = str;
        t(l());
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_frs_game_head_line_view_item : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(l(), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(this.v, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(this.w, R.color.CAM_X0205);
            d dVar = this.p;
            if (dVar != null) {
                dVar.n(tbPageContext, i2);
            }
            e eVar = this.q;
            if (eVar != null) {
                eVar.n(tbPageContext, i2);
            }
            e eVar2 = this.r;
            if (eVar2 != null) {
                eVar2.n(tbPageContext, i2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.s0.g0.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.y));
            if (view == this.p.l()) {
                d.a.s0.g0.a aVar = this.s;
                if (aVar == null) {
                    return;
                }
                a aVar2 = this.x;
                if (aVar2 != null) {
                    aVar2.a(view, aVar);
                }
                s(this.s.getThreadData());
            } else if (view == this.q.l()) {
                d.a.s0.g0.b bVar2 = this.t;
                if (bVar2 == null) {
                    return;
                }
                a aVar3 = this.x;
                if (aVar3 != null) {
                    aVar3.a(view, bVar2);
                }
                s(this.t.getThreadData());
            } else if (view != this.r.l() || (bVar = this.u) == null) {
            } else {
                a aVar4 = this.x;
                if (aVar4 != null) {
                    aVar4.a(view, bVar);
                }
                s(this.u.getThreadData());
            }
        }
    }

    public final void s(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b2Var) == null) {
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(k().getPageActivity()).createFromThreadCfg(b2Var, null, m.g(), 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(b2Var.Q()));
            createFromThreadCfg.setForumName(b2Var.W());
            createFromThreadCfg.setStartFrom(0);
            m.a(b2Var.n1());
            k().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public final void t(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            this.m = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
            this.n = (TextView) view.findViewById(R.id.frs_game_head_line_title);
            this.o = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
            this.v = view.findViewById(R.id.divider_line_1);
            this.w = view.findViewById(R.id.divider_line_2);
            int dimensionPixelSize = this.f57033g.getResources().getDimensionPixelSize(R.dimen.tbds44);
            if (this.p == null) {
                this.p = new d(this.f57032f, null, null);
            }
            this.p.v(0, 0, 0, 0);
            this.p.w(8);
            this.p.x(8);
            if (this.p.l().getParent() != null) {
                ((ViewGroup) this.p.l().getParent()).removeView(this.p.l());
            }
            this.p.l().setOnClickListener(this);
            this.p.l().setVisibility(8);
            this.o.addView(this.p.l());
            if (this.q == null) {
                this.q = new e(this.f57032f);
            }
            this.q.v(8);
            this.q.w(0, dimensionPixelSize, 0, 0);
            if (this.q.l().getParent() != null) {
                ((ViewGroup) this.q.l().getParent()).removeView(this.q.l());
            }
            this.q.l().setOnClickListener(this);
            this.q.l().setVisibility(8);
            this.o.addView(this.q.l());
            if (this.r == null) {
                this.r = new e(this.f57032f);
            }
            this.r.v(8);
            this.r.w(0, dimensionPixelSize, 0, 0);
            if (this.r.l().getParent() != null) {
                ((ViewGroup) this.r.l().getParent()).removeView(this.r.l());
            }
            this.r.l().setOnClickListener(this);
            this.r.l().setVisibility(8);
            this.o.addView(this.r.l());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: u */
    public void m(d.a.s0.g0.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null || dVar.c() == null) {
            return;
        }
        if (!TextUtils.isEmpty(dVar.c().f67046b)) {
            this.n.setText(dVar.c().f67046b);
        }
        List<b2> list = dVar.c().f67045a;
        if (ListUtils.getCount(list) >= 1) {
            d.a.s0.g0.a aVar = new d.a.s0.g0.a();
            this.s = aVar;
            aVar.c(list.get(0));
            this.p.l().setVisibility(0);
            this.p.m(this.s);
        }
        if (ListUtils.getCount(list) >= 2) {
            d.a.s0.g0.b bVar = new d.a.s0.g0.b();
            this.t = bVar;
            bVar.c(list.get(1));
            this.q.l().setVisibility(0);
            this.q.m(this.t);
            this.q.x(8);
        }
        if (ListUtils.getCount(list) >= 3) {
            d.a.s0.g0.b bVar2 = new d.a.s0.g0.b();
            this.u = bVar2;
            bVar2.c(list.get(2));
            this.r.l().setVisibility(0);
            this.r.m(this.u);
            this.r.x(8);
        }
    }

    public void v(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.x = aVar;
        }
    }
}
