package d.a.n0.j0.n;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import d.a.c.e.p.k;
import d.a.m0.r.q.n1;
import d.a.m0.r.q.o1;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56218a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f56219b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f56220c = new a();

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f56221d = new b();

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.m.f f56222e = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.j0.b.a(d.this.f56218a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            d.a.n0.j0.b.a(d.this.f56218a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.m0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                d.a.n0.j0.b.a(d.this.f56218a, null);
                return;
            }
            String D = n1Var.D();
            if (k.isForumName(D)) {
                d.this.f56218a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f56218a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f56218a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f56219b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f56219b.setSquareEntranceAtStart(true);
        this.f56219b.setTabName(null);
        this.f56219b.setFrom(0);
        this.f56219b.setOnClickRightArrowListener(this.f56220c);
        this.f56219b.setOnRullOkCallbackr(this.f56221d);
        this.f56219b.setOnItemCoverListener(this.f56222e);
    }

    public void b(o1 o1Var) {
        this.f56219b.a(o1Var);
    }

    public RecommendForumLayout c() {
        return this.f56219b;
    }
}
