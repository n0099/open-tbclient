package d.b.i0.m2;

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
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56932a;

    /* renamed from: b  reason: collision with root package name */
    public View f56933b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f56934c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f56935d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f56936e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f56937f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f56938g;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.f56932a = postSearchActivity;
        this.f56933b = view;
    }

    public final void a() {
        this.f56936e.E0();
        this.f56937f.E0();
        this.f56938g.E0();
    }

    public final void b() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
        this.f56936e = postSearchListFragment;
        bVar.f13312c = postSearchListFragment;
        bVar.f13311b = c(R.string.searching_time_tab);
        bVar.f13310a = 1;
        this.f56934c.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
        this.f56937f = postSearchListFragment2;
        bVar2.f13312c = postSearchListFragment2;
        bVar2.f13311b = c(R.string.searching_relative_tab);
        bVar2.f13310a = 2;
        this.f56934c.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
        this.f56938g = postSearchListFragment3;
        bVar3.f13312c = postSearchListFragment3;
        bVar3.f13311b = c(R.string.searching_only_thread_tab);
        bVar3.f13310a = 3;
        this.f56934c.a(bVar3);
    }

    public final FragmentTabIndicator c(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.f56932a.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.f56932a.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.f56932a.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth((l.k(this.f56932a.getPageContext().getContext()) - (this.f56932a.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3);
        return fragmentTabIndicator;
    }

    public int d() {
        return this.f56934c.getCurrentTabType();
    }

    public final PostSearchListFragment e(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return this.f56938g;
            }
            return this.f56937f;
        }
        return this.f56936e;
    }

    public final void f(int i) {
        View inflate = ((ViewStub) this.f56933b.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.f56934c = fragmentTabHost;
        fragmentTabHost.setup(this.f56932a.getSupportFragmentManager());
        this.f56934c.setTabWidgetViewHeight((int) this.f56932a.getResources().getDimension(R.dimen.ds80));
        this.f56934c.setShouldDrawIndicatorLine(true);
        b();
        this.f56934c.k(3);
        this.f56934c.setCurrentTabByType(i);
        this.f56934c.setNeedShowThemeStyle(false);
        this.f56934c.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.f56934c.o(TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundColor(this.f56934c.getFragmentTabWidget(), R.color.CAM_X0201);
        this.f56934c.setOnPageChangeListener(this.f56935d);
    }

    public void g(int i) {
        FragmentTabHost fragmentTabHost = this.f56934c;
        if (fragmentTabHost != null) {
            fragmentTabHost.o(i);
        }
        FragmentTabHost fragmentTabHost2 = this.f56934c;
        if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
            return;
        }
        SkinManager.setBackgroundColor(this.f56934c.getFragmentTabWidget(), R.color.CAM_X0201);
    }

    public void h(int i, b bVar, boolean z) {
        j(true);
        PostSearchListFragment e2 = e(i);
        if (e2 != null) {
            e2.I0(bVar, z);
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f56935d = onPageChangeListener;
        FragmentTabHost fragmentTabHost = this.f56934c;
        if (fragmentTabHost != null) {
            fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost = this.f56934c;
        if (fragmentTabHost != null) {
            if (z) {
                fragmentTabHost.setVisibility(0);
            } else {
                fragmentTabHost.setVisibility(8);
            }
        }
    }

    public void k(int i) {
        if (this.f56934c == null) {
            f(1);
            return;
        }
        a();
        if (this.f56934c.getCurrentTabType() == i) {
            PostSearchListFragment e2 = e(i);
            if (e2 != null) {
                e2.J0(true);
                return;
            }
            return;
        }
        this.f56934c.setCurrentTabByType(i);
    }
}
