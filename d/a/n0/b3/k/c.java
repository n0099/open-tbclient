package d.a.n0.b3.k;

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
import d.a.n0.e3.f0;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public class c extends d.a.n0.z.b<d.a.n0.b3.f.b> {
    public View m;
    public BarImageView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TBSpecificationBtn s;
    public String t;
    public String u;
    public d.a.n0.b3.f.b v;
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
                l.M(c.this.f67159f.getPageActivity(), c.this.f67159f.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (c.this.w.getErrorCode() != 0) {
                    l.M(c.this.f67159f.getPageActivity(), c.this.w.getErrorString());
                } else {
                    c.this.z(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f0.a {
        public b() {
        }

        @Override // d.a.n0.e3.f0.a
        public void a(String str, long j) {
            c.this.y = false;
        }

        @Override // d.a.n0.e3.f0.a
        public void b(String str, long j) {
            c.this.y = false;
            c.this.z(false);
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

    public final void A(String str) {
        if (k.isEmpty(str)) {
            if (this.p.getVisibility() != 8) {
                this.p.setVisibility(8);
                if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f67159f.getPageActivity(), R.dimen.tbds47);
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
                ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = l.g(this.f67159f.getPageActivity(), R.dimen.tbds24);
                this.o.requestLayout();
            }
        }
        this.p.setText(str);
    }

    @Override // d.a.n0.z.b
    public int h() {
        return R.layout.square_forum_item_layout;
    }

    @Override // d.a.n0.z.b
    public void o(TbPageContext<?> tbPageContext, int i2) {
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
            x();
            b0<T> b0Var = this.f67162i;
            if (b0Var != 0) {
                b0Var.a(view, this.v);
            }
        } else if (this.s == view) {
            if (this.f67159f.getPageActivity() instanceof ForumSquareActivity) {
                String f2 = ((ForumSquareActivity) this.f67159f.getPageActivity()).getDelegate().f();
                if (!"推荐".equals(f2)) {
                    statisticItem = new StatisticItem("c13653");
                    statisticItem.param(TiebaStatic.Params.RESOURCE_ID, f2);
                } else {
                    statisticItem = new StatisticItem("c13644");
                    statisticItem.param("obj_locate", 3);
                }
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", this.v.f55802e);
                statisticItem.param(TiebaStatic.Params.OBJ_TO, this.v.q() ? 2 : 1);
                TiebaStatic.log(statisticItem);
            }
            if (this.v.q()) {
                w();
            } else {
                v();
            }
        }
    }

    public final void v() {
        if (this.y) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.f67159f.getPageActivity(), this.f67159f.getString(R.string.neterror));
            return;
        }
        d.a.n0.b3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.i()) || this.v.g() <= 0 || !ViewHelper.checkUpIsLogin(this.f67159f.getPageActivity())) {
            return;
        }
        if (this.w == null) {
            LikeModel likeModel = new LikeModel(this.f67159f);
            this.w = likeModel;
            likeModel.setLoadDataCallBack(new a());
        }
        if (k.isForumName(this.v.i())) {
            this.y = true;
            this.w.I();
            this.w.L(this.v.i(), String.valueOf(this.v.g()));
        }
    }

    public final void w() {
        if (this.y) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.f67159f.getPageActivity(), this.f67159f.getString(R.string.neterror));
            return;
        }
        d.a.n0.b3.f.b bVar = this.v;
        if (bVar == null || StringUtils.isNull(bVar.i()) || this.v.g() <= 0 || !ViewHelper.checkUpIsLogin(this.f67159f.getPageActivity())) {
            return;
        }
        if (this.x == null) {
            f0 f0Var = new f0();
            this.x = f0Var;
            f0Var.b(new b());
        }
        this.y = true;
        this.x.c(this.v.i(), this.v.g());
    }

    public final void x() {
        d.a.n0.b3.f.b bVar = this.v;
        if (bVar == null) {
            return;
        }
        String i2 = bVar.i();
        if (k.isForumName(i2)) {
            this.f67159f.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f67159f.getPageActivity()).createNormalCfg(i2, FrsActivityConfig.FRS_FROM_SQUARE).setCallFrom(5)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.z.b
    /* renamed from: y */
    public void n(d.a.n0.b3.f.b bVar) {
        if (bVar == null) {
            return;
        }
        this.v = bVar;
        this.n.setShowOval(true);
        this.n.setShowOuterBorder(false);
        this.n.setShowInnerBorder(true);
        this.n.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.n.setStrokeColorResId(R.color.CAM_X0401);
        this.n.U(bVar.c(), 10, false);
        String i2 = bVar.i();
        if (k.isEmpty(i2)) {
            i2 = "";
        }
        this.o.setText(i2);
        this.q.setText(this.t + " " + StringHelper.numberUniformFormatExtra(bVar.k()));
        this.r.setText(this.u + " " + StringHelper.numberUniformFormatExtra((long) bVar.p()));
        A(bVar.o());
        z(this.v.q());
        this.m.setOnClickListener(this);
        this.s.setOnClickListener(this);
        o(this.f67159f, TbadkCoreApplication.getInst().getSkinType());
    }

    public void z(boolean z) {
        if (!z) {
            d.a.m0.r.f0.m.b bVar = new d.a.m0.r.f0.m.b();
            bVar.q(R.color.CAM_X0302);
            this.s.setConfig(bVar);
            this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_doLike));
        } else {
            d.a.m0.r.f0.m.b bVar2 = new d.a.m0.r.f0.m.b();
            bVar2.r(R.color.CAM_X0109);
            this.s.setConfig(bVar2);
            this.s.setText(TbadkCoreApplication.getInst().getString(R.string.forum_isLiked));
        }
        this.v.w(z);
    }
}
