package d.b.i0.i3.e;

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
import d.b.b.e.p.l;
import d.b.h0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f56272a;

    /* renamed from: b  reason: collision with root package name */
    public View f56273b;

    /* renamed from: c  reason: collision with root package name */
    public View f56274c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56275d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f56276e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f56277f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f56278g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56279h;
    public e i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f56278g = null;
        this.j = 0;
        this.f56272a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56272a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f56273b = inflate;
        this.f56272a.setContentView(inflate);
        this.f56274c = this.f56273b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56273b.findViewById(R.id.view_navigation_bar);
        this.f56275d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56275d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56273b.findViewById(R.id.view_member_recommend);
        this.f56276e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f56277f = (BdListView) this.f56273b.findViewById(R.id.listview_bg_list);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f56272a.getPageContext());
        this.f56278g = gVar;
        this.f56277f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f56272a.getActivity());
        this.f56279h = textView;
        textView.setHeight(l.g(this.f56272a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f56272a.getPageContext(), dVar);
        this.i = eVar;
        this.f56277f.setAdapter((ListAdapter) eVar);
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
        SkinManager.setBackgroundColor(this.f56273b, R.color.CAM_X0204);
        this.f56272a.hideNetRefreshView(this.f56273b);
        this.f56274c.setVisibility(0);
    }

    public View c() {
        return this.f56273b;
    }

    public void d() {
        e eVar;
        d.b.h0.s0.a.a(this.f56272a.getPageContext(), this.f56273b);
        NavigationBar navigationBar = this.f56275d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56272a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56277f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.b.h0.r.f0.g gVar = this.f56278g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f56276e.d();
        SkinManager.setBackgroundColor(this.f56279h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f56277f.setVisibility(0);
            this.i.b(list);
            this.i.notifyDataSetChanged();
            return;
        }
        this.f56277f.setVisibility(8);
    }

    public final boolean f(d.b.i0.i3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56276e.setVisibility(0);
            this.f56276e.e(eVar);
            return true;
        }
        this.f56276e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f56277f.setOnSrollToBottomListener(pVar);
        this.f56278g.b(gVar);
    }

    public void h() {
        this.f56274c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56273b, R.color.CAM_X0201);
        String string = this.f56272a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56272a.setNetRefreshViewTopMargin(this.j);
        this.f56272a.showNetRefreshView(this.f56273b, string, false);
    }

    public void i(d.b.i0.i3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f56277f.removeHeaderView(this.f56279h);
                this.f56277f.addHeaderView(this.f56279h);
            } else {
                this.f56277f.removeHeaderView(this.f56279h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f56277f.A(0L);
    }
}
