package com.repackage;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class x48 extends r48 implements ol7, o48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public t48 f;
    public r68 g;
    public PersonPolymericModel h;
    public s48 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<j18> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x48(BaseFragment baseFragment, t48 t48Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, t48Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = true;
        this.m = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.j = baseFragmentActivity;
        this.b = baseFragmentActivity.getPageContext();
        this.c = j;
        this.f = t48Var;
        this.e = bdUniqueId;
        this.k = t48Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        r68 r68Var = new r68(baseFragment, t48Var, bdUniqueId, z, this.c);
        this.g = r68Var;
        r68Var.W(this);
        g();
        this.h = this.f.r();
        this.i = this.f.l();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new j18());
        this.n.add(new j18());
    }

    @Override // com.repackage.ol7
    public void a() {
        t48 t48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (t48Var = this.f) == null) {
            return;
        }
        t48Var.a();
    }

    @Override // com.repackage.o48
    public r68 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (r68) invokeV.objValue;
    }

    @Override // com.repackage.o48
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.o48
    public void e() {
        r68 r68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (r68Var = this.g) == null) {
            return;
        }
        r68Var.M();
    }

    @Override // com.repackage.o48
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.repackage.ol7
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.M();
            }
        }
    }

    public void j(rv8 rv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, rv8Var) == null) {
            this.g.X(rv8Var);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.m == i) {
            return;
        }
        r68 r68Var = this.g;
        if (r68Var != null) {
            r68Var.T(i);
        }
        this.m = i;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            r68 r68Var = this.g;
            if (r68Var != null) {
                r68Var.U();
            }
        }
    }

    @Override // com.repackage.ol7
    public void loadData() {
        t48 t48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (t48Var = this.f) == null) {
            return;
        }
        t48Var.loadData();
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z && this.d) {
            loadData();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(kg.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.j.finish();
        }
    }

    public void o(y48 y48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, y48Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (y48Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c2d), true);
                this.i.m();
                this.i.t(8);
                return;
            }
            this.i.o();
            if (y48Var.e() != null && ((y48Var.e().getHide_stat() == 1 && y48Var.e().getBlock_stat() == 1) || (y48Var.e().getHide_stat() == 1 && y48Var.e().getBlock_stat() == 2))) {
                this.i.v(this.a);
                this.i.t(8);
                return;
            }
            this.i.t(0);
            y48Var.b();
            z = (y48Var.f() == null || y48Var.f().size() < 20) ? false : false;
            if (y48Var.j() != null) {
                y48Var.j().getSex();
            }
            this.d = false;
            if (this.a && y48Var.j() != null) {
                y48Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                s35.d().i(y48Var.j());
            }
            j18 j18Var = this.n.get(0);
            j18Var.a(y48Var.f());
            j18Var.b(z);
            this.g.Z(y48Var, z, i(y48Var));
        }
    }
}
