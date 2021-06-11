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
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f66937a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f66938b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f66940d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f66941e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f66942f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f66943g;

    /* renamed from: i  reason: collision with root package name */
    public List f66945i;

    /* renamed from: c  reason: collision with root package name */
    public int f66939c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f66944h = false;
    public ViewPager.OnPageChangeListener j = new C1793a();

    /* renamed from: d.a.n0.x1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1793a implements ViewPager.OnPageChangeListener {
        public C1793a() {
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
        this.f66943g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f66938b = fragmentTabHost;
        fragmentTabHost.setup(this.f66943g.getSupportFragmentManager());
        this.f66938b.setOnPageChangeListener(this.j);
        this.f66941e = (NavigationBar) this.f66943g.findViewById(R.id.navigation_bar);
        this.f66942f = (NoNetworkView) this.f66943g.findViewById(R.id.view_no_network);
        this.f66941e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f66941e.setCenterTextTitle(this.f66943g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f66941e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f66943g).findViewById(R.id.right_textview);
        this.f66937a = textView;
        textView.setText(R.string.edit);
        this.f66937a.setOnClickListener(this.f66943g);
        this.f66941e.onChangeSkinType(this.f66943g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Fragment fragment = this.f66940d;
        if (fragment instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) fragment;
            if (!collectFragment.I0()) {
                z = false;
            }
            k(collectFragment.I0());
            i2 = collectFragment.G0();
        } else {
            i2 = -1;
        }
        this.f66944h = z;
        this.f66937a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f66937a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f66937a, this.f66944h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f66944h);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.a.m0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.a.m0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12213c = fragmentTabStructure.f53008a;
        bVar2.f12211a = fragmentTabStructure.f53012e;
        fragmentTabIndicator.setText(fragmentTabStructure.f53009b);
        fragmentTabIndicator.setTextSize(0, this.f66943g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12212b = fragmentTabIndicator;
        bVar2.f12214d = bVar;
        this.f66938b.a(bVar2);
    }

    public TextView d() {
        return this.f66937a;
    }

    public Fragment e() {
        return this.f66940d;
    }

    public int f() {
        return this.f66939c;
    }

    public final int g() {
        return ListUtils.getCount(this.f66945i);
    }

    public void h(ArrayList<d.a.m0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f66945i = arrayList;
        this.f66938b.q();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.m0.e0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f66943g.getPageContext().getPageActivity()));
            }
        }
        this.f66938b.k(0);
        this.f66938b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f66938b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f66944h;
    }

    public void j(int i2) {
        this.f66938b.p(i2);
        if (this.f66938b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f66938b.getTabWrapper().setVisibility(8);
            } else {
                this.f66938b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f66937a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f66941e.onChangeSkinType(this.f66943g.getPageContext(), i2);
        this.f66942f.c(this.f66943g.getPageContext(), i2);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f66937a.setEnabled(z);
        if (z) {
            return;
        }
        this.f66937a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f66937a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i2) {
        FragmentTabHost.b f2 = this.f66938b.f(i2);
        this.f66939c = f2.f12211a;
        this.f66940d = f2.f12213c;
    }
}
