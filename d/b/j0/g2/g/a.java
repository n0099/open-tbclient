package d.b.j0.g2.g;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonBarActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPostActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class a extends d.b.j0.x.b<d.b.j0.g2.e.d> {
    public LinearLayout A;
    public UserData B;
    public int C;
    public int D;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public LinearLayout u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public View y;
    public View z;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.C = 3;
        this.D = 0;
        View m = m();
        this.A = (LinearLayout) m.findViewById(R.id.layout_container);
        this.y = m.findViewById(R.id.top_divider_line);
        this.z = m.findViewById(R.id.bottom_divider_line);
        this.m = (TextView) m.findViewById(R.id.fans_num);
        this.n = (TextView) m.findViewById(R.id.fans_title);
        this.o = (TextView) m.findViewById(R.id.concer_num);
        this.p = (TextView) m.findViewById(R.id.concer_title);
        this.q = (TextView) m.findViewById(R.id.attention_bar_num);
        this.r = (TextView) m.findViewById(R.id.attention_bar_title);
        this.s = (TextView) m.findViewById(R.id.thread_num);
        this.t = (TextView) m.findViewById(R.id.thread_title);
        this.u = (LinearLayout) m.findViewById(R.id.fans_action);
        this.v = (LinearLayout) m.findViewById(R.id.concer_action);
        this.w = (LinearLayout) m.findViewById(R.id.attention_action);
        this.x = (LinearLayout) m.findViewById(R.id.thread_action);
        this.y.setVisibility(8);
        this.z.setVisibility(8);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.person_center_actions_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.C != i) {
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.z, R.color.CAM_X0204);
            int g2 = l.g(b(), R.dimen.tbds16);
            TBSelector.makeShadowDrawable().setShape(1).setShadowSide(4096).setBgColor(R.color.CAM_X0205).setShapeRadius(0).setShadowLayer(R.color.cp_shadow_a, 0.2f, 0, l.g(b(), R.dimen.tbds5), g2).into(m());
            this.C = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.fans_action) {
            if (this.B == null) {
                return;
            }
            d.b.j0.t2.a.v().L(2, false, true);
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 6));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f64177f.getPageActivity(), false, this.B.getUserId(), this.B.getSex()).updateBjhUser(this.B.isBaijiahaoUser())));
        } else if (view.getId() == R.id.concer_action) {
            if (this.B == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 5));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonListActivityConfig(this.f64177f.getPageActivity(), true, this.B.getUserId(), this.B.getSex()).updateBjhUser(this.B.isBaijiahaoUser()).updateFollowNum(this.D, this.B.getPortrait())));
        } else if (view.getId() == R.id.attention_action) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 7));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonBarActivityConfig(this.f64177f.getPageActivity(), this.B.getLike_bars(), this.B.getUserId(), this.B.getSex())));
        } else if (view.getId() == R.id.thread_action) {
            TiebaStatic.log(new StatisticItem("c12523").param("obj_locate", 8));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPostActivityConfig(this.f64177f.getPageActivity(), this.B.getUserId(), this.B.getSex(), this.B.getPortrait())));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
    /* renamed from: u */
    public void n(d.b.j0.g2.e.d dVar) {
        this.B = dVar.j;
        this.D = dVar.f56656f;
        this.m.setText(StringHelper.numFormatOverWanNa(dVar.f56655e));
        this.o.setText(Integer.toString(dVar.f56656f));
        this.q.setText(Integer.toString(dVar.f56657g));
        this.s.setText(StringHelper.longNumFormatOver9999wan(dVar.f56658h));
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        o(l(), TbadkCoreApplication.getInst().getSkinType());
    }
}
