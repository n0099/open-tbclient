package d.b.j0.i0.k.d;

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
import d.b.c.a.e;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
/* loaded from: classes4.dex */
public class b extends d.b.j0.x.b<d.b.j0.i0.k.c.c> {
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
        public void a(d.b.j0.i0.k.c.b bVar) {
            b bVar2 = b.this;
            bVar2.B(bVar, bVar2.n);
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.b.j0.i0.k.c.b bVar) {
            b.this.A(bVar);
        }
    }

    /* renamed from: d.b.j0.i0.k.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1351b implements RecommendForumItemView.a {
        public C1351b() {
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void a(d.b.j0.i0.k.c.b bVar) {
            b bVar2 = b.this;
            bVar2.B(bVar, bVar2.o);
        }

        @Override // com.baidu.tieba.enterForum.recommend.view.RecommendForumItemView.a
        public void b(d.b.j0.i0.k.c.b bVar) {
            b.this.A(bVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RecommendForumItemView f57206a;

        public c(RecommendForumItemView recommendForumItemView) {
            this.f57206a = recommendForumItemView;
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (b.this.q.getErrorCode() == 22) {
                l.L(b.this.m.getPageActivity(), b.this.m.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (b.this.q.getErrorCode() != 0) {
                    l.L(b.this.m.getPageActivity(), b.this.q.getErrorString());
                    return;
                }
                if (this.f57206a == b.this.n) {
                    b.this.n.e(true);
                } else {
                    b.this.o.e(true);
                }
                l.L(b.this.m.getPageActivity(), b.this.m.getString(R.string.attention_success));
            }
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.p = 3;
        this.m = tbPageContext;
        F();
        this.n.setForumItemClickListener(new a());
        this.o.setForumItemClickListener(new C1351b());
    }

    public final void A(d.b.j0.i0.k.c.b bVar) {
        this.m.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.m.getPageActivity()).createNormalCfg(bVar.f57184c, FrsActivityConfig.FRS_FROM_TAB_RECOMMEND_FORUM).setCallFrom(11)));
        E(bVar, "2");
    }

    public final void B(d.b.j0.i0.k.c.b bVar, RecommendForumItemView recommendForumItemView) {
        if (!l.C()) {
            UtilHelper.showToast(this.f64177f.getPageActivity(), this.f64177f.getString(R.string.neterror));
        } else if (bVar == null || StringUtils.isNull(bVar.f57184c) || bVar.f57183b <= 0) {
        } else {
            if (!ViewHelper.checkUpIsLogin(b())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
                return;
            }
            if (this.q == null) {
                this.q = new LikeModel(this.m);
            }
            this.q.setLoadDataCallBack(new c(recommendForumItemView));
            if (k.isForumName(bVar.f57184c)) {
                this.q.H(bVar.f57184c, String.valueOf(bVar.f57183b));
            }
            E(bVar, "1");
        }
    }

    public final void E(d.b.j0.i0.k.c.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13375");
        statisticItem.param("obj_type", String.valueOf(bVar.f57189h));
        statisticItem.param("fid", bVar.f57183b);
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
    @Override // d.b.j0.x.b
    /* renamed from: G */
    public void n(d.b.j0.i0.k.c.c cVar) {
        if (cVar == null) {
            return;
        }
        o(this.m, this.p);
        if (cVar.f57191e != null) {
            this.n.setVisibility(0);
            this.n.c(cVar.f57191e);
        } else {
            this.n.setVisibility(4);
        }
        if (cVar.f57192f != null) {
            this.o.setVisibility(0);
            this.o.c(cVar.f57192f);
            return;
        }
        this.o.setVisibility(4);
    }

    @Override // d.b.j0.x.b
    public int h() {
        return R.layout.recommend_forum_layout;
    }

    @Override // d.b.j0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        this.p = i;
        this.n.d();
        this.o.d();
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
