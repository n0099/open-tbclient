package d.b.i0.p0.h1;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class b extends d.b.i0.x.b<c> {
    public TbImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public RelativeLayout q;
    public ConstrainImageGroup r;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View m = m();
        this.m = (TbImageView) m.findViewById(R.id.ad_portrait);
        this.n = (TextView) m.findViewById(R.id.ad_title);
        this.o = (TextView) m.findViewById(R.id.ad_desc);
        this.r = (ConstrainImageGroup) m.findViewById(R.id.ad_img_layout);
        this.p = m.findViewById(R.id.item_divider);
        this.q = (RelativeLayout) m.findViewById(R.id.frs_ad_list_item_view);
        m.setOnClickListener(this);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.frs_ad_list_item_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.f62180e != i) {
            this.f62180e = i;
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.q, R.drawable.ad_list_item_bg);
            this.r.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(c cVar) {
        if (cVar == null) {
            return;
        }
        this.m.setPlaceHolder(1);
        this.m.W(cVar.n(), 10, false);
        this.m.setRadius(l.g(b(), R.dimen.tbds26));
        this.m.setDrawerType(1);
        this.m.setDrawBorder(true);
        this.m.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.m.setBorderWidth(l.g(b(), R.dimen.tbds1));
        this.m.setDefaultResource(R.drawable.transparent_bg);
        this.m.setDefaultBgResource(R.drawable.transparent_bg);
        this.n.setText(cVar.j());
        this.o.setText(cVar.g());
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.q, R.drawable.ad_list_item_bg);
        if (ListUtils.getCount(cVar.t()) > 0) {
            d.b.h0.b1.j.f fVar = new d.b.h0.b1.j.f(3);
            fVar.d(1.0d);
            this.r.setVisibility(0);
            this.r.setFromCDN(true);
            this.r.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
            this.r.setImageProcessor(fVar);
            this.r.setImageMediaList(cVar.t());
            if (!cVar.s()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.g(b(), R.dimen.tbds16));
                layoutParams.addRule(12);
                this.p.setLayoutParams(layoutParams);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
                this.p.setVisibility(0);
                return;
            }
            this.p.setVisibility(8);
            return;
        }
        this.r.setVisibility(8);
        if (!cVar.s()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.g(b(), R.dimen.tbds1));
            layoutParams2.addRule(12);
            this.p.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            this.p.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
    }

    public void v(d.b.b.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup = this.r;
        if (constrainImageGroup != null) {
            constrainImageGroup.setImageViewPool(bVar);
        }
    }

    public void w(d.b.b.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup = this.r;
        if (constrainImageGroup != null) {
            constrainImageGroup.setConstrainLayoutPool(bVar);
        }
    }

    public void x(double d2) {
        ConstrainImageGroup constrainImageGroup = this.r;
        if (constrainImageGroup != null) {
            constrainImageGroup.setSingleImageRatio(d2);
        }
    }
}
