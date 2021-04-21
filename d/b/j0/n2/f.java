package d.b.j0.n2;

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
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f58991a;

    /* renamed from: b  reason: collision with root package name */
    public View f58992b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f58993c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f58994d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f58995e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f58996f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f58997g;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.f58991a = postSearchActivity;
        this.f58992b = view;
    }

    public final void a() {
        this.f58995e.E0();
        this.f58996f.E0();
        this.f58997g.E0();
    }

    public final void b() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
        this.f58995e = postSearchListFragment;
        bVar.f12982c = postSearchListFragment;
        bVar.f12981b = c(R.string.searching_time_tab);
        bVar.f12980a = 1;
        this.f58993c.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
        this.f58996f = postSearchListFragment2;
        bVar2.f12982c = postSearchListFragment2;
        bVar2.f12981b = c(R.string.searching_relative_tab);
        bVar2.f12980a = 2;
        this.f58993c.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
        this.f58997g = postSearchListFragment3;
        bVar3.f12982c = postSearchListFragment3;
        bVar3.f12981b = c(R.string.searching_only_thread_tab);
        bVar3.f12980a = 3;
        this.f58993c.a(bVar3);
    }

    public final FragmentTabIndicator c(int i) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.f58991a.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i);
        fragmentTabIndicator.setTextSize(0, this.f58991a.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.f58991a.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth((l.k(this.f58991a.getPageContext().getContext()) - (this.f58991a.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3);
        return fragmentTabIndicator;
    }

    public int d() {
        return this.f58993c.getCurrentTabType();
    }

    public final PostSearchListFragment e(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return null;
                }
                return this.f58997g;
            }
            return this.f58996f;
        }
        return this.f58995e;
    }

    public final void f(int i) {
        View inflate = ((ViewStub) this.f58992b.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.f58993c = fragmentTabHost;
        fragmentTabHost.setup(this.f58991a.getSupportFragmentManager());
        this.f58993c.setTabWidgetViewHeight((int) this.f58991a.getResources().getDimension(R.dimen.ds80));
        this.f58993c.setShouldDrawIndicatorLine(true);
        b();
        this.f58993c.k(3);
        this.f58993c.setCurrentTabByType(i);
        this.f58993c.setNeedShowThemeStyle(false);
        this.f58993c.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.f58993c.o(TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundColor(this.f58993c.getFragmentTabWidget(), R.color.CAM_X0201);
        this.f58993c.setOnPageChangeListener(this.f58994d);
    }

    public void g(int i) {
        FragmentTabHost fragmentTabHost = this.f58993c;
        if (fragmentTabHost != null) {
            fragmentTabHost.o(i);
        }
        FragmentTabHost fragmentTabHost2 = this.f58993c;
        if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
            return;
        }
        SkinManager.setBackgroundColor(this.f58993c.getFragmentTabWidget(), R.color.CAM_X0201);
    }

    public void h(int i, b bVar, boolean z) {
        j(true);
        PostSearchListFragment e2 = e(i);
        if (e2 != null) {
            e2.I0(bVar, z);
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f58994d = onPageChangeListener;
        FragmentTabHost fragmentTabHost = this.f58993c;
        if (fragmentTabHost != null) {
            fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost = this.f58993c;
        if (fragmentTabHost != null) {
            if (z) {
                fragmentTabHost.setVisibility(0);
            } else {
                fragmentTabHost.setVisibility(8);
            }
        }
    }

    public void k(int i) {
        if (this.f58993c == null) {
            f(1);
            return;
        }
        a();
        if (this.f58993c.getCurrentTabType() == i) {
            PostSearchListFragment e2 = e(i);
            if (e2 != null) {
                e2.J0(true);
                return;
            }
            return;
        }
        this.f58993c.setCurrentTabByType(i);
    }
}
