package d.a.k0;

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
public class i implements d.a.j0.t0.a, View.OnClickListener, TbTabLayout.c {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectForumActivity> f55620e;

    /* renamed from: f  reason: collision with root package name */
    public String f55621f = "key_select_forum_tab_index";

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f55622g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f55623h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f55624i;
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
        public void onPageScrollStateChanged(int i2) {
            i.this.n = i2 == 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    public i(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f55620e = tbPageContext;
        this.f55624i = linearLayout;
        this.f55622g = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.f55621f += currentAccount;
        }
        f();
        d();
        g();
        h();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
    }

    public final void d() {
        LayoutInflater.from(this.f55620e.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.f55624i, true);
        this.j = (TbTabLayout) this.f55624i.findViewById(R.id.activity_select_forum_tab_layout);
        this.k = (BdBaseViewPager) this.f55624i.findViewById(R.id.activity_select_forum_viewpager);
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        TiebaStatic.log(new StatisticItem("c13994").param("obj_type", fVar.e() + 1));
        d.a.j0.r.d0.b.j().v(this.f55621f, fVar.e());
    }

    public final void f() {
        this.f55622g.setCenterTextTitle(this.f55620e.getResources().getString(R.string.activity_select_forum_title));
        ImageView imageView = (ImageView) this.f55622g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        this.f55623h = imageView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, 0, d.a.c.e.p.l.g(this.f55620e.getPageActivity(), R.dimen.ds10), 0);
        this.f55623h.setLayoutParams(layoutParams);
        this.f55623h.setOnClickListener(this);
        this.f55623h.setVisibility(8);
    }

    public final void g() {
        this.j.setSelectedTabTextBlod(true);
        this.j.setSelectedTabIndicatorColor(0);
        TbTabLayout.f z = this.j.z();
        z.s(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_recently));
        TbTabLayout.f z2 = this.j.z();
        z2.s(TbadkCoreApplication.getInst().getString(R.string.activity_select_forum_tab_attention));
        this.j.f(z, false);
        this.j.f(z2, false);
    }

    @Override // d.a.j0.t0.a
    public Intent getResultIntent() {
        return this.m;
    }

    public final void h() {
        SelectForumPagerAdapter selectForumPagerAdapter = new SelectForumPagerAdapter(this.f55620e);
        this.l = selectForumPagerAdapter;
        this.k.setAdapter(selectForumPagerAdapter);
        this.j.setupWithViewPager(this.k);
        j(d.a.j0.r.d0.b.j().k(this.f55621f, 0));
        this.j.setOnTabSelectedListener(this);
        this.k.addOnPageChangeListener(new a());
    }

    public void i() {
        SelectForumPagerAdapter selectForumPagerAdapter = this.l;
        if (selectForumPagerAdapter != null) {
            selectForumPagerAdapter.c();
        }
    }

    @Override // d.a.j0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.a.j0.t0.a
    public boolean isOnViewTop() {
        return false;
    }

    public boolean j(int i2) {
        if (i2 < 0 || i2 > 1) {
            return false;
        }
        TbTabLayout.f w = this.j.w(i2);
        if (w != null && !w.h()) {
            w.l();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // d.a.j0.t0.a
    public void onViewChangeSkinType(int i2) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f55623h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.j.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
        this.l.d();
    }
}
