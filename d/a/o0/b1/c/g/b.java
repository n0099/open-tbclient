package d.a.o0.b1.c.g;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.FollowUserButton;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import d.a.c.a.e;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.o0.b1.c.f.d;
import d.a.o0.e3.f0;
/* loaded from: classes4.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public d f55211h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55212i;
    public LikeModel j;
    public f0 k;
    public C1249b l;
    public d.a.n0.r.f0.m.b m;
    public d.a.n0.r.f0.m.b n;
    public TbPageContext<?> o;
    public byte p;
    public TextView q;
    public BarImageView[] r;
    public TextView[] s;
    public TextView[] t;
    public TextView[] u;
    public TextView[] v;
    public TextView[] w;
    public FollowUserButton[] x;
    public final int[] y;
    public final int[] z;

    /* renamed from: d.a.o0.b1.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1249b extends e implements f0.a {

        /* renamed from: a  reason: collision with root package name */
        public d.a f55213a;

        /* renamed from: b  reason: collision with root package name */
        public FollowUserButton f55214b;

        public C1249b() {
        }

        @Override // d.a.o0.e3.f0.a
        public void a(String str, long j) {
            b.this.f55212i = false;
        }

        @Override // d.a.o0.e3.f0.a
        public void b(String str, long j) {
            b.this.f55212i = false;
            b.this.o(this.f55214b, false);
            this.f55213a.o(false);
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            b.this.f55212i = false;
            if (b.this.j.getErrorCode() == 22) {
                l.M(b.this.o.getPageActivity(), b.this.o.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (b.this.j.getErrorCode() != 0) {
                    l.M(b.this.o.getPageActivity(), b.this.j.getErrorString());
                    return;
                }
                b.this.o(this.f55214b, true);
                this.f55213a.o(true);
            }
        }

        public void d(FollowUserButton followUserButton, d.a aVar) {
            this.f55213a = aVar;
            this.f55214b = followUserButton;
        }
    }

    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        this.f55212i = false;
        this.m = new d.a.n0.r.f0.m.b();
        this.n = new d.a.n0.r.f0.m.b();
        this.r = new BarImageView[3];
        this.s = new TextView[3];
        this.t = new TextView[3];
        this.u = new TextView[3];
        this.v = new TextView[3];
        this.w = new TextView[3];
        this.x = new FollowUserButton[3];
        this.y = new int[]{R.id.recommend_bar_info_1, R.id.recommend_bar_info_2, R.id.recommend_bar_info_3};
        this.z = new int[]{R.color.CAM_X0301, R.color.CAM_X0305, R.color.CAM_X0312};
        this.o = tbPageContext;
        this.p = b2;
        k(view);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a
    public void c(n nVar) {
        if (nVar instanceof d) {
            d dVar = (d) nVar;
            this.f55211h = dVar;
            this.q.setText(dVar.f55201e);
            for (int i2 = 0; i2 < 3; i2++) {
                this.r[i2].U(this.f55211h.f55204h[i2].c(), 10, false);
                this.t[i2].setText(this.f55211h.f55204h[i2].e());
                this.w[i2].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f55211h.f55204h[i2].g())}));
                this.v[i2].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f55211h.f55204h[i2].b())}));
                this.x[i2].setTag(Integer.valueOf(i2));
                o(this.x[i2], this.f55211h.f55204h[i2].n());
                this.s[i2].setVisibility(this.f55211h.f55202f ? 0 : 8);
                ((LinearLayout.LayoutParams) this.t[i2].getLayoutParams()).leftMargin = l.g(this.o.getPageActivity(), this.f55211h.f55202f ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.f55211h.f55204h[i2].l()) && d.a.n0.b.d.F()) {
                    this.u[i2].setText(this.f55211h.f55204h[i2].l());
                } else if (!StringUtils.isNull(this.f55211h.f55204h[i2].i()) && d.a.n0.b.d.E()) {
                    this.u[i2].setText(this.f55211h.f55204h[i2].i());
                } else {
                    this.u[i2].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    public final void h(d.a aVar, FollowUserButton followUserButton) {
        if (this.f55212i) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.o.getPageActivity(), this.o.getString(R.string.neterror));
        } else if (aVar == null || StringUtils.isNull(aVar.e()) || aVar.h() <= 0 || !ViewHelper.checkUpIsLogin(this.o.getPageActivity())) {
        } else {
            if (this.l == null) {
                this.l = new C1249b();
            }
            if (this.j == null) {
                LikeModel likeModel = new LikeModel(this.o);
                this.j = likeModel;
                likeModel.setLoadDataCallBack(this.l);
            }
            this.l.d(followUserButton, aVar);
            if (k.isForumName(aVar.e())) {
                this.f55212i = true;
                this.j.I();
                this.j.L(aVar.e(), String.valueOf(aVar.h()));
            }
        }
    }

    public final void i(d.a aVar, FollowUserButton followUserButton) {
        if (this.f55212i) {
            return;
        }
        if (!l.D()) {
            UtilHelper.showToast(this.o.getPageActivity(), this.o.getString(R.string.neterror));
        } else if (aVar == null || StringUtils.isNull(aVar.e()) || aVar.h() <= 0 || !ViewHelper.checkUpIsLogin(this.o.getPageActivity())) {
        } else {
            if (this.l == null) {
                this.l = new C1249b();
            }
            if (this.k == null) {
                f0 f0Var = new f0();
                this.k = f0Var;
                f0Var.b(this.l);
            }
            this.l.d(followUserButton, aVar);
            this.f55212i = true;
            this.k.c(aVar.e(), aVar.h());
        }
    }

    public d j() {
        return this.f55211h;
    }

    public final void k(View view) {
        this.q = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.m.r(R.color.CAM_X0109);
        this.m.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.n.q(R.color.CAM_X0304);
        this.n.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.n.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        int i2 = 0;
        while (i2 < 3) {
            View findViewById = view.findViewById(this.y[i2]);
            findViewById.setTag(Integer.valueOf(i2));
            findViewById.setOnClickListener(this);
            this.r[i2] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.s[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.t[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.u[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.v[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.w[i2] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.x[i2] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.x[i2].setOnClickListener(this);
            int i3 = i2 + 1;
            this.s[i2].setText(String.valueOf(i3));
            this.r[i2].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.r[i2].setShowInnerBorder(true);
            this.r[i2].setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.r[i2].setShowOval(true);
            this.r[i2].setPlaceHolder(2);
            this.r[i2].setShowOuterBorder(false);
            this.r[i2].setStrokeColorResId(R.color.CAM_X0401);
            i2 = i3;
        }
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i2) {
        if (this.f12679e == i2) {
            return;
        }
        this.f12679e = i2;
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
        for (int i3 = 0; i3 < 3; i3++) {
            if (this.s[i3].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.s[i3], R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.z[i3]).cornerRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.s[i3]);
            }
            this.x[i3].r(i2);
            SkinManager.setViewTextColor(this.t[i3], R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u[i3], R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.v[i3], R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.w[i3], R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void n(int i2, boolean z) {
        if (this.f55211h == null) {
            return;
        }
        if (z) {
            o(this.x[i2], true);
            this.f55211h.f55204h[i2].o(true);
            return;
        }
        o(this.x[i2], false);
        this.f55211h.f55204h[i2].o(false);
    }

    public final void o(FollowUserButton followUserButton, boolean z) {
        if (followUserButton == null) {
            return;
        }
        followUserButton.setConfig(z ? this.m : this.n);
        followUserButton.setText(TbadkCoreApplication.getInst().getString(z ? R.string.followed : R.string.attention));
        followUserButton.r(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f55211h == null || view == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        d.a aVar = this.f55211h.f55204h[intValue];
        if (view instanceof TBSpecificationBtn) {
            if (aVar.n()) {
                i(aVar, this.x[intValue]);
                return;
            }
            h(aVar, this.x[intValue]);
            StatisticItem param = new StatisticItem("c13644").param("fid", aVar.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.p);
            if (!StringUtils.isNull(this.f55211h.f55201e)) {
                param = param.param("obj_name", this.f55211h.f55201e);
            }
            TiebaStatic.log(param);
        } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
            FrsActivityConfig callFrom = new FrsActivityConfig(this.o.getPageActivity()).createNormalCfg(aVar.e(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
            if (d.a.n0.b.d.E()) {
                Intent intent = callFrom.getIntent();
                if (aVar.k() != 0 && intent != null) {
                    intent.putExtra("transition_type", 0);
                    intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.k());
                }
            }
            this.o.sendMessage(new CustomMessage(2003000, callFrom));
            StatisticItem param2 = new StatisticItem("c13988").param("fid", aVar.h()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.p);
            if (!StringUtils.isNull(this.f55211h.f55201e)) {
                param2 = param2.param("obj_name", this.f55211h.f55201e);
            }
            TiebaStatic.log(param2);
        }
    }
}
