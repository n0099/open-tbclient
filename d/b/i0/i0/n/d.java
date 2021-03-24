package d.b.i0.i0.n;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.card.view.RecommendForumLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import d.b.b.e.p.k;
import d.b.h0.r.q.n1;
import d.b.h0.r.q.o1;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55843a;

    /* renamed from: b  reason: collision with root package name */
    public RecommendForumLayout f55844b;

    /* renamed from: c  reason: collision with root package name */
    public View.OnClickListener f55845c = new a();

    /* renamed from: d  reason: collision with root package name */
    public PullLeftRefreshLayout.f f55846d = new b();

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.m.f f55847e = new c();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.i0.i0.b.a(d.this.f55843a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements PullLeftRefreshLayout.f {
        public b() {
        }

        @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.f
        public void a() {
            d.b.i0.i0.b.a(d.this.f55843a, null);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.b.h0.m.f<n1> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: b */
        public void c(View view, n1 n1Var, int i, long j) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.m.f
        /* renamed from: d */
        public void a(View view, n1 n1Var, int i, long j) {
            if (n1Var == null) {
                d.b.i0.i0.b.a(d.this.f55843a, null);
                return;
            }
            String D = n1Var.D();
            if (k.isForumName(D)) {
                d.this.f55843a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(d.this.f55843a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            }
        }
    }

    public d(TbPageContext<?> tbPageContext) {
        this.f55843a = tbPageContext;
        RecommendForumLayout recommendForumLayout = new RecommendForumLayout(tbPageContext);
        this.f55844b = recommendForumLayout;
        recommendForumLayout.setShowMore(true);
        this.f55844b.setSquareEntranceAtStart(true);
        this.f55844b.setTabName(null);
        this.f55844b.setFrom(0);
        this.f55844b.setOnClickRightArrowListener(this.f55845c);
        this.f55844b.setOnRullOkCallbackr(this.f55846d);
        this.f55844b.setOnItemCoverListener(this.f55847e);
    }

    public void b(o1 o1Var) {
        this.f55844b.a(o1Var);
    }

    public RecommendForumLayout c() {
        return this.f55844b;
    }
}
