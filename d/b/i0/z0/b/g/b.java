package d.b.i0.z0.b.g;

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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.view.FollowUserButton;
import d.b.b.a.e;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.i0.c3.f0;
import d.b.i0.z0.b.f.d;
/* loaded from: classes4.dex */
public class b extends BdBaseViewPagerAdapter.a implements View.OnClickListener {

    /* renamed from: h  reason: collision with root package name */
    public d f62804h;
    public boolean i;
    public LikeModel j;
    public f0 k;
    public C1685b l;
    public d.b.h0.r.f0.m.b m;
    public d.b.h0.r.f0.m.b n;
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

    /* renamed from: d.b.i0.z0.b.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1685b extends e implements f0.a {

        /* renamed from: a  reason: collision with root package name */
        public d.a f62805a;

        /* renamed from: b  reason: collision with root package name */
        public FollowUserButton f62806b;

        public C1685b() {
        }

        @Override // d.b.i0.c3.f0.a
        public void a(String str, long j) {
            b.this.i = false;
        }

        @Override // d.b.i0.c3.f0.a
        public void b(String str, long j) {
            b.this.i = false;
            b.this.o(this.f62806b, false);
            this.f62805a.p(false);
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            b.this.i = false;
            if (b.this.j.getErrorCode() == 22) {
                l.L(b.this.o.getPageActivity(), b.this.o.getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (b.this.j.getErrorCode() != 0) {
                    l.L(b.this.o.getPageActivity(), b.this.j.getErrorString());
                    return;
                }
                b.this.o(this.f62806b, true);
                this.f62805a.p(true);
            }
        }

        public void d(FollowUserButton followUserButton, d.a aVar) {
            this.f62805a = aVar;
            this.f62806b = followUserButton;
        }
    }

    public b(View view, TbPageContext<?> tbPageContext, byte b2) {
        super(view);
        this.i = false;
        this.m = new d.b.h0.r.f0.m.b();
        this.n = new d.b.h0.r.f0.m.b();
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
            this.f62804h = dVar;
            this.q.setText(dVar.f62795e);
            for (int i = 0; i < 3; i++) {
                this.r[i].W(this.f62804h.f62798h[i].e(), 10, false);
                this.t[i].setText(this.f62804h.f62798h[i].f());
                this.w[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_thread, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f62804h.f62798h[i].g())}));
                this.v[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_concern, new Object[]{StringHelper.numberUniformFormatExtraWithRoundInt(this.f62804h.f62798h[i].a())}));
                this.x[i].setTag(Integer.valueOf(i));
                o(this.x[i], this.f62804h.f62798h[i].o());
                this.s[i].setVisibility(this.f62804h.f62796f ? 0 : 8);
                ((LinearLayout.LayoutParams) this.t[i].getLayoutParams()).leftMargin = l.g(this.o.getPageActivity(), this.f62804h.f62796f ? R.dimen.tbds15 : R.dimen.tbds0);
                if (!StringUtils.isNull(this.f62804h.f62798h[i].n()) && d.b.h0.b.d.D()) {
                    this.u[i].setText(this.f62804h.f62798h[i].n());
                } else if (!StringUtils.isNull(this.f62804h.f62798h[i].k()) && d.b.h0.b.d.C()) {
                    this.u[i].setText(this.f62804h.f62798h[i].k());
                } else {
                    this.u[i].setText(TbadkCoreApplication.getInst().getString(R.string.recommend_bar_desc));
                }
            }
        }
    }

    public final void h(d.a aVar, FollowUserButton followUserButton) {
        if (this.i) {
            return;
        }
        if (!l.C()) {
            UtilHelper.showToast(this.o.getPageActivity(), this.o.getString(R.string.neterror));
        } else if (aVar == null || StringUtils.isNull(aVar.f()) || aVar.j() <= 0 || !ViewHelper.checkUpIsLogin(this.o.getPageActivity())) {
        } else {
            if (this.l == null) {
                this.l = new C1685b();
            }
            if (this.j == null) {
                LikeModel likeModel = new LikeModel(this.o);
                this.j = likeModel;
                likeModel.setLoadDataCallBack(this.l);
            }
            this.l.d(followUserButton, aVar);
            if (k.isForumName(aVar.f())) {
                this.i = true;
                this.j.E();
                this.j.H(aVar.f(), String.valueOf(aVar.j()));
            }
        }
    }

    public final void i(d.a aVar, FollowUserButton followUserButton) {
        if (this.i) {
            return;
        }
        if (!l.C()) {
            UtilHelper.showToast(this.o.getPageActivity(), this.o.getString(R.string.neterror));
        } else if (aVar == null || StringUtils.isNull(aVar.f()) || aVar.j() <= 0 || !ViewHelper.checkUpIsLogin(this.o.getPageActivity())) {
        } else {
            if (this.l == null) {
                this.l = new C1685b();
            }
            if (this.k == null) {
                f0 f0Var = new f0();
                this.k = f0Var;
                f0Var.b(this.l);
            }
            this.l.d(followUserButton, aVar);
            this.i = true;
            this.k.c(aVar.f(), aVar.j());
        }
    }

    public d j() {
        return this.f62804h;
    }

    public final void k(View view) {
        this.q = (TextView) view.findViewById(R.id.recommend_bar_item_title);
        this.m.r(R.color.CAM_X0109);
        this.m.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.n.q(R.color.CAM_X0304);
        this.n.i(0, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.n.f(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
        int i = 0;
        while (i < 3) {
            View findViewById = view.findViewById(this.y[i]);
            findViewById.setTag(Integer.valueOf(i));
            findViewById.setOnClickListener(this);
            this.r[i] = (BarImageView) findViewById.findViewById(R.id.recommend_bar_icon);
            this.s[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_title_index);
            this.t[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_name);
            this.u[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_desc);
            this.v[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_concern_info);
            this.w[i] = (TextView) findViewById.findViewById(R.id.recommend_bar_thread_info);
            this.x[i] = (FollowUserButton) findViewById.findViewById(R.id.recommend_bar_concern_btn);
            this.x[i].setOnClickListener(this);
            int i2 = i + 1;
            this.s[i].setText(String.valueOf(i2));
            this.r[i].setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.r[i].setShowInnerBorder(true);
            this.r[i].setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.r[i].setShowOval(true);
            this.r[i].setPlaceHolder(2);
            this.r[i].setShowOuterBorder(false);
            this.r[i].setStrokeColorResId(R.color.CAM_X0401);
            i = i2;
        }
        l(TbadkCoreApplication.getInst().getSkinType());
    }

    public void l(int i) {
        if (this.f13655e == i) {
            return;
        }
        this.f13655e = i;
        SkinManager.setViewTextColor(this.q, R.color.CAM_X0108);
        for (int i2 = 0; i2 < 3; i2++) {
            if (this.s[i2].getVisibility() == 0) {
                SkinManager.setViewTextColor(this.s[i2], R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().defaultColor(this.z[i2]).cornerRadius(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8)).into(this.s[i2]);
            }
            this.x[i2].r(i);
            SkinManager.setViewTextColor(this.t[i2], R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.u[i2], R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.v[i2], R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.w[i2], R.color.CAM_X0109);
        }
    }

    public void m(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void n(int i, boolean z) {
        if (this.f62804h == null) {
            return;
        }
        if (z) {
            o(this.x[i], true);
            this.f62804h.f62798h[i].p(true);
            return;
        }
        o(this.x[i], false);
        this.f62804h.f62798h[i].p(false);
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
        if (this.f62804h == null || view == null) {
            return;
        }
        int id = view.getId();
        int intValue = ((Integer) view.getTag()).intValue();
        d.a aVar = this.f62804h.f62798h[intValue];
        if (view instanceof TBSpecificationBtn) {
            if (aVar.o()) {
                i(aVar, this.x[intValue]);
                return;
            }
            h(aVar, this.x[intValue]);
            StatisticItem param = new StatisticItem("c13644").param("fid", aVar.j()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.p);
            if (!StringUtils.isNull(this.f62804h.f62795e)) {
                param = param.param("obj_name", this.f62804h.f62795e);
            }
            TiebaStatic.log(param);
        } else if (id == R.id.recommend_bar_info_1 || id == R.id.recommend_bar_info_2 || id == R.id.recommend_bar_info_3) {
            FrsActivityConfig callFrom = new FrsActivityConfig(this.o.getPageActivity()).createNormalCfg(aVar.f(), FrsActivityConfig.FRS_FROM_RECOMMEND_BAR_CAR).setCallFrom(3);
            if (d.b.h0.b.d.C()) {
                Intent intent = callFrom.getIntent();
                if (aVar.l() != 0 && intent != null) {
                    intent.putExtra("transition_type", 0);
                    intent.putExtra(FrsActivityConfig.FRS_HOT_THREAD_ID, aVar.l());
                }
            }
            this.o.sendMessage(new CustomMessage(2003000, callFrom));
            StatisticItem param2 = new StatisticItem("c13988").param("fid", aVar.j()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", (int) this.p);
            if (!StringUtils.isNull(this.f62804h.f62795e)) {
                param2 = param2.param("obj_name", this.f62804h.f62795e);
            }
            TiebaStatic.log(param2);
        }
    }
}
