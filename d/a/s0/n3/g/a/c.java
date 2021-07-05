package d.a.s0.n3.g.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryActivity;
import com.baidu.tieba.themeCenter.card.category.PersonalCardItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.s0.n3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64244a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalCardCategoryActivity f64245b;

    /* renamed from: c  reason: collision with root package name */
    public View f64246c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f64247d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f64248e;

    /* renamed from: f  reason: collision with root package name */
    public MemberRecommendView f64249f;

    /* renamed from: g  reason: collision with root package name */
    public BdListView f64250g;

    /* renamed from: h  reason: collision with root package name */
    public b f64251h;

    /* renamed from: i  reason: collision with root package name */
    public View f64252i;
    public TextView j;
    public int k;

    public c(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64244a = 3;
        this.k = 0;
        this.f64245b = personalCardCategoryActivity;
        this.k = l.g(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f64245b.getPageContext().getPageActivity()).inflate(R.layout.category_card_list_layout, (ViewGroup) null);
        this.f64246c = inflate;
        this.f64245b.setContentView(inflate);
        this.f64252i = this.f64246c.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f64246c.findViewById(R.id.view_navigation_bar);
        this.f64247d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64247d.setTitleText(R.string.personal_card);
        this.f64248e = (NoNetworkView) this.f64246c.findViewById(R.id.view_no_network);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f64246c.findViewById(R.id.categary_card_recommend);
        this.f64249f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.f64245b.getActivity());
        this.j = textView;
        textView.setHeight(l.g(this.f64245b.getActivity(), R.dimen.ds104));
        this.f64250g = (BdListView) this.f64246c.findViewById(R.id.categary_card_listview);
        b bVar = new b(this.f64245b.getPageContext());
        this.f64251h = bVar;
        this.f64250g.setAdapter((ListAdapter) bVar);
    }

    public final List<Object> a(List<a> list) {
        InterceptResult invokeL;
        int size;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (a aVar : list) {
                ArrayList<d.a.s0.n3.a> a2 = aVar.a();
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
                            i2 = this.f64244a;
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
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f64245b.hideNetRefreshView(this.f64246c);
            this.f64252i.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64246c : (View) invokeV.objValue;
    }

    public void d() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f64245b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.f64245b.getLayoutMode().j(this.f64246c);
            NavigationBar navigationBar = this.f64247d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f64245b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.f64248e;
            if (noNetworkView != null) {
                noNetworkView.c(this.f64245b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f64250g;
            if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f64251h) != null) {
                bVar.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f64249f;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f64249f.d();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        }
    }

    public final void e(List<a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f64250g.setVisibility(0);
                this.f64251h.b(a(list));
                this.f64251h.notifyDataSetChanged();
                return;
            }
            this.f64250g.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f64249f.setVisibility(0);
                this.f64249f.e(eVar);
                return true;
            }
            this.f64249f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PersonalCardItemView.b bVar) {
        b bVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (bVar2 = this.f64251h) == null) {
            return;
        }
        bVar2.a(bVar);
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.f64250g.setOnSrollToBottomListener(pVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f64252i.setVisibility(8);
            String string = this.f64245b.getPageContext().getResources().getString(R.string.no_data_text);
            this.f64245b.setNetRefreshViewTopMargin(this.k);
            this.f64245b.showNetRefreshView(this.f64246c, string, false);
        }
    }

    public void j(int i2, e eVar, List<a> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), eVar, list, Boolean.valueOf(z)}) == null) {
            if ((eVar == null || StringUtils.isNull(eVar.c())) && (list == null || list.size() <= 0)) {
                i();
            } else if (i2 != 0) {
            } else {
                b();
                if (f(eVar)) {
                    this.f64250g.removeHeaderView(this.j);
                    this.f64250g.addHeaderView(this.j);
                } else {
                    this.f64250g.removeHeaderView(this.j);
                }
                e(list);
            }
        }
    }
}
