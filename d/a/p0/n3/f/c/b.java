package d.a.p0.n3.f.c;

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
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.themeCenter.bubble.list.BubbleListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.o0.r.f0.f;
import d.a.o0.r.f0.g;
import d.a.p0.n3.h.e;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BubbleListActivity f60990a;

    /* renamed from: b  reason: collision with root package name */
    public View f60991b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f60992c;

    /* renamed from: d  reason: collision with root package name */
    public MemberRecommendView f60993d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f60994e;

    /* renamed from: f  reason: collision with root package name */
    public g f60995f;

    /* renamed from: g  reason: collision with root package name */
    public a f60996g;

    /* renamed from: h  reason: collision with root package name */
    public int f60997h;

    public b(BubbleListActivity bubbleListActivity, d.a.p0.n3.f.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleListActivity, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60995f = null;
        this.f60997h = 0;
        this.f60990a = bubbleListActivity;
        this.f60997h = l.g(bubbleListActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60990a.getPageContext().getPageActivity()).inflate(R.layout.bubble_list, (ViewGroup) null);
        this.f60991b = inflate;
        this.f60990a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f60991b.findViewById(R.id.view_navigation_bar);
        this.f60992c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60992c.setTitleText(R.string.bubble_all);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60991b.findViewById(R.id.view_member_recommend);
        this.f60993d = memberRecommendView;
        memberRecommendView.setFromType(7);
        this.f60994e = (BdListView) this.f60991b.findViewById(R.id.listview_bubble);
        g gVar = new g(this.f60990a.getPageContext());
        this.f60995f = gVar;
        this.f60994e.setPullRefresh(gVar);
        TextView textView = new TextView(this.f60990a.getActivity());
        textView.setHeight(l.g(this.f60990a.getActivity(), R.dimen.ds20));
        this.f60994e.addFooterView(textView);
        a aVar2 = new a(this.f60990a.getPageContext(), aVar);
        this.f60996g = aVar2;
        this.f60994e.setAdapter((ListAdapter) aVar2);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 = i2 + 1 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < 2; i3++) {
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
            SkinManager.setBackgroundColor(this.f60991b, R.color.CAM_X0204);
            this.f60990a.hideNetRefreshView(this.f60991b);
            this.f60993d.setVisibility(0);
            this.f60994e.setVisibility(0);
            this.f60991b.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60991b : (View) invokeV.objValue;
    }

    public void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d.a.o0.s0.a.a(this.f60990a.getPageContext(), this.f60991b);
            NavigationBar navigationBar = this.f60992c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f60990a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f60994e;
            if (bdListView != null && bdListView.getVisibility() == 0 && (aVar = this.f60996g) != null) {
                aVar.notifyDataSetChanged();
            }
            g gVar = this.f60995f;
            if (gVar != null) {
                gVar.I(TbadkApplication.getInst().getSkinType());
            }
            this.f60993d.d();
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f60994e.setVisibility(0);
                this.f60996g.b(list);
                this.f60996g.notifyDataSetChanged();
                return;
            }
            this.f60994e.setVisibility(8);
        }
    }

    public final boolean f(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            if (eVar != null && !StringUtils.isNull(eVar.c())) {
                this.f60993d.setVisibility(0);
                this.f60993d.e(eVar);
                return true;
            }
            this.f60993d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f60994e.setOnSrollToBottomListener(pVar);
            this.f60995f.a(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f60993d.setVisibility(8);
            this.f60994e.setVisibility(8);
            this.f60991b.setVisibility(8);
            SkinManager.setBackgroundColor(this.f60991b, R.color.CAM_X0201);
            String string = this.f60990a.getPageContext().getResources().getString(R.string.no_data_text);
            this.f60990a.setNetRefreshViewTopMargin(this.f60997h);
            this.f60990a.showNetRefreshView(this.f60991b, string, false);
        }
    }

    public void i(e eVar, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, eVar, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                f(eVar);
                e(a(list));
                return;
            }
            h();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f60994e.A(0L);
        }
    }
}
