package d.a.k0.j3.g.a;

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
import d.a.k0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f56919a = 3;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f56920b;

    /* renamed from: c  reason: collision with root package name */
    public View f56921c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56922d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f56923e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f56924f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f56925g;

    /* renamed from: h  reason: collision with root package name */
    public b f56926h;

    /* renamed from: i  reason: collision with root package name */
    public View f56927i;
    public TextView j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.k = 0;
        this.f56920b = personalCardCategoryActivity;
        this.k = l.g(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56920b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f56921c = inflate;
        this.f56920b.setContentView(inflate);
        this.f56927i = this.f56921c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56921c.findViewById(R.id.view_navigation_bar);
        this.f56922d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56922d.setTitleText(R.string.personal_card);
        this.f56923e = (NoNetworkView) this.f56921c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56921c.findViewById(R.id.categary_card_recommend);
        this.f56924f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f56920b.getActivity());
        this.j = textView;
        textView.setHeight(l.g(this.f56920b.getActivity(), R.dimen.ds104));
        this.f56925g = (BdListView) this.f56921c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f56920b.getPageContext());
        this.f56926h = bVar;
        this.f56925g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        int size;
        int i2;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<d.a.k0.j3.a> a2 = aVar.a();
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
                        i2 = this.f56919a;
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
        this.f56920b.hideNetRefreshView(this.f56921c);
        this.f56927i.setVisibility(0);
    }

    public View c() {
        return this.f56921c;
    }

    public void d() {
        b bVar;
        this.f56920b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f56920b.getLayoutMode().j(this.f56921c);
        NavigationBar navigationBar = this.f56922d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56920b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f56923e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56920b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56925g;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f56926h) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f56924f;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f56924f.d();
        }
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    public final void e(List<a> list) {
        if (list != null && list.size() > 0) {
            this.f56925g.setVisibility(0);
            this.f56926h.b(a(list));
            this.f56926h.notifyDataSetChanged();
            return;
        }
        this.f56925g.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56924f.setVisibility(0);
            this.f56924f.e(eVar);
            return true;
        }
        this.f56924f.setVisibility(8);
        return false;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2 = this.f56926h;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void h(BdListView.p pVar) {
        this.f56925g.setOnSrollToBottomListener(pVar);
    }

    public void i() {
        this.f56927i.setVisibility(8);
        String string = this.f56920b.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56920b.setNetRefreshViewTopMargin(this.k);
        this.f56920b.showNetRefreshView(this.f56921c, string, false);
    }

    public void j(int i2, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
            i();
        } else if (i2 != 0) {
        } else {
            b();
            if (f(eVar)) {
                this.f56925g.removeHeaderView(this.j);
                this.f56925g.addHeaderView(this.j);
            } else {
                this.f56925g.removeHeaderView(this.j);
            }
            e(list);
        }
    }
}
