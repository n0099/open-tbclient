package d.a.j0.j3.e;

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
import d.a.i0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f56127a;

    /* renamed from: b  reason: collision with root package name */
    public View f56128b;

    /* renamed from: c  reason: collision with root package name */
    public View f56129c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56130d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f56131e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f56132f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.i0.r.f0.g f56133g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56134h;

    /* renamed from: i  reason: collision with root package name */
    public e f56135i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f56133g = null;
        this.j = 0;
        this.f56127a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56127a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f56128b = inflate;
        this.f56127a.setContentView(inflate);
        this.f56129c = this.f56128b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56128b.findViewById(R.id.view_navigation_bar);
        this.f56130d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56130d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56128b.findViewById(R.id.view_member_recommend);
        this.f56131e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f56132f = (BdListView) this.f56128b.findViewById(R.id.listview_bg_list);
        d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(this.f56127a.getPageContext());
        this.f56133g = gVar;
        this.f56132f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f56127a.getActivity());
        this.f56134h = textView;
        textView.setHeight(l.g(this.f56127a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f56127a.getPageContext(), dVar);
        this.f56135i = eVar;
        this.f56132f.setAdapter((ListAdapter) eVar);
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
        SkinManager.setBackgroundColor(this.f56128b, R.color.CAM_X0204);
        this.f56127a.hideNetRefreshView(this.f56128b);
        this.f56129c.setVisibility(0);
    }

    public View c() {
        return this.f56128b;
    }

    public void d() {
        e eVar;
        d.a.i0.s0.a.a(this.f56127a.getPageContext(), this.f56128b);
        NavigationBar navigationBar = this.f56130d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56127a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56132f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f56135i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.a.i0.r.f0.g gVar = this.f56133g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f56131e.d();
        SkinManager.setBackgroundColor(this.f56134h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f56132f.setVisibility(0);
            this.f56135i.b(list);
            this.f56135i.notifyDataSetChanged();
            return;
        }
        this.f56132f.setVisibility(8);
    }

    public final boolean f(d.a.j0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56131e.setVisibility(0);
            this.f56131e.e(eVar);
            return true;
        }
        this.f56131e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f56132f.setOnSrollToBottomListener(pVar);
        this.f56133g.a(gVar);
    }

    public void h() {
        this.f56129c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56128b, R.color.CAM_X0201);
        String string = this.f56127a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56127a.setNetRefreshViewTopMargin(this.j);
        this.f56127a.showNetRefreshView(this.f56128b, string, false);
    }

    public void i(d.a.j0.j3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f56132f.removeHeaderView(this.f56134h);
                this.f56132f.addHeaderView(this.f56134h);
            } else {
                this.f56132f.removeHeaderView(this.f56134h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f56132f.A(0L);
    }
}
