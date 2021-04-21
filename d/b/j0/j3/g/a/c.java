package d.b.j0.j3.g.a;

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
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import d.b.c.e.p.l;
import d.b.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f58221a = 3;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f58222b;

    /* renamed from: c  reason: collision with root package name */
    public View f58223c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58224d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f58225e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f58226f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f58227g;

    /* renamed from: h  reason: collision with root package name */
    public b f58228h;
    public View i;
    public TextView j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.k = 0;
        this.f58222b = personalCardCategoryActivity;
        this.k = l.g(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f58222b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f58223c = inflate;
        this.f58222b.setContentView(inflate);
        this.i = this.f58223c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f58223c.findViewById(R.id.view_navigation_bar);
        this.f58224d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58224d.setTitleText(R.string.personal_card);
        this.f58225e = (NoNetworkView) this.f58223c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f58223c.findViewById(R.id.categary_card_recommend);
        this.f58226f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f58222b.getActivity());
        this.j = textView;
        textView.setHeight(l.g(this.f58222b.getActivity(), R.dimen.ds104));
        this.f58227g = (BdListView) this.f58223c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f58222b.getPageContext());
        this.f58228h = bVar;
        this.f58227g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        int size;
        int i;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<d.b.j0.j3.a> a2 = aVar.a();
            if (a2 != null && (size = a2.size()) != 0) {
                arrayList.add(aVar.b());
                if (size > 6) {
                    size = 6;
                }
                int i2 = 0;
                while (i2 < size) {
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = 0;
                    while (true) {
                        i = this.f58221a;
                        if (i3 < i) {
                            int i4 = i2 + i3;
                            if (i4 < size) {
                                arrayList2.add(a2.get(i4));
                            }
                            i3++;
                        }
                    }
                    arrayList.add(arrayList2);
                    i2 = i2 + (i - 1) + 1;
                }
            }
        }
        return arrayList;
    }

    public void b() {
        this.f58222b.hideNetRefreshView(this.f58223c);
        this.i.setVisibility(0);
    }

    public View c() {
        return this.f58223c;
    }

    public void d() {
        b bVar;
        this.f58222b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f58222b.getLayoutMode().j(this.f58223c);
        NavigationBar navigationBar = this.f58224d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58222b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f58225e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58222b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f58227g;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f58228h) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f58226f;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f58226f.d();
        }
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    public final void e(List<a> list) {
        if (list != null && list.size() > 0) {
            this.f58227g.setVisibility(0);
            this.f58228h.b(a(list));
            this.f58228h.notifyDataSetChanged();
            return;
        }
        this.f58227g.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f58226f.setVisibility(0);
            this.f58226f.e(eVar);
            return true;
        }
        this.f58226f.setVisibility(8);
        return false;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2 = this.f58228h;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void h(BdListView.p pVar) {
        this.f58227g.setOnSrollToBottomListener(pVar);
    }

    public void i() {
        this.i.setVisibility(8);
        String string = this.f58222b.getPageContext().getResources().getString(R.string.no_data_text);
        this.f58222b.setNetRefreshViewTopMargin(this.k);
        this.f58222b.showNetRefreshView(this.f58223c, string, false);
    }

    public void j(int i, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
            i();
        } else if (i != 0) {
        } else {
            b();
            if (f(eVar)) {
                this.f58227g.removeHeaderView(this.j);
                this.f58227g.addHeaderView(this.j);
            } else {
                this.f58227g.removeHeaderView(this.j);
            }
            e(list);
        }
    }
}
