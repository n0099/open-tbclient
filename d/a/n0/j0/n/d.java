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
    public TbPageContext<?> f59907a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f59908b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f59909c = new a();

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f59910d = new b();

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.m.f f59911e = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.n0.j0.b.a(d.this.f59907a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            d.a.n0.j0.b.a(d.this.f59907a, null);
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
                d.a.n0.j0.b.a(d.this.f59907a, null);
                return;
            }
            String D = n1Var.D();
            if (k.isForumName(D)) {
                d.this.f59907a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f59907a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f59907a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f59908b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f59908b.setSquareEntranceAtStart(true);
        this.f59908b.setTabName(null);
        this.f59908b.setFrom(0);
        this.f59908b.setOnClickRightArrowListener(this.f59909c);
        this.f59908b.setOnRullOkCallbackr(this.f59910d);
        this.f59908b.setOnItemCoverListener(this.f59911e);
    }

    public void b(o1 o1Var) {
        this.f59908b.a(o1Var);
    }

    public RecommendForumLayout c() {
        return this.f59908b;
    }
}
