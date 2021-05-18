package d.a.k0.j3.e;

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
import d.a.j0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f56834a;

    /* renamed from: b  reason: collision with root package name */
    public View f56835b;

    /* renamed from: c  reason: collision with root package name */
    public View f56836c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56837d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f56838e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f56839f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.r.f0.g f56840g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56841h;

    /* renamed from: i  reason: collision with root package name */
    public e f56842i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f56840g = null;
        this.j = 0;
        this.f56834a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56834a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f56835b = inflate;
        this.f56834a.setContentView(inflate);
        this.f56836c = this.f56835b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56835b.findViewById(R.id.view_navigation_bar);
        this.f56837d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56837d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56835b.findViewById(R.id.view_member_recommend);
        this.f56838e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f56839f = (BdListView) this.f56835b.findViewById(R.id.listview_bg_list);
        d.a.j0.r.f0.g gVar = new d.a.j0.r.f0.g(this.f56834a.getPageContext());
        this.f56840g = gVar;
        this.f56839f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f56834a.getActivity());
        this.f56841h = textView;
        textView.setHeight(l.g(this.f56834a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f56834a.getPageContext(), dVar);
        this.f56842i = eVar;
        this.f56839f.setAdapter((ListAdapter) eVar);
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
        SkinManager.setBackgroundColor(this.f56835b, R.color.CAM_X0204);
        this.f56834a.hideNetRefreshView(this.f56835b);
        this.f56836c.setVisibility(0);
    }

    public View c() {
        return this.f56835b;
    }

    public void d() {
        e eVar;
        d.a.j0.s0.a.a(this.f56834a.getPageContext(), this.f56835b);
        NavigationBar navigationBar = this.f56837d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56834a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56839f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f56842i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.a.j0.r.f0.g gVar = this.f56840g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f56838e.d();
        SkinManager.setBackgroundColor(this.f56841h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f56839f.setVisibility(0);
            this.f56842i.b(list);
            this.f56842i.notifyDataSetChanged();
            return;
        }
        this.f56839f.setVisibility(8);
    }

    public final boolean f(d.a.k0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56838e.setVisibility(0);
            this.f56838e.e(eVar);
            return true;
        }
        this.f56838e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f56839f.setOnSrollToBottomListener(pVar);
        this.f56840g.a(gVar);
    }

    public void h() {
        this.f56836c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f56835b, R.color.CAM_X0201);
        String string = this.f56834a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56834a.setNetRefreshViewTopMargin(this.j);
        this.f56834a.showNetRefreshView(this.f56835b, string, false);
    }

    public void i(d.a.k0.j3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f56839f.removeHeaderView(this.f56841h);
                this.f56839f.addHeaderView(this.f56841h);
            } else {
                this.f56839f.removeHeaderView(this.f56841h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f56839f.A(0L);
    }
}
