package d.a.o0.h2.g;

import android.view.View;
import android.widget.LinearLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.personCenter.view.AutoBannerView;
import d.a.o0.h2.e.n;
import java.util.List;
/* loaded from: classes5.dex */
public class e extends d.a.o0.z.b<n> {
    public int m;
    public LinearLayout n;
    public AutoBannerView o;
    public d.a.n0.r.w.b.d<d.a.o0.h2.e.a> p;

    /* loaded from: classes5.dex */
    public class a implements d.a.n0.r.w.b.d<d.a.o0.h2.e.a> {
        public a() {
        }

        @Override // d.a.n0.r.w.b.d
        public void b(int i2, String str) {
            if (e.this.o == null || str == null) {
                return;
            }
            if (e.this.o.a(i2)) {
                TiebaStatic.log(new StatisticItem("c13247").param("obj_locate", i2).param("obj_param1", str));
            }
            e.this.o.f();
            e.this.o.b(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, d.a.o0.h2.e.a aVar) {
            if (e.this.o == null || aVar == null || aVar.c() == null || !e.this.o.a(i2)) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13246").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", i2).param("obj_param1", aVar.c()));
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

    @Override // d.a.o0.z.b
    public int h() {
        return R.layout.person_center_viewpager_layout;
    }

    @Override // d.a.o0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        if (this.m != i2) {
            AutoBannerView autoBannerView = this.o;
            if (autoBannerView != null) {
                autoBannerView.e(i2);
            }
            SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
            this.m = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.z.b
    /* renamed from: u */
    public void n(n nVar) {
        List<d.a.o0.h2.e.a> list;
        o(this.f67284f, TbadkCoreApplication.getInst().getSkinType());
        if (this.n == null || nVar == null || (list = nVar.f59396e) == null || this.o == null || list.size() == 0) {
            return;
        }
        this.o.d(nVar.f59396e);
    }
}
