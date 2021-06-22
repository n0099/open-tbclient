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
import d.a.i.v0.a;
/* loaded from: classes.dex */
public class n extends h {
    public ThreadGodReplyLayout l;
    public d.a.n0.r.q.a m;
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
        public final /* synthetic */ View.OnClickListener f43833e;

        public b(View.OnClickListener onClickListener) {
            this.f43833e = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbActivityConfig pbActivityConfig = new PbActivityConfig(n.this.f43782f);
            String z1 = n.this.m.i().z1();
            PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(z1, n.this.m.i().C1().E() + "", 1, "other");
            createNormalCfg.setStartFrom(n.this.f43781e.i());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            n.this.f43781e.o(new a.C0602a(1));
            this.f43833e.onClick(view);
        }
    }

    /* loaded from: classes.dex */
    public class c implements a.b {
        public c() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0602a c0602a) {
            d.a.o0.z.m.l(n.this.l.getGodReplyContent(), n.this.m.i().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
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
        this.l.l();
    }

    public boolean u() {
        ThreadGodReplyLayout threadGodReplyLayout = this.l;
        return threadGodReplyLayout == null || threadGodReplyLayout.getVisibility() != 8;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: v */
    public void a(d.a.n0.r.q.a aVar) {
        this.m = aVar;
        PostData C1 = aVar.i().C1();
        if (this.n != null && C1 != null && C1.t() != null && C1.t().getUserId() != null) {
            this.n.param("tid", aVar.i().A).param("post_id", C1.E()).param("uid", C1.t().getUserId());
            d.a.o0.z.t.b().a(this.n);
        }
        this.l.setData(aVar.i());
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
