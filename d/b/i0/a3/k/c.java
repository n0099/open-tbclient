package d.b.i0.a3.k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.tbadkCore.LikeModel;
import d.b.c.a.e;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.d3.f0;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public class c extends d.b.i0.x.b<d.b.i0.a3.f.b> {
    public View m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TBSpecificationBtn s;
    public String t;
    public String u;
    public d.b.i0.a3.f.b v;
    public LikeModel w;
    public f0 x;
    public boolean y;

    /* loaded from: classes4.dex */
    public class a extends e {
        public a() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            c.this.y = false;
            if (c.this.w.getErrorCode() == 22) {
                l.L(c.this.f63756f.getPageActivity(), c.this.f63756f.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (c.this.w.getErrorCode() != 0) {
                    l.L(c.this.f63756f.getPageActivity(), c.this.w.getErrorString());
                } else {
                    c.this.A(true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f0.a {
        public b() {
        }

        @Override // d.b.i0.d3.f0.a
        public void a(String str, long j) {
            c.this.y = false;
        }

        @Override // d.b.i0.d3.f0.a
        public void b(String str, long j) {
            c.this.y = false;
            c.this.A(false);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.y = false;
        this.t = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.u = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View m = m();
        this.m = m;
        this.n = (BarImageView) m.findViewById(R.id.bar_image);
        this.o = (TextView) m.findViewById(R.id.bar_name);
        this.p = (TextView) m.findViewById(R.id.desc);
        this.q = (TextView) m.findViewById(R.id.member_text);
        this.r = (TextView) m.findViewById(R.id.post_text);
        this.s = (TBSpecificationBtn) m.findViewById(R.id.forum_like_button);
    }

    public void A(boolean z) {
        if (!z) {
            d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
            bVar.q(R.color.CAM_X0302);
            this.s.setConfig(bVar);
            this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            d.b.h0.r.f0.m.b bVar2 = new d.b.h0.r.f0.m.b();
            bVar2.r(R.color.CAM_X0109);
            this.s.setConfig(bVar2);
            this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.v.w(z);
    }

    public final void B(String str) {
        if (k.isEmpty(str)) {
            if (this.p.getVisibility() != 8) {
                this.p.setVisibility(8);
                if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f63756f.getPageActivity(), R.dimen.tbds47);
                    this.o.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        if (this.p.getVisibility() != 0) {
            this.p.setVisibility(0);
            if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f63756f.getPageActivity(), R.dimen.tbds24);
                this.o.requestLayout();
            }
        }
        this.p.setText(str);
    }

    @Override // d.b.i0.x.b
    public int h() {
        return R.layout.square_forum_item_layout;
    }

    @Override // d.b.i0.x.b
    public void o(TbPageContext<?> tbPageContext, int i) {
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        this.s.k();
        SkinManager.setBackgroundColor(m(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatisticItem statisticItem;
        if (this.v == null) {
            return;
        }
        if (this.m == view) {
            y();
            b0<T> b0Var = this.i;
            if (b0Var != 0) {
                b0Var.a(view, this.v);
            }
        } else if (this.s == view) {
            if (this.f63756f.getPageActivity() instanceof ForumSquareActivity) {
                String f2 = ((ForumSquareActivity) this.f63756f.getPageActivity()).getDelegate().f();
                if (!"推荐".equals(f2)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f2);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.v.f53094e);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.v.u() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.v.u()) {
                x();
            } else {
                w();
            }
        }
    }

    public final void w() {
        if (this.y) {
            return;
        }
        if (!l.C()) {
            UtilHelper.showToast(this.f63756f.getPageActivity(), this.f63756f.getString(R.string.neterror));
            return;
        }
        d.b.i0.a3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.n()) || this.v.j() <= 0 || !ViewHelper.checkUpIsLogin(this.f63756f.getPageActivity())) {
            return;
        }
        if (this.w == null) {
            LikeModel likeModel = new LikeModel(this.f63756f);
            this.w = likeModel;
            likeModel.setLoadDataCallBack(new a());
        }
        if (k.isForumName(this.v.n())) {
            this.y = true;
            this.w.E();
            this.w.H(this.v.n(), String.valueOf(this.v.j()));
        }
    }

    public final void x() {
        if (this.y) {
            return;
        }
        if (!l.C()) {
            UtilHelper.showToast(this.f63756f.getPageActivity(), this.f63756f.getString(R.string.neterror));
            return;
        }
        d.b.i0.a3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.n()) || this.v.j() <= 0 || !ViewHelper.checkUpIsLogin(this.f63756f.getPageActivity())) {
            return;
        }
        if (this.x == null) {
            f0 f0Var = new f0();
            this.x = f0Var;
            f0Var.b(new b());
        }
        this.y = true;
        this.x.c(this.v.n(), this.v.j());
    }

    public final void y() {
        d.b.i0.a3.f.b bVar = this.v;
        if (bVar == null) {
            return;
        }
        String n = bVar.n();
        if (k.isForumName(n)) {
            this.f63756f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f63756f.getPageActivity()).createNormalCfg(n, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.x.b
    /* renamed from: z */
    public void n(d.b.i0.a3.f.b bVar) {
        if (bVar == null) {
            return;
        }
        this.v = bVar;
        this.n.setShowOval(true);
        this.n.setShowOuterBorder(false);
        this.n.setShowInnerBorder(true);
        this.n.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.n.setStrokeColorResId(R.color.CAM_X0401);
        this.n.W(bVar.g(), 10, false);
        String n = bVar.n();
        if (k.isEmpty(n)) {
            n = "";
        }
        this.o.setText(n);
        this.q.setText(this.t + " " + StringHelper.numberUniformFormatExtra(bVar.o()));
        this.r.setText(this.u + " " + StringHelper.numberUniformFormatExtra((long) bVar.t()));
        B(bVar.s());
        A(this.v.u());
        this.m.setOnClickListener(this);
        this.s.setOnClickListener(this);
        o(this.f63756f, TbadkCoreApplication.getInst().getSkinType());
    }
}
