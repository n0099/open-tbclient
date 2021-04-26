package d.a.j0.w1;

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
    public final TextView f62313a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f62314b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f62316d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f62317e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f62318f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f62319g;

    /* renamed from: i  reason: collision with root package name */
    public List f62321i;

    /* renamed from: c  reason: collision with root package name */
    public int f62315c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f62320h = false;
    public ViewPager.OnPageChangeListener j = new C1654a();

    /* renamed from: d.a.j0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1654a implements ViewPager.OnPageChangeListener {
        public C1654a() {
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
        this.f62319g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f62314b = fragmentTabHost;
        fragmentTabHost.setup(this.f62319g.getSupportFragmentManager());
        this.f62314b.setOnPageChangeListener(this.j);
        this.f62317e = (NavigationBar) this.f62319g.findViewById(R.id.navigation_bar);
        this.f62318f = (NoNetworkView) this.f62319g.findViewById(R.id.view_no_network);
        this.f62317e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f62317e.setCenterTextTitle(this.f62319g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f62317e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f62319g).findViewById(R.id.right_textview);
        this.f62313a = textView;
        textView.setText(R.string.edit);
        this.f62313a.setOnClickListener(this.f62319g);
        this.f62317e.onChangeSkinType(this.f62319g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Fragment fragment = this.f62316d;
        if (fragment instanceof CollectFragment) {
            CollectFragment collectFragment = (CollectFragment) fragment;
            if (!collectFragment.G0()) {
                z = false;
            }
            k(collectFragment.G0());
            i2 = collectFragment.E0();
        } else {
            i2 = -1;
        }
        this.f62320h = z;
        this.f62313a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f62313a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f62313a, this.f62320h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f62320h);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.a.i0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.a.i0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12907c = fragmentTabStructure.f48462a;
        bVar2.f12905a = fragmentTabStructure.f48466e;
        fragmentTabIndicator.setText(fragmentTabStructure.f48463b);
        fragmentTabIndicator.setTextSize(0, this.f62319g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12906b = fragmentTabIndicator;
        bVar2.f12908d = bVar;
        this.f62314b.a(bVar2);
    }

    public TextView d() {
        return this.f62313a;
    }

    public Fragment e() {
        return this.f62316d;
    }

    public int f() {
        return this.f62315c;
    }

    public final int g() {
        return ListUtils.getCount(this.f62321i);
    }

    public void h(ArrayList<d.a.i0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f62321i = arrayList;
        this.f62314b.p();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.i0.e0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f62319g.getPageContext().getPageActivity()));
            }
        }
        this.f62314b.k(0);
        this.f62314b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f62314b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f62320h;
    }

    public void j(int i2) {
        this.f62314b.o(i2);
        if (this.f62314b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f62314b.getTabWrapper().setVisibility(8);
            } else {
                this.f62314b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f62313a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f62317e.onChangeSkinType(this.f62319g.getPageContext(), i2);
        this.f62318f.c(this.f62319g.getPageContext(), i2);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f62313a.setEnabled(z);
        if (z) {
            return;
        }
        this.f62313a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f62313a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i2) {
        FragmentTabHost.b f2 = this.f62314b.f(i2);
        this.f62315c = f2.f12905a;
        this.f62316d = f2.f12907c;
    }
}
