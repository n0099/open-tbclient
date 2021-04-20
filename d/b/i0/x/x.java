package d.b.i0.x;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.layout.FrsBaseVideoView;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class x extends b<a2> implements d.b.i0.m.e {
    public final View m;
    public TbPageContext<?> n;
    public HeadImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public a2 s;
    public u t;
    public FrsBaseVideoView u;

    public x(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        View m = m();
        m.setOnClickListener(this);
        this.n = tbPageContext;
        HeadImageView headImageView = (HeadImageView) m.findViewById(R.id.topic_icon);
        this.o = headImageView;
        headImageView.setIsRound(true);
        this.o.setDefaultResource(R.drawable.pic_head_topic);
        this.p = (TextView) m.findViewById(R.id.card_topic_name);
        this.r = (TextView) m.findViewById(R.id.card_thread_title);
        this.q = (TextView) m.findViewById(R.id.card_reply_time);
        this.m = m.findViewById(R.id.card_divider_line);
        FrsBaseVideoView frsBaseVideoView = (FrsBaseVideoView) m.findViewById(R.id.base_video_view);
        this.u = frsBaseVideoView;
        frsBaseVideoView.setClickListener(this);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.frs_hottopic_video_card;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.o.invalidate();
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(m(), R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        FrsBaseVideoView frsBaseVideoView = this.u;
        if (frsBaseVideoView != null) {
            frsBaseVideoView.h(i);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.s == null) {
            return;
        }
        if (i() != null) {
            i().b(view, this.s, this.t);
        }
        m.a(this.s.w1());
        m.l(this.r, this.s.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
        u();
    }

    @Override // d.b.i0.m.e
    public void setPage(String str) {
    }

    public final void u() {
        a2 a2Var = this.s;
        if (a2Var == null || a2Var.T() == null || this.s.T().getName_show() == null) {
            return;
        }
        if (d.b.h0.p0.b.h(true) && !d.b.h0.p0.b.g()) {
            String name_show = this.s.T().getName_show();
            HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(b());
            HotTopicActivityConfig createNormalConfig = hotTopicActivityConfig.createNormalConfig("", name_show + "", "3");
            createNormalConfig.setExtra(this.s.c0(), this.s.d0(), this.s.d1(), d.b.c.e.m.b.f(this.s.w1(), 0L));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            return;
        }
        UrlManager.getInstance().dealOneLink(this.n, new String[]{this.s.C1()});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(a2 a2Var) {
        if (a2Var == null) {
            if (m() != null) {
                m().setVisibility(8);
                return;
            }
            return;
        }
        this.s = a2Var;
        if (m() != null) {
            m().setVisibility(0);
            m().setOnClickListener(this);
        }
        FrsBaseVideoView frsBaseVideoView = this.u;
        if (frsBaseVideoView != null) {
            frsBaseVideoView.g(this.s, a2Var.n0());
        }
        if (a2Var.T() != null) {
            this.p.setText(a2Var.T().getName_show());
        }
        this.q.setText(StringHelper.getFormatTime(a2Var.B0() * 1000));
        String str = a2Var.D1() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) a2Var.O2(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.r.setText(spannableStringBuilder);
        m.l(this.r, this.s.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
        o(this.n, TbadkCoreApplication.getInst().getSkinType());
    }
}
