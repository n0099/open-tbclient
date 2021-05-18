package d.a.k0.j3.f.c;

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
import d.a.j0.r.f0.f;
import d.a.j0.r.f0.g;
import d.a.k0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f56899a;

    /* renamed from: b  reason: collision with root package name */
    public View f56900b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56901c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f56902d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56903e;

    /* renamed from: f  reason: collision with root package name */
    public g f56904f;

    /* renamed from: g  reason: collision with root package name */
    public a f56905g;

    /* renamed from: h  reason: collision with root package name */
    public int f56906h;

    public b(BubbleListActivity bubbleListActivity, d.a.k0.j3.f.a.a aVar) {
        this.f56904f = null;
        this.f56906h = 0;
        this.f56899a = bubbleListActivity;
        this.f56906h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56899a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f56900b = inflate;
        this.f56899a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f56900b.findViewById(R.id.view_navigation_bar);
        this.f56901c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56901c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56900b.findViewById(R.id.view_member_recommend);
        this.f56902d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f56903e = (BdListView) this.f56900b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f56899a.getPageContext());
        this.f56904f = gVar;
        this.f56903e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f56899a.getActivity());
        textView.setHeight(l.g(this.f56899a.getActivity(), R.dimen.ds20));
        this.f56903e.addFooterView(textView);
        a aVar2 = new a(this.f56899a.getPageContext(), aVar);
        this.f56905g = aVar2;
        this.f56903e.setAdapter((ListAdapter) aVar2);
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
        SkinManager.setBackgroundColor(this.f56900b, R.color.CAM_X0204);
        this.f56899a.hideNetRefreshView(this.f56900b);
        this.f56902d.setVisibility(0);
        this.f56903e.setVisibility(0);
        this.f56900b.setVisibility(0);
    }

    public View c() {
        return this.f56900b;
    }

    public void d() {
        a aVar;
        d.a.j0.s0.a.a(this.f56899a.getPageContext(), this.f56900b);
        NavigationBar navigationBar = this.f56901c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56899a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56903e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f56905g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f56904f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f56902d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f56903e.setVisibility(0);
            this.f56905g.b(list);
            this.f56905g.notifyDataSetChanged();
            return;
        }
        this.f56903e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56902d.setVisibility(0);
            this.f56902d.e(eVar);
            return true;
        }
        this.f56902d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f56903e.setOnSrollToBottomListener(pVar);
        this.f56904f.a(gVar);
    }

    public void h() {
        this.f56902d.setVisibility(8);
        this.f56903e.setVisibility(8);
        this.f56900b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56900b, R.color.CAM_X0201);
        String string = this.f56899a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56899a.setNetRefreshViewTopMargin(this.f56906h);
        this.f56899a.showNetRefreshView(this.f56900b, string, false);
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
        this.f56903e.A(0L);
    }
}
