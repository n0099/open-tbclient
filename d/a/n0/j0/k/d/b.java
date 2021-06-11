package d.a.n0.j0.k.d;

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
public class b extends d.a.n0.z.b<d.a.n0.j0.k.c.c> {
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
        public void a(d.a.n0.j0.k.c.b bVar) {
            b bVar2 = b.this;
            bVar2.A(bVar, bVar2.n);
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.a.n0.j0.k.c.b bVar) {
            b.this.z(bVar);
        }
    }

    /* renamed from: d.a.n0.j0.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1436b implements RecommendForumItemView.a {
        public C1436b() {
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(d.a.n0.j0.k.c.b bVar) {
            b bVar2 = b.this;
            bVar2.A(bVar, bVar2.o);
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.a.n0.j0.k.c.b bVar) {
            b.this.z(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumItemView f59717a;

        public c(RecommendForumItemView recommendForumItemView) {
            this.f59717a = recommendForumItemView;
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
                if (this.f59717a == b.this.n) {
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
        F();
        this.n.setForumItemClickListener(new a());
        this.o.setForumItemClickListener(new C1436b());
    }

    public final void A(d.a.n0.j0.k.c.b bVar, RecommendForumItemView recommendForumItemView) {
        if (!l.D()) {
            UtilHelper.showToast(this.f67159f.getPageActivity(), this.f67159f.getString(R.string.neterror));
        } else if (bVar == null || StringUtils.isNull(bVar.f59694c) || bVar.f59693b <= 0) {
        } else {
            if (!ViewHelper.checkUpIsLogin(b())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.q == null) {
                this.q = new LikeModel(this.m);
            }
            this.q.setLoadDataCallBack(new c(recommendForumItemView));
            if (k.isForumName(bVar.f59694c)) {
                this.q.L(bVar.f59694c, String.valueOf(bVar.f59693b));
            }
            B(bVar, "1");
        }
    }

    public final void B(d.a.n0.j0.k.c.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(bVar.f59699h));
        statisticItem.param("fid", bVar.f59693b);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", str);
        TiebaStatic.log(statisticItem);
    }

    public final void F() {
        View m = m();
        this.n = (RecommendForumItemView) m.findViewById(R.id.reommend_forum_one);
        this.o = (RecommendForumItemView) m.findViewById(R.id.reommend_forum_two);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: G */
    public void n(d.a.n0.j0.k.c.c cVar) {
        if (cVar == null) {
            return;
        }
        o(this.m, this.p);
        if (cVar.f59701e != null) {
            this.n.setVisibility(0);
            this.n.c(cVar.f59701e);
        } else {
            this.n.setVisibility(4);
        }
        if (cVar.f59702f != null) {
            this.o.setVisibility(0);
            this.o.c(cVar.f59702f);
            return;
        }
        this.o.setVisibility(4);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.recommend_forum_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
        this.p = i2;
        this.n.d();
        this.o.d();
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public final void z(d.a.n0.j0.k.c.b bVar) {
        this.m.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.m.getPageActivity()).createNormalCfg(bVar.f59694c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        B(bVar, "2");
    }
}
