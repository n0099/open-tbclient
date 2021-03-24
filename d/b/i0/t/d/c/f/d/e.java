package d.b.i0.t.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class e extends d.b.i0.x.b<d.b.i0.t.d.c.f.b.a> {
    public TextView m;
    public TextView n;
    public TbImageView o;
    public TbImageView p;
    public View q;
    public d.b.i0.t.d.c.f.b.a r;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.q = m();
        this.m = (TextView) m().findViewById(R.id.id_tab_live_sub_notification_title);
        this.n = (TextView) m().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.o = (TbImageView) m().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        TbImageView tbImageView = (TbImageView) m().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.p = tbImageView;
        tbImageView.setAutoChangeStyle(true);
        this.p.setDefaultResource(17170445);
        this.p.setDefaultBgResource(17170445);
        this.o.setOnClickListener(this);
        this.n.setOnClickListener(this);
        o(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.tab_sub_notification_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setBackgroundResource(this.q, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
        SkinManager.setImageResource(this.o, R.drawable.icon_tab_live_close_n);
        SkinManager.setBackgroundResource(this.n, R.drawable.tab_sub_notification_btn_bg_selecor);
        SkinManager.setImageResource(this.p, R.drawable.bg_tab_live_notification);
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
    public void n(d.b.i0.t.d.c.f.b.a aVar) {
        this.r = aVar;
    }
}
