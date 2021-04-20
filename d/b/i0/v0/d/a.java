package d.b.i0.v0.d;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import d.b.h0.r.f0.q.c;
import d.b.i0.x.e0.h;
/* loaded from: classes4.dex */
public class a extends d.b.i0.x.b<h> {
    public CommonUserLikeButton m;
    public c n;
    public ClickableHeaderImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public View s;
    public TbPageContext<?> t;
    public Drawable u;
    public MetaData v;
    public h w;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.t = tbPageContext;
        m().setOnClickListener(this);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) m().findViewById(R.id.god_header_view);
        this.o = clickableHeaderImageView;
        clickableHeaderImageView.setGodIconMargin(R.dimen.ds4);
        this.o.setAfterClickListener(this);
        this.q = (TextView) m().findViewById(R.id.god_name);
        this.r = (TextView) m().findViewById(R.id.god_describe);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) m().findViewById(R.id.god_like_btn);
        this.m = commonUserLikeButton;
        this.n = new c(tbPageContext, commonUserLikeButton);
        this.m.setAfterOnClickListener(this);
        this.s = m().findViewById(R.id.bottom_line);
        this.p = (TextView) m().findViewById(R.id.god_rank);
        this.u = this.t.getResources().getDrawable(R.drawable.transparent_bg);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_god_square_hot_god;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f63755e != i) {
            SkinManager.setBackgroundResource(m(), R.drawable.home_thread_card_item_bg);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        }
        this.f63755e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData metaData;
        if (i() != null) {
            i().a(view, this.w);
        }
        if (view != m() || (metaData = this.v) == null || StringUtils.isNull(metaData.getName_show()) || StringUtils.isNull(this.v.getUserId())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.t.getPageActivity()).createNormalConfig(d.b.c.e.m.b.f(this.v.getUserId(), 0L), false, this.v.isBigV())));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(h hVar) {
        MetaData metaData;
        if (hVar == null || (metaData = hVar.f63786e) == null || metaData.getGodUserData() == null) {
            return;
        }
        this.w = hVar;
        this.v = hVar.f63786e;
        w(hVar.f63788g);
        this.o.setData(hVar.f63786e);
        this.q.setText(hVar.f63786e.getName_show());
        this.r.setText(hVar.f63786e.getGodUserData().getIntro());
        this.n.n(hVar.f63786e);
        o(null, TbadkCoreApplication.getInst().getSkinType());
    }

    public void v(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    public final void w(int i) {
        String str;
        if (i == 1) {
            this.p.setText("");
            SkinManager.setBackgroundResource(this.p, R.drawable.icon_grade_round_no1);
        } else if (i == 2) {
            this.p.setText("");
            SkinManager.setBackgroundResource(this.p, R.drawable.icon_grade_round_no2);
        } else if (i != 3) {
            this.p.setBackgroundDrawable(this.u);
            if (i < 100) {
                str = String.format("%02d", Integer.valueOf(i));
            } else {
                str = i + "";
            }
            this.p.setText(str);
        } else {
            this.p.setText("");
            SkinManager.setBackgroundResource(this.p, R.drawable.icon_grade_round_no3);
        }
    }
}
