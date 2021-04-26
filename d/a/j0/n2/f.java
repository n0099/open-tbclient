package d.a.j0.n2;

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
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57012a;

    /* renamed from: b  reason: collision with root package name */
    public View f57013b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f57014c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f57015d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f57016e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f57017f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f57018g;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.f57012a = postSearchActivity;
        this.f57013b = view;
    }

    public final void a() {
        this.f57016e.E0();
        this.f57017f.E0();
        this.f57018g.E0();
    }

    public final void b() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
        this.f57016e = postSearchListFragment;
        bVar.f12907c = postSearchListFragment;
        bVar.f12906b = c(R.string.searching_time_tab);
        bVar.f12905a = 1;
        this.f57014c.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
        this.f57017f = postSearchListFragment2;
        bVar2.f12907c = postSearchListFragment2;
        bVar2.f12906b = c(R.string.searching_relative_tab);
        bVar2.f12905a = 2;
        this.f57014c.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
        this.f57018g = postSearchListFragment3;
        bVar3.f12907c = postSearchListFragment3;
        bVar3.f12906b = c(R.string.searching_only_thread_tab);
        bVar3.f12905a = 3;
        this.f57014c.a(bVar3);
    }

    public final FragmentTabIndicator c(int i2) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.f57012a.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i2);
        fragmentTabIndicator.setTextSize(0, this.f57012a.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.f57012a.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth((l.k(this.f57012a.getPageContext().getContext()) - (this.f57012a.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3);
        return fragmentTabIndicator;
    }

    public int d() {
        return this.f57014c.getCurrentTabType();
    }

    public final PostSearchListFragment e(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return this.f57018g;
            }
            return this.f57017f;
        }
        return this.f57016e;
    }

    public final void f(int i2) {
        View inflate = ((ViewStub) this.f57013b.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.f57014c = fragmentTabHost;
        fragmentTabHost.setup(this.f57012a.getSupportFragmentManager());
        this.f57014c.setTabWidgetViewHeight((int) this.f57012a.getResources().getDimension(R.dimen.ds80));
        this.f57014c.setShouldDrawIndicatorLine(true);
        b();
        this.f57014c.k(3);
        this.f57014c.setCurrentTabByType(i2);
        this.f57014c.setNeedShowThemeStyle(false);
        this.f57014c.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.f57014c.o(TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundColor(this.f57014c.getFragmentTabWidget(), R.color.CAM_X0201);
        this.f57014c.setOnPageChangeListener(this.f57015d);
    }

    public void g(int i2) {
        FragmentTabHost fragmentTabHost = this.f57014c;
        if (fragmentTabHost != null) {
            fragmentTabHost.o(i2);
        }
        FragmentTabHost fragmentTabHost2 = this.f57014c;
        if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
            return;
        }
        SkinManager.setBackgroundColor(this.f57014c.getFragmentTabWidget(), R.color.CAM_X0201);
    }

    public void h(int i2, b bVar, boolean z) {
        j(true);
        PostSearchListFragment e2 = e(i2);
        if (e2 != null) {
            e2.I0(bVar, z);
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f57015d = onPageChangeListener;
        FragmentTabHost fragmentTabHost = this.f57014c;
        if (fragmentTabHost != null) {
            fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost = this.f57014c;
        if (fragmentTabHost != null) {
            if (z) {
                fragmentTabHost.setVisibility(0);
            } else {
                fragmentTabHost.setVisibility(8);
            }
        }
    }

    public void k(int i2) {
        if (this.f57014c == null) {
            f(1);
            return;
        }
        a();
        if (this.f57014c.getCurrentTabType() == i2) {
            PostSearchListFragment e2 = e(i2);
            if (e2 != null) {
                e2.J0(true);
                return;
            }
            return;
        }
        this.f57014c.setCurrentTabByType(i2);
    }
}
