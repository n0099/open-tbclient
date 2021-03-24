package d.b.i0.f2.g;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.AutoBannerView;
import d.b.i0.f2.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends d.b.i0.x.b<n> {
    public int m;
    public LinearLayout n;
    public AutoBannerView o;
    public d.b.h0.r.w.b.d<d.b.i0.f2.e.a> p;

    /* loaded from: classes5.dex */
    public class a implements d.b.h0.r.w.b.d<d.b.i0.f2.e.a> {
        public a() {
        }

        @Override // d.b.h0.r.w.b.d
        public void b(int i, String str) {
            if (e.this.o == null || str == null) {
                return;
            }
            if (e.this.o.a(i)) {
                TiebaStatic.log(new StatisticItem("c13247").param("obj_locate", i).param("obj_param1", str));
            }
            e.this.o.f();
            e.this.o.b(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.r.w.b.d
        /* renamed from: c */
        public void a(int i, d.b.i0.f2.e.a aVar) {
            if (e.this.o == null || aVar == null || aVar.c() == null || !e.this.o.a(i)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13246").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i).param("obj_param1", aVar.c()));
        }
    }

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.m = 3;
        this.p = new a();
        View m = m();
        this.n = (LinearLayout) m.findViewById(R.id.viewpager);
        AutoBannerView autoBannerView = (AutoBannerView) m.findViewById(R.id.person_center_auto_banner_view);
        this.o = autoBannerView;
        autoBannerView.setMarqueenTime(3000L);
        this.o.getCoverFlowView().setCallback(this.p);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.person_center_viewpager_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        if (this.m != i) {
            AutoBannerView autoBannerView = this.o;
            if (autoBannerView != null) {
                autoBannerView.e(i);
            }
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
            this.m = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: v */
    public void n(n nVar) {
        List<d.b.i0.f2.e.a> list;
        o(this.f62180f, TbadkCoreApplication.getInst().getSkinType());
        if (this.n == null || nVar == null || (list = nVar.f54807e) == null || this.o == null || list.size() == 0) {
            return;
        }
        this.o.d(nVar.f54807e);
    }
}
