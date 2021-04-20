package d.b.i0.j3.f.c;

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
import d.b.c.e.p.l;
import d.b.h0.r.f0.f;
import d.b.h0.r.f0.g;
import d.b.i0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f57781a;

    /* renamed from: b  reason: collision with root package name */
    public View f57782b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f57783c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f57784d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f57785e;

    /* renamed from: f  reason: collision with root package name */
    public g f57786f;

    /* renamed from: g  reason: collision with root package name */
    public a f57787g;

    /* renamed from: h  reason: collision with root package name */
    public int f57788h;

    public b(BubbleListActivity bubbleListActivity, d.b.i0.j3.f.a.a aVar) {
        this.f57786f = null;
        this.f57788h = 0;
        this.f57781a = bubbleListActivity;
        this.f57788h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f57781a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f57782b = inflate;
        this.f57781a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f57782b.findViewById(R.id.view_navigation_bar);
        this.f57783c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57783c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57782b.findViewById(R.id.view_member_recommend);
        this.f57784d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f57785e = (BdListView) this.f57782b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f57781a.getPageContext());
        this.f57786f = gVar;
        this.f57785e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f57781a.getActivity());
        textView.setHeight(l.g(this.f57781a.getActivity(), R.dimen.ds20));
        this.f57785e.addFooterView(textView);
        a aVar2 = new a(this.f57781a.getPageContext(), aVar);
        this.f57787g = aVar2;
        this.f57785e.setAdapter((ListAdapter) aVar2);
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
        SkinManager.setBackgroundColor(this.f57782b, R.color.CAM_X0204);
        this.f57781a.hideNetRefreshView(this.f57782b);
        this.f57784d.setVisibility(0);
        this.f57785e.setVisibility(0);
        this.f57782b.setVisibility(0);
    }

    public View c() {
        return this.f57782b;
    }

    public void d() {
        a aVar;
        d.b.h0.s0.a.a(this.f57781a.getPageContext(), this.f57782b);
        NavigationBar navigationBar = this.f57783c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57781a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f57785e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f57787g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f57786f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f57784d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f57785e.setVisibility(0);
            this.f57787g.b(list);
            this.f57787g.notifyDataSetChanged();
            return;
        }
        this.f57785e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57784d.setVisibility(0);
            this.f57784d.e(eVar);
            return true;
        }
        this.f57784d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f57785e.setOnSrollToBottomListener(pVar);
        this.f57786f.b(gVar);
    }

    public void h() {
        this.f57784d.setVisibility(8);
        this.f57785e.setVisibility(8);
        this.f57782b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f57782b, R.color.CAM_X0201);
        String string = this.f57781a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57781a.setNetRefreshViewTopMargin(this.f57788h);
        this.f57781a.showNetRefreshView(this.f57782b, string, false);
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
        this.f57785e.A(0L);
    }
}
