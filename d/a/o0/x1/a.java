package d.a.o0.x1;

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
    public final TextView f67062a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f67063b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f67065d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f67066e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f67067f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f67068g;

    /* renamed from: i  reason: collision with root package name */
    public List f67070i;

    /* renamed from: c  reason: collision with root package name */
    public int f67064c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f67069h = false;
    public ViewPager.OnPageChangeListener j = new C1797a();

    /* renamed from: d.a.o0.x1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1797a implements ViewPager.OnPageChangeListener {
        public C1797a() {
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
        this.f67068g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f67063b = fragmentTabHost;
        fragmentTabHost.setup(this.f67068g.getSupportFragmentManager());
        this.f67063b.setOnPageChangeListener(this.j);
        this.f67066e = (NavigationBar) this.f67068g.findViewById(R.id.navigation_bar);
        this.f67067f = (NoNetworkView) this.f67068g.findViewById(R.id.view_no_network);
        this.f67066e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f67066e.setCenterTextTitle(this.f67068g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f67066e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f67068g).findViewById(R.id.right_textview);
        this.f67062a = textView;
        textView.setText(R.string.edit);
        this.f67062a.setOnClickListener(this.f67068g);
        this.f67066e.onChangeSkinType(this.f67068g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i2;
        Fragment fragment = this.f67065d;
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
        this.f67069h = z;
        this.f67062a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f67062a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f67062a, this.f67069h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f67069h);
        bundle.putInt("fragment_type", i2);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.a.n0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.a.n0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12295c = fragmentTabStructure.f53115a;
        bVar2.f12293a = fragmentTabStructure.f53119e;
        fragmentTabIndicator.setText(fragmentTabStructure.f53116b);
        fragmentTabIndicator.setTextSize(0, this.f67068g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12294b = fragmentTabIndicator;
        bVar2.f12296d = bVar;
        this.f67063b.a(bVar2);
    }

    public TextView d() {
        return this.f67062a;
    }

    public Fragment e() {
        return this.f67065d;
    }

    public int f() {
        return this.f67064c;
    }

    public final int g() {
        return ListUtils.getCount(this.f67070i);
    }

    public void h(ArrayList<d.a.n0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.f67070i = arrayList;
        this.f67063b.q();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.n0.e0.b bVar = arrayList.get(i2);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f67068g.getPageContext().getPageActivity()));
            }
        }
        this.f67063b.k(0);
        this.f67063b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f67063b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f67069h;
    }

    public void j(int i2) {
        this.f67063b.p(i2);
        if (this.f67063b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f67063b.getTabWrapper().setVisibility(8);
            } else {
                this.f67063b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f67062a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f67066e.onChangeSkinType(this.f67068g.getPageContext(), i2);
        this.f67067f.c(this.f67068g.getPageContext(), i2);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f67062a.setEnabled(z);
        if (z) {
            return;
        }
        this.f67062a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f67062a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i2) {
        FragmentTabHost.b f2 = this.f67063b.f(i2);
        this.f67064c = f2.f12293a;
        this.f67065d = f2.f12295c;
    }
}
