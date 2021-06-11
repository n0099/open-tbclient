package d.a.n0;

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
public class k implements d.a.m0.t0.a, View.OnClickListener, TbTabLayout.c {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<SelectForumActivity> f60269e;

    /* renamed from: f  reason: collision with root package name */
    public String f60270f = "key_select_forum_tab_index";

    /* renamed from: g  reason: collision with root package name */
    public NavigationBar f60271g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f60272h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f60273i;
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
            k.this.n = i2 == 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    public k(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.f60269e = tbPageContext;
        this.f60273i = linearLayout;
        this.f60271g = navigationBar;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            this.f60270f += currentAccount;
        }
        f();
        d();
        h();
        i();
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void a(TbTabLayout.f fVar) {
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void c(TbTabLayout.f fVar) {
    }

    public final void d() {
        LayoutInflater.from(this.f60269e.getPageActivity()).inflate(R.layout.activity_select_forum_layout, (ViewGroup) this.f60273i, true);
        this.j = (TbTabLayout) this.f60273i.findViewById(R.id.activity_select_forum_tab_layout);
        this.k = (BdBaseViewPager) this.f60273i.findViewById(R.id.activity_select_forum_viewpager);
    }

    @Override // com.baidu.adp.widget.design.TbTabLayout.c
    public void e(TbTabLayout.f fVar) {
        TiebaStatic.log(new StatisticItem("c13994").param("obj_type", fVar.e() + 1));
        d.a.m0.r.d0.b.j().v(this.f60270f, fVar.e());
    }

    public final void f() {
        this.f60271g.setCenterTextTitle(this.f60269e.getResources().getString(R.string.activity_select_forum_title));
        ImageView imageView = (ImageView) this.f60271g.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
        this.f60272h = imageView;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.setMargins(0, 0, d.a.c.e.p.l.g(this.f60269e.getPageActivity(), R.dimen.ds10), 0);
        this.f60272h.setLayoutParams(layoutParams);
        this.f60272h.setOnClickListener(this);
        this.f60272h.setVisibility(8);
    }

    @Override // d.a.m0.t0.a
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
        SelectForumPagerAdapter selectForumPagerAdapter = new SelectForumPagerAdapter(this.f60269e);
        this.l = selectForumPagerAdapter;
        this.k.setAdapter(selectForumPagerAdapter);
        this.j.setupWithViewPager(this.k);
        k(d.a.m0.r.d0.b.j().k(this.f60270f, 0));
        this.j.setOnTabSelectedListener(this);
        this.k.addOnPageChangeListener(new a());
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewCancel() {
        return true;
    }

    @Override // d.a.m0.t0.a
    public boolean isOnViewTop() {
        return false;
    }

    public void j() {
        SelectForumPagerAdapter selectForumPagerAdapter = this.l;
        if (selectForumPagerAdapter != null) {
            selectForumPagerAdapter.e();
        }
    }

    public boolean k(int i2) {
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

    @Override // d.a.m0.t0.a
    public void onViewChangeSkinType(int i2) {
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f60272h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.j.setTabTextColors(SkinManager.getColor(R.color.CAM_X0108), SkinManager.getColor(R.color.CAM_X0105));
        this.l.f();
    }
}
