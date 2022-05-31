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
/* loaded from: classes5.dex */
public class e28 extends y18 implements wi7, v18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public a28 f;
    public y38 g;
    public PersonPolymericModel h;
    public z18 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<sy7> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e28(BaseFragment baseFragment, a28 a28Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, a28Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = a28Var;
        this.e = bdUniqueId;
        this.k = a28Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        y38 y38Var = new y38(baseFragment, a28Var, bdUniqueId, z, this.c);
        this.g = y38Var;
        y38Var.W(this);
        g();
        this.h = this.f.r();
        this.i = this.f.l();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new sy7());
        this.n.add(new sy7());
    }

    @Override // com.repackage.wi7
    public void a() {
        a28 a28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (a28Var = this.f) == null) {
            return;
        }
        a28Var.a();
    }

    @Override // com.repackage.v18
    public y38 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (y38) invokeV.objValue;
    }

    @Override // com.repackage.v18
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.v18
    public void e() {
        y38 y38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (y38Var = this.g) == null) {
            return;
        }
        y38Var.M();
    }

    @Override // com.repackage.v18
    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.repackage.wi7
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

    public void j(ts8 ts8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ts8Var) == null) {
            this.g.X(ts8Var);
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || this.m == i) {
            return;
        }
        y38 y38Var = this.g;
        if (y38Var != null) {
            y38Var.T(i);
        }
        this.m = i;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            y38 y38Var = this.g;
            if (y38Var != null) {
                y38Var.U();
            }
        }
    }

    @Override // com.repackage.wi7
    public void loadData() {
        a28 a28Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (a28Var = this.f) == null) {
            return;
        }
        a28Var.loadData();
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(jg.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.j.finish();
        }
    }

    public void o(f28 f28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, f28Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (f28Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c33), true);
                this.i.m();
                this.i.t(8);
                return;
            }
            this.i.o();
            if (f28Var.e() != null && ((f28Var.e().getHide_stat() == 1 && f28Var.e().getBlock_stat() == 1) || (f28Var.e().getHide_stat() == 1 && f28Var.e().getBlock_stat() == 2))) {
                this.i.v(this.a);
                this.i.t(8);
                return;
            }
            this.i.t(0);
            f28Var.b();
            z = (f28Var.f() == null || f28Var.f().size() < 20) ? false : false;
            if (f28Var.j() != null) {
                f28Var.j().getSex();
            }
            this.d = false;
            if (this.a && f28Var.j() != null) {
                f28Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                o25.d().i(f28Var.j());
            }
            sy7 sy7Var = this.n.get(0);
            sy7Var.a(f28Var.f());
            sy7Var.b(z);
            this.g.Z(f28Var, z, i(f28Var));
        }
    }
}
