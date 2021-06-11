package d.a.i;

import android.widget.RelativeLayout;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import d.a.m0.r.q.v0;
/* loaded from: classes.dex */
public class b0 extends c implements p<v0>, q {
    public static final int l = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds124);

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView f43695i;
    public Align j;
    public boolean k;

    public b0(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
    }

    public final void k() {
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds57);
        int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
        int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds34);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = g3;
        layoutParams.topMargin = g4;
        i(layoutParams);
        this.f43695i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
        this.f43695i.setPadding(0, 0, 0, 0);
        this.f43695i.setLayoutParams(layoutParams);
    }

    public void l(Align align) {
        if (this.j == align) {
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
            this.f43695i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43695i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43695i.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.f43695i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43695i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43695i.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i2 = l;
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = g3;
            layoutParams3.bottomMargin = g4;
            i(layoutParams3);
            this.f43695i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f43695i.setPadding(g2, g2, g2, g2);
            this.f43695i.setLayoutParams(layoutParams3);
        }
        this.j = align;
    }

    public void m(d.a.m0.r.q.a aVar) {
        if (aVar == null || aVar.c() == null) {
            return;
        }
        if (aVar.c().g() <= 0 && aVar.i() != null) {
            if (!aVar.p() && !aVar.k()) {
                l(Align.ALIGN_RIGHT_BOTTOM);
            } else if (aVar.isSupportTop()) {
                v((!p(aVar) || d.a.m0.b.d.V()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds60) : o(R.dimen.tbds64));
            } else if (aVar.isSupportBottom()) {
                l0 l0Var = this.f43699h;
                if (l0Var != null) {
                    l0Var.n(this);
                }
            } else {
                l(Align.ALIGN_RIGHT_TOP);
            }
        } else if (this.k) {
            k();
        } else {
            r(aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.c
    /* renamed from: n */
    public NEGFeedBackView b() {
        return this.f43695i;
    }

    public final int o(int i2) {
        return d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), i2);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.f43695i.q();
    }

    public final boolean p(d.a.m0.r.q.a aVar) {
        return (aVar instanceof d.a.n0.z.e0.k) && ((d.a.n0.z.e0.k) aVar).s;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: q */
    public void a(v0 v0Var) {
        if (v0Var == null) {
            this.f43695i.setVisibility(8);
            return;
        }
        this.f43695i.setData(v0Var);
        this.f43695i.setFirstRowSingleColumn(true);
        this.f43695i.setVisibility(0);
    }

    public final void r(d.a.m0.r.q.a aVar) {
        if (aVar.p()) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams.topMargin = dimenPixelSize2;
            i(layoutParams);
            this.f43695i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43695i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43695i.setLayoutParams(layoutParams);
            return;
        }
        int i2 = l;
        int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
        int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
        int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = g3;
        layoutParams2.topMargin = g4;
        i(layoutParams2);
        this.f43695i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
        this.f43695i.setPadding(g2, g2, g2, g2);
        this.f43695i.setLayoutParams(layoutParams2);
    }

    public void s(boolean z) {
        this.f43695i.setAutoProcess(z);
    }

    public void t(String str) {
        this.f43695i.setHeadText(str);
    }

    public void u(NEGFeedBackView.b bVar) {
        this.f43695i.setEventCallback(bVar);
    }

    public final void v(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f43695i.getLayoutParams();
        if (this.f43695i.getParent() == null || layoutParams == null || layoutParams.topMargin != i2) {
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.topMargin = i2;
            i(layoutParams2);
            this.f43695i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43695i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43695i.setLayoutParams(layoutParams2);
        }
    }

    public void w(boolean z) {
        this.f43695i.s(z);
    }

    public b0(TbPageContext tbPageContext, Align align) {
        h(-1);
        NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(tbPageContext);
        this.f43695i = nEGFeedBackView;
        nEGFeedBackView.setId(R.id.decor_item_right_id);
        g(this.f43695i);
        l(align);
    }
}
