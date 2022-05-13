package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dn8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final tm8 b;
    public oz5 c;
    public oz5 d;
    public oz5 e;
    public boolean f;
    public boolean g;

    public dn8(MainTabActivity mainTabActivity, tm8 tm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, tm8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = false;
        this.a = mainTabActivity;
        this.b = tm8Var;
    }

    public void a() {
        oz5 oz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (oz5Var = this.e) != null && oz5Var.J()) {
            this.e.I();
        }
    }

    public void b() {
        oz5 oz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (oz5Var = this.d) != null && oz5Var.J()) {
            this.d.I();
            this.d = null;
        }
    }

    public void c() {
        oz5 oz5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (oz5Var = this.c) != null && oz5Var.J()) {
            this.c.I();
            this.c = null;
        }
    }

    public void d() {
        tm8 tm8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tm8Var = this.b) == null || tm8Var.z() == null) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.z().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        oz5 oz5Var = new oz5(this.a.getPageContext(), fragmentTabWidget.getChildAt(1));
        this.e = oz5Var;
        oz5Var.g0(R.drawable.obfuscated_res_0x7f0802e9);
        this.e.L(2);
        this.e.O(32);
        this.e.h0(true);
        this.e.k0(-mi.f(this.a, R.dimen.tbds10));
        this.e.X(R.color.CAM_X0101);
        this.e.P(R.dimen.tbds54);
        this.e.T(1);
        this.e.N(4000);
        this.e.a0(mi.f(this.a, R.dimen.tbds44));
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.z().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        oz5 oz5Var = new oz5(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
        this.c = oz5Var;
        oz5Var.g0(R.drawable.obfuscated_res_0x7f0802e9);
        this.c.L(2);
        this.c.O(32);
        this.c.h0(true);
        this.c.k0(-mi.f(this.a, R.dimen.tbds10));
        this.c.X(R.color.CAM_X0101);
        this.c.P(R.dimen.tbds54);
        this.c.T(999);
        this.c.N(5000);
        this.c.a0(mi.f(this.a, R.dimen.tbds44));
        this.c.o0(str, "categoryUpdate", false, true);
    }

    public void f() {
        tm8 tm8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tm8Var = this.b) == null || tm8Var.z() == null) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.z().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 4) {
            return;
        }
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f0b34);
        oz5 oz5Var = new oz5(this.a.getPageContext(), fragmentTabWidget.getChildAt(4));
        this.d = oz5Var;
        oz5Var.g0(R.drawable.obfuscated_res_0x7f0802ec);
        this.d.L(2);
        this.d.O(48);
        this.d.h0(true);
        this.d.j0(-mi.f(this.a, R.dimen.tbds62));
        this.d.X(R.color.CAM_X0101);
        this.d.e0(R.dimen.T_X08);
        this.d.T(1);
        this.d.N(3000);
        this.d.d0(mi.f(this.a, R.dimen.tbds25));
        this.d.a0(mi.f(this.a, R.dimen.tbds33));
        this.d.b0(mi.f(this.a, R.dimen.tbds36));
        this.d.c0(mi.f(this.a, R.dimen.tbds36));
        this.d.o0(string, "mycreatecentertip", true, true);
    }

    public void g() {
        tm8 tm8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tm8Var = this.b) == null || tm8Var.z() == null) {
            return;
        }
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f13e9);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        FragmentTabWidget fragmentTabWidget = this.b.z().getFragmentTabWidget();
        if (fragmentTabWidget.getChildCount() < 2) {
            return;
        }
        oz5 oz5Var = new oz5(this.a.getPageContext(), fragmentTabWidget.getChildAt(2));
        this.c = oz5Var;
        oz5Var.g0(R.drawable.obfuscated_res_0x7f0802ed);
        this.c.L(2);
        this.c.O(32);
        this.c.h0(true);
        this.c.k0(-mi.f(this.a, R.dimen.tbds10));
        this.c.X(R.color.CAM_X0101);
        this.c.P(R.dimen.tbds109);
        this.c.T(1);
        this.c.N(3000);
        this.c.a0(mi.f(this.a, R.dimen.tbds44));
        this.c.o0(string, "videoChannelComming", true, false);
    }

    public void h() {
        oz5 oz5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (oz5Var = this.e) == null || oz5Var.J()) {
            return;
        }
        oz5 oz5Var2 = this.e;
        String string = this.a.getString(R.string.obfuscated_res_0x7f0f0576);
        oz5Var2.m0(string, "first_like_forum_enterforumtab_tips" + TbadkCoreApplication.getCurrentAccount());
    }
}
