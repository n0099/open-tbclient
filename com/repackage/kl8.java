package com.repackage;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class kl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final al8 b;
    public wz5 c;
    public wz5 d;
    public wz5 e;
    public zz5 f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kl8 a;

        public a(kl8 kl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kl8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        str = "&skin=dart";
                    } else if (skinType == 1) {
                        str = "&skin=" + SkinManager.SKIN_TYPE_STR_NIGHT;
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/hybrid-main-service/virtualAvatar?customfullscreen=1&nonavigationbar=1" + str + "&from=2"});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }
    }

    public kl8(MainTabActivity mainTabActivity, al8 al8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, al8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = al8Var;
    }

    public void b() {
        wz5 wz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (wz5Var = this.e) != null && wz5Var.J()) {
            this.e.I();
        }
    }

    public void c() {
        wz5 wz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (wz5Var = this.d) != null && wz5Var.J()) {
            this.d.I();
            this.d = null;
        }
    }

    public void d() {
        wz5 wz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (wz5Var = this.c) != null && wz5Var.J()) {
            this.c.I();
            this.c = null;
        }
    }

    public void e() {
        al8 al8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (al8Var = this.b) == null || al8Var.B() == null) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        wz5 wz5Var = new wz5(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
        this.e = wz5Var;
        wz5Var.e0(R.drawable.obfuscated_res_0x7f0802e8);
        this.e.L(2);
        this.e.O(32);
        this.e.f0(true);
        this.e.i0(-pi.f(this.a, R.dimen.tbds10));
        this.e.X(R.color.CAM_X0101);
        this.e.P(R.dimen.tbds54);
        this.e.T(1);
        this.e.N(4000);
        this.e.a0(pi.f(this.a, R.dimen.tbds44));
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        wz5 wz5Var = new wz5(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
        this.c = wz5Var;
        wz5Var.e0(R.drawable.obfuscated_res_0x7f0802e8);
        this.c.L(2);
        this.c.O(32);
        this.c.f0(true);
        this.c.i0(-pi.f(this.a, R.dimen.tbds10));
        this.c.X(R.color.CAM_X0101);
        this.c.P(R.dimen.tbds54);
        this.c.T(999);
        this.c.N(5000);
        this.c.a0(pi.f(this.a, R.dimen.tbds44));
        this.c.m0(str, "categoryUpdate", false, true);
    }

    public void g() {
        al8 al8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (al8Var = this.b) == null || al8Var.B() == null) {
            return;
        }
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f13fc);
        FragmentTabWidget fragmentTabWidget = this.b.B().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 4) {
            return;
        }
        zz5 zz5Var = new zz5(this.a.getPageContext(), fragmentTabWidget.getChildAt(4));
        this.f = zz5Var;
        zz5Var.O(R.drawable.obfuscated_res_0x7f0802eb);
        this.f.F(2);
        this.f.I(48);
        this.f.P(true);
        this.f.Q(-pi.f(this.a, R.dimen.tbds62));
        this.f.M(R.color.CAM_X0101);
        this.f.N(R.dimen.T_X09);
        this.f.K(1);
        this.f.H(3000);
        this.f.G(new a(this));
        this.f.S(string, "setVirtualImage", true, false);
    }

    public void h() {
        wz5 wz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (wz5Var = this.e) == null || wz5Var.J()) {
            return;
        }
        wz5 wz5Var2 = this.e;
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f057b);
        wz5Var2.k0(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
    }
}
