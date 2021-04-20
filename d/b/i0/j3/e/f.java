package d.b.i0.j3.e;

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
import d.b.h0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f57720a;

    /* renamed from: b  reason: collision with root package name */
    public View f57721b;

    /* renamed from: c  reason: collision with root package name */
    public View f57722c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57723d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f57724e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f57725f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.h0.r.f0.g f57726g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57727h;
    public e i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        this.f57726g = null;
        this.j = 0;
        this.f57720a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f57720a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f57721b = inflate;
        this.f57720a.setContentView(inflate);
        this.f57722c = this.f57721b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f57721b.findViewById(R.id.view_navigation_bar);
        this.f57723d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57723d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57721b.findViewById(R.id.view_member_recommend);
        this.f57724e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f57725f = (BdListView) this.f57721b.findViewById(R.id.listview_bg_list);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f57720a.getPageContext());
        this.f57726g = gVar;
        this.f57725f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f57720a.getActivity());
        this.f57727h = textView;
        textView.setHeight(l.g(this.f57720a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f57720a.getPageContext(), dVar);
        this.i = eVar;
        this.f57725f.setAdapter((ListAdapter) eVar);
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
        SkinManager.setBackgroundColor(this.f57721b, R.color.CAM_X0204);
        this.f57720a.hideNetRefreshView(this.f57721b);
        this.f57722c.setVisibility(0);
    }

    public View c() {
        return this.f57721b;
    }

    public void d() {
        e eVar;
        d.b.h0.s0.a.a(this.f57720a.getPageContext(), this.f57721b);
        NavigationBar navigationBar = this.f57723d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57720a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f57725f;
        if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.i) != null) {
            eVar.notifyDataSetChanged();
        }
        d.b.h0.r.f0.g gVar = this.f57726g;
        if (gVar != null) {
            gVar.I(TbadkApplication.getInst().getSkinType());
        }
        this.f57724e.d();
        SkinManager.setBackgroundColor(this.f57727h, R.color.CAM_X0204);
    }

    public final void e(List<List<DressItemData>> list) {
        if (list != null && list.size() > 0) {
            this.f57725f.setVisibility(0);
            this.i.b(list);
            this.i.notifyDataSetChanged();
            return;
        }
        this.f57725f.setVisibility(8);
    }

    public final boolean f(d.b.i0.j3.h.e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57724e.setVisibility(0);
            this.f57724e.e(eVar);
            return true;
        }
        this.f57724e.setVisibility(8);
        return false;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        this.f57725f.setOnSrollToBottomListener(pVar);
        this.f57726g.b(gVar);
    }

    public void h() {
        this.f57722c.setVisibility(8);
        SkinManager.setBackgroundColor(this.f57721b, R.color.CAM_X0201);
        String string = this.f57720a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57720a.setNetRefreshViewTopMargin(this.j);
        this.f57720a.showNetRefreshView(this.f57721b, string, false);
    }

    public void i(d.b.i0.j3.h.e eVar, List<DressItemData> list, boolean z) {
        if (list != null && list.size() > 0) {
            b();
            if (f(eVar)) {
                this.f57725f.removeHeaderView(this.f57727h);
                this.f57725f.addHeaderView(this.f57727h);
            } else {
                this.f57725f.removeHeaderView(this.f57727h);
            }
            e(a(list));
            return;
        }
        h();
    }

    public void j() {
        this.f57725f.A(0L);
    }
}
