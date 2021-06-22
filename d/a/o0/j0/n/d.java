package d.a.o0.j0.n;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import d.a.c.e.p.k;
import d.a.n0.r.q.n1;
import d.a.n0.r.q.o1;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60032a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f60033b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f60034c = new a();

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f60035d = new b();

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.m.f f60036e = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.o0.j0.b.a(d.this.f60032a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            d.a.o0.j0.b.a(d.this.f60032a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.n0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i2, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i2, long j) {
            if (n1Var == null) {
                d.a.o0.j0.b.a(d.this.f60032a, null);
                return;
            }
            String D = n1Var.D();
            if (k.isForumName(D)) {
                d.this.f60032a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f60032a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f60032a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f60033b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f60033b.setSquareEntranceAtStart(true);
        this.f60033b.setTabName(null);
        this.f60033b.setFrom(0);
        this.f60033b.setOnClickRightArrowListener(this.f60034c);
        this.f60033b.setOnRullOkCallbackr(this.f60035d);
        this.f60033b.setOnItemCoverListener(this.f60036e);
    }

    public void b(o1 o1Var) {
        this.f60033b.a(o1Var);
    }

    public RecommendForumLayout c() {
        return this.f60033b;
    }
}
