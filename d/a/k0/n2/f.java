package d.a.k0.n2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.tieba.postsearch.PostSearchListFragment;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57719a;

    /* renamed from: b  reason: collision with root package name */
    public View f57720b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f57721c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f57722d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f57723e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f57724f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f57725g;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.f57719a = postSearchActivity;
        this.f57720b = view;
    }

    public final void a() {
        this.f57723e.D0();
        this.f57724f.D0();
        this.f57725g.D0();
    }

    public final void b() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
        this.f57723e = postSearchListFragment;
        bVar.f12243c = postSearchListFragment;
        bVar.f12242b = c(R.string.searching_time_tab);
        bVar.f12241a = 1;
        this.f57721c.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
        this.f57724f = postSearchListFragment2;
        bVar2.f12243c = postSearchListFragment2;
        bVar2.f12242b = c(R.string.searching_relative_tab);
        bVar2.f12241a = 2;
        this.f57721c.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
        this.f57725g = postSearchListFragment3;
        bVar3.f12243c = postSearchListFragment3;
        bVar3.f12242b = c(R.string.searching_only_thread_tab);
        bVar3.f12241a = 3;
        this.f57721c.a(bVar3);
    }

    public final FragmentTabIndicator c(int i2) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.f57719a.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i2);
        fragmentTabIndicator.setTextSize(0, this.f57719a.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.f57719a.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth((l.k(this.f57719a.getPageContext().getContext()) - (this.f57719a.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3);
        return fragmentTabIndicator;
    }

    public int d() {
        return this.f57721c.getCurrentTabType();
    }

    public final PostSearchListFragment e(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return this.f57725g;
            }
            return this.f57724f;
        }
        return this.f57723e;
    }

    public final void f(int i2) {
        View inflate = ((ViewStub) this.f57720b.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.f57721c = fragmentTabHost;
        fragmentTabHost.setup(this.f57719a.getSupportFragmentManager());
        this.f57721c.setTabWidgetViewHeight((int) this.f57719a.getResources().getDimension(R.dimen.ds80));
        this.f57721c.setShouldDrawIndicatorLine(true);
        b();
        this.f57721c.k(3);
        this.f57721c.setCurrentTabByType(i2);
        this.f57721c.setNeedShowThemeStyle(false);
        this.f57721c.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.f57721c.o(TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundColor(this.f57721c.getFragmentTabWidget(), R.color.CAM_X0201);
        this.f57721c.setOnPageChangeListener(this.f57722d);
    }

    public void g(int i2) {
        FragmentTabHost fragmentTabHost = this.f57721c;
        if (fragmentTabHost != null) {
            fragmentTabHost.o(i2);
        }
        FragmentTabHost fragmentTabHost2 = this.f57721c;
        if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
            return;
        }
        SkinManager.setBackgroundColor(this.f57721c.getFragmentTabWidget(), R.color.CAM_X0201);
    }

    public void h(int i2, b bVar, boolean z) {
        j(true);
        PostSearchListFragment e2 = e(i2);
        if (e2 != null) {
            e2.H0(bVar, z);
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f57722d = onPageChangeListener;
        FragmentTabHost fragmentTabHost = this.f57721c;
        if (fragmentTabHost != null) {
            fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost = this.f57721c;
        if (fragmentTabHost != null) {
            if (z) {
                fragmentTabHost.setVisibility(0);
            } else {
                fragmentTabHost.setVisibility(8);
            }
        }
    }

    public void k(int i2) {
        if (this.f57721c == null) {
            f(1);
            return;
        }
        a();
        if (this.f57721c.getCurrentTabType() == i2) {
            PostSearchListFragment e2 = e(i2);
            if (e2 != null) {
                e2.I0(true);
                return;
            }
            return;
        }
        this.f57721c.setCurrentTabByType(i2);
    }
}
