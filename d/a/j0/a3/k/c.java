package d.a.j0.a3.k;

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
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.j0.d3.f0;
import d.a.j0.x.b0;
/* loaded from: classes5.dex */
public class c extends d.a.j0.x.b<d.a.j0.a3.f.b> {
    public View m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TBSpecificationBtn s;
    public String t;
    public String u;
    public d.a.j0.a3.f.b v;
    public LikeModel w;
    public f0 x;
    public boolean y;

    /* loaded from: classes5.dex */
    public class a extends e {
        public a() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            c.this.y = false;
            if (c.this.w.getErrorCode() == 22) {
                l.M(c.this.f62437f.getPageActivity(), c.this.f62437f.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (c.this.w.getErrorCode() != 0) {
                    l.M(c.this.f62437f.getPageActivity(), c.this.w.getErrorString());
                } else {
                    c.this.y(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f0.a {
        public b() {
        }

        @Override // d.a.j0.d3.f0.a
        public void a(String str, long j) {
            c.this.y = false;
        }

        @Override // d.a.j0.d3.f0.a
        public void b(String str, long j) {
            c.this.y = false;
            c.this.y(false);
        }
    }

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.y = false;
        this.t = TbadkCoreApplication.getInst().getString(R.string.forum_member_num);
        this.u = TbadkCoreApplication.getInst().getString(R.string.forum_post_num);
        View l = l();
        this.m = l;
        this.n = (BarImageView) l.findViewById(R.id.bar_image);
        this.o = (TextView) l.findViewById(R.id.bar_name);
        this.p = (TextView) l.findViewById(R.id.desc);
        this.q = (TextView) l.findViewById(R.id.member_text);
        this.r = (TextView) l.findViewById(R.id.post_text);
        this.s = (TBSpecificationBtn) l.findViewById(R.id.forum_like_button);
    }

    @Override // d.a.j0.x.b
    public int g() {
        return R.layout.square_forum_item_layout;
    }

    @Override // d.a.j0.x.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.r, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109);
        this.s.k();
        SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StatisticItem statisticItem;
        if (this.v == null) {
            return;
        }
        if (this.m == view) {
            w();
            b0<T> b0Var = this.f62440i;
            if (b0Var != 0) {
                b0Var.a(view, this.v);
            }
        } else if (this.s == view) {
            if (this.f62437f.getPageActivity() instanceof ForumSquareActivity) {
                String f2 = ((ForumSquareActivity) this.f62437f.getPageActivity()).getDelegate().f();
                if (!"推荐".equals(f2)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f2);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.v.f51247e);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.v.u() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.v.u()) {
                v();
            } else {
                u();
            }
        }
    }

    public final void u() {
        if (this.y) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.f62437f.getPageActivity(), this.f62437f.getString(R.string.neterror));
            return;
        }
        d.a.j0.a3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.m()) || this.v.l() <= 0 || !ViewHelper.checkUpIsLogin(this.f62437f.getPageActivity())) {
            return;
        }
        if (this.w == null) {
            LikeModel likeModel = new LikeModel(this.f62437f);
            this.w = likeModel;
            likeModel.setLoadDataCallBack(new a());
        }
        if (k.isForumName(this.v.m())) {
            this.y = true;
            this.w.E();
            this.w.H(this.v.m(), String.valueOf(this.v.l()));
        }
    }

    public final void v() {
        if (this.y) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.f62437f.getPageActivity(), this.f62437f.getString(R.string.neterror));
            return;
        }
        d.a.j0.a3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.m()) || this.v.l() <= 0 || !ViewHelper.checkUpIsLogin(this.f62437f.getPageActivity())) {
            return;
        }
        if (this.x == null) {
            f0 f0Var = new f0();
            this.x = f0Var;
            f0Var.b(new b());
        }
        this.y = true;
        this.x.c(this.v.m(), this.v.l());
    }

    public final void w() {
        d.a.j0.a3.f.b bVar = this.v;
        if (bVar == null) {
            return;
        }
        String m = bVar.m();
        if (k.isForumName(m)) {
            this.f62437f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f62437f.getPageActivity()).createNormalCfg(m, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.x.b
    /* renamed from: x */
    public void m(d.a.j0.a3.f.b bVar) {
        if (bVar == null) {
            return;
        }
        this.v = bVar;
        this.n.setShowOval(true);
        this.n.setShowOuterBorder(false);
        this.n.setShowInnerBorder(true);
        this.n.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.n.setStrokeColorResId(R.color.CAM_X0401);
        this.n.V(bVar.h(), 10, false);
        String m = bVar.m();
        if (k.isEmpty(m)) {
            m = "";
        }
        this.o.setText(m);
        this.q.setText(this.t + " " + StringHelper.numberUniformFormatExtra(bVar.p()));
        this.r.setText(this.u + " " + StringHelper.numberUniformFormatExtra((long) bVar.t()));
        z(bVar.s());
        y(this.v.u());
        this.m.setOnClickListener(this);
        this.s.setOnClickListener(this);
        n(this.f62437f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void y(boolean z) {
        if (!z) {
            d.a.i0.r.f0.m.b bVar = new d.a.i0.r.f0.m.b();
            bVar.q(R.color.CAM_X0302);
            this.s.setConfig(bVar);
            this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            d.a.i0.r.f0.m.b bVar2 = new d.a.i0.r.f0.m.b();
            bVar2.r(R.color.CAM_X0109);
            this.s.setConfig(bVar2);
            this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.v.w(z);
    }

    public final void z(String str) {
        if (k.isEmpty(str)) {
            if (this.p.getVisibility() != 8) {
                this.p.setVisibility(8);
                if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f62437f.getPageActivity(), R.dimen.tbds47);
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
                ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f62437f.getPageActivity(), R.dimen.tbds24);
                this.o.requestLayout();
            }
        }
        this.p.setText(str);
    }
}
