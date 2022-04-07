package com.repackage;

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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public PersonalCardCategoryActivity b;
    public View c;
    public NavigationBar d;
    public NoNetworkView e;
    public MemberRecommendView f;
    public BdListView g;
    public yq8 h;
    public View i;
    public TextView j;
    public int k;

    public zq8(PersonalCardCategoryActivity personalCardCategoryActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalCardCategoryActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.k = 0;
        this.b = personalCardCategoryActivity;
        this.k = oi.f(personalCardCategoryActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07023f);
        View inflate = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01cf, (ViewGroup) null);
        this.c = inflate;
        this.b.setContentView(inflate);
        this.i = this.c.findViewById(R.id.obfuscated_res_0x7f09039d);
        NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0923ab);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f0e39);
        this.e = (NoNetworkView) this.c.findViewById(R.id.obfuscated_res_0x7f0923ad);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.c.findViewById(R.id.obfuscated_res_0x7f0905a8);
        this.f = memberRecommendView;
        memberRecommendView.setFromType(9);
        TextView textView = new TextView(this.b.getActivity());
        this.j = textView;
        textView.setHeight(oi.f(this.b.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        this.g = (BdListView) this.c.findViewById(R.id.obfuscated_res_0x7f0905a7);
        yq8 yq8Var = new yq8(this.b.getPageContext());
        this.h = yq8Var;
        this.g.setAdapter((ListAdapter) yq8Var);
    }

    public final List<Object> a(List<xq8> list) {
        InterceptResult invokeL;
        int size;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (xq8 xq8Var : list) {
                ArrayList<aq8> a = xq8Var.a();
                if (a != null && (size = a.size()) != 0) {
                    arrayList.add(xq8Var.b());
                    if (size > 6) {
                        size = 6;
                    }
                    int i2 = 0;
                    while (i2 < size) {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        while (true) {
                            i = this.a;
                            if (i3 < i) {
                                int i4 = i2 + i3;
                                if (i4 < size) {
                                    arrayList2.add(a.get(i4));
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
        return (List) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.hideNetRefreshView(this.c);
            this.i.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public void d() {
        yq8 yq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
            this.b.getLayoutMode().j(this.c);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            NoNetworkView noNetworkView = this.e;
            if (noNetworkView != null) {
                noNetworkView.c(this.b.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.g;
            if (bdListView != null && bdListView.getVisibility() == 0 && (yq8Var = this.h) != null) {
                yq8Var.notifyDataSetChanged();
            }
            MemberRecommendView memberRecommendView = this.f;
            if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
                this.f.d();
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204);
        }
    }

    public final void e(List<xq8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.g.setVisibility(0);
                this.h.b(a(list));
                this.h.notifyDataSetChanged();
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final boolean f(fr8 fr8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, fr8Var)) == null) {
            if (fr8Var != null && !StringUtils.isNull(fr8Var.c())) {
                this.f.setVisibility(0);
                this.f.e(fr8Var);
                return true;
            }
            this.f.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(PersonalCardItemView.b bVar) {
        yq8 yq8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (yq8Var = this.h) == null) {
            return;
        }
        yq8Var.a(bVar);
    }

    public void h(BdListView.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pVar) == null) {
            this.g.setOnSrollToBottomListener(pVar);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.i.setVisibility(8);
            String string = this.b.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c30);
            this.b.setNetRefreshViewTopMargin(this.k);
            this.b.showNetRefreshView(this.c, string, false);
        }
    }

    public void j(int i, fr8 fr8Var, List<xq8> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), fr8Var, list, Boolean.valueOf(z)}) == null) {
            if ((fr8Var == null || StringUtils.isNull(fr8Var.c())) && (list == null || list.size() <= 0)) {
                i();
            } else if (i != 0) {
            } else {
                b();
                if (f(fr8Var)) {
                    this.g.removeHeaderView(this.j);
                    this.g.addHeaderView(this.j);
                } else {
                    this.g.removeHeaderView(this.j);
                }
                e(list);
            }
        }
    }
}
