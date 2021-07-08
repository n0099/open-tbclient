package d.a.p0.n3.e;

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
import d.a.o0.r.f0.f;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BackgroundListActivity f60925a;

    /* renamed from: b  reason: collision with root package name */
    public View f60926b;

    /* renamed from: c  reason: collision with root package name */
    public View f60927c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60928d;

    /* renamed from: e  reason: collision with root package name */
    public MemberRecommendView f60929e;

    /* renamed from: f  reason: collision with root package name */
    public BdListView f60930f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r.f0.g f60931g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60932h;

    /* renamed from: i  reason: collision with root package name */
    public e f60933i;
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
        this.f60931g = null;
        this.j = 0;
        this.f60925a = backgroundListActivity;
        this.j = l.g(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60925a.getPageContext().getPageActivity()).inflate(R.layout.background_list, (ViewGroup) null);
        this.f60926b = inflate;
        this.f60925a.setContentView(inflate);
        this.f60927c = this.f60926b.findViewById(R.id.body_view);
        NavigationBar navigationBar = (NavigationBar) this.f60926b.findViewById(R.id.view_navigation_bar);
        this.f60928d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60928d.setTitleText(R.string.personal_background_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60926b.findViewById(R.id.view_member_recommend);
        this.f60929e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f60930f = (BdListView) this.f60926b.findViewById(R.id.listview_bg_list);
        d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(this.f60925a.getPageContext());
        this.f60931g = gVar;
        this.f60930f.setPullRefresh(gVar);
        TextView textView = new TextView(this.f60925a.getActivity());
        this.f60932h = textView;
        textView.setHeight(l.g(this.f60925a.getActivity(), R.dimen.ds104));
        e eVar = new e(this.f60925a.getPageContext(), dVar);
        this.f60933i = eVar;
        this.f60930f.setAdapter((ListAdapter) eVar);
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
            SkinManager.setBackgroundColor(this.f60926b, R.color.CAM_X0204);
            this.f60925a.hideNetRefreshView(this.f60926b);
            this.f60927c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60926b : (View) invokeV.objValue;
    }

    public void d() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.o0.s0.a.a(this.f60925a.getPageContext(), this.f60926b);
            NavigationBar navigationBar = this.f60928d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f60925a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f60930f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (eVar = this.f60933i) != null) {
                eVar.notifyDataSetChanged();
            }
            d.a.o0.r.f0.g gVar = this.f60931g;
            if (gVar != null) {
                gVar.I(TbadkApplication.getInst().getSkinType());
            }
            this.f60929e.d();
            SkinManager.setBackgroundColor(this.f60932h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f60930f.setVisibility(0);
                this.f60933i.b(list);
                this.f60933i.notifyDataSetChanged();
                return;
            }
            this.f60930f.setVisibility(8);
        }
    }

    public final boolean f(d.a.p0.n3.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f60929e.setVisibility(0);
                this.f60929e.e(eVar);
                return true;
            }
            this.f60929e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f60930f.setOnSrollToBottomListener(pVar);
            this.f60931g.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f60927c.setVisibility(8);
            SkinManager.setBackgroundColor(this.f60926b, R.color.CAM_X0201);
            String string = this.f60925a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f60925a.setNetRefreshViewTopMargin(this.j);
            this.f60925a.showNetRefreshView(this.f60926b, string, false);
        }
    }

    public void i(d.a.p0.n3.h.e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(eVar)) {
                    this.f60930f.removeHeaderView(this.f60932h);
                    this.f60930f.addHeaderView(this.f60932h);
                } else {
                    this.f60930f.removeHeaderView(this.f60932h);
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
            this.f60930f.A(0L);
        }
    }
}
