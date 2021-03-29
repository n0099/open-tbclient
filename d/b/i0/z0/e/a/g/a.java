package d.b.i0.z0.e.a.g;

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
import d.b.b.e.p.l;
import d.b.h0.r.f0.m.c;
import java.util.List;
/* loaded from: classes3.dex */
public class a implements TabLayout.OnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public TabLayout.OnTabSelectedListener f62978a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62979b;

    /* renamed from: c  reason: collision with root package name */
    public TabLayout f62980c;

    /* renamed from: d  reason: collision with root package name */
    public int f62981d;

    public a(Context context) {
        this.f62979b = context;
        c();
    }

    public Context a() {
        return this.f62979b;
    }

    public TabLayout b() {
        return this.f62980c;
    }

    public final void c() {
        TabLayout tabLayout = (TabLayout) LayoutInflater.from(a()).inflate(R.layout.default_tab_layout, (ViewGroup) null);
        this.f62980c = tabLayout;
        tabLayout.setOnTabSelectedListener(this);
    }

    public void d(int i) {
        for (int i2 = 0; i2 < this.f62980c.getTabCount(); i2++) {
            TabLayout.Tab tabAt = this.f62980c.getTabAt(i2);
            if (tabAt != null) {
                if (tabAt.isSelected()) {
                    g(tabAt);
                } else {
                    h(tabAt);
                }
                if (tabAt.getCustomView() instanceof TBSpecificationBtn) {
                    ((TBSpecificationBtn) tabAt.getCustomView()).l(i);
                }
            }
        }
    }

    public void e(TabLayout.OnTabSelectedListener onTabSelectedListener) {
        this.f62978a = onTabSelectedListener;
    }

    public void f(FrsTabInfoData frsTabInfoData) {
        i(this.f62981d, frsTabInfoData.tabList, this.f62980c);
    }

    public final void g(TabLayout.Tab tab) {
        if (tab.getCustomView() != null) {
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
            if (tBSpecificationBtn.getStyleConfig() instanceof c) {
                ((c) tBSpecificationBtn.getStyleConfig()).o(R.color.CAM_X0304);
            }
        }
    }

    public final void h(TabLayout.Tab tab) {
        if (tab == null || tab.getCustomView() == null) {
            return;
        }
        TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) tab.getCustomView();
        if (tBSpecificationBtn.getStyleConfig() instanceof c) {
            ((c) tBSpecificationBtn.getStyleConfig()).q(R.color.CAM_X0108);
        }
    }

    public final void i(int i, List<FrsTabItemData> list, TabLayout tabLayout) {
        int min = Math.min(list.size(), 9);
        if (tabLayout.getTabCount() > min) {
            int tabCount = tabLayout.getTabCount() - min;
            for (int i2 = 0; i2 < tabCount; i2++) {
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
        for (int i3 = 0; i3 < min; i3++) {
            TabLayout.Tab tabAt = tabLayout.getTabAt(i3);
            if (tabAt == null) {
                tabAt = tabLayout.newTab();
                tabLayout.addTab(tabAt, false);
                View childAt = linearLayout.getChildAt(i3);
                ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                layoutParams2.width = -2;
                layoutParams2.height = -2;
                childAt.requestLayout();
                if (childAt != null) {
                    childAt.setPadding(0, 0, 0, 0);
                }
            }
            FrsTabItemData frsTabItemData = list.get(i3);
            tabAt.setTag(frsTabItemData);
            if (!(tabAt.getCustomView() instanceof TBSpecificationBtn)) {
                TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(a());
                c cVar = new c();
                cVar.q(R.color.CAM_X0108);
                tBSpecificationBtn.setConfig(cVar);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds177), UtilHelper.getDimenPixelSize(R.dimen.tbds75));
                layoutParams3.setMargins(g2, g3, g2, g4);
                tBSpecificationBtn.setLayoutParams(layoutParams3);
                tabAt.setCustomView(tBSpecificationBtn);
            }
            ((TBSpecificationBtn) tabAt.getCustomView()).setText(StringHelper.cutForumNameWithSuffix(frsTabItemData.name, 10, StringHelper.STRING_MORE));
            if (!tabAt.isSelected() && i == frsTabItemData.tabId) {
                tabAt.select();
            }
        }
        linearLayout.setPadding(0, 0, 0, 0);
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabReselected(TabLayout.Tab tab) {
        g(tab);
        TabLayout.OnTabSelectedListener onTabSelectedListener = this.f62978a;
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabReselected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null && (tab.getTag() instanceof FrsTabItemData)) {
            this.f62981d = ((FrsTabItemData) tab.getTag()).tabId;
        }
        g(tab);
        TabLayout.OnTabSelectedListener onTabSelectedListener = this.f62978a;
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabSelected(tab);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public void onTabUnselected(TabLayout.Tab tab) {
        h(tab);
        TabLayout.OnTabSelectedListener onTabSelectedListener = this.f62978a;
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabUnselected(tab);
        }
    }
}
