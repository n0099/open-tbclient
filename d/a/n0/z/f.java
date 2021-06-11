package d.a.n0.z;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.m0.r.q.a2;
import java.util.List;
/* loaded from: classes4.dex */
public class f extends b<d.a.n0.e0.d> {
    public LinearLayout m;
    public TextView n;
    public LinearLayout o;
    public d p;
    public e q;
    public e r;
    public d.a.n0.e0.a s;
    public d.a.n0.e0.b t;
    public d.a.n0.e0.b u;
    public View v;
    public View w;
    public a x;
    public String y;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, BaseCardInfo baseCardInfo);
    }

    public f(TbPageContext<?> tbPageContext, String str) {
        super(tbPageContext);
        this.y = str;
        u(m());
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.card_frs_game_head_line_view_item;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundResource(m(), R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0106, 1);
        SkinManager.setBackgroundResource(this.v, R.color.CAM_X0205);
        SkinManager.setBackgroundResource(this.w, R.color.CAM_X0205);
        d dVar = this.p;
        if (dVar != null) {
            dVar.o(tbPageContext, i2);
        }
        e eVar = this.q;
        if (eVar != null) {
            eVar.o(tbPageContext, i2);
        }
        e eVar2 = this.r;
        if (eVar2 != null) {
            eVar2.o(tbPageContext, i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.a.n0.e0.b bVar;
        TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 6).param("fid", this.y));
        if (view == this.p.m()) {
            d.a.n0.e0.a aVar = this.s;
            if (aVar == null) {
                return;
            }
            a aVar2 = this.x;
            if (aVar2 != null) {
                aVar2.a(view, aVar);
            }
            t(this.s.c());
        } else if (view == this.q.m()) {
            d.a.n0.e0.b bVar2 = this.t;
            if (bVar2 == null) {
                return;
            }
            a aVar3 = this.x;
            if (aVar3 != null) {
                aVar3.a(view, bVar2);
            }
            t(this.t.c());
        } else if (view != this.r.m() || (bVar = this.u) == null) {
        } else {
            a aVar4 = this.x;
            if (aVar4 != null) {
                aVar4.a(view, bVar);
            }
            t(this.u.c());
        }
    }

    public final void t(a2 a2Var) {
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(k().getPageActivity()).createFromThreadCfg(a2Var, null, m.g(), 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(a2Var.c0()));
        createFromThreadCfg.setForumName(a2Var.i0());
        createFromThreadCfg.setStartFrom(0);
        m.a(a2Var.z1());
        k().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public final void u(View view) {
        this.m = (LinearLayout) view.findViewById(R.id.card_frs_game_head_line_layout);
        this.n = (TextView) view.findViewById(R.id.frs_game_head_line_title);
        this.o = (LinearLayout) view.findViewById(R.id.frs_game_head_line_container);
        this.v = view.findViewById(R.id.divider_line_1);
        this.w = view.findViewById(R.id.divider_line_2);
        int dimensionPixelSize = this.f67160g.getResources().getDimensionPixelSize(R.dimen.tbds44);
        if (this.p == null) {
            this.p = new d(this.f67159f, null, null);
        }
        this.p.w(0, 0, 0, 0);
        this.p.x(8);
        this.p.y(8);
        if (this.p.m().getParent() != null) {
            ((ViewGroup) this.p.m().getParent()).removeView(this.p.m());
        }
        this.p.m().setOnClickListener(this);
        this.p.m().setVisibility(8);
        this.o.addView(this.p.m());
        if (this.q == null) {
            this.q = new e(this.f67159f);
        }
        this.q.w(8);
        this.q.x(0, dimensionPixelSize, 0, 0);
        if (this.q.m().getParent() != null) {
            ((ViewGroup) this.q.m().getParent()).removeView(this.q.m());
        }
        this.q.m().setOnClickListener(this);
        this.q.m().setVisibility(8);
        this.o.addView(this.q.m());
        if (this.r == null) {
            this.r = new e(this.f67159f);
        }
        this.r.w(8);
        this.r.x(0, dimensionPixelSize, 0, 0);
        if (this.r.m().getParent() != null) {
            ((ViewGroup) this.r.m().getParent()).removeView(this.r.m());
        }
        this.r.m().setOnClickListener(this);
        this.r.m().setVisibility(8);
        this.o.addView(this.r.m());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: v */
    public void n(d.a.n0.e0.d dVar) {
        if (dVar == null || dVar.c() == null) {
            return;
        }
        if (!TextUtils.isEmpty(dVar.c().f63376b)) {
            this.n.setText(dVar.c().f63376b);
        }
        List<a2> list = dVar.c().f63375a;
        if (ListUtils.getCount(list) >= 1) {
            d.a.n0.e0.a aVar = new d.a.n0.e0.a();
            this.s = aVar;
            aVar.g(list.get(0));
            this.p.m().setVisibility(0);
            this.p.n(this.s);
        }
        if (ListUtils.getCount(list) >= 2) {
            d.a.n0.e0.b bVar = new d.a.n0.e0.b();
            this.t = bVar;
            bVar.g(list.get(1));
            this.q.m().setVisibility(0);
            this.q.n(this.t);
            this.q.y(8);
        }
        if (ListUtils.getCount(list) >= 3) {
            d.a.n0.e0.b bVar2 = new d.a.n0.e0.b();
            this.u = bVar2;
            bVar2.g(list.get(2));
            this.r.m().setVisibility(0);
            this.r.n(this.u);
            this.r.y(8);
        }
    }

    public void w(a aVar) {
        this.x = aVar;
    }
}
