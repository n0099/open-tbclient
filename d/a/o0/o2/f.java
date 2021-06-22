package d.a.o0.o2;

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
    public PostSearchActivity f61707a;

    /* renamed from: b  reason: collision with root package name */
    public View f61708b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentTabHost f61709c;

    /* renamed from: d  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f61710d;

    /* renamed from: e  reason: collision with root package name */
    public PostSearchListFragment f61711e;

    /* renamed from: f  reason: collision with root package name */
    public PostSearchListFragment f61712f;

    /* renamed from: g  reason: collision with root package name */
    public PostSearchListFragment f61713g;

    public f(PostSearchActivity postSearchActivity, View view) {
        this.f61707a = postSearchActivity;
        this.f61708b = view;
    }

    public final void a() {
        this.f61711e.G0();
        this.f61712f.G0();
        this.f61713g.G0();
    }

    public final void b() {
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment = new PostSearchListFragment(1);
        this.f61711e = postSearchListFragment;
        bVar.f12295c = postSearchListFragment;
        bVar.f12294b = c(R.string.searching_time_tab);
        bVar.f12293a = 1;
        this.f61709c.a(bVar);
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment2 = new PostSearchListFragment(2);
        this.f61712f = postSearchListFragment2;
        bVar2.f12295c = postSearchListFragment2;
        bVar2.f12294b = c(R.string.searching_relative_tab);
        bVar2.f12293a = 2;
        this.f61709c.a(bVar2);
        FragmentTabHost.b bVar3 = new FragmentTabHost.b();
        PostSearchListFragment postSearchListFragment3 = new PostSearchListFragment(3);
        this.f61713g = postSearchListFragment3;
        bVar3.f12295c = postSearchListFragment3;
        bVar3.f12294b = c(R.string.searching_only_thread_tab);
        bVar3.f12293a = 3;
        this.f61709c.a(bVar3);
    }

    public final FragmentTabIndicator c(int i2) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(this.f61707a.getPageContext().getPageActivity()).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        fragmentTabIndicator.setText(i2);
        fragmentTabIndicator.setTextSize(0, this.f61707a.getResources().getDimensionPixelSize(R.dimen.ds32));
        fragmentTabIndicator.l = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setContentTvTopMargin(this.f61707a.getResources().getDimensionPixelSize(R.dimen.ds4));
        fragmentTabIndicator.setWidth((l.k(this.f61707a.getPageContext().getContext()) - (this.f61707a.getResources().getDimensionPixelSize(R.dimen.ds34) * 2)) / 3);
        return fragmentTabIndicator;
    }

    public int d() {
        return this.f61709c.getCurrentTabType();
    }

    public final PostSearchListFragment e(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return null;
                }
                return this.f61713g;
            }
            return this.f61712f;
        }
        return this.f61711e;
    }

    public final void f(int i2) {
        View inflate = ((ViewStub) this.f61708b.findViewById(R.id.search_tab_host_viewstub)).inflate();
        inflate.setVisibility(0);
        FragmentTabHost fragmentTabHost = (FragmentTabHost) inflate.findViewById(R.id.post_search_tab_host);
        this.f61709c = fragmentTabHost;
        fragmentTabHost.setup(this.f61707a.getSupportFragmentManager());
        this.f61709c.setTabWidgetViewHeight((int) this.f61707a.getResources().getDimension(R.dimen.ds80));
        this.f61709c.setShouldDrawIndicatorLine(true);
        b();
        this.f61709c.k(3);
        this.f61709c.setCurrentTabByType(i2);
        this.f61709c.setNeedShowThemeStyle(false);
        this.f61709c.getFragmentTabWidget().setBackGroundDrawableResId(0);
        this.f61709c.p(TbadkCoreApplication.getInst().getSkinType());
        SkinManager.setBackgroundColor(this.f61709c.getFragmentTabWidget(), R.color.CAM_X0201);
        this.f61709c.setOnPageChangeListener(this.f61710d);
    }

    public void g(int i2) {
        FragmentTabHost fragmentTabHost = this.f61709c;
        if (fragmentTabHost != null) {
            fragmentTabHost.p(i2);
        }
        FragmentTabHost fragmentTabHost2 = this.f61709c;
        if (fragmentTabHost2 == null || fragmentTabHost2.getFragmentTabWidget() == null) {
            return;
        }
        SkinManager.setBackgroundColor(this.f61709c.getFragmentTabWidget(), R.color.CAM_X0201);
    }

    public void h(int i2, b bVar, boolean z) {
        j(true);
        PostSearchListFragment e2 = e(i2);
        if (e2 != null) {
            e2.K0(bVar, z);
        }
    }

    public void i(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f61710d = onPageChangeListener;
        FragmentTabHost fragmentTabHost = this.f61709c;
        if (fragmentTabHost != null) {
            fragmentTabHost.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void j(boolean z) {
        FragmentTabHost fragmentTabHost = this.f61709c;
        if (fragmentTabHost != null) {
            if (z) {
                fragmentTabHost.setVisibility(0);
            } else {
                fragmentTabHost.setVisibility(8);
            }
        }
    }

    public void k(int i2) {
        if (this.f61709c == null) {
            f(1);
            return;
        }
        a();
        if (this.f61709c.getCurrentTabType() == i2) {
            PostSearchListFragment e2 = e(i2);
            if (e2 != null) {
                e2.L0(true);
                return;
            }
            return;
        }
        this.f61709c.setCurrentTabByType(i2);
    }
}
