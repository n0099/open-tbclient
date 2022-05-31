package com.repackage;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.avatarPendant.AvatarPendantActivity;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class lm8 extends z8<AvatarPendantActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mm8 a;
    public BdListView b;
    public NoNetworkView c;
    public MemberRecommendView d;
    public NavigationBar e;
    public int f;
    public TextView g;
    public TextView h;
    public AvatarPendantActivity i;
    public View j;
    public TextView k;

    /* loaded from: classes6.dex */
    public interface a {
        void onItemClick(DressItemData dressItemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm8(AvatarPendantActivity avatarPendantActivity) {
        super(avatarPendantActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {avatarPendantActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 0;
        this.i = avatarPendantActivity;
        avatarPendantActivity.setContentView(R.layout.obfuscated_res_0x7f0d0124);
        this.j = avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f091adb);
        this.f = li.f(avatarPendantActivity.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702a1);
        this.b = (BdListView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0902eb);
        this.c = (NoNetworkView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0923a4);
        NavigationBar navigationBar = (NavigationBar) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0923a2);
        this.e = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.e.setTitleText(R.string.obfuscated_res_0x7f0f02bd);
        MemberRecommendView memberRecommendView = (MemberRecommendView) avatarPendantActivity.findViewById(R.id.obfuscated_res_0x7f0902ed);
        this.d = memberRecommendView;
        memberRecommendView.setFromType(8);
        this.d.getButton().setOnClickListener(avatarPendantActivity);
        TextView textView = new TextView(avatarPendantActivity.getActivity());
        this.g = textView;
        textView.setHeight(li.f(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f07019c));
        this.k = new TextView(avatarPendantActivity.getActivity());
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + li.f(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f070282));
        TextView textView2 = new TextView(avatarPendantActivity.getActivity());
        this.h = textView2;
        textView2.setHeight(li.f(avatarPendantActivity.getActivity(), R.dimen.obfuscated_res_0x7f0702d5));
        this.k.setLayoutParams(layoutParams);
        this.b.x(this.k, 0);
        this.b.addFooterView(this.h);
        mm8 mm8Var = new mm8(avatarPendantActivity);
        this.a = mm8Var;
        this.b.setAdapter((ListAdapter) mm8Var);
    }

    public void b(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.c.a(bVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.i.hideNetRefreshView(this.j);
            this.b.setVisibility(0);
        }
    }

    public MemberRecommendView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (MemberRecommendView) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public TextView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : (TextView) invokeV.objValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.a.notifyDataSetChanged();
            this.e.onChangeSkinType(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.c.c(this.i.getPageContext(), TbadkApplication.getInst().getSkinType());
            this.d.d();
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0201);
        }
    }

    public void k(List<jm8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list != null && list.size() > 0) {
                this.b.setVisibility(0);
                this.a.c(list);
                this.a.notifyDataSetChanged();
                return;
            }
            this.b.setVisibility(8);
        }
    }

    public final boolean l(ln8 ln8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ln8Var)) == null) {
            if (ln8Var != null && !StringUtils.isNull(ln8Var.c())) {
                this.d.setVisibility(0);
                this.d.e(ln8Var);
                return true;
            }
            this.d.setVisibility(8);
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            this.a.b(aVar);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setVisibility(8);
            String string = this.i.getPageContext().getResources().getString(R.string.obfuscated_res_0x7f0f0c4d);
            this.i.setNetRefreshViewTopMargin(this.f);
            this.i.showNetRefreshView(this.j, string, false);
        }
    }

    public void o(ln8 ln8Var, List<jm8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, ln8Var, list) == null) {
            if ((ln8Var != null && !StringUtils.isNull(ln8Var.c())) || (list != null && list.size() > 0)) {
                e();
                if (l(ln8Var)) {
                    this.b.removeHeaderView(this.g);
                    this.b.addHeaderView(this.g);
                } else {
                    this.b.removeHeaderView(this.g);
                }
                k(list);
                return;
            }
            n();
        }
    }
}
