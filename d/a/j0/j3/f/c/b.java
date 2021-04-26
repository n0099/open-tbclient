package d.a.j0.j3.f.c;

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
import d.a.i0.r.f0.f;
import d.a.i0.r.f0.g;
import d.a.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f56192a;

    /* renamed from: b  reason: collision with root package name */
    public View f56193b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56194c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f56195d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56196e;

    /* renamed from: f  reason: collision with root package name */
    public g f56197f;

    /* renamed from: g  reason: collision with root package name */
    public a f56198g;

    /* renamed from: h  reason: collision with root package name */
    public int f56199h;

    public b(BubbleListActivity bubbleListActivity, d.a.j0.j3.f.a.a aVar) {
        this.f56197f = null;
        this.f56199h = 0;
        this.f56192a = bubbleListActivity;
        this.f56199h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56192a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f56193b = inflate;
        this.f56192a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f56193b.findViewById(R.id.view_navigation_bar);
        this.f56194c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56194c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56193b.findViewById(R.id.view_member_recommend);
        this.f56195d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f56196e = (BdListView) this.f56193b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f56192a.getPageContext());
        this.f56197f = gVar;
        this.f56196e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f56192a.getActivity());
        textView.setHeight(l.g(this.f56192a.getActivity(), R.dimen.ds20));
        this.f56196e.addFooterView(textView);
        a aVar2 = new a(this.f56192a.getPageContext(), aVar);
        this.f56198g = aVar2;
        this.f56196e.setAdapter((ListAdapter) aVar2);
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
        SkinManager.setBackgroundColor(this.f56193b, R.color.CAM_X0204);
        this.f56192a.hideNetRefreshView(this.f56193b);
        this.f56195d.setVisibility(0);
        this.f56196e.setVisibility(0);
        this.f56193b.setVisibility(0);
    }

    public View c() {
        return this.f56193b;
    }

    public void d() {
        a aVar;
        d.a.i0.s0.a.a(this.f56192a.getPageContext(), this.f56193b);
        NavigationBar navigationBar = this.f56194c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56192a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56196e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f56198g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f56197f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f56195d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f56196e.setVisibility(0);
            this.f56198g.b(list);
            this.f56198g.notifyDataSetChanged();
            return;
        }
        this.f56196e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56195d.setVisibility(0);
            this.f56195d.e(eVar);
            return true;
        }
        this.f56195d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f56196e.setOnSrollToBottomListener(pVar);
        this.f56197f.a(gVar);
    }

    public void h() {
        this.f56195d.setVisibility(8);
        this.f56196e.setVisibility(8);
        this.f56193b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56193b, R.color.CAM_X0201);
        String string = this.f56192a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56192a.setNetRefreshViewTopMargin(this.f56199h);
        this.f56192a.showNetRefreshView(this.f56193b, string, false);
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
        this.f56196e.A(0L);
    }
}
