package d.a.i;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.i.u0.a;
/* loaded from: classes.dex */
public class n extends h {
    public ThreadGodReplyLayout l;
    public d.a.i0.r.q.a m;
    public StatisticItem n;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (n.this.d() != null) {
                n.this.d().a(view, n.this.m);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f47743e;

        public b(View.OnClickListener onClickListener) {
            this.f47743e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(n.this.f47690f);
            String w1 = n.this.m.m().w1();
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(w1, n.this.m.m().z1().E() + "", 1, "other");
            createNormalCfg.setStartFrom(n.this.f47689e.i());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            n.this.f47689e.o(new a.C1011a(1));
            this.f47743e.onClick(view);
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.b {
        public c() {
        }

        @Override // d.a.i.u0.a.b
        public boolean a(a.C1011a c1011a) {
            d.a.j0.x.m.l(n.this.l.getGodReplyContent(), n.this.m.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return false;
        }
    }

    public n(Context context) {
        super(context);
        r(d.a.c.e.p.l.g(context, R.dimen.M_H_X003));
        this.l = new ThreadGodReplyLayout(context);
        a aVar = new a();
        this.l.setAfterClickListener(aVar);
        this.l.setOnClickListener(new b(aVar));
    }

    @Override // d.a.i.a
    public View g() {
        return this.l;
    }

    @Override // d.a.i.a
    public void h() {
        i(1, new c());
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        this.l.k();
    }

    public boolean u() {
        ThreadGodReplyLayout threadGodReplyLayout = this.l;
        return threadGodReplyLayout == null || threadGodReplyLayout.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: v */
    public void a(d.a.i0.r.q.a aVar) {
        this.m = aVar;
        PostData z1 = aVar.m().z1();
        if (this.n != null && z1 != null && z1.t() != null && z1.t().getUserId() != null) {
            this.n.param("tid", aVar.m().A).param("post_id", z1.E()).param("uid", z1.t().getUserId());
            d.a.j0.x.t.b().a(this.n);
        }
        this.l.setData(aVar.m());
    }

    public void w(String str) {
        this.l.setFrom(str);
    }

    public void x(boolean z) {
        this.l.setFromCDN(z);
    }

    public void y(StatisticItem statisticItem) {
        this.n = statisticItem;
    }
}
