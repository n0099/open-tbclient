package d.a.k0.w1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.collectTab.CollectFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.R;
import com.baidu.tieba.myCollection.CollectTabActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f63037a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f63038b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f63040d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f63041e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f63042f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f63043g;

    /* renamed from: i  reason: collision with root package name */
    public List f63045i;

    /* renamed from: c  reason: collision with root package name */
    public int f63039c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63044h = false;
    public ViewPager.OnPageChangeListener j = new C1719a();

    /* renamed from: d.a.k0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1719a implements ViewPager.OnPageChangeListener {
        public C1719a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            a.this.l(i2);
            a.this.b(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.f63043g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f63038b = fragmentTabHost;
        fragmentTabHost.setup(this.f63043g.getSupportFragmentManager());
        this.f63038b.setOnPageChangeListener(this.j);
        this.f63041e = (NavigationBar) this.f63043g.findViewById(R.id.navigation_bar);
        this.f63042f = (NoNetworkView) this.f63043g.findViewById(R.id.view_no_network);
        this.f63041e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63041e.setCenterTextTitle(this.f63043g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f63041e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f63043g).findViewById(R.id.right_textview);
        this.f63037a = textView;
        textView.setText(R.string.edit);
        this.f63037a.setOnClickListener(this.f63043g);
        this.f63041e.onChangeSkinType(this.f63043g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Fragment fragment = this.f63040d;
        if (fragment instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) fragment;
            if (!collectFragment.F0()) {
                z = false;
            }
            k(collectFragment.F0());
            i2 = collectFragment.D0();
        } else {
            i2 = -1;
        }
        this.f63044h = z;
        this.f63037a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f63037a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f63037a, this.f63044h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f63044h);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.a.j0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.a.j0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12243c = fragmentTabStructure.f49290a;
        bVar2.f12241a = fragmentTabStructure.f49294e;
        fragmentTabIndicator.setText(fragmentTabStructure.f49291b);
        fragmentTabIndicator.setTextSize(0, this.f63043g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12242b = fragmentTabIndicator;
        bVar2.f12244d = bVar;
        this.f63038b.a(bVar2);
    }

    public TextView d() {
        return this.f63037a;
    }

    public Fragment e() {
        return this.f63040d;
    }

    public int f() {
        return this.f63039c;
    }

    public final int g() {
        return ListUtils.getCount(this.f63045i);
    }

    public void h(ArrayList<d.a.j0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f63045i = arrayList;
        this.f63038b.p();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.j0.e0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f63043g.getPageContext().getPageActivity()));
            }
        }
        this.f63038b.k(0);
        this.f63038b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f63038b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f63044h;
    }

    public void j(int i2) {
        this.f63038b.o(i2);
        if (this.f63038b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f63038b.getTabWrapper().setVisibility(8);
            } else {
                this.f63038b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f63037a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f63041e.onChangeSkinType(this.f63043g.getPageContext(), i2);
        this.f63042f.c(this.f63043g.getPageContext(), i2);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f63037a.setEnabled(z);
        if (z) {
            return;
        }
        this.f63037a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f63037a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i2) {
        FragmentTabHost.b f2 = this.f63038b.f(i2);
        this.f63039c = f2.f12241a;
        this.f63040d = f2.f12243c;
    }
}
