package d.a.i;

import android.widget.RelativeLayout;
import com.baidu.card.Align;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.n0.r.q.a2;
/* loaded from: classes.dex */
public class r0 extends c implements p<a2>, q {
    public static final int k = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds124);

    /* renamed from: i  reason: collision with root package name */
    public UnfollowedDecorView f43842i;
    public Align j;

    public r0(TbPageContext tbPageContext, Align align) {
        h(-1);
        UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.f43842i = unfollowedDecorView;
        unfollowedDecorView.setId(R.id.decor_item_right_id);
        g(this.f43842i);
        k(align);
    }

    public void k(Align align) {
        if (align == this.j) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams.topMargin = dimenPixelSize2;
            i(layoutParams);
            this.f43842i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43842i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43842i.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.f43842i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43842i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43842i.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i2 = k;
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = g3;
            layoutParams3.bottomMargin = g4;
            i(layoutParams3);
            this.f43842i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f43842i.setPadding(g2, g2, g2, g2);
            this.f43842i.setLayoutParams(layoutParams3);
        }
        this.j = align;
    }

    public void l(d.a.n0.r.q.a aVar) {
        if (aVar.isSupportTop()) {
            k(Align.ALIGN_RIGHT_TOP);
        } else if (aVar.isSupportBottom()) {
            l0 l0Var = this.f43792h;
            if (l0Var != null) {
                l0Var.n(this);
            }
        } else {
            k(Align.ALIGN_RIGHT_TOP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: m */
    public void a(a2 a2Var) {
        this.f43842i.a(a2Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.f43842i.l();
    }
}
