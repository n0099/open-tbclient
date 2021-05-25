package d.a.n0.k3.f.c;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import d.a.m0.r.f0.g;
import d.a.n0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f57079a;

    /* renamed from: b  reason: collision with root package name */
    public View f57080b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f57081c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f57082d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f57083e;

    /* renamed from: f  reason: collision with root package name */
    public g f57084f;

    /* renamed from: g  reason: collision with root package name */
    public a f57085g;

    /* renamed from: h  reason: collision with root package name */
    public int f57086h;

    public b(BubbleListActivity bubbleListActivity, d.a.n0.k3.f.a.a aVar) {
        this.f57084f = null;
        this.f57086h = 0;
        this.f57079a = bubbleListActivity;
        this.f57086h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f57079a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f57080b = inflate;
        this.f57079a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f57080b.findViewById(R.id.view_navigation_bar);
        this.f57081c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57081c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57080b.findViewById(R.id.view_member_recommend);
        this.f57082d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f57083e = (BdListView) this.f57080b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f57079a.getPageContext());
        this.f57084f = gVar;
        this.f57083e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f57079a.getActivity());
        textView.setHeight(l.g(this.f57079a.getActivity(), R.dimen.ds20));
        this.f57083e.addFooterView(textView);
        a aVar2 = new a(this.f57079a.getPageContext(), aVar);
        this.f57085g = aVar2;
        this.f57083e.setAdapter((ListAdapter) aVar2);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 = i2 + 1 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < 2; i3++) {
                int i4 = i2 + i3;
                if (i4 < size) {
                    arrayList2.add(list.get(i4));
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public void b() {
        SkinManager.setBackgroundColor(this.f57080b, R.color.CAM_X0204);
        this.f57079a.hideNetRefreshView(this.f57080b);
        this.f57082d.setVisibility(0);
        this.f57083e.setVisibility(0);
        this.f57080b.setVisibility(0);
    }

    public View c() {
        return this.f57080b;
    }

    public void d() {
        a aVar;
        d.a.m0.s0.a.a(this.f57079a.getPageContext(), this.f57080b);
        NavigationBar navigationBar = this.f57081c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57079a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f57083e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f57085g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f57084f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f57082d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f57083e.setVisibility(0);
            this.f57085g.b(list);
            this.f57085g.notifyDataSetChanged();
            return;
        }
        this.f57083e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57082d.setVisibility(0);
            this.f57082d.e(eVar);
            return true;
        }
        this.f57082d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f57083e.setOnSrollToBottomListener(pVar);
        this.f57084f.a(gVar);
    }

    public void h() {
        this.f57082d.setVisibility(8);
        this.f57083e.setVisibility(8);
        this.f57080b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f57080b, R.color.CAM_X0201);
        String string = this.f57079a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57079a.setNetRefreshViewTopMargin(this.f57086h);
        this.f57079a.showNetRefreshView(this.f57080b, string, false);
    }

    public void i(e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            f(eVar);
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f57083e.A(0L);
    }
}
