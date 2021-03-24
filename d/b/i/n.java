package d.b.i;

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
import d.b.i.u0.a;
/* loaded from: classes2.dex */
public class n extends h {
    public ThreadGodReplyLayout l;
    public d.b.h0.r.q.a m;
    public StatisticItem n;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f51807e;

        public b(View.OnClickListener onClickListener) {
            this.f51807e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(n.this.f51762f);
            String w1 = n.this.m.n().w1();
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(w1, n.this.m.n().z1().D() + "", 1, "other");
            createNormalCfg.setStartFrom(n.this.f51761e.i());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            n.this.f51761e.o(new a.C1117a(1));
            this.f51807e.onClick(view);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a.b {
        public c() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1117a c1117a) {
            d.b.i0.x.m.l(n.this.l.getGodReplyContent(), n.this.m.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
            return false;
        }
    }

    public n(Context context) {
        super(context);
        r(d.b.b.e.p.l.g(context, R.dimen.M_H_X003));
        this.l = new ThreadGodReplyLayout(context);
        a aVar = new a();
        this.l.setAfterClickListener(aVar);
        this.l.setOnClickListener(new b(aVar));
    }

    @Override // d.b.i.a
    public View g() {
        return this.l;
    }

    @Override // d.b.i.a
    public void h() {
        i(1, new c());
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        this.l.l();
    }

    public boolean u() {
        ThreadGodReplyLayout threadGodReplyLayout = this.l;
        return threadGodReplyLayout == null || threadGodReplyLayout.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i.p
    /* renamed from: v */
    public void a(d.b.h0.r.q.a aVar) {
        this.m = aVar;
        PostData z1 = aVar.n().z1();
        if (this.n != null && z1 != null && z1.s() != null && z1.s().getUserId() != null) {
            this.n.param("tid", aVar.n().A).param("post_id", z1.D()).param("uid", z1.s().getUserId());
            d.b.i0.x.t.b().a(this.n);
        }
        this.l.setData(aVar.n());
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
