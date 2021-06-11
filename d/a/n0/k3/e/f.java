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
    public BackgroundListActivity f60703a;

    /* renamed from: b  reason: collision with root package name */
    public View f60704b;

    /* renamed from: c  reason: collision with root package name */
    public View f60705c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60706d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f60707e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f60708f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.m0.r.f0.g f60709g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60710h;

    /* renamed from: i  reason: collision with root package name */
    public e f60711i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f60709g = null;
        this.j = 0;
        this.f60703a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60703a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f60704b = inflate;
        this.f60703a.setContentView(inflate);
        this.f60705c = this.f60704b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60704b.findViewById(R.id.view_navigation_bar);
        this.f60706d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60706d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60704b.findViewById(R.id.view_member_recommend);
        this.f60707e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f60708f = (BdListView) this.f60704b.findViewById(R.id.listview_bg_list);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f60703a.getPageContext());
        this.f60709g = gVar;
        this.f60708f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f60703a.getActivity());
        this.f60710h = textView;
        textView.setHeight(l.g(this.f60703a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f60703a.getPageContext(), dVar);
        this.f60711i = eVar;
        this.f60708f.setAdapter((ListAdapter) eVar);
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
        SkinManager.setBackgroundColor(this.f60704b, R.color.CAM_X0204);
        this.f60703a.hideNetRefreshView(this.f60704b);
        this.f60705c.setVisibility(0);
    }

    public View c() {
        return this.f60704b;
    }

    public void d() {
        e eVar;
        d.a.m0.s0.a.a(this.f60703a.getPageContext(), this.f60704b);
        NavigationBar navigationBar = this.f60706d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60703a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f60708f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f60711i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.a.m0.r.f0.g gVar = this.f60709g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f60707e.d();
        SkinManager.setBackgroundColor(this.f60710h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f60708f.setVisibility(0);
            this.f60711i.b(list);
            this.f60711i.notifyDataSetChanged();
            return;
        }
        this.f60708f.setVisibility(8);
    }

    public final boolean f(d.a.n0.k3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60707e.setVisibility(0);
            this.f60707e.e(eVar);
            return true;
        }
        this.f60707e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f60708f.setOnSrollToBottomListener(pVar);
        this.f60709g.a(gVar);
    }

    public void h() {
        this.f60705c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f60704b, R.color.CAM_X0201);
        String string = this.f60703a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60703a.setNetRefreshViewTopMargin(this.j);
        this.f60703a.showNetRefreshView(this.f60704b, string, false);
    }

    public void i(d.a.n0.k3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f60708f.removeHeaderView(this.f60710h);
                this.f60708f.addHeaderView(this.f60710h);
            } else {
                this.f60708f.removeHeaderView(this.f60710h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f60708f.A(0L);
    }
}
