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
    public BubbleListActivity f56333a;

    /* renamed from: b  reason: collision with root package name */
    public View f56334b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56335c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f56336d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56337e;

    /* renamed from: f  reason: collision with root package name */
    public g f56338f;

    /* renamed from: g  reason: collision with root package name */
    public a f56339g;

    /* renamed from: h  reason: collision with root package name */
    public int f56340h;

    public b(BubbleListActivity bubbleListActivity, d.b.i0.i3.f.a.a aVar) {
        this.f56338f = null;
        this.f56340h = 0;
        this.f56333a = bubbleListActivity;
        this.f56340h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56333a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f56334b = inflate;
        this.f56333a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f56334b.findViewById(R.id.view_navigation_bar);
        this.f56335c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56335c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56334b.findViewById(R.id.view_member_recommend);
        this.f56336d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f56337e = (BdListView) this.f56334b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f56333a.getPageContext());
        this.f56338f = gVar;
        this.f56337e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f56333a.getActivity());
        textView.setHeight(l.g(this.f56333a.getActivity(), R.dimen.ds20));
        this.f56337e.addFooterView(textView);
        a aVar2 = new a(this.f56333a.getPageContext(), aVar);
        this.f56339g = aVar2;
        this.f56337e.setAdapter((ListAdapter) aVar2);
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
        SkinManager.setBackgroundColor(this.f56334b, R.color.CAM_X0204);
        this.f56333a.hideNetRefreshView(this.f56334b);
        this.f56336d.setVisibility(0);
        this.f56337e.setVisibility(0);
        this.f56334b.setVisibility(0);
    }

    public View c() {
        return this.f56334b;
    }

    public void d() {
        a aVar;
        d.b.h0.s0.a.a(this.f56333a.getPageContext(), this.f56334b);
        NavigationBar navigationBar = this.f56335c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56333a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56337e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f56339g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f56338f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f56336d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f56337e.setVisibility(0);
            this.f56339g.b(list);
            this.f56339g.notifyDataSetChanged();
            return;
        }
        this.f56337e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56336d.setVisibility(0);
            this.f56336d.e(eVar);
            return true;
        }
        this.f56336d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f56337e.setOnSrollToBottomListener(pVar);
        this.f56338f.b(gVar);
    }

    public void h() {
        this.f56336d.setVisibility(8);
        this.f56337e.setVisibility(8);
        this.f56334b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56334b, R.color.CAM_X0201);
        String string = this.f56333a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56333a.setNetRefreshViewTopMargin(this.f56340h);
        this.f56333a.showNetRefreshView(this.f56334b, string, false);
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
        this.f56337e.A(0L);
    }
}
