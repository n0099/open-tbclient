package d.b.j0.j3.e;

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
import d.b.c.e.p.l;
import d.b.i0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f58141a;

    /* renamed from: b  reason: collision with root package name */
    public View f58142b;

    /* renamed from: c  reason: collision with root package name */
    public View f58143c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58144d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f58145e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f58146f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.r.f0.g f58147g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58148h;
    public e i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f58147g = null;
        this.j = 0;
        this.f58141a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f58141a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f58142b = inflate;
        this.f58141a.setContentView(inflate);
        this.f58143c = this.f58142b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f58142b.findViewById(R.id.view_navigation_bar);
        this.f58144d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58144d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f58142b.findViewById(R.id.view_member_recommend);
        this.f58145e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f58146f = (BdListView) this.f58142b.findViewById(R.id.listview_bg_list);
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(this.f58141a.getPageContext());
        this.f58147g = gVar;
        this.f58146f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f58141a.getActivity());
        this.f58148h = textView;
        textView.setHeight(l.g(this.f58141a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f58141a.getPageContext(), dVar);
        this.i = eVar;
        this.f58146f.setAdapter((ListAdapter) eVar);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i = i + 2 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 3; i2++) {
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
        SkinManager.setBackgroundColor(this.f58142b, R.color.CAM_X0204);
        this.f58141a.hideNetRefreshView(this.f58142b);
        this.f58143c.setVisibility(0);
    }

    public View c() {
        return this.f58142b;
    }

    public void d() {
        e eVar;
        d.b.i0.s0.a.a(this.f58141a.getPageContext(), this.f58142b);
        NavigationBar navigationBar = this.f58144d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58141a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f58146f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.b.i0.r.f0.g gVar = this.f58147g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f58145e.d();
        SkinManager.setBackgroundColor(this.f58148h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f58146f.setVisibility(0);
            this.i.b(list);
            this.i.notifyDataSetChanged();
            return;
        }
        this.f58146f.setVisibility(8);
    }

    public final boolean f(d.b.j0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f58145e.setVisibility(0);
            this.f58145e.e(eVar);
            return true;
        }
        this.f58145e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f58146f.setOnSrollToBottomListener(pVar);
        this.f58147g.b(gVar);
    }

    public void h() {
        this.f58143c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f58142b, R.color.CAM_X0201);
        String string = this.f58141a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f58141a.setNetRefreshViewTopMargin(this.j);
        this.f58141a.showNetRefreshView(this.f58142b, string, false);
    }

    public void i(d.b.j0.j3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f58146f.removeHeaderView(this.f58148h);
                this.f58146f.addHeaderView(this.f58148h);
            } else {
                this.f58146f.removeHeaderView(this.f58148h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f58146f.A(0L);
    }
}
