package d.a.k0.i0.n;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import d.a.c.e.p.k;
import d.a.j0.r.q.n1;
import d.a.j0.r.q.o1;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f56034a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f56035b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f56036c = new a();

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f56037d = new b();

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.m.f f56038e = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.k0.i0.b.a(d.this.f56034a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            d.a.k0.i0.b.a(d.this.f56034a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.j0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                d.a.k0.i0.b.a(d.this.f56034a, null);
                return;
            }
            String D = n1Var.D();
            if (k.isForumName(D)) {
                d.this.f56034a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f56034a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f56034a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f56035b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f56035b.setSquareEntranceAtStart(true);
        this.f56035b.setTabName(null);
        this.f56035b.setFrom(0);
        this.f56035b.setOnClickRightArrowListener(this.f56036c);
        this.f56035b.setOnRullOkCallbackr(this.f56037d);
        this.f56035b.setOnItemCoverListener(this.f56038e);
    }

    public void b(o1 o1Var) {
        this.f56035b.a(o1Var);
    }

    public RecommendForumLayout c() {
        return this.f56035b;
    }
}
