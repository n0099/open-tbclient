package d.a.n0.x1;

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
    public final TextView f63222a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f63223b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f63225d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f63226e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f63227f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f63228g;

    /* renamed from: i  reason: collision with root package name */
    public List f63230i;

    /* renamed from: c  reason: collision with root package name */
    public int f63224c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63229h = false;
    public ViewPager.OnPageChangeListener j = new C1736a();

    /* renamed from: d.a.n0.x1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1736a implements ViewPager.OnPageChangeListener {
        public C1736a() {
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
        this.f63228g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f63223b = fragmentTabHost;
        fragmentTabHost.setup(this.f63228g.getSupportFragmentManager());
        this.f63223b.setOnPageChangeListener(this.j);
        this.f63226e = (NavigationBar) this.f63228g.findViewById(R.id.navigation_bar);
        this.f63227f = (NoNetworkView) this.f63228g.findViewById(R.id.view_no_network);
        this.f63226e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63226e.setCenterTextTitle(this.f63228g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f63226e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f63228g).findViewById(R.id.right_textview);
        this.f63222a = textView;
        textView.setText(R.string.edit);
        this.f63222a.setOnClickListener(this.f63228g);
        this.f63226e.onChangeSkinType(this.f63228g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Fragment fragment = this.f63225d;
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
        this.f63229h = z;
        this.f63222a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f63222a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f63222a, this.f63229h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f63229h);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.a.m0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.a.m0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12151c = fragmentTabStructure.f49334a;
        bVar2.f12149a = fragmentTabStructure.f49338e;
        fragmentTabIndicator.setText(fragmentTabStructure.f49335b);
        fragmentTabIndicator.setTextSize(0, this.f63228g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12150b = fragmentTabIndicator;
        bVar2.f12152d = bVar;
        this.f63223b.a(bVar2);
    }

    public TextView d() {
        return this.f63222a;
    }

    public Fragment e() {
        return this.f63225d;
    }

    public int f() {
        return this.f63224c;
    }

    public final int g() {
        return ListUtils.getCount(this.f63230i);
    }

    public void h(ArrayList<d.a.m0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f63230i = arrayList;
        this.f63223b.p();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.m0.e0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f63228g.getPageContext().getPageActivity()));
            }
        }
        this.f63223b.k(0);
        this.f63223b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f63223b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f63229h;
    }

    public void j(int i2) {
        this.f63223b.o(i2);
        if (this.f63223b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f63223b.getTabWrapper().setVisibility(8);
            } else {
                this.f63223b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f63222a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f63226e.onChangeSkinType(this.f63228g.getPageContext(), i2);
        this.f63227f.c(this.f63228g.getPageContext(), i2);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f63222a.setEnabled(z);
        if (z) {
            return;
        }
        this.f63222a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f63222a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i2) {
        FragmentTabHost.b f2 = this.f63223b.f(i2);
        this.f63224c = f2.f12149a;
        this.f63225d = f2.f12151c;
    }
}
