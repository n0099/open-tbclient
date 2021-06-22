package d.a.o0.k3.g.a;

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
import d.a.o0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f60913a = 3;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f60914b;

    /* renamed from: c  reason: collision with root package name */
    public View f60915c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60916d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f60917e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f60918f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f60919g;

    /* renamed from: h  reason: collision with root package name */
    public b f60920h;

    /* renamed from: i  reason: collision with root package name */
    public View f60921i;
    public TextView j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.k = 0;
        this.f60914b = personalCardCategoryActivity;
        this.k = l.g(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60914b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f60915c = inflate;
        this.f60914b.setContentView(inflate);
        this.f60921i = this.f60915c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60915c.findViewById(R.id.view_navigation_bar);
        this.f60916d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60916d.setTitleText(R.string.personal_card);
        this.f60917e = (NoNetworkView) this.f60915c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60915c.findViewById(R.id.categary_card_recommend);
        this.f60918f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f60914b.getActivity());
        this.j = textView;
        textView.setHeight(l.g(this.f60914b.getActivity(), R.dimen.ds104));
        this.f60919g = (BdListView) this.f60915c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f60914b.getPageContext());
        this.f60920h = bVar;
        this.f60919g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        int size;
        int i2;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<d.a.o0.k3.a> a2 = aVar.a();
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
                        i2 = this.f60913a;
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
        this.f60914b.hideNetRefreshView(this.f60915c);
        this.f60921i.setVisibility(0);
    }

    public View c() {
        return this.f60915c;
    }

    public void d() {
        b bVar;
        this.f60914b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f60914b.getLayoutMode().j(this.f60915c);
        NavigationBar navigationBar = this.f60916d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60914b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f60917e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f60914b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f60919g;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f60920h) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f60918f;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f60918f.d();
        }
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    public final void e(List<a> list) {
        if (list != null && list.size() > 0) {
            this.f60919g.setVisibility(0);
            this.f60920h.b(a(list));
            this.f60920h.notifyDataSetChanged();
            return;
        }
        this.f60919g.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60918f.setVisibility(0);
            this.f60918f.e(eVar);
            return true;
        }
        this.f60918f.setVisibility(8);
        return false;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2 = this.f60920h;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void h(BdListView.p pVar) {
        this.f60919g.setOnSrollToBottomListener(pVar);
    }

    public void i() {
        this.f60921i.setVisibility(8);
        String string = this.f60914b.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60914b.setNetRefreshViewTopMargin(this.k);
        this.f60914b.showNetRefreshView(this.f60915c, string, false);
    }

    public void j(int i2, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
            i();
        } else if (i2 != 0) {
        } else {
            b();
            if (f(eVar)) {
                this.f60919g.removeHeaderView(this.j);
                this.f60919g.addHeaderView(this.j);
            } else {
                this.f60919g.removeHeaderView(this.j);
            }
            e(list);
        }
    }
}
