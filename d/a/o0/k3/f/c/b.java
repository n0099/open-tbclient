package d.a.o0.k3.f.c;

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
import d.a.n0.r.f0.f;
import d.a.n0.r.f0.g;
import d.a.o0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f60893a;

    /* renamed from: b  reason: collision with root package name */
    public View f60894b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60895c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f60896d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60897e;

    /* renamed from: f  reason: collision with root package name */
    public g f60898f;

    /* renamed from: g  reason: collision with root package name */
    public a f60899g;

    /* renamed from: h  reason: collision with root package name */
    public int f60900h;

    public b(BubbleListActivity bubbleListActivity, d.a.o0.k3.f.a.a aVar) {
        this.f60898f = null;
        this.f60900h = 0;
        this.f60893a = bubbleListActivity;
        this.f60900h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60893a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f60894b = inflate;
        this.f60893a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f60894b.findViewById(R.id.view_navigation_bar);
        this.f60895c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60895c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60894b.findViewById(R.id.view_member_recommend);
        this.f60896d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f60897e = (BdListView) this.f60894b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f60893a.getPageContext());
        this.f60898f = gVar;
        this.f60897e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f60893a.getActivity());
        textView.setHeight(l.g(this.f60893a.getActivity(), R.dimen.ds20));
        this.f60897e.addFooterView(textView);
        a aVar2 = new a(this.f60893a.getPageContext(), aVar);
        this.f60899g = aVar2;
        this.f60897e.setAdapter((ListAdapter) aVar2);
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
        SkinManager.setBackgroundColor(this.f60894b, R.color.CAM_X0204);
        this.f60893a.hideNetRefreshView(this.f60894b);
        this.f60896d.setVisibility(0);
        this.f60897e.setVisibility(0);
        this.f60894b.setVisibility(0);
    }

    public View c() {
        return this.f60894b;
    }

    public void d() {
        a aVar;
        d.a.n0.s0.a.a(this.f60893a.getPageContext(), this.f60894b);
        NavigationBar navigationBar = this.f60895c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60893a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f60897e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f60899g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f60898f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f60896d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f60897e.setVisibility(0);
            this.f60899g.b(list);
            this.f60899g.notifyDataSetChanged();
            return;
        }
        this.f60897e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60896d.setVisibility(0);
            this.f60896d.e(eVar);
            return true;
        }
        this.f60896d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f60897e.setOnSrollToBottomListener(pVar);
        this.f60898f.a(gVar);
    }

    public void h() {
        this.f60896d.setVisibility(8);
        this.f60897e.setVisibility(8);
        this.f60894b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60894b, R.color.CAM_X0201);
        String string = this.f60893a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60893a.setNetRefreshViewTopMargin(this.f60900h);
        this.f60893a.showNetRefreshView(this.f60894b, string, false);
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
        this.f60897e.A(0L);
    }
}
