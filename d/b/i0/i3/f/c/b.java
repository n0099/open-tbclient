package d.b.i0.i3.f.c;

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
import d.b.b.e.p.l;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.i3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f56334a;

    /* renamed from: b  reason: collision with root package name */
    public View f56335b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56336c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f56337d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56338e;

    /* renamed from: f  reason: collision with root package name */
    public g f56339f;

    /* renamed from: g  reason: collision with root package name */
    public a f56340g;

    /* renamed from: h  reason: collision with root package name */
    public int f56341h;

    public b(BubbleListActivity bubbleListActivity, d.b.i0.i3.f.a.a aVar) {
        this.f56339f = null;
        this.f56341h = 0;
        this.f56334a = bubbleListActivity;
        this.f56341h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56334a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f56335b = inflate;
        this.f56334a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f56335b.findViewById(R.id.view_navigation_bar);
        this.f56336c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56336c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56335b.findViewById(R.id.view_member_recommend);
        this.f56337d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f56338e = (BdListView) this.f56335b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f56334a.getPageContext());
        this.f56339f = gVar;
        this.f56338e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f56334a.getActivity());
        textView.setHeight(l.g(this.f56334a.getActivity(), R.dimen.ds20));
        this.f56338e.addFooterView(textView);
        a aVar2 = new a(this.f56334a.getPageContext(), aVar);
        this.f56340g = aVar2;
        this.f56338e.setAdapter((ListAdapter) aVar2);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i = i + 1 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                int i3 = i + i2;
                if (i3 < size) {
                    arrayList2.add(list.get(i3));
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public void b() {
        SkinManager.setBackgroundColor(this.f56335b, R.color.CAM_X0204);
        this.f56334a.hideNetRefreshView(this.f56335b);
        this.f56337d.setVisibility(0);
        this.f56338e.setVisibility(0);
        this.f56335b.setVisibility(0);
    }

    public View c() {
        return this.f56335b;
    }

    public void d() {
        a aVar;
        d.b.h0.s0.a.a(this.f56334a.getPageContext(), this.f56335b);
        NavigationBar navigationBar = this.f56336c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56334a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56338e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f56340g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f56339f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f56337d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f56338e.setVisibility(0);
            this.f56340g.b(list);
            this.f56340g.notifyDataSetChanged();
            return;
        }
        this.f56338e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56337d.setVisibility(0);
            this.f56337d.e(eVar);
            return true;
        }
        this.f56337d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f56338e.setOnSrollToBottomListener(pVar);
        this.f56339f.b(gVar);
    }

    public void h() {
        this.f56337d.setVisibility(8);
        this.f56338e.setVisibility(8);
        this.f56335b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56335b, R.color.CAM_X0201);
        String string = this.f56334a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56334a.setNetRefreshViewTopMargin(this.f56341h);
        this.f56334a.showNetRefreshView(this.f56335b, string, false);
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
        this.f56338e.A(0L);
    }
}
