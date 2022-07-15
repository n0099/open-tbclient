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
public class d48 extends x38 implements zk7, u38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext b;
    public long c;
    public boolean d;
    public BdUniqueId e;
    public z38 f;
    public x58 g;
    public PersonPolymericModel h;
    public y38 i;
    public BaseFragmentActivity j;
    public View k;
    public PersonPostModel l;
    public int m;
    public List<u08> n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d48(BaseFragment baseFragment, z38 z38Var, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, z38Var, bdUniqueId, Long.valueOf(j), Boolean.valueOf(z)};
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
        this.f = z38Var;
        this.e = bdUniqueId;
        this.k = z38Var.e;
        this.l = new PersonPostModel(this.b, bdUniqueId, null, this.a, PersonPostModel.FROM_PERSON_POLYMERIC);
        x58 x58Var = new x58(baseFragment, z38Var, bdUniqueId, z, this.c);
        this.g = x58Var;
        x58Var.W(this);
        h();
        this.h = this.f.r();
        this.i = this.f.m();
        ArrayList arrayList = new ArrayList(2);
        this.n = arrayList;
        arrayList.add(new u08());
        this.n.add(new u08());
    }

    @Override // com.repackage.zk7
    public void a() {
        z38 z38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (z38Var = this.f) == null) {
            return;
        }
        z38Var.a();
    }

    @Override // com.repackage.zk7
    public void b() {
        z38 z38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (z38Var = this.f) == null) {
            return;
        }
        z38Var.b();
    }

    @Override // com.repackage.u38
    public x58 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.g : (x58) invokeV.objValue;
    }

    @Override // com.repackage.u38
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.repackage.u38
    public void f() {
        x58 x58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (x58Var = this.g) == null) {
            return;
        }
        x58Var.M();
    }

    @Override // com.repackage.u38
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // com.repackage.zk7
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.l.resetThreadPn();
            PersonPolymericModel personPolymericModel = this.h;
            if (personPolymericModel != null) {
                personPolymericModel.O();
            }
        }
    }

    public void k(yt8 yt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yt8Var) == null) {
            this.g.X(yt8Var);
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || this.m == i) {
            return;
        }
        x58 x58Var = this.g;
        if (x58Var != null) {
            x58Var.T(i);
        }
        this.m = i;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.e);
            x58 x58Var = this.g;
            if (x58Var != null) {
                x58Var.U();
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && z && this.d) {
            a();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && TbadkCoreApplication.isLogin() && !this.a && this.c == TbadkCoreApplication.getCurrentAccountId()) {
            this.a = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.b.getPageActivity()).createNormalConfig(ng.g(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.j.finish();
        }
    }

    public void p(e48 e48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, e48Var) == null) {
            this.g.N();
            this.j.hideLoadingView(this.k);
            boolean z = true;
            if (e48Var == null) {
                this.i.y(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0c2b), true);
                this.i.n();
                this.i.t(8);
                return;
            }
            this.i.p();
            if (e48Var.e() != null && ((e48Var.e().getHide_stat() == 1 && e48Var.e().getBlock_stat() == 1) || (e48Var.e().getHide_stat() == 1 && e48Var.e().getBlock_stat() == 2))) {
                this.i.v(this.a);
                this.i.t(8);
                return;
            }
            this.i.t(0);
            e48Var.b();
            z = (e48Var.f() == null || e48Var.f().size() < 20) ? false : false;
            if (e48Var.j() != null) {
                e48Var.j().getSex();
            }
            this.d = false;
            if (this.a && e48Var.j() != null) {
                e48Var.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                f45.d().i(e48Var.j());
            }
            u08 u08Var = this.n.get(0);
            u08Var.a(e48Var.f());
            u08Var.b(z);
            this.g.Z(e48Var, z, j(e48Var));
        }
    }
}
