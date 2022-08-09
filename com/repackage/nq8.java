package com.repackage;

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
import com.repackage.av4;
import java.util.ArrayList;
import java.util.List;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class nq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BackgroundListActivity a;
    public View b;
    public View c;
    public NavigationBar d;
    public MemberRecommendView e;
    public BdListView f;
    public bv4 g;
    public TextView h;
    public mq8 i;
    public int j;

    public nq8(BackgroundListActivity backgroundListActivity, lq8 lq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {backgroundListActivity, lq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = null;
        this.j = 0;
        this.a = backgroundListActivity;
        this.j = qi.f(backgroundListActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07023c);
        View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d012b, (ViewGroup) null);
        this.b = inflate;
        this.a.setContentView(inflate);
        this.c = this.b.findViewById(R.id.obfuscated_res_0x7f0903ac);
        NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.obfuscated_res_0x7f09255b);
        this.d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.d.setTitleText(R.string.obfuscated_res_0x7f0f0e6e);
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.b.findViewById(R.id.obfuscated_res_0x7f09255a);
        this.e = memberRecommendView;
        memberRecommendView.setFromType(5);
        this.f = (BdListView) this.b.findViewById(R.id.obfuscated_res_0x7f091316);
        bv4 bv4Var = new bv4(this.a.getPageContext());
        this.g = bv4Var;
        this.f.setPullRefresh(bv4Var);
        TextView textView = new TextView(this.a.getActivity());
        this.h = textView;
        textView.setHeight(qi.f(this.a.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        mq8 mq8Var = new mq8(this.a.getPageContext(), lq8Var);
        this.i = mq8Var;
        this.f.setAdapter((ListAdapter) mq8Var);
    }

    public final List<List<DressItemData>> a(List<DressItemData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i = i + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < 3; i2++) {
                    int i3 = i + i2;
                    if (i3 < size) {
                        arrayList2.add(list.get(i3));
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
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0204);
            this.a.hideNetRefreshView(this.b);
            this.c.setVisibility(0);
        }
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void d() {
        mq8 mq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            fb5.a(this.a.getPageContext(), this.b);
            NavigationBar navigationBar = this.d;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a.getPageContext(), TbadkApplication.getInst().getSkinType());
            }
            BdListView bdListView = this.f;
            if (bdListView != null && bdListView.getVisibility() == 0 && (mq8Var = this.i) != null) {
                mq8Var.notifyDataSetChanged();
            }
            bv4 bv4Var = this.g;
            if (bv4Var != null) {
                bv4Var.H(TbadkApplication.getInst().getSkinType());
            }
            this.e.d();
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        }
    }

    public final void e(List<List<DressItemData>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.f.setVisibility(0);
                this.i.b(list);
                this.i.notifyDataSetChanged();
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public final boolean f(gr8 gr8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gr8Var)) == null) {
            if (gr8Var != null && !StringUtils.isNull(gr8Var.c())) {
                this.e.setVisibility(0);
                this.e.e(gr8Var);
                return true;
            }
            this.e.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(BdListView.p pVar, av4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, pVar, gVar) == null) {
            this.f.setOnSrollToBottomListener(pVar);
            this.g.f(gVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.setVisibility(8);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0201);
            String string = this.a.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c56);
            this.a.setNetRefreshViewTopMargin(this.j);
            this.a.showNetRefreshView(this.b, string, false);
        }
    }

    public void i(gr8 gr8Var, List<DressItemData> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, gr8Var, list, z) == null) {
            if (list != null && list.size() > 0) {
                b();
                if (f(gr8Var)) {
                    this.f.removeHeaderView(this.h);
                    this.f.addHeaderView(this.h);
                } else {
                    this.f.removeHeaderView(this.h);
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
            this.f.A(0L);
        }
    }
}
