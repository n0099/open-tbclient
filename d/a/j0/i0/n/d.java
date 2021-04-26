package d.a.j0.i0.n;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import d.a.c.e.p.k;
import d.a.i0.r.q.n1;
import d.a.i0.r.q.o1;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55327a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f55328b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f55329c = new a();

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f55330d = new b();

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.m.f f55331e = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.i0.b.a(d.this.f55327a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            d.a.j0.i0.b.a(d.this.f55327a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.i0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                d.a.j0.i0.b.a(d.this.f55327a, null);
                return;
            }
            String D = n1Var.D();
            if (k.isForumName(D)) {
                d.this.f55327a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f55327a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f55327a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f55328b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f55328b.setSquareEntranceAtStart(true);
        this.f55328b.setTabName(null);
        this.f55328b.setFrom(0);
        this.f55328b.setOnClickRightArrowListener(this.f55329c);
        this.f55328b.setOnRullOkCallbackr(this.f55330d);
        this.f55328b.setOnItemCoverListener(this.f55331e);
    }

    public void b(o1 o1Var) {
        this.f55328b.a(o1Var);
    }

    public RecommendForumLayout c() {
        return this.f55328b;
    }
}
