package d.b.i0.z0.j.b.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import com.baidu.tieba.homepage.topic.topictab.view.TopicPkView;
import d.b.b.e.p.l;
import d.b.h0.r.u.c;
/* loaded from: classes3.dex */
public class a extends d.b.i0.x.b<d.b.i0.z0.j.b.c.a> {
    public static final int D = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
    public RelativeLayout A;
    public d.b.i0.z0.j.b.c.a B;
    public final int C;
    public final View m;
    public int n;
    public CellTopicLinearLayout o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public RelativeLayout t;
    public TbImageView u;
    public View v;
    public TopicPkView w;
    public ThreadGodReplyLayout x;
    public TextView y;
    public View z;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.n = 3;
        this.C = l.g(b(), R.dimen.M_W_X005);
        View m = m();
        this.o = (CellTopicLinearLayout) m.findViewById(R.id.cell_topic_root);
        this.A = (RelativeLayout) m.findViewById(R.id.cell_topic_top_layout);
        this.p = (TextView) m.findViewById(R.id.cell_topic_index);
        this.q = (TextView) m.findViewById(R.id.cell_topic_title);
        this.r = (TextView) m.findViewById(R.id.cell_topic_partake);
        this.s = (TextView) m.findViewById(R.id.cell_topic_des);
        this.t = (RelativeLayout) m.findViewById(R.id.cell_topic_img_layout);
        this.u = (TbImageView) m.findViewById(R.id.cell_topic_img);
        this.v = m.findViewById(R.id.cell_topic_img_placeholder);
        this.w = (TopicPkView) m.findViewById(R.id.cell_topic_pk);
        this.x = (ThreadGodReplyLayout) m.findViewById(R.id.cell_topic_god_reply);
        this.y = (TextView) m.findViewById(R.id.cell_topic_icon);
        this.z = m.findViewById(R.id.cell_topic_img_mask);
        this.m = m.findViewById(R.id.cell_topic_bottom_placeholder);
        w(this.A);
        w(this.s);
        w(this.x);
        w(this.m);
        w(this.u);
        w(this.z);
        int g2 = l.g(b(), R.dimen.tbds11);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.w.getLayoutParams();
        layoutParams.leftMargin = g2;
        layoutParams.rightMargin = g2;
        this.w.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.u.getLayoutParams();
        layoutParams2.height = ((l.k(b()) - l.g(b(), R.dimen.tbds88)) * 9) / 16;
        this.u.setLayoutParams(layoutParams2);
        this.u.setRadiusById(R.string.J_X05);
        this.u.setConrers(15);
        this.u.setDrawCorner(true);
        this.u.setPlaceHolder(3);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.cell_topic_card_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.w.q();
        this.x.l();
        if (i == this.n) {
            return;
        }
        this.n = i;
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.s, R.color.CAM_X0105);
        this.u.setIsNight(this.n == 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b.i0.z0.j.b.c.a aVar = this.B;
        if (aVar == null) {
            return;
        }
        if (aVar.a0 != 1) {
            TiebaStatic.log(new StatisticItem("c13351").param("topic_id", this.B.T).param("obj_locate", this.B.S));
        }
        if (this.B.a0 == 1) {
            TiebaStatic.log(new StatisticItem("c13449").param("topic_id", this.B.T));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TopicDetailActivityConfig(b(), this.B.T)));
    }

    public CellTopicLinearLayout u() {
        return this.o;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(d.b.i0.z0.j.b.c.a aVar) {
        if (aVar == null) {
            return;
        }
        this.B = aVar;
        if (aVar.a0 == 0) {
            this.y.setVisibility(8);
            this.p.setVisibility(0);
            this.r.setVisibility(0);
            this.p.setText(String.valueOf(aVar.S));
            int i = aVar.S;
            if (i == 1) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_one_bg);
            } else if (i == 2) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_two_bg);
            } else if (i == 3) {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_three_bg);
            } else {
                SkinManager.setBackgroundResource(this.p, R.drawable.topic_rank_other_bg);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            int g2 = l.g(b(), R.dimen.tbds16);
            layoutParams.addRule(1, R.id.cell_topic_index);
            layoutParams.setMargins(g2, 0, g2, 0);
            ThreadCardUtils.cutAndSetTextByMaxLine(this.s, aVar.V, R.string.check_detail, R.dimen.tbds17, 2, D, true);
            if (aVar.W == 0) {
                this.r.setText("NEW");
            } else {
                this.r.setText(String.format(this.f62181f.getString(R.string.topic_partake_default), StringHelper.numberUniformFormat(aVar.W)));
            }
            if (aVar.Z == null) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
                this.x.setData(aVar.Z);
            }
        } else {
            this.y.setVisibility(0);
            this.p.setVisibility(8);
            this.r.setVisibility(8);
            this.x.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            int g3 = l.g(b(), R.dimen.tbds30);
            int g4 = l.g(b(), R.dimen.tbds16);
            layoutParams2.addRule(1, R.id.cell_topic_icon);
            layoutParams2.setMargins(g3, 0, g4, 0);
            this.q.setTextSize(0, l.g(this.f62182g, R.dimen.tbds40));
            c a2 = c.a(this.q);
            a2.n(R.color.CAM_X0105);
            a2.s(R.string.F_X01);
            if (StringUtils.isNull(aVar.V)) {
                this.s.setVisibility(8);
            } else {
                this.s.setVisibility(0);
                ThreadCardUtils.cutAndSetTextByMaxLine(this.s, aVar.V, R.string.check_detail, R.dimen.tbds17, 2, D, true, false);
            }
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0105, 1);
        }
        String str = aVar.U;
        if (str.length() > 14) {
            str = str.substring(0, 13) + StringHelper.STRING_MORE;
        }
        this.q.setText(String.format(this.f62181f.getString(R.string.daily_topic_name), str));
        if (StringUtils.isNull(aVar.X)) {
            this.t.setVisibility(8);
            this.w.setUserColor(R.color.CAM_X0109);
        } else {
            this.t.setVisibility(0);
            this.u.setPlaceHolder(3);
            this.u.W(aVar.X, 10, false);
            this.w.setUserColor(R.color.CAM_X0101);
        }
        if (aVar.Y == null) {
            this.v.setVisibility(8);
            this.w.setVisibility(8);
            this.z.setVisibility(8);
            return;
        }
        this.v.setVisibility(0);
        this.w.setVisibility(0);
        this.w.setData(aVar.Y);
        this.z.setVisibility(0);
    }

    public final void w(View view) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int i = this.C;
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = i;
            view.setLayoutParams(marginLayoutParams);
        }
    }
}
