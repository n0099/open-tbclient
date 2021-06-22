package d.a.o0.k3.e;

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
import d.a.n0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f60828a;

    /* renamed from: b  reason: collision with root package name */
    public View f60829b;

    /* renamed from: c  reason: collision with root package name */
    public View f60830c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60831d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f60832e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f60833f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r.f0.g f60834g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60835h;

    /* renamed from: i  reason: collision with root package name */
    public e f60836i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f60834g = null;
        this.j = 0;
        this.f60828a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60828a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f60829b = inflate;
        this.f60828a.setContentView(inflate);
        this.f60830c = this.f60829b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60829b.findViewById(R.id.view_navigation_bar);
        this.f60831d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60831d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60829b.findViewById(R.id.view_member_recommend);
        this.f60832e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f60833f = (BdListView) this.f60829b.findViewById(R.id.listview_bg_list);
        d.a.n0.r.f0.g gVar = new d.a.n0.r.f0.g(this.f60828a.getPageContext());
        this.f60834g = gVar;
        this.f60833f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f60828a.getActivity());
        this.f60835h = textView;
        textView.setHeight(l.g(this.f60828a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f60828a.getPageContext(), dVar);
        this.f60836i = eVar;
        this.f60833f.setAdapter((ListAdapter) eVar);
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
        SkinManager.setBackgroundColor(this.f60829b, R.color.CAM_X0204);
        this.f60828a.hideNetRefreshView(this.f60829b);
        this.f60830c.setVisibility(0);
    }

    public View c() {
        return this.f60829b;
    }

    public void d() {
        e eVar;
        d.a.n0.s0.a.a(this.f60828a.getPageContext(), this.f60829b);
        NavigationBar navigationBar = this.f60831d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60828a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f60833f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f60836i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.a.n0.r.f0.g gVar = this.f60834g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f60832e.d();
        SkinManager.setBackgroundColor(this.f60835h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f60833f.setVisibility(0);
            this.f60836i.b(list);
            this.f60836i.notifyDataSetChanged();
            return;
        }
        this.f60833f.setVisibility(8);
    }

    public final boolean f(d.a.o0.k3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60832e.setVisibility(0);
            this.f60832e.e(eVar);
            return true;
        }
        this.f60832e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f60833f.setOnSrollToBottomListener(pVar);
        this.f60834g.a(gVar);
    }

    public void h() {
        this.f60830c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60829b, R.color.CAM_X0201);
        String string = this.f60828a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60828a.setNetRefreshViewTopMargin(this.j);
        this.f60828a.showNetRefreshView(this.f60829b, string, false);
    }

    public void i(d.a.o0.k3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f60833f.removeHeaderView(this.f60835h);
                this.f60833f.addHeaderView(this.f60835h);
            } else {
                this.f60833f.removeHeaderView(this.f60835h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f60833f.A(0L);
    }
}
