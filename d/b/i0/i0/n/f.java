package d.b.i0.i0.n;

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
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.h0.r.q.n1;
import d.b.i0.c3.f0;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f55857a;

    /* renamed from: b  reason: collision with root package name */
    public View f55858b;

    /* renamed from: c  reason: collision with root package name */
    public BarImageView f55859c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f55860d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f55861e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55862f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55863g;

    /* renamed from: h  reason: collision with root package name */
    public TBSpecificationBtn f55864h;
    public String i = TbadkCoreApplication.getInst().getString(R.string.attention);
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
    public class c extends d.b.b.a.e {
        public c() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (f.this.l.getErrorCode() == 22) {
                l.L(f.this.f55857a.getPageActivity(), f.this.f55857a.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (f.this.l.getErrorCode() != 0) {
                    l.L(f.this.f55857a.getPageActivity(), f.this.l.getErrorString());
                    return;
                }
                f.this.n(true);
                l.L(f.this.f55857a.getPageActivity(), f.this.f55857a.getString(R.string.attention_success));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f0.a {
        public d() {
        }

        @Override // d.b.i0.c3.f0.a
        public void a(String str, long j) {
        }

        @Override // d.b.i0.c3.f0.a
        public void b(String str, long j) {
            f.this.n(false);
            l.L(f.this.f55857a.getPageActivity(), f.this.f55857a.getString(R.string.un_attention_success));
        }
    }

    public f(TbPageContext<?> tbPageContext) {
        this.f55857a = tbPageContext;
        View inflate = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.recommend_forum_vertical_item_view, (ViewGroup) null);
        this.f55858b = inflate;
        this.f55859c = (BarImageView) inflate.findViewById(R.id.bar_image);
        this.f55860d = (TextView) this.f55858b.findViewById(R.id.bar_name);
        this.f55861e = (TextView) this.f55858b.findViewById(R.id.desc);
        this.f55862f = (TextView) this.f55858b.findViewById(R.id.follow_text);
        this.f55863g = (TextView) this.f55858b.findViewById(R.id.tiezi_text);
        this.f55864h = (TBSpecificationBtn) this.f55858b.findViewById(R.id.forum_like_button);
        this.f55858b.setOnClickListener(new a());
        this.f55864h.setOnClickListener(new b());
    }

    public void g(n1 n1Var) {
        if (n1Var == null) {
            return;
        }
        this.k = n1Var;
        this.f55859c.setShowOval(true);
        this.f55859c.setShowOuterBorder(false);
        this.f55859c.setShowInnerBorder(true);
        this.f55859c.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
        this.f55859c.setStrokeColorResId(R.color.CAM_X0401);
        this.f55859c.W(n1Var.B(), 10, false);
        String D = n1Var.D();
        if (k.isEmpty(D)) {
            D = "";
        }
        this.f55860d.setText(D);
        this.f55862f.setText(this.i + " " + StringHelper.numFormatOverWanWithoutDecimals(n1Var.E()));
        this.f55863g.setText(this.j + " " + StringHelper.numFormatOverWanWithoutDecimals((long) n1Var.G()));
        String F = n1Var.F();
        if (k.isEmpty(F)) {
            if (this.f55861e.getVisibility() != 8) {
                this.f55861e.setVisibility(8);
                if (this.f55860d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f55860d.getLayoutParams()).topMargin = l.g(this.f55857a.getPageActivity(), R.dimen.tbds47);
                    this.f55860d.requestLayout();
                }
            }
        } else {
            if (this.f55861e.getVisibility() != 0) {
                this.f55861e.setVisibility(0);
                if (this.f55860d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.f55860d.getLayoutParams()).topMargin = l.g(this.f55857a.getPageActivity(), R.dimen.tbds24);
                    this.f55860d.requestLayout();
                }
            }
            this.f55861e.setText(F);
        }
        n(this.k.H());
        l();
    }

    public final void h() {
        if (!l.C()) {
            UtilHelper.showToast(this.f55857a.getPageActivity(), this.f55857a.getString(R.string.neterror));
            return;
        }
        n1 n1Var = this.k;
        if (n1Var == null || StringUtils.isNull(n1Var.D()) || this.k.C() <= 0) {
            return;
        }
        if (!ViewHelper.checkUpIsLogin(this.f55857a.getPageActivity())) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            return;
        }
        if (this.l == null) {
            this.l = new LikeModel(this.f55857a);
        }
        this.l.setLoadDataCallBack(new c());
        if (k.isForumName(this.k.D())) {
            this.l.E();
            this.l.H(this.k.D(), String.valueOf(this.k.C()));
        }
    }

    public final void i() {
        if (!l.C()) {
            UtilHelper.showToast(this.f55857a.getPageActivity(), this.f55857a.getString(R.string.neterror));
            return;
        }
        n1 n1Var = this.k;
        if (n1Var == null || StringUtils.isNull(n1Var.D()) || this.k.C() <= 0) {
            return;
        }
        if (!ViewHelper.checkUpIsLogin(this.f55857a.getPageActivity())) {
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
            this.f55857a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f55857a.getPageActivity()).createNormalCfg(D, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
            StatisticItem statisticItem = new StatisticItem("c13643");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.k.C());
            statisticItem.param("obj_locate", 1);
            statisticItem.param("obj_type", this.n ? 4 : 1);
            TiebaStatic.log(statisticItem);
        }
    }

    public View k() {
        return this.f55858b;
    }

    public void l() {
        SkinManager.setViewTextColor(this.f55860d, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55862f, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f55863g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f55861e, R.color.CAM_X0109);
    }

    public void m(boolean z) {
        this.n = z;
    }

    public void n(boolean z) {
        if (!z) {
            d.b.h0.r.f0.m.b bVar = new d.b.h0.r.f0.m.b();
            bVar.q(R.color.CAM_X0302);
            this.f55864h.setConfig(bVar);
            this.f55864h.setText(this.i);
        } else {
            d.b.h0.r.f0.m.b bVar2 = new d.b.h0.r.f0.m.b();
            bVar2.r(R.color.CAM_X0109);
            this.f55864h.setConfig(bVar2);
            this.f55864h.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        }
        this.k.J(z);
    }
}
