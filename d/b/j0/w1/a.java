package d.b.j0.w1;

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
    public final TextView f64063a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f64064b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f64066d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f64067e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f64068f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f64069g;
    public List i;

    /* renamed from: c  reason: collision with root package name */
    public int f64065c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64070h = false;
    public ViewPager.OnPageChangeListener j = new C1717a();

    /* renamed from: d.b.j0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1717a implements ViewPager.OnPageChangeListener {
        public C1717a() {
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
        this.f64069g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f64064b = fragmentTabHost;
        fragmentTabHost.setup(this.f64069g.getSupportFragmentManager());
        this.f64064b.setOnPageChangeListener(this.j);
        this.f64067e = (NavigationBar) this.f64069g.findViewById(R.id.navigation_bar);
        this.f64068f = (NoNetworkView) this.f64069g.findViewById(R.id.view_no_network);
        this.f64067e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64067e.setCenterTextTitle(this.f64069g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f64067e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f64069g).findViewById(R.id.right_textview);
        this.f64063a = textView;
        textView.setText(R.string.edit);
        this.f64063a.setOnClickListener(this.f64069g);
        this.f64067e.onChangeSkinType(this.f64069g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i;
        Fragment fragment = this.f64066d;
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
        this.f64070h = z;
        this.f64063a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f64063a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f64063a, this.f64070h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f64070h);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.b.i0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.b.i0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12982c = fragmentTabStructure.f50884a;
        bVar2.f12980a = fragmentTabStructure.f50888e;
        fragmentTabIndicator.setText(fragmentTabStructure.f50885b);
        fragmentTabIndicator.setTextSize(0, this.f64069g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12981b = fragmentTabIndicator;
        bVar2.f12983d = bVar;
        this.f64064b.a(bVar2);
    }

    public TextView d() {
        return this.f64063a;
    }

    public Fragment e() {
        return this.f64066d;
    }

    public int f() {
        return this.f64065c;
    }

    public final int g() {
        return ListUtils.getCount(this.i);
    }

    public void h(ArrayList<d.b.i0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.i = arrayList;
        this.f64064b.p();
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.i0.e0.b bVar = arrayList.get(i);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f64069g.getPageContext().getPageActivity()));
            }
        }
        this.f64064b.k(0);
        this.f64064b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f64064b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f64070h;
    }

    public void j(int i) {
        this.f64064b.o(i);
        if (this.f64064b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f64064b.getTabWrapper().setVisibility(8);
            } else {
                this.f64064b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f64063a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f64067e.onChangeSkinType(this.f64069g.getPageContext(), i);
        this.f64068f.c(this.f64069g.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f64063a.setEnabled(z);
        if (z) {
            return;
        }
        this.f64063a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f64063a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i) {
        FragmentTabHost.b f2 = this.f64064b.f(i);
        this.f64065c = f2.f12980a;
        this.f64066d = f2.f12982c;
    }
}
