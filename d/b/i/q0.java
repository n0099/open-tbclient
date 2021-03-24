package d.b.i;

import android.widget.RelativeLayout;
import com.baidu.card.Align;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.h0.r.q.a2;
/* loaded from: classes2.dex */
public class q0 extends c implements p<a2>, q {
    public static final int k = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    public UnfollowedDecorView i;
    public Align j;

    public q0(TbPageContext tbPageContext, Align align) {
        h(-1);
        UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.i = unfollowedDecorView;
        unfollowedDecorView.setId(R.id.decor_item_right_id);
        g(this.i);
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
            this.i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.i.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.i.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i = k;
            int g2 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = g3;
            layoutParams3.bottomMargin = g4;
            i(layoutParams3);
            this.i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.i.setPadding(g2, g2, g2, g2);
            this.i.setLayoutParams(layoutParams3);
        }
        this.j = align;
    }

    public void l(d.b.h0.r.q.a aVar) {
        if (aVar.isSupportTop()) {
            k(Align.ALIGN_RIGHT_TOP);
        } else if (aVar.isSupportBottom()) {
            k0 k0Var = this.f51770h;
            if (k0Var != null) {
                k0Var.n(this);
            }
        } else {
            k(Align.ALIGN_RIGHT_TOP);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: m */
    public void a(a2 a2Var) {
        this.i.a(a2Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.i.c();
    }
}
