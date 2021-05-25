package d.a.n0.k3.g.a;

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
import d.a.c.e.p.l;
import d.a.n0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f57099a = 3;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f57100b;

    /* renamed from: c  reason: collision with root package name */
    public View f57101c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57102d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f57103e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f57104f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f57105g;

    /* renamed from: h  reason: collision with root package name */
    public b f57106h;

    /* renamed from: i  reason: collision with root package name */
    public View f57107i;
    public TextView j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.k = 0;
        this.f57100b = personalCardCategoryActivity;
        this.k = l.g(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f57100b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f57101c = inflate;
        this.f57100b.setContentView(inflate);
        this.f57107i = this.f57101c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f57101c.findViewById(R.id.view_navigation_bar);
        this.f57102d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57102d.setTitleText(R.string.personal_card);
        this.f57103e = (NoNetworkView) this.f57101c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57101c.findViewById(R.id.categary_card_recommend);
        this.f57104f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f57100b.getActivity());
        this.j = textView;
        textView.setHeight(l.g(this.f57100b.getActivity(), R.dimen.ds104));
        this.f57105g = (BdListView) this.f57101c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f57100b.getPageContext());
        this.f57106h = bVar;
        this.f57105g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        int size;
        int i2;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<d.a.n0.k3.a> a2 = aVar.a();
            if (a2 != null && (size = a2.size()) != 0) {
                arrayList.add(aVar.b());
                if (size > 6) {
                    size = 6;
                }
                int i3 = 0;
                while (i3 < size) {
                    ArrayList arrayList2 = new ArrayList();
                    int i4 = 0;
                    while (true) {
                        i2 = this.f57099a;
                        if (i4 < i2) {
                            int i5 = i3 + i4;
                            if (i5 < size) {
                                arrayList2.add(a2.get(i5));
                            }
                            i4++;
                        }
                    }
                    arrayList.add(arrayList2);
                    i3 = i3 + (i2 - 1) + 1;
                }
            }
        }
        return arrayList;
    }

    public void b() {
        this.f57100b.hideNetRefreshView(this.f57101c);
        this.f57107i.setVisibility(0);
    }

    public View c() {
        return this.f57101c;
    }

    public void d() {
        b bVar;
        this.f57100b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f57100b.getLayoutMode().j(this.f57101c);
        NavigationBar navigationBar = this.f57102d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57100b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f57103e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f57100b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f57105g;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f57106h) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f57104f;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f57104f.d();
        }
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    public final void e(List<a> list) {
        if (list != null && list.size() > 0) {
            this.f57105g.setVisibility(0);
            this.f57106h.b(a(list));
            this.f57106h.notifyDataSetChanged();
            return;
        }
        this.f57105g.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57104f.setVisibility(0);
            this.f57104f.e(eVar);
            return true;
        }
        this.f57104f.setVisibility(8);
        return false;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2 = this.f57106h;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void h(BdListView.p pVar) {
        this.f57105g.setOnSrollToBottomListener(pVar);
    }

    public void i() {
        this.f57107i.setVisibility(8);
        String string = this.f57100b.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57100b.setNetRefreshViewTopMargin(this.k);
        this.f57100b.showNetRefreshView(this.f57101c, string, false);
    }

    public void j(int i2, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
            i();
        } else if (i2 != 0) {
        } else {
            b();
            if (f(eVar)) {
                this.f57105g.removeHeaderView(this.j);
                this.f57105g.addHeaderView(this.j);
            } else {
                this.f57105g.removeHeaderView(this.j);
            }
            e(list);
        }
    }
}
