package d.b.i0.u0.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import d.b.h0.r.f0.q.c;
import d.b.i0.x.e0.h;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.b<h> {
    public CommonUserLikeButton m;
    public c n;
    public ClickableHeaderImageView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public View s;
    public TbPageContext<?> t;
    public MetaData u;
    public h v;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.t = tbPageContext;
        m().setOnClickListener(this);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) m().findViewById(R.id.god_header_view);
        this.o = clickableHeaderImageView;
        clickableHeaderImageView.setGodIconMargin(R.dimen.ds6);
        this.o.setAfterClickListener(this);
        this.p = (TextView) m().findViewById(R.id.god_name);
        this.q = (TextView) m().findViewById(R.id.god_describe);
        this.r = (TextView) m().findViewById(R.id.rec_reason);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) m().findViewById(R.id.god_like_btn);
        this.m = commonUserLikeButton;
        this.n = new c(tbPageContext, commonUserLikeButton);
        this.m.setAfterOnClickListener(this);
        this.s = m().findViewById(R.id.bottom_line);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.card_god_square_rec_god;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62180e != i) {
            SkinManager.setBackgroundResource(m(), R.drawable.home_thread_card_item_bg);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        }
        this.f62180e = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData metaData;
        if (i() != null) {
            i().a(view, this.v);
        }
        if (view != m() || (metaData = this.u) == null || StringUtils.isNull(metaData.getName_show()) || StringUtils.isNull(this.u.getUserId())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getPageActivity(), this.u.getUserId(), this.u.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(h hVar) {
        MetaData metaData;
        if (hVar == null || (metaData = hVar.f62211e) == null || metaData.getGodUserData() == null) {
            return;
        }
        this.v = hVar;
        MetaData metaData2 = hVar.f62211e;
        this.u = metaData2;
        this.o.setData(metaData2);
        this.p.setText(hVar.f62211e.getName_show());
        this.q.setText(hVar.f62211e.getGodUserData().getIntro());
        String string = this.t.getResources().getString(R.string.recommend_reason);
        String recommendReason = hVar.f62211e.getGodUserData().getRecommendReason();
        if (StringUtils.isNull(recommendReason)) {
            this.r.setText("");
        } else {
            this.r.setText(String.format(string, recommendReason));
        }
        this.n.n(hVar.f62211e);
        o(null, TbadkCoreApplication.getInst().getSkinType());
    }

    public void v(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }
}
