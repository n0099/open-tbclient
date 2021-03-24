package d.b.i0;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.design.TbTabLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.SelectForumActivity;
import com.baidu.tieba.SelectForumPagerAdapter;
/* loaded from: classes4.dex */
public class i implements d.b.h0.t0.a, View.OnClickListener, TbTabLayout.c {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectForumActivity> f55447e;

    /* renamed from: f  reason: collision with root package name */
    public String f55448f = "key_select_forum_tab_index";

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f55449g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55450h;
    public LinearLayout i;
    public TbTabLayout j;
    public BdBaseViewPager k;
    public SelectForumPagerAdapter l;
    public Intent m;
    public boolean n;

    /* loaded from: classes4.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            i.this.n = i == 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    public i(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f55447e = tbPageContext;
        this.i = linearLayout;
        this.f55449g = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.f55448f += currentAccount;
        }
        e();
        c();
        h();
        i();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void b(TbTabLayout.f fVar) {
    }

    public final void c() {
        LayoutInflater.from(this.f55447e.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.i, true);
        this.j = (TbTabLayout) this.i.findViewById(R.id.activity_select_forum_tab_layout);
        this.k = (BdBaseViewPager) this.i.findViewById(R.id.activity_select_forum_viewpager);
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void d(TbTabLayout.f fVar) {
    }

    public final void e() {
        this.f55449g.setCenterTextTitle(this.f55447e.getResources().getString(R.string.activity_select_forum_title));
        ImageView imageView = (ImageView) this.f55449g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        this.f55450h = imageView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, 0, d.b.b.e.p.l.g(this.f55447e.getPageActivity(), R.dimen.ds10), 0);
        this.f55450h.setLayoutParams(layoutParams);
        this.f55450h.setOnClickListener(this);
        this.f55450h.setVisibility(8);
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void f(TbTabLayout.f fVar) {
        TiebaStatic.log(new StatisticItem("c13994").param("obj_type", fVar.e() + 1));
        d.b.h0.r.d0.b.i().u(this.f55448f, fVar.e());
    }

    @Override // d.b.h0.t0.a
    public Intent getResultIntent() {
        return this.m;
    }

    public final void h() {
        this.j.setSelectedTabTextBlod(true);
        this.j.setSelectedTabIndicatorColor(0);
        TbTabLayout.f z = this.j.z();
        z.s(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.f z2 = this.j.z();
        z2.s(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.j.f(z, false);
        this.j.f(z2, false);
    }

    public final void i() {
        SelectForumPagerAdapter selectForumPagerAdapter = new SelectForumPagerAdapter(this.f55447e);
        this.l = selectForumPagerAdapter;
        this.k.setAdapter(selectForumPagerAdapter);
        this.j.setupWithViewPager(this.k);
        k(d.b.h0.r.d0.b.i().j(this.f55448f, 0));
        this.j.setOnTabSelectedListener(this);
        this.k.addOnPageChangeListener(new a());
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.b.h0.t0.a
    public boolean isOnViewTop() {
        return false;
    }

    public void j() {
        SelectForumPagerAdapter selectForumPagerAdapter = this.l;
        if (selectForumPagerAdapter != null) {
            selectForumPagerAdapter.e();
        }
    }

    public boolean k(int i) {
        if (i < 0 || i > 1) {
            return false;
        }
        TbTabLayout.f w = this.j.w(i);
        if (w != null && !w.h()) {
            w.l();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.b.h0.t0.a
    public void onViewChangeSkinType(int i) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55450h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.j.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
        this.l.f();
    }
}
