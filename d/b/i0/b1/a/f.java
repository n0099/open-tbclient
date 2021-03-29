package d.b.i0.b1.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.b.h0.r.q.a2;
import d.b.i0.x.b0;
import d.b.i0.x.n;
/* loaded from: classes3.dex */
public class f extends d.b.b.j.e.a<d.b.i0.x.e0.k, d> {
    public TbPageContext<HotTopicActivity> m;
    public boolean n;
    public BdUniqueId o;
    public d.b.b.e.k.b<ConstrainImageLayout> p;
    public d.b.b.e.k.b<TbImageView> q;
    public b0<d.b.i0.x.e0.k> r;

    /* loaded from: classes3.dex */
    public class a implements d.b.b.e.k.c<ConstrainImageLayout> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            constrainImageLayout.removeAllViews();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            return new ConstrainImageLayout(f.this.m.getPageActivity());
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            return constrainImageLayout;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.b.e.k.c<TbImageView> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.b.b.e.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            return tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            TbImageView tbImageView = new TbImageView(f.this.m.getPageActivity());
            tbImageView.setDrawBorder(true);
            tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
            tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
            return tbImageView;
        }

        public TbImageView h(TbImageView tbImageView) {
            tbImageView.setOnClickListener(null);
            tbImageView.setForegroundColor(0);
            return tbImageView;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends b0<d.b.i0.x.e0.k> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.x.b0
        /* renamed from: d */
        public void a(View view, d.b.i0.x.e0.k kVar) {
            if (kVar == null || kVar.n() == null || StringUtils.isNull(kVar.n().w1()) || StringUtils.isNull(kVar.M())) {
                return;
            }
            String topicName = ((HotTopicActivity) f.this.m.getOrignalPage()).getTopicName();
            String hotTopicId = ((HotTopicActivity) f.this.m.getOrignalPage()).getHotTopicId();
            a2 n = kVar.n();
            n.Z3(5);
            if ("c10814".equals(kVar.M())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10814").param("tid", n.o0()).param("obj_name", topicName).param("topic_id", hotTopicId));
            } else if ("c10816".equals(kVar.M())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                TiebaStatic.log(new StatisticItem("c10816").param("post_id", n.w1()).param("obj_name", topicName).param("topic_id", hotTopicId));
            }
            if (f.this.m == null || !(f.this.m.getOrignalPage() instanceof d.b.i0.b1.b.a)) {
                return;
            }
            ((HotTopicActivity) f.this.m.getOrignalPage()).businessStatisticForTopicClick(kVar);
        }
    }

    /* loaded from: classes3.dex */
    public class d extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public n f52022a;

        public d(f fVar, n nVar) {
            super(nVar.m());
            this.f52022a = nVar;
        }
    }

    public f(TbPageContext<HotTopicActivity> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.n = false;
        this.p = new d.b.b.e.k.b<>(new a(), 6, 0);
        this.q = new d.b.b.e.k.b<>(new b(), 12, 0);
        this.r = new c();
        this.m = tbPageContext;
        this.o = tbPageContext.getUniqueId();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public d R(ViewGroup viewGroup) {
        n nVar = new n(this.m);
        nVar.M(this.o);
        nVar.O(this.q);
        nVar.P(this.p);
        nVar.S(false);
        nVar.Q(this.n);
        nVar.l = 0;
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = nVar.o;
        if (threadCommentAndPraiseInfoLayout != null) {
            threadCommentAndPraiseInfoLayout.R = 0;
        }
        return new d(this, nVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, d.b.i0.x.e0.k kVar, d dVar) {
        dVar.f52022a.n(kVar);
        dVar.f52022a.q(this.r);
        dVar.f52022a.U(!(z(i + 1) instanceof d.b.i0.b1.c.n));
        TbPageContext<HotTopicActivity> tbPageContext = this.m;
        if (tbPageContext != null && (tbPageContext.getOrignalPage() instanceof d.b.i0.b1.b.a)) {
            this.m.getOrignalPage().businessStatisticForTopic(kVar);
        }
        return dVar.a();
    }

    public void setFromCDN(boolean z) {
        this.n = z;
    }
}
