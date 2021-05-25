package d.a.n0.k3.e;

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
import com.baidu.tieba.themeCenter.background.BackgroundListActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f57014a;

    /* renamed from: b  reason: collision with root package name */
    public View f57015b;

    /* renamed from: c  reason: collision with root package name */
    public View f57016c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57017d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f57018e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f57019f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.g f57020g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57021h;

    /* renamed from: i  reason: collision with root package name */
    public e f57022i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f57020g = null;
        this.j = 0;
        this.f57014a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f57014a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f57015b = inflate;
        this.f57014a.setContentView(inflate);
        this.f57016c = this.f57015b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f57015b.findViewById(R.id.view_navigation_bar);
        this.f57017d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57017d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57015b.findViewById(R.id.view_member_recommend);
        this.f57018e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f57019f = (BdListView) this.f57015b.findViewById(R.id.listview_bg_list);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f57014a.getPageContext());
        this.f57020g = gVar;
        this.f57019f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f57014a.getActivity());
        this.f57021h = textView;
        textView.setHeight(l.g(this.f57014a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f57014a.getPageContext(), dVar);
        this.f57022i = eVar;
        this.f57019f.setAdapter((ListAdapter) eVar);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2 = i2 + 2 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < 3; i3++) {
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
        SkinManager.setBackgroundColor(this.f57015b, R.color.CAM_X0204);
        this.f57014a.hideNetRefreshView(this.f57015b);
        this.f57016c.setVisibility(0);
    }

    public View c() {
        return this.f57015b;
    }

    public void d() {
        e eVar;
        d.a.m0.s0.a.a(this.f57014a.getPageContext(), this.f57015b);
        NavigationBar navigationBar = this.f57017d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57014a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f57019f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f57022i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.a.m0.r.f0.g gVar = this.f57020g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f57018e.d();
        SkinManager.setBackgroundColor(this.f57021h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f57019f.setVisibility(0);
            this.f57022i.b(list);
            this.f57022i.notifyDataSetChanged();
            return;
        }
        this.f57019f.setVisibility(8);
    }

    public final boolean f(d.a.n0.k3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57018e.setVisibility(0);
            this.f57018e.e(eVar);
            return true;
        }
        this.f57018e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f57019f.setOnSrollToBottomListener(pVar);
        this.f57020g.a(gVar);
    }

    public void h() {
        this.f57016c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f57015b, R.color.CAM_X0201);
        String string = this.f57014a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57014a.setNetRefreshViewTopMargin(this.j);
        this.f57014a.showNetRefreshView(this.f57015b, string, false);
    }

    public void i(d.a.n0.k3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f57019f.removeHeaderView(this.f57021h);
                this.f57019f.addHeaderView(this.f57021h);
            } else {
                this.f57019f.removeHeaderView(this.f57021h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f57019f.A(0L);
    }
}
