package d.b.j0.j3.f.c;

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
import d.b.i0.r.f0.f;
import d.b.i0.r.f0.g;
import d.b.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f58202a;

    /* renamed from: b  reason: collision with root package name */
    public View f58203b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f58204c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f58205d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f58206e;

    /* renamed from: f  reason: collision with root package name */
    public g f58207f;

    /* renamed from: g  reason: collision with root package name */
    public a f58208g;

    /* renamed from: h  reason: collision with root package name */
    public int f58209h;

    public b(BubbleListActivity bubbleListActivity, d.b.j0.j3.f.a.a aVar) {
        this.f58207f = null;
        this.f58209h = 0;
        this.f58202a = bubbleListActivity;
        this.f58209h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f58202a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f58203b = inflate;
        this.f58202a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f58203b.findViewById(R.id.view_navigation_bar);
        this.f58204c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58204c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f58203b.findViewById(R.id.view_member_recommend);
        this.f58205d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f58206e = (BdListView) this.f58203b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f58202a.getPageContext());
        this.f58207f = gVar;
        this.f58206e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f58202a.getActivity());
        textView.setHeight(l.g(this.f58202a.getActivity(), R.dimen.ds20));
        this.f58206e.addFooterView(textView);
        a aVar2 = new a(this.f58202a.getPageContext(), aVar);
        this.f58208g = aVar2;
        this.f58206e.setAdapter((ListAdapter) aVar2);
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
        SkinManager.setBackgroundColor(this.f58203b, R.color.CAM_X0204);
        this.f58202a.hideNetRefreshView(this.f58203b);
        this.f58205d.setVisibility(0);
        this.f58206e.setVisibility(0);
        this.f58203b.setVisibility(0);
    }

    public View c() {
        return this.f58203b;
    }

    public void d() {
        a aVar;
        d.b.i0.s0.a.a(this.f58202a.getPageContext(), this.f58203b);
        NavigationBar navigationBar = this.f58204c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58202a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f58206e;
        if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f58208g) != null) {
            aVar.notifyDataSetChanged();
        }
        g gVar = this.f58207f;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f58205d.d();
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f58206e.setVisibility(0);
            this.f58208g.b(list);
            this.f58208g.notifyDataSetChanged();
            return;
        }
        this.f58206e.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f58205d.setVisibility(0);
            this.f58205d.e(eVar);
            return true;
        }
        this.f58205d.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f58206e.setOnSrollToBottomListener(pVar);
        this.f58207f.b(gVar);
    }

    public void h() {
        this.f58205d.setVisibility(8);
        this.f58206e.setVisibility(8);
        this.f58203b.setVisibility(8);
        SkinManager.setBackgroundColor(this.f58203b, R.color.CAM_X0201);
        String string = this.f58202a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f58202a.setNetRefreshViewTopMargin(this.f58209h);
        this.f58202a.showNetRefreshView(this.f58203b, string, false);
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
        this.f58206e.A(0L);
    }
}
