package d.b.i0.t.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class f extends d.b.i0.x.b<d.b.i0.t.d.c.f.b.b> {
    public TextView m;
    public TextView n;
    public HeadImageView o;
    public TextView p;
    public View q;
    public d.b.i0.t.d.c.f.b.b r;
    public RelativeLayout s;

    public f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.q = m();
        this.s = (RelativeLayout) m().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.m = (TextView) m().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.n = (TextView) m().findViewById(R.id.id_tab_live_sub_offline_item_description);
        HeadImageView headImageView = (HeadImageView) m().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.o = headImageView;
        headImageView.setAutoChangeStyle(true);
        this.o.setIsRound(true);
        this.o.setDrawBorder(true);
        this.o.setPlaceHolder(1);
        this.o.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.o.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.p = (TextView) m().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.s.setOnClickListener(this);
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.tab_sub_live_offline_item_view;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundResource(this.q, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0108);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (i() != null) {
            i().a(view, this.r);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: u */
    public void n(d.b.i0.t.d.c.f.b.b bVar) {
        if (bVar != null) {
            this.r = bVar;
            String str = bVar.f61924g;
            if (StringUtils.isNull(str)) {
                str = StringUtils.isNull(bVar.f61923f) ? "" : bVar.f61923f;
            }
            this.m.setText(str);
            this.n.setText(StringUtils.isNull(bVar.i) ? "" : bVar.i);
            this.o.W(bVar.f61925h, 10, false);
            this.p.setText(StringUtils.isNull(bVar.j) ? "" : bVar.j);
        }
    }
}
