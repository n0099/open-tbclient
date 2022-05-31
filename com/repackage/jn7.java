package com.repackage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.BaseInterestedForumFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionStyleAFragment;
import com.baidu.tieba.newinterest.fragment.InterestSelectionStyleBFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumFragment;
import com.baidu.tieba.newinterest.fragment.InterestedForumStyleAFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class jn7 implements View.OnClickListener, BaseInterestSelectionFragment.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragmentActivity a;
    public int b;
    public boolean c;
    public ArrayList<Integer> d;
    public String[] e;
    public View f;
    public View g;
    public TextView h;
    public NavigationBar i;
    public BaseInterestedForumFragment j;
    public BaseInterestSelectionFragment k;

    public jn7(BaseFragmentActivity baseFragmentActivity, int i, boolean z, ArrayList<Integer> arrayList, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, Integer.valueOf(i), Boolean.valueOf(z), arrayList, strArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseFragmentActivity;
        this.b = i;
        this.c = z;
        this.d = arrayList;
        this.e = strArr;
        f();
        g();
    }

    @Override // com.baidu.tieba.newinterest.fragment.BaseInterestSelectionFragment.a
    public void a(List<xm7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            if (UbsABTestHelper.isInterestGuideStyleAOrB()) {
                this.j = InterestedForumStyleAFragment.K0(this.b, this.e);
            } else {
                this.j = InterestedForumFragment.J0(this.b, this.e);
            }
            this.j.H0(list);
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906c5, this.j).addToBackStack(null).commitAllowingStateLoss();
            en7.a(b().getFragments().size() == 1 ? 1 : 2, 1, this.b, c(list), "");
        }
    }

    public final FragmentManager b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.getSupportFragmentManager() : (FragmentManager) invokeV.objValue;
    }

    public String c(List<xm7> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (xm7 xm7Var : list) {
                if (xm7Var != null) {
                    if (sb.length() > 0) {
                        sb.append("|");
                    }
                    sb.append(TextUtils.isEmpty(xm7Var.b()) ? xm7Var.f() : xm7Var.b());
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public View d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 1);
            TiebaStatic.log(statisticItem);
            MessageManager.getInstance().sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(this.a).createNormalCfg(0)));
        }
    }

    public final void f() {
        Fragment fragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d003d, (ViewGroup) null);
            this.f = inflate;
            this.i = (NavigationBar) inflate.findViewById(R.id.obfuscated_res_0x7f0914f2);
            if (UbsABTestHelper.isInterestGuideStyleB()) {
                wq4.d(this.i).f(R.color.CAM_X0206);
            }
            TextView addTextButton = this.i.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getString(R.string.obfuscated_res_0x7f0f11b2));
            this.h = addTextButton;
            addTextButton.setId(R.id.obfuscated_res_0x7f090436);
            if (!UbsABTestHelper.isInterestGuideStyleA() && !UbsABTestHelper.isInterestGuideStyleB()) {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0107);
            } else {
                SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0108);
            }
            this.g = this.i.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            if (this.c) {
                if (UbsABTestHelper.isInterestGuideStyleAOrB()) {
                    this.j = InterestedForumStyleAFragment.J0(this.b, this.c, this.e);
                } else {
                    this.j = InterestedForumFragment.I0(this.b, this.c, this.e);
                }
                List<xm7> j = j();
                if (j != null) {
                    this.j.H0(j);
                }
                fragment = this.j;
                this.g.setVisibility(4);
            } else {
                if (UbsABTestHelper.isInterestGuideStyleA()) {
                    this.k = InterestSelectionStyleAFragment.I0(this.b, this.e);
                } else if (UbsABTestHelper.isInterestGuideStyleB()) {
                    this.k = InterestSelectionStyleBFragment.I0(this.b, this.e);
                } else {
                    this.k = InterestSelectionFragment.I0(this.b, this.e);
                }
                fragment = this.k;
            }
            b().beginTransaction().add(R.id.obfuscated_res_0x7f0906c5, fragment).commitAllowingStateLoss();
            TiebaStatic.log(new StatisticItem("c13681"));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.setOnClickListener(this);
            this.g.setOnClickListener(this);
            BaseInterestSelectionFragment baseInterestSelectionFragment = this.k;
            if (baseInterestSelectionFragment != null) {
                baseInterestSelectionFragment.H0(this);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && b().getFragments().size() == 1) {
            en7.c(1, this.b);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0201);
        }
    }

    public final List<xm7> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ListUtils.isEmpty(this.d)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<Integer> it = this.d.iterator();
            while (it.hasNext()) {
                xm7 xm7Var = new xm7();
                xm7Var.k(it.next().intValue());
                arrayList.add(xm7Var);
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            if (view2 == this.g && this.a != null) {
                BaseInterestedForumFragment baseInterestedForumFragment = this.j;
                if (baseInterestedForumFragment != null && baseInterestedForumFragment.isVisible()) {
                    b().popBackStack();
                    en7.c(1, this.b);
                    return;
                }
                e();
            } else if (view2 == this.h) {
                e();
                en7.a(b().getFragments().size() != 1 ? 2 : 1, 2, this.b, "", "");
            }
        }
    }
}
