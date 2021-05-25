package d.a.n0.z;

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
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class x extends b<a2> implements d.a.n0.o.e {
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
        View l = l();
        l.setOnClickListener(this);
        this.n = tbPageContext;
        HeadImageView headImageView = (HeadImageView) l.findViewById(R.id.topic_icon);
        this.o = headImageView;
        headImageView.setIsRound(true);
        this.o.setDefaultResource(R.drawable.pic_head_topic);
        this.p = (TextView) l.findViewById(R.id.card_topic_name);
        this.r = (TextView) l.findViewById(R.id.card_thread_title);
        this.q = (TextView) l.findViewById(R.id.card_reply_time);
        this.m = l.findViewById(R.id.card_divider_line);
        FrsBaseVideoView frsBaseVideoView = (FrsBaseVideoView) l.findViewById(R.id.base_video_view);
        this.u = frsBaseVideoView;
        frsBaseVideoView.setClickListener(this);
    }

    @Override // d.a.n0.z.b
    public int g() {
        return R.layout.frs_hottopic_video_card;
    }

    @Override // d.a.n0.z.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        this.o.invalidate();
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setBackgroundResource(l(), R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        FrsBaseVideoView frsBaseVideoView = this.u;
        if (frsBaseVideoView != null) {
            frsBaseVideoView.h(i2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.s == null) {
            return;
        }
        if (h() != null) {
            h().b(view, this.s, this.t);
        }
        m.a(this.s.y1());
        m.l(this.r, this.s.y1(), R.color.CAM_X0105, R.color.CAM_X0109);
        s();
    }

    public final void s() {
        a2 a2Var = this.s;
        if (a2Var == null || a2Var.T() == null || this.s.T().getName_show() == null) {
            return;
        }
        if (d.a.m0.p0.b.h(true) && !d.a.m0.p0.b.g()) {
            String name_show = this.s.T().getName_show();
            HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(b());
            HotTopicActivityConfig createNormalConfig = hotTopicActivityConfig.createNormalConfig("", name_show + "", "3");
            createNormalConfig.setExtra(this.s.c0(), this.s.d0(), this.s.e1(), d.a.c.e.m.b.f(this.s.y1(), 0L));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            return;
        }
        UrlManager.getInstance().dealOneLink(this.n, new String[]{this.s.E1()});
    }

    @Override // d.a.n0.o.e
    public void setPage(String str) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: t */
    public void m(a2 a2Var) {
        if (a2Var == null) {
            if (l() != null) {
                l().setVisibility(8);
                return;
            }
            return;
        }
        this.s = a2Var;
        if (l() != null) {
            l().setVisibility(0);
            l().setOnClickListener(this);
        }
        FrsBaseVideoView frsBaseVideoView = this.u;
        if (frsBaseVideoView != null) {
            frsBaseVideoView.g(this.s, a2Var.n0());
        }
        if (a2Var.T() != null) {
            this.p.setText(a2Var.T().getName_show());
        }
        this.q.setText(StringHelper.getFormatTime(a2Var.C0() * 1000));
        String str = a2Var.F1() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) a2Var.R2(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.r.setText(spannableStringBuilder);
        m.l(this.r, this.s.y1(), R.color.CAM_X0105, R.color.CAM_X0109);
        n(this.n, TbadkCoreApplication.getInst().getSkinType());
    }
}
