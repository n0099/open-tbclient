package d.b.j0.x;

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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalForumInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import d.b.i0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class w extends b<a2> implements d.b.j0.m.e {
    public final View m;
    public TbPageContext<?> n;
    public HeadImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public a2 s;
    public u t;
    public ConstrainImageGroup u;

    public w(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
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
        this.u = (ConstrainImageGroup) m.findViewById(R.id.card_img_layout);
        this.m = m.findViewById(R.id.card_divider_line);
        this.u.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
        d.b.i0.b1.j.f fVar = new d.b.i0.b1.j.f(3);
        fVar.d(1.0d);
        this.u.setImageProcessor(fVar);
        this.u.setSinglePicUseStyleV10(true);
        this.u.setFromCDN(true);
        this.u.setClickable(false);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.frs_hot_topic_card_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.o.invalidate();
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(m(), R.drawable.addresslist_item_bg);
        SkinManager.setBackgroundColor(this.m, R.color.CAM_X0204);
        this.u.b();
        this.o.setDefaultBgResource(i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.s == null) {
            return;
        }
        if (i() != null) {
            i().b(view, this.s, this.t);
        }
        if (view == m()) {
            m.a(this.s.w1());
            m.l(this.r, this.s.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
            u();
        }
    }

    @Override // d.b.j0.m.e
    public void setPage(String str) {
    }

    public final void u() {
        a2 a2Var = this.s;
        if (a2Var == null || a2Var.T() == null || this.s.T().getName_show() == null) {
            return;
        }
        long c0 = this.s.c0();
        OriginalForumInfo originalForumInfo = this.s.C1;
        if (originalForumInfo != null) {
            c0 = d.b.c.e.m.b.f(originalForumInfo.id, 0L);
        }
        long j = c0;
        if (d.b.i0.p0.b.h(true) && !d.b.i0.p0.b.g()) {
            String name_show = this.s.T().getName_show();
            HotTopicActivityConfig hotTopicActivityConfig = new HotTopicActivityConfig(b());
            HotTopicActivityConfig createNormalConfig = hotTopicActivityConfig.createNormalConfig("", name_show + "", "3");
            createNormalConfig.setExtra(j, this.s.d0(), this.s.d1(), d.b.c.e.m.b.f(this.s.w1(), 0L));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            return;
        }
        UrlManager.getInstance().dealOneLink(this.n, new String[]{this.s.C1()});
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.x.b
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
        if (a2Var.T() != null) {
            this.p.setText(a2Var.T().getName_show());
        }
        this.q.setText(StringHelper.getFormatTime(a2Var.B0() * 1000));
        String str = a2Var.D1() + "：";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.append((CharSequence) a2Var.O2(false, true));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0304)), 0, str.length(), 33);
        this.r.setText(spannableStringBuilder);
        ArrayList<MediaData> K0 = a2Var.K0();
        if (d.b.i0.r.k.c().g() && ListUtils.getCount(K0) != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < K0.size(); i++) {
                MediaData mediaData = (MediaData) ListUtils.getItem(K0, i);
                if (mediaData != null && mediaData.getType() == 3) {
                    arrayList.add(mediaData);
                }
            }
            if (ListUtils.getCount(arrayList) > 0) {
                this.u.setVisibility(0);
                this.u.setImageMediaList(arrayList);
            } else {
                this.u.setVisibility(8);
            }
        } else {
            this.u.setVisibility(8);
        }
        m.l(this.r, this.s.w1(), R.color.CAM_X0105, R.color.CAM_X0109);
        o(this.n, TbadkCoreApplication.getInst().getSkinType());
    }

    public void w(d.b.c.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.u;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void x(d.b.c.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.u;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }
}
