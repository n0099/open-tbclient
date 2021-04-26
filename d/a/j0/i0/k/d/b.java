package d.a.j0.i0.k.d;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView;
import com.baidu.tieba.tbadkCore.LikeModel;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class b extends d.a.j0.x.b<d.a.j0.i0.k.c.c> {
    public TbPageContext m;
    public RecommendForumItemView n;
    public RecommendForumItemView o;
    public int p;
    public LikeModel q;

    /* loaded from: classes4.dex */
    public class a implements RecommendForumItemView.a {
        public a() {
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(d.a.j0.i0.k.c.b bVar) {
            b bVar2 = b.this;
            bVar2.z(bVar, bVar2.n);
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.a.j0.i0.k.c.b bVar) {
            b.this.y(bVar);
        }
    }

    /* renamed from: d.a.j0.i0.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1290b implements RecommendForumItemView.a {
        public C1290b() {
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(d.a.j0.i0.k.c.b bVar) {
            b bVar2 = b.this;
            bVar2.z(bVar, bVar2.o);
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.a.j0.i0.k.c.b bVar) {
            b.this.y(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumItemView f55137a;

        public c(RecommendForumItemView recommendForumItemView) {
            this.f55137a = recommendForumItemView;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (b.this.q.getErrorCode() == 22) {
                l.M(b.this.m.getPageActivity(), b.this.m.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (b.this.q.getErrorCode() != 0) {
                    l.M(b.this.m.getPageActivity(), b.this.q.getErrorString());
                    return;
                }
                if (this.f55137a == b.this.n) {
                    b.this.n.e(true);
                } else {
                    b.this.o.e(true);
                }
                l.M(b.this.m.getPageActivity(), b.this.m.getString(R.string.attention_success));
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.p = 3;
        this.m = tbPageContext;
        B();
        this.n.setForumItemClickListener(new a());
        this.o.setForumItemClickListener(new C1290b());
    }

    public final void A(d.a.j0.i0.k.c.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(bVar.f55119h));
        statisticItem.param("fid", bVar.f55113b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", str);
        TiebaStatic.log(statisticItem);
    }

    public final void B() {
        View l = l();
        this.n = (RecommendForumItemView) l.findViewById(R.id.reommend_forum_one);
        this.o = (RecommendForumItemView) l.findViewById(R.id.reommend_forum_two);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: F */
    public void m(d.a.j0.i0.k.c.c cVar) {
        if (cVar == null) {
            return;
        }
        n(this.m, this.p);
        if (cVar.f55121e != null) {
            this.n.setVisibility(0);
            this.n.c(cVar.f55121e);
        } else {
            this.n.setVisibility(4);
        }
        if (cVar.f55122f != null) {
            this.o.setVisibility(0);
            this.o.c(cVar.f55122f);
            return;
        }
        this.o.setVisibility(4);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.recommend_forum_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        this.p = i2;
        this.n.d();
        this.o.d();
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void y(d.a.j0.i0.k.c.b bVar) {
        this.m.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.m.getPageActivity()).createNormalCfg(bVar.f55114c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        A(bVar, "2");
    }

    public final void z(d.a.j0.i0.k.c.b bVar, RecommendForumItemView recommendForumItemView) {
        if (!l.D()) {
            UtilHelper.showToast(this.f62437f.getPageActivity(), this.f62437f.getString(R.string.neterror));
        } else if (bVar == null || StringUtils.isNull(bVar.f55114c) || bVar.f55113b <= 0) {
        } else {
            if (!ViewHelper.checkUpIsLogin(b())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.q == null) {
                this.q = new LikeModel(this.m);
            }
            this.q.setLoadDataCallBack(new c(recommendForumItemView));
            if (k.isForumName(bVar.f55114c)) {
                this.q.H(bVar.f55114c, String.valueOf(bVar.f55113b));
            }
            A(bVar, "1");
        }
    }
}
