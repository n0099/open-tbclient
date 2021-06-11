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
    public BubbleListActivity f60768a;

    /* renamed from: b  reason: collision with root package name */
    public View f60769b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60770c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f60771d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60772e;

    /* renamed from: f  reason: collision with root package name */
    public g f60773f;

    /* renamed from: g  reason: collision with root package name */
    public a f60774g;

    /* renamed from: h  reason: collision with root package name */
    public int f60775h;

    public b(BubbleListActivity bubbleListActivity, d.a.n0.k3.f.a.a aVar) {
        this.f60773f = null;
        this.f60775h = 0;
        this.f60768a = bubbleListActivity;
        this.f60775h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60768a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f60769b = inflate;
        this.f60768a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f60769b.findViewById(R.id.view_navigation_bar);
        this.f60770c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60770c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60769b.findViewById(R.id.view_member_recommend);
        this.f60771d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f60772e = (BdListView) this.f60769b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f60768a.getPageContext());
        this.f60773f = gVar;
        this.f60772e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f60768a.getActivity());
        textView.setHeight(l.g(this.f60768a.getActivity(), R.dimen.ds20));
        this.f60772e.addFooterView(textView);
        a aVar2 = new a(this.f60768a.getPageContext(), aVar);
        this.f60774g = aVar2;
        this.f60772e.setAdapter((ListAdapter) aVar2);
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
        SkinManager.setBackgroundColor(this.f60769b, R.color.CAM_X0204);
        this.f60768a.hideNetRefreshView(this.f60769b);
        this.f60771d.setVisibility(0);
        this.f60772e.setVisibility(0);
        this.f60769b.setVisibility(0);
    }

    public View c() {
        return this.f60769b;
    }

    public void d() {
        a aVar;
        d.a.m0.s0.a.a(this.f60768a.getPageContext(), this.f60769b);
        NavigationBar navigationBar = this.f60770c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60768a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f60772e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f60774g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f60773f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f60771d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f60772e.setVisibility(0);
            this.f60774g.b(list);
            this.f60774g.notifyDataSetChanged();
            return;
        }
        this.f60772e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60771d.setVisibility(0);
            this.f60771d.e(eVar);
            return true;
        }
        this.f60771d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f60772e.setOnSrollToBottomListener(pVar);
        this.f60773f.a(gVar);
    }

    public void h() {
        this.f60771d.setVisibility(8);
        this.f60772e.setVisibility(8);
        this.f60769b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60769b, R.color.CAM_X0201);
        String string = this.f60768a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60768a.setNetRefreshViewTopMargin(this.f60775h);
        this.f60768a.showNetRefreshView(this.f60769b, string, false);
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
        this.f60772e.A(0L);
    }
}
