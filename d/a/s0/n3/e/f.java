package d.a.s0.n3.e;

import android.annotation.SuppressLint;
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
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.BackgroundListActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f64159a;

    /* renamed from: b  reason: collision with root package name */
    public View f64160b;

    /* renamed from: c  reason: collision with root package name */
    public View f64161c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f64162d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f64163e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f64164f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.r0.r.f0.g f64165g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f64166h;

    /* renamed from: i  reason: collision with root package name */
    public e f64167i;
    public int j;

    public f(BackgroundListActivity backgroundListActivity, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundListActivity, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64165g = null;
        this.j = 0;
        this.f64159a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f64159a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f64160b = inflate;
        this.f64159a.setContentView(inflate);
        this.f64161c = this.f64160b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f64160b.findViewById(R.id.view_navigation_bar);
        this.f64162d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f64162d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f64160b.findViewById(R.id.view_member_recommend);
        this.f64163e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f64164f = (BdListView) this.f64160b.findViewById(R.id.listview_bg_list);
        d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(this.f64159a.getPageContext());
        this.f64165g = gVar;
        this.f64164f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f64159a.getActivity());
        this.f64166h = textView;
        textView.setHeight(l.g(this.f64159a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f64159a.getPageContext(), dVar);
        this.f64167i = eVar;
        this.f64164f.setAdapter((ListAdapter) eVar);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
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
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setBackgroundColor(this.f64160b, R.color.CAM_X0204);
            this.f64159a.hideNetRefreshView(this.f64160b);
            this.f64161c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f64160b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.r0.s0.a.a(this.f64159a.getPageContext(), this.f64160b);
            NavigationBar navigationBar = this.f64162d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f64159a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f64164f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f64167i) != null) {
                eVar.notifyDataSetChanged();
            }
            d.a.r0.r.f0.g gVar = this.f64165g;
            if (gVar != null) {
                gVar.I(TbadkApplication.getInst().getSkinType());
            }
            this.f64163e.d();
            SkinManager.setBackgroundColor(this.f64166h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f64164f.setVisibility(0);
                this.f64167i.b(list);
                this.f64167i.notifyDataSetChanged();
                return;
            }
            this.f64164f.setVisibility(8);
        }
    }

    public final boolean f(d.a.s0.n3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f64163e.setVisibility(0);
                this.f64163e.e(eVar);
                return true;
            }
            this.f64163e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f64164f.setOnSrollToBottomListener(pVar);
            this.f64165g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f64161c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f64160b, R.color.CAM_X0201);
            String string = this.f64159a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f64159a.setNetRefreshViewTopMargin(this.j);
            this.f64159a.showNetRefreshView(this.f64160b, string, false);
        }
    }

    public void i(d.a.s0.n3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f64164f.removeHeaderView(this.f64166h);
                    this.f64164f.addHeaderView(this.f64166h);
                } else {
                    this.f64164f.removeHeaderView(this.f64166h);
                }
                e(a(list));
                return;
            }
            h();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f64164f.A(0L);
        }
    }
}
