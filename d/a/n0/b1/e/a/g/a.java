package d.a.n0.b1.e.a.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.google.android.material.tabs.TabLayout;
import d.a.c.e.p.l;
import d.a.m0.r.f0.m.b;
import java.util.List;
/* loaded from: classes4.dex */
public class a implements TabLayout.OnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f51584a;

    /* renamed from: b  reason: collision with root package name */
    public Context f51585b;

    /* renamed from: c  reason: collision with root package name */
    public TabLayout f51586c;

    /* renamed from: d  reason: collision with root package name */
    public int f51587d;

    public a(Context context) {
        this.f51585b = context;
        c();
    }

    public Context a() {
        return this.f51585b;
    }

    public TabLayout b() {
        return this.f51586c;
    }

    public final void c() {
        TabLayout tabLayout = (TabLayout) LayoutInflater.from(a()).inflate(R.layout.default_tab_layout, (ViewGroup) null);
        this.f51586c = tabLayout;
        tabLayout.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) this);
        this.f51586c.setTabGravity(2);
    }

    public void d(int i2) {
        for (int i3 = 0; i3 < this.f51586c.getTabCount(); i3++) {
            TabLayout.Tab tabAt = this.f51586c.getTabAt(i3);
            if (tabAt != null) {
                if (tabAt.isSelected()) {
                    g(tabAt);
                } else {
                    h(tabAt);
                }
                if (tabAt.getCustomView() instanceof TBSpecificationBtn) {
                    ((TBSpecificationBtn) tabAt.getCustomView()).l(i2);
                }
            }
        }
    }

    public void e(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.f51584a = onTabSelectedListener;
    }

    public void f(FrsTabInfoData frsTabInfoData) {
        i(this.f51587d, frsTabInfoData.tabList, this.f51586c);
    }

    public final void g(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof b) {
                ((b) tBSpecificationBtn.getStyleConfig()).s(R.color.CAM_X0304);
            }
        }
    }

    public final void h(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
        if (tBSpecificationBtn.getStyleConfig() instanceof b) {
            ((b) tBSpecificationBtn.getStyleConfig()).s(R.color.CAM_X0108);
        }
    }

    public final void i(int i2, List<FrsTabItemData> list, TabLayout tabLayout) {
        int min = Math.min(list.size(), 9);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i3 = 0; i3 < tabCount; i3++) {
                tabLayout.removeTabAt(0);
            }
        }
        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
        if (linearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        linearLayout.requestLayout();
        int g2 = l.g(a(), R.dimen.M_W_X006) / 2;
        int g3 = l.g(a(), R.dimen.M_H_X003);
        int g4 = l.g(a(), R.dimen.M_H_X001);
        for (int i4 = 0; i4 < min; i4++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i4);
            if (tabAt == null) {
                tabAt = tabLayout.newTab();
                tabLayout.addTab(tabAt, false);
                View childAt = linearLayout.getChildAt(i4);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -2;
                childAt.requestLayout();
                if (childAt != null) {
                    childAt.setPadding(0, 0, 0, 0);
                }
            }
            FrsTabItemData frsTabItemData = list.get(i4);
            tabAt.setTag(frsTabItemData);
            if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(a());
                b bVar = new b();
                bVar.s(R.color.CAM_X0108);
                tBSpecificationBtn.setConfig(bVar);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds177), UtilHelper.getDimenPixelSize(R.dimen.tbds75));
                layoutParams3.setMargins(g2, g3, g2, g4);
                tBSpecificationBtn.setLayoutParams(layoutParams3);
                tabAt.setCustomView(tBSpecificationBtn);
            }
            ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(frsTabItemData.name, 10, StringHelper.STRING_MORE));
            if (!tabAt.isSelected() && i2 == frsTabItemData.tabId) {
                tabAt.select();
            }
        }
        linearLayout.setPadding(0, 0, 0, 0);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        g(tab);
        TabLayout.OnTabSelectedListener onTabSelectedListener = this.f51584a;
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabReselected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
            this.f51587d = ((FrsTabItemData) tab.getTag()).tabId;
        }
        g(tab);
        TabLayout.OnTabSelectedListener onTabSelectedListener = this.f51584a;
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        h(tab);
        TabLayout.OnTabSelectedListener onTabSelectedListener = this.f51584a;
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabUnselected(tab);
        }
    }
}
