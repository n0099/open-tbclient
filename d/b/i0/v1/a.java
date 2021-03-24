package d.b.i0.v1;

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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f61975a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f61976b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f61978d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f61979e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f61980f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f61981g;
    public List i;

    /* renamed from: c  reason: collision with root package name */
    public int f61977c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f61982h = false;
    public ViewPager.OnPageChangeListener j = new C1636a();

    /* renamed from: d.b.i0.v1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1636a implements ViewPager.OnPageChangeListener {
        public C1636a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            a.this.l(i);
            a.this.b(false);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public a(CollectTabActivity collectTabActivity) {
        this.f61981g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f61976b = fragmentTabHost;
        fragmentTabHost.setup(this.f61981g.getSupportFragmentManager());
        this.f61976b.setOnPageChangeListener(this.j);
        this.f61979e = (NavigationBar) this.f61981g.findViewById(R.id.navigation_bar);
        this.f61980f = (NoNetworkView) this.f61981g.findViewById(R.id.view_no_network);
        this.f61979e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61979e.setCenterTextTitle(this.f61981g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f61979e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f61981g).findViewById(R.id.right_textview);
        this.f61975a = textView;
        textView.setText(R.string.edit);
        this.f61975a.setOnClickListener(this.f61981g);
        this.f61979e.onChangeSkinType(this.f61981g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i;
        Fragment fragment = this.f61978d;
        if (fragment instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) fragment;
            if (!collectFragment.G0()) {
                z = false;
            }
            k(collectFragment.G0());
            i = collectFragment.E0();
        } else {
            i = -1;
        }
        this.f61982h = z;
        this.f61975a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f61975a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f61975a, this.f61982h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f61982h);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.b.h0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.b.h0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f13312c = fragmentTabStructure.f50154a;
        bVar2.f13310a = fragmentTabStructure.f50158e;
        fragmentTabIndicator.setText(fragmentTabStructure.f50155b);
        fragmentTabIndicator.setTextSize(0, this.f61981g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f13311b = fragmentTabIndicator;
        bVar2.f13313d = bVar;
        this.f61976b.a(bVar2);
    }

    public TextView d() {
        return this.f61975a;
    }

    public Fragment e() {
        return this.f61978d;
    }

    public int f() {
        return this.f61977c;
    }

    public final int g() {
        return ListUtils.getCount(this.i);
    }

    public void h(ArrayList<d.b.h0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.i = arrayList;
        this.f61976b.p();
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.h0.e0.b bVar = arrayList.get(i);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f61981g.getPageContext().getPageActivity()));
            }
        }
        this.f61976b.k(0);
        this.f61976b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f61976b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f61982h;
    }

    public void j(int i) {
        this.f61976b.o(i);
        if (this.f61976b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f61976b.getTabWrapper().setVisibility(8);
            } else {
                this.f61976b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f61975a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f61979e.onChangeSkinType(this.f61981g.getPageContext(), i);
        this.f61980f.c(this.f61981g.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f61975a.setEnabled(z);
        if (z) {
            return;
        }
        this.f61975a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f61975a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i) {
        FragmentTabHost.b f2 = this.f61976b.f(i);
        this.f61977c = f2.f13310a;
        this.f61978d = f2.f13312c;
    }
}
