package d.b.v;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mcn.McnVideoAdView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f64801a;

    /* renamed from: b  reason: collision with root package name */
    public McnVideoAdView f64802b;

    /* renamed from: c  reason: collision with root package name */
    public McnVideoAdView.c f64803c = new a(this);

    /* loaded from: classes2.dex */
    public class a implements McnVideoAdView.c {
        public a(c cVar) {
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void a(d.b.v.a aVar) {
            if (aVar == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13404");
            statisticItem.param("tid", aVar.f64794e);
            statisticItem.param("fid", aVar.f64795f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", aVar.f64796g);
            TiebaStatic.log(statisticItem);
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void b(d.b.v.a aVar) {
            if (aVar == null || StringUtils.isNull(aVar.f64793d)) {
                return;
            }
            b.b().c(aVar.f64793d);
        }

        @Override // com.baidu.mcn.McnVideoAdView.c
        public void c(d.b.v.a aVar) {
            if (aVar == null) {
                return;
            }
            StatisticItem statisticItem = new StatisticItem("c13405");
            statisticItem.param("tid", aVar.f64794e);
            statisticItem.param("fid", aVar.f64795f);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", aVar.f64796g);
            TiebaStatic.log(statisticItem);
        }
    }

    public c(Context context) {
        this.f64801a = context;
        McnVideoAdView mcnVideoAdView = new McnVideoAdView(context);
        this.f64802b = mcnVideoAdView;
        mcnVideoAdView.setIMcnStatListener(this.f64803c);
    }

    public void a() {
        McnVideoAdView mcnVideoAdView = this.f64802b;
        if (mcnVideoAdView != null) {
            mcnVideoAdView.f();
        }
    }

    public void b() {
        McnVideoAdView mcnVideoAdView = this.f64802b;
        if (mcnVideoAdView != null) {
            mcnVideoAdView.g();
        }
    }

    public boolean c() {
        McnVideoAdView mcnVideoAdView = this.f64802b;
        if (mcnVideoAdView != null) {
            return mcnVideoAdView.i();
        }
        return false;
    }

    public void d() {
        McnVideoAdView mcnVideoAdView = this.f64802b;
        if (mcnVideoAdView != null) {
            mcnVideoAdView.k();
        }
    }

    public void e(d.b.v.a aVar, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView = this.f64802b;
        if (mcnVideoAdView != null) {
            mcnVideoAdView.l(aVar, viewGroup);
        }
    }

    public void f(d.b.v.a aVar, ViewGroup viewGroup) {
        McnVideoAdView mcnVideoAdView = this.f64802b;
        if (mcnVideoAdView != null) {
            mcnVideoAdView.m(aVar, viewGroup);
        }
    }
}
