package d.b.i;

import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.i0.r.q.a2;
/* loaded from: classes.dex */
public class j0 extends c implements p<a2> {
    public TbPageContext i;
    public TbImageView j;
    public boolean k = true;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ThemeCardInUserData f50172e;

        public a(ThemeCardInUserData themeCardInUserData) {
            this.f50172e = themeCardInUserData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonalCardDetailActivityConfig(j0.this.i.getPageActivity(), this.f50172e.getCardId())));
        }
    }

    public j0(TbPageContext tbPageContext) {
        this.i = tbPageContext;
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.b.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.ds180), d.b.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.ds50));
        layoutParams.addRule(11);
        layoutParams.topMargin = d.b.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        layoutParams.rightMargin = d.b.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.tbds30);
        i(layoutParams);
        TbImageView tbImageView = new TbImageView(tbPageContext.getPageActivity());
        this.j = tbImageView;
        g(tbImageView);
    }

    public void l(a2 a2Var) {
        MetaData T;
        if (a2Var == null || this.j == null || (T = a2Var.T()) == null) {
            return;
        }
        ThemeCardInUserData themeCard = T.getThemeCard();
        if (themeCard != null && !StringUtils.isNull(themeCard.getCardImageUrlAndroid()) && !a2Var.P1) {
            if (this.k && (this.j.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.rightMargin = d.b.c.e.p.l.g(this.i.getPageActivity(), R.dimen.tbds106);
                this.j.setLayoutParams(layoutParams);
            }
            this.j.setVisibility(0);
            this.j.setImageDrawable(null);
            this.j.W(themeCard.getCardImageUrlAndroid(), 10, false);
            this.j.setOnClickListener(new a(themeCard));
            return;
        }
        this.j.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: m */
    public void a(a2 a2Var) {
        l(a2Var);
    }

    public void n(boolean z) {
        this.k = z;
    }

    public void o(BdUniqueId bdUniqueId) {
        this.j.setPageId(bdUniqueId);
    }
}
