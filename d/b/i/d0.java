package d.b.i;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import d.b.i0.r.q.a2;
/* loaded from: classes.dex */
public class d0 extends c implements p<a2>, q {
    public static final int s = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds62);
    public RelativeLayout i;
    public ImageView j;
    public FrameLayout k;
    public a2 l;
    public BdUniqueId m;
    public int n;
    public Align q;
    public int o = R.drawable.ic_icon_pure_card_delete_svg;
    public int p = R.color.CAM_X0111;
    public View.OnClickListener r = new a();

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d0.this.l == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921428, d0.this.m);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921428, d0.this.l);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public d0(Context context, int i) {
        this.n = 0;
        this.n = i;
        this.i = new RelativeLayout(context);
        this.j = new ImageView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.k = frameLayout;
        ImageView imageView = this.j;
        int i2 = s;
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i2, i2));
        this.k.setOnClickListener(this.r);
        m(Align.ALIGN_RIGHT_BOTTOM);
        this.i.addView(this.k);
        g(this.i);
        h(-1);
        i(new RelativeLayout.LayoutParams(-1, -1));
    }

    public void m(Align align) {
        if (align == this.q) {
            return;
        }
        if (align == Align.ALIGN_RIGHT_TOP) {
            int g2 = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds77);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams.topMargin = g2;
            layoutParams.bottomMargin = 0;
            this.k.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams2.topMargin = 0;
            layoutParams2.bottomMargin = 0;
            this.k.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
            layoutParams3.bottomMargin = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds51);
            layoutParams3.topMargin = 0;
            this.k.setLayoutParams(layoutParams3);
        }
        this.q = align;
    }

    public void n(d.b.i0.r.q.a aVar) {
        m(Align.ALIGN_RIGHT_TOP);
    }

    public final boolean o(int i) {
        return (i & this.n) > 0;
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, this.o, this.p, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: p */
    public void a(a2 a2Var) {
        this.l = a2Var;
        if (a2Var == null) {
            this.k.setVisibility(8);
        } else if (!o(4)) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, this.o, this.p, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public void q(BdUniqueId bdUniqueId) {
        this.m = bdUniqueId;
    }
}
