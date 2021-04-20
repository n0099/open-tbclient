package d.b.i0.w1;

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
    public final TextView f63642a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentTabHost f63643b;

    /* renamed from: d  reason: collision with root package name */
    public Fragment f63645d;

    /* renamed from: e  reason: collision with root package name */
    public final NavigationBar f63646e;

    /* renamed from: f  reason: collision with root package name */
    public final NoNetworkView f63647f;

    /* renamed from: g  reason: collision with root package name */
    public CollectTabActivity f63648g;
    public List i;

    /* renamed from: c  reason: collision with root package name */
    public int f63644c = -1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63649h = false;
    public ViewPager.OnPageChangeListener j = new C1694a();

    /* renamed from: d.b.i0.w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1694a implements ViewPager.OnPageChangeListener {
        public C1694a() {
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
        this.f63648g = collectTabActivity;
        FragmentTabHost fragmentTabHost = (FragmentTabHost) collectTabActivity.findViewById(R.id.tab_host);
        this.f63643b = fragmentTabHost;
        fragmentTabHost.setup(this.f63648g.getSupportFragmentManager());
        this.f63643b.setOnPageChangeListener(this.j);
        this.f63646e = (NavigationBar) this.f63648g.findViewById(R.id.navigation_bar);
        this.f63647f = (NoNetworkView) this.f63648g.findViewById(R.id.view_no_network);
        this.f63646e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63646e.setCenterTextTitle(this.f63648g.getPageContext().getString(R.string.my_mark));
        TextView textView = (TextView) this.f63646e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, this.f63648g).findViewById(R.id.right_textview);
        this.f63642a = textView;
        textView.setText(R.string.edit);
        this.f63642a.setOnClickListener(this.f63648g);
        this.f63646e.onChangeSkinType(this.f63648g.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        j(TbadkCoreApplication.getInst().getSkinType());
    }

    @SuppressLint({"ResourceAsColor"})
    public void b(boolean z) {
        int i;
        Fragment fragment = this.f63645d;
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
        this.f63649h = z;
        this.f63642a.setText(z ? R.string.done : R.string.edit);
        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
            SkinManager.setNavbarTitleColor(this.f63642a, R.color.navi_op_text, R.color.navi_op_text_skin);
        } else {
            SkinManager.setNavbarTitleColor(this.f63642a, this.f63649h ? R.color.CAM_X0302 : R.color.navi_op_text, R.color.navi_op_text_skin);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_edit_state", this.f63649h);
        bundle.putInt("fragment_type", i);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2022208, bundle));
    }

    public final void c(d.b.h0.e0.b bVar, FragmentTabIndicator fragmentTabIndicator) {
        d.b.h0.e0.c fragmentTabStructure = bVar.getFragmentTabStructure();
        if (fragmentTabStructure == null) {
            return;
        }
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        bVar2.f12974c = fragmentTabStructure.f50548a;
        bVar2.f12972a = fragmentTabStructure.f50552e;
        fragmentTabIndicator.setText(fragmentTabStructure.f50549b);
        fragmentTabIndicator.setTextSize(0, this.f63648g.getResources().getDimension(R.dimen.fontsize32));
        fragmentTabIndicator.setTextColorResId(R.color.s_actionbar_text_color);
        fragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        fragmentTabIndicator.setTipPosType(1);
        bVar2.f12973b = fragmentTabIndicator;
        bVar2.f12975d = bVar;
        this.f63643b.a(bVar2);
    }

    public TextView d() {
        return this.f63642a;
    }

    public Fragment e() {
        return this.f63645d;
    }

    public int f() {
        return this.f63644c;
    }

    public final int g() {
        return ListUtils.getCount(this.i);
    }

    public void h(ArrayList<d.b.h0.e0.b> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.i = arrayList;
        this.f63643b.p();
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.h0.e0.b bVar = arrayList.get(i);
            if (bVar != null && bVar.isAvailable()) {
                c(bVar, (FragmentTabIndicator) bVar.getTabIndicator(this.f63648g.getPageContext().getPageActivity()));
            }
        }
        this.f63643b.k(0);
        this.f63643b.setCurrentTab(0);
        if (arrayList.size() == 1) {
            this.f63643b.getFragmentTabWidget().setVisibility(8);
        }
        l(0);
    }

    public boolean i() {
        return this.f63649h;
    }

    public void j(int i) {
        this.f63643b.o(i);
        if (this.f63643b.getTabWrapper() != null) {
            if (g() <= 1) {
                this.f63643b.getTabWrapper().setVisibility(8);
            } else {
                this.f63643b.getTabWrapper().setVisibility(0);
            }
        }
        SkinManager.setNavbarTitleColor(this.f63642a, R.color.navi_op_text, R.color.navi_op_text_skin);
        this.f63646e.onChangeSkinType(this.f63648g.getPageContext(), i);
        this.f63647f.c(this.f63648g.getPageContext(), i);
    }

    @SuppressLint({"ResourceAsColor"})
    public void k(boolean z) {
        this.f63642a.setEnabled(z);
        if (z) {
            return;
        }
        this.f63642a.setText(R.string.edit);
        SkinManager.setNavbarTitleColor(this.f63642a, R.color.navi_op_text, R.color.navi_op_text_skin);
    }

    public final void l(int i) {
        FragmentTabHost.b f2 = this.f63643b.f(i);
        this.f63644c = f2.f12972a;
        this.f63645d = f2.f12974c;
    }
}
