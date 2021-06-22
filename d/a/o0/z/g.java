package d.a.o0.z;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends b<d.a.o0.e0.e> {
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public View s;
    public String t;

    public g(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        t(m());
    }

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.card_frs_game_hot_topic_view_item;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setBackgroundResource(m(), R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.r, R.color.CAM_X0205);
        SkinManager.setBackgroundResource(this.s, R.color.CAM_X0205);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0106, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.n || view == this.o || view == this.p || view == this.q) {
            TiebaStatic.log(new StatisticItem("c13047").param("obj_locate", 8).param("fid", this.t));
            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(this.f67284f.getPageActivity()), new String[]{(String) view.getTag()}, true);
        }
    }

    public final void t(View view) {
        this.m = (TextView) view.findViewById(R.id.card_frs_game_hot_title);
        this.n = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_1);
        this.o = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_2);
        this.p = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_3);
        this.q = (TextView) view.findViewById(R.id.card_frs_game_hot_topic_4);
        this.n.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r = view.findViewById(R.id.divider_line_1);
        this.s = view.findViewById(R.id.divider_line_2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: u */
    public void n(d.a.o0.e0.e eVar) {
        if (eVar == null || eVar.c() == null) {
            return;
        }
        if (!TextUtils.isEmpty(eVar.c().title)) {
            this.m.setText(eVar.c().title);
        }
        this.n.setVisibility(8);
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.q.setVisibility(8);
        if (eVar.c().sub_nodes.size() >= 1) {
            this.n.setVisibility(0);
            this.n.setTag(eVar.c().sub_nodes.get(0).url);
            this.n.setText(eVar.c().sub_nodes.get(0).title);
        }
        if (eVar.c().sub_nodes.size() >= 2) {
            this.o.setVisibility(0);
            this.o.setTag(eVar.c().sub_nodes.get(1).url);
            this.o.setText(eVar.c().sub_nodes.get(1).title);
        }
        if (eVar.c().sub_nodes.size() >= 3) {
            this.p.setVisibility(0);
            this.p.setTag(eVar.c().sub_nodes.get(2).url);
            this.p.setText(eVar.c().sub_nodes.get(2).title);
        }
        if (eVar.c().sub_nodes.size() >= 4) {
            this.q.setVisibility(0);
            this.q.setTag(eVar.c().sub_nodes.get(3).url);
            this.q.setText(eVar.c().sub_nodes.get(3).title);
        }
    }

    public void v(String str) {
        this.t = str;
    }
}
