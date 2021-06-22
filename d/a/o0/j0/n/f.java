package d.a.o0.j0.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.tbadkCore.LikeModel;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.n0.r.q.n1;
import d.a.o0.e3.f0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f60046a;

    /* renamed from: b  reason: collision with root package name */
    public View f60047b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f60048c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f60049d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f60050e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60051f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60052g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f60053h;

    /* renamed from: i  reason: collision with root package name */
    public String f60054i = TbadkCoreApplication.getInst().getString(R.string.attention);
    public String j = TbadkCoreApplication.getInst().getString(R.string.thread_str);
    public n1 k;
    public LikeModel l;
    public f0 m;
    public boolean n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.j();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            StatisticItem statisticItem = new StatisticItem("c13644");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", f.this.k.C());
            statisticItem.param("obj_locate", 1);
            statisticItem.param(TiebaStatic.Params.OBJ_TO, f.this.k.H() ? 2 : 1);
            TiebaStatic.log(statisticItem);
            if (f.this.k.H()) {
                f.this.i();
            } else {
                f.this.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.a.e {
        public c() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (f.this.l.getErrorCode() == 22) {
                l.M(f.this.f60046a.getPageActivity(), f.this.f60046a.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (f.this.l.getErrorCode() != 0) {
                    l.M(f.this.f60046a.getPageActivity(), f.this.l.getErrorString());
                    return;
                }
                f.this.n(true);
                l.M(f.this.f60046a.getPageActivity(), f.this.f60046a.getString(R.string.attention_success));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f0.a {
        public d() {
        }

        @Override // d.a.o0.e3.f0.a
        public void a(String str, long j) {
        }

        @Override // d.a.o0.e3.f0.a
        public void b(String str, long j) {
            f.this.n(false);
            l.M(f.this.f60046a.getPageActivity(), f.this.f60046a.getString(R.string.un_attention_success));
        }
    }

    public f(TbPageContext<?> tbPageContext) {
        this.f60046a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f60047b = inflate;
        this.f60048c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f60049d = (TextView) this.f60047b.findViewById(R.id.bar_name);
        this.f60050e = (TextView) this.f60047b.findViewById(R.id.desc);
        this.f60051f = (TextView) this.f60047b.findViewById(R.id.follow_text);
        this.f60052g = (TextView) this.f60047b.findViewById(R.id.tiezi_text);
        this.f60053h = (TBSpecificationBtn) this.f60047b.findViewById(R.id.forum_like_button);
        this.f60047b.setOnClickListener(new a());
        this.f60053h.setOnClickListener(new b());
    }

    public void g(n1 n1Var) {
        if (n1Var == null) {
            return;
        }
        this.k = n1Var;
        this.f60048c.setShowOval(true);
        this.f60048c.setShowOuterBorder(false);
        this.f60048c.setShowInnerBorder(true);
        this.f60048c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f60048c.setStrokeColorResId(R.color.CAM_X0401);
        this.f60048c.U(n1Var.B(), 10, false);
        String D = n1Var.D();
        if (k.isEmpty(D)) {
            D = "";
        }
        this.f60049d.setText(D);
        this.f60051f.setText(this.f60054i + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.E()));
        this.f60052g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) n1Var.G()));
        String F = n1Var.F();
        if (k.isEmpty(F)) {
            if (this.f60050e.getVisibility() != 8) {
                this.f60050e.setVisibility(8);
                if (this.f60049d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f60049d.getLayoutParams()).topMargin = l.g(this.f60046a.getPageActivity(), R.dimen.tbds47);
                    this.f60049d.requestLayout();
                }
            }
        } else {
            if (this.f60050e.getVisibility() != 0) {
                this.f60050e.setVisibility(0);
                if (this.f60049d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f60049d.getLayoutParams()).topMargin = l.g(this.f60046a.getPageActivity(), R.dimen.tbds24);
                    this.f60049d.requestLayout();
                }
            }
            this.f60050e.setText(F);
        }
        n(this.k.H());
        l();
    }

    public final void h() {
        if (!l.D()) {
            UtilHelper.showToast(this.f60046a.getPageActivity(), this.f60046a.getString(R.string.neterror));
            return;
        }
        n1 n1Var = this.k;
        if (n1Var == null || StringUtils.isNull(n1Var.D()) || this.k.C() <= 0) {
            return;
        }
        if (!ViewHelper.checkUpIsLogin(this.f60046a.getPageActivity())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            return;
        }
        if (this.l == null) {
            this.l = new LikeModel(this.f60046a);
        }
        this.l.setLoadDataCallBack(new c());
        if (k.isForumName(this.k.D())) {
            this.l.I();
            this.l.L(this.k.D(), String.valueOf(this.k.C()));
        }
    }

    public final void i() {
        if (!l.D()) {
            UtilHelper.showToast(this.f60046a.getPageActivity(), this.f60046a.getString(R.string.neterror));
            return;
        }
        n1 n1Var = this.k;
        if (n1Var == null || StringUtils.isNull(n1Var.D()) || this.k.C() <= 0) {
            return;
        }
        if (!ViewHelper.checkUpIsLogin(this.f60046a.getPageActivity())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            return;
        }
        if (this.m == null) {
            this.m = new f0();
        }
        this.m.b(new d());
        this.m.c(this.k.D(), this.k.C());
    }

    public final void j() {
        n1 n1Var = this.k;
        if (n1Var == null) {
            return;
        }
        String D = n1Var.D();
        if (k.isForumName(D)) {
            this.f60046a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f60046a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            StatisticItem statisticItem = new StatisticItem("c13643");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k.C());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", this.n ? 4 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public View k() {
        return this.f60047b;
    }

    public void l() {
        SkinManager.setViewTextColor(this.f60049d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60051f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f60052g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f60050e, R.color.CAM_X0109);
    }

    public void m(boolean z) {
        this.n = z;
    }

    public void n(boolean z) {
        if (!z) {
            d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
            bVar.q(R.color.CAM_X0302);
            this.f60053h.setConfig(bVar);
            this.f60053h.setText(this.f60054i);
        } else {
            d.a.n0.r.f0.m.b bVar2 = new d.a.n0.r.f0.m.b();
            bVar2.r(R.color.CAM_X0109);
            this.f60053h.setConfig(bVar2);
            this.f60053h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.k.J(z);
    }
}
