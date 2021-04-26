package d.a.j0.v0.d;

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
import d.a.i0.r.f0.q.c;
import d.a.j0.x.e0.h;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<h> {
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
        l().setOnClickListener(this);
        ClickableHeaderImageView clickableHeaderImageView = (ClickableHeaderImageView) l().findViewById(R.id.god_header_view);
        this.o = clickableHeaderImageView;
        clickableHeaderImageView.setGodIconMargin(R.dimen.ds6);
        this.o.setAfterClickListener(this);
        this.p = (TextView) l().findViewById(R.id.god_name);
        this.q = (TextView) l().findViewById(R.id.god_describe);
        this.r = (TextView) l().findViewById(R.id.rec_reason);
        CommonUserLikeButton commonUserLikeButton = (CommonUserLikeButton) l().findViewById(R.id.god_like_btn);
        this.m = commonUserLikeButton;
        this.n = new c(tbPageContext, commonUserLikeButton);
        this.m.setAfterOnClickListener(this);
        this.s = l().findViewById(R.id.bottom_line);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.card_god_square_rec_god;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        if (this.f62436e != i2) {
            SkinManager.setBackgroundResource(l(), R.drawable.home_thread_card_item_bg);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        }
        this.f62436e = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MetaData metaData;
        if (h() != null) {
            h().a(view, this.v);
        }
        if (view != l() || (metaData = this.u) == null || StringUtils.isNull(metaData.getName_show()) || StringUtils.isNull(this.u.getUserId())) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.t.getPageActivity(), this.u.getUserId(), this.u.getName_show(), null, AddFriendActivityConfig.TYPE_FRS_HEAD)));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: s */
    public void m(h hVar) {
        MetaData metaData;
        if (hVar == null || (metaData = hVar.f62471e) == null || metaData.getGodUserData() == null) {
            return;
        }
        this.v = hVar;
        MetaData metaData2 = hVar.f62471e;
        this.u = metaData2;
        this.o.setData(metaData2);
        this.p.setText(hVar.f62471e.getName_show());
        this.q.setText(hVar.f62471e.getGodUserData().getIntro());
        String string = this.t.getResources().getString(R.string.recommend_reason);
        String recommendReason = hVar.f62471e.getGodUserData().getRecommendReason();
        if (StringUtils.isNull(recommendReason)) {
            this.r.setText("");
        } else {
            this.r.setText(String.format(string, recommendReason));
        }
        this.n.n(hVar.f62471e);
        n(null, TbadkCoreApplication.getInst().getSkinType());
    }

    public void t(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }
}
