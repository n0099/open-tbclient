package d.a.j0.j3.g.a;

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
import d.a.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f56212a = 3;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f56213b;

    /* renamed from: c  reason: collision with root package name */
    public View f56214c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f56215d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f56216e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f56217f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f56218g;

    /* renamed from: h  reason: collision with root package name */
    public b f56219h;

    /* renamed from: i  reason: collision with root package name */
    public View f56220i;
    public TextView j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        this.k = 0;
        this.f56213b = personalCardCategoryActivity;
        this.k = l.g(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f56213b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f56214c = inflate;
        this.f56213b.setContentView(inflate);
        this.f56220i = this.f56214c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f56214c.findViewById(R.id.view_navigation_bar);
        this.f56215d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56215d.setTitleText(R.string.personal_card);
        this.f56216e = (NoNetworkView) this.f56214c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f56214c.findViewById(R.id.categary_card_recommend);
        this.f56217f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f56213b.getActivity());
        this.j = textView;
        textView.setHeight(l.g(this.f56213b.getActivity(), R.dimen.ds104));
        this.f56218g = (BdListView) this.f56214c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f56213b.getPageContext());
        this.f56219h = bVar;
        this.f56218g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        int size;
        int i2;
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            ArrayList<d.a.j0.j3.a> a2 = aVar.a();
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
                        i2 = this.f56212a;
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
        this.f56213b.hideNetRefreshView(this.f56214c);
        this.f56220i.setVisibility(0);
    }

    public View c() {
        return this.f56214c;
    }

    public void d() {
        b bVar;
        this.f56213b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f56213b.getLayoutMode().j(this.f56214c);
        NavigationBar navigationBar = this.f56215d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56213b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f56216e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56213b.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        BdListView bdListView = this.f56218g;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f56219h) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f56217f;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f56217f.d();
        }
        SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
    }

    public final void e(List<a> list) {
        if (list != null && list.size() > 0) {
            this.f56218g.setVisibility(0);
            this.f56219h.b(a(list));
            this.f56219h.notifyDataSetChanged();
            return;
        }
        this.f56218g.setVisibility(8);
    }

    public final boolean f(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f56217f.setVisibility(0);
            this.f56217f.e(eVar);
            return true;
        }
        this.f56217f.setVisibility(8);
        return false;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2 = this.f56219h;
        if (bVar2 != null) {
            bVar2.a(bVar);
        }
    }

    public void h(BdListView.p pVar) {
        this.f56218g.setOnSrollToBottomListener(pVar);
    }

    public void i() {
        this.f56220i.setVisibility(8);
        String string = this.f56213b.getPageContext().getResources().getString(R.string.no_data_text);
        this.f56213b.setNetRefreshViewTopMargin(this.k);
        this.f56213b.showNetRefreshView(this.f56214c, string, false);
    }

    public void j(int i2, e eVar, List<a> list, boolean z) {
        if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
            i();
        } else if (i2 != 0) {
        } else {
            b();
            if (f(eVar)) {
                this.f56218g.removeHeaderView(this.j);
                this.f56218g.addHeaderView(this.j);
            } else {
                this.f56218g.removeHeaderView(this.j);
            }
            e(list);
        }
    }
}
